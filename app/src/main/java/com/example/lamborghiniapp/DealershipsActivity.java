package com.example.lamborghiniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lamborghiniapp.ui.main.MainFragment;

public class DealershipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dealerships_activity);
    }

    public void openHomePage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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
        Toast.makeText(getApplicationContext(), "You are already on the Dealership page", Toast.LENGTH_SHORT).show();
    }
}