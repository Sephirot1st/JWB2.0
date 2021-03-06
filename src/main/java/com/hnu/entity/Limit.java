package com.hnu.entity;

import java.util.Date;

public class Limit {

    //max_lon, min_lon, max_lat, min_lat
    private float maxLon;
    private float minLon;
    private float maxLat;
    private float minLat;
    private Date startTime;
    private Date endTime;

    public Limit() {
    }

    public Limit(float maxLon, float minLon, float maxLat, float minLat, Date startTime, Date endTime) {
        this.maxLon = maxLon;
        this.minLon = minLon;
        this.maxLat = maxLat;
        this.minLat = minLat;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public float getMaxLon() {
        return maxLon;
    }

    public void setMaxLon(float maxLon) {
        this.maxLon = maxLon;
    }

    public float getMinLon() {
        return minLon;
    }

    public void setMinLon(float minLon) {
        this.minLon = minLon;
    }

    public float getMaxLat() {
        return maxLat;
    }

    public void setMaxLat(float maxLat) {
        this.maxLat = maxLat;
    }

    public float getMinLat() {
        return minLat;
    }

    public void setMinLat(float minLat) {
        this.minLat = minLat;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
