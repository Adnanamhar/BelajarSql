package com.example.belajarsql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.google.gson.JsonIOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SiswaActivity extends AppCompatActivity {
    RecyclerView recyclerSiswa;
    private static final String TAG = "SiswaActivity";
    SwipeRefreshLayout swiperefreshSiswa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siswa);

        recyclerSiswa = findViewById(R.id.recyclersiswa);
        swiperefreshSiswa = findViewById(R.id.SwiperefreshSiswa);

        swiperefreshSiswa.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestSiswa();
            }
        });

        recyclerSiswa.setLayoutManager(new LinearLayoutManager(
                this,RecyclerView.VERTICAL,false));

        recyclerSiswa.setHasFixedSize(true);
        AndroidNetworking.initialize(getApplicationContext());
        requestSiswa();
    }

    private void requestSiswa() {
        AndroidNetworking.get("http://192.168.71.105/belajarsql/api_siswatampil.php")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "OnResponse" + response);//untuk log pada response
                        swiperefreshSiswa.setRefreshing(false);
                        ArrayList<Siswa> listSiswa = new ArrayList<>();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonSiswa = response.getJSONObject(i);
                                Siswa siswa = new Siswa(
                                        jsonSiswa.getString("nosiswa"),
                                        jsonSiswa.getString("idjurusan"),
                                        jsonSiswa.getString("nama"),
                                        jsonSiswa.getString("jeniskelamin"),
                                        jsonSiswa.getString("tgllahir"));
                                listSiswa.add(siswa);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        AdapterSiswa adapterSiswa = new AdapterSiswa(listSiswa);
                        recyclerSiswa.setAdapter(adapterSiswa);
                    }

                    @Override
                    public void onError(ANError anError) {
                        swiperefreshSiswa.setRefreshing(false);
                        Toast.makeText(SiswaActivity.this,"Req Error:" + anError.getErrorBody(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
