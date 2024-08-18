package com.plcoding.globalsnackbarscompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ScreenA(
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ScreenAViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            scope.launch {
                SnackbarController.sendEvent(
                    event = SnackbarEvent(
                        message = "Hello world!"
                    )
                )
            }
        }) {
            Text(text = "Show snackbar")
        }
        Button(onClick = {
            viewModel.showSnackbar()
        }) {
            Text(text = "Show snackbar with action")
        }
        Button(onClick = onNavigate) {
            Text(text = "Navigate to B")
        }
    }
}