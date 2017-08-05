package br.com.blooger.phpryder.mysms;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_nova_mensagem)
public class NovaMensagemActivity extends Activity {

    @ViewById(R.id.tmpMsg)
    protected RecyclerView recyclerView;

    @ViewById(R.id.btnEnviarNovaMsg)
    protected Button button;

    @AfterViews
    protected void init(){

    }

    @Click
    protected void btnEnviarNovaMsg(View v){


    }

    private void msgTmp(){

    }


}
