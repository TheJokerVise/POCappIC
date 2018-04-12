package mobile.intranet.infocamere.it.pocappic.utils;

import android.util.Log;

/**
 * Created by LucaVise on 16/03/18.
 */

public class GeneralUtils {

    public TypicalSearch getTypicalSearch(String originalQuery) {

        TypicalSearch typicalSearch = new TypicalSearch();

        if (originalQuery.toLowerCase().contains("chiama")) {
            typicalSearch.setDoCall(true);
            String wrapQuery = originalQuery.replace("chiama", "").trim();
            wrapQuery = wrapQuery.replace("Chiama", "").trim();
            typicalSearch.setQuery(wrapQuery);
        }
        else {
            typicalSearch.setDoCall(false);
            typicalSearch.setQuery(originalQuery);
        }

        return typicalSearch;
    }

    public static String[] getOrderLayouts(String orderUI) {
        String[] orderLayouts = orderUI.split("-");

        return orderLayouts;
    }
}