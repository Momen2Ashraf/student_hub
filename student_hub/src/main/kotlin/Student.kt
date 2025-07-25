package org.example

data class Student(
    val id: Int,
    val name: String,
    val enrollmentYear: Int,
    var email: String,
    //students in the first year don't have gpa and might not asscoiated to major yet
    var gpa: Double? = null,
    var major: String? = null,
    // student register but still don't have an advisor or status
    var advisor: String? = null,
    var status: String? = null,
    var notes: String? = null
)
