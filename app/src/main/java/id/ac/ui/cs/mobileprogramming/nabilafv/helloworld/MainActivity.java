package id.ac.ui.cs.mobileprogramming.nabilafv.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private ImageButton startBtn, resetBtn;
    private Button exitBtn;

    private long timeWhenStopped = 0;
    private boolean isResume, isRunning, wasRunning;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                int h = (int)(time/3600000);
                int m = (int)(time-h*3600000)/60000;
                int s = (int)(time-h*3600000-m*60000)/1000;
                String t = (h < 10 ? "0"+h: h)+":"+(m < 10 ? "0"+m: m)+":"+ (s < 10 ? "0"+s: s);
                chronometer.setText(t);
            }
        });

        startBtn = findViewById(R.id.bt_start);
        resetBtn = findViewById(R.id.bt_stop);
        exitBtn = findViewById(R.id.bt_exit);

        if (savedInstanceState != null) {
            chronometer.setBase(savedInstanceState.getLong("ChronoTime"));
            chronometer.setText(savedInstanceState.getString("ChronoText"));
            timeWhenStopped = savedInstanceState.getLong("timeWhenStopped");
            isResume = savedInstanceState.getBoolean("isResume");
            isRunning = savedInstanceState.getBoolean("isRunning");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        } else {
            chronometer.setBase(SystemClock.elapsedRealtime());
        }

        if (isResume) {
            resetBtn.setVisibility(View.GONE);
            startBtn.setImageDrawable((getResources().getDrawable(R.drawable.ic_pause)));
            chronometer.start();
        } else {
            resetBtn.setVisibility(View.VISIBLE);
            startBtn.setImageDrawable((getResources().getDrawable(R.drawable.ic_play)));
            chronometer.stop();
        }

        handler = new Handler();

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isResume) {
                    isResume = true;
                    isRunning = true;
                    handler.post(runnable);
                    resetBtn.setVisibility(View.GONE);
                    startBtn.setImageDrawable((getResources().getDrawable(R.drawable.ic_pause)));
                } else {
                    isResume = false;
                    isRunning = false;
                    handler.removeCallbacks(runnable);
                    timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
                    chronometer.stop();
                    resetBtn.setVisibility(View.VISIBLE);
                    startBtn.setImageDrawable((getResources().getDrawable(R.drawable.ic_play)));
                }
            }
//            @Override
//            public void onClick(View v) {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (!isRunning) {
//                            chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
//                            chronometer.start();
//                            isRunning = true;
//                            resetBtn.setVisibility(View.GONE);
//                            startBtn.setImageDrawable((getResources().getDrawable(R.drawable.ic_pause)));
//                        } else {
//                            handler.removeCallbacks(this);
//                            timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
//                            chronometer.stop();
//                            isRunning = false;
//                            resetBtn.setVisibility(View.VISIBLE);
//                            startBtn.setImageDrawable((getResources().getDrawable(R.drawable.ic_play)));
//                        }
//                    }
//                });
//
//            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isResume) {
                    isRunning = false;
                    handler.removeCallbacks(runnable);
                    startBtn.setImageDrawable((getResources().getDrawable(R.drawable.ic_play)));
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    timeWhenStopped = 0;
                    chronometer.stop();
                }
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (isRunning) {
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
            }
        }
    };

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putLong("ChronoTime", chronometer.getBase());
        savedInstanceState.putString("ChronoText", (String) chronometer.getText());
        savedInstanceState.putLong("timeWhenStopped", timeWhenStopped);
        savedInstanceState.putBoolean("isResume", isResume);
        savedInstanceState.putBoolean("isRunning", isRunning);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            isRunning = true;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = isRunning;
        isRunning = isResume;
    }

    @Override
    protected void onStop() {
        super.onStop();
        wasRunning = isRunning;
        isRunning = isResume;
    }

    @Override
    public void onBackPressed()
    {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text_toast);
        text.setText("Please click exit button to exit");

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
};