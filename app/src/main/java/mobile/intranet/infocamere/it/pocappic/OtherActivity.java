package mobile.intranet.infocamere.it.pocappic;

import android.app.SearchManager;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import mobile.intranet.infocamere.it.pocappic.model.ItemUI;
import mobile.intranet.infocamere.it.pocappic.utils.ItemUIAdapter;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        /*
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PresenceFragment fragment = new PresenceFragment();
        fragmentTransaction.add(R.id.presence_container, fragment);
        fragmentTransaction.commit();
        */

        ItemUIAdapter adapter = new ItemUIAdapter(generateSimpleList());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_itemUI);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    public void btnOpenSearch_onClick(View view) {
        onSearchRequested();
    }

    private List<ItemUI> generateSimpleList() {

        List<ItemUI> itemUIModelList = new ArrayList<>();
        ItemUI itemUI = null;

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                itemUI = new ItemUI("#33ccff", "item_" + i, "Profilo Item " + i,
                        "ITEM ITEM " + i, "Lorem ipsum dolor acta dado ciauuu", "");
            }
            else if (i == 1) {
                itemUI = new ItemUI("#009933", "item_" + i, "Profilo Item " + i,
                        "ITEM ITEM " + i, "Lorem ipsum dolor acta dado ciauuu", "");
            }
            else if (i == 2) {
                itemUI = new ItemUI("#ff0066", "item_" + i, "Profilo Item " + i,
                        "ITEM ITEM " + i, "Lorem ipsum dolor acta dado ciauuu", "");
            }
            else if (i == 3) {
                itemUI = new ItemUI("#666699", "item_" + i, "Profilo Item " + i,
                        "ITEM ITEM " + i, "Lorem ipsum dolor acta dado ciauuu", "");
            }
            else if (i == 4) {
                itemUI = new ItemUI("#00cc99", "item_" + i, "Profilo Item " + i,
                        "ITEM ITEM " + i, "Lorem ipsum dolor acta dado ciauuu", "");
            }
            else if (i == 5) {
                itemUI = new ItemUI("#9999ff", "item_" + i, "Profilo Item " + i,
                        "ITEM ITEM " + i, "Lorem ipsum dolor acta dado ciauuu", "");
            }
            else if (i == 6) {
                itemUI = new ItemUI("#000066", "item_" + i, "Profilo Item " + i,
                        "ITEM ITEM " + i, "Lorem ipsum dolor acta dado ciauuu", "");
            }
            else if (i == 7) {
                itemUI = new ItemUI("#990099", "item_" + i, "Profilo Item " + i,
                        "ITEM ITEM " + i, "Lorem ipsum dolor acta dado ciauuu", "");
            }
            else if (i == 8) {
                itemUI = new ItemUI("#669900", "item_" + i, "Profilo Item " + i,
                        "ITEM ITEM " + i, "Lorem ipsum dolor acta dado ciauuu", "");
            }
            else if (i == 9) {
                itemUI = new ItemUI("#ff9966", "item_" + i, "Profilo Item " + i,
                        "ITEM ITEM " + i, "Lorem ipsum dolor acta dado ciauuu", "");
            }

            itemUIModelList.add(itemUI);
        }

        return itemUIModelList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

}