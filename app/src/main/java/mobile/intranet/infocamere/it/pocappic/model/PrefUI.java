package mobile.intranet.infocamere.it.pocappic.model;

import org.json.JSONException;
import org.json.JSONObject;

public class PrefUI {
    // Labels table name
    public static final String TABLE = "prefUI";

    // Labels Table Columns names
    public static final String KEY_ROWID = "_id";
    public static final String KEY_ID = "prefUI_id";
    public static final String KEY_ORDER = "order";

    // property help us to keep data
    public int _id;
    public int prefUI_id;
    public String order;

    public static String getTABLE() {
        return TABLE;
    }

    public static String getKeyRowid() {
        return KEY_ROWID;
    }

    public static String getKeyId() {
        return KEY_ID;
    }

    public static String getKeyOrder() {
        return KEY_ORDER;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getPrefUI_id() {
        return prefUI_id;
    }

    public void setPrefUI_id(int prefUI_id) {
        this.prefUI_id = prefUI_id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {

        return "PrefUI{" +
                "_id=" + _id +
                ", prefUI_id=" + prefUI_id +
                ", order='" + order + '\'' +
                '}';
    }

    public JSONObject toJSON() throws JSONException {

        JSONObject jo = new JSONObject();

        jo.put("_id", _id);
        jo.put("prefUI", prefUI_id);
        jo.put("order", order);

        return jo;
    }
}
