package com.example.leetcode.Network.ResponseModels

data class SolvedResponse(
    val acSubmissionNum: List<AcSubmissionNum>,
    val easySolved: Int,
    val hardSolved: Int,
    val mediumSolved: Int,
    val solvedProblem: Int,
    val totalSubmissionNum: List<TotalSubmissionNum>
)