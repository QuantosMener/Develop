package com.quantos.composestarter

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    state: MainUiState,
    onIncrement: () -> Unit,
    onOpenDetails: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Привіт! Це стартовий проект (Kotlin + Compose + Hilt + DataStore).",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Text("Лічильник: ${'$'}{state.count}", style = MaterialTheme.typography.headlineMedium)
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(onClick = onIncrement) { Text("Додати +1") }
                OutlinedButton(onClick = onOpenDetails) { Text("Деталі") }
            }
        }
    }
}

@Composable
fun DetailsScreen(onBack: () -> Unit) {
    Surface(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Екран деталей", style = MaterialTheme.typography.headlineSmall)
            Text("Це другий екран для прикладу навігації.")
            OutlinedButton(onClick = onBack) { Text("Назад") }
        }
    }
}
