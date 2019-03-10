package com.tencent.gaio.workorder.domain;


public class Workorder {

    private long id;

    //办理渠道
    private String channel;
    //自然人
    private String serverCategory;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getServerCategory() {
        return serverCategory;
    }

    public void setServerCategory(String serverCategory) {
        this.serverCategory = serverCategory;
    }

    @Override
    public String toString() {
        return "Workorder{" +
                "channel='" + channel + '\'' +
                ", serverCategory='" + serverCategory + '\'' +
                '}';
    }
}
