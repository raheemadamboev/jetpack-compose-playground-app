package xyz.teamgravity.gradientcard

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var size by remember { mutableStateOf(200.dp) }
            val sizeAnimation by animateDpAsState(
                targetValue = size,
                animationSpec = tween(
                    durationMillis = 3000,
                    delayMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )

            val infiniteTransition = rememberInfiniteTransition()
            val color by infiniteTransition.animateColor(
                initialValue = Color.Red,
                targetValue = Color.Green,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 2000),
                    repeatMode = RepeatMode.Reverse
                )
            )

            Box(
                modifier = Modifier
                    .size(sizeAnimation)
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    size += 50.dp
                }) {
                    Text(text = "Click me")
                }
            }
        }
    }
}