package kr.ac.kumoh.ce.s20200694.s23w07intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import kr.ac.kumoh.ce.s20200694.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    companion object {
        const val KEY_NAME = "soraka"
        const val REM1 = "rem1"
        const val REM2 = "rem2"
    }
    private lateinit var main: ActivityMainBinding
    private val startforResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult())
    {
        if(it.resultCode != RESULT_OK)
            return@registerForActivityResult
        val result = it.data?.getIntExtra(
           // ImageActivity.IMAGE_RESULT, //string타입
            // ImageActivity.NONE //null의 int타입 : 디폴트
            AnotherActivity.IMAGE_RESULT, //string타입
            AnotherActivity.NONE //null의 int타입 : 디폴트
        )
        val str = when(result){
            //ImageActivity.LIKE -> "좋아요"
            //ImageActivity.DISLIKE -> "싫어요"
            AnotherActivity.LIKE -> "좋아요"
            AnotherActivity.DISLIKE -> "싫어요"
            else -> "error"
        }
        when(it.data?.getStringExtra(ImageActivity.IMAGE_NAME)) {
            REM1 -> main.btn1.text = "리메이크전($str)"
            REM2 -> main.btn2.text = "리메이크후($str)"
        }//리메이크 전이냐, 리메이크 후냐
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)
        main.btn1.setOnClickListener(this)
        main.btn2.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val value = when(v?.id){
            main.btn1.id -> {
                Toast.makeText(this, "리메이크 전", Toast.LENGTH_SHORT).show()
                REM1
            }
            main.btn2.id -> {
                Toast.makeText(this, "리메이크 후", Toast.LENGTH_SHORT).show()
                REM2
            }
            else -> return
        }

        var intent = Intent(this, ImageActivity::class.java)
        intent.putExtra(KEY_NAME, value)
        //startActivity(intent)
        startforResult.launch(intent)


    }
}