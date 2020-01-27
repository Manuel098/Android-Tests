package com.example.propinas

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_configuracion.*

class ConfiguracionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        acept.setOnClickListener {
            Toast.makeText(this@ConfiguracionActivity, "Okay :D",Toast.LENGTH_SHORT).show()
            savePropina()
        }
    }



    fun savePropina(){
        val preferencias :SharedPreferences = this.getSharedPreferences(
            "AppPreferences",
            Context.MODE_PRIVATE
        )
        val editPreferences : SharedPreferences.Editor = preferencias.edit()
        editPreferences.putString(
            "PorcentajePropina", edtPorcentaje.text.toString()
        )
        editPreferences.commit()
        this.finish()
    }
}
