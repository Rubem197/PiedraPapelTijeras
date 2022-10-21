package com.example.piedrapapeltijeras

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity(), Comunicador {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun pulsarPapel() {
        volverInvisible()
        val papel = this.findViewById<ImageView>(R.id.imgPapel2)
        val eleccionMaquina = aleatorioMaquina()

        eleccionMaquina.visibility = View.VISIBLE
        papel.visibility = View.VISIBLE

        mostrarResultado(papel, eleccionMaquina)
    }

    override fun pulsarPiedra() {

        volverInvisible()
        val piedra = this.findViewById<ImageView>(R.id.imgPiedra2)

        val eleccionMaquina= aleatorioMaquina()

        eleccionMaquina.visibility = View.VISIBLE
        piedra.visibility = View.VISIBLE

        mostrarResultado(piedra, eleccionMaquina)
    }

    override fun pulsarTijeras() {

        volverInvisible()
        val tijeras = this.findViewById<ImageView>(R.id.imgTijeras2)

        val eleccionMaquina= aleatorioMaquina()

        eleccionMaquina.visibility = View.VISIBLE
        tijeras.visibility = View.VISIBLE

        mostrarResultado(tijeras, eleccionMaquina)
    }

    private fun volverInvisible(){
        val papel = this.findViewById<ImageView>(R.id.imgPapel2)
        val piedra = this.findViewById<ImageView>(R.id.imgPiedra2)
        val tijeras = this.findViewById<ImageView>(R.id.imgTijeras2)

        papel.visibility = View.INVISIBLE
        piedra.visibility = View.INVISIBLE
        tijeras.visibility = View.INVISIBLE
    }

    private fun mostrarResultado(eleccionJugador: ImageView, eleccionMaquina: ImageView){

        val papelJug = this.findViewById<ImageView>(R.id.imgPapel2)
        val piedraJug = this.findViewById<ImageView>(R.id.imgPiedra2)
        val tijerasJug = this.findViewById<ImageView>(R.id.imgTijeras2)

        val papelMaq = this.findViewById<ImageView>(R.id.imgPapel)
        val piedraMaq = this.findViewById<ImageView>(R.id.imgPiedra)
        val tijerasMaq = this.findViewById<ImageView>(R.id.imgTijeras)

        if (eleccionJugador==papelJug && eleccionMaquina== piedraMaq){
            mensajeVictoria().show()
        }
        else if (eleccionJugador==piedraJug && eleccionMaquina== tijerasMaq){
            mensajeVictoria().show()
        }
        else if(eleccionJugador==tijerasJug && eleccionMaquina== papelMaq){
            mensajeVictoria().show()
        }
    }

    fun mensajeVictoria():AlertDialog{

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Victoria!!!!")
        builder.setMessage("Has ganado a la máqina")
        builder.setPositiveButton("Aceptar", null)

        val mostrarVictoria = builder.create()

        return mostrarVictoria
    }

    private fun aleatorioMaquina(): ImageView {
        val papel = this.findViewById<ImageView>(R.id.imgPapel)
        val piedra = this.findViewById<ImageView>(R.id.imgPiedra)
        val tijeras = this.findViewById<ImageView>(R.id.imgTijeras)

        papel.visibility = View.INVISIBLE
        piedra.visibility = View.INVISIBLE
        tijeras.visibility = View.INVISIBLE

        val arrayFotos = arrayOf(papel, piedra, tijeras)


        val eleccionRandom = arrayFotos[(0..2).random()]


        return eleccionRandom
    }
}