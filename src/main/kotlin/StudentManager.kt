data class Student(
    val id: Int,
    var name: String,
    var grade: String,
    var status: String? = null,
    var gpa: Double? = null,
    var notes: String? = null
)

object StudentManager {
    private val students = mutableListOf<Student>()

    init {
        // Sample data for testing
        students.add(Student(1, "Zeina", "A", "passed", 3.8, "Excellent student"))
        students.add(Student(2, "Ahmed", "B", "active", 2.9, "Needs improvement"))
        students.add(Student(3, "Laila", "A", "passed", 3.7))
        students.add(Student(4, "Omar", "C", "failed", null))
        students.add(Student(5, "Mona", "B", "active", 3.0))
    }

    fun viewAllStudents() {
        if (students.isEmpty()) {
            println("No students available.\n")
        } else {
            println(" All Students:")
            students.forEach { println(it) }
            println()
        }
    }

    fun filterByName(name: String) {
        val result = students.filter { it.name.contains(name, ignoreCase = true) }
        if (result.isEmpty()) {
            println("No students with name \"$name\"\n")
        } else {
            println("Students with name \"$name\":")
            result.forEach { println(it) }
        }
        println()
    }

    fun filterByStatus(status: String) {
        val result = students.filter { it.status?.equals(status, ignoreCase = true) == true }
        if (result.isEmpty()) {
            println("No students with status \"$status\"\n")
        } else {
            println("Students with status \"$status\":")
            result.forEach { println(it) }
        }
        println()
    }

    fun filterByGpaRange(min: Double, max: Double) {
        val result = students.filter { it.gpa?.let { g -> g in min..max } == true }
        if (result.isEmpty()) {
            println("No students with GPA in $min - $max\n")
        } else {
            println("Students with GPA between $min and $max:")
            result.forEach { println(it) }
        }
        println()
    }

    fun showAveragePassedGpa() {
        val passedGpas = students
            .filter { it.status == "passed" && it.gpa != null }
            .map { it.gpa!! }

        val average = passedGpas.takeIf { it.isNotEmpty() }?.average()

        if (average != null) {
            println("Average GPA of passed students: %.2f\n".format(average))
        } else {
            println("No passed students with GPA found.\n")
        }
    }
}

fun main() {
    while (true) {
        println("StudentHub Menu")
        println("1. View all students")
        println("2. Filter by name")
        println("3. Filter by status")
        println("4. Filter by GPA range")
        println("5. Show average GPA of passed students")
        println("6. Exit")
        print("Choose: ")

        when (readLine()?.trim()) {
            "1" -> StudentManager.viewAllStudents()
            "2" -> {
                print("Enter name: ")
                val name = readLine().orEmpty()
                StudentManager.filterByName(name)
            }
            "3" -> {
                print("Enter status: ")
                val status = readLine().orEmpty()
                StudentManager.filterByStatus(status)
            }
            "4" -> {
                try {
                    print("Enter min GPA: ")
                    val min = readLine()?.toDoubleOrNull()
                    print("Enter max GPA: ")
                    val max = readLine()?.toDoubleOrNull()
                    if (min != null && max != null) {
                        StudentManager.filterByGpaRange(min, max)
                    } else {
                        println("Invalid GPA input\n")
                    }
                } catch (e: Exception) {
                    println("Error: ${e.message}\n")
                }
            }
            "5" -> StudentManager.showAveragePassedGpa()
            "6" -> {
                println("Goodbye.")
                break
            }
            else -> println("Sorry.Invalid option\n")
        }
    }
}
