package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JpaManager {

    private static final String PERSISTENCE_UNIT_NAME = "persistence";

    public EntityManager getManager(){
        //Create new Entity Manager
        Map<String, String> env = System.getenv();
        Map<String, Object> configOverrides = new HashMap<String, Object>();
        for (String envName : env.keySet()) {
            if (envName.contains("MySQL_User")) {
                configOverrides.put("jakarta.persistence.jdbc.user", env.get(envName));
            }
            if (envName.contains("MySQL_Password")) {
                configOverrides.put("jakarta.persistence.jdbc.password", env.get(envName));
            }
        }
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME,configOverrides);
        return managerFactory.createEntityManager();
    }


}
