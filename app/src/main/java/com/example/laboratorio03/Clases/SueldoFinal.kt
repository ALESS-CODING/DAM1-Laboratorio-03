package com.example.laboratorio03.Clases

class SueldoFinal {

    //atributos
    var numeroHoras:Double = 0.0
    var costoHora: Double = 0.0
    var sueldoBasico:Double = 0.0
    var bonificacion:Double = 0.0
    var descuento:Double = 0.0
    var sueldoFinal:Double = 0.0

    //operaciones
    fun CalcularSueldoBasico ():Double {
        sueldoBasico = numeroHoras * costoHora
        return sueldoBasico
    }
    fun CalcularBonificacion(porcetaje:Double):Double{
        bonificacion = sueldoBasico * porcetaje
        return bonificacion
    }

    fun CalcularDescuento ():Double{
        descuento = sueldoBasico * 0.3
        return descuento
    }

    fun CalcularSueldoFinal():Double{
        sueldoFinal = sueldoBasico + bonificacion - descuento
        return  sueldoFinal
    }
}