package com.bayu.submission1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bayu.submission1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            rvItem.layoutManager = LinearLayoutManager(this@MainActivity)
            rvItem.adapter = UserAdapter(userDataArray())
        }

        title = "Github User"

    }

    private fun userDataArray(): ArrayList<User> {
        val avatar = resources.obtainTypedArray(R.array.avatar)
        val name = resources.getStringArray(R.array.name)
        val username = resources.getStringArray(R.array.username)
        val location = resources.getStringArray(R.array.location)
        val company = resources.getStringArray(R.array.company)
        val repository = resources.getStringArray(R.array.repository)
        val followers = resources.getStringArray(R.array.followers)
        val following = resources.getStringArray(R.array.following)

        val addUser: ArrayList<User> = arrayListOf()
        for (position in name.indices) {
            val user = User(
                avatar.getResourceId(position, -1),
                name[position],
                username[position],
                location[position],
                company[position],
                repository[position],
                followers[position],
                following[position],
            )
            addUser.add(user)
        }
        return addUser
    }
}