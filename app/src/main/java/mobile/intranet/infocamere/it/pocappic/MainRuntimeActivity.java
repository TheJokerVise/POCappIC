package mobile.intranet.infocamere.it.pocappic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by LucaVise on 11/04/18.
 */

public class MainRuntimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_runtime);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.containerTotal);

        // PRESENZE
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        RelativeLayout layoutPresenze = (RelativeLayout) inflater.inflate(
                R.layout.layout_presenze, null, false);

        rl.addView(layoutPresenze);

        // TRASFERTE
        RelativeLayout layoutTrasferte = (RelativeLayout) inflater.inflate(
                R.layout.layout_trasferte, null, false);
        rl.addView(layoutTrasferte);


        final RelativeLayout relPresenze = (RelativeLayout) findViewById(R.id.card_presenze);
        final RelativeLayout relTrasferte = (RelativeLayout) findViewById(R.id.card_trasferte);

        RelativeLayout.LayoutParams paramsTrasferte =
                (RelativeLayout.LayoutParams) relTrasferte.getLayoutParams();

        RelativeLayout.LayoutParams paramsPresenze =
                (RelativeLayout.LayoutParams) relPresenze.getLayoutParams();
                /*
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        */

        // paramsTrasferte.removeRule(RelativeLayout.BELOW);
        // relTrasferte.setLayoutParams(paramsTrasferte);

        paramsTrasferte.addRule(RelativeLayout.BELOW, R.id.card_presenze);
        relTrasferte.setLayoutParams(paramsTrasferte);

        // gestione long click
        relPresenze.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {

                RelativeLayout.LayoutParams paramsTrasferte =
                        (RelativeLayout.LayoutParams) relTrasferte.getLayoutParams();

                RelativeLayout.LayoutParams paramsPresenze =
                        (RelativeLayout.LayoutParams) relPresenze.getLayoutParams();
                /*
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                */

                paramsTrasferte.removeRule(RelativeLayout.BELOW);
                relTrasferte.setLayoutParams(paramsTrasferte);

                paramsPresenze.addRule(RelativeLayout.BELOW, R.id.card_trasferte);
                relPresenze.setLayoutParams(paramsPresenze);

                Toast.makeText(
                        MainRuntimeActivity.this,"Long Click",
                        Toast.LENGTH_LONG).show();

                return true;
            }

        });

        // gestione click semplice
        relPresenze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent presenze = new Intent(
                        MainRuntimeActivity.this, PresenzeActivity.class);
                startActivity(presenze);
            }
        });

    }
}
