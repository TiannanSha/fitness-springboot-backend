package com.fitness.demo.eating.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value="/api/v1/eating")
public class EatingEntryController {

    @Autowired
    private EatingEntryService eatingEntryService;

    @PutMapping
    public ResponseEntity<EatingEntry> createNewEatingEntry(@RequestParam Map<String, String> params) {
        String foodType = params.get("foodType");
        double amountByGram = Double.parseDouble(params.get("amount"));
        String timestampStr = params.get("timestamp");
        EatingEntry eatingEntry = new EatingEntry(foodType, amountByGram, timestampStr);

        String userName = params.get("userName");
        EatingEntry eatingEntryAdded = eatingEntryService.addEatingEntry(eatingEntry, userName);
        if (eatingEntryAdded != null) {
            return new ResponseEntity<>(eatingEntryAdded, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
