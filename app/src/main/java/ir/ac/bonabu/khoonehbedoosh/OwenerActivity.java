package ir.ac.bonabu.khoonehbedoosh;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OwenerActivity extends Activity {

    private Button MyPassengers;
    private Button MyPlaces;
    private Button MyAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_activity);

        MyPassengers=(Button)findViewById(R.id.owner_activity_myPassengers_btn);

        MyPlaces=(Button)findViewById(R.id.owner_activity_MyPlaces_btn);

        MyAccount=(Button)findViewById(R.id.owner_activity_MyAccount_btn);

        Typeface typeface=Typeface.createFromAsset(getAssets(),"Fonts/font.ttf");
        MyAccount.setTypeface(typeface);
        MyPlaces.setTypeface(typeface);
        MyPassengers.setTypeface(typeface);

        MyPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_LONG).show();
            }
        });
    }
}