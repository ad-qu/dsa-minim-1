package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.Partida;
import edu.upc.eetac.dsa.models.Usuario;

import java.util.HashMap;
import java.util.List;

public interface Manager {
    //persona
    Usuario addUsuario(Usuario usuario);

    //Get muestras partidas
    List<Partida> getMuestrasPartidas(String idUsuario);

    void tearDown();
}
