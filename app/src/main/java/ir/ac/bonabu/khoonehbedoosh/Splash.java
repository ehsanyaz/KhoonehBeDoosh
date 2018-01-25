package ir.ac.bonabu.khoonehbedoosh;



        import android.app.Activity;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import ir.ac.bonabu.khoonehbedoosh.Server_Connection.SendUser;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        User user=new User("a","b","c","d","e","0914","0914");
        SendUser sendUser=new SendUser(Splash.this,user);
        sendUser.ImageUploadToServerFunction();
    }

}