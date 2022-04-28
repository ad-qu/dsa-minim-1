package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.junit.*;

//import edu.upc.eetac.dsa.models.Usuario;

public class TestManager {

    private Manager manager;

    private static Logger logger = Logger.getLogger(TestManager.class);

    @Before
    public void setUp() {

        this.manager = ManagerImpl.getInstance();

        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    @After
    public void tearDown(){
        this.manager.tearDown();
    }

    @Test
    public void testFirst() {

        /////////////////

        /* asserEquals(a, b); Para comparar */
    }
}
