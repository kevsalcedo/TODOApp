package com.example.todoapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)
    private val viewContainer: CardView = view.findViewById(R.id.viewContainer)

    fun render(taskCategory: TaskCategory, onCategorySelected: (Int) -> Unit) {

        itemView.setOnClickListener { onCategorySelected(layoutPosition) }

        val color = if (taskCategory.isSelected){
            R.color.todo_background_card
        }else{
            R.color.todo_background_disabled
        }

        viewContainer.setCardBackgroundColor(
            ContextCompat.getColor(viewContainer.context, color)
        )

        when(taskCategory){
            TaskCategory.Business -> {
                tvCategoryName.text = "Business"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_business_category)
                )
            }
            TaskCategory.Other -> {
                tvCategoryName.text = "Other"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_other_category)
                )
            }
            TaskCategory.Personal -> {
                tvCategoryName.text = "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_personal_category)
                )
            }
        }


    }

}