package net.strocamp.hue.umshueplugin.model;

public class Configuration {
    private Integer proxyport;
    private String utc;
    private String name;
    //private Object swupdate;
    //private Object whitelist;
    private String swversion;
    private String proxyaddress;
    private String mac;
    private Boolean linkbutton;
    private String ipaddress;
    private String netmask;
    private String gateway;
    private Boolean dhcp;
    private Boolean portalservices;

    public Configuration() {
    }

    public Integer getProxyport() {
        return proxyport;
    }

    public void setProxyport(Integer proxyport) {
        this.proxyport = proxyport;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Object getSwupdate() {
//        return swupdate;
//    }

//    public void setSwupdate(Object swupdate) {
//        this.swupdate = swupdate;
//    }

//    public Object getWhitelist() {
//        return whitelist;
//    }

//    public void setWhitelist(Object whitelist) {
//        this.whitelist = whitelist;
//    }

    public String getSwversion() {
        return swversion;
    }

    public void setSwversion(String swversion) {
        this.swversion = swversion;
    }

    public String getProxyaddress() {
        return proxyaddress;
    }

    public void setProxyaddress(String proxyaddress) {
        this.proxyaddress = proxyaddress;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Boolean getLinkbutton() {
        return linkbutton;
    }

    public void setLinkbutton(Boolean linkbutton) {
        this.linkbutton = linkbutton;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getNetmask() {
        return netmask;
    }

    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public Boolean getDhcp() {
        return dhcp;
    }

    public void setDhcp(Boolean dhcp) {
        this.dhcp = dhcp;
    }

    public Boolean getPortalservices() {
        return portalservices;
    }

    public void setPortalservices(Boolean portalservices) {
        this.portalservices = portalservices;
    }

}
