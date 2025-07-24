package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val student = Student(id = 1, "Momen",2023,"momen@gmail.com")
    println("welcome admin would you like to ")

    while (true){
        println(
        "1- Add student \n"+
        "2- update student info \n"+
        "3- remove student \n"+
        "4- list students"
    )
       print("enter your choice : ")
    val choice = readLine()
    when(choice){
        "1" -> addStudent()
        "2" -> updateStudentInfo()
        "3" -> removeStudent()
        "4" -> getStudents()
        else -> println("invalid input try again")
    }
       print("would you like to make another operation (Y|N) : ")
       val char = readLine()
       if (char == "n" || char == "N")
           break
       else
           continue
   }
}
fun addStudent (){

}
fun updateStudentInfo(){

}
fun removeStudent(){

}
fun getStudents(){

}