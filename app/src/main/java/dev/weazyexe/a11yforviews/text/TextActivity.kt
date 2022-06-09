package dev.weazyexe.a11yforviews.text

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import dev.weazyexe.a11yforviews.databinding.ActivityTextBinding

class TextActivity : AppCompatActivity() {

    private val binding by lazy { ActivityTextBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}