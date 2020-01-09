package com.example.projektarbeit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Anmeldung extends AppCompatActivity {

    private Button registrieren;
    private Button anmelden;
    private EditText nutzername;
    private EditText passwort;

    private String passwortV;
    private String nutzernameV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrierung);

        registrieren = findViewById(R.id.button);
        anmelden = findViewById(R.id.button);
        nutzername = findViewById(R.id.nutzername);
        passwort = findViewById(R.id.passwort);

        anmelden.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Datenbank auslesen
                // auslesen(passwortV,nutzernameV);//muss noch angelegt werden
                //Passwort abgleichen
                // wechselZurMain(view);
                //openActivityMain

            }
        });
        registrieren.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                //Zur Registrierungsactivity wechseln
                wechselnZurReg(passwortV,nutzernameV);
                //werte werden in die entsprechenden Felder übertragen
            }
        });

    }
    public void wechselnZurMain(View view)
    {
        //Intent zur MainActivity
    }
    public void wechselnZurReg(String passwort, String nutzername)
    {
        //Externer Intent mit Datenübertragung
    }
    public void auslesen()
    {
        passwortV=passwort.getText().toString();
        nutzernameV=nutzername.getText().toString();
    }

}

