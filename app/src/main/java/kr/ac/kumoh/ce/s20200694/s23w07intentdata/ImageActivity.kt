package kr.ac.kumoh.ce.s20200694.s23w07intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import kr.ac.kumoh.ce.s20200694.s23w07intentdata.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity(), OnClickListener{
    private lateinit var main: ActivityImageBinding
    private lateinit var imageName: String
    companion object{
        const val IMAGE_NAME = "image name"
        const val IMAGE_RESULT = "image result"

        const val LIKE = 100
        const val DISLIKE = 101
        const val NONE = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityImageBinding.inflate(layoutInflater)
        setContentView(main.root)
        Log.i("Image!!!", intent.getStringExtra("soraka") ?: "없음")

        imageName = intent.getStringExtra(MainActivity.KEY_NAME) ?: "none"
        val res = when(intent.getStringExtra(MainActivity.KEY_NAME)) {
            MainActivity.REM1 -> R.drawable.rem1
            MainActivity.REM2 -> R.drawable.rem2
            else -> R.drawable.ic_launcher_foreground
        }
        main.image.setImageResource(res)

        main.btnLike.setOnClickListener(this)
        main.btnDislike.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        val value = when(v?.id){
            main.btnLike.id -> LIKE
            main.btnDislike.id -> DISLIKE
            else -> NONE

        }
        intent.putExtra(IMAGE_NAME, imageName)
        intent.putExtra(IMAGE_RESULT, value)
        setResult(RESULT_OK, intent)
        finish()
    }
}