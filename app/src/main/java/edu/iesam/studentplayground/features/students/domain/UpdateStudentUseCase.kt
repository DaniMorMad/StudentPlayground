package edu.iesam.studentplayground.features.students.domain

class UpdateStudentUseCase (val studentRepository: StudentRepository) {
    operator fun invoke(student: Student){
        studentRepository.update(student)
    }
}