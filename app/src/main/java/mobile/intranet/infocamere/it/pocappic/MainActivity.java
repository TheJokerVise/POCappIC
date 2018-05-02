package mobile.intranet.infocamere.it.pocappic;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mobile.intranet.infocamere.it.pocappic.model.ItemUI;
import mobile.intranet.infocamere.it.pocappic.model.PrefUI;
import mobile.intranet.infocamere.it.pocappic.model.UserIC;
import mobile.intranet.infocamere.it.pocappic.utils.GeneralUtils;
import mobile.intranet.infocamere.it.pocappic.utils.PrefUIRepo;
import mobile.intranet.infocamere.it.pocappic.utils.RVAdapter;
import mobile.intranet.infocamere.it.pocappic.utils.UserICRepo;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Cursor cursor;
    private UserICRepo userICRepo;
    private final static String TAG = MainActivity.class.getName().toString();


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        RVAdapter adapter = new RVAdapter(generateItemUi());
        mRecyclerView.setAdapter(adapter);

        userICRepo = new UserICRepo(this);
        cursor = userICRepo.getUsersList();

        if(cursor == null) {
            insertDummy();
        }
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

    private List<ItemUI> generateItemUi() {

        List<ItemUI> itemUIModelList = new ArrayList<>();
        ItemUI itemUI = null;

        itemUI = new ItemUI("#393185", "item_1", "Il mio profilo",
                "Presenze", "Gestisci il tuo foglio presenze. Tocca per vedere " +
                "timbrature, anomalie, salidi e giustificativi.", "tempo2");

        itemUIModelList.add(itemUI);

        itemUI = new ItemUI("#E83E00", "item_2", "Il mio profilo",
                "Trasferte", "", "trasferte");

        itemUIModelList.add(itemUI);

        itemUI = new ItemUI("#496A8D", "item_2", "Il mio profilo",
                "Trasferte", "", "trasferte");

        itemUIModelList.add(itemUI);

        itemUI = new ItemUI("#3F9CDC", "item_2", "Il mio profilo",
                "Trasferte", "", "trasferte");

        itemUIModelList.add(itemUI);

        return itemUIModelList;
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



    @Override
    public void onResume(){
        super.onResume();
    }

        /*
    Cursor cursor;
    UserICRepo userICRepo;
    Cursor cursorPref;
    PrefUIRepo prefUIRepo;
    private final static String TAG = MainActivity.class.getName().toString();
    String[] orderLayouts = null;
    PrefUI prefUI = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userICRepo = new UserICRepo(this);
        cursor = userICRepo.getUsersList();
        prefUIRepo = new PrefUIRepo(this);
        cursorPref = prefUIRepo.getPrefUIList();

        if(cursor == null) {
            insertDummy();
        }

        if (cursorPref == null) {
            Log.i("insert PREFUI","INSERT PREFUI");
            insertPrefUI();
            orderLayouts = GeneralUtils.getOrderLayouts("1-2");
        }
        else {
            Log.i("PREFUI","Leggo PREFUI");
            prefUI = prefUIRepo.getPrefUIById(0);
            orderLayouts = GeneralUtils.getOrderLayouts(prefUI.getOrderUI());
        }

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.containerTotal);
        LayoutInflater inflater = null;
        RelativeLayout layoutPresenze = null;
        RelativeLayout layoutTrasferte = null;
        RelativeLayout.LayoutParams paramsTrasferte, paramsPresenze = null;

        inflater = LayoutInflater.from(getApplicationContext());
        layoutPresenze = (RelativeLayout) inflater.inflate(
                R.layout.layout_presenze, null, false);
        layoutTrasferte = (RelativeLayout) inflater.inflate(
                R.layout.layout_trasferte, null, false);

        /*
        rl.addView(layoutPresenze);
        rl.addView(layoutTrasferte);
        */

    /*
    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.i("ONSTART", "ONSTART");
        final RelativeLayout relPresenze = (RelativeLayout) findViewById(R.id.card_presenze);
        final RelativeLayout relTrasferte = (RelativeLayout) findViewById(R.id.card_trasferte);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.containerTotal);
        LayoutInflater inflater = null;
        RelativeLayout layoutPresenze = null;
        RelativeLayout layoutTrasferte = null;
        RelativeLayout.LayoutParams paramsTrasferte, paramsPresenze = null;
        String previous = "";

        for (int i=0; i<orderLayouts.length; i++) {
            Log.i("Dentro al FOR", "DENTRO AL FOR " + orderLayouts[i]);
            if (orderLayouts[i].trim().equals("1")) {
                Log.i("Dentro al FOR", "Presenze manager");
                // PRESENZE

                if (previous != "") {
                    if (previous.equals("2")) {
                        Log.i("Dentro al FOR", "So che prima di me ci sono le trasferte");
                        paramsPresenze =
                                (RelativeLayout.LayoutParams) relPresenze.getLayoutParams();
                        paramsPresenze.addRule(RelativeLayout.BELOW, R.id.card_trasferte);
                        relPresenze.setLayoutParams(paramsPresenze);
                    }
                }
            }
            else if (orderLayouts[i].trim().equals("2")) {
                Log.i("Dentro al FOR", "Trasferte manager");
                // TRASFERTE

                if (previous != "") {
                    if (previous.equals("1")) {
                        Log.i("Dentro al FOR", "So che prima di me ci sono le presenze");
                        paramsTrasferte =
                                (RelativeLayout.LayoutParams) relTrasferte.getLayoutParams();
                        paramsTrasferte.addRule(RelativeLayout.BELOW, R.id.card_presenze);
                        relTrasferte.setLayoutParams(paramsTrasferte);
                    }
                }
            }
            previous = orderLayouts[i];
        }

        // gestione long click
        relPresenze.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder adb;
                adb = new AlertDialog.Builder(MainActivity.this);

                adb.setTitle("Gestisci la tua sezione PRESENZE");
                // N.B. non usare setMessage altrimenti setItems non funziona
                // (uno esclude l'altro)

                final String[] opzioni = {"Sposta sotto", "Sposta sopra", "Nascondi sezione"};

                adb.setItems(opzioni, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(
                                getApplicationContext(),
                                "Hai scelto l'opzione " + opzioni[i] + " n. " + i,
                                Toast.LENGTH_SHORT).show();

                        if (true) {
                            RelativeLayout.LayoutParams paramsTrasferte =
                                    (RelativeLayout.LayoutParams) relTrasferte.getLayoutParams();

                            RelativeLayout.LayoutParams paramsPresenze =
                                    (RelativeLayout.LayoutParams) relPresenze.getLayoutParams();

                            paramsTrasferte.removeRule(RelativeLayout.BELOW);
                            relTrasferte.setLayoutParams(paramsTrasferte);

                            paramsPresenze.addRule(RelativeLayout.BELOW, R.id.card_trasferte);
                            relPresenze.setLayoutParams(paramsPresenze);
                        }
                    }
                });

                adb.create().show();

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

        relTrasferte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent other = new Intent(
                        MainActivity.this, OtherActivity.class);
                startActivity(other);
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

    public void insertPrefUI() {
        PrefUI prefUI = new PrefUI();
        prefUI.prefUI_id = 1;
        prefUI.orderUI = "1-2";
        prefUIRepo.insert(prefUI);
    }

    private List<ItemUI> generateItemUi() {

        List<ItemUI> itemUIModelList = new ArrayList<>();
        ItemUI itemUI = null;

        itemUI = new ItemUI("#393185", "item_1", "Il mio profilo",
                "Presenze", "Gestisci il tuo foglio presenze. Tocca per vedere " +
                "timbrature, anomalie, salidi e giustificativi.", "tempo2");

        itemUIModelList.add(itemUI);

        itemUI = new ItemUI("#9999ff", "item_2", "Il mio profilo",
                "Trasferte", "", "trasferte");

        itemUIModelList.add(itemUI);

        return itemUIModelList;
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
    */

}
