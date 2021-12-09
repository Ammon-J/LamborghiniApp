package com.example.lamborghiniapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lamborghiniapp.ui.collection.CollectionFragment;
import com.example.lamborghiniapp.ui.collection.CollectionViewModel;

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