package com.frankgp.democompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.frankgp.democompose.components.TourStepHeader

@Composable
fun ComposeStep10_NavigationScreen(
    onNext: () -> Unit,
    onPrevious: () -> Unit
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Home", "Search", "Create", "Messages", "Profile")
    val icons = listOf(Icons.Default.Home, Icons.Default.Search, Icons.Default.AddCircle, Icons.Default.Email, Icons.Default.Person)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TourStepHeader(
            stepNumber = 10,
            componentName = "Navigation Implementation",
            description = "Explore navigation structures including Bottom Navigation bars, NavigationRail for tablets, and top/drawer menu navigation.",
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
            // Simulated Bottom Navigation Preview Card
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(text = "Bottom Navigation Pattern", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Text(text = "Currently selected tab: ${tabs[selectedTab]}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)

                    // Simulated screen content area
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        shape = MaterialTheme.shapes.medium,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(icons[selectedTab], contentDescription = null, modifier = Modifier.size(36.dp), tint = MaterialTheme.colorScheme.primary)
                                Spacer(Modifier.height(8.dp))
                                Text("Displaying content for ${tabs[selectedTab]} Screen", style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }

                    // Simulated Bottom Bar
                    NavigationBar {
                        tabs.forEachIndexed { index, title ->
                            NavigationBarItem(
                                selected = (selectedTab == index),
                                onClick = { selectedTab = index },
                                icon = { Icon(icons[index], contentDescription = title) },
                                label = { Text(title) }
                            )
                        }
                    }
                }
            }

            // Navigation Rail preview info
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "NavigationRail (For Tablet & Desktop)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Text(
                        text = "On wider screens (tablets/foldables), apps transition from bottom navigation bars to side-rail navigation for ergonomic reachability.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
