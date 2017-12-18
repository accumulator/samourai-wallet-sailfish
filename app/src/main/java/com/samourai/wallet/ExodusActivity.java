package com.samourai.wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.samourai.wallet.util.TimeOutUtil;

public class ExodusActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TimeOutUtil.getInstance().reset();
        
        finish();
    }

}
