package edu.iesam.studentplayground.features.students.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.studentplayground.R
import edu.iesam.studentplayground.features.students.data.StudentDataRepository
import edu.iesam.studentplayground.features.students.data.local.StudentMemLocalDataSource
import edu.iesam.studentplayground.features.students.data.local.StudentXmlLocalDataSource
import edu.iesam.studentplayground.features.students.data.remote.StudentApiRemoteDataSource
import edu.iesam.studentplayground.features.students.domain.DeleteStudentUseCase
import edu.iesam.studentplayground.features.students.domain.FetchAllStudentUseCase
import edu.iesam.studentplayground.features.students.domain.SaveStudentUseCase
import edu.iesam.studentplayground.features.students.domain.UpdateStudentUseCase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initStudents()
    }

    fun initStudents() {
        val dataRepository = StudentDataRepository(
            StudentApiRemoteDataSource(),
            StudentMemLocalDataSource(),
            StudentXmlLocalDataSource()
        )

        val viewModel = StudentViewModel(
            SaveStudentUseCase(dataRepository),
            FetchAllStudentUseCase(dataRepository),
            DeleteStudentUseCase(dataRepository),
            UpdateStudentUseCase(dataRepository)
        )


        viewModel.saveClicked("0001", "nombre1 apellido1 apellido1")
        val studentList = viewModel.fetchClicked()
        viewModel.updateClicked("0001", "nombre2 apellido2 apellido2")
        viewModel.deleteClicked("0001")
    }
}