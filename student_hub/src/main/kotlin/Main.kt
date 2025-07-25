package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val studentList = mutableListOf(
        Student(1, "Mirvt", 2022, "mirvt@gmail.com"),
        Student(2, "Ahmed", 2023, "ahmed@gmail.com"),
        Student(3, "Laila", 2021, "laila@gmail.com")
    )

    val student = Student(id = 1, "Momen", 2023, "momen@gmail.com")
    val choice = Command.AddStudent(student)
    when (choice) {
        is Command.AddStudent -> { addStudent() }
        is Command.UpdateStudentInfo ->{updateStudentInfo()}
        is Command.RemoveStudent -> removeStudent(choice.student.id)
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
fun removeStudent(id: Int){
    val removedStudent = studentList.removeIf { it.id == id }

    if (removedStudent) {
        println("Student with ID $id removed successfully.")
    } else {
        println("No student found with ID $id.")
    }

}
fun getStudents(){

}
