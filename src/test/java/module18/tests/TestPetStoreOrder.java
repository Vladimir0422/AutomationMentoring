package module18.tests;

import com.google.common.collect.ImmutableList;
import io.restassured.mapper.ObjectMapperType;
import module18.Statuses.PetStatus;
import module18.endpoints.PetStorePetEndpoint;
import module18.models.Category;
import module18.models.Pet;
import module18.models.PetStoreOrder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 12/2/2018
 */


public class TestPetStoreOrder {
    private static final PetStorePetEndpoint PET_STORE_PET_ENDPOINT = new PetStorePetEndpoint();
    private static long categoryId = 123123;
    private static String categoryName = "Cats";
    private static long petID = 123125;
    private static long orderId = 5;
    private static String petName = "BarsikSV4";

    @Before
    public void createAndPostPet() {

        Category category = new Category();
        category.setName(categoryName);
        category.setId(categoryId);

        Pet cat = new Pet();
        cat.setId(petID);
        cat.setName(petName);
        cat.setCategory(category);
        cat.setPhotoUrls(ImmutableList.of("someUrl"));
        cat.setStatus(PetStatus.AVAILABLE.status());

        PET_STORE_PET_ENDPOINT
                .createPet(cat)
                .then()
                .statusCode(200);

        PET_STORE_PET_ENDPOINT
                .createPetOrder(petID, orderId)
                .then()
                .statusCode(200);
    }

    @After
    public void cleanUp() {
        PET_STORE_PET_ENDPOINT.deletePetOrder(orderId)
                .then()
                .statusCode(200);

        PET_STORE_PET_ENDPOINT.deletePetById(petID)
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyOrder() {
        PetStoreOrder actualPetStoreOrder = PET_STORE_PET_ENDPOINT.getPetOrderByOrderId(orderId)
                .then()
                .statusCode(200)
                .and()
                .extract().response().body().as(PetStoreOrder.class, ObjectMapperType.JACKSON_2);

        Assert.assertNotNull(actualPetStoreOrder);
    }
}
