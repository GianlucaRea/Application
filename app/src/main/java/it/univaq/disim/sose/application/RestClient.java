package it.univaq.disim.sose.application;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.client.params.ClientPNames;

public class RestClient {

    private static final String BASE_URL = "http://10.0.2.2:8080/AuthService/rest/User/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void post(String url, RequestParams params , AsyncHttpResponseHandler responseHandler){
        client.post(getAbsoluteUrl(url),params ,responseHandler);
    }

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.get(getAbsoluteUrl(url),params,responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl){return BASE_URL + relativeUrl;}
}
