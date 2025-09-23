package edu.iesam.studentplayground.features.students.domain

class FetchAllStudentUseCase (val studentRepository: StudentRepository) {
    operator fun invoke(): List<Student> {
        return studentRepository.fetch()
    }
}