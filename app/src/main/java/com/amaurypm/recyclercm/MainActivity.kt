package com.amaurypm.recyclercm

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.amaurypm.recyclercm.databinding.ActivityMainBinding
import com.amaurypm.recyclercm.model.Movie

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val movies = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        repeat(1000){ index ->
            val movieTmp = Movie(
                id = index.toLong(),
                title = "Título ${index + 1}",
                type = "Categoría ${index + 1}",
                date = "Fecha ${index + 1}"
            )
            movies.add(movieTmp)
        }

        val adapter = MovieAdapter(
            movies
        ){ selectedMovie ->
            Toast.makeText(
                this,
                "Clic en la película ${selectedMovie.title} con id: ${selectedMovie.id}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.apply {
            //establecemos el layout que va a usar nuestro listado
            rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
            //establecemos el adapter que va a usar el recyclerview
            rvMain.adapter = adapter
        }
    }
}