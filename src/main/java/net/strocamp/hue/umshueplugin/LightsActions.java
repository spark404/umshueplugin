package net.strocamp.hue.umshueplugin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.strocamp.hue.umshueplugin.model.Light;
import net.strocamp.hue.umshueplugin.model.State;

import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.reflect.TypeToken;

public class LightsActions extends Actions {
    private static final Logger LOGGER = LoggerFactory.getLogger(LightsActions.class);

    public LightsActions(URL hueUrl) {
        super(hueUrl);
    }

    public List<Light> getAll() throws HueApiException {
        GetMethod method = new GetMethod(hueUrl.toExternalForm() + "/lights");
        int responseCode;
        try {
            responseCode = client.executeMethod(method);

            if (responseCode >= 300) {
                throw new HueApiException("Api failure " + method.getStatusText());
            }
            Type returnType = new TypeToken<Map<String, Light>>() {
            }.getType();
            Map<String, Light> lightMap = gson.fromJson(method.getResponseBodyAsString(), returnType);
            method.releaseConnection();
            List<Light> lights = new ArrayList<Light>();
            for (Entry<String, Light> lightEntry : lightMap.entrySet()) {
                Light light = getLightById(lightEntry.getKey());
                lights.add(light);
            }
            return lights;
        } catch (IOException e) {
            throw new HueApiException("Failed to get configuration", e);
        }

    }

    public Light getLightById(String id) throws HueApiException {
        GetMethod method = new GetMethod(hueUrl.toExternalForm() + "/lights/" + id);
        int responseCode;
        try {
            responseCode = client.executeMethod(method);

            if (responseCode >= 300) {
                throw new HueApiException("Api failure " + method.getStatusText());
            }
            Light light = gson.fromJson(method.getResponseBodyAsString(), Light.class);
            method.releaseConnection();
            light.setId(id);
            return light;
        } catch (IOException e) {
            throw new HueApiException("Failed to get configuration", e);
        }
    }

    public void setState(String id, State state) throws HueApiException {
        PutMethod method = new PutMethod(hueUrl.toExternalForm() + "/lights/" + id + "/state");
        int responseCode;
        try {
            method.setRequestHeader(CONTENT_TYPE, JSON_CONTENT_TYPE);
            try {
                LOGGER.debug("Setting " + id + " state to " + gson.toJson(state));
                method.setRequestEntity(new StringRequestEntity(gson.toJson(state), JSON_CONTENT_TYPE, null));
            } catch (final UnsupportedEncodingException e) {
                throw new HueApiException("Failed to encode json request body", e);
            }
            responseCode = client.executeMethod(method);

            if (responseCode >= 300) {
                throw new HueApiException("Api failure " + method.getStatusText());
            }

            LOGGER.debug("response: " + method.getResponseBodyAsString());
            method.releaseConnection();
        } catch (IOException e) {
            throw new HueApiException("Failed to get configuration", e);
        }

    }

}
