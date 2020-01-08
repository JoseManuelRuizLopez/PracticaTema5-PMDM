package com.example.practicatema5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConfigurarToast extends AppCompatActivity {

    EditText txtDespVert;
    EditText txtDespHoriz;
    EditText txtMensajeToast;
    Spinner spnHoriz;
    Spinner spnVert;
    Button btnMostrar;
    TextView lblError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_toast);

        txtDespVert = (EditText) findViewById(R.id.txtDespVerti);
        txtDespHoriz = (EditText) findViewById(R.id.txtDespHoriz);
        txtMensajeToast = (EditText) findViewById(R.id.txtMensajeToast);
        spnHoriz = (Spinner) findViewById(R.id.spnHorizontal);
        spnVert = (Spinner) findViewById(R.id.spnVertical);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        lblError = (TextView) findViewById(R.id.lblError);

        //Rellenar los spinners
        ArrayAdapter arrayAdapterH;
        arrayAdapterH = ArrayAdapter.createFromResource(this, R.array.spnAliHoriz, R.layout.support_simple_spinner_dropdown_item);
        spnHoriz.setAdapter(arrayAdapterH);

        ArrayAdapter arrayAdapterV;
        arrayAdapterV = ArrayAdapter.createFromResource(this, R.array.spnAliVerti, R.layout.support_simple_spinner_dropdown_item);
        spnVert.setAdapter(arrayAdapterV);

        btnMostrar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (spnVert.getSelectedItem().toString().equals(getString(R.string.selcAli)) || spnHoriz.getSelectedItem().toString().equals(getString(R.string.selcAli))) {
                    lblError.setText(R.string.lblError);
                } else {
                    String mnsToast = txtMensajeToast.getText().toString();
                    int despVert = Integer.parseInt(txtDespVert.getText().toString());
                    int despHoriz = Integer.parseInt(txtDespHoriz.getText().toString());
                    int aliHoriz = 0;
                    int aliVert = 0;

                    //Spinner Horizontal
                    if (spnHoriz.getSelectedItem().toString().equals(getString(R.string.izq))) {
                        aliHoriz = Gravity.LEFT;
                    } else if (spnHoriz.getSelectedItem().toString().equals(getString(R.string.med))) {
                        aliHoriz = Gravity.CENTER;
                    } else if (spnHoriz.getSelectedItem().toString().equals(getString(R.string.der))) {
                        aliHoriz = Gravity.RIGHT;
                    }

                    //Spinner Vertical
                    if (spnVert.getSelectedItem().toString().equals(getString(R.string.arr))) {
                        aliVert = Gravity.TOP;
                    } else if (spnVert.getSelectedItem().toString().equals(getString(R.string.cen))) {
                        aliVert = Gravity.CENTER;
                    } else if (spnVert.getSelectedItem().toString().equals(getString(R.string.aba))) {
                        aliVert = Gravity.BOTTOM;
                    }

                    Toast toast = Toast.makeText(v.getContext(), mnsToast, Toast.LENGTH_LONG);
                    toast.setGravity(aliHoriz | aliVert, despHoriz, despVert);
                    toast.show();
                }
            }
        });
    }
}
