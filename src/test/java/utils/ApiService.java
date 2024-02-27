package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Pet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ApiService {

    public static Response postPet() throws IOException {
        String body = Files.readString(Paths.get("/Users/alexisvillamayor/Solvd/Projects/CarIQChallenge/src/test/resources/postPets.json"));
//        body = body
//                .replace("nameToChange", name);
        Response response = (Response) RestAssured.given()
                .log()
                .all()
                .header("Content-Type","application/json")
                .body(body)
                .baseUri(Constants.baseUrl)
                .basePath(Constants.endpointPost)
                .post().then().extract();

        //printing response
        response.getBody().prettyPrint();
        //Set the response into a Pet object in LocalData class
        LocalData.localData.setPetResponse(new Gson().fromJson(response.asPrettyString(), Pet.class));
        return response;
    }

    public static Response getPetByStatus(){
        Response response = (Response) RestAssured.given()
                .log()
                .all()
                .header("Content-Type","application/json")
                .get(Constants.baseUrl + Constants.endpointGetByStatus)
                .then().extract();
        //saving response as a JSON
        String jsonResponse = response.getBody().asString();

        // Convert JSONs' list to Java objects
        Type listType = new TypeToken<List<Pet>>(){}.getType();
        List<Pet> pets = new Gson().fromJson(jsonResponse, listType);
        for (Pet pet : pets) {
            System.out.println(pet);
        }
        LocalData.localData.setPetResponses(pets);
        response.getBody().prettyPrint();
        return response;
    }

    public static Response putPet() throws IOException {
        String body = Files.readString(Paths.get("/Users/alexisvillamayor/Solvd/Projects/CarIQChallenge/src/test/resources/putPets.json"));

        Response response = (Response) RestAssured.given()
                .log()
                .all()
                .header("Content-Type","application/json")
                .body(body)
                .baseUri(Constants.baseUrl)
                .basePath(Constants.endpointPut)
                .put().then().extract();

        LocalData.localData.setPetResponse(new Gson().fromJson(response.asPrettyString(), Pet.class));
        response.getBody().prettyPrint();
        return response;
    }
}
