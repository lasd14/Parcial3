package com.example.parcial3.entidades;

public class RecetasFavoritas {

    private String producto;
    private String foto;
    private String preparacion;
    private String comentario;

    public RecetasFavoritas(String prod, String ft, String pre, String com) {
        producto = prod;
        foto = ft;
        preparacion = pre;
        comentario = com;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
