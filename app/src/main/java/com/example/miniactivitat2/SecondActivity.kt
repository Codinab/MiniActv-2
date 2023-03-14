package com.example.miniactivitat2

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    var editText: EditText? = null
    val button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        intent.extras?.let {
            val textToRepeat = it.getString("textToRepeat")
            val timesToRepeat = it.getString("timesToRepeat")
            val messageTextView: TextView = findViewById(R.id.message_text_view)
            messageTextView.text = textToRepeat?.repeat(timesToRepeat?.toInt() ?: 1)
            intent.putExtra("message", messageTextView.text)
        }

        val goBackButton: Button = findViewById(R.id.go_back_button)
        goBackButton.setOnClickListener {
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}