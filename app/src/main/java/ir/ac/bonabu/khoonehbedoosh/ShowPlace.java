package ir.ac.bonabu.khoonehbedoosh;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowPlace extends Activity {



    /////////
    /////////
    ////Important////
    public static String placeName;
    /////////////
    /////////

    private EditText PlaceNameEdit;
    private EditText state;
    private EditText city;

    private TextView price;
    private TextView roomCount;
    private TextView metraj;
    private TextView placeType;

    private ImageView bathRoom;
    private ImageView toilet;
    private ImageView parking;
    private ImageView mobl;
    private ImageView tv;
    private ImageView cooler;
    private ImageView heater;
    private ImageView kitchen;
    private ImageView refreg;
    private ImageView wifi;
    private ImageView elevator;
    private ImageView pool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_place);
        intialGraphics();




        ////////
        ///////
        /////
        //TODO:we have to intailize all of components here again!!!!
        ////
        ////

    }

    private void intialGraphics() {

        PlaceNameEdit=(EditText)findViewById(R.id.showPlace_PlaceName_edit);

        state=(EditText) findViewById(R.id.showPlace_state_edit);

        city=(EditText)findViewById(R.id.showPlace_city_edit);

        price=(TextView)findViewById(R.id.showPlace_price_txt);

        roomCount=(TextView)findViewById(R.id.showPlace_roomCount_txt);

        metraj=(TextView)findViewById(R.id.showPlace_metraj_txt);

        placeType=(TextView)findViewById(R.id.showPlace_placeType_txt);

        bathRoom=(ImageView)findViewById(R.id.showPlace_bathroom_img);
        bathRoom.setImageResource(R.drawable.bathroom);
        bathRoom.setColorFilter(Color.GRAY);

        toilet=(ImageView)findViewById(R.id.showPlace_toilet_img);
        toilet.setImageResource(R.drawable.toilet);
        toilet.setColorFilter(Color.GRAY);

        parking=(ImageView)findViewById(R.id.showPlace_parking_img);
        parking.setImageResource(R.drawable.parking);
        parking.setColorFilter(Color.GRAY);

        mobl=(ImageView)findViewById(R.id.showPlace_mobl_img);
        mobl.setImageResource(R.drawable.mobl);
        mobl.setColorFilter(Color.GRAY);

        tv=(ImageView)findViewById(R.id.showPlace_tv_img);
        tv.setImageResource(R.drawable.tv);
        tv.setColorFilter(Color.GRAY);

        cooler=(ImageView)findViewById(R.id.showPlace_aircon_img);
        cooler.setImageResource(R.drawable.aircon);
        cooler.setColorFilter(Color.GRAY);

        heater=(ImageView)findViewById(R.id.showPlace_heater_img);
        heater.setImageResource(R.drawable.heater);
        heater.setColorFilter(Color.GRAY);

        kitchen=(ImageView)findViewById(R.id.showPlace_kitchen_img);
        kitchen.setImageResource(R.drawable.kitchen);
        kitchen.setColorFilter(Color.GRAY);

        refreg=(ImageView)findViewById(R.id.showPlace_refregirator_img);
        refreg.setImageResource(R.drawable.refrigertor);
        refreg.setColorFilter(Color.GRAY);

        wifi=(ImageView)findViewById(R.id.showPlace_wifi_img);
        wifi.setImageResource(R.drawable.wifi);
        wifi.setColorFilter(Color.GRAY);

        elevator=(ImageView)findViewById(R.id.showPlace_eleverator_img);
        elevator.setImageResource(R.drawable.eleveator);
        elevator.setColorFilter(Color.GRAY);

        pool=(ImageView)findViewById(R.id.showPlace_pool_img);
        pool.setImageResource(R.drawable.pool);
        pool.setColorFilter(Color.GRAY);

    }
}
