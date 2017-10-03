package emr.common.config;

import emr.common.models.config.Target;

import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;

import emr.common.enums.Environment;

public class InstanceConfig {
    
    public static String getClient() {

        XMLConfiguration config = getConfig();
        
        return config.getString("Config.Client[@name]");
    }
    
    public static ArrayList<Target> getTargets() {
        
        XMLConfiguration config = getConfig();
        ArrayList<Target> targets = new ArrayList<>();
        
        for (int i = 0; i <= config.getMaxIndex("Config.Target"); i++) {
            
           String element = String.format("Config.Target(%d)", i);
           
           Environment environment = getEnvironment(config.getString(element + "[env]").toUpperCase().trim());
           boolean isEnabled = config.getBoolean(element + "[active]");
           
           targets.add(new Target(environment, isEnabled));
        }
        
        return targets;
    }
   
    public static Environment getEnvironment() {

        XMLConfiguration config = getConfig();
        
        return getEnvironment(config.getString("Config.Client[@env]").toUpperCase().trim());
    }
    
    private static Environment getEnvironment(String environment) {
        
        switch (environment) {
            
            case "PROD" :
                return Environment.PROD;
            case "STAGE" :
                return Environment.STAGE;
            case "TEST" :
                return Environment.TEST;
            default :
                //  TODO: Throw error
        }
        
        return null;
    }
    
    private static XMLConfiguration getConfig() {
        
        XMLConfiguration config = new XMLConfiguration();
        
        try {

            config.read(new FileInputStream(new File("config.instance.xml")));
        }
        catch (IOException ex) {

            //  TODO: Write in error handling.
        }
        catch (ConfigurationException ex) {

            //  TODO: Write in error handling.
        }
        catch (Exception ex) {

            //  TODO: Write in error handling.
        }

        return config;
    }
}
