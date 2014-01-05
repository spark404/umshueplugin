package net.strocamp.hue.umshueplugin;

import java.io.IOException;
import java.net.URL;

import net.strocamp.hue.umshueplugin.model.Configuration;

import org.apache.commons.httpclient.methods.GetMethod;

public class ConfigurationActions extends Actions {


    public ConfigurationActions(URL hueUrl) {
        super(hueUrl);
    }

    public Configuration getConfiguration() throws HueApiException {
        GetMethod method = new GetMethod(hueUrl.toExternalForm() + "/config");
        int responseCode;
        try {
            responseCode = client.executeMethod(method);

            if (responseCode >= 300) {
                throw new HueApiException("Api failure " + method.getStatusText());
            }
            Configuration configuration = gson.fromJson(method.getResponseBodyAsString(), Configuration.class);
            method.releaseConnection();
            return configuration;
        } catch (IOException e) {
            throw new HueApiException("Failed to get configuration", e);
        }
    }

    public void updateConfiguration(Configuration configuration) {

    }
}
