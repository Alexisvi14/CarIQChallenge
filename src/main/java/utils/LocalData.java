package utils;

import model.Pet;

import java.util.List;

public class LocalData {
    public static LocalData localData = new LocalData();
    private Pet petResponse;
    private List<Pet> petResponses;

    public static LocalData getLocalData() {
        return localData;
    }

    public static void setLocalData(LocalData localData) {
        LocalData.localData = localData;
    }

    public Pet getPetResponse() {
        return petResponse;
    }

    public void setPetResponse(Pet petResponse) {
        this.petResponse = petResponse;
    }

    public List<Pet> getPetResponses() {
        return petResponses;
    }

    public void setPetResponses(List<Pet> petResponses) {
        this.petResponses = petResponses;
    }
}
