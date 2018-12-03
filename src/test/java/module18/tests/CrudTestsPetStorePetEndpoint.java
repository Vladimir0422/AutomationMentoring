package module18.tests;

import io.restassured.response.Response;
import module18.endpoints.PetStorePetEndpoint;
import module18.models.Pet;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 11/25/2018
 */


public class CrudTestsPetStorePetEndpoint {

    public static final PetStorePetEndpoint PET_STORE_PET_ENDPOINT = new PetStorePetEndpoint();

    @BeforeClass
    public static void cleanup() {
        PET_STORE_PET_ENDPOINT.getPetByStatus("available")
                .body()
                .jsonPath()
                .getList("findAll {item -> item.name == 'BarsikSV5'}", Pet.class)
                .stream()
                .forEach(pet -> PET_STORE_PET_ENDPOINT.deletePetById(pet.getId()));
    }

    @Test
    public void createPet() {
        //Given
        Pet barsik = Pet.createBarsik();

        //When
        Response petResponse = PET_STORE_PET_ENDPOINT.createPet(barsik);

        //Then
        long createdPetId = petResponse.body().as(Pet.class).getId();
        Pet createdPetFromService = PET_STORE_PET_ENDPOINT.getPetById(String.valueOf(createdPetId)).as(Pet.class);

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(createdPetFromService.getName()).as("Name").isEqualTo(barsik.getName());
        assertions.assertThat(createdPetFromService.getStatus()).as("Name").isEqualTo(barsik.getStatus());
        assertions.assertAll();
    }

    @Test
    public void readPet() {
        //Given
        Pet barsik = Pet.createBarsik();
        Response petResponse = PET_STORE_PET_ENDPOINT.createPet(barsik);
        long createdPetId = petResponse.body().as(Pet.class).getId();

        //When
        Pet createdPetFromService = PET_STORE_PET_ENDPOINT.getPetById(String.valueOf(createdPetId)).as(Pet.class);

        //Then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(createdPetFromService.getName()).as("Name").isEqualTo(barsik.getName());
        assertions.assertThat(createdPetFromService.getStatus()).as("Name").isEqualTo(barsik.getStatus());
        assertions.assertAll();
    }

    @Test
    public void updatePet() {
        //Given
        Pet barsik = Pet.createBarsik();
        PET_STORE_PET_ENDPOINT.createPet(barsik);
        barsik.setStatus("sold");

        //When
        Pet createdPetFromService = PET_STORE_PET_ENDPOINT.updatePet(barsik).as(Pet.class);

        //Then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(createdPetFromService.getName()).as("Name").isEqualTo(barsik.getName());
        assertions.assertThat(createdPetFromService.getStatus()).as("Status").isEqualTo(barsik.getStatus());
        assertions.assertAll();
    }

    @Test
    public void deletePet() {
        //Given
        Pet barsik = Pet.createBarsik();
        PET_STORE_PET_ENDPOINT.createPet(barsik);
        Pet createdPetFromService = PET_STORE_PET_ENDPOINT.updatePet(barsik).as(Pet.class);

        //When
        PET_STORE_PET_ENDPOINT.deletePetById(barsik.getId());
        //Then
        Response petById = PET_STORE_PET_ENDPOINT.getPetById(String.valueOf(createdPetFromService.getId()));
        Assertions.assertThat(petById.getStatusCode()).isEqualTo(404);
    }
}
