package com.example.khabarzone

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScienceFragment : Fragment() {

    val api = "caab743de05c4625b0fe67806625762c"
    lateinit var rc_science: RecyclerView
    lateinit var MyAdapter_science: MyAdapter
    val country = "in"
    lateinit var scienceArrayList: ArrayList<KhabarModel>
    var apiInteface = ApiUtilities().getApiInterface()
    val category = "science"

//    lateinit var pd: ProgressDialog



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.sciencefragment, null)
        rc_science = v.findViewById(R.id.rc_science)
        scienceArrayList = ArrayList()
        rc_science.layoutManager = LinearLayoutManager(context)
        MyAdapter_science = MyAdapter(requireContext(), scienceArrayList)
        rc_science.adapter = MyAdapter_science



        findNews()

//        pd = ProgressDialog(requireContext())
//
//        pd.max = 100;
//        pd.setMessage("Please Wait.....")
//        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
//        pd.show();



        return v;


    }

    private fun findNews() {
        apiInteface!!.getCategoryNews(country,category,100,api).enqueue(
            object : Callback<NewsData> {
                override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                    if(response.isSuccessful){

//                        pd.dismiss()
                        scienceArrayList.addAll(response.body()!!.articles)
                        MyAdapter_science.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<NewsData>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )
    }


}