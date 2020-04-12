package mc.alequei.minittwitter.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import mc.alequei.minittwitter.R;

public class SingOup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_oup);
        //Oculta el bar
        getSupportActionBar().hide();
        
    }
}
