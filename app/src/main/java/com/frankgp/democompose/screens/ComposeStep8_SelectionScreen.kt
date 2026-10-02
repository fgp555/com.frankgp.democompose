package com.frankgp.democompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.frankgp.democompose.components.TourStepHeader

@Composable
fun ComposeStep8_SelectionScreen(
    onNext: () -> Unit,
    onPrevious: () -> Unit
) {
    var option1 by remember { mutableStateOf(true) }
    var option2 by remember { mutableStateOf(false) }
    var option3 by remember { mutableStateOf(false) }

    val filterOptions = listOf("All Posts", "Following Only", "Trending", "Bookmarks")
    var selectedFilter by remember { mutableStateOf(filterOptions[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TourStepHeader(
            stepNumber = 8,
            componentName = "Checkbox & RadioButton",
            description = "Use Checkboxes for multiple selections (e.g. batch post management) and RadioButtons for single-choice filters (e.g. feed categories).",
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
            // Checkbox Showcase Card
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Checkboxes (Multiple Selections)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(4.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { option1 = !option1 },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(checked = option1, onCheckedChange = { option1 = it })
                        Spacer(Modifier.width(8.dp))
                        Text("Notify me on new comments")
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { option2 = !option2 },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(checked = option2, onCheckedChange = { option2 = it })
                        Spacer(Modifier.width(8.dp))
                        Text("Enable direct messages from everyone")
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { option3 = !option3 },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(checked = option3, onCheckedChange = { option3 = it })
                        Spacer(Modifier.width(8.dp))
                        Text("Auto-save drafts to cloud")
                    }
                }
            }

            // RadioButton Showcase Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "RadioButtons (Single-choice Feed Filter)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(4.dp))

                    filterOptions.forEach { filter ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (selectedFilter == filter),
                                    onClick = { selectedFilter = filter }
                                )
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (selectedFilter == filter),
                                onClick = { selectedFilter = filter }
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(filter, style = MaterialTheme.typography.bodyLarge)
                        }
                    }

                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Active Filter: $selectedFilter",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}
