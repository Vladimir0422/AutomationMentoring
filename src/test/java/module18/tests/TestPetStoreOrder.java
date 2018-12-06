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
    public static final PetStorePetEndpoint instance = new PetStorePetEndpoint();
    ///Value for category
    private static long categoryId = 123123;
    private static String categoryName = "Cats";
    ///Value for pet
    private static long petID = 123125;
    private static String petName = "BarsikSV4";
    private static String photoUrl = "someUrl";
    ///Value for order
    private static long orderId = 5;
    private static int quantityForOrder = 11;


    @Before
    public void createAndPostPet() {

        Category category = new Category();
        category.setName(categoryName);
        category.setId(categoryId);

        Pet cat = new Pet();
        cat.setId(petID);
        cat.setName(petName);
        cat.setCategory(category);
        cat.setPhotoUrls(ImmutableList.of(photoUrl));
        cat.setStatus(PetStatus.AVAILABLE);

        instance.getInstance()
                .createPet(cat)
                .then()
                .statusCode(200);

        instance.getInstance()
                .createPetOrder(petID, orderId, quantityForOrder)
                .then()
                .statusCode(200);
    }

    @After
    public void cleanUp() {
        instance.getInstance().deletePetOrder(orderId)
                .then()
                .statusCode(200);

        instance.getInstance().deletePetById(petID)
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyOrder() {
        PetStoreOrder actualPetStoreOrder = instance.getInstance().getPetOrderByOrderId(orderId)
                .then()
                .statusCode(200)
                .and()
                .extract().response().body().as(PetStoreOrder.class, ObjectMapperType.JACKSON_2);

        Assert.assertNotNull(actualPetStoreOrder);
    }
}
