package com.example.notas;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Constructor;
import java.util.prefs.PreferenceChangeEvent;

public class Notas {

    SharedPreferences preferencias;
    SharedPreferences.Editor editorPreferencias;
    Context contexto;
    private final String PREFERENCIAS_FILE = "Notas";




    public Notas(Context c) {
        this.contexto = c;
        preferencias = this.contexto.getSharedPreferences(PREFERENCIAS_FILE, Context.MODE_PRIVATE);
        editorPreferencias = preferencias.edit();

    }

    public String recuperarNota(){
        if(this.preferencias.contains("nota")){
            String texto = contexto.getResources().getString(R.string.msg1);
            Toast.makeText(this.contexto, texto,Toast.LENGTH_LONG).show();
            return this.preferencias.getString("nota","");
        }else{
            return "";
        }
    };


    public void salvarNota(String textos){
        editorPreferencias.putString("texto", textos);
        editorPreferencias.commit();
        
    };

}
