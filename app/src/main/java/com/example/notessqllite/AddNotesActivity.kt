package com.example.notessqllite

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notessqllite.databinding.ActivityMainBinding
import com.example.notessqllite.databinding.ActivityAddNotesBinding


class AddNotesActivity : AppCompatActivity() {
    
    
    private  lateinit var binding: ActivityAddNotesBinding
    private lateinit var db: NotesDataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDataBaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val content = binding.ContentEditText.text.toString()
            val note = Note(0, title, content)
            db.insertNote(note)
            Toast.makeText(this,"Note Saved", Toast.LENGTH_SHORT).show()
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}