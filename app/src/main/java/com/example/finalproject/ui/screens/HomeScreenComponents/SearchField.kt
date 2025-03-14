package com.example.finalproject.ui.screens.HomeScreenComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalproject.R
import com.example.finalproject.viewmodel.SearchFieldViewmodel

@Composable
fun SearchField(searchFieldViewmodel: SearchFieldViewmodel = viewModel()) {
    TextField(
        value = searchFieldViewmodel.value,
        onValueChange = {
            searchFieldViewmodel.value = it
            searchFieldViewmodel.getSearchResults()
        },
        label = { Text(stringResource(R.string.search)) },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.tertiary
        )
    )
}