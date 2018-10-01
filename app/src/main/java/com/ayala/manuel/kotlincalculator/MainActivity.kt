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

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    var calculadora:Long = 0
    var calculadoraMemoria:Long = 0
    var arrayNumeros = ArrayList<Long>()
    var arrayOperaciones = ArrayList<String>()


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

        //Guardar el tipo de Operacion
        //Creamos un bool que diga si estamos haciendo una operacion
    }

    fun sumando (v: View){
        this.arrayNumeros.add(textViewResultado.text.toString().toLong())
        this.arrayOperaciones.add("+")
        this.textViewResultado.text = "0"
        Toast.makeText(this@MainActivity, "Sumando", Toast.LENGTH_LONG).show()
        //Log.d("numero-debug", "Calculadora suma previa: " + calculadora)
    }

    fun restando (v: View){
        this.arrayNumeros.add(textViewResultado.text.toString().toLong())
        this.arrayOperaciones.add("-")
        this.textViewResultado.text = "0"
        Toast.makeText(this@MainActivity, "Restando", Toast.LENGTH_LONG).show()
    }

    fun multiplicando (v: View){
        this.arrayNumeros.add(textViewResultado.text.toString().toLong())
        this.arrayOperaciones.add("*")
        this.textViewResultado.text = "0"
        Toast.makeText(this@MainActivity, "Multiplicando", Toast.LENGTH_LONG).show()
    }

    fun dividiendo (v: View){
        this.arrayNumeros.add(textViewResultado.text.toString().toLong())
        this.arrayOperaciones.add("/")
        this.textViewResultado.text = "0"
        Toast.makeText(this@MainActivity, "Dividiendo", Toast.LENGTH_LONG).show()
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
            Toast.makeText(this@MainActivity, "El número es demasiado largo", Toast.LENGTH_LONG).show()
        }

    }

    fun limpiar (v: View){
        this.arrayNumeros = ArrayList<Long>()
        this.arrayOperaciones = ArrayList<String>()
        this.textViewResultado.text = "0"
        this.calculadora = 0
        Toast.makeText(this@MainActivity, "Calculadora reseteada", Toast.LENGTH_LONG).show()

    }

    fun memoriaValor (v: View){
        this.textViewResultado.text = calculadoraMemoria.toString()
        Toast.makeText(this@MainActivity, "Valor actual de la memoria", Toast.LENGTH_LONG).show()
    }

    fun memoriaResetear (v: View){
        this.calculadoraMemoria = 0
        Toast.makeText(this@MainActivity, "Memoria reseteada", Toast.LENGTH_LONG).show()
    }

    fun memoriaAsignarValor(v: View){
        this.calculadoraMemoria += this.textViewResultado.text.toString().toLong()
        Toast.makeText(this@MainActivity, "Memoria almacenada", Toast.LENGTH_LONG).show()
    }

    fun resultado (v: View){
        this.arrayNumeros.add(textViewResultado.text.toString().toLong())
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
        Toast.makeText(this@MainActivity, "Resultado", Toast.LENGTH_LONG).show()
        Log.d("numero-debug", "Resultado: " + this.calculadora)

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
