package com.bignerdranch.andriod.traffic_light

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var trafficLightImage: ImageView
    private lateinit var trafficLightButton: Button
    private var currentState = TrafficLightState.RED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trafficLightImage = findViewById(R.id.traffic_light_image)
        trafficLightButton = findViewById(R.id.traffic_light_button)

        trafficLightButton.setOnClickListener {
            currentState = when (currentState) {
                TrafficLightState.RED -> TrafficLightState.GREEN
                TrafficLightState.GREEN -> TrafficLightState.YELLOW
                TrafficLightState.YELLOW -> TrafficLightState.RED
            }
            updateTrafficLight()
        }

        updateTrafficLight()
    }

    private fun updateTrafficLight() {
        when (currentState) {
            TrafficLightState.RED -> {
                trafficLightImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.red_light))
                trafficLightButton.text = "STOP"
            }
            TrafficLightState.GREEN -> {
                trafficLightImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.green_light))
                trafficLightButton.text = "GO"
            }
            TrafficLightState.YELLOW -> {
                trafficLightImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.yellow_light))
                trafficLightButton.text = "WAIT"
            }
        }
    }

    private enum class TrafficLightState {
        RED, GREEN, YELLOW
    }
}
