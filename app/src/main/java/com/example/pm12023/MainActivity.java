package com.example.pm12023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numero1, numero2;
    RadioButton suma, resta, multiplicacion, division;

    Button btncalcular;
    String operacion ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncalcular = findViewById(R.id.btncalcular);
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ResultadoActivity.class));
                finish();
            }
        });

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);

        suma = findViewById(R.id.suma);
        resta = findViewById(R.id.resta);
        multiplicacion = findViewById(R.id.multiplicacion);
        division = findViewById(R.id.division);
        btncalcular = findViewById(R.id.btncalcular);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero1.getText().toString().length()<1) {
                    Toast.makeText(getApplicationContext(), "Falta Un numero 1", Toast.LENGTH_LONG).show();
                } else if (numero2.getText().toString().length()<1) {
                    Toast.makeText(getApplicationContext(), "Falta Numero 2", Toast.LENGTH_LONG).show();
                } else {
                    if (suma.isChecked())
                        operacion = "suma";
                        if (resta.isChecked())
                            operacion = "resta";
                            if (multiplicacion.isChecked())
                                operacion = "multiplicacion";
                                if (division.isChecked())
                                    operacion = "division";

                                Intent i = new Intent(getApplicationContext(),ResultadoActivity.class);
                                i.putExtra("numero1",numero1.getText().toString());
                                i.putExtra("numero2",numero2.getText().toString());
                                i.putExtra("operacion",operacion);
                                startActivity(i);
                                }
                            }

        });
    }
}