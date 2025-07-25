package exp

val students = mutableListOf<Student>()
val student = Student(5, "Momen", gpa = 4.0)
fun String.hasDigit() = if(this.any(){it.isDigit()})  true else false
fun String.hasCharcters() = if(this.any(){it.isLetter()}) true else false

fun main() {
        students.add(Student(1, "Zeina", "A", "passed", 3.8, "Excellent student"))
        students.add(Student(2, "Moe", "A", "passed", 3.8, "Excellent student"))
        students.add(Student(3, "leo", "A", "passed", 3.8, "Excellent student"))
        students.add(Student(4, "salah", "A", "passed", 3.8, "Excellent student"))
        students.add(Student(5, "Hassan", "A", "passed", 3.8, "Excellent student"))
        lateinit var choice:Command;
    while (true){
        println("\n1.Add student")
        println("2.update student")
        println("3.remove student")
        println("4.get or filter students")
        println("5. Exit")
        print("Choose: ")
        val char = readLine()

        val id = 5
        when (char) {
            "1" -> {
                println("enter the student data you want to add: ")
                print("id:");
                var id = readLine()
                if (id == null || id == "" || id.hasCharcters())
                {
                    println("enter valid id and try again ")
                    continue
                }
                print("name : ");
                var name: String? = readLine()
                if (name.isNullOrBlank() || name.hasDigit())
                {
                    println("enter valid name and try again ")
                    continue
                }
                print("status : ");
                val status = readLine()
                if (status.isNullOrBlank() || status.hasDigit()){
                    println("enter valid status and try again ")
                    continue
                }
                print("gpa : ");
                val gpa = readLine()
                if (gpa.isNullOrBlank() || gpa.hasCharcters()) {
                    println("enter valid GPA ")
                    return
                }
                print("grade : ");
                val grade = readLine()
                if (grade.isNullOrBlank() || grade.hasDigit())
                {
                    println("enter valid grade and try again ")
                    continue
                }
                choice = Command.AddStudent(Student(id.toInt(), name, grade, status, gpa.toDouble()))
                applyOpreations(choice)
            }

            "2" -> {
                print("enter student id that you want to modify : ")
                val id = readLine()?.toInt()
                if (id == null) {
                    println("enter valid id ")
                    return
                }
                choice = Command.UpdateStudentInfo(id)
                applyOpreations(choice)
            }

            "3" -> {
                print("enter student id :"); val id =readLine()
                if (id.isNullOrBlank() || id.hasCharcters())
                {
                    println("enter valid id ")
                    continue
                }
                choice = Command.RemoveStudent(id.toInt())
                applyOpreations(choice)
            }
            "4" -> {
                choice = Command.GetAllOrFilterStudents
                applyOpreations(choice)
            }

            "5" -> { return }
            else -> {
                print("invalid input please try again")
            }
        }
        }
    }

    fun addStudent(student: Student) {
        if (students.contains(student))
            println("student Already exist!!")
        else {
            students.add(student)
            println("Student Added Successfully")
        }
    }

    fun updateStudentInfo(id: Int) {
        val updatedStudent = students.find { it.id == id }
        if (updatedStudent == null) {
            println("didn't found specified student")
            return
        } else
            println("the saved data is $updatedStudent ")
        while (true){
            println("enter the new data")
        print("name : ");
        var name: String? = readLine()
        if (name!! == "") name = updatedStudent.name
        print("status : ");
        val status = readLine()
        print("gpa : ");
        val gpa = readLine()
        if (gpa!! == "") {
            println("enter valid GPA ")
            continue
        } else {
            val gpa = gpa.toDouble()
        }
        print("grade : ");
        val grade = readLine()

        if (updatedStudent.validateName(name) && updatedStudent.validateGpa(gpa.toDouble())) {
            updatedStudent.name = name
            updatedStudent.gpa = gpa.toDouble()
            updatedStudent.grade = grade
            updatedStudent.status = status
            println("Students updated successfully !")
            println(students.filter { it.id == id })
            break
        } else
            println("Try again")
    }

    }

    fun removeStudent(id: Int) {
        val removedStudent = students.removeIf { it.id == id }

        if (removedStudent) {
            println("Student with ID $id removed successfully.")
        } else {
            println("No student found with ID $id.")
        }
    }

    fun getStudents(students: List<Student>) {
        val student = StudentManager(students)
    }
    fun applyOpreations(opreation : Command){
        when (opreation) {
            is Command.AddStudent -> {
                if(student.validateStudent(opreation.student,students))
                    addStudent(opreation.student)
                else
                    println("you can try again ")
            }

            is Command.UpdateStudentInfo -> {
                updateStudentInfo(opreation.id)
            }

            is Command.RemoveStudent -> {
                removeStudent(opreation.id)
            }

            is Command.GetAllOrFilterStudents -> {
                getStudents(students)
            }
        }

    }
    