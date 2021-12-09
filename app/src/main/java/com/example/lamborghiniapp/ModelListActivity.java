package com.example.lamborghiniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lamborghiniapp.ui.main.ModelListFragment;

public class ModelListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.model_list_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ModelListFragment.newInstance())
                    .commitNow();
        }
    }

    public void openHomePage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openModelPage(View view) {
        Toast.makeText(getApplicationContext(), "You are already on the Models page", Toast.LENGTH_SHORT).show();
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