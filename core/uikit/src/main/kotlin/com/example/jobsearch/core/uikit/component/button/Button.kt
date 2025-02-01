package com.example.jobsearch.core.uikit.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.jobsearch.core.uikit.theme.basicGreyFourth
import com.example.jobsearch.core.uikit.theme.darkBlue
import com.example.jobsearch.core.uikit.utils.DefaultPreview

@Composable
fun JobSearchButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    shape: Shape = MaterialTheme.shapes.small,
    paddingValues: PaddingValues,
    contentColor: Color,
    containerColor: Color,
    content: @Composable (RowScope.() -> Unit)
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            contentColor = contentColor,
            containerColor = containerColor,
        ),
        content = content,
        contentPadding = paddingValues,
    )
}

@PreviewLightDark
@Composable
private fun PreviewJobSearchButton() {
    DefaultPreview {
        JobSearchButton(
            shape = MaterialTheme.shapes.small,
            paddingValues = PaddingValues(horizontal = 66.dp, vertical = 11.dp),
            contentColor = basicGreyFourth,
            containerColor = darkBlue,
        ) {
            Text("Label")
        }
    }
}