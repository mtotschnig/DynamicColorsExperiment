package com.example.myapplication

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.preference.PreferenceManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.color.DynamicColors
import com.google.android.material.color.DynamicColorsOptions


private const val KEY_FONT_SCALE = "fontScale"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        PreferenceManager.getDefaultSharedPreferences(this).getFloat(KEY_FONT_SCALE, 0F).takeIf {
            it != 0F
        }?.let {
            val config = Configuration()
            config.fontScale = it
            applyOverrideConfiguration(config)
        }

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
        binding.fontScale.setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putFloat(KEY_FONT_SCALE, 1.5f).apply()
            recreate()
        }
    }
}