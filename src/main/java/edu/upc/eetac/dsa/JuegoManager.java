package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.Objeto;
import edu.upc.eetac.dsa.models.Usuario;

import java.util.List;

public interface JuegoManager {

    void RegistrarUsuario(Usuario usuario);

    List<Usuario> getListaDeUsuarios(); //De manera alfabética. Mostrar nombre y apellido en caso de tener el mismo nombre.

    int IniciarSesion(String CorreoElectronico, String Password);

    void NuevoObjetoAlCatalogo(String Nombre, String Desc, int Precio);

    List<Objeto> getListaDeObjetos(); //De manera descendente.

    int ComprarObjetoDeLaTienda(Objeto objeto, Usuario usuario);

    List<Objeto> getListaDeObjetosComprados(String CorreoElectronico);

    // Extra para JUNIT //

    Usuario getUsuarioPorCorreo(String CorreoElectronico);

    void tearDown();
}
