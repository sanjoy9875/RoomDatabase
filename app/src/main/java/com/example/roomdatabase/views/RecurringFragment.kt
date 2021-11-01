package com.example.roomdatabase.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.R
import com.example.roomdatabase.viewmodel.RecurringViewModel

class RecurringFragment : Fragment() {

    object value{
        var weeklyValue = "(on Thursday's)"
        var monthlyValue = "(on the last Thursday)"
        var annuallyValue = "(on April 29)"
        const val weekdaysValue = "(Mon - Fri)"
    }

    object items{
        const val do_not_repeat = "Don't repeat"
        const val daily = "Daily"
        const val weekly = "Weekly "
        const val monthly = "Monthly "
        const val annually = "Annually "
        const val weekdays = "Weekdays only "
    }

    private val recurringViewModel by lazy {
        ViewModelProvider(this).get(RecurringViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {

            MainActivity3.value.weeklyValue = recurringViewModel.weekly()
            MainActivity3.value.monthlyValue = recurringViewModel.monthly()
            MainActivity3.value.annuallyValue = recurringViewModel.annually()

            setContent {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Spacer(modifier = Modifier.height(30.dp))
                    header(text = "Recurring")
                    Spacer(modifier = Modifier.height(30.dp))

                    Divider(color = Color.LightGray)

                    Spacer(modifier = Modifier.height(35.dp))

                    radioGroup(text = MainActivity3.items.do_not_repeat,"")
                    radioGroup(text = MainActivity3.items.daily,"")
                    radioGroup(text = MainActivity3.items.weekly, MainActivity3.value.weeklyValue)
                    radioGroup(text = MainActivity3.items.monthly, MainActivity3.value.monthlyValue)
                    radioGroup(text = MainActivity3.items.annually, MainActivity3.value.annuallyValue)
                    radioGroup(text = MainActivity3.items.weekdays, MainActivity3.value.weekdaysValue)
                }
            }
        }
    }

@Composable
fun header(text: String,modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
    ) {

        Text(text = text,fontSize = 24.sp)
        Icon(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = null,
            Modifier.scale(1.5f),
            tint = Color.Gray,
        )
    }
}

@Composable
fun radioGroup(text : String,value : String,modifier: Modifier = Modifier){

    val selectedItem = remember{
        mutableStateOf("")
    }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
    ){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,){
            Text(text = text,fontSize = 24.sp)
            Text(text = value,fontSize = 18.sp)
        }

        RadioButton(
            selected = selectedItem.value == text,
            onClick = {
                selectedItem.value = text
                Log.d("TAG","$text")
            },
            colors = RadioButtonDefaults.colors(
                selectedColor = colorResource(R.color.radio_button_checked),
                unselectedColor = Color.Gray
            ),
            modifier = modifier.scale(1.6f)

        )

    }
    Spacer(modifier = modifier.height(40.dp))
}
}