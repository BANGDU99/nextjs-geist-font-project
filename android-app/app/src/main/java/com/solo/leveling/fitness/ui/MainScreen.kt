package com.solo.leveling.fitness.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.solo.leveling.fitness.ui.theme.SoloLevelingFitnessTheme

data class Workout(
    val id: Int,
    val name: String,
    val description: String,
    val completed: Boolean = false
)

@Composable
fun MainScreen() {
    var workouts by remember {
        mutableStateOf(
            listOf(
                Workout(1, "Daily Quest: Push-ups", "Complete 50 push-ups"),
                Workout(2, "Daily Quest: Squats", "Complete 50 squats"),
                Workout(3, "Daily Quest: Running", "Run 3 kilometers")
            )
        )
    }

    SoloLevelingFitnessTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Solo Leveling Fitness Tracker",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(workouts) { workout ->
                        WorkoutItem(workout) { completed ->
                            workouts = workouts.map {
                                if (it.id == workout.id) it.copy(completed = completed) else it
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WorkoutItem(workout: Workout, onCheckedChange: (Boolean) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2C2C2C))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Checkbox(
                checked = workout.completed,
                onCheckedChange = onCheckedChange,
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFFBB86FC))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = workout.name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
                Text(
                    text = workout.description,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Gray
                )
            }
        }
    }
}
