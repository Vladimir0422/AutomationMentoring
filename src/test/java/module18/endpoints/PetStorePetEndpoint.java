package module18.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import module18.Statuses.OrderStatus;
import module18.models.Pet;
import module18.models.PetStoreOrder;

import java.time.LocalDateTime;

import static module18.config.Config.*;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 11/25/2018
 */


public class PetStorePetEndpoint {

    private PetStoreOrder petStoreOrder;

    public Response getPetById(String id) {
        return given()
                .pathParam("petId", id)
                .when()
                .get(PET_BY_ID)
                .then()
                .extract().response();
    }

    public Response getPetByStatus(String status) {
        return given()
                .queryParam("status", status)
                .when()
                .get(FIND_BY_STATUS)
                .then()
                .extract().response();
    }

    public Response createPet(Pet pet) {
        return given()
                .body(pet)
                .when()
                .post(CREATE_PET)
                .then()
                .extract().response();
    }

    public Response updatePet(Pet pet) {
        return given()
                .body(pet)
                .when()
                .put(CREATE_PET)
                .then()
                .extract().response();
    }

    public Response deletePetById(long id) {
        return given()
                .pathParam("petId", id)
                .when()
                .delete(PET_BY_ID)
                .then()
                .extract().response();
    }

    private RequestSpecification given() {
        return RestAssured.given()
                .log().uri()
                .log().body()
                .baseUri(PETS_STORE_BASE_URL)
                .contentType(ContentType.JSON);
    }

    ///Pet store order

    public Response createPetOrder(long petId, long orderId) {
        return given()
                .body(createOrder(petId, orderId))
                .contentType(ContentType.JSON)
                .when()
                .post(CREATE_PET_STORE_ORDER);
    }

    public Response deletePetOrder(long orderId) {
        return given()
                .baseUri(PETS_STORE_BASE_URL)
                .pathParam("orderId", orderId)
                .when()
                .delete(FIND_PET_STORE_ORDER_BY_ORDER_ID);
    }

    public Response getPetOrderByOrderId(long orderId) {
        return given()
                .pathParam("orderId" , orderId)
                .get(FIND_PET_STORE_ORDER_BY_ORDER_ID);
    }

    private PetStoreOrder createOrder(long petId, long orderId) {
        petStoreOrder = new PetStoreOrder();

        petStoreOrder.setId(orderId);
        petStoreOrder.setPetId(petId);
        petStoreOrder.setQuantity(11);
        petStoreOrder.setShipDate(LocalDateTime.now().plusDays(1));
        petStoreOrder.setStatus(OrderStatus.DELIVERED.orderStatus());
        petStoreOrder.setComplete(true);

        return petStoreOrder;
    }

    public PetStoreOrder getPetStoreObject() {
        return petStoreOrder;
    }
}
