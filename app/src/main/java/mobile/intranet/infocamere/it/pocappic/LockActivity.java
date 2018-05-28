/*
 * Copyright (c)
 * Created by Luca Visentin - yyi4216
 * 28/05/18 16.49
 *
 */

package mobile.intranet.infocamere.it.pocappic;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import mobile.intranet.infocamere.it.pocappic.utils.UnlockerSettings;

public class LockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        AssetManager am = getAssets();
        InputStream is = null;
        try {
            is = am.open("ic_logo_app.png");
        } catch(IOException e) {
            e.printStackTrace();
        }

        ((ImageView)findViewById(R.id.logo_img)).setImageBitmap(BitmapFactory.decodeStream(is));

        findViewById(R.id.unlock_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView editText = findViewById(R.id.code_unlocker);
                String code = editText.getText().toString();
                if (UnlockerSettings.tryUnlock(LockActivity.this, code)){
                    startMainActivity();
                }
                else {
                    Toast.makeText(
                            LockActivity.this,
                            "Codice errato",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void startMainActivity() {
        startActivity(new Intent(this, DrawerNavMainActivity.class));
        finish();
    }
}
