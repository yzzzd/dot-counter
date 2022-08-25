package com.yzzzd.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.yzzzd.counter.widget.dotcounter.view.CircularDotsCounter

class MainActivity : AppCompatActivity() {

    private lateinit var btnCounter: TextView
    private lateinit var vCounter: CircularDotsCounter

    private var currentCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCounter = findViewById(R.id.btn_counter)
        vCounter = findViewById(R.id.v_counter)

        btnCounter.setOnClickListener {
            if (currentCounter < 10) {
                currentCounter += 1
                btnCounter.text = "$currentCounter Gerak"
                vCounter.setCounter(currentCounter)
            }
        }
    }
}