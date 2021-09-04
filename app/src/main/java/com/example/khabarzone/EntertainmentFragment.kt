package com.example.khabarzone

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class EntertainmentFragment : Fragment() {

    val api = "caab743de05c4625b0fe67806625762c"
    lateinit var rc_enter: RecyclerView
    lateinit var MyAdapter_enter: MyAdapter
    val country = "in"
    lateinit var enterArrayList: ArrayList<KhabarModel>
//    lateinit var ApiUtilities: ApiUtilities
    val category = "entertainment"
//    lateinit var pd: ProgressDialog




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.entertainmentfragment, null)
        rc_enter = v.findViewById(R.id.rc_entertainment)
        enterArrayList = ArrayList()
        rc_enter.layoutManager = LinearLayoutManager(context)
        MyAdapter_enter = MyAdapter(requireContext(), enterArrayList)
        rc_enter.adapter = MyAdapter_enter



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
        ApiUtilities().getApiInterface()!!.getCategoryNews(country,category,100,api).enqueue(
            object : retrofit2.Callback<NewsData> {
                override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                    if(response.isSuccessful){
//                        pd.dismiss()
                        enterArrayList.addAll(response.body()!!.articles)
                        MyAdapter_enter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<NewsData>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )
    }
}