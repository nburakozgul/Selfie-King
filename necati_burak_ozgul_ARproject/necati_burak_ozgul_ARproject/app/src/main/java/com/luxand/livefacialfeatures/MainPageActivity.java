package com.luxand.livefacialfeatures;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.luxand.FSDK;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by bozgul on 26.01.2017.
 */


public class MainPageActivity extends Activity implements View.OnClickListener {
    private boolean mIsFailed = false;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View buttons = inflater.inflate(R.layout.main, null);
        buttons.findViewById(R.id.randButton).setOnClickListener(this);
        buttons.findViewById(R.id.selectButton).setOnClickListener(this);
        addContentView(buttons, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.randButton) {
            Intent intentApp = new Intent(MainPageActivity.this,
                    MainActivity.class);
            intentApp.putExtra("key",true);
            MainPageActivity.this.startActivity(intentApp);

        } else if (view.getId() == R.id.selectButton) {
            Intent intentApp = new Intent(MainPageActivity.this,
                    SelectFilterActivity.class);
            MainPageActivity.this.startActivity(intentApp);
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

