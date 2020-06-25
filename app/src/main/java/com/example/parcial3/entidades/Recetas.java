package com.example.parcial3.entidades;

public class Recetas {

    private String producto;
    private String foto;
    private String ingrediente1;
    private String ingrediente2;
    private String ingrediente3;
    private String ingrediente4;
    private String ingrediente5;
    private String preparacion;

    public Recetas(String prod, String ft, String ing1, String ing2, String ing3, String ing4, String ing5 , String pre) {
        producto = prod;
        foto = ft;
        ingrediente1 = ing1;
        ingrediente2 = ing2;
        ingrediente3 = ing3;
        ingrediente4 = ing4;
        ingrediente5 = ing5;
        preparacion = pre;
    }

    public String getProducto() {
        return producto;
    }

    public String getFoto() {
        return foto;
    }

    public String getIngrediente1() {
        return ingrediente1;
    }

    public String getIngrediente2() {
        return ingrediente2;
    }

    public String getIngrediente3() {
        return ingrediente3;
    }

    public String getIngrediente4() {
        return ingrediente4;
    }

    public String getIngrediente5() {
        return ingrediente5;
    }

    public String getPreparacion() {
        return preparacion;
    }
}
