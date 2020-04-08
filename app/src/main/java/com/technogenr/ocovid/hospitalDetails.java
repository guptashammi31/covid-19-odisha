package com.technogenr.ocovid;

/**
 * Created by HP on 02-06-2018.
 */

public class hospitalDetails {

    public String imageName;

    public String imageURL;
    public String imageExp;
    public String imageAvail;
    public String imagePrice;
    public String mob;
    public hospitalDetails() {

    }

    public hospitalDetails(String name, String url , String exp, String avail, String price) {

        this.imageName = name;
        this.imageExp=exp;
        this.imageAvail=avail;
        this.imagePrice=price;
        this.imageURL= url;

    }

    public String getImageName() {
        return imageName;
    }

    public String getexp() {
        return imageExp;
    }

    public String getAvail() {
        return imageAvail;
    }

    public String getPrice() {
        return imagePrice;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getMob() {
        return mob;
    }



}