package com.example.roomdatabase.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.roomdatabase.R
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                BottomSheetDemo()
            }
        }
    }

}

data class BottomSheetItem(val title: String)


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun BottomSheetDemo() {
    val bottomSheetItems = listOf(
        BottomSheetItem(title = "Weekdays"),
        BottomSheetItem(title = "24/7"),
        BottomSheetItem(title = "Custom"))

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed))

    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(30.dp),
        sheetElevation = 20.dp,
        sheetContent = {
            Column(
                content = {
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Working Hours",
                        modifier = Modifier
                            .fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    LazyVerticalGrid(
                        cells = GridCells.Fixed(1)
                    ) {
                        items(bottomSheetItems.size, itemContent = {

                            OutlinedButton(
                                modifier = Modifier
                                    .padding(top = 4.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(10.dp),
//                                border= BorderStroke(1.dp, Color.Blue),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                                onClick = {

                                }
                            ) {
                                Text(text = bottomSheetItems[it].title, color = Color.Black)
                            }

                        })
                    }
                    Spacer(modifier = Modifier.padding(16.dp))
                    Button(
                        modifier = Modifier
                            .background(Color.Blue)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(23.dp),
                        onClick = {

                        }
                    ) {
                        Text(text = "Done", color = Color.White)
                    }

                }, modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.White)
                    .padding(20.dp)
            )
        },
        sheetPeekHeight = 0.dp,

    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Button(
                modifier = Modifier
                    .padding(20.dp),
                onClick = {
                    coroutineScope.launch {
                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        } else {
                            bottomSheetScaffoldState.bottomSheetState.collapse()
                        }
                    }
                }
            ) {
                Text(
                    text = "Click to show Bottom Sheet"
                )
            }
        }
    }
}