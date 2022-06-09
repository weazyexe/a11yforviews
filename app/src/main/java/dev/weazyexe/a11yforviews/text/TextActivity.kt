package dev.weazyexe.a11yforviews.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import dev.weazyexe.a11yforviews.databinding.ActivityTextBinding

class TextActivity : ComponentActivity() {

    private val binding by lazy { ActivityTextBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}