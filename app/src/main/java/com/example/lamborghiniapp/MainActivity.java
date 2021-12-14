package com.example.lamborghiniapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.lamborghiniapp.databinding.MainActivityBinding;
import com.example.lamborghiniapp.databinding.MainFragmentBinding;
import com.example.lamborghiniapp.ui.collection.CollectionViewModel;
import com.example.lamborghiniapp.ui.main.MainFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
        homeBtn = findViewById(R.id.homeBtn);
    }

    public void openHomePage(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
    public void openModelPage(View view) {
        Intent intent = new Intent(this, ModelListActivity.class);
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
}