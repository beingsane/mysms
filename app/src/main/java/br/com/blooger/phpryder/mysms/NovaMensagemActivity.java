package br.com.blooger.phpryder.mysms;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_nova_mensagem)
public class NovaMensagemActivity extends Activity {

    @ViewById(R.id.tmpMsg)
    protected RecyclerView recyclerView;

    @ViewById(R.id.btnEnviarNovaMsg)
    protected Button button;

    private Context context = this;

    @NonConfigurationInstance
    protected List<Contado> contadosList = new ArrayList<>();

    @NonConfigurationInstance
    protected List<String> list = new ArrayList<>();

    @InstanceState
    protected Contado contado;

    @NonConfigurationInstance
    ArrayAdapter<String> spinnerAdapter;

    @ViewById(R.id.spinnerNMsg)
    protected Spinner spinner;

    @AfterViews
     void init(){
       contados();
        if (contadosList.size() != 0) {
            for (int i = 0; i < contadosList.size(); i++) {
                contado = contadosList.get(i);
                list.add(contado.getName());
            }
        }

        spinnerAdapter  = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,list);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    @Click
    protected void btnEnviarNovaMsg(View v){


    }

    private void msgTmp(){

    }

    private List<Contado> contados(){
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,ContactsContract.Contacts.DISPLAY_NAME);
        int indexId = cursor.getColumnIndex(ContactsContract.Contacts._ID);
        int indexNome = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
        int indexTelephone = cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);

        while (cursor.moveToNext()){
            if(Integer.parseInt(cursor.getString(indexTelephone))>0){
                contado = new Contado(cursor.getString(indexTelephone));
                contadosList.add(contado);
            }
        }
        cursor.close();
        return contadosList;
    }



}
