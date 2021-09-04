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

class TechnologyFragment : Fragment() {

    val api = "caab743de05c4625b0fe67806625762c"
    lateinit var rc_tech: RecyclerView
    lateinit var MyAdapter_tech: MyAdapter
    val country = "in"
    lateinit var techArrayList: ArrayList<KhabarModel>
//    lateinit var ApiUtilities: ApiUtilities
    val category = "technology"
//    lateinit var pd: ProgressDialog




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.technologyfragment, null)
        rc_tech = v.findViewById(R.id.rc_technology)
        techArrayList = ArrayList()
        rc_tech.layoutManager = LinearLayoutManager(context)
        MyAdapter_tech = MyAdapter(requireContext(), techArrayList)
        rc_tech.adapter = MyAdapter_tech


//        pd = ProgressDialog(requireContext())
//
//        pd.max = 100;
//        pd.setMessage("Please Wait.....")
//        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
//        pd.show();


        findNews()



        return v;


    }

    private fun findNews() {
        ApiUtilities().getApiInterface()!!.getCategoryNews(country,category,100,api).enqueue(
            object : retrofit2.Callback<NewsData> {
                override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                    if(response.isSuccessful){
//                        pd.dismiss()
                        techArrayList.addAll(response.body()!!.articles)
                        MyAdapter_tech.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<NewsData>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )
    }
}