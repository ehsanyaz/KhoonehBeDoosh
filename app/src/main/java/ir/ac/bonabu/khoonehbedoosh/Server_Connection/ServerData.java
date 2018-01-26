package ir.ac.bonabu.khoonehbedoosh.Server_Connection;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import ir.ac.bonabu.khoonehbedoosh.CutomerActivity;
import ir.ac.bonabu.khoonehbedoosh.MapsActivity;
import ir.ac.bonabu.khoonehbedoosh.OwenerActivity;
import ir.ac.bonabu.khoonehbedoosh.User;

/**
 * Created by Abolfazl 7x on 1/25/2018.
 */

public class ServerData {

    public static boolean malek=true;

    final int SIGN_IN = 0;
    final int SIGN_UP = 1;
    boolean check = true;
    Context context;
    ProgressDialog progressDialog;
    int cu = 0;
    String ServerUploadPath = "http://530d2d83.ngrok.io/Php/kbd/test.php";
    User.signUp user;
    User.signIn signIn;

    public ServerData(Context context, User.signUp user, int cu) {
        this.context = context;
        this.user = user;
        this.cu = cu;

    }

    public ServerData(Context context, User.signIn user, int cu) {
        this.context = context;
        this.signIn = user;
        this.cu = cu;
    }


    public void upload() {

        class AsyncTaskUploadClass extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {

                super.onPreExecute();

               progressDialog = ProgressDialog.show(context, "Connecting...", "Please Wait", false, false);
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
               progressDialog.dismiss();
                Log.w("Server", result);
                if (cu == SIGN_UP || cu == SIGN_IN) {
                    if (result.contains("successful") && result.contains("user")) {
                        malek=true;
                        context.startActivity(new Intent(context, MapsActivity.class));
                        ((Activity)context).finish();
                    } else if (result.contains("successful") && result.contains("costumer")) {
                        context.startActivity(new Intent(context, OwenerActivity.class));
                        ((Activity)context).finish();
                    } else {
                        AlertDialog.Builder msg = new AlertDialog.Builder(context)
                                .setIcon(android.R.drawable.ic_delete)
                                .setNegativeButton("باشه", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                        if (cu == SIGN_UP) {
                            msg.setTitle("ثبت نام ناموفق")
                                    .setMessage("مشکل ارتباط با سرور");
                        } else {
                            msg.setTitle("ورود ناموفق")
                                    .setMessage("نام کاربری یا گذر واژه نادرست وارد شده اند");
                        }
                        msg.create().show();
                    }
                } else {

                }
                // Log.w("Server", result);


            }


            @Override
            protected String doInBackground(Void... params) {

                SendProcessClass imageProcessClass = new SendProcessClass();
                String FinalData = "";
                if (cu == SIGN_UP) {
                    HashMap<String, String> HashMapParams = signUpPreoare();
                    FinalData = imageProcessClass.ImageHttpRequest(ServerUploadPath, HashMapParams);
                } else if (cu == SIGN_IN) {
                    HashMap<String, String> HashMapParams = signInPreoare();
                    FinalData = imageProcessClass.ImageHttpRequest(ServerUploadPath, HashMapParams);
                }

                return FinalData;
            }
        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();

        AsyncTaskUploadClassOBJ.execute();
    }

    public class SendProcessClass {

        public String ImageHttpRequest(String requestURL, HashMap<String, String> PData) {

            StringBuilder stringBuilder = new StringBuilder();

            try {

                URL url;
                HttpURLConnection httpURLConnectionObject;
                OutputStream OutPutStream;
                BufferedWriter bufferedWriterObject;
                BufferedReader bufferedReaderObject;
                int RC;

                url = new URL(requestURL);

                httpURLConnectionObject = (HttpURLConnection) url.openConnection();

                httpURLConnectionObject.setReadTimeout(30000);

                httpURLConnectionObject.setConnectTimeout(30000);

                httpURLConnectionObject.setRequestMethod("POST");

                httpURLConnectionObject.setDoInput(true);

                httpURLConnectionObject.setDoOutput(true);

                OutPutStream = httpURLConnectionObject.getOutputStream();

                bufferedWriterObject = new BufferedWriter(

                        new OutputStreamWriter(OutPutStream, "UTF-8"));

                bufferedWriterObject.write(bufferedWriterDataFN(PData));

                bufferedWriterObject.flush();

                bufferedWriterObject.close();

                OutPutStream.close();

                RC = httpURLConnectionObject.getResponseCode();

                if (RC == HttpsURLConnection.HTTP_OK) {

                    bufferedReaderObject = new BufferedReader(new InputStreamReader(httpURLConnectionObject.getInputStream()));

                    stringBuilder = new StringBuilder();

                    String RC2;

                    while ((RC2 = bufferedReaderObject.readLine()) != null) {

                        stringBuilder.append(RC2);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        private String bufferedWriterDataFN(HashMap<String, String> HashMapParams) throws UnsupportedEncodingException {

            StringBuilder stringBuilderObject;

            stringBuilderObject = new StringBuilder();

            for (Map.Entry<String, String> KEY : HashMapParams.entrySet()) {

                if (check)

                    check = false;
                else
                    stringBuilderObject.append("&");

                stringBuilderObject.append(URLEncoder.encode(KEY.getKey(), "UTF-8"));

                stringBuilderObject.append("=");

                stringBuilderObject.append(URLEncoder.encode(KEY.getValue(), "UTF-8"));
            }

            return stringBuilderObject.toString();
        }

    }

    public HashMap<String, String> signUpPreoare() {
        HashMap<String, String> HashMapParams = new HashMap<String, String>();
        HashMapParams.put("u[name]", user.getName());
        HashMapParams.put("u[lastname]", user.getLastname());
        HashMapParams.put("u[email]", user.getEmail());
        HashMapParams.put("u[username]", user.getUsername());
        HashMapParams.put("u[password]", user.getPassword());
        HashMapParams.put("u[phone]", user.getPhone());
       // HashMapParams.put("u[nacode]", user.getNacode());
        HashMapParams.put("action", "1");
        return HashMapParams;
    }

    public HashMap<String, String> signInPreoare() {
        HashMap<String, String> HashMapParams = new HashMap<String, String>();
        HashMapParams.put("u[username]", signIn.getUsername());
        HashMapParams.put("u[password]", signIn.getPassword());
        Log.e("server", signIn.getUsername());
        Log.e("server", signIn.getPassword());
        HashMapParams.put("action", "0");
        return HashMapParams;
    }
    public HashMap<String, String> mapdata() {
        HashMap<String, String> HashMapParams = new HashMap<String, String>();
        HashMapParams.put("u[username]", signIn.getUsername());
        HashMapParams.put("u[password]", signIn.getPassword());
        Log.e("server", signIn.getUsername());
        Log.e("server", signIn.getPassword());
        HashMapParams.put("action", "0");
        return HashMapParams;
    }
}
