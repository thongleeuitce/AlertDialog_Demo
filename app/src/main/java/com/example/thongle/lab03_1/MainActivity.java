package com.example.thongle.lab03_1;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button_alert_dialog;
    private Button button_custom_alert_dialog_1;
    private Button button_custom_alert_dialog_2;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_alert_dialog = (Button) findViewById(R.id.btn_alert_dialog);
        button_custom_alert_dialog_1 = (Button) findViewById(R.id.btn_custom_alert_dialog_1);
        button_custom_alert_dialog_2 = (Button) findViewById(R.id.btn_custom_alert_dialog_2);

        button_alert_dialog.setOnClickListener(this);
        button_custom_alert_dialog_1.setOnClickListener(this);
        button_custom_alert_dialog_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_alert_dialog:
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle(R.string.title_alert_dialog);
                alertDialog.setMessage(getResources().getString(R.string.content_alert_dialog));
                alertDialog.setIcon(R.mipmap.ic_launcher);
                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, R.string.toast_when_click_NO, Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, R.string.toast_when_click_YES, Toast.LENGTH_SHORT).show();
                    }

                });
                alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "SKIP", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, R.string.toast_when_click_SKIP, Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
                break;
            case R.id.btn_custom_alert_dialog_1:
                Intent intent = new Intent(this, CustomAlertDialog1Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_custom_alert_dialog_2:
                Intent intent1 = new Intent(this, CustomAlertDialog2Activity.class);
                startActivity(intent1);
                break;
        }
    }
}
