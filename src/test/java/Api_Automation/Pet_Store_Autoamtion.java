package Api_Automation;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Pet_Store_Autoamtion {

    @Test
    public void CreateUser(){

        Response res =
                given()
                        .header("accept", "application/json")
                        .header("Content-Type", "application/json")
                        .body("{\n" +
                                "  \"id\": 0,\n" +
                                "  \"username\": \"vaibhav\",\n" +
                                "  \"firstName\": \"vaibhav\",\n" +
                                "  \"lastName\": \"string\",\n" +
                                "  \"email\": \"string\",\n" +
                                "  \"password\": \"vaibhav\",\n" +
                                "  \"phone\": \"string\",\n" +
                                "  \"userStatus\": 0\n" +
                                "}")
                        .when()
                        .post("https://petstore.swagger.io/v2/user");
        res.prettyPrint();
        res.then().statusCode(200);
        Assert.assertEquals(res.statusCode(),200);
    }

    @Test
    public void getUser(){
        Response response =
                given()
                        .header("accept", "application/json")
                        .when()
                        .get("https://petstore.swagger.io/v2/user/vaibhav");
        response.prettyPrint();
//        response.then().statusCode(200);
    }

    @Test
    public void logIn(){
        Response response =
                given()
                        .header("accept", "application/json")
                        .when()
                        .get("https://petstore.swagger.io/v2/user/login?username=vaibhav&password=vaibhav");
        response.prettyPrint();
    }

    @Test
    public void logOut(){

        Response response=
                given()
                        .header("accept", "application/json")
                        .when()
                        .get("https://petstore.swagger.io/v2/user/logout");
        response.prettyPrint();
    }

    @Test
    public void createListofUser(){

        Response response = given()
                .header("accept","application/json")
                .header("Content-Type", "application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"username\": \"ram\",\n" +
                        "    \"firstName\": \"string\",\n" +
                        "    \"lastName\": \"string\",\n" +
                        "    \"email\": \"string\",\n" +
                        "    \"password\": \"ram\",\n" +
                        "    \"phone\": \"string\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 2,\n" +
                        "    \"username\": \"joy\",\n" +
                        "    \"firstName\": \"string\",\n" +
                        "    \"lastName\": \"string\",\n" +
                        "    \"email\": \"string\",\n" +
                        "    \"password\": \"joy\",\n" +
                        "    \"phone\": \"string\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithArray");
        response.prettyPrint();
    }

    @Test
    public void updateUser(){
        Response response =
                given()
                        .header("accept", "application/json")
                        .header("Content-Type", "application/json")
                        .body("{\n" +
                                "  \"id\": 0,\n" +
                                "  \"username\": \"vaibhav\",\n" +
                                "  \"firstName\": \"Vaibhav\",\n" +
                                "  \"lastName\": \"Kumbhar\",\n" +
                                "  \"email\": \"string\",\n" +
                                "  \"password\": \"vaibhav\",\n" +
                                "  \"phone\": \"string\",\n" +
                                "  \"userStatus\": 0\n" +
                                "}")
                        .when()
                        .put("https://petstore.swagger.io/v2/user/vaibhav");
        response.prettyPrint();
    }

    @Test
    public void deleteUser(){
        Response response =
                given()
                        .header("accept", "application/json")
                        .when()
                        .delete("https://petstore.swagger.io/v2/user/vaibhav");
                    response.prettyPrint();
    }

    @Test
    public void placeOrder(){
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"petId\": 101,\n" +
                        "  \"quantity\": 1,\n" +
                        "  \"shipDate\": \"2024-05-29T01:04:56.887Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/store/order");
        response.prettyPrint();
    }

    @Test
    public void getOrder(){

        Response response = given()
                .header("accept", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/1");
        response.prettyPrint();
    }

    @Test
    public void getInventory(){
        Response response = given()
                .header("accept", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");
        response.prettyPrint();
    }

    @Test
    public void deleteOrder(){

        Response response = given()
                .header("accept", "application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/1");
        response.prettyPrint();

    }

    @Test
    public void addPet(){

        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"bunty\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
    }

    @Test
    public void getPet(){

        Response response = given()
                .header("accept", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/1");
        response.prettyPrint();
    }

    @Test
    public void updatePetData(){

        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .post("https://petstore.swagger.io/v2/pet/1");
        response.prettyPrint();
    }

    @Test
    public void findByStatus(){

        Response response =
                given()
                        .header("accept", "application/json")
                        .when()
                        .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        response.prettyPrint();

    }

    @Test
    public void updatePet(){

        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"Bunty\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 101,\n" +
                        "      \"name\": \"EnglishBerry\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
    }

    @Test
    public void deletePet(){

        Response response = given()
                .header("accept", "application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/2");
        response.prettyPrint();
    }

    @Test
    public void uploadImage(){
            File file = new File("C:\\Users\\vaibh\\Downloads\\dog.jpg");
        Response response = given()
                .header("accept", "application/json")
                .header("Content-type", "multipart/form-data")
                .multiPart(file)
                .when()
                .post("https://petstore.swagger.io/v2/pet/1/uploadImage");
        response.prettyPrint();

        response.then().statusCode(200);
    }
}
