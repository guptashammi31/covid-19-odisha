package com.technogenr.ocovid;

/**
 * Created by HP on 30-12-2018.
 */

public class ImageUploadInfo {

    public String area;
    public String number;
    public ImageUploadInfo() {

    }

    public ImageUploadInfo(String area,String number) {
        this.area = area;
        this.number=number;
    }
    public String getArea() {
        return area;
    }
    public String getNumber(){return number;}

}