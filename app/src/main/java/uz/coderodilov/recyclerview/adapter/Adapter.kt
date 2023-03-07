package uz.coderodilov.recyclerview.adapter
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.coderodilov.recyclerview.model.Model
import uz.coderodilov.recyclerview.R

class Adapter(private var list: List<Model>, private var index:Int) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {


    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
      val texView: TextView = view.findViewById(R.id.textView)
      val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setFilteredList(list: List<Model>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when(index){
            1-> {
                ViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_item, parent, false))
            }
            2-> {
                ViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_item_list, parent, false))
            }
            else -> {ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_item, parent, false))}
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.texView.text = list[position].name
        holder.imageView.setImageResource(list[position].image)
    }

}