package com.example.sqllite;

public class ModelRecord {

    String id, Pelicula, image, Director, Actor, Duracion, Precio, description;


    public ModelRecord() {

    }

    public ModelRecord(String id, String Pelicula,  String image, String Director, String Actor, String Duracion, String Precio, String description) {
        this.id = id;
        this.Pelicula = Pelicula;
        this.image = image;
        this.Director = Director;
        this.Actor = Actor;
        this.Duracion = Duracion;
        this.Precio = Precio;
        this.description = description;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPelicula() {
        return Pelicula;
    }

    public void setPelicula(String Pelicula) {
        this.Pelicula = Pelicula;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getActor() {
        return Actor;
    }

    public void setActor(String Actor) {
        this.Actor = Actor;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String Duracion) {
        this.Duracion = Duracion;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
