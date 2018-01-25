package ir.ac.bonabu.khoonehbedoosh.Server_Connection;


        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;

        import android.media.ExifInterface;
        import android.net.Uri;
        import android.os.Build;
        import android.os.Bundle;
        import android.provider.MediaStore;
        import android.support.v4.content.FileProvider;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

        import android.widget.ImageView;

        import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;

        import java.io.File;
        import java.io.IOException;
        import java.text.SimpleDateFormat;
        import java.util.Date;

        import ir.ac.bonabu.khoonehbedoosh.G;
        import ir.ac.bonabu.khoonehbedoosh.R;


public class CameraHandeller extends Activity {
    private ImageView imageResult = null;
    private ImageView fullImage;
    private Button camera, gallery;
    final int CAMERA_REQUEST = 55;
    final int GALLERY_REQUEST = 66;
    private String currentImgPath, choiceUri;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        imageResult = (ImageView) findViewById(R.id.result);
        fullImage = (ImageView) findViewById(R.id.full_Image);

        camera = (Button) findViewById(R.id.camera);
        gallery = (Button) findViewById(R.id.gallery);

        //// Buttons Click
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cameraOnClick();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                galleyOnClick();
            }
        });
        imageResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bitmap != null) {
                    fullImage.setOnTouchListener(new ImageMatrixTouchHandler(CameraHandeller.this));
                    fullImage.setImageBitmap(bitmap);
                    fullImage.setVisibility(View.VISIBLE);
                }

            }


        });
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bitmap != null) {
                    Uploder uploder = new Uploder(CameraHandeller.this,bitmap);
                    uploder.setAddress("Adppppppppp");
                    uploder.setDisc("sdsdsoooooo");
                    uploder.ImageUploadToServerFunction();
                }
            }

        });
    }


    private void cameraOnClick() throws IOException {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        String imgName = "Salamat" + System.currentTimeMillis() + ".jpg";
//        Uri uri=Uri.fromFile(new File(G.imageDir+"/"+imgName));

        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, createImageFile());
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }

    private Uri createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
        Log.i("f", timeStamp + "");
        String imageFileName = "JPEG_" + timeStamp;
        File storageDir = new File(G.imageDir);

        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentImgPath = image.getAbsolutePath();
//        return image;
        if (Build.VERSION.SDK_INT > 21) {
            return FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", image);
        } else {
            return Uri.fromFile(image);
        }
    }

    private void addPicToGallery() {
        Intent addGIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File file = new File(currentImgPath);
        Uri uri = Uri.fromFile(file);
        addGIntent.setData(uri);
        this.sendBroadcast(addGIntent);
    }

    private void galleyOnClick() {
        Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(galleryIntent, "Select App "), GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAMERA_REQUEST:
                if (resultCode == RESULT_OK) {
                    addPicToGallery();
                    bitmap = BitmapFactory.decodeFile(currentImgPath);
                    imageResult.setRotation(-90);
                    imageResult.setImageBitmap(bitmap);

                }
                break;
            case GALLERY_REQUEST:
                if (resultCode == RESULT_OK && data != null && data.getData() != null) {
                    Uri uri = data.getData();
                    try {
                        imageResult.setRotation(90);
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        imageResult.setImageBitmap(bitmap);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                break;

        }

    }

    @Override
    public void onBackPressed() {

        if (fullImage.getVisibility() == View.VISIBLE) {
            fullImage.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }

    }
}