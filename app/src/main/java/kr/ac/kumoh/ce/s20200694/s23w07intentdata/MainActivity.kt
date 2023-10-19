package kr.ac.kumoh.ce.s20200694.s23w07intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.ac.kumoh.ce.s20200694.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val KEY_NAME = "soraka"
    }
    private lateinit var main: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)
        main.btn1.setOnClickListener {
            Toast.makeText(this, "리메이크 전", Toast.LENGTH_SHORT).show()
        var intent = Intent(this, ImageActivity::class.java)
            intent.putExtra(KEY_NAME, "rem1")
            startActivity(intent)
        }
        main.btn2.setOnClickListener {
            Toast.makeText(this, "리메이크 후", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, ImageActivity::class.java)
            intent.putExtra(KEY_NAME, "rem2")
            startActivity(intent)

        }

    }
}