package com.frankgp.democompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.frankgp.democompose.components.TourStepHeader

@Composable
fun ComposeStep7_TextFieldScreen(
    onNext: () -> Unit,
    onPrevious: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var postContent by remember { mutableStateOf("") }
    var emailInput by remember { mutableStateOf("") }
    val isEmailError = emailInput.isNotBlank() && !emailInput.contains("@")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TourStepHeader(
            stepNumber = 7,
            componentName = "TextField Composable",
            description = "Explore TextField and OutlinedTextField for user input, search bars, multi-line post creation, error states, and placeholder hints.",
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
            // 1. Search Bar (Single-line OutlinedTextField)
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(text = "Search Bar (Single-line)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Search users, tags, or posts...") },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        trailingIcon = {
                            if (searchQuery.isNotEmpty()) {
                                IconButton(onClick = { searchQuery = "" }) {
                                    Icon(Icons.Default.Clear, contentDescription = "Clear")
                                }
                            }
                        },
                        singleLine = true
                    )
                }
            }

            // 2. Create Post Box (Multi-line TextField)
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(text = "Create New Post (Multi-line input)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = postContent,
                        onValueChange = { postContent = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        placeholder = { Text("What's on your mind today?") },
                        maxLines = 5
                    )
                    Button(
                        onClick = { postContent = "" },
                        enabled = postContent.isNotBlank(),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Publish Post")
                    }
                }
            }

            // 3. Email Input with Validation Error State
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(text = "Validation & Error State", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = emailInput,
                        onValueChange = { emailInput = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Email Address") },
                        placeholder = { Text("user@domain.com") },
                        isError = isEmailError,
                        supportingText = {
                            if (isEmailError) {
                                Text("Invalid email address (must contain @)", color = MaterialTheme.colorScheme.error)
                            } else {
                                Text("We'll never share your email.")
                            }
                        },
                        singleLine = true
                    )
                }
            }
        }
    }
}
