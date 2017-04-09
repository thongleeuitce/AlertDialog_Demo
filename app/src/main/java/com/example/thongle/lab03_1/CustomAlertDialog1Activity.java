package com.example.thongle.lab03_1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by thongle on 08/04/2017.
 */

public class CustomAlertDialog1Activity extends AppCompatActivity{
    private Button button_dialog;
    private TextView textView_name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alertdialog_1);

        textView_name = (TextView) findViewById(R.id.txtv_custom_1);
        button_dialog = (Button) findViewById(R.id.btn_custom_1);
        button_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(CustomAlertDialog1Activity.this);
                View custom_dialog_1 = layoutInflater.inflate(R.layout.custom_dialog_1, null);


                final AlertDialog custom_1 = new AlertDialog.Builder(CustomAlertDialog1Activity.this).create();
                custom_1.setView(custom_dialog_1);
                final EditText editText_name = (EditText) custom_dialog_1.findViewById(R.id.edtxt_enter_name);

                custom_1.setButton(DialogInterface.BUTTON_POSITIVE, "OKE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView_name.setText("Your name: " + editText_name.getText().toString());
                    }
                });
                custom_1.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        custom_1.cancel();
                    }
                });
                custom_1.show();
            }
        });
    }
}
