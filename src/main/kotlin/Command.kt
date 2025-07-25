sealed class Command {
    data class AddStudent(val student: Student) : Command()
    data class UpdateStudentInfo(val id: Int) : Command()
    data class RemoveStudent(val id: Int) : Command()
    object GetAllOrFilterStudents : Command()
}