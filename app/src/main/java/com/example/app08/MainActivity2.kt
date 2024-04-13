package com.example.app08

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.app08.databinding.ActivityMain2Binding

class MainActivity2 : ComponentActivity() {

    private lateinit var binding : ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent
        val nome = i.extras?.getString("n")
        binding.editNome.setText(nome)

        binding.buttonOK.setOnClickListener {
            i.putExtra("n", binding.editNome.text.toString())
            setResult(1, i)
            finish()
        }
        binding.buttonCancelar.setOnClickListener {
            setResult(2, i)
            finish()
        }
    }
}
