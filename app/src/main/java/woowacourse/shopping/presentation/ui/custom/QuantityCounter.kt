package woowacourse.shopping.presentation.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import woowacourse.shopping.databinding.CustomCounterQuantityBinding

class QuantityCounter(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var binding: CustomCounterQuantityBinding
    private var minValue: Int? = null
    private var maxValue: Int? = null

    init {
        initView()
    }

    private fun initView() {
        layoutInflater ?: run {
            layoutInflater = LayoutInflater.from(context)
            binding = CustomCounterQuantityBinding.inflate(layoutInflater!!, this, true)
        }
    }

    fun setIncreaseClickListener(action: () -> Unit) {
        binding.buttoncounterIncrease.setOnClickListener {
            action()
        }
    }

    fun setDecreaseClickListener(action: () -> Unit) {
        binding.buttonCounterDecrease.setOnClickListener {
            action()
        }
    }

    fun setQuantityText(quantity: Int) {
        binding.textCounterQuantity.text = quantity.toString()
        binding.buttonCounterDecrease.isEnabled = quantity != minValue
        binding.buttoncounterIncrease.isEnabled = quantity != maxValue
    }

    fun setMinValue(min: Int) {
        minValue = min
    }

    fun setMaxValue(max: Int) {
        maxValue = max
    }
}
