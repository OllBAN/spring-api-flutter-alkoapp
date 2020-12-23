package com.alkoapp.AlkoAppAPI.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import com.alkoapp.AlkoAppAPI.Model.AlkoObject;

@RestController
public class AlkoObjectController {

    private List<AlkoObject> alkoObjectList = new ArrayList<AlkoObject>();

    public AlkoObjectController() {
        alkoObjectList.add(new AlkoObject("TEST", "TEST", 0, false));
    }

    @GetMapping("/")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(alkoObjectList);
    }

    /// getObject?idDrink=1
    @GetMapping(value = "/getObject")
    public ResponseEntity<?> getAlkoObject(@RequestParam(value = "idDrink") int idDrink) {
        AlkoObject itemToReturn = null;
        for (AlkoObject obj : alkoObjectList) {
            if (obj.getIdDrink() == idDrink)
                itemToReturn = obj;
        }

        if (itemToReturn == null) {
            return ResponseEntity.ok("No AlkoObject found with id " + idDrink);
        } else {
            return ResponseEntity.ok(itemToReturn);
        }

    }

    // http://localhost:8080/addObject?strDrink=TEXT&strDrinkThumb=TEXT&idDrink=TEXT
    @RequestMapping(value = "/addObject")
    public ResponseEntity<?> addToAlkoObjectList(@RequestParam(value = "strDrink") String strDrink,
            @RequestParam(value = "strDrinkThumb") String strDrinkThumb, @RequestParam(value = "idDrink") int idDrink) {
        alkoObjectList.add(new AlkoObject(strDrink, strDrinkThumb, idDrink, false));
        System.out.println(alkoObjectList);
        return ResponseEntity.ok(alkoObjectList);
    }

    // @PutMapping(value = "/")
    // public ResponseEntity<?> updateAlkoObjectList(@RequestParam(value="strDrink")
    // String strDrink, @RequestParam(value="idDrink") String idDrink) {
    // alkoObjectList.forEach(alkoObjectList -> {
    // if(alkoObjectList.getIdDrink() == idDrink){
    // alkoObjectList.setStrDrink(strDrink);
    // }
    // });
    // return ResponseEntity.ok(alkoObjectList);
    // }

    // @DeleteMapping(value = "/")
    // public ResponseEntity<?> removeAlkoObjectList(@RequestParam(value="id")
    // String id) {
    // AlkoObject itemToRemove = null;
    // for(AlkoObject bucket : alkoObjectList){
    // if(bucket.getIdDrink() == id)
    // itemToRemove = bucket;
    // }

    // alkoObjectList.remove(itemToRemove);
    // return ResponseEntity.ok(alkoObjectList);
    // }
}