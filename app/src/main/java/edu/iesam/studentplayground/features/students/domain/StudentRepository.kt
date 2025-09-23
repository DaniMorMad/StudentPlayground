package edu.iesam.studentplayground.features.students.domain

interface StudentRepository {

    fun save(student: Student)
    fun fetch(): List<Student>
    fun delete(exp: String)
    fun update(student: Student)
}