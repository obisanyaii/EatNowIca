package com.example.eatnow.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
//    //h1 = TextStyle(
//        fontFamily = FontFamily.Cursive,
//        fontWeight = FontWeight.Bold,
//        fontSize = 55.sp
//    ),
//    h2 = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.SemiBold,
//        fontSize = 40.sp
//    ),
//    h3 = TextStyle(
//        fontFamily = FontFamily.Serif,
//        fontWeight = FontWeight.Normal,
//        fontSize = 32.sp

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)