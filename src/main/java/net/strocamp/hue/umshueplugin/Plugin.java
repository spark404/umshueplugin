package net.strocamp.hue.umshueplugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JComponent;

import net.pms.dlna.DLNAMediaInfo;
import net.pms.dlna.DLNAResource;
import net.pms.external.StartStopListener;
import net.strocamp.hue.umshueplugin.model.Light;
import net.strocamp.hue.umshueplugin.model.State;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Plugin implements StartStopListener
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Plugin.class);

    private BridgeConnection bridgeConnection;

    private final static String BRIDGE_HOST = "192.168.168.104";
    private final static String BRIDGE_USER = "23cd9c961ed81447206b44fa1cb695b";
    private final static String BRIDGE_DEVICE = "UmsHuePlugin";

    private Map<String, State> playingScene = new HashMap<String, State>();
    private Map<String, State> storedScene = new HashMap<String, State>();

    /** TODO Define a scene format
     * TODO Define a scene for Start and Stop
     * 
     */
    public Plugin() {
        bridgeConnection = new BridgeConnection(BRIDGE_HOST, BRIDGE_USER);
        try {
            LOGGER.info("UmsHuePLugin connected to " + bridgeConnection.getConfigurationActions().getConfiguration().getName());
        } catch (HueApiException e) {
            LOGGER.error("Failed to connect to bridge " + BRIDGE_HOST, e);
        }

        // Prepare videoScene, should be done via config
        playingScene.put("1", new State(174, 0.3764, 0.4537));
        playingScene.put("2", State.OFF);
        playingScene.put("3", new State(111, 0.2097, 0.6733));
        playingScene.put("4", State.OFF);
    }

    @Override
    public JComponent config() {
        // No configurable components yet
        return null;
    }

    @Override
    public String name() {
        return "UMS Hue Plugin";
    }

    @Override
    public void shutdown() {
        // TODO Auto-generated method stub
    }

    @Override
    public void nowPlaying(DLNAMediaInfo media, DLNAResource resource) {
        LOGGER.debug("Hue plugin start playing action start");
        LightsActions actions = bridgeConnection.getLightsActions();
        try {
            for (Light light : actions.getAll()) {
                if (playingScene.containsKey(light.getId())) {
                    storedScene.put(light.getId(), light.getState());
                    actions.setState(light.getId(), playingScene.get(light.getId()));
                }
            }
        } catch (HueApiException e) {
            LOGGER.error("Failed to change scene", e);
        }
        LOGGER.debug("Hue plugin start playing action complete");
    }

    @Override
    public void donePlaying(DLNAMediaInfo media, DLNAResource resource) {
        LOGGER.debug("hue plugin stop playing action start");
        LightsActions actions = bridgeConnection.getLightsActions();
        try {
            for (Entry<String, State> lightState : storedScene.entrySet()) {
                actions.setState(lightState.getKey(), lightState.getValue());
            }
        } catch (HueApiException e) {
            LOGGER.error("Failed to change scene", e);
        }
        LOGGER.debug("hue plugin stop playing action stop");

    }

}
