package ir.ac.bonabu.khoonehbedoosh;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by Shaho on 1/26/2018.
 */

public class Example extends Activity
{
    Button malek,karbar;

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        malek=(Button) findViewById(R.id.malek);
        karbar=(Button) findViewById(R.id.karbar);

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Example.this);
        edit=sharedPreferences.edit();

        malek.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                edit.putBoolean("malek",true);
                edit.commit();
                Intent intent=new Intent(Example.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        karbar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                edit.putBoolean("malek",false);
                edit.commit();
                Intent intent=new Intent(Example.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
