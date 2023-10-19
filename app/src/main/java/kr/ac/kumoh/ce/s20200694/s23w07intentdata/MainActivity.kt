package kr.ac.kumoh.ce.s20200694.s23w07intentdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.ac.kumoh.ce.s20200694.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)
        main.btn1.setOnClickListener { Toast.makeText(this, "리메이크 전", Toast.LENGTH_SHORT).show() }
        main.btn2.setOnClickListener { Toast.makeText(this, "리메이크 후", Toast.LENGTH_SHORT).show() }

    }
}