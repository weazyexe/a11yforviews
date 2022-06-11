package dev.weazyexe.a11yforviews.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import dev.weazyexe.a11yforviews.databinding.ViewWalletCardBinding

class WalletCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val binding = ViewWalletCardBinding.inflate(
        LayoutInflater.from(context), this, true
    )
}