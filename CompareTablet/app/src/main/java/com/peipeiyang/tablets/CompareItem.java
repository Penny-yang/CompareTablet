package com.peipeiyang.tablets;

import android.os.Parcel;
import android.widget.CheckBox;

/**
 * Created by yangp on 5/4/2016.
 */
public class CompareItem   {
    public String names;
    public String system;
    public String demensions;
    public String weight;
    public int    photo;

    public CompareItem(){

    }


    public CompareItem(String names, String system, String demensions,String weight,int photo){
        this.names= names;
        this.system = system;
        this.demensions = demensions;
        this.weight = weight;
        this.photo = photo;
    }

    public String getNames() {
        return names;
    }
    public void setNames(String names) {
        this.names = names;
    }
    public String getSystem(){
        return  system;
    }
    public void setSystem(String system){
        this.system = system;
    }
    public String getDemensions(){
        return demensions;
    }
    public void setDemensions(String demensions){
        this.demensions = demensions;
    }
    public String getWeight(){
        return weight;
    }
    public void setWeight(String weight){
        this.weight = weight;
    }
    public int getPhoto(){return photo;}
    public void setPhoto(int photo){this.photo = photo;}

}
