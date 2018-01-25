package ir.ac.bonabu.khoonehbedoosh;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import ir.ac.bonabu.khoonehbedoosh.Server_Connection.SendUser;

public class Splash extends Activity {
    Button signin;
    FrameLayout signup_Layot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        signin = (Button) findViewById(R.id.open_layout);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin.setVisibility(View.GONE);
                signup_Layot = (FrameLayout) findViewById(R.id.sigin_lay);
                signup_Layot.setVisibility(View.VISIBLE);
            }
        });

        User user = new User("a", "b", "c", "d", "e", "0914", "0914");
        SendUser sendUser = new SendUser(Splash.this, user);
        //   sendUser.ImageUploadToServerFunction();
    }

    @Override
    public void onBackPressed() {
        if (signup_Layot.getVisibility() == View.VISIBLE) {
            signup_Layot.setVisibility(View.INVISIBLE);
            signin.setVisibility(View.VISIBLE);

        } else {
            super.onBackPressed();
        }
    }
}