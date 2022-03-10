package com.shang.jetpackmovie.activity.children.Base

interface ILoreMore<A> {
    fun getIPage(): Int
    fun getIData(): List<A>
}