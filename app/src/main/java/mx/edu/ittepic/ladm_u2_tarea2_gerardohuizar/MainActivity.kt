package mx.edu.ittepic.ladm_u2_tarea2_gerardohuizar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var contador = 0
    var hiloControl : HiloControl?=null

    var arcoiris :Array<Int> = Array(12){0}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arcoiris[0] = Color.YELLOW
        arcoiris[1] = Color.WHITE
        arcoiris[2] = Color.TRANSPARENT
        arcoiris[3] = Color.RED
        arcoiris[4] = Color.MAGENTA
        arcoiris[5] = Color.DKGRAY
        arcoiris[6] = Color.CYAN
        arcoiris[7] = Color.BLACK
        arcoiris[8] = Color.BLUE
        arcoiris[9] = Color.GREEN
        arcoiris[10] = Color.GRAY
        arcoiris[11] = Color.LTGRAY

        //arcoiris[12]= Color.rgb(248,212,46)




        hiloControl = HiloControl(this)
        setTitle("ESTADO: "+hiloControl!!.isAlive)

        button.setOnClickListener {
            try {
                if(hiloControl!!.estaIniciado()){
                    Mensaje("Error, hilo ya está iniciado")
                    return@setOnClickListener
                }
                hiloControl?.start()
                setTitle("ESTADO: "+ "El hilo esta INICIADO")
            }catch (e:Exception){
                setTitle("ESTADO: "+hiloControl!!.isAlive)
                Mensaje("EXCEPCION: Hilo ya fue detenido")
            }
        }

        button2.setOnClickListener {
            hiloControl?.pausar()
            setTitle("ESTADO: "+ "El hilo esta PAUSADO")
        }

        button3.setOnClickListener {
            hiloControl?.despausar()
            setTitle("ESTADO: "+ "El hilo a sido DESPAUSADO")
        }

        button4.setOnClickListener {
            contador = 0
            setTitle("ESTADO: "+ "El hilo a sido REINICIADO")
        }

        button5.setOnClickListener {
            hiloControl!!.detener()
            setTitle("ESTADO: "+ "Mataste al hilo uwu")
        }
    }

    private fun Mensaje(s: String) {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("ATENCION")
            .setPositiveButton("OK"){d,i->}
            .show()
    }
}


