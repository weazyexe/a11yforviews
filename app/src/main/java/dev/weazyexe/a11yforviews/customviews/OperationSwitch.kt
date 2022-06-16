package dev.weazyexe.a11yforviews.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import com.google.android.material.color.MaterialColors
import dev.weazyexe.a11yforviews.R
import dev.weazyexe.a11yforviews.databinding.ViewOperationSwitchBinding
import com.google.android.material.R as materialR


class OperationSwitch @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val binding = ViewOperationSwitchBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    init {
        initListeners()
        binding.depositButton.performClick()
        setupAccessibility()
    }

    private fun initListeners() = with(binding) {
        depositButton.setOnClickListener {
            depositButton.select()
            transferButton.deselect()
            updateStateDescription()
        }

        transferButton.setOnClickListener {
            transferButton.select()
            depositButton.deselect()
            updateStateDescription()
        }
    }

    private fun updateStateDescription() {
        ViewCompat.setStateDescription(
            binding.root,
            context.getString(
                if (binding.transferButton.isSelected) {
                    R.string.operation_switch_transfer_label
                } else {
                    R.string.operation_switch_deposit_label
                }
            )
        )
    }

    private fun setupAccessibility() = with(binding) {
        ViewCompat.replaceAccessibilityAction(
            root,
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK,
            // Строка "Toggle"
            context.getString(R.string.operation_switch_accessibility_toggle_action)
        ) { _, _ ->
            if (transferButton.isSelected) {
                depositButton.performClick()
            } else {
                transferButton.performClick()
            }
            true
        }

        ViewCompat.setAccessibilityDelegate(
            root,
            object : AccessibilityDelegateCompat() {
                override fun onInitializeAccessibilityNodeInfo(
                    host: View,
                    info: AccessibilityNodeInfoCompat
                ) {
                    super.onInitializeAccessibilityNodeInfo(host, info)
                    info.roleDescription = context.getString(R.string.role_description_switch)
                }
            }
        )
    }

    private fun Button.select() {
        isSelected = true
        setTextColor(
            MaterialColors.getColor(
                this,
                materialR.attr.colorOnPrimary
            )
        )
    }

    private fun Button.deselect() {
        isSelected = false
        setTextColor(
            MaterialColors.getColor(
                this,
                materialR.attr.colorPrimary
            )
        )
    }
}