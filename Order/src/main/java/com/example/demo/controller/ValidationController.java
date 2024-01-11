package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/validation_schema")
public class ValidationController {

    @GetMapping
    public ResponseEntity<String> getValidationSchema(@PathVariable String roomType) {
        String validationSchema = getValidationSchemaByRoomType(roomType);

        if (validationSchema != null) {
            return ResponseEntity.ok(validationSchema);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String getValidationSchemaByRoomType(String roomType) {
        String res = "";
        res = "{" +
                "\"properties\": {" +
                "\"id\": {\"type\": \"integer\"}," +
                "\"title\": {\"type\": \"string\"}," +
                "\"description\": {\"type\": \"string\"}," +
                "\"typeconnection\": {\"type\": \"string\"}," +
                "\"Nameclient\": {\"type\": \"string\"}," +
                "\"requirement\": {\"type\": \"string\"}," +
                "\"price\": {\"type\": \"integer\"}" +
                "}," +
                "\"required\": [\"title\", \"description\", \"typeconnection\", \"NameClient\", \"requirement\", \"price\"]" +
                "}";
        return res;
    }
}
