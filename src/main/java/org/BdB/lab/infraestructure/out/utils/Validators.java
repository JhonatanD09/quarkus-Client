package org.BdB.lab.infraestructure.out.utils;


import org.BdB.lab.infraestructure.out.entity.EntityClient;

public class Validators {

    public static boolean isClientDocument(EntityClient client, int document){
        return client.getDocumentNumber() == document;
    }

    public static boolean isClientDocumentType(EntityClient client, char documentType){
        return Character.toUpperCase(client.getDocumentType()) == Character.toUpperCase(documentType);
    }
}
