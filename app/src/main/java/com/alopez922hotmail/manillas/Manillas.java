package com.alopez922hotmail.manillas;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Manillas extends AppCompatActivity {
    private Spinner material;
    private String Arraymaterial[];
    private Resources recursos;
    private Spinner dije;
    private String Arraydije[];
    private Spinner Tipo;
    private String ArrayTipo[];
    private Spinner Moneda;
    private String ArrayMoneda[];
    private EditText Canti;
    private TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manillas);

        Canti = findViewById(R.id.txtCantidad);
        Resultado = findViewById(R.id.txtresultado);

        material = findViewById(R.id.spinneritem);
        recursos = this.getResources();

        Arraymaterial = recursos.getStringArray(R.array.items);

        ArrayAdapter<String> Adaptermaterial = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Arraymaterial);
        material.setAdapter(Adaptermaterial);

        dije = findViewById(R.id.spinnerdije);
        recursos = this.getResources();

        Arraydije = recursos.getStringArray(R.array.itemsdije);

        ArrayAdapter<String> Adapterdije = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Arraydije);
        dije.setAdapter(Adapterdije);

        Tipo = findViewById(R.id.spinnerTipo);
        recursos = this.getResources();

        ArrayTipo = recursos.getStringArray(R.array.itemsTipo);

        ArrayAdapter<String> AdapterTipo = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ArrayTipo);
        Tipo.setAdapter(AdapterTipo);

        Moneda = findViewById(R.id.spinnerMoneda);
        recursos = this.getResources();

        ArrayMoneda = recursos.getStringArray(R.array.TipoMoneda);
        ArrayAdapter<String> AdapterMoneda = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ArrayMoneda);
        Moneda.setAdapter(AdapterMoneda);


    }

    public void calcular(View v) {
        int Mate, Di, tipe, valor=0 , Cantidad, Total;

        Mate = material.getSelectedItemPosition();
        Di = dije.getSelectedItemPosition();
        tipe = Tipo.getSelectedItemPosition();
        Cantidad = Integer.parseInt(Canti.getText().toString());

        if (Mate == 0 && Di == 0 && (tipe == 0 || tipe == 1)) {
            valor = 100;
        } else if (Mate == 0 && Di == 0 && tipe == 2) {
            valor = 80;
        } else if (Mate == 0 && Di == 0 && tipe == 3) {
            valor = 70;
        } else if (Mate == 0 && Di == 1 && (tipe == 0 || tipe == 1)) {
            valor = 120;
        } else if (Mate == 0 && Di == 1 && tipe == 2) { //Cuero ancla plata
            valor = 100;
        } else if (Mate == 0 && Di == 1 && tipe == 3) {  //Cuero ancla Niquel
            valor = 90;
        } else if (Mate == 1 && Di == 0 && (tipe == 0 || tipe == 1)) { //Cuerda Martillo oro - oro rosado
            valor = 90;
        } else if (Mate == 1 && Di == 0 && tipe == 2) { // Cuerda martillo plata
            valor = 70;
        } else if (Mate == 1 && Di == 0 && tipe == 3) {   //cuerda martillo niquel
            valor = 50;
        } else if (Mate == 1 && Di == 1 && (tipe == 0 || tipe == 1)) { //cuerda ancla oro-oro rosado
            valor = 110;
        } else if (Mate == 1 && Di == 1 && tipe == 2) { // Cuerda ancla plata
            valor = 90;
        } else if (Mate == 1 && Di == 1 && tipe == 3) { //Cuerda ancla Niquel
            valor = 80;
        }
        Total=Calcucantidad(valor,Cantidad,Moneda.getSelectedItemPosition());
        Resultado.setText("$"+Total);
    }

    public int Calcucantidad(int valor, int C , int moneda){

           if (moneda == 1){

               return valor * C *3200;

           } else{
               return valor * C ;
           }



    }

}
