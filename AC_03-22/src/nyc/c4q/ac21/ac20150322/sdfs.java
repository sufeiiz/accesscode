package nyc.c4q.ac21.ac20150322;

import com.oracle.javafx.jmx.json.JSONException;

/**
 * Created by sufeizhao on 6/28/15.
 */
public class sdfs {
    public static void main(String[] args) throws JSONException {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("_id", "sdfs");
        jsonObj.put("pop", "sdfs");
        jsonObj.put("city", "sdfs");
        jsonObj.put("state", "sdfs");
        jsonObj.put("loc", "sdfs");

        String json = jsonObj.toString();
        System.out.println(json);

    }
}
