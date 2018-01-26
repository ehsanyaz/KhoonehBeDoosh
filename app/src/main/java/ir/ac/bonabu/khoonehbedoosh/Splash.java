package ir.ac.bonabu.khoonehbedoosh;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import ir.ac.bonabu.khoonehbedoosh.Server_Connection.ServerData;

public class Splash extends Activity {
    final int SIGN_IN=0;
    final int SIGN_UP=1;
    Button signin_laybtn;
    EditText signup_u, signup_p, signup_e, signup_n, signup_ln, signup_ph, signup_nc,signin_p,signin_u;
    LinearLayout signup_Layot,signin_Layot;

    private static SharedPreferences preferences;

    public static void putUserPass(String UserName,String Password,String Name,String familyName){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("UserName",UserName);
        editor.putString("Password",Password);
        editor.putString("Name",Name);
        editor.putString("FamilyName",familyName);
        editor.commit();
    }

    public static String getFamilyName(){
        return preferences.getString("FamilyName","");
    }

    public static String getName(){
        return preferences.getString("Name","");
    }

    public static String getPassword(){
        return preferences.getString("Password","");
    }

    public static String getUserName(){
        return preferences.getString("UserName","");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        preferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        signin_laybtn = (Button) findViewById(R.id.open_layout);
        signup_Layot = (LinearLayout) findViewById(R.id.sigup_lay);
        signin_Layot = (LinearLayout) findViewById(R.id.sigin_lay);
        signup_u=(EditText)findViewById(R.id.signup_u);
        signup_p=(EditText)findViewById(R.id.signup_p);
        signup_n=(EditText)findViewById(R.id.signup_n);
        signup_ln=(EditText)findViewById(R.id.signup_ln);
        signup_e=(EditText)findViewById(R.id.signup_e);
        signup_ph=(EditText)findViewById(R.id.signup_ph);
        signin_u=(EditText)findViewById(R.id.signin_u);
        signin_p=(EditText)findViewById(R.id.signin_p);
        signin_laybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin_laybtn.setVisibility(View.GONE);
                signin_Layot.setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.go_toSignup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin_Layot.setVisibility(View.GONE);
                signup_Layot.setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.go_toSignin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup_Layot.setVisibility(View.GONE);
                signin_Layot.setVisibility(View.VISIBLE);

            }
        });
        findViewById(R.id.sigup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.signUp user = new User.signUp(signup_n.getText().toString(), signup_ln.getText().toString(), signup_u.getText().toString(), signup_e.getText().toString(), signup_p.getText().toString(), signup_ph.getText().toString());
                ServerData sendUser = new ServerData(Splash.this, user,SIGN_UP);
                sendUser.upload();
            }
        });
        findViewById(R.id.sigin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.signIn user = new User.signIn( signin_u.getText().toString(), signin_p.getText().toString());
                ServerData sendUser = new ServerData(Splash.this, user,SIGN_IN);
                sendUser.upload();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (signup_Layot.getVisibility() == View.VISIBLE) {
            signin_Layot.setVisibility(View.GONE);
            signin_laybtn.setVisibility(View.VISIBLE);

        } else {
            super.onBackPressed();
        }
    }
}