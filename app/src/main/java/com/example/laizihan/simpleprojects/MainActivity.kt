package com.example.laizihan.simpleprojects

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView.setImageBitmap(SimpleJava.createQrCodeBitmap("https://www.baidu.com", 400, 400, 1))
    }


    fun createQrCodeBitmap(content: String, w: Int, h: Int, margin: Int): Bitmap? {
        var bitmap: Bitmap? = null
        try {

            //生成二维矩阵,编码时指定大小,不要生成了图片以后再进行缩放,这样会模糊导致识别失败
            val hints = HashMap<EncodeHintType, Any>()
            hints[EncodeHintType.CHARACTER_SET] = "utf-8"
            hints[EncodeHintType.MARGIN] = margin
            val matrix = MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, w, h, hints)
            val width = matrix.width
            val height = matrix.height
            //二维矩阵转为一维像素数组,也就是一直横着排了
            val pixels = IntArray(width * height)
            for (y in 0 until height) {
                for (x in 0 until width) {
                    if (matrix.get(x, y)) {
                        pixels[y * width + x] = -0x1000000
                    } else {
                        pixels[y * width + x] = Color.WHITE
                    }
                }
            }
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            //通过像素数组生成bitmap
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height)
            Log.e("tag","this is master commit")

        } catch (e: Throwable) {

        }
        return bitmap
    }


}
