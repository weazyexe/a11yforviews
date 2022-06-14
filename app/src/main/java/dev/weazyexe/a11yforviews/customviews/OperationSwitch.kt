package dev.weazyexe.a11yforviews.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import com.google.android.material.color.MaterialColors
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
        binding.depositButton.select()
    }

    private fun initListeners() = with(binding) {
        depositButton.setOnClickListener {
            depositButton.select()
            transferButton.deselect()
        }

        transferButton.setOnClickListener {
            transferButton.select()
            depositButton.deselect()
        }
    }

    private fun Button.select() {
        isSelected = true
        setTextColor(
            MaterialColors.getColor(
                this@OperationSwitch,
                materialR.attr.colorOnPrimary
            )
        )
    }

    private fun Button.deselect() {
        isSelected = false
        setTextColor(
            MaterialColors.getColor(
                this@OperationSwitch,
                materialR.attr.colorPrimary
            )
        )
    }
}