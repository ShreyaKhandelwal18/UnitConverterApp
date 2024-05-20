package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter(){

    var inputValue by remember {(mutableStateOf("")) }
    var outputValue by remember {(mutableStateOf("")) }
    var inputUnit by remember {(mutableStateOf("Meters")) }
    var outputUnit by remember {(mutableStateOf("Meters")) }
    var iExpanded by remember {(mutableStateOf(false)) }
    var oExpanded by remember {(mutableStateOf(false)) }
    val conversionFactor = remember {(mutableStateOf(1.00)) }
    val oConversionFactor = remember {(mutableStateOf(1.00)) }

    fun convertUnits(){
        //?: ->elvis operator
        //it sets the default value to 0.0 if we don't enter the double type value
       val inputValueDouble=inputValue.toDoubleOrNull() ?:0.0
        val result=(inputValueDouble * conversionFactor.value * 100.0 /oConversionFactor.value).roundToInt() /100.0
        outputValue=result.toString()
    }


    Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement=Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,

) {
    //Here all the UI elements will be stacked below each other
Text("Unit Converter", modifier = Modifier.padding(20.dp), style = MaterialTheme.typography.headlineLarge)
    //when we user spacer it gives multiple element the same space
    //if we use padding it gives space to single element in which we use
   OutlinedTextField(value = inputValue, onValueChange ={
       inputValue=it
   },label={Text("Enter Value")} )


    Spacer(modifier = Modifier.height(16.dp ))
    Row {
        //INPUT BOX
       Box{
        //INPUT BUTTON
           Button(onClick = { iExpanded=true }) {
               Text(inputUnit)
               Icon(Icons.Default.ArrowDropDown,
                   contentDescription ="Arrow Down" )
           }
           DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded=false }) {
               DropdownMenuItem(
                   text = { Text("Centimeters") },
                   onClick = {
                       iExpanded=false
                       inputUnit="Centimeters"
                       conversionFactor.value=0.01
                       convertUnits()

                   }
               )
               DropdownMenuItem(
                   text = { Text("Meters") },
                   onClick = {
                       iExpanded=false
                       inputUnit="Meters"
                       conversionFactor.value=1.00
                       convertUnits() }
               )
               DropdownMenuItem(
                   text = { Text("Feet") },
                   onClick = {
                       iExpanded=false
                       inputUnit="Feet"
                       conversionFactor.value=0.3048
                       convertUnits()
                   }
               )
               DropdownMenuItem(
                   text = { Text("Milimeters") },
                   onClick = {
                       iExpanded=false
                       inputUnit="Milimeters"
                       conversionFactor.value=0.001
                       convertUnits()
                   }
               )
               DropdownMenuItem(
                   text = { Text("Inch") },
                   onClick = {
                       iExpanded=false
                       inputUnit="Inch"
                       conversionFactor.value=0.0254
                       convertUnits()

                   }
               )
               DropdownMenuItem(
                   text = { Text("Kilometers") },
                   onClick = {
                       iExpanded=false
                       inputUnit="Kilometers"
                       conversionFactor.value=1000.0
                       convertUnits()

                   }
               )
               DropdownMenuItem(
                   text = { Text("Mile") },
                   onClick = {
                       iExpanded=false
                       inputUnit="Mile"
                       conversionFactor.value=1609.34
                       convertUnits()

                   }
               )
               DropdownMenuItem(
                   text = { Text("Yard") },
                   onClick = {
                       iExpanded=false
                       inputUnit="Yard"
                       conversionFactor.value=0.9144
                       convertUnits()

                   }
               )
           }
       }
        Spacer(modifier = Modifier.width(20.dp))
        //Output Box
        Box {
            //Output Button100
            Button(onClick = { oExpanded=true }) {
                Text(outputUnit)
                Icon(Icons.Default.ArrowDropDown,
                    contentDescription ="Arrow Down" )
            }
            DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded=false }) {
                DropdownMenuItem(
                    text = { Text("Centimeters") },
                    onClick = {
                        oExpanded=false
                        outputUnit="Centimeters"
                       oConversionFactor.value=0.01
                        convertUnits()

                    }
                )
                DropdownMenuItem(
                    text = { Text("Meters") },
                    onClick = {
                        oExpanded=false
                        outputUnit="Meters"
                        oConversionFactor.value=1.00
                        convertUnits()

                    }
                )
                DropdownMenuItem(
                    text = { Text("Feet") },
                    onClick = {
                        oExpanded=false
                        outputUnit="Feet"
                        oConversionFactor.value=0.3048
                        convertUnits()

                    }
                )
                DropdownMenuItem(
                    text = { Text("Milimeters") },
                    onClick = {
                        oExpanded=false
                        outputUnit="Milimeters"
                        oConversionFactor.value=0.001
                        convertUnits()

                    }
                )
                DropdownMenuItem(
                    text = { Text("Inch") },
                    onClick = {
                        oExpanded=false
                        outputUnit="Inch"
                        oConversionFactor.value=0.0254
                        convertUnits()

                    }
                )
                DropdownMenuItem(
                    text = { Text("Kilometers") },
                    onClick = {
                        oExpanded=false
                        outputUnit="Kilometers"
                        oConversionFactor.value=1000.0
                        convertUnits()

                    }
                )
                DropdownMenuItem(
                    text = { Text("Mile") },
                    onClick = {
                        oExpanded=false
                        outputUnit="Mile"
                        oConversionFactor.value=1609.34
                        convertUnits()

                    }
                )
                DropdownMenuItem(
                    text = { Text("Yard") },
                    onClick = {
                        oExpanded=false
                        outputUnit="Yard"
                        oConversionFactor.value=0.9144
                        convertUnits()

                    }
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
    Text("Result: $outputValue $outputUnit",
        style = MaterialTheme.typography.headlineMedium
    )
}
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
   UnitConverter()
}