package com.cornez.shippingcalculator;

/**
 * Created by trishcornez on 6/29/14.
 */
public class ShipItem {


    private double mHeight;
    private double mWeight;
    private int mAge;
    private double mBmr;

    public ShipItem() {
        mWeight = 0.0;
        mHeight = 0.0;
        mAge = 0;
    }

    public void setHeight (double height){
        mHeight = height;
    }
    public void setWeight (double weight){
        mWeight = weight;
    }
    public void setAge (int age){
        mAge = age;
    }
    public void setting1(){
        mBmr = 66.4730 + 13.7516 * mWeight + 5.0033 * mHeight + 6.7550 * mAge;
    }
    public void setting2(){
        mBmr = 655.0955 + 9.5634 * mWeight + 1.8496 * mHeight - 4.6756 * mAge;
    }
    public double getBMR(){
        return mBmr;
    }

}

