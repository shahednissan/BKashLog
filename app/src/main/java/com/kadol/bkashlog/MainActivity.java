package com.kadol.bkashlog;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static String READ_SMS= Manifest.permission.READ_SMS;
    private int MY_REQUEST_GRANTED_CODE=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askingPermission();

    }

    private void askingPermission() {

        if(ContextCompat.checkSelfPermission(getApplicationContext(),READ_SMS)!= PackageManager.PERMISSION_GRANTED){
            //the permission is not granted
            ActivityCompat.requestPermissions(this,new String[]{READ_SMS},MY_REQUEST_GRANTED_CODE);
        } else {
            //Let the user know it is a contact app and without the permission it will not work
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case 123:{

                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    //user has given the permission
                }else{
                    //Let the user know it is a contact app and without the permission it will not work
                }

                return;
            }
        }
    }
}
