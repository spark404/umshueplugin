package net.strocamp.hue.umshueplugin.model;

import java.util.Map;

public class Light {
    private transient String id;
    private String name;
    private String type;
    private String modelid;
    private String swversion;
    private Map<String, String> pointsymbol;
    private State state;

    public Light() {
        // TODO Auto-generated constructor stub
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModelid() {
        return modelid;
    }

    public void setModelid(String modelid) {
        this.modelid = modelid;
    }

    public String getSwversion() {
        return swversion;
    }

    public void setSwversion(String swversion) {
        this.swversion = swversion;
    }

    public Map<String, String> getPointsymbol() {
        return pointsymbol;
    }

    public void setPointsymbol(Map<String, String> pointsymbol) {
        this.pointsymbol = pointsymbol;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
