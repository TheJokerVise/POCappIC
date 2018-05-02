package mobile.intranet.infocamere.it.pocappic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mobile.intranet.infocamere.it.pocappic.model.ItemUI;
import mobile.intranet.infocamere.it.pocappic.utils.RVAdapter;


public class OtherActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


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

        /*
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
        */

        return itemUIModelList;
    }


}