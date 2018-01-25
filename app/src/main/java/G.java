

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by Abolfazl 7x on 12/22/2017.
 */

public class G extends Application {

    public static Context context;
    public static String imageDir;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        imageDir= Environment.getExternalStorageDirectory().getAbsolutePath()+"/Salamat/Salamat Images";
        File fImg=new File(imageDir);
        fImg.mkdirs();
    }

}