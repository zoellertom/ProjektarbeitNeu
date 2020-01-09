package com.example.projektarbeit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //EditTextVariablen
    private EditText passwort;
    private EditText email;
    private EditText nickname;
    private EditText alter;
    private Button weiter;
//hhhh
    //Variablen
    private String passwortV;
    private String emailV;
    private String nicknameV;
    private int alterV;
    private String alterS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passwort = (EditText) findViewById(R.id.EditTextPasswort);
        email = (EditText) findViewById(R.id.EditTextEmail);
        alter = (EditText) findViewById(R.id.EditTextAlter);
        nickname = (EditText) findViewById(R.id.EditTextNickName);
        weiter = (Button) findViewById(R.id.button);

        weiter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                auslesen(view);
                //openActivityMain

            }
        });
    }
    /*
    public void openActivityMain()
    {
        Intent intent=new Intent(this. ActivityMain.class);
        startActivityMain();
    }

     */




    public void auslesen(View view) {
        if ((email.getText().length() != 0) && (passwort.getText().length() != 0) && (alter.getText().length() != 0) && (nickname.getText().length() != 0)) {
            emailV = email.getText().toString();
            passwortV = passwort.getText().toString();
            alterS = alter.getText().toString();
            alterV = Integer.valueOf(alterS);
            nicknameV = nickname.getText().toString();

            objektErstellen(nicknameV, alterV, emailV, passwortV);

        } else {
            Toast.makeText(this, "Bitte füllen Sie alle erforderlichen Felder!", Toast.LENGTH_SHORT).show();
        }


    }

    public void objektErstellen(String name, int alter, String email, String passwort) {
        //Nutzer aus der Activity
        System.out.println("test") ;
        System.out.println(name) ;

        User user = new User(name, alter, email, passwort);
        //Nutzer aus der Datenbank
        User dbUser;
        //Erstellen der Datenbank
        DatabaseHandler db=new DatabaseHandler(this); //Datenbank erstellen
        //speichern des Namens aus der Activity
        String usernameU=user.getName(); //gewünschten Namen (User) einlesen
        //schauen ob der name schon drin ist
        dbUser=db.getUser(usernameU);
        if(dbUser!=null && dbUser.getName().equals(user.getName()))
        {
            Toast.makeText(this, "Bitte finde einen anderen Nutzernamen", Toast.LENGTH_SHORT).show();

        }
        else
        {
            db.addUser(user); //typ hinzufügen
            Toast.makeText(this, "Registrierung erfolgreich!", Toast.LENGTH_SHORT).show();
            //openActivityMain();
        }



        System.out.println(name);
        System.out.println(alter);
        System.out.println(email);
        System.out.println(passwort);


    }

}


