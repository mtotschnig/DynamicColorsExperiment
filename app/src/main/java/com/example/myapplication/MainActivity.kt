package com.example.myapplication

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.color.DynamicColors
import com.google.android.material.color.DynamicColorsOptions


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun attachBaseContext(newBase: Context?) {
        val config = Configuration()
        config.fontScale = 1.5f
        applyOverrideConfiguration(config)
        super.attachBaseContext(newBase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DynamicColors.applyToActivityIfAvailable(
            this,
            DynamicColorsOptions.Builder()
                .setContentBasedSource(Color.GREEN)
                .build()
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.german.setOnClickListener {
            AppCompatDelegate.setApplicationLocales(
                LocaleListCompat.forLanguageTags("de")
            )
        }
    }
}