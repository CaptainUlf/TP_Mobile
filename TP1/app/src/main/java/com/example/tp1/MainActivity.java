package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    String CYCLE_VIE_PREFS = "cycle_vie_prefs";

    /**
     * Exécuté chaque fois que l'utilisateur clique sur l'icône de l'application pour une première fois.
     *
     * La fonction onCreate() est suivie d'un onStart().
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnQuitter = (Button) findViewById(R.id.btnQuitter);
        btnQuitter.setOnClickListener(btnQuitterOnClickListener);

        Button btnEnvoyer = (Button) findViewById(R.id.btnEnvoyer);
        btnEnvoyer.setOnClickListener(btnEnvoyerOnClickListener);

        Button btnAct = (Button) findViewById(R.id.btnAct2);
        btnAct.setOnClickListener(btnAct2OnClickListener);

        popUp("onCreate()");
    }
    /** =============================================================
     * Exécuté que l'activité arrêtée via un "stop" redémarre.
     *
     * La fonction onRestart() est suivie de la fonction onStart().
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        popUp("onRestart()");
    }
    /** ==============================================================
     * Exécuté lorsque l'activité devient visible à l'utilisateur.
     *
     * La fonction onStart() est suivie de la fonction onResume().
     */
    @Override
    protected void onStart() {
        super.onStart();
        popUp("onStart()");
    }
    /** ==============================================================
     * Exécutée à chaque passage en premier plan de l'activité.
     * Ou bien, si l'activité passe à nouveau en premier
     * (si une autre activité était passée en premier plan entre temps).
     *
     * La fonction onResume() est suivie de l'exécution de l'activité.
     */
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences settings = getSharedPreferences(CYCLE_VIE_PREFS, Context.MODE_PRIVATE);
        String value = settings.getString("cle","");
        setTxTValeur(value);

        popUp("onResume()");
    }
    /** =============================================================
     * La fonction onPause() est suivie :
     * - d'un onResume() si l'activité passe à nouveau en premier plan
     * - d'un onStop() si elle devient invisible à l'utilisateur
     *
     * L'exécution de la fonction onPause() doit être rapide,
     * car la prochaine activité ne démarrera pas tant que l'exécution
     * de la fonction onPause() n'est pas terminée.
     */
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences settings = getSharedPreferences(CYCLE_VIE_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("cle", getTxtValeur());
        editor.apply();

        if (isFinishing()) {
            popUp("onPause, l'utilisateur à demandé la fermeture via un finish()");
        } else {
            popUp("onPause, l'utilisateur n'a pas demandé la fermeture via un finish()");
        }
    }
    /** ==============================================================
     * La fonction onStop() est exécutée :
     * - lorsque l'activité n'est plus en premier plan
     * - ou bien lorsque l'activité va être détruite
     *
     * Cette fonction est suivie :
     * - de la fonction onRestart() si l'activité passe à nouveau en premier plan
     * - de la fonction onDestroy() lorsque l'activité se termine
     *    ou bien lorsque le système décide de l'arrêter
     */
    @Override
    protected void onStop() {
        super.onStop();
        popUp("onStop()");
    }
    /** =============================================================
     * Cette fonction est exécutée lorsque l'activité se termine ou bien lorsque
     * le système décide de l'arrêter.
     *
     * La fonction onCreate() devra à nouveau être exécutée pour obtenir à nouveau l'activité.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        popUp("onDestroy()");
    }
    //=================================================================
    View.OnClickListener btnQuitterOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    View.OnClickListener btnEnvoyerOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUp("valeur saisie = " + getTxtValeur());
        }
    };

    View.OnClickListener btnAct2OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), SecondActivity.class);
            startActivity(intent);

            intent.putExtra("intent", getTxtValeur()) ;
        }
    };
    //=================================================================

    public String getTxtValeur() {
        EditText zoneValeur = (EditText) findViewById(R.id.editTxtValeur);
        return zoneValeur.getText().toString();
    }

    public void setTxTValeur(String valeur) {
        EditText zoneValeur = (EditText) findViewById(R.id.editTxtValeur);
        zoneValeur.setText(valeur);
    }

    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("clé", "");
    }

    public void popUp(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
    //Que se passe-t-il quand vous faites pivoter (rotation) votre appareil ?
    // onPause() sans finish + onStop + onDestroy + onCreate + onStart + onResume
    // L'application se redémare lorsque l'on effectue une rotation.