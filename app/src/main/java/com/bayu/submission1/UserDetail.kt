package com.bayu.submission1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bayu.submission1.databinding.ActivityUserDetailBinding

class UserDetail : AppCompatActivity() {
    private lateinit var bindingD: ActivityUserDetailBinding

    companion object {
        var EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingD = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(bindingD.root)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        userData()
    }

    private fun userData() {
        val position = intent.getParcelableExtra<User>(EXTRA_DATA) as User
        bindingD.ivAvatar.setImageResource(position.avatar)
        bindingD.tvName.text = position.name
        bindingD.tvUsername.text = position.username
        bindingD.tvLocation.text = position.location
        bindingD.tvCompany.text = position.company
        bindingD.tvRepository.text = position.repository
        bindingD.tvFollowers.text = position.followers
        bindingD.tvFollowing.text = position.following
        title = position.name
    }
}