/*
 * Copyright (c)
 * Created by Luca Visentin - yyi4216
 * 28/05/18 14.53
 *
 */

package mobile.intranet.infocamere.it.pocappic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Intent intent = new Intent(getApplicationContext(),
                LockActivity.class);
        startActivity(intent);
        finish();
    }
}