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

class SportsFragment : Fragment() {

    val api = "caab743de05c4625b0fe67806625762c"
    lateinit var rc_sports: RecyclerView
    lateinit var MyAdapter_sports: MyAdapter
    val country = "in"
    lateinit var sportsArrayList: ArrayList<KhabarModel>
//    lateinit var ApiUtilities: ApiUtilities
    val category = "sports"
//    lateinit var pd: ProgressDialog




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.sportsfragment, null)

        rc_sports = v.findViewById(R.id.rc_sports)
        sportsArrayList = ArrayList()
        rc_sports.layoutManager = LinearLayoutManager(context)
        MyAdapter_sports = MyAdapter(requireContext(), sportsArrayList)
        rc_sports.adapter = MyAdapter_sports



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
                        sportsArrayList.addAll(response.body()!!.articles)
                        MyAdapter_sports.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<NewsData>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )
    }
}