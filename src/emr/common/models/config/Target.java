package emr.common.models.config;

import emr.common.enums.Environment;

public class Target {

    private Environment environment;
    
    private boolean isEnabled;
    
    public Target(Environment environment, boolean isEnabled) {
        
        this.environment = environment;
        this.isEnabled = isEnabled;
    }
    
    public void setEnvironment(Environment environment) {
        
        this.environment = environment;
    }
    
    public Environment getEnvironment() {
        
        return environment;
    }
    
    public void setEnabledState(boolean isEnabled) {
        
        this.isEnabled = isEnabled;
    }
    
    public boolean getEnabledState() {
        
        return isEnabled;
    }
}
