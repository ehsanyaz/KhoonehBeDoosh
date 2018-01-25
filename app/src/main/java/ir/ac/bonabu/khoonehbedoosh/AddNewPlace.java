package ir.ac.bonabu.khoonehbedoosh;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

public class AddNewPlace extends Activity {

    public static double x=0;
    public static double y=0;

    private ImageView img1,img2,img3,img4,img5,img6,img7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_place);

        img2=(ImageView)findViewById(R.id.add_place_addPic_btn);
        img3=(ImageView)findViewById(R.id.addNewPlace_img1);
        img1=(ImageView)findViewById(R.id.addNewPlace_img4);
        img4=(ImageView)findViewById(R.id.addNewPlace_img2);
        img5=(ImageView)findViewById(R.id.addNewPlace_img3);
        img6=(ImageView)findViewById(R.id.add_place_addLocation_img);

        img1.setColorFilter(Color.WHITE);
        img2.setColorFilter(Color.WHITE);
        img3.setColorFilter(Color.WHITE);
        img4.setColorFilter(Color.WHITE);
        img5.setColorFilter(Color.WHITE);
        img6.setColorFilter(Color.WHITE);

    }
}
