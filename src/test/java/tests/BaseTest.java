package tests;

import jakarta.persistence.EntityManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.JpaManager;

public class BaseTest {

    EntityManager manager;

    @BeforeMethod
    public void setUp()
    {
        manager = new JpaManager().getManager();
    }

    @AfterMethod
    public void tearDown()
    {
        manager.close();
    }
}
