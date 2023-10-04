package com.example.pm12023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    TextView rn1,rn2, texto, resultado;
    Button btnvolver;

    int n1,n2,res;
    String operacion="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        rn1= findViewById(R.id.rn1);
        rn2= findViewById(R.id.rn2);
        texto= findViewById(R.id.texto);
        resultado= findViewById(R.id.resultado);


        btnvolver = findViewById(R.id.btnvolver);
        n1=Integer.valueOf(getIntent().getExtras().getString("numero1"));
        n2=Integer.valueOf(getIntent().getExtras().getString("numero2"));
        operacion = getIntent().getExtras().getString("operacion");

        switch (operacion){
            case "suma":
                res= n1 + n2;
                break;

            case "resta":
                res= n1 - n2;
                break;

            case "multiplicacion":
                res= n1 * n2;
                break;

            case "division":
                res= n1 / n2;
                break;

        }
        texto.setText("La " +operacion+ " es: ");
        resultado.setText(String.valueOf(res));

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}