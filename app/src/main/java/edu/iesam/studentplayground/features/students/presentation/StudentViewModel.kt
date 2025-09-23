package edu.iesam.studentplayground.features.students.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.studentplayground.features.students.domain.DeleteStudentUseCase
import edu.iesam.studentplayground.features.students.domain.FetchAllStudentUseCase
import edu.iesam.studentplayground.features.students.domain.SaveStudentUseCase
import edu.iesam.studentplayground.features.students.domain.Student
import edu.iesam.studentplayground.features.students.domain.UpdateStudentUseCase

class StudentViewModel(
    private val saveStudentUseCase: SaveStudentUseCase,
    private val fetchAllStudentUseCase: FetchAllStudentUseCase,
    private val deleteStudentUseCase: DeleteStudentUseCase,
    private val updateStudentUseCase: UpdateStudentUseCase
) : ViewModel() {


    fun saveClicked(exp: String, name: String){
        saveStudentUseCase.invoke(Student(exp, name))
    }

    fun fetchClicked(): List<Student> {
        return fetchAllStudentUseCase.invoke()
    }

    fun deleteClicked(exp: String) {
        deleteStudentUseCase.invoke(exp)
    }

    fun updateClicked(exp: String, name: String){
        updateStudentUseCase.invoke(Student(exp, name))
    }
}