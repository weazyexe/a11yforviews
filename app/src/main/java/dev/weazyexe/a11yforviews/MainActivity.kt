package dev.weazyexe.a11yforviews

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import dev.weazyexe.a11yforviews.contrast.ContrastActivity
import dev.weazyexe.a11yforviews.customviews.CustomViewsActivity
import dev.weazyexe.a11yforviews.databinding.ActivityMainBinding
import dev.weazyexe.a11yforviews.liveregion.LiveRegionActivity
import dev.weazyexe.a11yforviews.text.TextActivity
import dev.weazyexe.a11yforviews.traversal.TraversalActivity

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
        contrastButton.setOnClickListener { openActivity(ContrastActivity::class.java) }
        customViewsButton.setOnClickListener { openActivity(CustomViewsActivity::class.java) }
        focusOrderButton.setOnClickListener { openActivity(TraversalActivity::class.java) }
        liveRegionButton.setOnClickListener { openActivity(LiveRegionActivity::class.java) }
    }

    private fun <T : Activity> openActivity(activityClass: Class<T>) {
        Intent(this, activityClass).apply {
            startActivity(this)
        }
    }
}