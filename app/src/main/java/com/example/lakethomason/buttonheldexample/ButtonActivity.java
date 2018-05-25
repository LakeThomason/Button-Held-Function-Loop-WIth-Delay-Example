package com.example.lakethomason.buttonheldexample;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ButtonActivity extends AppCompatActivity {

    TextView buttonText;
    Button button;
    int counter;

    boolean buttonIsDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        button = (Button) this.findViewById(R.id.button);
        buttonText = (TextView) this.findViewById(R.id.textView);
        counter = 0;

        buttonIsDown = false;

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonIsDown = false;
                    return true;
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonIsDown = true;
                    final Handler handler = new Handler();
                    final Runnable myRunnable = new Runnable() {
                        @Override
                        public void run() {
                            incrementButtonText(v);
                            if (buttonIsDown) {
                                handler.postDelayed(this, 100);  // 1 second delay
                            }
                        }
                    };
                    myRunnable.run();
                    return true;
                }
                return false;
            }
        });
    }

    public void incrementButtonText(View v) {
        buttonText.setText(String.valueOf(++counter));
    }
}
