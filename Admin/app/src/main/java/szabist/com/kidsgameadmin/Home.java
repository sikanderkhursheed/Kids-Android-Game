package szabist.com.kidsgameadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import szabist.com.kidsgameadmin.Model.Items;

public class Home extends AppCompatActivity {

    ImageView img;
    Items[] itemses1 = new Items[0];

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        jsonData1();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        adapter = new RecyclerAdapter(itemses1);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);

    }        public void jsonData1 () {
        RequestQueue queue = Volley.newRequestQueue(this);
            String url = "https://api.myjson.com/bins/67x9v";

        // /Ye wali destop mai images prhe hue wali hai
///        String url = "https://api.myjson.com/bins/yug1f";
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
                            itemses1 = new Items[17];
                            for (int i = 0; i < results.length(); i++) {
                                int id = results.getJSONObject(i).getInt("id");
                                String name = results.getJSONObject(i).getString("name");
                                String picture = results.getJSONObject(i).getString("picture");

                                itemses1[i] = new Items(id, name, picture);
                            }
                            mRecyclerView.setAdapter(new RecyclerAdapter(itemses1));
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