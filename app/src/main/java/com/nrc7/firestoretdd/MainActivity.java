package com.nrc7.firestoretdd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.nrc7.firestoretdd.api.DataSource;
import com.nrc7.firestoretdd.api.IData;
import com.nrc7.firestoretdd.databinding.ActivityMainBinding;
import com.nrc7.firestoretdd.model.Pojo;

import java.util.List;

// Implements me suscribe al Callback
public class MainActivity extends AppCompatActivity implements IData {

    // Clase autogenerada
    // Si el layout se llama activity_main
    // La clase se llama ActivityMain
    ActivityMainBinding mainBinding;
    // Presenter
    DataSource source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Binding
        mainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        // Instanciar al Presentador (DataSource)
        source = new DataSource(this);
        // Ejecuto el llamado
        source.initConsultaApi(20);
    }

    // ctrl + o
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Quitar la refencia al Presentador (DataSource)
        source = null;
    }

    // Es donde recibo la respuesta una vez que se obtiene (Asyncrono)
    @Override
    public void notificarLista(List<Pojo> pojoList) {
        // Obtener 1 objeto dentro de la lista
        Pojo pojo = pojoList.get(0);
        // Setear la informacion del POJO a las vistas
        mainBinding.nombreTv.setText(pojo.getCharacter()); //CTRL + D
        mainBinding.fraseTv.setText(pojo.getQuote());
        // Setear la imagen
        Glide.with(this).load(pojo.getImage())
                .into(mainBinding.imageView);
    }
}
