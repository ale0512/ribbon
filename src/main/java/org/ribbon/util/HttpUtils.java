package org.ribbon.util;


import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

/**
 * Created by admin on 2015/2/5.
 */
public class HttpUtils {

    public static int post(String url){
        HttpResponse response = HttpRequest
                .post("http://srv:8080/api/jsonws/user/get-user-by-id")
                .form("userId", "10194")
                .send();
        return 0;
    }
}
