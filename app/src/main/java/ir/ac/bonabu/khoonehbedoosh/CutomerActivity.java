package ir.ac.bonabu.khoonehbedoosh;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class CutomerActivity extends Activity {

    private Button showMap;
    private Button FilterMAp;

    private Typeface typeface;

    public static boolean malek=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_activity);

        showMap=(Button) findViewById(R.id.customer_activity_Map_btn);
        //TODO:complete here

        FilterMAp=(Button)findViewById(R.id.customer_activity_findPlace_btn);
        FilterMAp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),FindPlace.class);
                startActivity(i);

            }
        });

        typeface=Typeface.createFromAsset(getAssets(),"Fonts/font.ttf");
        FilterMAp.setTypeface(typeface);
        showMap.setTypeface(typeface);

        showMap.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                malek=false;
                Intent intent=new Intent(CutomerActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        
    }
}