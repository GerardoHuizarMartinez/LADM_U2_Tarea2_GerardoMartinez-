package mx.edu.ittepic.ladm_u2_tarea2_gerardohuizar

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class HiloControl (p:MainActivity) : Thread(){
    private var iniciado = false
    private var puntero = p
    private var pausa = false


    override fun run() {
        super.run()
        iniciado = true
        while(iniciado){
            sleep(300)
            if(!pausa){
                puntero.runOnUiThread {
                            puntero.textView.setBackgroundColor(puntero.arcoiris[puntero.contador])
                            puntero.contador++


                            if(puntero.contador==11){
                                puntero.contador=0
                    }

                }
            }
        }

    }

    fun estaIniciado(): Boolean {
        return iniciado
    }

    fun pausar() {
        pausa = true
    }

    fun despausar() {
        pausa = false
    }

    fun detener() {
        iniciado = false
    }
}