package com.example.internal_ex

data class  Fruit(var fr_name:String,var fr_fathername:String,var fr_age:Int ) {
    var id:Int=0
    constructor(id:Int,fr_name:String,fr_fathername:String,fr_age:Int):this(fr_name,fr_fathername,fr_age)
    {
        this.id=id
    }
}