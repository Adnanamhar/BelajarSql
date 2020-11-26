package com.example.belajarsql;

import android.os.Bundle;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GuruActivity extends AppCompatActivity {
    private RecyclerView recyclerGuru;
    private static final String TAGGuru = "GuruActivity";
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guru);
        Toolbar toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

        recyclerGuru = findViewById(R.id.recyclerGuru);
        swipeRefreshLayout = findViewById(R.id.swiperefreshguru);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestGuru();
            }
        });
        recyclerGuru.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerGuru.setHasFixedSize(true);
        AndroidNetworking.initialize(getApplicationContext());
        requestGuru();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void requestGuru() {
        AndroidNetworking.get("http://192.168.71.105/belajarsql/api_gurutampil.php")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAGGuru, "Onresponse" + response);
                        swipeRefreshLayout.setRefreshing(false);

                        ArrayList<Guru> listguru = new ArrayList<>();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonguru = response.getJSONObject(i);
                                Guru guru = new Guru(
                                        jsonguru.getString("idguru"),
                                        jsonguru.getString("nama_guru"),
                                        jsonguru.getString("jenis_kelamin"),
                                        jsonguru.getString("kota"),
                                        jsonguru.getString("gajiguru"));
                                listguru.add(guru);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        AdapterGuru adapterGuru = new AdapterGuru(listguru);
                        recyclerGuru.setAdapter(adapterGuru);
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
