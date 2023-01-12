package com.example.repaso06

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.view.isVisible

import com.example.repaso06.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextTextPersonName.isVisible=false
        binding.imageView.isVisible =false
        binding.button.setOnClickListener(){
            binding.editTextTextPersonName.isVisible=true
            if(binding.button.text.toString().equals("Comenzar"))
                binding.button.text="Finalizar"
            else
                if(binding.button.text.toString().equals("Finalizar")){
                    binding.button.text="Comenzar"
                    binding.editTextTextPersonName.isVisible=false
                }


        }
        binding.editTextTextPersonName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.imageView.isVisible = binding.editTextTextPersonName.text.toString().equals("Wayne")
                if( binding.editTextTextPersonName.text.toString().contains("joker"))
                    binding.fondo.setBackgroundColor(Color.parseColor("#ffcc00"))
                if( !binding.editTextTextPersonName.text.toString().contains("joker"))
                    binding.fondo.setBackgroundColor(Color.parseColor("#ffffff"))

            }


        })

        binding.editTextTextPersonName.setOnFocusChangeListener(){x, focus ->
            if (!focus)
                binding.editTextTextPersonName.text.clear()
        }
    }
}