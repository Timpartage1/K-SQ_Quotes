package com.example.k_sqquotes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.k_sqquotes.model.Quote;
import com.example.k_sqquotes.network.APIClient;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private ArrayList<QuoteModel> modelArrayList=new ArrayList<>();
    QuoteModel quoteModel;

    public HomeFragment(){

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list_();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        init(view);

        return view;
    }

    private void init(View view){
        RecyclerView recyclerView=view.findViewById(R.id.home_rccl);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerQuoteAdapter recyclerQuoteAdapter=new RecyclerQuoteAdapter(getContext(),modelArrayList);
        recyclerView.setAdapter(recyclerQuoteAdapter);

    }
    private void list_(){

        //dealing with networking

        Call<List<Quote>> call= APIClient.apIinterface().getQuote();
        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if(response.isSuccessful()){

                    int size=response.body().size();
                    for(int i=0;i<size;i++){
                        quoteModel=new QuoteModel(response.body().get(i).getQuoteTitle(),response.body().get(i).getQuoteDescription(),response.body().get(i).getQuoteContent(),"333",response.body().get(i).getQuoteUrl());
                        modelArrayList.add(quoteModel);
                    }







                }else{
                    Toast.makeText(getContext(), "not successfull", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }
}