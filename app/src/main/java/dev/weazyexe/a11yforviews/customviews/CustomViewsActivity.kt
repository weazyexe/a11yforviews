package dev.weazyexe.a11yforviews.customviews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import dev.weazyexe.a11yforviews.databinding.ActivityCustomViewsBinding

class CustomViewsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCustomViewsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}