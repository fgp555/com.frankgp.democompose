package com.frankgp.democompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.frankgp.democompose.components.TourStepHeader

@Composable
fun ComposeStep3_CardScreen(
    onNext: () -> Unit,
    onPrevious: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TourStepHeader(
            stepNumber = 3,
            componentName = "Card Composable",
            description = "Discover Card variants (Elevated, Filled, and Outlined) styled as social media posts with shadows, padding, and rounded corner radius.",
            onNext = onNext,
            onPrevious = onPrevious,
            canGoBack = true
        )

        Spacer(Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. Elevated Card (Social Post style)
            Text(
                text = "Elevated Card (with high shadow elevation)",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Sarah Connor • 2h ago", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.secondary)
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Elevated cards cast shadows that help communicate hierarchy and prominence on screen. Perfect for highlight feed posts!",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            // 2. Filled Card (Standard Card)
            Text(
                text = "Filled Card (surface tone background)",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Devon Lane • 4h ago", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.secondary)
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Filled cards use surface variant background tones to stand out gently without heavy drop shadows.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            // 3. Outlined Card
            Text(
                text = "Outlined Card (with border stroke)",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )
            OutlinedCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Emily Watson • 6h ago", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.secondary)
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Outlined cards feature a clean border stroke, excellent for secondary grouping and list items.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
