package com.alkoapp.AlkoAppAPI.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import com.alkoapp.AlkoAppAPI.Model.AlkoObject;

@RestController
public class AlkoObjectController {

    // https://secret-springs-79454.herokuapp.com/

    private List<AlkoObject> alkoObjectList = new ArrayList<AlkoObject>();

    public AlkoObjectController() {
        alkoObjectList.add(new AlkoObject("Example", "https://www.thecocktaildb.com/images/ingredients/vodka-Small.png", 12418));
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

    // /addObject?strDrink=TEXT&strDrinkThumb=TEXT&idDrink=TEXT
    @RequestMapping(value = "/addObject")
    public ResponseEntity<?> addToAlkoObjectList(@RequestParam(value = "strDrink") String strDrink,
            @RequestParam(value = "strDrinkThumb") String strDrinkThumb, @RequestParam(value = "idDrink") int idDrink) {
        alkoObjectList.add(new AlkoObject(strDrink, strDrinkThumb, idDrink));
        //System.out.println(alkoObjectList);
        return ResponseEntity.ok(alkoObjectList);
    }


    // /removeObject?idDrink=0
    @RequestMapping(value = "/removeObject", produces = "application/json", 
    method = {RequestMethod.GET, RequestMethod.PUT})
    public ResponseEntity<?> removeAlkoObjectList(@RequestParam(value = "idDrink") int idDrink) {
        AlkoObject itemToRemove = null;
        for (AlkoObject obj : alkoObjectList) {
            if (obj.getIdDrink() == idDrink)
                itemToRemove = obj;
        }

        alkoObjectList.remove(itemToRemove);
        return ResponseEntity.ok(alkoObjectList);
    }


}