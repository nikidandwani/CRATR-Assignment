package com.assigmnet.parameterPrinterdemo.parameter.server;

import java.io.Serializable;

public class Parameter implements Serializable {

    public Parameter(){

    }
    public Parameter(double p) {
        this.p = p;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    private double p;

    public double getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(double daysLeft) {
        this.daysLeft = daysLeft;
    }

    double daysLeft;
}
