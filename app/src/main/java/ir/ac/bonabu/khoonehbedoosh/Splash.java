package ir.ac.bonabu.khoonehbedoosh;


import android.app.Activity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        signin_laybtn = (Button) findViewById(R.id.open_layout);
        signup_Layot = (LinearLayout) findViewById(R.id.sigup_lay);
        signin_Layot = (LinearLayout) findViewById(R.id.sigin_lay);
        signup_u=(EditText)findViewById(R.id.signup_u);
        signup_p=(EditText)findViewById(R.id.signup_p);
        signup_n=(EditText)findViewById(R.id.signup_n);
        signup_ln=(EditText)findViewById(R.id.signup_ln);
        signup_e=(EditText)findViewById(R.id.signup_e);
        signup_ph=(EditText)findViewById(R.id.signup_ph);
        signup_nc=(EditText)findViewById(R.id.signup_nc);
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
                User.signUp user = new User.signUp(signup_n.getText().toString(), signup_ln.getText().toString(), signup_u.getText().toString(), signup_e.getText().toString(), signup_p.getText().toString(), signup_ph.getText().toString(), signup_nc.getText().toString());
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