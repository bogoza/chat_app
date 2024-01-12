package com.example.chatapp.adapter_recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chatapp.R
import com.example.chatapp.data.User
import com.example.chatapp.databinding.UserRvBinding


class UserRecyclerViewAdapter:ListAdapter<User,UserRecyclerViewAdapter.UserViewHolder>(UserDiff()){

    class UserDiff():DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }

    inner class UserViewHolder(private val binding:UserRvBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind() = with(binding){
            val position = currentList[adapterPosition]

            nameTv.text = position.owner
            messageTv.text = position.lastMessage
            timeTv.text = position.lastActive
            unreadTv.text = position.unreadMessages

            Glide
                .with(root.context)
                .load(position.image)
                .centerCrop()
                .placeholder(R.drawable.ic_user)
                .into(circleIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            UserRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind()
    }
}