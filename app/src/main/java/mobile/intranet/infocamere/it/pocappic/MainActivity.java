package mobile.intranet.infocamere.it.pocappic;

import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;

import mobile.intranet.infocamere.it.pocappic.model.UserIC;
import mobile.intranet.infocamere.it.pocappic.utils.UserICRepo;

public class MainActivity extends AppCompatActivity {

    Cursor cursor;
    UserICRepo userICRepo;
    private final static String TAG = MainActivity.class.getName().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userICRepo = new UserICRepo(this);
        cursor = userICRepo.getUsersList();

        if(cursor == null) {
            insertDummy();
        }

        final RelativeLayout relPresenze = (RelativeLayout) findViewById(R.id.card_presenze);
        final RelativeLayout relTrasferte = (RelativeLayout) findViewById(R.id.card_trasferte);

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
                        MainActivity.this,"Long Click",
                        Toast.LENGTH_LONG).show();

                return true;
            }

        });

        // gestione click semplice
        relPresenze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent presenze = new Intent(
                        MainActivity.this, PresenzeActivity.class);
                startActivity(presenze);
            }
        });

    }

    private void insertDummy(){
        UserIC user = new UserIC();

        user.yyi = "yyi4216";
        user.email = "luca.visentin@infocamere.it";
        user.name = "Luca";
        user.surname = "Visentin";
        user.phone_fix = "8182";
        user.setPhone_mobile("3401594597");
        user.setSede("Padova");
        user.setCdr("20040");
        user.setMatricola("2019");
        user.setOffice("PD-423");
        userICRepo.insert(user);

        userICRepo = new UserICRepo(this);

        user.yyi = "yyi0866";
        user.email = "marina.angelini@infocamere.it";
        user.name = "Marina";
        user.surname = "Angelini";
        user.phone_fix = "8639";
        user.setPhone_mobile("3401594597");
        user.setSede("Padova");
        user.setCdr("20040");
        user.setOffice("PD-423");
        user.setMatricola("2019");
        userICRepo.insert(user);

        userICRepo = new UserICRepo(this);

        user.yyi = "yyi0791";
        user.email = "marzia.menegazzo@infocamere.it";
        user.name = "Marzia";
        user.surname = "Menegazzo";
        user.phone_fix = "8064";
        user.setPhone_mobile("3401594597");
        user.setSede("Padova");
        user.setCdr("20040");
        user.setOffice("PD-423");
        user.setMatricola("2019");
        userICRepo.insert(user);

        userICRepo = new UserICRepo(this);

        user.yyi = "yyi0192";
        user.email = "giovanni.secchiati@infocamere.it";
        user.name = "Giovanni";
        user.surname = "Secchiati";
        user.phone_fix = "8641";
        user.setPhone_mobile("3401594597");
        user.setSede("Padova");
        user.setCdr("20040");
        user.setMatricola("2019");
        user.setOffice("PD-423");
        userICRepo.insert(user);

        userICRepo = new UserICRepo(this);

        user.yyi = "yyi0939";
        user.email = "simonetta.finoli@infocamere.it";
        user.name = "Simonetta";
        user.surname = "Finoli";
        user.phone_fix = "8182";
        user.setPhone_mobile("3401594597");
        user.setSede("Padova");
        user.setCdr("20040");
        user.setOffice("PD-423");
        user.setMatricola("2019");
        userICRepo.insert(user);

        userICRepo = new UserICRepo(this);

        user.yyi = "yyi1152";
        user.email = "cristiana.trolio@infocamere.it";
        user.name = "Cristiana";
        user.surname = "Trolio";
        user.phone_fix = "8182";
        user.setPhone_mobile("3401594597");
        user.setSede("Padova");
        user.setCdr("20040");
        user.setMatricola("2019");
        user.setOffice("PD-423");
        userICRepo.insert(user);

        userICRepo = new UserICRepo(this);

        user.yyi = "yyi0869";
        user.email = "stefano.ferrari@infocamere.it";
        user.name = "Stefano";
        user.surname = "Ferrari";
        user.phone_fix = "8182";
        user.setPhone_mobile("3401594597");
        user.setSede("Padova");
        user.setCdr("20040");
        user.setOffice("PD-423");
        user.setMatricola("2019");
        userICRepo.insert(user);

        userICRepo = new UserICRepo(this);

        user.yyi = "yyi0785";
        user.email = "stefano.catullo@infocamere.it";
        user.name = "Stefano";
        user.surname = "Catullo";
        user.phone_fix = "8182";
        user.setPhone_mobile("3401594597");
        user.setSede("Padova");
        user.setOffice("PD-423");
        user.setCdr("20040");
        user.setMatricola("2019");
        userICRepo.insert(user);

        userICRepo = new UserICRepo(this);

        user.yyi = "yyi2096";
        user.email = "carmine.quitadamo@infocamere.it";
        user.name = "Carmine";
        user.surname = "Quitadamo";
        user.phone_fix = "8182";
        user.setPhone_mobile("3401594597");
        user.setSede("Padova");
        user.setCdr("20040");
        user.setOffice("PD-423");
        user.setMatricola("2019");
        userICRepo.insert(user);

        userICRepo = new UserICRepo(this);

        user.yyi = "yyi1063";
        user.email = "angela.costantino@infocamere.it";
        user.name = "Angela";
        user.surname = "Costantino";
        user.phone_fix = "5633";
        user.setPhone_mobile("3401594597");
        user.setSede("Padova");
        user.setCdr("20040");
        user.setOffice("PD-423");
        user.setMatricola("2019");
        userICRepo.insert(user);

        userICRepo = new UserICRepo(this);

        user.yyi = "yyi4408";
        user.email = "donato.altamura@infocamere.it";
        user.name = "Donato";
        user.surname = "Altamura";
        user.phone_fix = "8182";
        user.setPhone_mobile("3401594597");
        user.setOffice("PD-423");
        user.setSede("Padova");
        user.setCdr("20040");
        user.setMatricola("2019");
        userICRepo.insert(user);

        userICRepo = new UserICRepo(this);

        user.yyi = "yyi0080";
        user.email = "antonio.ometto@infocamere.it";
        user.name = "Antonio";
        user.surname = "Ometto";
        user.phone_fix = "8182";
        user.setPhone_mobile("3401594597");
        user.setOffice("PD-423");
        user.setSede("Padova");
        user.setCdr("20040");
        user.setMatricola("2019");
        userICRepo.insert(user);

        userICRepo = new UserICRepo(this);

        user.yyi = "yyi0567";
        user.email = "marina.tommasi@infocamere.it";
        user.name = "Marina";
        user.surname = "Tommasi";
        user.phone_fix = "8182";
        user.setPhone_mobile("3401594597");
        user.setSede("Padova");
        user.setOffice("PD-423");
        user.setCdr("20040");
        user.setMatricola("2019");
        userICRepo.insert(user);

        userICRepo = new UserICRepo(this);

        user.yyi = "yyi0675";
        user.email = "attilio.sfragara@infocamere.it";
        user.name = "Attilio";
        user.surname = "Sfragara";
        user.phone_fix = "8182";
        user.setPhone_mobile("3401594597");
        user.setSede("Padova");
        user.setCdr("20040");
        user.setOffice("PD-423");
        user.setMatricola("2019");
        userICRepo.insert(user);
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

            SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();
            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
            search.setSubmitButtonEnabled(true);

            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                @Override
                public boolean onQueryTextSubmit(String s) {
                    cursor = userICRepo.getUserListByKeyword(s);

                    if (cursor == null) {
                        Toast.makeText(
                                MainActivity.this,"No records found!",
                                Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(
                                MainActivity.this,
                                cursor.getCount() + " records found!",
                                Toast.LENGTH_LONG).show();
                    }
                    // customAdapter.swapCursor(cursor);
                    Log.i(TAG, "onQueryTextSubmit FINE TOAST");

                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    Log.i(TAG, "onQueryTextChange " + s);
                    cursor = userICRepo.getUserListByKeyword(s);
                    if (cursor != null) {
                        // customAdapter.swapCursor(cursor);
                    }
                    return false;
                }

            });

        }

        return true;
    }

    public void btnToOther_onClick(View view) {
        Intent other = new Intent(this, OtherActivity.class);
        startActivity(other);
    }

    public void cardPresenze_onClick(View view) {
        Intent presenze = new Intent(this, PresenzeActivity.class);
        startActivity(presenze);
    }

    public void enableNotsPresenze_onClick(View view) {
        Toast.makeText(MainActivity.this,
                "Disabilita Notifiche Presenze",
                Toast.LENGTH_SHORT).show();
    }
}
