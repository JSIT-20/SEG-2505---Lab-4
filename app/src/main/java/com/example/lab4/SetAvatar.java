package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;

public class SetAvatar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_avatar);
    }

    public void setTeamIcon(View view){

        Intent returnIntent = new Intent();

        ImageView selectedImage = (ImageView) view;

        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);

        finish();
    }
}