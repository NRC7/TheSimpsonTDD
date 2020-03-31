package com.nrc7.firestoretdd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nrc7.firestoretdd.api.DataSource;
import com.nrc7.firestoretdd.api.IData;
import com.nrc7.firestoretdd.databinding.ActivityMainBinding;
import com.nrc7.firestoretdd.model.Pojo;

import java.util.List;

// Implements me suscribe al Callback
public class MainActivity extends AppCompatActivity {

    // Clase autogenerada
    // Si el layout se llama activity_main
    // La clase se llama ActivityMain
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Binding
        mainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, ListFragment.newInstance("", ""), "listFragment")
                .commit();
    }

    // Maneja el boton de retroceso del telefono
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // activity -> fragment -> otroFragment (ver cual fragment esta y sacarlo)
    }
}
