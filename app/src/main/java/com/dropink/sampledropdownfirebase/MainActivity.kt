package com.dropink.sampledropdownfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dropink.sampledropdownfirebase.databinding.ActivityMainBinding
import com.dropink.sampledropdownfirebase.fragment.DateFragment
import com.dropink.sampledropdownfirebase.fragment.LocationFragment
import com.dropink.sampledropdownfirebase.fragment.TimeFragment
import com.dropink.sampledropdownfirebase.module.ModuleDropdown
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_date.*
import kotlinx.android.synthetic.main.fragment_location.*
import kotlinx.android.synthetic.main.fragment_time.*

class MainActivity : AppCompatActivity()
{
    // Binding
    private lateinit var binding: ActivityMainBinding

    // Firebase Database
    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // Implementation Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize Fragment
        val date = DateFragment()
        val time = TimeFragment()
        val location = LocationFragment()

        // Show Fragment
        showFragmentDate(date)
        showFragmentTime(time)
        showFragmentLocation(location)

        // Save Data
        showAddData()
    }

    private fun showAddData()
    {
        database = FirebaseDatabase.getInstance()
        databaseReference = database.getReference("Dropdown")

        save_data.setOnClickListener {
            val choose_date = date_auto.text.toString()
            val choose_time = time_auto.text.toString()
            val choose_location = location_auto.text.toString()

            if (choose_date == "Choose Date")
            {
                date_auto.error = "Choose Date"
                date_auto.requestFocus()
            }

            else if (choose_time == "Choose Time")
            {
                time_auto.error = "Choose Time"
                time_auto.requestFocus()
            }

            else if (choose_location == "Choose Location")
            {
                location_auto.error = "Choose Location"
                location_auto.requestFocus()
            }

            else
            {
                saveData(choose_date, choose_time, choose_location)
            }
        }
    }

    private fun saveData(choose_date: String, choose_time: String, choose_location: String)
    {
        val data = ModuleDropdown()

        data.date = choose_date
        data.time = choose_time
        data.location = choose_location

        // Input Data
        databaseReference.child("Choose").addValueEventListener(object: ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot)
            {
                val dataFirebase = snapshot.getValue(ModuleDropdown::class.java)

                if (dataFirebase == null)
                {
                    // Write Data
                    databaseReference.child("Booked").setValue(data)
                    Toast.makeText(this@MainActivity, "Value Saved", Toast.LENGTH_SHORT).show()
                }

                else {
                    // Write Data
                    databaseReference.child("Another").setValue(data)
                    Toast.makeText(this@MainActivity, "Another Value Saved", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError)
            {
                Toast.makeText(this@MainActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun showFragmentLocation(fragment: Fragment)
    {
        //
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        //
        fragmentTransaction.replace(R.id.frame_location, fragment)
        fragmentTransaction.commit()
    }

    private fun showFragmentTime(fragment: Fragment)
    {
        //
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        //
        fragmentTransaction.replace(R.id.frame_time, fragment)
        fragmentTransaction.commit()
    }

    private fun showFragmentDate(fragment: Fragment)
    {
        //
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        //
        fragmentTransaction.replace(R.id.frame_date, fragment)
        fragmentTransaction.commit()
    }
}