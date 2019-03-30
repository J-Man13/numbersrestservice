package App.Models;

public class PhoneUser {
    private String phoneUserNumber;
    private String phoneUserName;

    public PhoneUser(){

    }

    public PhoneUser(String phoneUserNumber, String phoneUserName){
        this.phoneUserNumber = phoneUserNumber;
        this.phoneUserName = phoneUserName;
    }

    public String getPhoneUserNumber() {
        return phoneUserNumber;
    }

    public void setPhoneUserNumber(String phoneUserNumber) {
        this.phoneUserNumber = phoneUserNumber;
    }

    public String getPhoneUserName() {
        return phoneUserName;
    }

    public void setPhoneUserName(String phoneUserName) {
        this.phoneUserName = phoneUserName;
    }
}
