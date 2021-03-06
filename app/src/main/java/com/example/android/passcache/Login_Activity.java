package com.example.android.passcache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    @Override
    /**
     * Deactivate backwards button
     */
    public void onBackPressed() {
        // do nothing
    }

    public void buttonLoginClick(View view) {
        //String test = PrefUtilis.getFromPrefs(this, PrefUtilis.PREFS_LOGIN_PASSWORD_KEY, "wtf");
        try {
            String password = ((EditText) findViewById(R.id.password)).getText().toString();
            if( password.equals(PrefUtilis.getFromPrefs(this, PrefUtilis.PREFS_LOGIN_PASSWORD_KEY, "wtf")) ) {
                Intent intent = new Intent(Login_Activity.this, Main.class);
                startActivity(intent);
            }
            else {
                displayWrongPassDialog();
            }
            ((EditText) findViewById(R.id.password)).setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buttonForget(View view) {
        try {
            Intent intent = new Intent(Login_Activity.this, ForgetPass_Activity.class);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayWrongPassDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(Login_Activity.this).create();
        alertDialog.setTitle("Wrong Password!");
        alertDialog.setMessage("The password is incorrect");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        alertDialog.show();
    }
}
