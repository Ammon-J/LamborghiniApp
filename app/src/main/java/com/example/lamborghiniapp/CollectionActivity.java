package com.example.lamborghiniapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lamborghiniapp.ui.collection.CollectionFragment;
import com.example.lamborghiniapp.ui.collection.CollectionViewModel;
import com.example.lamborghiniapp.ui.main.MainFragment;

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CollectionFragment.newInstance())
                    .commitNow();
        }
    }

    public void openHomePage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openModelPage(View view) {
        Intent intent = new Intent(this, ModelListActivity.class);
        startActivity(intent);
    }

    public void openCollectionPage(View view) {
        Toast.makeText(getApplicationContext(), "You are are already on the Collection page", Toast.LENGTH_SHORT).show();
    }

    public void openDealershipsPage(View view) {
        Intent intent = new Intent(this, DealershipsActivity.class);
        startActivity(intent);
    }
}