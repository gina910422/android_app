package com.cornez.tapbuttoncounter;

class Counter {
    private int mCount;
    private int mAns1;
    private int mAns2;
    private int mAns3;
    public Counter(){
        mCount = 0;
        mAns1 = 0;
        mAns2 = 1;
        mAns3 = -1;
    }

    public void addCount(){
        if(mCount<20){
            mCount++;
        }
    }

    public void deCount(){
        if(mCount>0){
            mCount--;
        }
    }

    public void compCount(){
        int a = getCount();

        int f0=0;int f1=1;
        if(a==0){
            mAns1 = f0;
        }
        else if(a==1){
            mAns1 = f1;
        }
        else{
            for(int i=2;i<=a;i++){
                mAns1=f0+f1;
                f0=f1;
                f1=mAns1;
            }
        }

        int p0=1;int p1=1;int p2=1;
        if(a<3){
            mAns2=1;
        }
        else{
            for(int i=3;i<=a;i++){
                mAns2=p0+p1;
                p0=p1;
                p1=p2;
                p2=mAns2;
            }
        }

        mAns3=mAns1-mAns2;
    }
    public void resetCount(){
        mCount = 0;
        mAns1 = 0;
        mAns2 = 1;
        mAns3 = -1;
    }
    public Integer getCount() {
        return mCount;
    }

    public Integer getAns1() {
        return mAns1;
    }

    public Integer getAns2() {
        return mAns2;
    }

    public Integer getAns3() {
        return mAns3;
    }
}
