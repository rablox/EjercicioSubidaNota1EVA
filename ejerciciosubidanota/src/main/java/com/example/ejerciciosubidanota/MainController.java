package com.example.ejerciciosubidanota;

import com.example.ejerciciosubidanota.model.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

@SuppressWarnings("ALL")
public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Button botonDetalle;

    @FXML
    private TableColumn<?, ?> columnaApellidos;

    @FXML
    private TableColumn<?, ?> columnaCorreo;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private TableColumn<?, ?> columnaTelefono;

    @FXML
    private TableView<Estudiante> tabla;

    @FXML
    private Label textoAsignatura;

    private ObservableList<Estudiante> listaEstudiantes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnaApellidos.setCellValueFactory(new PropertyValueFactory<>("surname"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("phone"));
        columnaCorreo.setCellValueFactory(new PropertyValueFactory<>("email"));

        listaEstudiantes = FXCollections.observableArrayList();
        cargarEstudiantes();
        cargarAsignatura();
        acciones();
    }

    private void acciones() {
        botonDetalle.setOnAction(this);
    }

    private void cargarAsignatura() {
        String urlString = "https://run.mocky.io/v3/1f9f8119-9fb8-4f05-b8fc-f6eb113338d8";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            String response = result.toString();

            JSONObject responseObject = new JSONObject(response);
            JSONObject asig = responseObject.getJSONObject("subject");
            String name = asig.getString("name");

            textoAsignatura.setText(name);
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
    }
    private void cargarEstudiantes() {
        String urlString = "https://run.mocky.io/v3/1f9f8119-9fb8-4f05-b8fc-f6eb113338d8";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            String response = result.toString();

            JSONObject responseObject = new JSONObject(response);
            JSONArray estudiantesArray = responseObject.getJSONArray("students");

            for (int i = 0; i < estudiantesArray.length(); i++) {
                JSONObject estudiante = estudiantesArray.getJSONObject(i);
                String name = estudiante.getString("name");
                String surname = estudiante.getString("surname");
                String email = estudiante.getString("email");
                String phone = estudiante.getString("phone");
                String address = estudiante.getString("address");
                String about = estudiante.getString("about");
                Estudiante e = new Estudiante(name, surname, email, phone,address, about , 0.0, false);
                listaEstudiantes.add(e);
            }
            tabla.setItems(listaEstudiantes);
        } catch (IOException e) {

        }
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonDetalle) {
            Estudiante selectedEstudiante = tabla.getSelectionModel().getSelectedItem();
            if (selectedEstudiante == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Selecciona un estudiante");
                alert.showAndWait();
            } else {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("detallesestudiante.fxml"));
                    Parent root = loader.load();
                    DetallesEstudianteController detallesController = loader.getController();
                    detallesController.cargarEstudiante(selectedEstudiante);

                    Stage stage = new Stage();
                    stage.setTitle("Detalles del Estudiante");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                }
            }
        }
    }

}



