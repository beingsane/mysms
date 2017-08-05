package br.com.blooger.phpryder.mysms;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity (R.layout.activity_lista_contado)
public class ListaContadoActivity extends AppCompatActivity {


    @ViewById(R.id.recycleViewContado)
    protected RecyclerView recyclerView;

    @AfterViews
    protected  void init(){

    }

}