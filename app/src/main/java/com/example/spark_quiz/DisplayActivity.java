package com.example.spark_quiz;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    SApp application;
    ScoreChart sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        application = (SApp) getApplication();
        ScoreChart scr = findViewById(R.id.scorechart);
        this.sc = scr;
        sc.setScore(application.getScore());


        TextView txt = findViewById(R.id.textView);
        txt.setText("Your Score: " + (application.getScore()[0] + application.getScore()[1] + application.getScore()[2] + application.getScore()[3]) + "/20");

        Button main_menu = findViewById(R.id.menu_btn);
        main_menu.setOnClickListener(v-> {
            Intent intent = new Intent(DisplayActivity.this, HomeActivity.class);
            application.setScore(new int[4]);
            application.setAnswers(new byte[20]);
            application.setFetched(false);
            application.setQuestions(new ArrayList<>());
            startActivity(intent);

            finish();
        }
        );

        Button try_again = findViewById(R.id.again_btn);
        try_again.setOnClickListener(v->{
            Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
            application.setAnswers(new byte[20]);
            startActivity(intent);

            finish();
        });

        Button share = findViewById(R.id.share_btn);
        share.setOnClickListener(v -> {
            Bitmap bitmap = Bitmap.createBitmap(sc.getWidth(), sc.getHeight() , Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(Color.WHITE);
            sc.draw(canvas);

            String cachePath = this.getCacheDir() + "/score.jpg";
            try (FileOutputStream fos = new FileOutputStream(cachePath)) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Uri contentUri = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".fileprovider", new File(cachePath));

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("image/jpeg");

            shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            shareIntent.putExtra(Intent.EXTRA_TEXT, "HELLO DUMBFUCK! COME TRY THIS APP TO TEST YOUR KNOWLEDGE YOU STUPID COCKSUCKER!!!");
            this.startActivity(Intent.createChooser(shareIntent, "Share Score"));

        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
            }
        });



    }



}