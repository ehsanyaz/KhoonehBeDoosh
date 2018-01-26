package ir.ac.bonabu.khoonehbedoosh;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FindPlace extends Activity {

    private boolean haveMobl=false;
    private boolean haveRefreg=false;
    private boolean haveParking=false;
    private boolean haveToilet=false;
    private boolean havebathroom=false;
    private boolean haveKitchen=false;
    private boolean haveCooler=false;
    private boolean haveHeater=false;
    private boolean haveTV=false;
    private boolean haveWIFI=false;
    private boolean haveEleveretor=false;
    private boolean havePool=false;

    private ImageView mobl;
    private  ImageView refregirator;
    private ImageView parking;
    private ImageView toilet;
    private ImageView bathroom;
    private ImageView kitchen;
    private ImageView cooler;
    private ImageView heater;
    private ImageView tv;
    private ImageView wifi;
    private ImageView elevertor;
    private ImageView pool;

    private Button search;

    private Typeface typeface;

    private TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newof_ind_place);

        setImageViewSettings();

        typeface=Typeface.createFromAsset(getAssets(),"Fonts/font.ttf");

        txt1=(TextView)findViewById(R.id.FindPlace_txt1);
        txt1.setTypeface(typeface);

        search=(Button)findViewById(R.id.FindPlace_search_btn);
        search.setText("جستجو");
        search.setBackgroundColor(Color.WHITE);
        search.setTypeface(typeface);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_LONG).show();
                //TODO:Complete Search operation
            }
        });
    }

    private void setImageViewSettings() {

        bathroom=(ImageView)findViewById(R.id.findPlace_bathroom_img);
        bathroom.setImageResource(R.drawable.bathroom);
        bathroom.setColorFilter(Color.GRAY);
        bathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(havebathroom){
                    havebathroom=false;
                    bathroom.setColorFilter(Color.GRAY);
                }else{
                    havebathroom=true;
                    bathroom.setColorFilter(Color.BLACK);
                }
            }
        });

        mobl=(ImageView)findViewById(R.id.findPlace_mobl_img);
        mobl.setImageResource(R.drawable.mobl);
        mobl.setColorFilter(Color.GRAY);
        mobl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(haveMobl){
                    haveMobl=false;
                    mobl.setColorFilter(Color.GRAY);
                }else{
                    haveMobl=true;
                    mobl.setColorFilter(Color.BLACK);
                }
            }
        });

        refregirator=(ImageView)findViewById(R.id.findPlace_refregirator_img);
        refregirator.setImageResource(R.drawable.refrigertor);
        refregirator.setColorFilter(Color.GRAY);
        refregirator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(haveRefreg){
                    haveRefreg=false;
                    refregirator.setColorFilter(Color.GRAY);
                }else{
                    haveRefreg=true;
                    refregirator.setColorFilter(Color.BLACK);
                }
            }
        });

        parking=(ImageView)findViewById(R.id.findPlace_parking_img);
        parking.setImageResource(R.drawable.parking);
        parking.setColorFilter(Color.GRAY);
        parking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(haveParking){
                    haveParking=false;
                    parking.setColorFilter(Color.GRAY);
                }else{
                    haveParking=true;
                    parking.setColorFilter(Color.BLACK);
                }
            }
        });

        toilet=(ImageView)findViewById(R.id.findPlace_toilet_img);
        toilet.setImageResource(R.drawable.toilet);
        toilet.setColorFilter(Color.GRAY);
        toilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(haveToilet){
                    haveToilet=false;
                    toilet.setColorFilter(Color.GRAY);
                }else{
                    haveToilet=true;
                    toilet.setColorFilter(Color.BLACK);
                }
            }
        });



        kitchen=(ImageView)findViewById(R.id.findPlace_kitchen_img);
        kitchen.setImageResource(R.drawable.kitchen);
        kitchen.setColorFilter(Color.GRAY);
        kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(haveKitchen){
                    haveKitchen=false;
                    kitchen.setColorFilter(Color.GRAY);
                }else{
                    haveKitchen=true;
                    kitchen.setColorFilter(Color.BLACK);
                }
            }
        });

        cooler=(ImageView)findViewById(R.id.findPlace_aircon_img);
        cooler.setImageResource(R.drawable.aircon);
        cooler.setColorFilter(Color.GRAY);
        cooler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(haveCooler){
                    haveCooler=false;
                    cooler.setColorFilter(Color.GRAY);
                }else{
                    haveCooler=true;
                    cooler.setColorFilter(Color.BLACK);
                }
            }
        });

        heater=(ImageView)findViewById(R.id.findPlace_heater_img);
        heater.setImageResource(R.drawable.heater);
        heater.setColorFilter(Color.GRAY);
        heater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(haveHeater){
                    haveHeater=false;
                    heater.setColorFilter(Color.GRAY);
                }else{
                    haveHeater=true;
                    heater.setColorFilter(Color.BLACK);
                }
            }
        });

        tv=(ImageView)findViewById(R.id.findPlace_tv_img);
        tv.setImageResource(R.drawable.tv);
        tv.setColorFilter(Color.GRAY);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(haveTV){
                    haveTV=false;
                    tv.setColorFilter(Color.GRAY);
                }else{
                    haveTV=true;
                    tv.setColorFilter(Color.BLACK);
                }
            }
        });

        wifi=(ImageView)findViewById(R.id.findPlace_wifi_img);
        wifi.setImageResource(R.drawable.wifi);
        wifi.setColorFilter(Color.GRAY);
        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(haveWIFI){
                    haveWIFI=false;
                    wifi.setColorFilter(Color.GRAY);
                }else{
                    haveWIFI=true;
                    wifi.setColorFilter(Color.BLACK);
                }
            }
        });

        elevertor=(ImageView)findViewById(R.id.findPlace_eleverator_img);
        elevertor.setImageResource(R.drawable.eleveator);
        elevertor.setColorFilter(Color.GRAY);
        elevertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(haveEleveretor){
                    haveEleveretor=false;
                    elevertor.setColorFilter(Color.GRAY);
                }else{
                    haveEleveretor=true;
                    elevertor.setColorFilter(Color.BLACK);
                }
            }
        });

        pool=(ImageView)findViewById(R.id.findPlace_pool_img);
        pool.setImageResource(R.drawable.pool);
        pool.setColorFilter(Color.GRAY);
        pool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(havePool){
                    havePool=false;
                    pool.setColorFilter(Color.GRAY);
                }else{
                    havePool=true;
                    pool.setColorFilter(Color.BLACK);
                }
            }
        });
    }
}