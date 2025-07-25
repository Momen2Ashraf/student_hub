interface VaildiateData {

    fun validateStudent(student: Student,students: List<Student>): Boolean{
            if (validateGpa(student.gpa) && validateName(student.name) && validateId(student.id,students))
                return true
            return false
    }

    fun validateGpa(gpa: Double?): Boolean{
        if (gpa != null) {
            if ( gpa < 0 || gpa > 4) {
                println("Enter valid gpa !!")
                return false;
            }
        }
        return true
    }
    fun validateName(name: String): Boolean{
        if (name != null && name.any() { it.isDigit() }) {
            println("Enter valid name format")
            return false
        }
        return true
    }
    fun validateId(id: Int,students: List<Student>): Boolean{
        val student = students.find { it.id == id }
        if(student == null)
            return true
        println("this id already exist ")
        return false
    }

}