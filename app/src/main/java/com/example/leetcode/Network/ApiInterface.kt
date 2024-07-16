package com.example.leetcode.Network

import com.example.leetcode.Network.ResponseModels.SolvedResponse
import retrofit2.http.GET

interface ApiInterface {

    @GET("/solved")
    suspend fun getSolvedDetails() : SolvedResponse


}