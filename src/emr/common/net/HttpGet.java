package emr.common.net;

import java.util.LinkedHashMap;

public interface HttpGet extends HttpCall {
    
    public void get(String url, HttpParams parameters, LinkedHashMap<String, String> headers);
}
