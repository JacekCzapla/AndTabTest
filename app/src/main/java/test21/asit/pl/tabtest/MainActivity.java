package test21.asit.pl.tabtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_onClicked(View view)
    {
        Intent i = new Intent(MainActivity.this, TabActivity.class);
        startActivity(i);
    }
}
