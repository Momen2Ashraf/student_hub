data class Student(
    val id: Int,
    var name: String,
    var grade: String?= null,
    var status: String? = null,
    var gpa: Double? = null,
    var notes: String? = null
) : VaildiateData
