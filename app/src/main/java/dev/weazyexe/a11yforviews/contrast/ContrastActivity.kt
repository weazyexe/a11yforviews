package dev.weazyexe.a11yforviews.contrast

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import dev.weazyexe.a11yforviews.databinding.ActivityContrastBinding

class ContrastActivity : AppCompatActivity() {

    private val binding by lazy { ActivityContrastBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}