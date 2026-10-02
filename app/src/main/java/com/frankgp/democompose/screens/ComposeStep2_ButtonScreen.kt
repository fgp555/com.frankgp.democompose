package com.frankgp.democompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.frankgp.democompose.components.TourStepHeader

@Composable
fun ComposeStep2_ButtonScreen(
    onNext: () -> Unit,
    onPrevious: () -> Unit
) {
    var isFollowing by remember { mutableStateOf(false) }
    var clickCount by remember { mutableStateOf(0) }
    var isLiked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TourStepHeader(
            stepNumber = 2,
            componentName = "Button Composable",
            description = "Explore Button variants (Elevated, Filled, Outlined, Text, Icon, and FAB) with interactive states and smooth feedback.",
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
            // Interactive Social Actions Card
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Interactive Button Showcase",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    // Primary Button (Follow / Unfollow)
                    Button(
                        onClick = { isFollowing = !isFollowing },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(if (isFollowing) "Following ✓" else "Follow Profile")
                    }

                    // Secondary / Outlined Button
                    OutlinedButton(
                        onClick = { clickCount++ },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Interact Count: $clickCount (Tap me)")
                    }

                    // Tonal Button
                    FilledTonalButton(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.Share, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(8.dp))
                        Text("Share Profile")
                    }

                    // Text Button
                    TextButton(
                        onClick = { clickCount = 0 },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text("Reset Interactions")
                    }
                }
            }

            // Icon Buttons & FAB
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Icon Buttons & Floating Action Button",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Icon Button
                        IconButton(onClick = { isLiked = !isLiked }) {
                            Icon(
                                imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Filled.Favorite,
                                contentDescription = "Like",
                                tint = if (isLiked) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        // Icon Toggle Button
                        IconToggleButton(checked = isLiked, onCheckedChange = { isLiked = it }) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Toggle Like",
                                tint = if (isLiked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        // Floating Action Button
                        SmallFloatingActionButton(
                            onClick = { clickCount++ },
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Add Post")
                        }
                    }
                }
            }
        }
    }
}
