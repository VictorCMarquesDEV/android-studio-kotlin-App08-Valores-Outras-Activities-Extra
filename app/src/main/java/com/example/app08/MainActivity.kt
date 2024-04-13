package com.example.app08

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.app08.databinding.ActivityMainBinding

// App08: Usar valores de outros Activities com Extra

class MainActivity : ComponentActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var result: ActivityResultLauncher<Intent>
    private  var nome = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonMudarNome.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("n", nome)
            //startActivity(i)
            result.launch(i)
        }

        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.data != null && it.resultCode == 1){
                nome = it.data?.getStringExtra("n").toString()
                binding.textNome.text = "Olá, $nome"
            } else if (it.data != null && it.resultCode == 2){
                Toast.makeText(applicationContext, "Operação Cancelada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Erro ao atualizar o nome", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
