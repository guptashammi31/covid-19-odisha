package com.technogenr.ocovid;

/**
 * Created by HP on 17-06-2018.
 */

public class PatientinforAppointment {



    public String name;
    public String number;
    public String date;
    public String discription;
    public String address;





    public PatientinforAppointment()
    {

    }

    public PatientinforAppointment(String name, String number, String date, String discription , String address ) {
        this.name=name;
        this.number=number;
        this.date=date;
        this.discription=discription;
        this.address=address;



    }

    public String getname() {
        return name;
    }

    public String getnumber() {
        return number;
    }

    public String getdate() {
        return date;
    }

    public String getdiscription() {return discription;}

    public String getaddress() {
        return address;
    }


}
