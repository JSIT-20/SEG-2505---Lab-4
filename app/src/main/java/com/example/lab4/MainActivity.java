package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onOpenInGoogleMaps(View view){
        EditText teamAddress = (EditText) findViewById(R.id.address);

        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }

    public void onSetAvatarButton(View view){
        Intent intent = new Intent(getApplicationContext(), SetAvatar.class);
        startActivityForResult(intent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_CANCELED) return;

        ImageView avatarImage = (ImageView) findViewById(R.id.avatar);

        String drawableName = "ic_logo_00";
        switch(data.getIntExtra("imageID", R.id.image0)){
            case R.id.image0:
                drawableName = "ic_logo_00";
                break;
            case R.id.image1:
                drawableName = "ic_logo_01";
                break;
            case R.id.image2:
                drawableName = "ic_logo_02";
                break;
            case R.id.image3:
                drawableName = "ic_logo_03";
                break;
            case R.id.image4:
                drawableName = "ic_logo_04";
                break;
            case R.id.image5:
                drawableName = "ic_logo_05";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }

        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }




}