package br.com.blooger.phpryder.mysms;

import android.content.Context;

import java.io.Serializable;

/**
 * Created by Cliente on 05/08/2017.
 */


public class Contado implements Serializable{


    private int id;
    private String name;
    private String telefone;

    public Contado(String telefone){
        this.telefone = telefone;
    }

    public Contado(String name, int id, String telefone, Context context)
    {
        this.id = id;
        this.name = name;
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contado contado = (Contado) o;

        return id == contado.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
