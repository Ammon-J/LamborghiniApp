package com.example.lamborghiniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;

import com.example.lamborghiniapp.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }

    public void openModelPage(View view) {
        Intent intent = new Intent(this, ModelsActivity.class);
        startActivity(intent);
    }

    public void openCollectionPage(View view) {
        Intent intent = new Intent(this, CollectionActivity.class);
        startActivity(intent);
    }

    public void openDealershipsPage(View view) {
        Intent intent = new Intent(this, DealershipsActivity.class);
        startActivity(intent);
    }

    public void openMapsPage(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}