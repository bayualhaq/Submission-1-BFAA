package com.bayu.submission1

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bayu.submission1.databinding.ItemUserBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UserAdapter(private val dataUser: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ListViewHolder>() {
    inner class ListViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(user.avatar)
                    .apply(RequestOptions())
                    .into(ivAvatar)
                tvName.text = user.name
                tvUsername.text = user.username
                tvLocation.text = user.location
            }
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, UserDetail::class.java)
                intent.putExtra(UserDetail.EXTRA_DATA, user)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.bind(dataUser[position])

    override fun getItemCount(): Int = dataUser.size

}