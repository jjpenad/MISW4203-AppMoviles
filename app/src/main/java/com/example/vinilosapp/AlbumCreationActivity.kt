package com.example.vinilosapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.vinilosapp.data.model.Album
import com.example.vinilosapp.data.model.Song

class AlbumCreationActivity : AppCompatActivity() {
    private lateinit var songsAdapter: ArrayAdapter<Song>
    private val songsList = mutableListOf<Song>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_creation)

        // Aquí inicializas tu ListView con un adaptador y datos de ejemplo
        val listView = findViewById<ListView>(R.id.songsListView)
        songsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, songsList)
        listView.adapter = songsAdapter
        listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        // Agregar canciones de ejemplo
        songsList.add(Song("Tomalo", "Hillsong United"))
        songsList.add(Song("Siempre te Alabaré", "Planetshakers"))
        songsList.add(Song("Yeshua", "G12"))
        songsAdapter.notifyDataSetChanged()

        val createAlbumButton = findViewById<Button>(R.id.createAlbumButton)
        createAlbumButton.setOnClickListener {
            val albumName = findViewById<EditText>(R.id.albumNameEditText).text.toString()
            val albumDescription = findViewById<EditText>(R.id.albumDescriptionEditText).text.toString()
            val albumId = findViewById<EditText>(R.id.albumIdEditText).text.toString()
            val albumCover = findViewById<EditText>(R.id.albumCoverEditText).text.toString()
            val albumReleasedate = findViewById<EditText>(R.id.albumReleasedateEditText).text.toString()
            val albumGenre = findViewById<EditText>(R.id.albumGenreEditText).text.toString()
            val albumRecordlabel = findViewById<EditText>(R.id.albumRecordlabelEditText).text.toString()


            // Aquí recolectas las canciones seleccionadas
            val selectedSongs = songsList.filter { it.isSelected }

            // Crear el álbum
            val newAlbum = Album(albumName, albumDescription,albumId,albumCover,albumReleasedate,albumGenre,albumRecordlabel, selectedSongs)
            // Aquí deberías guardar el álbum en tu base de datos o backend
        }

        listView.setOnItemClickListener { adapterView, view, position, id ->
            // Cambiar el estado de selección de la canción
            val song = songsList[position]
            song.isSelected = !song.isSelected
            songsAdapter.notifyDataSetChanged()
        }
    }
}

