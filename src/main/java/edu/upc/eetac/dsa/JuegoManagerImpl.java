package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.Objeto;
import edu.upc.eetac.dsa.models.Usuario;

import java.util.*;

import org.apache.log4j.Logger;

public class JuegoManagerImpl implements JuegoManager {

    private static Logger logger = Logger.getLogger(JuegoManagerImpl.class);

    private List<Objeto> TiendaDeObjetos;
    private HashMap<String, Usuario> mapUsuarios;

    private static JuegoManager instance;

    private JuegoManagerImpl() {

        this.mapUsuarios = new HashMap<>();
        this.TiendaDeObjetos = new ArrayList<>();
    }

    public static JuegoManager getInstance() {

        if (instance == null) instance = new JuegoManagerImpl();
        return instance;
    }

    //MÈTODES NO-ESTÀTICS

    @Override
    public void RegistrarUsuario(Usuario usuario) {

        logger.info("Comprobando...");

        boolean flag = mapUsuarios.containsValue(usuario); //Comprobamos si existe un usuario con dicho correo eletrónico.

        if (flag == false) {

            logger.info("Correo electrónico disponible, registrando usuario: " + usuario + ".");

            this.mapUsuarios.put(usuario.getCorreoElectronico(), usuario);
        } else {
            logger.info("Ya hay algún usuario con dicho correo eletrónico.");
        }
    }

    @Override
    public List<Usuario> getListaDeUsuarios() {

        return new LinkedList<>(this.mapUsuarios.values());
    }

    @Override
    public int IniciarSesion(String CorreoElectronico, String Password) {

            return 0;
    }

    @Override
    public void NuevoObjetoAlCatalogo(String Nombre, String Desc, int Precio) {

        Objeto objeto = new Objeto(Nombre, Desc, Precio);

        TiendaDeObjetos.add(objeto);
    }

    @Override
    public List<Objeto> getListaDeObjetos() {

        List<Objeto> resultado = new LinkedList<>(this.TiendaDeObjetos);

        Collections.sort(resultado, new Comparator<Objeto>() {

            @Override
            public int compare(Objeto p1, Objeto p2) {
                return Integer.compare(p1.getPrecio(), p2.getPrecio());
            }
        });

        return resultado; //Devuelve lista de objetos ordenada ascend.
    }


    @Override
    public int ComprarObjetoDeLaTienda(Objeto objeto, Usuario usuario) {

        return 0;
    }

    @Override
    public List<Objeto> getListaDeObjetosComprados(String CorreoElectronico) {
        return null;
    }

    @Override
    public void tearDown() {

        this.mapUsuarios.clear();
        this.TiendaDeObjetos.clear();
    }

    public Usuario getUsuarioPorCorreo(String CorreoElectronico) {

        return this.mapUsuarios.get(CorreoElectronico);
    }
}
