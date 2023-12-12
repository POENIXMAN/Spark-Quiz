package com.example.spark_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(v -> {
            if (isConnectedToWifi()) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                showWifiAlertDialog();
            }

        });
    }

    private boolean isConnectedToWifi() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI && networkInfo.isConnected();
        }
        return false;
    }


    private void showWifiAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("No Wi-Fi Connection");
        builder.setMessage("Please connect to Wi-Fi to proceed.");
        builder.setPositiveButton("OK", (dialog, which) -> {
            // Handle the "OK" button click (if needed)
        });
        builder.setCancelable(false);
        builder.show();
    }
}