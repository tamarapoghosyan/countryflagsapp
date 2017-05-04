package com.example.lenovo.myapp;

import java.io.Serializable;

/**
 * Created by LENOVO on 03.05.2017.
 */
public class Country implements Serializable{
    private String name;
    private String code;
    private boolean isSelected;;

    public Country(String name, String code, boolean isSelected) {
        this.name = name;
        this.code = code;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
