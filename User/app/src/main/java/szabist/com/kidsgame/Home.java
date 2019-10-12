package szabist.com.kidsgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import szabist.com.kidsgame.Model.Items;


public class Home extends AppCompatActivity {

    ImageView img;
    Items[] itemses = new Items[0];

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        jsonData1();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter=new RecyclerAdapter(itemses);
        layoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);

    }
    public void jsonData1 () {
        RequestQueue queue = Volley.newRequestQueue(this);
            String url = "https://api.myjson.com/bins/67x9v";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                        JSONObject json = null;
                        JSONArray results = null;
                        try {
                            json = new JSONObject(response);
                            results = json.getJSONArray("items");
                            itemses = new Items[11];
                            for (int i = 0; i < results.length(); i++) {
                                int id = results.getJSONObject(i).getInt("id");
                                String name = results.getJSONObject(i).getString("name");
                                String picture = results.getJSONObject(i).getString("picture");

                                itemses[i] = new Items(id, name, picture);
                            }
                            mRecyclerView.setAdapter(new RecyclerAdapter(itemses));
                            mRecyclerView.invalidate();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}