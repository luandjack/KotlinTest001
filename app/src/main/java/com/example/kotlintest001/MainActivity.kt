package com.example.kotlintest001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalArgumentException
import java.lang.Integer.parseInt
import java.lang.NullPointerException
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    val bucketList = mutableListOf<String>( "11" , "22" , "33" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //textView.text = R.string.app_name.toString()
        textView.text = getString(R.string.app_name)

        button3.setOnClickListener {

            println(".....................Clicked")

            val random = (Math.random() * bucketList.count() ).toInt()

            textView.text = bucketList[random]

            val newWish = textView.text.toString()

            bucketList.add(newWish)

            println( bucketList )

        }

        button2.setOnClickListener{
            button2ClickEvent()
        }

    }

    private fun button2ClickEvent(){
        println( "...................button2 clicked" )
        textView.text = null

        val count = this.bucketList.count()

        if( count > 0 ){
            val random = ( Math.random() * count ).toInt()
            println( random )

        }else{
            println( "................count:${count}"  )
        }
    }

}

fun main(args: Array<String>) {
    println("..................Hello World")
    var v1 = "Hello"

    println("Say " + v1)

    v1 = "Hello Jack"

    println("Say " + v1)

    val a: Int

    a = 1

    println( "a:" + a )

    var b = "a"

    b = "s"

    println( "b:" + b )

    //println( ( a == b ) )

    var b1: Boolean = false
    var b2 = true

    println( ( b1 == b2 ) )

    var e1: Byte = -128
    var e2 = 127

    var r1: Short = -32768
    var r2 = 32767

    var ms = """aaaaaaa
        bbbbbb
        cccccc"""

    println(ms)

    var str1 = "abcde"

    println(str1.contains("b"))

    println("str1 contains e: ${str1.contains("e")}")

    var str2: String ?= null

    //str2 = if( str2 == null ) "is null" else str2

    println(str2)

    //println(str2.length)

    println(str2?.length)
    //println(str2!!.length)

    reversedStr(str1)

    var int1 : Int ?= 100
    var int2 : Int = -1

    println( "$int1 , $int2" )

    println( calculateVolume(2,3,4) )

    println( calculateVolume(2,3,4, 5) )

    test01()
    test02()
    test03()
    test04()
    test05()
    test06()
    test07()
    test08()
    test09()
    test10()
    test11()
    test12()
    test13()
    test14()
    test15()
    test16()
    test17()
    test18()
    test19()
    test20()
    test21()

}

fun String.clearDash():String{
    return this.replace("-","")
}

fun MutableList<Int>.swap(index1:Int,index2:Int){
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun test21(){
    val str = "1111-222222"

    var list = mutableListOf( 1 , 2 , 3 )

    println(list)

    list.swap( 0 , 2 )

    println(list)
}

fun fail( message:String){
    throw IllegalArgumentException(message)
}

fun test20(){
    var map: HashMap<Int,String> = HashMap()
    map.put(1,"B")

    for( (key,value) in map){
        println("Key: $key , Value: $value")
    }

    map.mapValues { (key,value) -> println("Key: $key , Value: $value") }

    try{
        fail("exception test")
    }catch( e: NullPointerException){

    }catch( e: Exception){
        println( e.message )
        e.printStackTrace()
    }finally{

    }

    val a: Int? = try{ parseInt("1111aa") }catch(e:Exception){ null }

    println(a)
}

data class IsData(val name:String , var arg: Int ){}
class NonData(val name:String , var arg: Int ){}

fun CallAPI(): IsData{
    return IsData("peter",43)
}

fun test19(){
    var d1 = IsData("jack" , 22 )
    var d2 = IsData("jack" , 22 )
    var d3 = IsData("jack" , 30 )

    var nd1 = NonData("jack" , 22 )
    var nd2 = NonData("jack" , 22 )
    var nd3 = NonData("jack" , 30 )

    println(d1)
    println(nd1)

    println("d1 equals d1:${d1.equals(d1)}")
    println("d1 equals d2:${d1.equals(d2)}")
    println("d1 equals d3:${d1.equals(d3)}")

    println("nd1 equals nd1:${nd1.equals(nd1)}")
    println("nd1 equals nd2:${nd1.equals(nd2)}")

    println("d1 hashCode:${d1.hashCode()}")
    println("d2 hashCode:${d2.hashCode()}")
    println("d3 hashCode:${d3.hashCode()}")

    println("nd1 hashCode:${nd1.hashCode()}")
    println("nd2 hashCode:${nd2.hashCode()}")
    println("nd3 hashCode:${nd3.hashCode()}")

    println( d1.component1() )
    println( d1.component2() )

    var c1 = d1.copy("riva")
    var c2 = c1

    println("d1:${d1.toString()}")

    c1.arg = 33

    println("d1:${d1.toString()}")
    println("c1:${c1.toString()}")

    c2.arg= 33

    println("d1:${d1.toString()}")
    println("c2:${c2.toString()}")

    var (name1,age1) = d1
    println("d1 name:${name1}")
    println("d1 age:${age1}")

    var (_,age2) = d2

    println("d2 age:${age2}")

    val (name3,age3) = CallAPI()

    println("name3:${name3}")

}

fun test18(){
    var sumA = { x:Int , y:Int -> x + y }
    sumA(1,2).also(::println)

    var sumB : ( Int , Int ) -> Int = { x,y -> x + y }
    sumB(1,2).also(::println)

    fun process(str:String , f:()->Unit){
        println("in process")
        f()
        println(str)
    }

    var step = {
        println("step 1")
        println("step 2")
    }

    process("......Done 1" , step )

    process("......Done 2" , {
        println("step 1")
        println("step 2")
    } )

    val another : String.(Int) -> String = { this + it }

    var str = "123-"

    str.another(456).also(::println)

    var arrayV1 = arrayOf(1,2,3,4,5)

    arrayV1.forEach { item -> print(item) }
    println()
    arrayV1.forEach { i -> print(i) }
    println()
    arrayV1.forEach { print(it) }
    println()
    arrayV1.any { item -> item > 3 }.also(::print)
    println()
    arrayV1.all { it > 3 }.also(::print)
    println()
    arrayV1.count { it > 3 }.also(::print)

}



fun test17(){
    var printMsg = { msg:String ->
        println("Hi")
        println("lambda -> ${msg}")
    }

    printMsg("111111222222")

    fun printMsg(msg:String){
        println("fun(${msg})")
    }

    printMsg("456")
}

class Customer(){
}
class CustomerA(account: String , password: String ){
    //println( "account:" + account )
}
class CustomerB constructor(account:String, password:String){
    val account = account.toLowerCase()
    var password = password

    fun test(){
        println( "account:" + account )
    }

}
class CustomerC @Deprecated("do not use") constructor(account:String, password:String){
}
class CustomerD private @Deprecated("do not use") constructor(account:String, password:String){
}
class CustomerF constructor(val account:String, var password:String){
    fun test(){
        println( "account:" + account )
    }
}

class CustomerE(){
    var name: String? = null
    var isVip: Boolean = false
    var birthday: LocalDate? = null
    val createdOn: LocalDate = LocalDate.now()
}

class CustomerG(_account: String , _password: String ){
    val account : String = _account
    var password: String = _password
    var name: String? = null
    var isVip: Boolean = false
    var birthday: LocalDate? = null
    var createdOn: LocalDate = LocalDate.now()

}

class CustomerH(_account: String , _password: String){
    init {
        println("init account:${_account}")
    }

    var account : String = _account.also (::println)
    var password : String = _password.also (::println)
    var isVip : Boolean = false.also(::println)
    var birthday: LocalDate = LocalDate.now()

    private var _isVip2: Boolean = false
    public val isVip2: Boolean
        get() {
            if (birthday?.getMonth() == LocalDate.now().getMonth())
            {
                return true
            }

            return _isVip2;
        }

    fun changeVip2( _isVip2: Boolean){
        this._isVip2 = _isVip2
    }

    constructor(_account: String , _password: String , _isVip : Boolean):this(_account , _password){
        println("Seconde Constructor: $_account")
        this.isVip = _isVip
    }
}

open class User(_account: String,_password: String){
    var account: String = _account.toLowerCase()
    private var password: String = _password
    public var name: String? = null
    val createOn: LocalDate = LocalDate.now()
    var birthday: LocalDate? = null

    fun changePass(_newPassword:String){
        this.password = _newPassword
    }

    open fun whoAreYou(){
        println("user")
    }

}

class CustomerI(_account: String,_password: String):User(_account,_password){

    private var _isVip: Boolean = false

    public val isVip: Boolean
        get() {
            if (birthday?.getMonth() == LocalDate.now().getMonth())
            {
                return true
            }

            return _isVip;
        }

    override fun whoAreYou(){
        println("customer")
    }
}

class Employee(_account: String,_password: String):User(_account,_password){
    public var title: String = ""
    private var salary: Int = 0

    override fun whoAreYou(){
        println("employee")
    }
}

fun test16(){
    var cust = CustomerI("jack","1111a")
    println(cust.whoAreYou())

    var employee = Employee("jack" , "2222b")
    println(employee.whoAreYou())

}

fun test15(){
    var cust = CustomerG("A" , "123").apply(){
        name = "Jack"
        isVip = true
    }

    println(".......Name:${cust.name} IsVip:${cust.isVip}")

    var cust2 = CustomerH("aaaa" ,"bbbb" )

    var cust3 = CustomerH("aaaa" ,"bbbb", false )

    println("cust3 isVip2:${cust3.isVip2}")

    cust3.changeVip2(false)

    println("cust3 isVip2:${cust3.isVip2}")

}

fun test14(){
    var cust = CustomerE()
    cust.name = "Jack"
    cust.birthday = LocalDate.of(2000,6,1)

    println("Name: ${cust.name} , IsVip: ${cust.isVip}")
    println("BirthDay: ${cust.birthday}")
}

fun test13(){
    println()
    val c1 = Customer()
    val c2 = CustomerA("1" ,"2")
    val c3 = CustomerB("1AAA" ,"2")
    println( c3.account + ":" + c3.password )
    c3.test()
    val c4 = CustomerC("1" ,"2")
    //val c5 = CustomerD("1" ,"2")
    val c6 = CustomerF("1" ,"2")
    println( c6.account + ":" + c6.password )
    c6.test()

}

fun test12(){
    println()
    first@
    do{
        second@
        println("second")
        while(true){
            if(true){
                break@first
                break
                continue@first
                continue
            }
        }

    }while(true)

    print("Done.")
}

fun test11(){
    println()
    var a = 0
    while(a<=10){
        a++
        if( a>5 ) break
        print("$a ")
    }

    println()
    a = 0
    while(a<=10){
        a++
        if( a % 2 == 1 ) continue
        print("$a ")
    }

}

fun test10(){
    val from = 0
    val stop = 10

    for( count in from until stop ){
        print("$count ")
    }

    println()

    for( i in 10 downTo 1 step 2){
        print("$i ")
    }

    println()

    var a = 0

    while(a <= 10){
        print("$a ")
        a++
    }

    println()

    a = 0

    do{
        print("$a ")
        a++
    }while(a <= 10)
}

fun test09(){
    val num = 0
    for( count in num..(num+10)){
        print("$count")
    }

    println()

    for( i in 0..10 step 2){
        print("$i")
    }
}

fun test08(){
    val from = 0
    val to = 10

    for( count in from..to){
        println("$count ")
    }

    println()

    for( i in 0..10 ){
        println("$i ")
    }
}

fun test07(){
    var str = "Today is Monday"

    for( char in str){
        print( "${char}_" )
    }

    println()
    var arryList = arrayListOf( "a" , "b" , "c" )
    for( value in arryList ){
        println("${value}")
    }

    println()
    var hashMap = hashMapOf( "k1" to "v1" , "k2" to "v2" )

    for( (key , value) in hashMap ){
        println("${key}:${value} ,")
    }

}

fun test06(){
    var hashMap = hashMapOf( "k1" to "v1" , "k2" to "v2" )
    println(hashMap)
    hashMap.put("k3" , "v3")
    println(hashMap)
    hashMap["k4"] = "v4"
    println(hashMap)
    hashMap.remove("k4")
    println(hashMap)
    hashMap.clear()
    println(hashMap)
}

fun test05(){
    var readOnlyMap = mapOf( "k1" to "v1" , "k2" to "v2" )
    println(readOnlyMap)
    println(readOnlyMap["k1"])
    println(readOnlyMap["k11"])
    println(readOnlyMap.get("k1"))
    println(readOnlyMap.getOrDefault("k11","v11"))
    println(readOnlyMap.keys)
    println(readOnlyMap.values)
}

fun test04(){
    var arrayList = arrayListOf<String>( "aa" , "bb" , "cc" )
    println(arrayList)
    arrayList.add("dd")
    println(arrayList)
    arrayList.removeAt(2)
    arrayList[1] = "abc"
    println(arrayList)

}

fun test03(){
    var readOnlyList = listOf( "111" , "222" , "333" )
    println( readOnlyList.last() )
    println( readOnlyList.asReversed() )
    println( readOnlyList.size )

}

fun test02(){
    var str = "C"

    when(str){
        "A" -> {
            println("is A")
        }
        "B", "C" -> {
            println("is B or C")
        }
        else -> {
            println("none above")
        }
    }
}

fun test01(){
    val i = 10

    if( i > 10 ){
        println( "more than 10" )
    }else if( i < 10 ){
        println( "less than 10" )
    }else {
        println( "equlas 10" )
    }
}

fun calculateVolume( width: Int , height: Int , length: Int , num: Int = 1):Int{
    return width * height * length * num
}

fun reversedStr(str:String?){
    if( str != null ){
        println(str.reversed())
    }else{
        println("is null")
    }
}