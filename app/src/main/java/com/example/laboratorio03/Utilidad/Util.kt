package com.example.laboratorio03.Utilidad

import android.app.AlertDialog
import android.content.Context

class Util {

    // creamos una variable para la alerta
    private var dialogo:AlertDialog.Builder? = null

    //creamos una funcion para las alaertas
    fun MensajeAlerta(context: Context, titulo:String,
                      mensaje:String, cancelable:Boolean,
                      textoBotonPositivo:String ){
        dialogo = AlertDialog.Builder(context)
        dialogo!!.setTitle(titulo)
        dialogo!!.setMessage(mensaje)
        dialogo!!.setCancelable(cancelable)
        dialogo!!.setPositiveButton(textoBotonPositivo){
            dialogo, which ->
        }

        dialogo!!.show()
    }
}