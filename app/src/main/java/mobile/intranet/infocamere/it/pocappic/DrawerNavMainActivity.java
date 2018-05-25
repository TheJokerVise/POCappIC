package mobile.intranet.infocamere.it.pocappic;

import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mobile.intranet.infocamere.it.pocappic.model.ItemUI;
import mobile.intranet.infocamere.it.pocappic.model.ServiceIC;
import mobile.intranet.infocamere.it.pocappic.model.UserIC;
import mobile.intranet.infocamere.it.pocappic.utils.RVAdapter;
import mobile.intranet.infocamere.it.pocappic.utils.ServiceICRepo;
import mobile.intranet.infocamere.it.pocappic.utils.UserICRepo;

public class DrawerNavMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Cursor cursor;
    private UserICRepo userICRepo;
    private Cursor cursorSvcIC;
    private ServiceICRepo svcICRepo;
    private final static String TAG = DrawerNavMainActivity.class.getName().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_nav_main);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*
        Inizia la costruzione del contenuto della pagina
         */
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

        /*
        Gestione inserimento utenti
         */
        userICRepo = new UserICRepo(this);
        cursor = userICRepo.getUsersList();
        if(cursor == null) {
            insertDummy();
        }

        /*
        Gestione inserimento Servici IC
         */
        svcICRepo = new ServiceICRepo(this);
        cursorSvcIC = svcICRepo.getServiceICList();
        if (cursorSvcIC == null) {
            insertServicesIC();
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

    private void insertServicesIC() {
        ServiceIC svcIC = new ServiceIC();
        svcIC.setSvcId("1");
        svcIC.setSvcName("Presenze");
        svcIC.setSvcVisible(true);
        svcICRepo.insert(svcIC);

        svcIC = new ServiceIC();
        svcIC.setSvcId("2");
        svcIC.setSvcName("Trasferte");
        svcIC.setSvcVisible(true);
        svcICRepo.insert(svcIC);

        svcIC = new ServiceIC();
        svcIC.setSvcId("3");
        svcIC.setSvcName("News");
        svcIC.setSvcVisible(true);
        svcICRepo.insert(svcIC);

        svcIC = new ServiceIC();
        svcIC.setSvcId("4");
        svcIC.setSvcName("Uscita");
        svcIC.setSvcVisible(true);
    }

    private List<ItemUI> generateItemUi() {

        Cursor c = svcICRepo.getServiceICList();
        ServiceIC svc = new ServiceIC();

        if (c.moveToFirst()) {
            do {
                svc.setSvcId(c.getString(c.getColumnIndex(ServiceIC.KEY_ID)));
                svc.setSvcName(c.getString(c.getColumnIndex(ServiceIC.KEY_serviceName)));
                svc.setSvcVisible(
                        c.getInt(c.getColumnIndex(ServiceIC.KEY_serviceVisible)) > 0);
            } while (c.moveToNext());
        }


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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_nav_main, menu);

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
