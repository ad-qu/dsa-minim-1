package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.utils.RandomUtils;

import java.util.List;
import java.util.LinkedList;

public class Usuario {

    String Nombre, Apellidos;
    String FechaDeNacimiento, CorreoElectronico;
    String Password;
    int Saldo;

    List<Objeto> ListaDeObjetosComprados;

    public Usuario() {}

    public Usuario(String Nombre, String Apellidos, String FechaDeNacimiento,
                   String CorreoElectronico, String Password){

        this.Nombre = Nombre; this.Apellidos = Apellidos;
        this.FechaDeNacimiento = FechaDeNacimiento;
        this.CorreoElectronico = CorreoElectronico; //Utilizaremos el correo eletrónico como ID ya que solo puede haber 1.
        this.Password = Password; this.Saldo = 50;

        this.ListaDeObjetosComprados = new LinkedList<>();
    }

    public void añadirObjetoAlInventario(String Nombre, String Desc, int Precio) {

        Objeto objeto = new Objeto(Nombre, Desc, Precio);

        ListaDeObjetosComprados.add(objeto);
    }

    public String getPassword() { return Password; }
    public String getCorreoElectronico() {
        return CorreoElectronico;
    }
}
