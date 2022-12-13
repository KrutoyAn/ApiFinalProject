package com.hfad.apifinalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.hfad.apifinalproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private companion object {

        private const val INTERVAL = 100L
        private const val PERIOD = 1000L * 10
        private const val PERIOD_VIEW_TWO = 1000L * 30
        private const val PERIOD_VIEW_THREE = 1000L * 35
        private const val REPEAT = 10
    }
    private lateinit var binding: ActivityMainBinding
    private var current = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.customViewOne.setPeriod(PERIOD)
        binding.customViewTwo.setPeriod(PERIOD_VIEW_TWO)
        binding.customViewThree.setPeriod(PERIOD_VIEW_THREE)

        lifecycleScope.launch {
            while (current < PERIOD * REPEAT) {
                current += INTERVAL
                binding.customViewOne.setCurrent(current)
                binding.customViewTwo.setCurrent(current)
                binding.customViewThree.setCurrent(current)
                delay(INTERVAL)
            }
        }
    }
}


