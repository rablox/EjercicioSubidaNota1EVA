package com.example.ejerciciosubidanota;

import com.example.ejerciciosubidanota.model.Estudiante;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DetallesEstudianteController {

    @FXML private Label labelName;
    @FXML private Label labelSurname;
    @FXML private Label labelAddress;
    @FXML private Label labelAbout;
    @FXML private Label labelPhone;
    @FXML private Label labelEmail;
    @FXML private TextField textFieldNotaMedia;
    @FXML private TextField textFieldAprobado;

    public void cargarEstudiante(Estudiante estudiante) {
        labelName.setText("Nombre: " + estudiante.getName());
        labelSurname.setText("Apellido: " + estudiante.getSurname());
        labelAddress.setText("Dirección: " + estudiante.getAddress());
        labelAbout.setText("About: " + estudiante.getAbout());
        labelPhone.setText("Teléfono: " + estudiante.getPhone());
        labelEmail.setText("Correo: " + estudiante.getEmail());
        textFieldNotaMedia.setText(String.valueOf(estudiante.getNotaMedia()));
        textFieldAprobado.setText(estudiante.isAprobado() ? "Sí" : "No");
    }

    @FXML
    private void botoncerrar() {
        Stage stage = (Stage) labelName.getScene().getWindow();
        stage.close();
    }
}
