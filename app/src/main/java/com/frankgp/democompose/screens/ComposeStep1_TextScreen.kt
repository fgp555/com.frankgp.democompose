package com.frankgp.democompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frankgp.democompose.components.TourStepHeader

@Composable
fun ComposeStep1_TextScreen(
    onNext: () -> Unit,
    onPrevious: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TourStepHeader(
            stepNumber = 1,
            componentName = "Text Composable",
            description = "Learn how Text renders typography in Compose with various font sizes, weights, styles, and colors, demonstrated via a social media user profile header.",
            onNext = onNext,
            onPrevious = onPrevious,
            canGoBack = false
        )

        Spacer(Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Profile Card Demo using Text styles
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Display / Large Title
                    Text(
                        text = "Alex Johnson",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    // Subtitle
                    Text(
                        text = "@alex_compose • Developer & Creator",
                        style = MaterialTheme.typography.titleMedium,
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colorScheme.secondary
                    )

                    Spacer(Modifier.height(4.dp))

                    // Body Text
                    Text(
                        text = "Building the next generation of Android experiences with Jetpack Compose. Passionate about clean architecture, smooth animations, and Material 3 design systems.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(Modifier.height(4.dp))

                    // Caption / Metadata
                    Text(
                        text = "Joined March 2023 • 1,420 Followers • 328 Posts",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Typography Showcase Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Typography Scale Reference",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text("Display Large (32sp)", fontSize = 28.sp, fontWeight = FontWeight.Black)
                    Text("Headline Medium (24sp)", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text("Title Medium (16sp)", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                    Text("Body Large (14sp)", fontSize = 14.sp, fontWeight = FontWeight.Normal)
                    Text("Caption / Label (12sp)", fontSize = 12.sp, color = Color.Gray)
                }
            }
        }
    }
}
