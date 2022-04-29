package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.utils.RandomUtils;

public class Objeto {

    String id, Nombre, Desc;
    int Precio;

    public Objeto() {}

    public Objeto(String Nombre, String Desc, int Precio) {

        this.id = RandomUtils.getId(); //Asignamos una ID random al objeto para identificarlo.
        this.Nombre = Nombre;
        this.Desc = Desc;
        this.Precio = Precio;
    }

    public String getNombre() { return Nombre; }
    public int getPrecio() { return Precio; }
}
