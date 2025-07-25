package org.example

import org.example.utils.isEmail

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
val studentList = mutableListOf(
    Student(1, "Mirvt", 2022, "mirvt@gmail.com"),
    Student(2, "Ahmed", 2023, "ahmed@gmail.com"),
    Student(3, "Laila", 2021, "laila@gmail.com"),
    Student(4, "Ayman", 2027, "ayman@gmail.com"),
    Student(5, "Alaa", 2022, "alaa@gmail.com"),
    Student(6, "Esraa", 2025, "esraa@gmail.com"),
)

fun main() {
    val student = Student(id = 1, "Momen", 2023, "momen@gmail.com")
    val choice = Command.UpdateStudentInfo(5, gpa = 3.5, major = "Computer science")
    when (choice) {
        is Command.AddStudent -> {
            addStudent()
        }

        is Command.UpdateStudentInfo -> {
            updateStudentInfo(choice.id, choice.email, choice.gpa, choice.major)
        }

        is Command.RemoveStudent -> removeStudent(choice.student.id)
        is Command.GetAllStudents -> {
            getStudents()
        }

        is Command.FilterStudents -> {}
        is Command.GetStudentById -> {}
    }
}

fun addStudent() {
    println("Added successfully !!")
}

fun updateStudentInfo(
    id: Int,
    email: String? = null,
    gpa: Double? = null,
    major: String? = null,
//    advisor: String? = null,
//    status: String? = null,
//    notes: String? = null
) {
    val student = studentList.find { it.id == id }
    if (student == null) {
        println("Student with ID #$id isn't found")
        return
    }
    if (email != null) {
        if (email.isNotBlank() && email.isEmail()) {
            student.email = email
        } else {
            println("Unexpected email format")
        }
    }
    if (gpa != null) {
        if (gpa >= 0.0 && gpa <= 4.0)
            student.gpa = gpa
        else
            println("Unexpected GPA it must be between 0.0 and 4.0 (inclusive)")
    }
    if (major != null) {
        if (major.isNotBlank())
            student.major = major
        else
            println("Major can't be an empty string")
    }
}

fun removeStudent(id: Int) {
    val removedStudent = studentList.removeIf { it.id == id }

    if (removedStudent) {
        println("Student with ID $id removed successfully.")
    } else {
        println("No student found with ID $id.")
    }

}

fun getStudents() {

}
