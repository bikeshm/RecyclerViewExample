package com.workassis.recyclerviewexample.models;

public class ScheduleModel {
    private String busNo;
    private String route;
    private String time;
    private String fee;

    public ScheduleModel() {
    }

    public ScheduleModel(String busNo, String route, String time, String fee) {
        this.busNo = busNo;
        this.route = route;
        this.time = time;
        this.fee = fee;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
