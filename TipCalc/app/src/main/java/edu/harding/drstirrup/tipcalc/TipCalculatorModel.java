package edu.harding.drstirrup.tipcalc;


/**
 * Created by ddenman3 on 9/20/2017.
 */

public class TipCalculatorModel {

    public float mTip;
    public float mBillTotal;

    public TipCalculatorModel(String numBillStr, String numTipPerStr) {
        //convert to numbers
        float numBill = Float.parseFloat(numBillStr);
        float numTipPer = Float.parseFloat(numTipPerStr);

        //convert tip percentage to decimal and calculate tip
        mTip = numTipPer*numBill*.01f;

        //calculate total = tip+bill
        mBillTotal = numBill+mTip;
    }
}
