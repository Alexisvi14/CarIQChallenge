import io.restassured.response.Response;
import model.Pet;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiService;
import utils.LocalData;

import java.io.IOException;

public class PetTests {
    @Test
    public void postNewPet() throws IOException {
        Response response = ApiService.postPet();
        Assert.assertEquals(response.statusCode(),201, "The status code was not the expected one");
        Assert.assertEquals(LocalData.localData.getPetResponse().getId(),1414, "Incorrect ID");
        Assert.assertEquals(LocalData.localData.getPetResponse().getStatus(), "sold", "Pet status is wrong");
    }

    @Test
    public void getPetByStatus(){
        Response response = ApiService.getPetByStatus();
        Assert.assertEquals(response.statusCode(),200, "The status code was not the expected one");
        for (Pet pet : LocalData.localData.getPetResponses()) {
            if (pet.getName().equalsIgnoreCase("Almendra")){
                Assert.assertEquals(pet.getCategory().getName(), "Dog");
                Assert.assertFalse(pet.getTags().isEmpty());
            } else {
                Assert.assertEquals(pet.getCategory().getName(), "Cat");
                Assert.assertEquals(pet.getId(), 12345);
            }
        }
    }

    @Test
    public void putPet() throws IOException {
        Response response = ApiService.putPet();
        Assert.assertEquals(response.statusCode(),200, "The status code was not the expected one");
        Assert.assertEquals(LocalData.localData.getPetResponse().getName(), "Minnie", "The name is incorrect");
    }
}
