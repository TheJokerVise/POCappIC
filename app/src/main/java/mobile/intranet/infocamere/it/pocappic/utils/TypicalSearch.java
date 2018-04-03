package mobile.intranet.infocamere.it.pocappic.utils;

/**
 * Created by LucaVise on 16/03/18.
 */

public class TypicalSearch {

    private boolean doCall;
    private String query;

    public TypicalSearch() {

    }

    public TypicalSearch(boolean doCall, String query) {
        this.doCall = doCall;
        this.query = query;
    }

    public boolean isDoCall() {
        return doCall;
    }

    public void setDoCall(boolean doCall) {
        this.doCall = doCall;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }


}
