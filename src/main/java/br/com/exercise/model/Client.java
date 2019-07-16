package br.com.exercise.model;

public class Client extends AbstractEntity{

    public static final String CLIENT_CODE = "002";

    private String businessArea;

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }
}
