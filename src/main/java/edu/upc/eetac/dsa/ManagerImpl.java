package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.Usuario;
import edu.upc.eetac.dsa.models.Partida;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class ManagerImpl implements Manager{

    private static Logger logger = Logger.getLogger(ManagerImpl.class);

    //singleton
    private static Manager instance;

    private ManagerImpl(){
        //new data
    }

    public static Manager getInstance(){
        if(instance==null) instance = new ManagerImpl(); return instance;
    }

    @Override
    public Usuario addUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Partida> getMuestrasPartidas(String idUsuario) {
        return null;
    }

    @Override
    public void tearDown() {
        //this.mapUsuarios.clear();
        //...
    }
}
