package com.example.vikrant.ilovezappos;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> prods;
    ListView lv;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.listView);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isConectedOnline()){
                    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
                    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.zappos.com").addConverterFactory(GsonConverterFactory.create(gson)).build();
                    ZapposAPI api = retrofit.create(ZapposAPI.class);
                    EditText tv = (EditText) findViewById(R.id.editText);
                    Call<OuterJson> cal = api.getOuterJSON(tv.getText().toString().trim());
                    cal.enqueue(products);
                } else{
                    Toast.makeText(MainActivity.this, "Internet Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, ProductActivity.class);
                Product res = (Product) prods.get(position);
                i.putExtra("disp", res);
                startActivity(i);
            }
        });

    }

    private boolean isConectedOnline(){
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if(netInfo!=null && netInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    Callback products = new Callback<OuterJson>(){

        @Override
        public void onResponse(Call<OuterJson> call, Response<OuterJson> response) {
            int code = response.code();
            if(code == 200){
                if(response.body()!=null){
                    Log.d("RESULT", response.body().toString());
                    prods = (ArrayList<Product>) response.body().getResults();
                    adapter = new ListViewAdapter(MainActivity.this, prods);
                    lv.setAdapter(adapter);
                    /*Intent i = new Intent(MainActivity.this, ProductActivity.class);
                    Product res = (Product) prods.get(0);
                    i.putExtra("disp", res);
                    startActivity(i);*/
                }
            }
        }

        @Override
        public void onFailure(Call<OuterJson> call, Throwable t) {

        }
    };
}
