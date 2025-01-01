/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Matricula........: 202310445
* Inicio...........: 15/06/2024
* Ultima alteracao.: 24/06/2024
* Nome.............: AnimacaoCarro
* Funcao...........: criar o objeto que controla as animacoes dos carros
*************************************************************** */
package model;


import javafx.application.Platform;

public class AnimacaoCarro {
  private Carro carro;
 
   /* ***************************************************************
  * Metodo: construtor da class
  * Parametros: Carro
  * Retorno: void
  *************************************************************** */
  public AnimacaoCarro(Carro carro) {
    this.carro = carro;

  }

   /* ***************************************************************
  * Metodo: getSleepTime
  * Funcao: ajustar o tempo do Thread slep para fluidez da animacao
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  private double getSleepTime() {
    // Defina os novos limites do slider e da taxa de FPS desejada
    int sliderMin = 1;
    int sliderMax = 5;
    int fpsMin = 25;
    int fpsMax = 35;

    // Pegue o valor do slider
    double sliderValue = carro.getSliderVelocidade().getValue();

    // Calcule o FPS correspondente ao valor do slider
    double fps = fpsMin + (sliderValue - sliderMin) * (fpsMax - fpsMin) / (sliderMax - sliderMin);

    // Calcule o tempo de sleep em milissegundos (1000 milissegundos em 1 segundo)
    return 1000.0 / fps;
  }


   /* ***************************************************************
  * Metodo: moveDireita
  * Funcao: executar a animacao da direita
  * Parametros: inteiro da distancia que sera andada
  * Retorno: void
  *************************************************************** */
  public void moveDireita(int distancia) {
      carro.pausar();
    int percurso = (int) (carro.getImagemCarro().getLayoutX() + distancia);
    while (carro.getImagemCarro().getLayoutX() < percurso) {
      
      Platform.runLater(() ->
        carro.getImagemCarro().setLayoutX(carro.getImagemCarro().getLayoutX() + 5));
      try {
        Carro.sleep((long) getSleepTime());
      } catch (Exception e) {
        // Handle exception
      }
    }
  }

   /* ***************************************************************
  * Metodo: moveEsquinaDireita
  * Funcao: executar a animacao da esquina direita
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void moveEsquinaDireita() {
    
    int percurso = (int) (carro.getImagemCarro().getLayoutX() + 45);
    while (carro.getImagemCarro().getLayoutX() < percurso) {
      Platform.runLater(() -> carro.getImagemCarro().setLayoutX(carro.getImagemCarro().getLayoutX() + 5));
      try {
        Carro.sleep((long) getSleepTime());
      } catch (Exception e) {
        // Handle exception
      }
    }
    carro.pausar();
  }

   /* ***************************************************************
  * Metodo: moveEsquerda
  * Funcao: executar a animacao da esquerda
  * Parametros: inteiro da distancia que sera andada
  * Retorno: void
  *************************************************************** */
  public void moveEsquerda(int distancia) {
    carro.pausar();
    int percurso = (int) (carro.getImagemCarro().getLayoutX() - distancia);
    while (carro.getImagemCarro().getLayoutX() > percurso) {
      Platform.runLater(() ->
        carro.getImagemCarro().setLayoutX(carro.getImagemCarro().getLayoutX() - 5));
      try {
        Carro.sleep((long) getSleepTime());
      } catch (Exception e) {
        // Handle exception
      }
    }
  }

   /* ***************************************************************
  * Metodo: moveEsquinaEsquerda
  * Funcao: executar a animacao da esquina esquerda
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void moveEsquinaEsquerda() {
    
    int percurso = (int) (carro.getImagemCarro().getLayoutX() - 45);
    while (carro.getImagemCarro().getLayoutX() > percurso) {
      Platform.runLater(() -> carro.getImagemCarro().setLayoutX(carro.getImagemCarro().getLayoutX() - 5));
      try {
        Carro.sleep((long) getSleepTime());
      } catch (Exception e) {
        // Handle exception
      }
    }
    carro.pausar();
  }

   /* ***************************************************************
  * Metodo: moveCima
  * Funcao: executar a animacao para cima
  * Parametros: inteiro da distancia que sera andada
  * Retorno: void
  *************************************************************** */
  public void moveCima(int distancia) {
    carro.pausar();
    int percurso = (int) (carro.getImagemCarro().getLayoutY() - distancia);
    while (carro.getImagemCarro().getLayoutY() > percurso) {
      Platform.runLater(() -> carro.getImagemCarro().setLayoutY(carro.getImagemCarro().getLayoutY() - 5));
      try {
        Carro.sleep((long) getSleepTime());
      } catch (Exception e) {
        // Handle exception
      }
    }
  }

     /* ***************************************************************
  * Metodo: esquinaCima
  * Funcao: executar a animacao para esquina cima
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void esquinaCima() {
    
    int percurso = (int) (carro.getImagemCarro().getLayoutY() - 35);
    while (carro.getImagemCarro().getLayoutY() > percurso) {
      Platform.runLater(() -> carro.getImagemCarro().setLayoutY(carro.getImagemCarro().getLayoutY() - 5));
      try {
        Carro.sleep((long) getSleepTime());
      } catch (Exception e) {
        // Handle exception
      }
    }
    carro.pausar();
  }

     /* ***************************************************************
  * Metodo: moveBaixo
  * Funcao: executar a animacao para baixo
  * Parametros: inteiro da distancia que sera andada
  * Retorno: void
  *************************************************************** */
  public void moveBaixo(int distancia) {
    carro.pausar();
    int percurso = (int) (carro.getImagemCarro().getLayoutY() + distancia);
    while (carro.getImagemCarro().getLayoutY() < percurso) {
      Platform.runLater(() -> carro.getImagemCarro().setLayoutY(carro.getImagemCarro().getLayoutY() + 5));
      try {
        Carro.sleep((long) getSleepTime());
      } catch (Exception e) {
        // Handle exception
      }
    }
  }

    /* ***************************************************************
  * Metodo: esquinaBaixo
  * Funcao: executar a animacao para esquina baixo
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void esquinaBaixo() {
    
    int percurso = (int) (carro.getImagemCarro().getLayoutY() + 35);
    while (carro.getImagemCarro().getLayoutY() < percurso) {
      Platform.runLater(() -> carro.getImagemCarro().setLayoutY(carro.getImagemCarro().getLayoutY() + 5));
      try {
        Carro.sleep((long) getSleepTime());
      } catch (Exception e) {
        // Handle exception
      }
    }
    carro.pausar();
  }

    /* ***************************************************************
  * Metodo: girarCima
  * Funcao: girar a imagem para a direcao de cima
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void girarCima() {
    Platform.runLater(() -> carro.getImagemCarro().setRotate(270));
  }

     /* ***************************************************************
  * Metodo: girarEsquerda
  * Funcao: girar a imagem para a direcao da esquerda
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void girarEsquerda() {
    Platform.runLater(() -> carro.getImagemCarro().setRotate(180));
  }

     /* ***************************************************************
  * Metodo: girarBaixo
  * Funcao: girar a imagem para a direcao de baixo
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void girarBaixo() {
    Platform.runLater(() -> carro.getImagemCarro().setRotate(90));
  }

     /* ***************************************************************
  * Metodo: girarDireita
  * Funcao: girar a imagem para a direcao da direita
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void girarDireita() {
    Platform.runLater(() -> carro.getImagemCarro().setRotate(0));
  }
}
