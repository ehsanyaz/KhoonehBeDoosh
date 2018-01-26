package ir.ac.bonabu.khoonehbedoosh;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private Activity context;

    public CustomInfoWindowAdapter(Activity context){
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = context.getLayoutInflater().inflate(R.layout.customwindow, null);

//        TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
        ImageView tvTitle = (ImageView) view.findViewById(R.id.tv_title);
        TextView tvSubTitle = (TextView) view.findViewById(R.id.tv_subtitle);
        Button tvSelect = (Button) view.findViewById(R.id.tv_select);

//        tvTitle.setText(marker.getTitle());
//        tvSubTitle.setText(marker.getSnippet());

        return view;
    }
}