package org.test.task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        CrptApi crptApi = new CrptApi(TimeUnit.SECONDS, 3);

        for (int i = 0; i < 5; i++) {
            CrptApi.Document document = createDocument();

            String signature = "signature";

            crptApi.createDocument(document, signature);
        }
    }

    private static CrptApi.Document createDocument() {
        CrptApi.Document document = new CrptApi.Document();
        document.setDoc_id("123");
        document.setDoc_status("pending");
        document.setDoc_type("LP_INTRODUCE_GOODS");
        document.setImportRequest(true);
        document.setOwner_inn("456");
        document.setParticipant_inn("789");
        document.setProducer_inn("101112");
        document.setProduction_date(LocalDate.now());
        document.setProduction_type("type1");
        document.setReg_date(LocalDate.now());
        document.setReg_number("001");

        CrptApi.Description description = new CrptApi.Description();
        description.setParticipantInn("999");
        document.setDescription(description);

        CrptApi.Product product = new CrptApi.Product();
        product.setCertificate_document("cert1");
        product.setCertificate_document_date(LocalDate.now());
        product.setCertificate_document_number("001");
        product.setOwner_inn("789");
        product.setProducer_inn("101112");
        product.setProduction_date(LocalDate.now());
        product.setTnved_code("123456");
        product.setUit_code("UIT-001");
        product.setUitu_code("UITU-001");

        List<CrptApi.Product> products = new ArrayList<>();
        products.add(product);
        document.setProducts(products);

        return document;
    }

}