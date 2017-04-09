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

public class CustomAlertDialog2Activity extends AppCompatActivity{
    private Button button_sign_in;
    private TextView textView_content;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alertdialog_2);

        textView_content = (TextView) findViewById(R.id.txtv_custom_2);
        button_sign_in = (Button) findViewById(R.id.btn_custom_2);
        button_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(CustomAlertDialog2Activity.this);
                View custom_dialog_2 = layoutInflater.inflate(R.layout.custom_dialog_2, null);


                final AlertDialog custom_2 = new AlertDialog.Builder(CustomAlertDialog2Activity.this).create();
                custom_2.setView(custom_dialog_2);
                final EditText editText_username = (EditText) custom_dialog_2.findViewById(R.id.edtxt_username);
                final EditText editText_password = (EditText) custom_dialog_2.findViewById(R.id.edtxt_password);

                custom_2.setButton(DialogInterface.BUTTON_POSITIVE, "Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView_content.setText("Hi: " + editText_username.getText().toString());
                    }
                });
                custom_2.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        custom_2.cancel();
                    }
                });
                custom_2.show();
            }
        });
    }
}
