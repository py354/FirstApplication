package com.example.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun method(view: View) {
        if ((findViewById<EditText>(R.id.inputName)).text.isEmpty()
            || (findViewById<EditText>(R.id.inputHeight)).text.isEmpty()
            || (findViewById<EditText>(R.id.inputWeight)).text.isEmpty()
            || (findViewById<EditText>(R.id.inputAge)).text.isEmpty()
        ) {
            Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show()
        } else {
            val heightOfUser =
                (findViewById<EditText>(R.id.inputHeight)).text.toString().toInt()
            val weightOfUser =
                (findViewById<EditText>(R.id.inputWeight)).text.toString().toDouble()
            val ageOfUser =
                (findViewById<EditText>(R.id.inputAge)).text.toString().toInt()


            if (heightOfUser !in 0..250) {
                Toast.makeText(this, "Рост должен быть от 0 до 250", Toast.LENGTH_SHORT).show()
            } else if (weightOfUser !in 0.0..250.0) {
                Toast.makeText(this, "Вес должен быть от 0 до 250", Toast.LENGTH_SHORT).show()
            } else if (ageOfUser !in 0..150) {
                Toast.makeText(this, "Возраст должен быть от 0 до 150", Toast.LENGTH_SHORT).show()
            } else {
                val dur = (ageOfUser*10 + weightOfUser) / 500.0 * 100.0
                findViewById<TextView>(R.id.textView).text = "Ваш срок по ипотеке $dur лет"
            }
        }
    }
}