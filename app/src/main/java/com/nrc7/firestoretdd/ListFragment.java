package com.nrc7.firestoretdd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nrc7.firestoretdd.adapter.Adapter;
import com.nrc7.firestoretdd.api.DataSource;
import com.nrc7.firestoretdd.api.IData;
import com.nrc7.firestoretdd.databinding.FragmentListBinding;
import com.nrc7.firestoretdd.model.Pojo;

import java.util.List;

public class ListFragment extends Fragment implements IData {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    FragmentListBinding listBinding;
    // Presenter
    DataSource source;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        // Es como un map, es decir key, value
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        // Instanciar al Presentador (DataSource)
        source = new DataSource(this);
        // Ejecuto el llamado
        source.initConsultaApi(20);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // Receta de DataBinding
        listBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        return listBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        listBinding.recyclerView.setHasFixedSize(true);
    }

    // Es donde recibo la respuesta una vez que se obtiene (Asyncrona)
    @Override
    public void notificarLista(List<Pojo> pojoList) {
        // Instancia del adapter
        Adapter adapter = new Adapter(pojoList, getContext());
        listBinding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Quitar la refencia al Presentador (DataSource)
        source = null;
    }
}
