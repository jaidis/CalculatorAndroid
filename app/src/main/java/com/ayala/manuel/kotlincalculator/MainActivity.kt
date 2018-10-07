package com.ayala.manuel.kotlincalculator

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import android.view.View
import android.widget.RadioButton

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.text.method.ScrollingMovementMethod
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    var calculadora:Double = 0.0
    var calculadoraMemoria:Double = 0.0
    var arrayNumeros = ArrayList<Double>()
    var arrayOperaciones = ArrayList<String>()

    var calculadora_HEX:String = "0"
    var calculadoraMemoria_HEX:String = "0"
    var arrayNumeros_HEX = ArrayList<String>()
    var arrayOperaciones_HEX = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)
//
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

        //OnSaveInstanceState
        //onRestoreInstanceState
        //Para guardar variables al rotar la pantalla
    }

    fun sumando (v: View){
        this.arrayNumeros.add(textViewResultado.text.toString().toDouble())
        this.arrayOperaciones.add("+")
        this.textViewResultado.text = "0"
        Toast.makeText(this@MainActivity, "Sumando", Toast.LENGTH_SHORT).show()
        //Log.d("numero-debug", "Calculadora suma previa: " + calculadora)
    }

    fun restando (v: View){
        this.arrayNumeros.add(textViewResultado.text.toString().toDouble())
        this.arrayOperaciones.add("-")
        this.textViewResultado.text = "0"
        Toast.makeText(this@MainActivity, "Restando", Toast.LENGTH_SHORT).show()
    }

    fun multiplicando (v: View){
        this.arrayNumeros.add(textViewResultado.text.toString().toDouble())
        this.arrayOperaciones.add("*")
        this.textViewResultado.text = "0"
        Toast.makeText(this@MainActivity, "Multiplicando", Toast.LENGTH_SHORT).show()
    }

    fun dividiendo (v: View){
        this.arrayNumeros.add(textViewResultado.text.toString().toDouble())
        this.arrayOperaciones.add("/")
        this.textViewResultado.text = "0"
        Toast.makeText(this@MainActivity, "Dividiendo", Toast.LENGTH_SHORT).show()
    }

    fun numero (v:View){
        val numero = findViewById<Button>(v.id)
        //Log.d("numero-debug", "Numero pulsado: " + numero.text.toString())
        if (this.textViewResultado.text.toString().length <= 8) {
            if (!this.textViewResultado.text.toString().equals("0"))
                this.textViewResultado.text = this.textViewResultado.text.toString() + numero.text.toString()
            else
                this.textViewResultado.text = numero.text.toString()
        }
        else{
            Toast.makeText(this@MainActivity, "El número es demasiado largo", Toast.LENGTH_SHORT).show()
        }

    }

    fun limpiar (v: View){
        this.arrayNumeros = ArrayList<Double>()
        this.arrayOperaciones = ArrayList<String>()
        this.textViewResultado.text = "0"
        this.calculadora = 0.0
        Toast.makeText(this@MainActivity, "Calculadora reseteada", Toast.LENGTH_SHORT).show()

    }

    fun memoriaValor (v: View){
        this.textViewResultado.text = calculadoraMemoria.toString()
        Toast.makeText(this@MainActivity, "Valor actual de la memoria", Toast.LENGTH_SHORT).show()
    }

    fun memoriaResetear (v: View){
        this.calculadoraMemoria = 0.0
        Toast.makeText(this@MainActivity, "Memoria reseteada", Toast.LENGTH_SHORT).show()
    }

    fun memoriaAsignarValor(v: View){
        this.calculadoraMemoria += this.textViewResultado.text.toString().toDouble()
        Toast.makeText(this@MainActivity, "Memoria almacenada", Toast.LENGTH_SHORT).show()
    }

    fun resultado (v: View){
        this.arrayNumeros.add(textViewResultado.text.toString().toDouble())
        this.calculadora = this.arrayNumeros[0]
        for ((indice, item) in this.arrayOperaciones.withIndex()){
//            Log.d("numero-debug", "Indice: " + indice)
//            Log.d("numero-debug", "Item: " + item)
            if (item == "+")
                this.calculadora += this.arrayNumeros[indice + 1]
            if (item == "-")
                this.calculadora -= this.arrayNumeros[indice + 1]
            if (item == "*")
                this.calculadora *= this.arrayNumeros[indice + 1]
            if (item == "/")
                this.calculadora /= this.arrayNumeros[indice + 1]
        }

        this.textViewResultado.text = calculadora.toString()
        Toast.makeText(this@MainActivity, "Resultado", Toast.LENGTH_SHORT).show()
        // Log.d("numero-debug", "Resultado: " + this.calculadora)

    }
    /*
    Calculadora Hexadecimal
     */

    fun sumando_HEX (v: View){
        this.arrayNumeros_HEX.add(textViewResultado_HEX.text.toString())
        this.arrayOperaciones_HEX.add("+")
        this.textViewResultado_HEX.text = "0"
        Toast.makeText(this@MainActivity, "Sumando", Toast.LENGTH_SHORT).show()
    }

    fun restando_HEX (v: View){
        this.arrayNumeros_HEX.add(textViewResultado_HEX.text.toString())
        this.arrayOperaciones_HEX.add("-")
        this.textViewResultado_HEX.text = "0"
        Toast.makeText(this@MainActivity, "Restando", Toast.LENGTH_SHORT).show()
    }

    fun multiplicando_HEX (v: View){
        this.arrayNumeros_HEX.add(textViewResultado_HEX.text.toString())
        this.arrayOperaciones_HEX.add("*")
        this.textViewResultado_HEX.text = "0"
        Toast.makeText(this@MainActivity, "Multiplicando", Toast.LENGTH_SHORT).show()
    }

    fun dividiendo_HEX (v: View){
        this.arrayNumeros_HEX.add(textViewResultado_HEX.text.toString())
        this.arrayOperaciones_HEX.add("/")
        this.textViewResultado_HEX.text = "0"
        Toast.makeText(this@MainActivity, "Dividiendo", Toast.LENGTH_SHORT).show()
    }

    fun numero_HEX (v:View){
        val numero_HEX = findViewById<Button>(v.id)
        //Log.d("numero-debug", "Numero pulsado: " + numero_HEX.text.toString())
        if (this.textViewResultado_HEX.text.toString().length <= 8) {
            if (!this.textViewResultado_HEX.text.toString().equals("0"))
                this.textViewResultado_HEX.text = this.textViewResultado_HEX.text.toString() + numero_HEX.text.toString()
            else
                this.textViewResultado_HEX.text = numero_HEX.text.toString()
        }
        else{
            Toast.makeText(this@MainActivity, "El número es demasiado largo", Toast.LENGTH_SHORT).show()
        }

    }

    fun limpiar_HEX (v: View){
        this.arrayNumeros_HEX = ArrayList<String>()
        this.arrayOperaciones_HEX = ArrayList<String>()
        this.textViewResultado_HEX.text = "0"
        this.calculadora_HEX = "0"
        Toast.makeText(this@MainActivity, "Calculadora reseteada", Toast.LENGTH_SHORT).show()

    }

    fun memoriaValor_HEX (v: View){
        this.textViewResultado_HEX.text = Integer.toHexString(this.calculadoraMemoria_HEX.toInt()).toUpperCase()
        Toast.makeText(this@MainActivity, "Valor actual de la memoria", Toast.LENGTH_SHORT).show()
    }

    fun memoriaResetear_HEX (v: View){
        this.calculadoraMemoria_HEX = "0"
        Toast.makeText(this@MainActivity, "Memoria reseteada", Toast.LENGTH_SHORT).show()
    }

    fun memoriaAsignarValor_HEX(v: View){
        this.calculadoraMemoria_HEX = (java.lang.Long.parseLong(this.calculadoraMemoria_HEX, 16) + java.lang.Long.parseLong(this.textViewResultado_HEX.text.toString(), 16)).toString()
        Toast.makeText(this@MainActivity, "Memoria almacenada", Toast.LENGTH_SHORT).show()
    }

    fun resultado_HEX (v: View){
        this.arrayNumeros_HEX.add(textViewResultado_HEX.text.toString())
        this.calculadora_HEX = this.arrayNumeros_HEX[0]
        for ((indice, item) in this.arrayOperaciones_HEX.withIndex()){
            if (item == "+")
                this.calculadora_HEX = (java.lang.Long.parseLong(this.calculadora_HEX, 16) + java.lang.Long.parseLong(this.arrayNumeros_HEX[indice + 1], 16)).toString()
            if (item == "-")
                this.calculadora_HEX = (java.lang.Long.parseLong(this.calculadora_HEX, 16) - java.lang.Long.parseLong(this.arrayNumeros_HEX[indice + 1], 16)).toString()
            if (item == "*")
                this.calculadora_HEX = (java.lang.Long.parseLong(this.calculadora_HEX, 16) * java.lang.Long.parseLong(this.arrayNumeros_HEX[indice + 1], 16)).toString()
            if (item == "/")
                this.calculadora_HEX = (java.lang.Long.parseLong(this.calculadora_HEX, 16) / java.lang.Long.parseLong(this.arrayNumeros_HEX[indice + 1], 16)).toString()
        }

        this.textViewResultado_HEX.text = Integer.toHexString(this.calculadora_HEX.toInt()).toUpperCase()
        Toast.makeText(this@MainActivity, "Resultado", Toast.LENGTH_SHORT).show()
        // Log.d("numero-debug", "Resultado: " + this.calculadora)

    }


//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}
