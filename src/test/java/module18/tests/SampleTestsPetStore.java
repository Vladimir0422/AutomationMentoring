package module18.tests;

import com.google.common.collect.ImmutableList;
import io.restassured.response.Response;
import module18.endpoints.PetStorePetEndpoint;
import module18.models.Category;
import module18.models.Pet;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 11/26/2018
 */


public class SampleTestsPetStore {

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
    public void verifyStatusCode() {
        PET_STORE_PET_ENDPOINT
                .getPetByStatus("available")
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyBody() {
        PET_STORE_PET_ENDPOINT
                .getPetByStatus("available")
                .then()
                .assertThat()
                .body(is(not(isEmptyOrNullString())));
    }

    @Test
    public void verifyNotExistingPetReturn404() {
        PET_STORE_PET_ENDPOINT
                .getPetById("123412423423")
                .then()
                .statusCode(404);
    }

    @Test
    public void verifyPetCanBeCreated() {
        Category category = new Category();
        category.setName("Cats");
        category.setId(123123);

        Pet cat = new Pet();
        cat.setId(807011);
        cat.setName("BarsikSV4");
        cat.setCategory(category);
        cat.setPhotoUrls(ImmutableList.of("someUrl"));
        cat.setStatus("available");

        PET_STORE_PET_ENDPOINT
                .createPet(cat)
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyPetHasIdAfterCreation() {
        Pet barsik = Pet.createBarsik();

        Response petResponse = PET_STORE_PET_ENDPOINT
                .createPet(barsik);

        Pet petFromService = petResponse.body().as(Pet.class);
        Assert.assertNotNull(petFromService.getId());
    }
}
