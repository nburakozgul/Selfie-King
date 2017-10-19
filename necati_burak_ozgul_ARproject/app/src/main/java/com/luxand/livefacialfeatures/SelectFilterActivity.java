package com.luxand.livefacialfeatures;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

/**
 * Created by bozgul on 27.01.2017.
 */

public class SelectFilterActivity extends Activity implements View.OnClickListener {
    private boolean mIsFailed = false;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View buttons = inflater.inflate(R.layout.selectfilter, null);
        buttons.findViewById(R.id.okButton).setOnClickListener(this);
        addContentView(buttons, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.okButton) {
            Intent intentApp = new Intent(SelectFilterActivity.this,
                    MainActivity.class);
            CheckBox biyik = (CheckBox)findViewById(R.id.checkBoxBiyik);
            CheckBox eyes = (CheckBox)findViewById(R.id.checkBoxEyes);
            CheckBox piratehat = (CheckBox)findViewById(R.id.checkBoxPirateHat);
            CheckBox pirateye = (CheckBox)findViewById(R.id.checkBoxPirateye);
            CheckBox santahat = (CheckBox)findViewById(R.id.checkBoxSantaHat);

            intentApp.putExtra("biyik",biyik.isChecked());
            intentApp.putExtra("eyes",eyes.isChecked());
            intentApp.putExtra("piratehat",piratehat.isChecked());
            intentApp.putExtra("pirateye",pirateye.isChecked());
            intentApp.putExtra("santahat",santahat.isChecked());
            SelectFilterActivity.this.startActivity(intentApp);

        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mIsFailed)
            return;

    }

    @Override
    public void onResume() {
        super.onResume();
        if (mIsFailed)
            return;

    }


}