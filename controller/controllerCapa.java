/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Matricula........: 202310445
* Inicio...........: 27/06/2024
* Ultima alteracao.: 27/06/2024
* Nome.............: controllerCapa
* Funcao...........: Controllar as interações e imagens que estao na capa
*************************************************************** */
package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class controllerCapa {
  Stage stage;
  Scene scene;
  Parent root;


  public void mudarTela(MouseEvent event) throws IOException {
      root = FXMLLoader.load(getClass().getResource("/view/tela.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
}
