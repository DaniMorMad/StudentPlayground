package edu.iesam.studentplayground.features.students.data

import edu.iesam.studentplayground.features.students.data.local.StudentMemLocalDataSource
import edu.iesam.studentplayground.features.students.data.local.StudentXmlLocalDataSource
import edu.iesam.studentplayground.features.students.data.remote.StudentApiRemoteDataSource
import edu.iesam.studentplayground.features.students.domain.Student
import edu.iesam.studentplayground.features.students.domain.StudentRepository

class StudentDataRepository(
    private val apiRemoteDataSource: StudentApiRemoteDataSource,
    private val memLocalDataSource: StudentMemLocalDataSource,
    private val xmlLocalDataSource: StudentXmlLocalDataSource
) : StudentRepository {
    override fun save(student: Student) {
        memLocalDataSource.save(student)
    }

    override fun fetch(): List<Student> {
        return memLocalDataSource.fetch()
    }

    override fun delete(exp: String) {
        memLocalDataSource.delete(exp)
    }

    override fun update(student: Student) {
        memLocalDataSource.update(student)
    }
}