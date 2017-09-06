package kiilian.android.apiretorno;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import kiilian.android.apiretorno.Adapters.GiraAdapter;
import kiilian.android.apiretorno.Datas.GirasDataRest;
import kiilian.android.apiretorno.Models.Giras;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.message.BasicHeader;

import static com.loopj.android.http.AsyncHttpClient.log;

public class MainActivity extends AppCompatActivity {

    private ListView giraList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getGiras();
    }

    private void getGiras() {
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Accept", "application/json"));

        GirasDataRest.get(MainActivity.this, "webapi/api/atualizacao", headers.toArray(new Header[headers.size()]),
                null, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        ArrayList<Giras> giraArray = new ArrayList<Giras>();
                        GiraAdapter noteAdapter = new GiraAdapter(MainActivity.this, giraArray);

                        for (int i = 0; i < response.length(); i++) {
                                try {
                                    //noteAdapter.add(new Giras(response.get(0).getString("Eventos")));

                                    noteAdapter.add(new Giras(response.getJSONObject(i))); //.getJSONObject("Eventos")
                                    //noteAdapter.add(new Giras((JSONObject) response.getJSONObject(i).keys()));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }


                        giraList = (ListView) findViewById(R.id.list_giras);
                        giraList.setAdapter(noteAdapter);
                    }
                });
    }
}
