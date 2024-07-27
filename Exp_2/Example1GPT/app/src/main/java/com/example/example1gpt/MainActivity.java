package com.example.example1gpt;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.example1gpt.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean isHelloWorld = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_change_text) {
            if (isHelloWorld) {
                textView.setText(R.string.goodbye_world);
            } else {
                textView.setText(R.string.hello_world);
            }
            isHelloWorld = !isHelloWorld;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
