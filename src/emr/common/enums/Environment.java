package emr.common.enums;


public enum Environment {

    PROD(10),
    STAGE(20),
    TEST(30);
    
    private int value;
    
    Environment(int value) {
        
        this.value = value;
    }
    
    public int value() {
        
        return value;
    }
}
