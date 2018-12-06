package module18.tests;

import com.google.common.collect.ImmutableList;
import io.restassured.response.Response;
import module18.Statuses.PetStatus;
import module18.endpoints.PetStorePetEndpoint;
import module18.models.Category;
import module18.models.Pet;
import module18.models.PetFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 11/26/2018
 */


public class SampleTestsPetStore {

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
    public void verifyStatusCode() {
        instance.getInstance()
                .getPetByStatus(PetStatus.AVAILABLE)
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyBody() {
        instance.getInstance()
                .getPetByStatus(PetStatus.AVAILABLE)
                .then()
                .assertThat()
                .body(is(not(isEmptyOrNullString())));
    }

    @Test
    public void verifyNotExistingPetReturn404() {
        instance.getInstance()
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
        cat.setStatus(PetStatus.AVAILABLE);

        instance.getInstance()
                .createPet(cat)
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyPetHasIdAfterCreation() {
        Pet barsik = Pet.createBarsik();

        Response petResponse = instance.getInstance()
                .createPet(barsik);

        Pet petFromService = petResponse.body().as(Pet.class);
        Assert.assertNotNull(petFromService.getId());
    }
}
