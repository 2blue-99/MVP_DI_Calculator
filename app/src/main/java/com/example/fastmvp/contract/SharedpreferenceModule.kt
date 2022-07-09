package com.example.fastmvp.contract

interface SharedpreferenceModule {
    fun save(result:String)
    fun get(): String
}