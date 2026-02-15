package com.example.remotecontrolserver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.remotecontrolserver.databinding.ActivityMainBinding
import com.example.remotecontrolserver.runtime.RemoteControlRuntime

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var runtime: RemoteControlRuntime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        runtime = RemoteControlRuntime { status ->
            runOnUiThread {
                binding.statusTextView.text = status
            }
        }

        runtime.start()
        runtime.injectInput("TAP")
    }

    override fun onDestroy() {
        runtime.stop()
        super.onDestroy()
    }
}
