package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.junit.*;

import edu.upc.eetac.dsa.models.Usuario;

public class JuegoManagerTest {

    private JuegoManager manager;

    private static Logger logger = Logger.getLogger(JuegoManagerTest.class);

    @Before
    public void setUp() {

        this.manager = JuegoManagerImpl.getInstance();

        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    @After
    public void tearDown(){
        this.manager.tearDown();
    }

    @Test
    public void testRegistrarUsuario() {

        Usuario x = new Usuario("Adrián", "Quirós", "15-09-2000",
                "adrian.quiros@estudiantat.upc.edu", "12345");

        this.manager.RegistrarUsuario(x);

        Assert.assertEquals("adrian.quiros@estudiantat.upc.edu",
                manager.getUsuarioPorCorreo(x.getCorreoElectronico()).getCorreoElectronico());
    }

    @Test
    public void testRegistrarUsuarioRepetido() {

        Usuario x = new Usuario("Adrián", "Quirós", "15-09-2000",
                "adrian.quiros@estudiantat.upc.edu", "12345");

        this.manager.RegistrarUsuario(x);

        Usuario y = new Usuario("Adrián", "Quirós", "15-09-2000",
                "adrian.quiros@estudiantat.upc.edu", "12345");

        this.manager.RegistrarUsuario(y);

        Assert.assertEquals(manager.getUsuarioPorCorreo(x.getCorreoElectronico()),
                manager.getUsuarioPorCorreo(y.getCorreoElectronico()));
    }

    @Test
    public void testListaDeUsuarios() {

        Usuario x = new Usuario("Roberto", "Rangel", "15-09-2000",
                "roberto.rangel@estudiantat.upc.edu", "12345");

        this.manager.RegistrarUsuario(x);

        Usuario y = new Usuario("Adrián", "Quirós", "15-09-2000",
                "adrian.quiros@gmail.com", "12345");

        this.manager.RegistrarUsuario(y);

        this.manager.getListaDeUsuarios();
    }
}
