package com.example.sping_portfolio.minilabs;

public class patient {
    private boolean needssurgery;
    private int age;
    private boolean hasHealthInsurance;
    private String name;
    private String emergencyContact;

    public patient(boolean needssurgery, boolean hasHealthInsurance, int age, String name, String emergencyContact) {
        needssurgery = needssurgery;
        hasHealthInsurance = hasHealthInsurance;
        age = age;
        name = name;
        emergencyContact = emergencyContact;
    }

    public boolean willTreat() {
        if (needssurgery && !hasHealthInsurance) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean needsAdult() {
        if (age < 18 && emergencyContact != "") {
            return true;
        }
        else {
            return false;
        }
    }
}