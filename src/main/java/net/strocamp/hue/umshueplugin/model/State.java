package net.strocamp.hue.umshueplugin.model;

public class State {
    private Boolean on;
    private Integer bri;
    private Integer hue;
    private Integer sat;
    private Double[] xy;
    private Integer ct;
    private String alert;
    private String effect;
    private String colormode;
    private Boolean reachable;

    public State() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Convenience constructor, implicitly sets the light on and colormode xy
     * @param brightness
     * @param x
     * @param y
     */
    public State(int brightness, double x, double y) {
        on = true;
        colormode = "xy";
        bri = brightness;
        xy = new Double[] {x, y};
    }

    public State(boolean on) {
        this.on = on;
    }

    public Boolean getOn() {
        return on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }

    public Integer getBri() {
        return bri;
    }

    public void setBri(Integer bri) {
        this.bri = bri;
    }

    public Integer getHue() {
        return hue;
    }

    public void setHue(Integer hue) {
        this.hue = hue;
    }

    public Integer getSat() {
        return sat;
    }

    public void setSat(Integer sat) {
        this.sat = sat;
    }

    public Double[] getXy() {
        return xy;
    }

    public void setXy(Double[] xy) {
        this.xy = xy;
    }

    public Integer getCt() {
        return ct;
    }

    public void setCt(Integer ct) {
        this.ct = ct;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getColormode() {
        return colormode;
    }

    public void setColormode(String colormode) {
        this.colormode = colormode;
    }

    public Boolean getReachable() {
        return reachable;
    }

    public void setReachable(Boolean reachable) {
        this.reachable = reachable;
    }

    public static State ON = new State(true);

    public static State OFF = new State(false);

}
