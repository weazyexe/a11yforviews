package dev.weazyexe.a11yforviews.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import dev.weazyexe.a11yforviews.R
import dev.weazyexe.a11yforviews.databinding.ViewWalletCardBinding

class WalletCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val binding = ViewWalletCardBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    init {
        parseAttributes(attrs)
    }

    private fun parseAttributes(attrs: AttributeSet?) = with(binding) {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.WalletCard)
        titleTv.text = attributes.getString(R.styleable.WalletCard_wallet_card_title)
        balanceTv.text = attributes.getString(R.styleable.WalletCard_wallet_card_balance)
        addressTv.text = attributes.getString(R.styleable.WalletCard_wallet_card_address)
        attributes.recycle();
    }
}