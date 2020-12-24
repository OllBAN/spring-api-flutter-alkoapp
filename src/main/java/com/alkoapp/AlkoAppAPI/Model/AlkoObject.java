package com.alkoapp.AlkoAppAPI.Model;


public class AlkoObject {
    
    private String strDrink;
    private String strDrinkThumb;
    private int idDrink;
    
    public AlkoObject(String strDrink, String strDrinkThumb, int idDrink){
        this.strDrink= strDrink;
        this.strDrinkThumb = strDrinkThumb;
        this.idDrink = idDrink;
    }

    
    public String getStrDrink() {
        return strDrink;
    }
    
    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }
    
    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }
    
    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }
    
    public int getIdDrink() {
        return idDrink;
    }
    
    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
    }
    
    @Override
    public String toString() {
        return  "strDrink: " + strDrink + " strDrinkThumb: " + strDrinkThumb + " idDrink: " + idDrink;
    }
    
}