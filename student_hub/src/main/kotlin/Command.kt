package org.example

sealed class Command {
    data class AddStudent(val student: Student) : Command()
    data class UpdateStudentInfo(val student: Student) : Command()
    data class RemoveStudent(val student: Student) : Command()
    object GetAllStudents : Command()
    data class GetStudentById(val studentId: Int) : Command()
    data class FilterStudents(
        val gradeLevel: Int? = null,
        val status: String? = null,
        val nameQuery: String? = null
    ) : Command()
}