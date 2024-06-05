package com.example.laboratorio03

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.laboratorio03.Clases.SueldoFinal
import com.example.laboratorio03.Utilidad.Util

class MainActivity : AppCompatActivity() {

    private  lateinit var txtnumeroHoras:EditText
    private  lateinit var txtcostoHora:EditText
    private  lateinit var txtsueldoBasico:EditText
    private  lateinit var rgcategoria:RadioGroup
    private  lateinit var rgA:RadioButton
    private  lateinit var rgB:RadioButton
    private  lateinit var rgC:RadioButton

    private  lateinit var txtbonificacion:EditText
    private  lateinit var txtTardanza:CheckBox
    private  lateinit var txtdescuento:EditText
    private  lateinit var txtsueldoFinal:EditText

    private  lateinit var btnCalcular:Button
    private  lateinit var btnLimpiar:Button
    private  lateinit var btnSalir:Button

    var numeroHoras = 0.0
    var costoHora = 0.0
    var sueldoBasico = 0.0
    var bonificacion = 0.0
    var descuento = 0.0
    var sueldoFinal = 0.0

    //creamos un objeto de la clase
    val objUtilidad:Util = Util()
    val objSueldoFinal:SueldoFinal = SueldoFinal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Creando controles
        txtnumeroHoras =  findViewById(R.id.txtNumeroHoras)
        txtcostoHora =  findViewById(R.id.txtCostoHora)
        txtsueldoBasico =  findViewById(R.id.txtSueldoBasico)
        rgcategoria = findViewById(R.id.rgCat)
        rgA =  findViewById(R.id.rbA)
        rgB =  findViewById(R.id.rbB)
        rgC =  findViewById(R.id.rbC)
        txtbonificacion =  findViewById(R.id.txtBonificacion)
        txtTardanza =  findViewById(R.id.chkTardanza)
        txtdescuento =  findViewById(R.id.txtDescuento)
        txtsueldoFinal =  findViewById(R.id.txtSueldoFinal)

        btnCalcular =  findViewById(R.id.btnCalcular)


        btnCalcular.setOnClickListener(View.OnClickListener {
            if(txtnumeroHoras.getText().toString().equals("")){
                objUtilidad.MensajeAlerta(this, "Validando datos",
                    "Ingrese numero de horas",
                    false, "Aceptar")
                txtnumeroHoras.requestFocus()
            }else if (txtcostoHora.getText().toString().equals("")){
                objUtilidad.MensajeAlerta(this, "Validando datos",
                    "Ingrese costo pot hora",
                    false, "Aceptar")
                txtcostoHora.requestFocus()
            }else if (rgA.isChecked == false && rgB.isChecked == false && rgC.isChecked == false ){
                objUtilidad.MensajeAlerta(this, "Validando datos",
                    "Ingrese costo pot hora",
                    false, "Aceptar")
                rgA.requestFocus()
            } else{
                //Capturando datos
                numeroHoras = txtnumeroHoras.getText().toString().toDouble()
                costoHora = txtcostoHora.getText().toString().toDouble()

                //enviamos los datos
                objSueldoFinal.numeroHoras = numeroHoras
                objSueldoFinal.costoHora = costoHora

                //Calculando la bonificacion
                sueldoBasico = objSueldoFinal.CalcularSueldoBasico()
                if(rgA.isChecked){
                    bonificacion = objSueldoFinal.CalcularBonificacion(0.05)
                }else if (rgB.isChecked){
                    bonificacion = objSueldoFinal.CalcularBonificacion(0.07)
                }else if (rgC.isChecked){
                    bonificacion = objSueldoFinal.CalcularBonificacion(0.09)
                }

                //Mostrar datos
                txtsueldoBasico.setText(sueldoBasico.toString())
                txtbonificacion.setText(bonificacion.toString())
                txtdescuento.setText(descuento.toString())
                txtsueldoFinal.setText(sueldoFinal.toString())

            }
        })

        btnLimpiar.setOnClickListener(View.OnClickListener {
            txtnumeroHoras.setText("")
            txtcostoHora.setText("")
            txtsueldoBasico.setText("")
            txtbonificacion.setText("")
            txtdescuento.setText("")
            txtTardanza.isChecked= false
            rgcategoria.clearCheck()

        })

    }
}