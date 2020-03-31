package com.nrc7.firestoretdd.api;

import android.util.Log;

import com.nrc7.firestoretdd.model.Pojo;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataSource {

    private IData callback;

    // Es un recurso para que MainActivity pueda decir (this) e implementar el metodo
    public DataSource(IData callback) {
        this.callback = callback;
    }

    // Este metodo se va a ejecutar dentro del MainActivity
    public void initConsultaApi(int num) {
        // Union de ambas partes
        Api api = RetrofitClient.getRetrofitInstance().create(Api.class);
        // Construccion del llamado
        Call<Pojo[]> call = api.getQuotes(num);
        // Ejecutar el llamado por el segundo del sistema operativo
        // new + espacio + C + enter
        call.enqueue(new Callback<Pojo[]>() {
            @Override
            public void onResponse(Call<Pojo[]> call, Response<Pojo[]> response) {
                // List<Pojo> lsit = response.body();
                if (response.body() != null) {
                List<Pojo> pojoList = Arrays.asList(response.body());
                callback.notificarLista(pojoList);

                } else {

                }
                // Enviar por el callback la lista hacia el Main
            }

            @Override
            public void onFailure(Call<Pojo[]> call, Throwable t) {
                // Generalmente se ejecuta cuando la clase Api esta construida de forma distinta
                // a la consulta pedida por el API
                Log.d("TAG", "onFailure: " + t.getMessage());
                Log.d("TAG", "onFailure: " + t.getLocalizedMessage());
                Log.d("TAG", "onFailure: " + call.request().url());
                Log.d("TAG", "onFailure: " + call.request().method());
            }
        });
    }
}
