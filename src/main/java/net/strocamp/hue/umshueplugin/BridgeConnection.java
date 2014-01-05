package net.strocamp.hue.umshueplugin;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BridgeConnection {
    private static final Logger LOGGER = LoggerFactory.getLogger(BridgeConnection.class);

    private URL apiUrl;

    /**
     * Create a new connection to a HUE bridge with an existing username
     * @param username
     */
    public BridgeConnection(String host, String username) {
        try {
            apiUrl = new URL("http", host, "/api/" + username);
        } catch (MalformedURLException e) {
            LOGGER.error("Unable to convert arguments to a URL", e);
            throw new InvalidParameterException("Host or username invalid");
        }

    }

    public ConfigurationActions getConfigurationActions() {
        return new ConfigurationActions(apiUrl);
    }

    public LightsActions getLightsActions() {
        return new LightsActions(apiUrl);
    }
}
