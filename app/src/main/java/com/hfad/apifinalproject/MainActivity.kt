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
        private const val PERIOD = 1000L * 30 // 30 sec
        private const val REPEAT = 10 // 10 times
    }
    private lateinit var binding: ActivityMainBinding
    private var current = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.customViewOne.setPeriod(PERIOD)
        binding.customViewTwo.setPeriod(PERIOD)

        lifecycleScope.launch {
            while (current < PERIOD * REPEAT) {
                current += INTERVAL
                binding.customViewOne.setCurrent(current)
                binding.customViewTwo.setCurrent(current)
                delay(INTERVAL)
            }
        }
    }
}


