package mobile.intranet.infocamere.it.pocappic;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class ScrollingProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView nameSurname = (TextView) findViewById(R.id.txt_nameSurnameUserIC);
        TextView email = (TextView) findViewById(R.id.txt_emailUserIC);
        TextView phoneMobile = (TextView) findViewById(R.id.txtPhoneMobile);
        TextView phoneFix = (TextView) findViewById(R.id.txtPhoneFix);
        TextView cdr = (TextView) findViewById(R.id.txtCdr);
        TextView matricola = (TextView) findViewById(R.id.txtMatricola);
        TextView office = (TextView) findViewById(R.id.txtOffice);
        TextView sede = (TextView) findViewById(R.id.txtSede);
        JSONObject json = null;
        String data = getIntent().getStringExtra("jsonData");

        try {
            json = new JSONObject(data);
            nameSurname.setText(json.getString("name") + " " +
                    json.getString("surname"));
            email.setText(json.getString("email"));
            phoneFix.setText(json.getString("phoneFix"));
            phoneMobile.setText(json.getString("phoneMobile"));
            cdr.setText(json.getString("cdr"));
            matricola.setText(json.getString("matricola"));
            office.setText(json.getString("office"));
            sede.setText(json.getString("sede"));
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
