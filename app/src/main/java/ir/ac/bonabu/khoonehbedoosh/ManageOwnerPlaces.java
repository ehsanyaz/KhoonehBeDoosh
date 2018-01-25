package ir.ac.bonabu.khoonehbedoosh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageOwnerPlaces extends Activity {

    private Button addNewPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_owner_places);

        addNewPlace=(Button)findViewById(R.id.add_newPlace_btn);
        addNewPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),AddNewPlace.class);
                startActivity(i);
            }
        });
    }
}
