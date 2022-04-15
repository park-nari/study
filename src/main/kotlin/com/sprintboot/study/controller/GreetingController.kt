package com.sprintboot.study.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.Date


@Controller
class GreetingController {
    @GetMapping("/greeting")
    fun greeting(
        @RequestParam(name = "name", required = false, defaultValue = "World") name: String?,
        model: Model
    ): String? {
// 리스트
        val array = arrayOf(1,2,3)
        val list = listOf(1,2,3)

        val array2 = arrayOf(1,"one", 2)
        val list2 = listOf(1,"one", 2)

        array[0] = 4
        // 리스트는 이뮤터블이라 값을 변경할수 없다.
        // 주소값을 참조하기 때문에 val를 사용해도 됨
        val arrayList = arrayListOf<Int>()
        arrayList.add(100)

        // 반복문 for while
        val students = arrayListOf("jia", "jua", "nari", "hong", "oh")

        var studentNames = ""
        for(name in students){
            studentNames += name
        }

        for (i in 1..10 step 2){ // until downto

        }
        for ((index, name) in students.withIndex()){}

        // nonNull nullable
        var name : String = "nari"
        var nonName : String? = null // type생략 불가능 타입 생략한 경우 널이 들어 갈수 없음
        // null?.메소드 널 아닌경우 메소트 실행 널인경우 null반환
        // ?: 디폴트 값을 설정해줌
        // !! 널 타입이지만 널아님
        //  ?.let{}

        // Class
        val testClass = Human("mari")

        // 람다
        // 람다식을 value처럼 쓸수 있는 익명 함수 이다.
        val square : (Int) -> (Int) = { number ->  number * number}
        val nameAge = { name: String, age: Int -> "my name is ${name} and i'm ${age}"}

        val testSquare = square(5)
        val testNameAge = nameAge("nari", 35)

        // 확장 함수
        val pizzaIsGreat : String.() -> String = {
            this + " Extension"
        }

        var testPizzaIsGreate = "nari".pizzaIsGreat()

        fun extendString(name: String, age : Int):String {
            val introduceMyself : String.(Int) -> String = { "my name is ${this} and i'm ${it} years old"}
            return name.introduceMyself(age)
        }
        // 람다의 리턴 마지막 한줄이 리턴 값이 된다.
        val calculateGrade : (Int) ->  String = {
            when(it){
                in 1..40 -> "가"
                in 41..70 -> "미"
                in 71..100 -> "수"
                else -> "err"
            }
        }

        //다양한 람다
        fun invokeLamda(lamda : (Double) ->  Boolean) : Boolean{
            return lamda(5.2343)
        }

        val lamda : (Double) -> Boolean = {
            number : Double -> number === 4.3213
        }
        invokeLamda(lamda)
        invokeLamda({true})
        invokeLamda({ it > 3.22 })
        invokeLamda { it > 3.22 }

        // 익명함수
        // 1. 코틀린이 아니 자바 인터페이스여야 한다.
        // ㅏㄷㄱ하나의 메소드만 가져야 한다.

        //DATACLASS pojo
        val ticketA = Ticket("korea", "nari", "", 14)

        //Companion Object
        // companion object 에 이름이 없을 경우
//        val gook = Book.Companion.create()
        val book = Book.BookFactoy.myBook

        // object
        val car1 = CarFactory.makeCar(10)
        val car2 = CarFactory.makeCar(400)

        model.addAttribute("for", "forTest: studentNames is ${studentNames}")
        model.addAttribute("name", name)
        model.addAttribute("message", helloWorld())
        model.addAttribute("add", add(1,1))
        return "index"
        // C S i 클래스 보기
        // 정렬 Ctrl Alt i
        // C A P make parameter
        // C A V make value
        // C S Insert getset
        // C F9 컴파일
        // C S F9 현 클래스만 컴파일
        // A S F10 실행
        // C N 클래스검색
        // C S N 파일
        // C S A N  메소드 검색
        // C S F 파일안의 스트링
        // C E 최근 사용 파일
        // A R or L
//        <!-- @링크  #텍스트(다국어) utext는 테그포함  $컨트롤러에서 전달된 값  *오브젝트 ~프래그먼트 | 연결부호 필요 없음- 문자 따옴표 안에 따옴표 attr-> 속성을 복수로 사용 사용안해도 됨-->
//        <!-- with 지역 변수 [[문법]][()] 태그 사용가능 (utext) -->
    }

    // 함수
    fun helloWorld() : String{
        return "Hello World! class!"
    }

    fun add(a : Int, b : Int) : Int{
        return a+b
    }
}
object CarFactory{
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car{
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower : Int)
//Companion Object
class Book private constructor(val id: Int, val name: String){
    companion object BookFactoy : IdProvider{
        // property
        val myBook = "name"

        //static
        fun create() = Book (0, myBook)
        override fun getId() {
            TODO("Not yet implemented")
        }
    }
}
interface IdProvider{
    fun getId()
}
//DataClass
// toString, hashCode(), equls(), copy()
data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int)
// 초기화
// 상속하기 위해서는 open예약어? 를 셋
class Human (name: String = "defualtName"){

    // 주생성자를 반듯이 받아와야 함
    constructor(name: String, age: Int) : this(name){

    }
    // 주생성자 초기화의 로직
    init {

    }
    fun eatingCake(){

    }
}