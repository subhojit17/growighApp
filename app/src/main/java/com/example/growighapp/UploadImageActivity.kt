package com.example.growighapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

private const val SELECT_IMAGE_REQUEST_CODE = 17
class UploadImageActivity : AppCompatActivity() {
    private lateinit var selectImageButton: Button
    private lateinit var uploadImageButton: Button
    private lateinit var imageView: ImageView
    private lateinit var back: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_image)
        imageView=findViewById(R.id.show_image)
        back=findViewById(R.id.back_button)
        back.setOnClickListener{
            finish()
        }
        selectImageButton=findViewById(R.id.select_image)
        selectImageButton.setOnClickListener{
            // Open the image gallery
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, SELECT_IMAGE_REQUEST_CODE)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SELECT_IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            val selectedImageUri = data?.data
            // Handle the selected image URI, e.g., display it in an ImageView
            imageView.setImageURI(selectedImageUri)
        }
    }

}