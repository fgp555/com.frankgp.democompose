package com.frankgp.democompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.frankgp.democompose.components.SocialPostCard
import com.frankgp.democompose.components.TourStepHeader
import com.frankgp.democompose.models.DummyData

@Composable
fun ComposeStep12_ResponsiveScreen(
    onNext: () -> Unit,
    onPrevious: () -> Unit
) {
    var isTabletMode by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        TourStepHeader(
            stepNumber = 12,
            componentName = "Responsive Design (Phone & Tablet)",
            description = "Learn how Compose adapts layouts across form factors. Toggle between Phone view (single-column with Bottom Nav) and Tablet view (NavigationRail + side-by-side multi-pane).",
            onNext = onNext,
            onPrevious = onPrevious,
            canGoBack = true
        )

        Spacer(Modifier.height(8.dp))

        // Device mode toggle bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (isTabletMode) "Mode: Tablet (Landscape / Multi-pane)" else "Mode: Phone (Portrait)",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Switch(
                checked = isTabletMode,
                onCheckedChange = { isTabletMode = it }
            )
        }

        Spacer(Modifier.height(8.dp))

        if (isTabletMode) {
            // Tablet Layout: NavigationRail on left, two-pane content on right
            Row(modifier = Modifier.fillMaxSize()) {
                NavigationRail(
                    modifier = Modifier.width(80.dp)
                ) {
                    Spacer(Modifier.height(16.dp))
                    NavigationRailItem(
                        selected = true,
                        onClick = { },
                        icon = { Icon(Icons.Default.Home, contentDescription = null) },
                        label = { Text("Home") }
                    )
                    NavigationRailItem(
                        selected = false,
                        onClick = { },
                        icon = { Icon(Icons.Default.Search, contentDescription = null) },
                        label = { Text("Search") }
                    )
                    NavigationRailItem(
                        selected = false,
                        onClick = { },
                        icon = { Icon(Icons.Default.Person, contentDescription = null) },
                        label = { Text("Profile") }
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text("Tablet Multi-Pane Adaptive View", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                                Text("Side-by-side layout efficiently utilizes large screen real estate.", style = MaterialTheme.typography.bodyMedium)
                            }
                        }

                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            contentPadding = PaddingValues(bottom = 24.dp)
                        ) {
                            items(DummyData.posts, key = { it.id }) { post ->
                                SocialPostCard(post = post, onLikeClick = { })
                            }
                        }
                    }
                }
            }
        } else {
            // Phone Layout: Single column feed
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 24.dp)
            ) {
                items(DummyData.posts, key = { it.id }) { post ->
                    SocialPostCard(post = post, onLikeClick = { })
                }
            }
        }
    }
}
