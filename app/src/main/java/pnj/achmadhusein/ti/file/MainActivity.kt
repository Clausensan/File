package pnj.achmadhusein.ti.file

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var actionBuat: Button
    lateinit var actionUbah: Button
    lateinit var actionBaca: Button
    lateinit var actionHapus: Button
    lateinit var edtInput: EditText

    private val fileName = "example.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        actionBuat = findViewById(R.id.actionBuat)
        actionUbah = findViewById(R.id.actionUbah)
        actionBaca = findViewById(R.id.actionBaca)
        actionHapus = findViewById(R.id.actionHapus)
        edtInput = findViewById(R.id.edtInput)

        actionBuat.setOnClickListener {
            buatFile()
        }

        actionUbah.setOnClickListener {
            ubahFile()
        }

        actionBaca.setOnClickListener {
            bacaFile()
        }

        actionHapus.setOnClickListener {
            hapusFile()
        }
    }

    private fun buatFile() {
        val text = edtInput.text.toString()
        val fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE)
        fileOutputStream.use {
            it.write(text.toByteArray())
        }
        edtInput.setText("")
    }

    private fun ubahFile() {
        val text = edtInput.text.toString()
        val fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE)
        fileOutputStream.use {
            it.write(text.toByteArray())
        }
        edtInput.setText("")
    }

    private fun bacaFile() {
        val fileInputStream = openFileInput(fileName)
        val text = fileInputStream.bufferedReader().useLines { lines ->
            lines.fold("") { some, text ->
                "$some\n$text"
            }
        }
        edtInput.setText(text.trim())
    }

    private fun hapusFile() {
        val file = File(filesDir, fileName)
        if (file.exists()) {
            file.delete()
        }
        edtInput.setText("")
    }
}
