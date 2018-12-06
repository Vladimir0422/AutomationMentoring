package module18.tests;

import io.restassured.response.Response;
import module18.Statuses.PetStatus;
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

    public static final PetStorePetEndpoint instance = new PetStorePetEndpoint();

    @BeforeClass
    public static void cleanup() {
        instance.getInstance().getPetByStatus(PetStatus.AVAILABLE)
                .body()
                .jsonPath()
                .getList("findAll {item -> item.name == 'BarsikSV5'}", Pet.class)
                .stream()
                .forEach(pet -> instance.getInstance().deletePetById(pet.getId()));
    }

    @Test
    public void createPet() {
        //Given
        Pet barsik = Pet.createBarsik();

        //When
        Response petResponse = instance.getInstance().createPet(barsik);

        //Then
        long createdPetId = petResponse.body().as(Pet.class).getId();
        Pet createdPetFromService = instance.getInstance().getPetById(String.valueOf(createdPetId)).as(Pet.class);

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(createdPetFromService.getName()).as("Name").isEqualTo(barsik.getName());
        assertions.assertThat(createdPetFromService.getStatus()).as("Name").isEqualTo(barsik.getStatus());
        assertions.assertAll();
    }

    @Test
    public void readPet() {
        //Given
        Pet barsik = Pet.createBarsik();
        Response petResponse = instance.getInstance().createPet(barsik);
        long createdPetId = petResponse.body().as(Pet.class).getId();

        //When
        Pet createdPetFromService = instance.getInstance().getPetById(String.valueOf(createdPetId)).as(Pet.class);

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
        instance.getInstance().createPet(barsik);
        barsik.setStatus(PetStatus.SOLD);

        //When
        Pet createdPetFromService = instance.getInstance().updatePet(barsik).as(Pet.class);

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
        instance.getInstance().createPet(barsik);
        Pet createdPetFromService = instance.getInstance().updatePet(barsik).as(Pet.class);

        //When
        instance.getInstance().deletePetById(barsik.getId());
        //Then
        Response petById = instance.getInstance().getPetById(String.valueOf(createdPetFromService.getId()));
        Assertions.assertThat(petById.getStatusCode()).isEqualTo(404);
    }
}
