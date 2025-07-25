
class StudentManager(val students: List<Student>) {
    init {
        getOrFilterStudents()
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
    fun getOrFilterStudents(){
        while (true) {
            println("1. View all students")
            println("2. Filter by name")
            println("3. Filter by status")
            println("4. Filter by GPA range")
            println("5. Show average GPA of passed students")
            println("6. Exit")
            print("Choose: ")

            when (readLine()?.trim()) {
                "1" -> viewAllStudents()
                "2" -> {
                    print("Enter name: ")
                    val name = readLine().orEmpty()
                    filterByName(name)
                }
                "3" -> {
                    print("Enter status: ")
                    val status = readLine().orEmpty()
                  filterByStatus(status)
                }
                "4" -> {
                    try {
                        print("Enter min GPA: ")
                        val min = readLine()?.toDoubleOrNull()
                        print("Enter max GPA: ")
                        val max = readLine()?.toDoubleOrNull()
                        if (min != null && max != null) {
                            filterByGpaRange(min, max)
                        } else {
                            println("Invalid GPA input\n")
                        }
                    } catch (e: Exception) {
                        println("Error: ${e.message}\n")
                    }
                }
                "5" -> showAveragePassedGpa()
                "6" -> {
                    println("Goodbye.")
                    break
                }
                else -> println("Sorry.Invalid option\n")
            }
        }
    }

}


//fun main() {
//}
