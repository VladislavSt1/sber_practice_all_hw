package org.example;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class mapToProd {

    public static Animal mapToProductDto(Pet pet) throws Exception{
        Class<?> clazz = pet.getClass();

        Field fieldName = clazz.getDeclaredField("name");
        Field fieldStatus = clazz.getDeclaredField("status");
        Field fieldPhotosList = clazz.getDeclaredField("photosList");


        fieldName.setAccessible(true);
        fieldStatus.setAccessible(true);
        fieldPhotosList.setAccessible(true);


        String name = (String) fieldName.get(pet);
        Status status = (Status) fieldStatus.get(pet);
        List<Photo> photosList = (List<Photo>) fieldPhotosList.get(pet);

        Animal myPet = new Animal();

        Field fieldTitle = myPet.getClass().getDeclaredField("title");
        Field fieldIsAvailable = myPet.getClass().getDeclaredField("isAvailable");
        Field fieldIsSold = myPet.getClass().getDeclaredField("isSold");
        Field fieldPhotosMap = myPet.getClass().getDeclaredField("photosMap");

        fieldTitle.setAccessible(true);
        fieldIsAvailable.setAccessible(true);
        fieldIsSold.setAccessible(true);
        fieldPhotosMap.setAccessible(true);

        fieldTitle.set(myPet, name);
        fieldIsAvailable.setBoolean(myPet, status == Status.AVAILABLE);
        fieldIsSold.setBoolean(myPet, status == Status.SOLD);

        Map<String, String> photosMap = new HashMap<>();
        Iterator<Photo> photoIterator = photosList.iterator();
        while(photoIterator.hasNext()) {
            Photo photo = photoIterator.next();
            photosMap.put(photo.getName(), photo.getURL());
        }
        fieldPhotosMap.set(myPet, photosMap);

        return myPet;
    }
}
