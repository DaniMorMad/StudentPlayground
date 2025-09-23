package edu.iesam.studentplayground.features.students.data.local

import edu.iesam.studentplayground.features.students.domain.Student

class StudentMemLocalDataSource {
    private val dataSource : MutableMap<String, Student> = mutableMapOf()

    fun save(student: Student) {
        dataSource.put(student.exp, student)
    }

    fun fetch (): List<Student> {
        val studentList = dataSource.values.toList()
        return studentList
    }

    fun delete (exp: String) {
        dataSource.remove(exp)
    }

    fun update(student: Student) {
        dataSource.replace(student.exp, student)
    }
}