package com.example.khabarzone

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper.Callback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    val api = "caab743de05c4625b0fe67806625762c"
    lateinit var rc_home: RecyclerView
    lateinit var MyAdapter_home: MyAdapter
    val country = "in"
    lateinit var homeArrayList: ArrayList<KhabarModel>
//    lateinit var ApiUtilities

    lateinit var pd:ProgressDialog


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.homefragment, null)

        rc_home = v.findViewById(R.id.rc_home)
        homeArrayList = ArrayList()
        rc_home.layoutManager = LinearLayoutManager(context)
        MyAdapter_home = MyAdapter(requireContext(), homeArrayList)
        rc_home.adapter = MyAdapter_home


        pd = ProgressDialog(requireContext())

        pd.max = 100;
        pd.setMessage("Please Wait.....")
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        pd.show();

        findNews()



        return v;


    }

    private fun findNews() {
        ApiUtilities().getApiInterface()!!.getNews(country, 100, api)
            .enqueue(object : retrofit2.Callback<NewsData> {

                override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                    if(response.isSuccessful){
                        pd.dismiss()
                        homeArrayList.addAll(response.body()!!.articles)
                        MyAdapter_home.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<NewsData>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
}


