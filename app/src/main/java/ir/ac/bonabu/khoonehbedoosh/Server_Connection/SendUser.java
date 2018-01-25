package ir.ac.bonabu.khoonehbedoosh.Server_Connection;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
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

import ir.ac.bonabu.khoonehbedoosh.G;
import ir.ac.bonabu.khoonehbedoosh.Splash;
import ir.ac.bonabu.khoonehbedoosh.User;

/**
 * Created by Abolfazl 7x on 1/25/2018.
 */

public class SendUser {


    boolean check = true;
    Context context;

    ProgressDialog progressDialog;


    String ServerUploadPath = "http://10.0.2.2/Php/kbd/test.php";
    User user;

    public SendUser(Context context,User user ) {
        this.user = user;

    }


    public void ImageUploadToServerFunction() {

        class AsyncTaskUploadClass extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {

                super.onPreExecute();

             //   progressDialog = ProgressDialog.show(context, "Image is Uploading", "Please Wait", false, false);
            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);

                // Dismiss the progress dialog after done uploading.
            //    progressDialog.dismiss();

                // Printing uploading success message coming from server on android app.
                Toast.makeText(G.context, string1+"", Toast.LENGTH_LONG).show();
                Log.w("Server","aa  "+string1);

                // Setting image as transparent after done uploading.


            }


            @Override
            protected String doInBackground(Void... params) {

                SendUser.ImageProcessClass imageProcessClass = new SendUser.ImageProcessClass();

                HashMap<String, String> HashMapParams = new HashMap<String, String>();
                HashMapParams.put("u[name]", user.getName());
                HashMapParams.put("u[lastname]", user.getLastname());
                HashMapParams.put("u[email]", user.getEmail());
                HashMapParams.put("u[username]", user.getUsername());
                HashMapParams.put("u[password]", user.getPassword());
                HashMapParams.put("u[phone]", user.getPhone());
                HashMapParams.put("u[nacode]", user.getNacode());

                String FinalData = imageProcessClass.ImageHttpRequest(ServerUploadPath, HashMapParams);

                return FinalData;
            }
        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();

        AsyncTaskUploadClassOBJ.execute();
    }

    public class ImageProcessClass {

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

                httpURLConnectionObject.setReadTimeout(19000);

                httpURLConnectionObject.setConnectTimeout(19000);

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
}
