package com.mobotechnology.bipinpandey.retrofit_handdirty.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.mobotechnology.bipinpandey.retrofit_handdirty.R;
import com.mobotechnology.bipinpandey.retrofit_handdirty.model.SampleData;
import com.mobotechnology.bipinpandey.retrofit_handdirty.my_interface.APIInterface;
import com.mobotechnology.bipinpandey.retrofit_handdirty.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void defaultclick(View view){
        APIInterface service = RetrofitInstance.getRetrofitInstance().create(APIInterface.class);

        Call<SampleData> call = service.getDefaultData();

        call.enqueue(new Callback<SampleData>() {
            @Override
            public void onResponse(Call<SampleData> call, Response<SampleData> response) {
                ((TextView)findViewById(R.id.server_response_text)).setText(response.body().getData());
                Toast.makeText(MainActivity.this,response.body().getData(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<SampleData> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
