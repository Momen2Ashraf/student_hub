package org.example.utils

import org.example.Student
import java.util.regex.Pattern.compile

val emailRegex = compile(
    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"
)
fun String.isEmail() : Boolean {
    return emailRegex.matcher(this).matches()
}
fun Student.print(){
    println("ID = $id")
    println("Name = $name")
    println("Enrollment Year = $enrollmentYear")
    println("Email = $email")
    println("GPA = ${gpa?:"0.0"}")
    println("Major = ${major?:"Not associated yet"}")
    if(!advisor.isNullOrBlank()){
        println("Advisor = $advisor")
    }
    if(!status.isNullOrBlank()){
        println("Status = $status")
    }
    if(!notes.isNullOrBlank()){
        println("Notes = $notes")
    }
}