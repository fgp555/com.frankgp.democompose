package com.frankgp.democompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.frankgp.democompose.screens.*
import com.frankgp.democompose.ui.theme.FGPDemoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var currentStep by remember { mutableIntStateOf(1) }
            var isDarkTheme by remember { mutableStateOf(true) }

            FGPDemoComposeTheme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize()
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        ) {
                            when (currentStep) {
                                1 -> ComposeStep1_TextScreen(
                                    onNext = { currentStep = 2 },
                                    onPrevious = { }
                                )
                                2 -> ComposeStep2_ButtonScreen(
                                    onNext = { currentStep = 3 },
                                    onPrevious = { currentStep = 1 }
                                )
                                3 -> ComposeStep3_CardScreen(
                                    onNext = { currentStep = 4 },
                                    onPrevious = { currentStep = 2 }
                                )
                                4 -> ComposeStep4_ImageScreen(
                                    onNext = { currentStep = 5 },
                                    onPrevious = { currentStep = 3 }
                                )
                                5 -> ComposeStep5_LazyColumnScreen(
                                    onNext = { currentStep = 6 },
                                    onPrevious = { currentStep = 4 }
                                )
                                6 -> ComposeStep6_LazyRowScreen(
                                    onNext = { currentStep = 7 },
                                    onPrevious = { currentStep = 5 }
                                )
                                7 -> ComposeStep7_TextFieldScreen(
                                    onNext = { currentStep = 8 },
                                    onPrevious = { currentStep = 6 }
                                )
                                8 -> ComposeStep8_SelectionScreen(
                                    onNext = { currentStep = 9 },
                                    onPrevious = { currentStep = 7 }
                                )
                                9 -> ComposeStep9_InteractionScreen(
                                    isDarkTheme = isDarkTheme,
                                    onToggleTheme = { isDarkTheme = !isDarkTheme },
                                    onNext = { currentStep = 10 },
                                    onPrevious = { currentStep = 8 }
                                )
                                10 -> ComposeStep10_NavigationScreen(
                                    onNext = { currentStep = 11 },
                                    onPrevious = { currentStep = 9 }
                                )
                                11 -> ComposeStep11_StateScreen(
                                    onNext = { currentStep = 12 },
                                    onPrevious = { currentStep = 10 }
                                )
                                12 -> ComposeStep12_ResponsiveScreen(
                                    onNext = { currentStep = 1 },
                                    onPrevious = { currentStep = 11 }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
