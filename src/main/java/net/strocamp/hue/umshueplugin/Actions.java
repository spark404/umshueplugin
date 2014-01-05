package net.strocamp.hue.umshueplugin;

import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class Actions {
    private final static MultiThreadedHttpConnectionManager s_httpClientManager = new MultiThreadedHttpConnectionManager();

    protected static final String TEXT_HTML_CONTENT_TYPE = "text/html";
    protected static final String JSON_CONTENT_TYPE = "application/json";
    protected static final String CONTENT_TYPE = "Content-Type";

    protected final URL hueUrl;
    protected final HttpClient client;
    protected final Gson gson;

    public Actions(URL hueUrl) {
        this.hueUrl = hueUrl;
        client = new HttpClient(s_httpClientManager);
        gson = new GsonBuilder().create();
    }

}
