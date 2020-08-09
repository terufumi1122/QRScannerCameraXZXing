package com.example.qrscannercameraxzxing

import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.util.AndroidRuntimeException
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.activity_create_qr.*

private val TAG = CreateQrActivity::class.java.simpleName

class CreateQrActivity : AppCompatActivity() {

    private var data = "https://www.google.com" // TODO ここを可変にする
    private val size = 500 // TODO ここを可変にする

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_qr)

        editText.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                try {
                    data = editText.text.toString()
                    val barcodeEncoder = BarcodeEncoder()
                    val bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, size, size)

                    val imageQr = findViewById<ImageView>(R.id.imageView)
                    imageQr.setImageBitmap(bitmap)
                } catch (e: WriterException) {
                    throw AndroidRuntimeException("Barcode Error", e)
                }
            }

        })
    }

}