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
        alkoObjectList.add(new AlkoObject("Example", "https://www.thecocktaildb.com/images/ingredients/vodka-Small.png", 12418,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null));
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
            @RequestParam(value = "strDrinkThumb") String strDrinkThumb, @RequestParam(value = "idDrink") int idDrink, @RequestParam(value = "strIngredient1") String strIngredient1, @RequestParam(value = "strIngredient2") String strIngredient2
            , @RequestParam(value = "strIngredient3") String strIngredient3, @RequestParam(value = "strIngredient4") String strIngredient4, @RequestParam(value = "strIngredient5") String strIngredient5, @RequestParam(value = "strIngredient6") String strIngredient6
            , @RequestParam(value = "strIngredient7") String strIngredient7, @RequestParam(value = "strIngredient8") String strIngredient8, @RequestParam(value = "strIngredient9") String strIngredient9
            , @RequestParam(value = "strIngredient10") String strIngredient10, @RequestParam(value = "strIngredient11") String strIngredient11, @RequestParam(value = "strIngredient12") String strIngredient12, @RequestParam(value = "strIngredient13") String strIngredient13
            , @RequestParam(value = "strIngredient14") String strIngredient14, @RequestParam(value = "strIngredient15") String strIngredient15, @RequestParam(value = "strMeasure1") String strMeasure1, @RequestParam(value = "strMeasure2") String strMeasure2
            , @RequestParam(value = "strMeasure3") String strMeasure3, @RequestParam(value = "strMeasure4") String strMeasure4, @RequestParam(value = "strMeasure5") String strMeasure5, @RequestParam(value = "strMeasure6") String strMeasure6
            , @RequestParam(value = "strMeasure7") String strMeasure7, @RequestParam(value = "strMeasure8") String strMeasure8, @RequestParam(value = "strMeasure9") String strMeasure9, @RequestParam(value = "strMeasure10") String strMeasure10
            , @RequestParam(value = "strMeasure1") String strMeasure11, @RequestParam(value = "strMeasure12") String strMeasure12, @RequestParam(value = "strMeasure13") String strMeasure13, @RequestParam(value = "strMeasure14") String strMeasure14
            , @RequestParam(value = "strMeasure15") String strMeasure15) {
        alkoObjectList.add(new AlkoObject(strDrink, strDrinkThumb, idDrink, strIngredient1, strIngredient2, strIngredient3,
        strIngredient4, strIngredient5, strIngredient6, strIngredient7, strIngredient8, strIngredient9, strIngredient10,
        strIngredient11, strIngredient12, strIngredient13, strIngredient14, strIngredient15, strMeasure1, strMeasure2,
        strMeasure3, strMeasure4, strMeasure5, strMeasure6, strMeasure7, strMeasure8, strMeasure9,
        strMeasure10, strMeasure11, strMeasure12, strMeasure13, strMeasure14, strMeasure15));
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