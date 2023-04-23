package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val btnCalcular: Button = findViewById<Button>(R.id.btnCalcular)
        val edtweight: EditText = findViewById(R.id.edt_weight)
        val edtHeight: EditText = findViewById (R.id.edt_height)



        btnCalcular.setOnClickListener {

            val heightStr = edtHeight.text.toString ()
            val weightStr = edtweight.text.toString()

            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                val height: Float = heightStr.toFloat()
                val weight: Float = weightStr.toFloat()

                val newHeight: Float = height * height
                val result: Float = weight/ newHeight


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }

                startActivity(intent)
            } else {
                Toast.makeText(this,"Preencher todos os campos", Toast.LENGTH_LONG).show()
            }


        }
    }
}