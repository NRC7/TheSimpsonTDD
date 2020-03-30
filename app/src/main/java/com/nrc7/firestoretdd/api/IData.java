package com.nrc7.firestoretdd.api;

import com.nrc7.firestoretdd.model.Pojo;

import java.util.List;

public interface IData {
    // Recordar: El parametro que quiero entregar a los subcriptores va entre parentesis
    void notificarLista(List<Pojo> pojoList);
}
