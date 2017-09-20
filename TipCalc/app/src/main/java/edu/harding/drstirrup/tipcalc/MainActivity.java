package edu.harding.drstirrup.tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    public final int CHEAP_SKATE_SPECIAL = 10;

    private EditText mBillEditText;
    private EditText mTipPercentEditText;
    private TextView mTipAmount;
    private TextView mBillTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pair widgets with class variables
        mBillEditText = (EditText) findViewById(R.id.billEditText);
        mTipPercentEditText = (EditText) findViewById(R.id.tipPercentText);
        mTipAmount = (TextView) findViewById(R.id.tipAmount);
        mBillTotal = (TextView) findViewById(R.id.billTipTotal);
    }

    //This is where I put the mechanics/magic
    public void calculateClick(View view){
        try {
            //get strings from edit texts
            String numBillStr = mBillEditText.getText().toString();
            String numTipPerStr = mTipPercentEditText.getText().toString();
            //TODO: add cheapskate Toast
                /*
                //convert to numbers
                float numBill = Float.parseFloat(numBillStr);
                float numTipPer = Float.parseFloat(numTipPerStr);

                convert tip percentage to decimal and calculate tip
                float tip = numTipPer * numBill * .01f;

                //calculate total = tip+bill
                float billTotal = numBill + tip;
                */
            TipCalculatorModel calc = new TipCalculatorModel(numBillStr, numTipPerStr);

            NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
            //send numbers to TextViews via setText
            mTipAmount.setText(moneyFormat.format(calc.mTip));
            mBillTotal.setText(moneyFormat.format(calc.mBillTotal));
        }
        catch (NumberFormatException ex) {
        //TODO: Add Toast
        //String errorMes = get.Resources().getString(R.string.error_message);
        Toast.makeText(this, "Please Add a Number", Toast.LENGTH_SHORT).show();
        }
        //Win
    }
    //TEST GIT HUB
    //TODO:Textwatcher version
}
