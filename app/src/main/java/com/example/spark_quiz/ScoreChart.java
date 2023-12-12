package com.example.spark_quiz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class ScoreChart extends View {

    private int geography_score = 0;
    private int history_score = 0;
    private int science_score = 0;
    private int popculture_score = 0;

    private Paint paint;

    private TextView ratingTextView;

    public ScoreChart(Context context, AttributeSet attrs, int[] score) {
        super(context, attrs);

        paint = new Paint();
        ratingTextView = new TextView(context);
        ratingTextView.setTextSize(16);
        ratingTextView.setTextColor(Color.BLACK);
        ratingTextView.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        geography_score = score[0];
        history_score = score[1];
        science_score = score[2];
        popculture_score = score[3];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        int barWidth = width / 4;

        paint.setColor(Color.GREEN);
        canvas.drawRect(0, height - geography_score * (height / 5), barWidth, height, paint);

        paint.setColor(Color.RED);
        canvas.drawRect(barWidth, height - history_score * (height / 5), barWidth * 2, height, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawRect(barWidth * 2, height - science_score * (height / 5), barWidth * 3, height, paint);

        paint.setColor(Color.parseColor("#FFBAFF"));
        canvas.drawRect(barWidth * 3, height - popculture_score * (height / 5), barWidth * 4, height, paint);


        int overallScore = geography_score + history_score + science_score + popculture_score;


        setRatingText(overallScore);
    }

    private void setRatingText(int overallScore) {
        String rating;
        if (overallScore >= 18) {
            rating = "Excellent";
        } else if (overallScore >= 13) {
            rating = "Great";
        } else if (overallScore >= 8) {
            rating = "Good";
        } else {
            rating = "Needs Improvement";
        }

        ratingTextView.setText(rating);
        ratingTextView.layout(0, getHeight(), getWidth(), getHeight() + 50);
    }
}

