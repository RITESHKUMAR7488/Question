package com.example.questions

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.questions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        with(binding) {
            btn1.setOnClickListener {
                val option1 = arrayOf("car", "scooter", "plane", "cycle")
                val correctanswer1= setOf(1,3)
                val selecteditem1=BooleanArray(option1.size)
                val builder1 = AlertDialog.Builder(this@MainActivity)
                builder1.setTitle("which one of these have two wheels")
                builder1.setMultiChoiceItems(
                    option1, selecteditem1)
                { _, which, isChecked ->
                    // Update the boolean array based on selection
                    selecteditem1[which] = isChecked
                }
                builder1.setPositiveButton("submit",DialogInterface.OnClickListener{dialogInterface,i->
                    val selectedindeces=selecteditem1
                        .mapIndexed{index,isSelected->if(isSelected)index else null  }
                        .filterNotNull()
                        .toSet()
                    if(selectedindeces==correctanswer1){
                        Toast.makeText(this@MainActivity,"Correct!",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@MainActivity,"Incorrect stupid",Toast.LENGTH_SHORT).show()
                    }


                })
                    .setNegativeButton("cancel",null)
                builder1.create().show()


            }
            btn2.setOnClickListener{
                val option2= arrayOf("banana","potato","oranges","cabbage")
                val builder1 = AlertDialog.Builder(this@MainActivity)
                val correctanswer2= setOf(1,3)
                val selecteditem2=BooleanArray(option2.size)
                builder1.setTitle("which of these are vegetables")
                builder1.setMultiChoiceItems(
                    option2,selecteditem2)
                { _, which, isChecked ->
                    // Update the boolean array based on selection
                    selecteditem2[which] = isChecked
                }
                builder1.setPositiveButton("submit",DialogInterface.OnClickListener{dialogInterface,i->
                    val selectedindeces=selecteditem2
                        .mapIndexed{index,isSelected->if(isSelected)index else null  }
                        .filterNotNull()
                        .toSet()
                    if(selectedindeces==correctanswer2){
                        Toast.makeText(this@MainActivity,"Correct!",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@MainActivity,"Incorrect stupid",Toast.LENGTH_SHORT).show()
                    }


                })
                    .setNegativeButton("cancel",null)
                builder1.create().show()

            }

        }

    }
}