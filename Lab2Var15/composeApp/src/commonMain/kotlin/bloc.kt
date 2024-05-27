
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneId

data class TimeElapsedState(val days: Long, val hours: Long, val minutes: Long, val seconds: Long)

class TimeElapsedBloc {
    private val _state = MutableStateFlow(calculateTimeElapsed())
    val state: StateFlow<TimeElapsedState> = _state

    private val job = CoroutineScope(Dispatchers.Default).launch {
        while (isActive) {
            _state.value = calculateTimeElapsed()
            delay(1000L)
        }
    }

    private fun calculateTimeElapsed(): TimeElapsedState {
        val now = LocalDateTime.now(ZoneId.systemDefault())
        val startOfMonth = now.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withNano(0)
        val duration = Duration.between(startOfMonth, now)

        val days = duration.toDays()
        val hours = duration.toHours() % 24
        val minutes = duration.toMinutes() % 60
        val seconds = duration.seconds % 60

        return TimeElapsedState(days, hours, minutes, seconds)
    }

    fun stop() {
        job.cancel()
    }
}
