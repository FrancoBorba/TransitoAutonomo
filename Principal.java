/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Matricula........: 202310445
* Inicio...........: 15/06/2024
* Ultima alteracao.: -----
* Nome.............: TransiotAutonomo
* Funcao...........: criar um progama que simule a movimentação de carros em uma cidade , cada carro tendo seu percurso fixo e utilizar semafaros para evitar colisão de um ou mais carros nas zonas criticas
*************************************************************** */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.controllerTela;
import controller.controllerCapa;

@SuppressWarnings("unused")
public class Principal extends Application{

  /* ***************************************************************
  * Metodo: main
  * Funcao: metodo principal do codigo , primeiro metodo a ser rodado e executado
  * Parametros: String[] args
  * Retorno: void
  *************************************************************** */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  
  /* ***************************************************************
  * Metodo: start
  * Funcao: metodo da classe Apllicatiton que executa o javaFX
  * Parametros: Stage(primeira tela que sera vista)
  * Retorno: void
  *************************************************************** */
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/view/capa.fxml")); // carregar o fmxl na tela
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Transito Autonomo"); // define um titulo
    primaryStage.setResizable(false); // nao permite mudar o tamanho da tela
    primaryStage.setOnCloseRequest(e -> System.exit(0)); // encerra as thread quando o usario fecha a tela
    primaryStage.show(); 
}

}