package emr.common.net;

import java.util.LinkedHashMap;

public interface HttpPut extends HttpCall {

    public void put(String url, HttpParams parameters, LinkedHashMap<String, String> headers, HttpBody body);
}
