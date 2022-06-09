package dev.weazyexe.a11yforviews

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import dev.weazyexe.a11yforviews.databinding.ActivityMainBinding
import dev.weazyexe.a11yforviews.text.TextActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        initListeners()
    }

    private fun initListeners() = with(binding) {
        textButton.setOnClickListener { openActivity(TextActivity::class.java) }
    }

    private fun <T : Activity> openActivity(activityClass: Class<T>) {
        Intent(this, activityClass).apply {
            startActivity(this)
        }
    }
}