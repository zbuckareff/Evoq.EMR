package emr.common.net;

import java.util.LinkedHashMap;

public interface HttpPost extends HttpCall {

    public void post(String url, HttpParams parameters, LinkedHashMap<String, String> headers, HttpBody body);
}
