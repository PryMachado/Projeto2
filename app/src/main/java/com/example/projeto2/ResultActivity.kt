package com.example.projeto2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult= findViewById<TextView>(R.id.textview_result)
        val tvclassificacao= findViewById<TextView>(R.id.textview_Classificacao)

        val result= intent.getFloatExtra("EXTRA_RESULT",0.1f)

        tvResult.text= result.toString()

        /*
    * MENOR QUE 18,5 ABAIXO DO PESO
    * ENTRE 18,5 E 24,9 NORMAL
    * ENTRE 25,0 E 29,0	SOBREPESO I
    * ENTRE 30,0 E 39,9	OBESIDADE II
    * MAIOR QUE 40,0 OBSEDIDADE GRAVE III
   */

        val classificacao= if (result< 18.5f) {
            "ABAIXO DO PESO"
        } else if(result in 18.5f..24.9f) {
            "normal"
        } else if(result in 25f..29.9f) {
            "SOBREPESO"
        } else if(result in 30f..39.9f) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"

        }
            tvclassificacao.text = getString(R.string.message_classificacao,classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
    }




