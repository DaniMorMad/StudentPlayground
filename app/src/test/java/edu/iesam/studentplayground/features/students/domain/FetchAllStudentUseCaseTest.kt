package edu.iesam.studentplayground.features.students.domain

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test

class FetchAllStudentUseCaseTest {
    @Test
    fun `when invoked then return students`(){
        // Given
        val studentList = listOf(
            Student("1", "a"),
            Student("2", "b"),
            Student("3", "c")
        )
        val studentRepositoryMock = mockk<StudentRepository>()
        every { studentRepositoryMock.fetch() } returns studentList
        val fetchAllStudentUseCase = FetchAllStudentUseCase(studentRepositoryMock)

        // When
        val returnedStudents = fetchAllStudentUseCase()

        // Then
        assertEquals(studentList, returnedStudents)
        verify(exactly = 1) { studentRepositoryMock.fetch() }
    }
}