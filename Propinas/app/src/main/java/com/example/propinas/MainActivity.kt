package com.example.propinas

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.title="Propinas"

        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setLogo(R.mipmap.ic_launcher)
        actionBar.setDisplayUseLogoEnabled(true)

        btnCalcular.setOnClickListener {
            Toast.makeText(this@MainActivity, "Mesaje",Toast.LENGTH_SHORT).show()
            calcularPropina()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.configuracion->{
                cargarActividad()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun cargarActividad(){
        val intent:Intent = Intent(getBaseContext(),ConfiguracionActivity::class.java)
        startActivity(intent)
    }
    fun getPorcentaj(){
        val preferencia: SharedPreferences =this.getSharedPreferences(
            "AppPreferences",
            Context.MODE_PRIVATE
        )
        val porcentaje : String? = preferencia.getString(
            "PorcentajePropina",
            "10"
        )
        texPercentaje.text = porcentaje
    }

    override fun onStart() {
        super.onStart()
        getPorcentaj()
    }

    fun calcularPropina(){
        val cantidad = inputCanti.text.toString().toDouble()
        var porcentaje = texPercentaje.text.toString().toDouble()

        val propina = cantidad * porcentaje/100
        txtPropina.text = "La propina es de $"+propina.toString()

        texToltal.text = "El total a pagar es de $"+(propina+cantidad).toString()
    }
}
