package com.example.leetcode.Network

import com.example.leetcode.Network.ResponseModels.SolvedResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/{username}/solved")
    suspend fun getSolvedDetails(@Path("username") username: String) : SolvedResponse


}