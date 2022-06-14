package dev.weazyexe.a11yforviews.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
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

    private fun parseAttributes(attrs: AttributeSet?) {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.WalletCard)
        val title = attributes.getString(R.styleable.WalletCard_wallet_card_title).orEmpty()
        val balance = attributes.getString(R.styleable.WalletCard_wallet_card_balance).orEmpty()
        val address = attributes.getString(R.styleable.WalletCard_wallet_card_address).orEmpty()
        attributes.recycle()

        setupAccessibility()
        setData(title, balance, address)
    }

    fun setData(
        title: String,
        balance: String,
        address: String
    ) = with(binding) {
        titleTv.text = title
        balanceTv.text = balance
        addressTv.text = address
        // Строка со значением "Wallet card: %s, balance is %s"
        root.contentDescription = context.getString(
            R.string.wallet_card_accessibility_description,
            title,
            balance
        )
    }

    private fun setupAccessibility() {
        ViewCompat.setAccessibilityDelegate(
            binding.root,
            object : AccessibilityDelegateCompat() {
                override fun onInitializeAccessibilityNodeInfo(
                    host: View,
                    info: AccessibilityNodeInfoCompat
                ) {
                    super.onInitializeAccessibilityNodeInfo(host, info)
                    val clickAction = AccessibilityNodeInfoCompat.AccessibilityActionCompat(
                        AccessibilityNodeInfoCompat.ACTION_CLICK,
                        // Строка со значением "View wallet details"
                        context.getString(R.string.wallet_card_accessibility_card_click_action)
                    )
                    info.addAction(clickAction)
                }
            }
        )

        ViewCompat.addAccessibilityAction(
            binding.root,
            // Строка "Show address QR code"
            context.getString(R.string.wallet_card_accessibility_show_qr_code_action)
        ) { _, _ ->
            // Открываем диалог с QR здесь
            Toast.makeText(context, "QR code has shown", Toast.LENGTH_SHORT).show()
            true
        }

        ViewCompat.addAccessibilityAction(
            binding.root,
            // Строка "Copy the wallet address"
            context.getString(R.string.wallet_card_accessibility_copy_the_address_action)
        ) { _, _ ->
            // Кладём строку с адресом в буфер обмена
            Toast.makeText(context, "Address has copied", Toast.LENGTH_SHORT).show()
            true
        }
    }
}