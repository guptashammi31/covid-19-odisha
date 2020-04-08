package com.technogenr.ocovid.model;

public class StatusIndiaResponse {
    private String Name, Active_Cases, Cured_Discharged, Deaths, Time;

    public StatusIndiaResponse() {
    }

    public StatusIndiaResponse(String name, String active_Cases, String cured_Discharged, String deaths, String time) {
        Name = name;
        Active_Cases = active_Cases;
        Cured_Discharged = cured_Discharged;
        Deaths = deaths;
        Time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getActive_Cases() {
        return Active_Cases;
    }

    public void setActive_Cases(String active_Cases) {
        Active_Cases = active_Cases;
    }

    public String getCured_Discharged() {
        return Cured_Discharged;
    }

    public void setCured_Discharged(String cured_Discharged) {
        Cured_Discharged = cured_Discharged;
    }

    public String getDeaths() {
        return Deaths;
    }

    public void setDeaths(String deaths) {
        Deaths = deaths;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
