package com.example.miniactivitat2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var mStartForResult: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            val data: Intent? = it.data
            val message = data?.getStringExtra("message")
            val bienvenidaTextView: TextView = findViewById(R.id.title_text_view)
            bienvenidaTextView.text = message
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goButton: Button = findViewById(R.id.go_button)
        goButton.setOnClickListener {
            val nameEditText: EditText = findViewById(R.id.text_to_repeat_editText)
            val messageEditText: EditText = findViewById(R.id.times_to_repeat_editText)
            val textToRepeat = nameEditText.text.toString()
            val timesToRepeat = messageEditText.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            if (textToRepeat.isEmpty() || timesToRepeat.isEmpty()) {
                return@setOnClickListener
            }

            intent.putExtra("textToRepeat", textToRepeat)
            intent.putExtra("timesToRepeat", timesToRepeat)
            nameEditText.text.clear()
            messageEditText.text.clear()
            mStartForResult.launch(intent)
        }
    }
}