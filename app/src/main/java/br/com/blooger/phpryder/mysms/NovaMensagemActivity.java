package br.com.blooger.phpryder.mysms;

import android.app.Activity;
import android.content.ContentResolver;
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
import org.androidannotations.annotations.ViewById;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_nova_mensagem)
public class NovaMensagemActivity extends Activity implements Serializable {

    @ViewById(R.id.tmpMsg)
    protected RecyclerView recyclerView;

    @ViewById(R.id.btnEnviarNovaMsg)
    protected Button button;

    private Context context = this;

    protected List<String> list ;

    @ViewById(R.id.spinnerNMsg)
    protected Spinner spinner;

    @AfterViews
     void init(){
       contados();
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, list);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    @Click
    protected void btnEnviarNovaMsg(View v){


    }

    private void msgTmp(){

    }

    private List<String> contados(){
        list = new ArrayList<>();
        ContentResolver contenntResolver = getContentResolver();
        Cursor cursor = contenntResolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        if(cursor.getCount()>0){
            while(cursor.moveToNext()){
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String nome = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                Cursor phoneCursor = contenntResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?" ,new String[]{id},null);
                if(cursor.getCount()>0) {
                    while (phoneCursor.moveToNext()) {
                        String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                        list.add(phoneNumber);
                    }
                }
            }
        }
        cursor.close();

        return list;
    }

}
