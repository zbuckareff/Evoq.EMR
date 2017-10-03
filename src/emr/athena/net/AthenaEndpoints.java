package emr.athena.net;

import emr.common.enums.Environment;
import emr.common.config.InstanceConfig;

public class AthenaEndpoints {

    public enum Endpoint {

        PROD("https://api.athenahealth.com/v1/%d/"),
        PREVIEW("https://api.athenahealth.com/preview1/%d/");
        
        private String url;
        
        Endpoint(String url) {

            this.url = url;
        }
        
        public String url() {

            return url;
        }
    }
    
    public enum Patient {

        GET_CHANGED("patients/changed"),
        GET_CHANGED_SUB("patients/changed/subscription"),
        POST_CHANGED_SUB("patients/changed/subscription"),
        DELETE_CHANGED_SUB("patients/changed/subscription"),
        GET_PATIENT("patients/%d"),
        PUT_PATIENT("patients/%d");
        
        private String url;
        
        Patient(String url) {

            this.url = url;
        }
        
        public String url() {

            return url;
        }
        
        @Override
        public String toString() {
            
            return getEndpoint(InstanceConfig.getEnvironment()) + url;
        }
    }
    
    public enum Appointment {

        CHANGED_GET("http://");
        
        private String url;
        
        Appointment(String url) {

            this.url = url;
        }
        
        public String url() {

            return url;
        }
        
        @Override
        public String toString() {
            
            return getEndpoint(InstanceConfig.getEnvironment()) + url;
        }
    }
    
    public enum Chart {

        CHANGED_GET("http://");
        
        private String url;
        
        Chart(String url) {

            this.url = url;
        }
        
        public String url() {

            return url;
        }
        
        @Override
        public String toString() {
            
            return getEndpoint(InstanceConfig.getEnvironment()) + url;
        }
    }
    
    private static String getEndpoint(Environment environment) { 
        
        if (environment.value() == Environment.PROD.value()) {
            
            return Endpoint.PROD.url();
        }
        else if (environment.value() == Environment.STAGE.value() || environment.value() == Environment.TEST.value()) {
            
            return Endpoint.PREVIEW.url();
        }
        else {
            
            //  throw new RuntimeException("Missing valid Client Environment in Instance.xml");
            //  TODO: Write Error throw logic
        }
        
        return null;
    }
}
