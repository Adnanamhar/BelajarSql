package com.example.belajarsql;

import android.os.Bundle;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JurusanActivity extends AppCompatActivity {
    private RecyclerView recyclerJurusan;
    private static final String TAG = "JurusanActivity";
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurusan);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerJurusan = findViewById(R.id.recyclerJurusan);
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestJurusan();
            }
        });

        recyclerJurusan.setLayoutManager(new LinearLayoutManager(
                this,RecyclerView.VERTICAL,false));

        recyclerJurusan.setHasFixedSize(true);
        AndroidNetworking.initialize(getApplicationContext());
        requestJurusan();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void requestJurusan() {
        AndroidNetworking.get("http://192.168.71.105/belajarsql/api_jurusantampil.php")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG,"Onresponse" + response);//untuk log pada resource
                        swipeRefreshLayout.setRefreshing(false);

                        ArrayList<Jrsn> listjurusan = new ArrayList<>();

                        for (int i = 0; i<response.length(); i++) {
                            try {
                                JSONObject jsonJurusan = response.getJSONObject(i);
                                Jrsn jrsn = new Jrsn(
                                        jsonJurusan.getString("idjurusan"),
                                        jsonJurusan.getString("nosiswa"),
                                        jsonJurusan.getString("namajurusan"));
                                listjurusan.add(jrsn);
                             } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        AdapterJurusan adapterJurusan = new AdapterJurusan(listjurusan);
                        recyclerJurusan.setAdapter(adapterJurusan);
                    }

                    @Override
                    public void onError(ANError anError) {
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(JurusanActivity.this,"Req Error :" + anError.getErrorBody(),
                                Toast.LENGTH_SHORT).show();

                    }
                });
    }
}
