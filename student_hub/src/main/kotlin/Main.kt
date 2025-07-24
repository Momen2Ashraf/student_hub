package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val student = Student(id = 1, "Momen", 2023, "momen@gmail.com")
    val choice = Command.AddStudent(student)
    when (choice) {
        is Command.AddStudent -> { addStudent() }
        is Command.UpdateStudentInfo ->{updateStudentInfo()}
        is Command.RemoveStudent -> {removeStudent()}
        is Command.GetAllStudents -> {getStudents()}
        is Command.FilterStudents -> {}
        is Command.GetStudentById -> {}
    }
}
fun addStudent (){
    println("Added successfully !!")
}
fun updateStudentInfo(){

}
fun removeStudent(){

}
fun getStudents(){

}
