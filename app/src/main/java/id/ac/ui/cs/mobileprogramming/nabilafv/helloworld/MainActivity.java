package id.ac.ui.cs.mobileprogramming.nabilafv.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text = findViewById(R.id.textWorld);
        final Button changeTextButton = findViewById(R.id.button);
        changeTextButton.setOnClickListener(new View.OnClickListener() {
            Boolean clicked = TRUE;
            public void onClick(View v) {
                if (clicked) {
                    text.setText("Bye World!");
                    clicked = FALSE;
                } else {
                    text.setText("Hello World!");
                    clicked = TRUE;
                }
            }
        });
    }
}