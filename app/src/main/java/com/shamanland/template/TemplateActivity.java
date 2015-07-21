package com.shamanland.template;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shamanland.common.CommonUtils;

public class TemplateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.a_template);

        CommonUtils.dummy();
    }
}
