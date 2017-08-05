package br.com.blooger.phpryder.mysms;

import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemSelect;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

//importacoes do framework AA

@EActivity(R.layout.activity_messeger)
public class MessegerActivity extends AppCompatActivity {

    protected List<String> list = new ArrayList<>();


    protected  Contado contado;

    protected List<Contado> contados = new ArrayList<>();

    @ViewById
    protected Button btnEnviar;

    @ViewById
    protected Spinner spinner;

    protected Context context = this;

    protected String  selecionado;

    @AfterViews
    protected void init(){

        Agenda();
        if (contados.size() != 0) {
            for (int i = 0; i < contados.size(); i++) {
                contado = contados.get(i);
                list.add(contado.getName());
            }
        }

        ArrayAdapter<String> spinnerAdapter  = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,list);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

    }

    protected void Agenda(){
        Uri agenda = ContactsContract.Contacts.CONTENT_URI;
        //contados.add(new Contado(agenda.getUserInfo()));
        Log.i("Agenda",ContactsContract.Contacts.DISPLAY_NAME);

    }

    @Click
    public void btnEnviar(View view){
        Snackbar.make(view, selecionado ,Snackbar.LENGTH_INDEFINITE).show();
    }

    @ItemSelect(R.id.spinner)
    protected void itemSelectedSpinner(boolean select , String item)
    {
        if(select){
            selecionado = item;
        }else{

        }
    }


//    public ArrayList<MeuContato> pegarContatos(){
//
//        ArrayList<MeuContato> listaDeContatos = new ArrayList<>();
//
//        Uri agenda = ContactsContract.Contacts.CONTENT_URI;
//        Cursor cursor = getContenResolver.query(agenda,null,null,null);
//
//        while(cursor.moveToNext()){
//
//            String nome = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//
//        /* Pegue mais informações de acordo com os atributos da sua classe MeuContato */
//
//            MeuContato contato = new MeuContato(nome);
//
//            listaDeContatos.add(contato);
//        }
//
//        cursor.close();
//
//        return listaDeContatos;
//    }


}
