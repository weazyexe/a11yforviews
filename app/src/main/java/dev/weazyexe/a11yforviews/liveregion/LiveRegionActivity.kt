package dev.weazyexe.a11yforviews.liveregion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import dev.weazyexe.a11yforviews.databinding.ActivityLiveRegionBinding

class LiveRegionActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLiveRegionBinding.inflate(layoutInflater) }

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        binding.incrementButton.setOnClickListener {
            binding.valueFirstTv.text = (++counter).toString()
        }
    }
}