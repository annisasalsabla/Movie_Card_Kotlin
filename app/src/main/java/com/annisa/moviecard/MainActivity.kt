package com.annisa.moviecard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //    private  lateinit var txtView1 :
    private lateinit var btnMovie : Button


    //Cara :
    //declare variable widget beserta tipe widget nya
    //findview widget sesuai dengan yg di declare di layout xml
    //set on click --> agar bisa d klik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnMovie = findViewById(R.id.btnMovie)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnMovie.setOnClickListener(){
            //perpindahan dari page satu ke yg lain
            //intent
            //Intent implicit : intent yg kita buat sendiri
            //intent explicit : intent yg memanggil library atau class lain
            val intenMenu2 = Intent(this@MainActivity, RecycleViewCardMovie::class.java)
            startActivity(intenMenu2)
        }

        }
    }
