package uz.datatalim.share

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var bcnopka2:Button
    var IMAGE_BULL = 1234
    lateinit var ivbull:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    private fun initViews(){
        bcnopka2 = findViewById(R.id.b_cnopka2)
        ivbull = findViewById(R.id.iv_bull)


        bcnopka2.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(Intent.createChooser(intent,"Select ones"),IMAGE_BULL)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (IMAGE_BULL == requestCode && resultCode == RESULT_OK){
            val uri = data?.data

            ivbull.setImageURI(uri)
        }
    }
}