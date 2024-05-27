import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import lab2var15.composeapp.generated.resources.Res
import lab2var15.composeapp.generated.resources.compose_multiplatform

@Composable
fun TimeElapsedScreen(bloc: TimeElapsedBloc) {
    val state by bloc.state.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Days: ${state.days}")
            Text(text = "Hours: ${state.hours}")
            Text(text = "Minutes: ${state.minutes}")
            Text(text = "Seconds: ${state.seconds}")
        }
    }
}