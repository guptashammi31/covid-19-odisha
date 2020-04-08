package com.technogenr.ocovid.model;

public class StatusOdishaResponse {
    private String Name, Total_Confirmed, Cured_Discharged_Migrated, Death;

    public StatusOdishaResponse() {
    }

    public StatusOdishaResponse(String name, String total_Confirmed, String cured_Discharged_Migrated, String death) {
        Name = name;
        Total_Confirmed = total_Confirmed;
        Cured_Discharged_Migrated = cured_Discharged_Migrated;
        Death = death;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTotal_Confirmed() {
        return Total_Confirmed;
    }

    public void setTotal_Confirmed(String total_Confirmed) {
        Total_Confirmed = total_Confirmed;
    }

    public String getCured_Discharged_Migrated() {
        return Cured_Discharged_Migrated;
    }

    public void setCured_Discharged_Migrated(String cured_Discharged_Migrated) {
        Cured_Discharged_Migrated = cured_Discharged_Migrated;
    }

    public String getDeath() {
        return Death;
    }

    public void setDeath(String death) {
        Death = death;
    }
}
