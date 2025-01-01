/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Matricula........: 202310445
* Inicio...........: 15/06/2024
* Ultima alteracao.: 03/07/2024
* Nome.............: Carro
* Funcao...........: criar o objeto que representara os carros com todas suas funcoes
*************************************************************** */
package model;

import controller.controllerTela;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class Carro extends Thread {
  private Slider sliderVelocidade;
  private ImageView imagemCarro;
  private AnimacaoCarro animacaoCarro;
  private int posicao;
  public boolean pausado = false;

 
  public void run(){
  
    
 while (true) {


    switch (posicao) {
      case 0:{
       try {
        trajeto5();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
        break;
      }
      case 1:{
        try {
          trajeto2();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
       break;
      }
      case 2:{
      try {
        trajeto8();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
     break;
      }
      case 3:{
        try {
          trajeto10();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        break;
      }
      case 4:{
        try {
          trajeto18();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        break;
      } 
      case 5:{
        try {
          trajeto15();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        break;
      }
      case 6:{
        try {
          trajeto21();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        break;
      }
      case 7:{
        try {
          trajeto22();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        break;
      }
        

      default:
        break;
    }
   
    try{  
      Thread.sleep(33);
   } catch(InterruptedException e){
   e.printStackTrace();
    } 
    
  }
}

  public Carro(ImageView imagem , Slider sliderVelocidade , int posicao ){
    this.imagemCarro = imagem;
    this.animacaoCarro = new AnimacaoCarro(this);
    this.sliderVelocidade = sliderVelocidade;
    this.posicao = posicao;
    switch (posicao) {
      case 0:{
         this.getImagemCarro().setLayoutX(-7); // posicao inicial x
         this.getImagemCarro().setLayoutY(392); // posicao inicial y
        break;
      }
      case 1:{
        this.getImagemCarro().setLayoutX(769); // posicao inicial x
        this.getImagemCarro().setLayoutY(381); // posicao inicial y
        break;
      }
      case 2:{
            this.getImagemCarro().setLayoutX(736);// posicao inicial x
          this.getImagemCarro().setLayoutY(75); // posicao inicial y 
          break;
      }
      case 3:{
        this.getImagemCarro().setLayoutX(740);
        this.getImagemCarro().setLayoutY(249);
        break;
      }
      case 4:{
          this.getImagemCarro().setLayoutX(579);
          this.getImagemCarro().setLayoutY(388);
          break;
      }
      case 5:{
        this.getImagemCarro().setLayoutX(413);
        this.getImagemCarro().setLayoutY(-6);
        break;
      }
      case 6:{
         this.getImagemCarro().setLayoutX(585);
        this.getImagemCarro().setLayoutY(149);
        break;
      }
      case 7:{
         this.getImagemCarro().setLayoutX(467);
        this.getImagemCarro().setLayoutY(322);
        break;
      }
        
        
    
      default:
        break;
    }
   
   
  }  

/* ***************************************************************
  * Metodo: trajeto5
  * Funcao: fazer os comandos de movimento do trajeto com seus respectivos semaforos
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void trajeto5() throws InterruptedException{ // ferrari
  
    animacaoCarro.moveDireita(120); // chega na  esquina 1x2
    controllerTela.zonaCritica1x2_1x5.acquire();
    animacaoCarro.moveEsquinaDireita();
    animacaoCarro.moveDireita(115); // chega na  esquina 1x3
    controllerTela.zonaCritica1x3_1x4.acquire();
    controllerTela.zonaCritica1x3_4x6.acquire();
    animacaoCarro.moveEsquinaDireita();
    controllerTela.zonaCritica1x1_1x3.release();
    animacaoCarro.moveDireita(105); // chega na  esquina 1x4
    controllerTela.zonaCritica1x4_1x6.acquire();
    animacaoCarro.moveEsquinaDireita();
    controllerTela.zonaCritica1x3_1x4.release();
    animacaoCarro.moveDireita(100); // chega na  esquina 1x5
    animacaoCarro.moveEsquinaDireita();
    controllerTela.zonaCritica1x2_1x5.release();
    animacaoCarro.moveDireita(110); // chega na  esquina 1x6
    controllerTela.zonaCritica1x6_3x6.acquire(); // zona critica menor mais a fora
    controllerTela.zonaCritica1x6_6x6.acquire(); // zona critica maior mais a dentro
    animacaoCarro.moveEsquinaDireita();
    controllerTela.zonaCritica1x1_1x6.release();
    controllerTela.zonaCritica1x4_1x6.release();
    animacaoCarro.girarCima();
    animacaoCarro.moveCima(55); // chega na  esquina 2x6
    controllerTela.zonaCritica2x6_5x6.acquire();
    animacaoCarro.esquinaCima();
    controllerTela.zonaCritica3x6_4x6.acquire(); // estendendo a zona critica para evitar deadlock
    animacaoCarro.moveCima(40); // chega na  esquina 3x6
    controllerTela.zonaCritica3x6_5x6.acquire();
    controllerTela.zonaCritica1x6_3x6.release();
    animacaoCarro.esquinaCima();
    animacaoCarro.moveCima(50); // chega na esquina  4x6
    animacaoCarro.esquinaCima();
    controllerTela.zonaCritica3x6_4x6.release();
    controllerTela.zonaCritica1x3_4x6.release();
    animacaoCarro.moveCima(45); // chega na  esquina 5x6
    animacaoCarro.esquinaCima();
    controllerTela.zonaCritica2x6_5x6.release();
    controllerTela.zonaCritica3x6_5x6.release();
    animacaoCarro.moveCima(64); // chega no topo  6 x 6
    controllerTela.zonaCritica6x6_6x1.acquire();
    animacaoCarro.girarEsquerda();
    controllerTela.zonaCritica1x6_6x6.release();
    animacaoCarro.moveEsquerda(150); // chega na esquina 6x5
    controllerTela.zonaCritica6x5_6x2.acquire();
    animacaoCarro.moveEsquinaEsquerda();
    animacaoCarro.moveEsquerda(110);  // chega na esquina 6x4
    controllerTela.zonaCritica6x4_6x3.acquire();
    controllerTela.zonaCritica6x4_6x1.acquire();
    animacaoCarro.moveEsquinaEsquerda();
    animacaoCarro.moveEsquerda(100);  // chega na esquina 6x3
    animacaoCarro.moveEsquinaEsquerda();
    controllerTela.zonaCritica6x4_6x3.release();
    animacaoCarro.moveEsquerda(105);  // chega na esquina 6x2
    animacaoCarro.moveEsquinaEsquerda();
    controllerTela.zonaCritica6x5_6x2.release();
    animacaoCarro.moveEsquerda(90);  // chega na esquina 6x1
    controllerTela.zonaCritica6x1_4x1.acquire(); // zona critica menor mais afora
    controllerTela.zonaCritica6x1_1x1.acquire();
    animacaoCarro.moveEsquinaEsquerda();
     controllerTela.zonaCritica6x4_6x1.release();
    controllerTela.zonaCritica6x6_6x1.release();
    animacaoCarro.girarBaixo();
    animacaoCarro.moveBaixo(65);// chega na esquina 5x1
    controllerTela.zonaCritica5x1_2x1.acquire();
    controllerTela.zonaCritica5x1_2x1FW.acquire();
    animacaoCarro.esquinaBaixo();
    animacaoCarro.moveBaixo(55); // chega na esquina 4x1
    controllerTela.zonaCritica4x1_3x1.acquire();
    animacaoCarro.esquinaBaixo();
    controllerTela.zonaCritica6x1_4x1.release();
    animacaoCarro.moveBaixo(50); // chega na esquina 3x1
    controllerTela.zonaCritica3x1_1x1.acquire();
    animacaoCarro.esquinaBaixo();
    controllerTela.zonaCritica5x1_2x1.release(); // deveria ser 3x1
    controllerTela.zonaCritica4x1_3x1.release();
    animacaoCarro.moveBaixo(40); // chega na esquina 2x1
    animacaoCarro.esquinaBaixo();
    controllerTela.zonaCritica5x1_2x1FW.release();
    animacaoCarro.moveBaixo(45); // chega na esquina 1x1
    controllerTela.zonaCritica1x1_1x6.acquire();
    controllerTela.zonaCritica3x1_1x1.release();
    animacaoCarro.girarDireita();
    controllerTela.zonaCritica1x1_1x3.acquire();
    controllerTela.zonaCritica6x1_1x1.release();
    this.getImagemCarro().setLayoutX(-7); // posicao inicial x
    this.getImagemCarro().setLayoutY(392); // posicao inicial y

}

/* ***************************************************************
  * Metodo: trajeto2
  * Funcao: fazer os comandos de movimento do trajeto com seus respectivos semaforos
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void trajeto2() throws InterruptedException{ // redBull
    this.getImagemCarro().setLayoutX(769); // posicao inicial x
    this.getImagemCarro().setLayoutY(381); // posicao inicial y
    animacaoCarro.moveCima(40); // chega na esquina 2x6
    controllerTela.zonaCritica2x6_5x6RW.acquire();
    animacaoCarro.esquinaCima();
    animacaoCarro.moveCima(30); // chega na esquina 3x6
    controllerTela.zonaCritica3x6_4x6RL.acquire();
    controllerTela.zonaCritica3x6_5x6RM.acquire();
    animacaoCarro.esquinaCima();
    controllerTela.zonaCritica1x6_3x6RA.release();
    animacaoCarro.moveCima(50); // chega na esquina 4x6
    animacaoCarro.esquinaCima();
    controllerTela.zonaCritica3x6_4x6RL.release();
    controllerTela.zonaCritica1x4_4x6.release(); // sai da zona critica pela esquina 4x6
    animacaoCarro.moveCima(50); // chega na esquina 5x6
    animacaoCarro.esquinaCima();
    controllerTela.zonaCritica2x6_5x6RW.release();
    controllerTela.zonaCritica3x6_5x6RM.release();
    animacaoCarro.moveCima(73); // chega na esquina 6x6
    animacaoCarro.girarEsquerda();
    controllerTela.zonaCritica6x6_6x1.acquire();
    controllerTela.zonaCritica1x6_6x6.release();
    animacaoCarro.moveEsquerda(150); // chega na esquina 6x5
    controllerTela.zonaCritica6x5_6x2RL.acquire();
    animacaoCarro.moveEsquinaEsquerda();
    animacaoCarro.moveEsquerda(110);  // chega na esquina 6x4
    controllerTela.zonaCritica6x4_6x3RW.acquire();
    controllerTela.zonaCritica6x4_6x1RH.acquire();
    animacaoCarro.moveEsquinaEsquerda();
    animacaoCarro.moveEsquerda(100);  // chega na esquina 6x3
    animacaoCarro.moveEsquinaEsquerda();
     controllerTela.zonaCritica6x4_6x3RW.release();
    animacaoCarro.moveEsquerda(105);  // chega na esquina 6x2
    animacaoCarro.moveEsquinaEsquerda();
    controllerTela.zonaCritica6x5_6x2RL.release();
    animacaoCarro.moveEsquerda(90);  // chega na esquina 6x1
    animacaoCarro.moveEsquinaEsquerda();
    controllerTela.zonaCritica6x1_3x1RH.acquire();
    controllerTela.zonaCritica6x4_6x1RH.release();
    controllerTela.zonaCritica6x1_1x1.acquire();
    controllerTela.zonaCritica6x6_6x1.release();
    animacaoCarro.girarBaixo();
    animacaoCarro.moveBaixo(65);// chega na esquina 5x1
    controllerTela.zonaCritica5x1_3x1RM.acquire();
    controllerTela.zonaCritica5x1_2x1RW.acquire();
    animacaoCarro.esquinaBaixo();
    animacaoCarro.moveBaixo(55); // chega na esquina 4x1
    controllerTela.zonaCritica4x1_3x1RL.acquire();
    animacaoCarro.esquinaBaixo();
    animacaoCarro.moveBaixo(50); // chega na esquina 3x1
    controllerTela.zonaCritica3x1_1x1RA.acquire();
    animacaoCarro.esquinaBaixo();
    controllerTela.zonaCritica4x1_3x1RL.release();
    controllerTela.zonaCritica6x1_3x1RH.release();
    controllerTela.zonaCritica5x1_3x1RM.release();
    animacaoCarro.moveBaixo(40); // chega na esquina 2x1
    animacaoCarro.esquinaBaixo();
    controllerTela.zonaCritica5x1_2x1RW.release();
    animacaoCarro.moveBaixo(45); // chega na esquina 1x1
    animacaoCarro.girarDireita();
     controllerTela.zonaCritica3x1_1x1RA.release();
    controllerTela.zonaCritica1x1_1x3RA.acquire();
    controllerTela.zonaCritica1x1_1x3.acquire();
    controllerTela.zonaCritica6x1_1x1.release();
    animacaoCarro.moveDireita(120); // chega na esquina 1x2
    controllerTela.zonaCritica1x2_1x3RL.acquire();
    animacaoCarro.moveEsquinaDireita();
    animacaoCarro.moveDireita(100); // chega na esquina 1x3
    controllerTela.zonaCritica2x3_1x3RW.acquire();
    controllerTela.zonaCritica1x3_4x4.acquire();
    animacaoCarro.moveEsquinaDireita();
    controllerTela.zonaCritica1x2_1x3RL.release();
    controllerTela.zonaCritica1x1_1x3RA.release();
    controllerTela.zonaCritica1x1_1x3.release();
    animacaoCarro.girarCima();
    animacaoCarro.moveCima(40); // chega na esquina 2x3
    animacaoCarro.esquinaCima();
    controllerTela.zonaCritica2x3_1x3RW.release();
    animacaoCarro.moveCima(40); // chega na esquina 3x3
    controllerTela.cruzamento3x3RH.acquire();
    controllerTela.cruzamento3x3RA.acquire();
    controllerTela.cruzamento3x3RM.acquire();
    animacaoCarro.esquinaCima();
    animacaoCarro.moveCima(40); // chega na esquina 4x3
    controllerTela.cruzamento3x3RH.release();
      controllerTela.cruzamento3x3RA.release();
    controllerTela.cruzamento3x3RM.release();
    animacaoCarro.esquinaCima();
    animacaoCarro.girarDireita();
    animacaoCarro.moveDireita(100); // chega na esquiuna 4x4
    controllerTela.zonaCritica4x4_3x4RH.acquire();
    animacaoCarro.moveEsquinaDireita();
    controllerTela.zonaCritica1x3_4x4.release();
    animacaoCarro.girarBaixo();
    animacaoCarro.moveBaixo(55); // chega na esquina 3x4
    controllerTela.cruzamento3x4RA.acquire();
    controllerTela.cruzamento3x4RM.acquire();
    
    animacaoCarro.esquinaBaixo();
    controllerTela.zonaCritica4x4_3x4RH.release();
    controllerTela.zonaCritica2x4_1x4RW.acquire(); // aumentei um pouco pq a animacao tava
    animacaoCarro.moveBaixo(50); // chega na esquina 2x4
    
    controllerTela.cruzamento3x4RA.release();
    controllerTela.cruzamento3x4RM.release();
    animacaoCarro.esquinaBaixo();
    controllerTela.zonaCritica1x4_4x6.acquire(); // entra na zona critica pela esquina 1x4
    animacaoCarro.moveBaixo(50); // chega na esquina 1x4
    controllerTela.zonaCritica1x4_1x5RL.acquire();
    controllerTela.zonaCritica1x4_1x6RA.acquire();
    controllerTela.zonaCritica1x4_1x6.acquire();
    controllerTela.zonaCritica2x4_1x4RW.release();
    animacaoCarro.girarDireita();
    animacaoCarro.moveDireita(115); // chega na esquina 1x5
    animacaoCarro.moveEsquinaDireita();
    controllerTela.zonaCritica1x4_1x5RL.release();
    animacaoCarro.moveDireita(115); // chega na esquina 1x6
    controllerTela.zonaCritica1x6_3x6RA.acquire();
    controllerTela.zonaCritica1x6_6x6.acquire();
    animacaoCarro.moveEsquinaDireita();
    controllerTela.zonaCritica1x4_1x6RA.release();
    controllerTela.zonaCritica1x4_1x6.release();
    animacaoCarro.girarCima();
}

/* ***************************************************************
  * Metodo: trajeto8
  * Funcao: fazer os comandos de movimento do trajeto com seus respectivos semaforos
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void trajeto8() throws InterruptedException{ // mercedes
  animacaoCarro.girarEsquerda();
  animacaoCarro.moveEsquerda(115); // chega na esquina 5x5
  controllerTela.cruzamento5x5ML.acquire();
  animacaoCarro.moveEsquinaEsquerda();
  controllerTela.cruzamento5x4MH.acquire();
  animacaoCarro.moveEsquerda(115); // chega na esquina 5x4
  controllerTela.cruzamento5x5ML.release();
  animacaoCarro.moveEsquinaEsquerda();
  controllerTela.zonaCritica5x6_5x4MW.release();
  controllerTela.cruzamento5x4MH.release();
  animacaoCarro.moveEsquerda(100); // chega na esquina 5x3
   controllerTela.zonaCritica5x3_5x1MW.acquire();
  animacaoCarro.moveEsquinaEsquerda();
  animacaoCarro.moveEsquerda(108); // chega na esquina 5x2
  controllerTela.cruzamento5x2ML.acquire();
  animacaoCarro.moveEsquinaEsquerda();
  animacaoCarro.moveEsquerda(87); // chega na esquina 5x1
  controllerTela.zonaCritica5x1_3x1MW.acquire();
  controllerTela.zonaCritica5x1_3x1MH.acquire();
  controllerTela.zonaCritica5x1_3x1RM.acquire();
  controllerTela.zonaCritica5x1_2x1.acquire();
  controllerTela.cruzamento5x2ML.release();
   controllerTela.zonaCritica5x3_5x1MW.release();
  animacaoCarro.moveEsquinaEsquerda();
  animacaoCarro.girarBaixo();
  animacaoCarro.moveBaixo(55); // chega na esquina 4x1
  controllerTela.zonaCritica4x1_3x1ML.acquire();
  animacaoCarro.esquinaBaixo();
  animacaoCarro.moveBaixo(50); // chega na esquina 3x1
  controllerTela.zonaCritica3x1_3x2ML.acquire();
  controllerTela.zonaCritica3x1_3x4MH.acquire();
  controllerTela.zonaCritica3x6_3x1MA.acquire();
  controllerTela.zonaCritica4x1_3x1ML.release();
  animacaoCarro.esquinaBaixo();
  controllerTela.zonaCritica5x1_3x1MW.release();
  controllerTela.zonaCritica5x1_3x1MH.release();
  controllerTela.zonaCritica5x1_2x1.release();
  controllerTela.zonaCritica5x1_3x1RM.release();
  animacaoCarro.girarDireita();
  animacaoCarro.moveDireita(120); // chega na esquina 3x2
  animacaoCarro.moveEsquinaDireita();
  controllerTela.zonaCritica3x1_3x2ML.release();
  animacaoCarro.moveDireita(120); // chega na esquina 3x3
  controllerTela.cruzamento3x3RM.acquire();
  controllerTela.cruzamento3x3AM.acquire();
  animacaoCarro.moveEsquinaDireita();
  controllerTela.cruzamento3x3AM.release();
  controllerTela.cruzamento3x3RM.release();
  animacaoCarro.moveDireita(100); // chega na esquina 3x4
  controllerTela.cruzamento3x4RM.acquire();
  animacaoCarro.moveEsquinaDireita();
  controllerTela.cruzamento3x4RM.release();
  controllerTela.zonaCritica3x1_3x4MH.release();
  animacaoCarro.moveDireita(110); // chega na esquina 3x5
  controllerTela.zonaCritica3x5_3x6ML.acquire();
  animacaoCarro.moveEsquinaDireita();
  animacaoCarro.moveDireita(110); // chega na esquina 3x6
  controllerTela.cruzamento4x6AM.acquire();
  controllerTela.zonaCritica3x6_5x6MW.acquire();
  controllerTela.zonaCritica3x6_4x6ML.acquire();
  controllerTela.zonaCritica3x6_5x6RM.acquire();
  controllerTela.zonaCritica3x6_5x6.acquire();
  animacaoCarro.moveEsquinaDireita();
  controllerTela.zonaCritica3x5_3x6ML.release();
  animacaoCarro.girarCima();
  animacaoCarro.moveCima(65); // chega na esquina 4x6
  controllerTela.zonaCritica3x6_3x1MA.release();
  animacaoCarro.esquinaCima();
  controllerTela.zonaCritica3x6_4x6ML.release();
  controllerTela.cruzamento4x6AM.release();
  animacaoCarro.moveCima(65); // chega na esquina 5x6
  controllerTela.zonaCritica5x6_5x4MW.acquire();
  controllerTela.zonaCritica3x6_5x6MW.release();
  controllerTela.zonaCritica3x6_5x6.release();
  controllerTela.zonaCritica3x6_5x6RM.release();
  animacaoCarro.girarEsquerda();
  this.getImagemCarro().setLayoutX(736);// posicao inicial x
  this.getImagemCarro().setLayoutY(75); // posicao inicial y

  
}
  
 public void trajeto10() throws InterruptedException{ // alipne
  animacaoCarro.girarEsquerda(); 
  getImagemCarro().setLayoutX(740);
  getImagemCarro().setLayoutY(249);
  animacaoCarro.girarEsquerda();
  animacaoCarro.moveEsquerda(115); // chega na esquina 3x5
  animacaoCarro.moveEsquinaEsquerda();
  controllerTela.zonaCritica3x5_3x6AL.release();
  animacaoCarro.moveEsquerda(115); // chega na esquina 3x4
  controllerTela.cruzamento3x4RA.acquire();
  controllerTela.zonaCritica3x1_3x4AH.acquire();
  animacaoCarro.moveEsquinaEsquerda();
   controllerTela.cruzamento3x4RA.release();
  animacaoCarro.moveEsquerda(100); // chega na esquina 3x3
  controllerTela.cruzamento3x3RA.acquire();
  controllerTela.cruzamento3x3AA.acquire();
  animacaoCarro.moveEsquinaEsquerda();
  controllerTela.cruzamento3x3AA.release();
  controllerTela.cruzamento3x3RA.release();
  animacaoCarro.moveEsquerda(108); // chega na esquina 3x2
  controllerTela.zonaCritica3x2_3x1AL.acquire();
  animacaoCarro.moveEsquinaEsquerda();
  animacaoCarro.moveEsquerda(83); // chega na esquina 3x1
  controllerTela.zonaCritica3x1_2x1AW.acquire();
  controllerTela.zonaCritica3x1_1x1RA.acquire();
  controllerTela.zonaCritica3x1_1x1.acquire();
  animacaoCarro.moveEsquinaEsquerda();
  controllerTela.zonaCritica3x2_3x1AL.release();
  controllerTela.zonaCritica3x1_3x4AH.release();
  controllerTela.zonaCritica3x6_3x1MA.release();
  animacaoCarro.girarBaixo();
  animacaoCarro.moveBaixo(55); // chega na esquina 2x1
  animacaoCarro.esquinaBaixo();
  controllerTela.zonaCritica3x1_2x1AW.release();
  animacaoCarro.moveBaixo(50); // chega na esquina 1x1
  controllerTela.zonaCritica1x1_1x3RA.acquire();
  controllerTela.zonaCritica1x1_1x6.acquire();
  controllerTela.zonaCritica3x1_1x1RA.release();
  controllerTela.zonaCritica3x1_1x1.release();
  animacaoCarro.girarDireita();
  animacaoCarro.moveDireita(120); // chega na esquina 1x2
  controllerTela.zonaCritica1x3_1x4AW.acquire(); // aumentei a zona critica para evitar deadlock
  controllerTela.zonaCritica1x2_1x5AL.acquire();
  animacaoCarro.moveEsquinaDireita();
  animacaoCarro.moveDireita(120); // chega na esquina 1x3
  
  controllerTela.zonaCritica1x3_3x6.acquire();
  animacaoCarro.moveEsquinaDireita();
  controllerTela.zonaCritica1x1_1x3RA.release();
  animacaoCarro.moveDireita(100); // chega na esquina 1x4
  controllerTela.zonaCritica1x4_1x6RA.acquire();
  animacaoCarro.moveEsquinaDireita();
  controllerTela.zonaCritica1x3_1x4AW.release();
  animacaoCarro.moveDireita(110); // chega na esquina 1x5
  animacaoCarro.moveEsquinaDireita();
  controllerTela.zonaCritica1x2_1x5AL.release();
  animacaoCarro.moveDireita(100); // chega na esquina 1x6
  controllerTela.zonaCritica1x6_3x6RA.acquire();
  controllerTela.zonaCritica1x6_3x6.acquire();
  animacaoCarro.moveEsquinaDireita();
  controllerTela.zonaCritica1x4_1x6RA.release();
  controllerTela.zonaCritica1x1_1x6.release();
  animacaoCarro.girarCima();
  animacaoCarro.moveCima(55); // chega na esquina 2x6
  controllerTela.zonaCritica2x6_3x6AW.acquire();
  animacaoCarro.esquinaCima();
  controllerTela.zonaCritica3x5_3x6AL.acquire();
  controllerTela.zonaCritica3x6_3x1MA.acquire();
  animacaoCarro.moveCima(50); // chega na esquina 3x6
  controllerTela.zonaCritica2x6_3x6AW.release();
  controllerTela.zonaCritica1x6_3x6RA.release();
  controllerTela.zonaCritica1x6_3x6.release(); 
  controllerTela.zonaCritica1x3_3x6.release();
  animacaoCarro.girarEsquerda(); 
  this.getImagemCarro().setLayoutX(740);
  this.getImagemCarro().setLayoutY(249);
}

/* ***************************************************************
  * Metodo: trajeto18
  * Funcao: fazer os comandos de movimento do trajeto com seus respectivos semaforos
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void trajeto18() throws InterruptedException{ // AstonMartin
    animacaoCarro.moveEsquerda(90); //chega na esquina 1x4
   // controllerTela.zonaCritica1x4_2x3.acquire();
    animacaoCarro.moveEsquinaEsquerda();
    controllerTela.zonaCritica1x4_4x6.release(); 
    animacaoCarro.moveEsquerda(100); //chega na esquina 1x3
    controllerTela.zonaCritica1x3_4x4.acquire();
    animacaoCarro.moveEsquinaEsquerda();
    controllerTela.zonaCritica1x3_3x6.release();
    controllerTela.zonaCritica1x3_4x6.release();
    controllerTela.zonaCricrita1x3_1x5.release(); 
    animacaoCarro.girarCima();
    animacaoCarro.moveCima(50); // chega na esquina 2x3
    animacaoCarro.esquinaCima();
    controllerTela.zonaCritica1x4_2x3.release();
    controllerTela.cruzamento3x3AA.acquire();
    controllerTela.cruzamento3x3AH.acquire();
    animacaoCarro.moveCima(50); // chega na esquina 3x3
    controllerTela.cruzamento3x3AM.acquire();
    animacaoCarro.esquinaCima();
     controllerTela.cruzamento3x3AA.release();
    controllerTela.cruzamento3x3AM.release();
    controllerTela.cruzamento3x3AH.release();
    animacaoCarro.moveCima(53); // chega na esquina 4x3
    animacaoCarro.girarDireita();
    animacaoCarro.moveDireita(110); // chega na esquina 4x4
    controllerTela.cruzamento4x4AH.acquire();
    animacaoCarro.moveEsquinaDireita();
    controllerTela.zonaCritica1x3_4x4.release();
    controllerTela.cruzamento4x4AH.release();
    animacaoCarro.moveDireita(110); // chega na esquina 4x5
    controllerTela.zonaCricrita3x6_4x5.acquire();
    animacaoCarro.moveEsquinaDireita();
    animacaoCarro.moveDireita(115); // chega na esquina 4x6
    controllerTela.zonaCritica1x4_2x3.acquire(); // estendendo a zona critica para evitar deadlock
    controllerTela.zonaCritica1x3_3x6.acquire();// tive que aumentar a zona critica para evitar deadlock
    controllerTela.cruzamento4x6AM.acquire();
    controllerTela.zonaCritica2x6_4x6.acquire();
    controllerTela.zonaCritica1x3_4x6.acquire();
    controllerTela.zonaCritica1x4_4x6.acquire(); 
    animacaoCarro.moveEsquinaDireita();
    animacaoCarro.girarBaixo();
    animacaoCarro.moveBaixo(55); // chega na esquina 3x6
    animacaoCarro.esquinaBaixo();
    controllerTela.zonaCricrita3x6_4x5.release();
    controllerTela.cruzamento4x6AM.release();
    animacaoCarro.moveBaixo(55); // chega na esquina 2x6
    controllerTela.zonaCritica2x6_4x6.release();
    animacaoCarro.esquinaBaixo();
    animacaoCarro.moveBaixo(43); // chega na esquina 1x6
    animacaoCarro.girarEsquerda();
    animacaoCarro.moveEsquerda(135); // chega na esquina 1x5
    controllerTela.zonaCricrita1x3_1x5.acquire();
    animacaoCarro.moveEsquinaEsquerda();
     this.getImagemCarro().setLayoutX(579);
     this.getImagemCarro().setLayoutY(388);
 
  }
   
   /* ***************************************************************
  * Metodo: trajeto15
  * Funcao: fazer os comandos de movimento do trajeto com seus respectivos semaforos
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void trajeto15() throws InterruptedException{ // HASS
    animacaoCarro.moveEsquerda(100); // chega na esquina 6x3
    animacaoCarro.moveEsquinaEsquerda();
    controllerTela.zonaCritica6x4_6x3HW.release();
    animacaoCarro.moveEsquerda(100); // chega na esquina 6x2
    animacaoCarro.moveEsquinaEsquerda();
    controllerTela.zonaCritica6x4_6x2HL.release();
    animacaoCarro.moveEsquerda(90); // chega na esquina 6x1
    animacaoCarro.moveEsquinaEsquerda();
    controllerTela.zonaCritica6x4_6x1RH.release();
    controllerTela.zonaCritica6x4_6x1.release();
    controllerTela.zonaCritica6x1_3x1RH.acquire();
    controllerTela.zonaCritica6x1_4x1.acquire();
    getImagemCarro().setRotate(270); // a imagem do carro nao esta no padrao das outras entao o rotade nao pode ser generico
    animacaoCarro.moveBaixo(65); // chega na esquina 5x1
    controllerTela.zonaCritica5x1_3x1HW.acquire();
    controllerTela.zonaCritica5x1_3x1MH.acquire();
    animacaoCarro.esquinaBaixo();
    animacaoCarro.moveBaixo(50); // chega na esquina 4x1
    controllerTela.zonaCritica4x1_3x1HL.acquire();
    animacaoCarro.esquinaBaixo();
    controllerTela.zonaCritica6x1_4x1.release();
    animacaoCarro.moveBaixo(40); // chega na esquina 3x1
    controllerTela.zonaCritica3x1_3x2HL.acquire();
    controllerTela.zonaCritica3x1_3x4AH.acquire();
    animacaoCarro.esquinaBaixo();
    controllerTela.zonaCritica5x1_3x1HW.release();
    controllerTela.zonaCritica4x1_3x1HL.release();
    controllerTela.zonaCritica5x1_3x1MH.release();
    controllerTela.zonaCritica6x1_3x1RH.release();
    getImagemCarro().setRotate(180);
    controllerTela.zonaCritica3x1_3x4MH.acquire();
    animacaoCarro.moveDireita(120); // chega na esquina 3x2
    animacaoCarro.moveEsquinaDireita();
    controllerTela.zonaCritica3x1_3x2HL.release();
    animacaoCarro.moveDireita(110); // chega na esquina 3x3
    controllerTela.cruzamento3x3RH.acquire();
    controllerTela.cruzamento3x3AH.acquire();
    animacaoCarro.moveEsquinaDireita();
    animacaoCarro.moveDireita(90); // chega na esquina 3x4
    controllerTela.zonaCritica4x4_3x4RH.acquire();
    controllerTela.cruzamento3x3RH.release();
    controllerTela.cruzamento3x3AH.release();
    animacaoCarro.moveEsquinaDireita();
    getImagemCarro().setRotate(90);
    animacaoCarro.moveCima(55); // chega na esquina 4x4
    controllerTela.zonaCritica3x1_3x4AH.release();
    controllerTela.zonaCritica3x1_3x4MH.release();
    controllerTela.cruzamento4x4AH.acquire();
    animacaoCarro.esquinaCima();
    controllerTela.zonaCritica4x4_3x4RH.release();
    controllerTela.cruzamento4x4AH.release();
    animacaoCarro.moveCima(55); // chega na esquina 5x4
    controllerTela.cruzamento5x4MH.acquire();
    controllerTela.zonaCritica5x4_6x4HW.acquire();
    animacaoCarro.esquinaCima();
    animacaoCarro.moveCima(45); // chega na esquina 6x4
    controllerTela.zonaCritica6x4_6x3HW.acquire();
    controllerTela.zonaCritica6x4_6x2HL.acquire();
    controllerTela.cruzamento5x4MH.release();
    controllerTela.zonaCritica6x4_6x1RH.acquire();
    controllerTela.zonaCritica6x4_6x1.acquire();
    animacaoCarro.esquinaCima();
    getImagemCarro().setRotate(0);
    controllerTela.zonaCritica5x4_6x4HW.release();
   animacaoCarro.moveEsquerda(30);
   this.getImagemCarro().setLayoutX(413);
    this.getImagemCarro().setLayoutY(-6);
        
}
  
  /* ***************************************************************
  * Metodo: trajeto21
  * Funcao: fazer os comandos de movimento do trajeto com seus respectivos semaforos
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void trajeto21() throws InterruptedException{ // mcLaren
    animacaoCarro.moveCima(50); // chega na esquina 5x5
    controllerTela.cruzamento5x5LW.acquire();
    controllerTela.cruzamento5x5ML.acquire();
    animacaoCarro.esquinaCima();  
    animacaoCarro.moveCima(40); // chega na esquina 6x5
    controllerTela.cruzamento5x5LW.release();
    controllerTela.cruzamento5x5ML.release();
    controllerTela.zonaCritica6x5_6x2RL.acquire();
    controllerTela.zonaCritica6x5_6x2.acquire();
    animacaoCarro.esquinaCima();
    animacaoCarro.girarEsquerda();
    animacaoCarro.moveEsquerda(115); // chega na esquina 6x4
    controllerTela.zonaCritica6x4_6x3LW.acquire();
    controllerTela.zonaCritica6x4_6x2HL.acquire();
    animacaoCarro.moveEsquinaEsquerda();
    animacaoCarro.moveEsquerda(110); // chega na esquina 6x3
    animacaoCarro.moveEsquinaEsquerda();
     controllerTela.zonaCritica6x4_6x3LW.release();
    animacaoCarro.moveEsquerda(95); // chega na esquina 6x2
    animacaoCarro.moveEsquinaEsquerda();
    controllerTela.zonaCritica6x4_6x2HL.release();
    controllerTela.zonaCritica6x5_6x2RL.release();
    controllerTela.zonaCritica6x5_6x2.release();
    animacaoCarro.girarBaixo();
    animacaoCarro.moveBaixo(55); // chega na esquina 5x2.
    controllerTela.cruzamento5x2LW.acquire();
    controllerTela.cruzamento5x2ML.acquire();
    animacaoCarro.esquinaBaixo();
    animacaoCarro.moveBaixo(50); // chega na esquina 4x2.
     controllerTela.cruzamento5x2LW.release();
    controllerTela.cruzamento5x2ML.release();
    animacaoCarro.esquinaBaixo();
    animacaoCarro.girarEsquerda();
    animacaoCarro.moveEsquerda(103); // chega na esquina 4x1
    controllerTela.zonaCritica4x1_3x1LW.acquire();
    controllerTela.zonaCritica4x1_3x1HL.acquire();
    controllerTela.zonaCritica4x1_3x1ML.acquire();
    controllerTela.zonaCritica4x1_3x1RL.acquire();
    controllerTela.zonaCritica4x1_3x1.acquire();
    animacaoCarro.moveEsquinaEsquerda();
    animacaoCarro.girarBaixo();
    animacaoCarro.moveBaixo(50); // chega na esquina 3x1
    animacaoCarro.esquinaBaixo();
    controllerTela.zonaCritica4x1_3x1LW.release(); 
    controllerTela.zonaCritica4x1_3x1HL.release();
    controllerTela.zonaCritica4x1_3x1ML.release();
    controllerTela.zonaCritica4x1_3x1RL.release();
    controllerTela.zonaCritica4x1_3x1.release();
    controllerTela.zonaCritica3x1_3x2ML.acquire();
    controllerTela.zonaCritica3x2_3x1AL.acquire();
    controllerTela.zonaCritica3x1_3x2HL.acquire();
    animacaoCarro.girarDireita();
    animacaoCarro.moveDireita(105); // chega na esquina 3x2
    animacaoCarro.moveEsquinaDireita();
    controllerTela.zonaCritica3x1_3x2HL.release();
    controllerTela.zonaCritica3x2_3x1AL.release();
    controllerTela.zonaCritica3x1_3x2ML.release();
    animacaoCarro.girarBaixo();
    animacaoCarro.moveBaixo(45); // chega na esqina 2x2
    controllerTela.cruzamento2x2LW.acquire();
    animacaoCarro.esquinaBaixo();
    animacaoCarro.moveBaixo(25); // chega na esqina 1x2
    controllerTela.cruzamento2x2LW.release();
    controllerTela.zonaCritica1x2_1x5AL.acquire();
    controllerTela.zonaCritica1x2_1x3RL.acquire();
    controllerTela.zonaCritica1x2_1x5.acquire();
    animacaoCarro.esquinaBaixo();
    animacaoCarro.girarDireita();
    animacaoCarro.moveDireita(120); // chega na esquina 1x3
    controllerTela.zonaCritica1x3_1x4LW.acquire();
    controllerTela.zonaCricrita1x3_1x5.acquire();
    animacaoCarro.moveEsquinaDireita();
    controllerTela.zonaCritica1x2_1x3RL.release();
    animacaoCarro.moveDireita(115); // chega na esquina 1x4
    controllerTela.zonaCritica1x4_1x5RL.acquire();
    controllerTela.zonaCritica1x3_1x4LW.release();
    animacaoCarro.moveEsquinaDireita();
    animacaoCarro.moveDireita(100); // chega na esquina 1x5
   animacaoCarro.moveDireita(27); // substituir o movi esquina pois ta indo muito longe
   controllerTela.zonaCritica1x2_1x5AL.release();
   controllerTela.zonaCritica1x4_1x5RL.release();
   controllerTela.zonaCritica1x2_1x5.release();
   controllerTela.zonaCricrita1x3_1x5.release();
   animacaoCarro.girarCima();
   animacaoCarro.moveCima(50); // chega na esquina 2x5
   controllerTela.cruzamento2x5LW.acquire();
   animacaoCarro.esquinaCima();
   animacaoCarro.moveCima(23); // chega na esquina 3x5
   controllerTela.cruzamento2x5LW.release();
   controllerTela.zonaCritica3x5_3x6AL.acquire();
   controllerTela.zonaCritica3x5_3x6ML.acquire();
   animacaoCarro.esquinaCima();
   controllerTela.zonaCricrita3x6_4x5.acquire(); // estendendo a zona critica para evitar deadLock
   animacaoCarro.girarDireita();
   animacaoCarro.moveDireita(128); // chega na esquina 3x6
   
   controllerTela.zonaCritica3x6_4x6LW.acquire();
   controllerTela.zonaCritica3x6_4x6ML.acquire();
   controllerTela.zonaCritica3x6_4x6RL.acquire();
   controllerTela.zonaCritica3x6_4x6.acquire();
   controllerTela.zonaCritica3x5_3x6AL.release();
   animacaoCarro.moveEsquinaDireita();
   controllerTela.zonaCritica3x5_3x6ML.release();
   animacaoCarro.girarCima();
   animacaoCarro.moveCima(45); // chega na esquina 4x6
   animacaoCarro.esquinaCima();
   controllerTela.zonaCritica3x6_4x6LW.release();
   controllerTela.zonaCritica3x6_4x6ML.release();
   controllerTela.zonaCritica3x6_4x6.release();
   controllerTela.zonaCritica3x6_4x6RL.release();
   animacaoCarro.girarEsquerda();
   animacaoCarro.moveEsquerda(125); // chega na esquina 4x5
   animacaoCarro.moveEsquinaEsquerda();
   controllerTela.zonaCricrita3x6_4x5.release();
   animacaoCarro.girarCima();
   animacaoCarro.moveCima(5);
    this.getImagemCarro().setLayoutX(585);
    this.getImagemCarro().setLayoutY(149);
  
  }
 
  /* ***************************************************************
  * Metodo: trajeto22
  * Funcao: fazer os comandos de movimento do trajeto com seus respectivos semaforos
  * Parametros: void
  * Retorno: void
  *************************************************************** */
 public void trajeto22() throws InterruptedException{ // willians
  animacaoCarro.moveDireita(100); // chega na esquina 2x5
  controllerTela.cruzamento2x5LW.acquire();
  animacaoCarro.moveEsquinaDireita();
  controllerTela.cruzamento2x5LW.release();
  animacaoCarro.moveDireita(113); // chega na esquina 2x6
  controllerTela.zonaCritica2x6_3x6AW.acquire();
  controllerTela.zonaCritica2x6_4x6.acquire();
  controllerTela.zonaCritica2x6_5x6RW.acquire();
  controllerTela.zonaCritica2x6_5x6.acquire();
  animacaoCarro.moveEsquinaDireita();
  getImagemCarro().setRotate(90); // girar esquerda (a imagem não esta padrao)
  animacaoCarro.moveCima(50); // chega na esquina 3x6
  controllerTela.zonaCritica3x6_4x6LW.acquire();
  controllerTela.zonaCritica3x6_5x6MW.acquire();
  controllerTela.zonaCritica2x6_3x6AW.release();
  animacaoCarro.esquinaCima();
  animacaoCarro.moveCima(50); // chega na esquina 4x6
  animacaoCarro.esquinaCima();
  controllerTela.zonaCritica2x6_4x6.release();
  controllerTela.zonaCritica3x6_4x6LW.release();
  animacaoCarro.moveCima(40); // chega na esquina 5x6
  controllerTela.zonaCritica5x6_5x4MW.acquire();
  animacaoCarro.esquinaCima();
  controllerTela.zonaCritica3x6_5x6MW.release();
  controllerTela.zonaCritica2x6_5x6RW.release();
  controllerTela.zonaCritica2x6_5x6.release();
  getImagemCarro().setRotate(0); // girar cima (a imagem não esta padrao)
  animacaoCarro.moveEsquerda(140); // chega na esquina 5x5
  controllerTela.cruzamento5x5LW.acquire();
  animacaoCarro.moveEsquinaEsquerda();
  controllerTela.cruzamento5x5LW.release();
  animacaoCarro.moveEsquerda(100); // chega na esquina 5x4
  controllerTela.zonaCritica5x4_6x4HW.acquire();
  animacaoCarro.moveEsquinaEsquerda();
  controllerTela.zonaCritica5x6_5x4MW.release();
  getImagemCarro().setRotate(90); // girar esquerda (a imagem não esta padrao)
  animacaoCarro.moveCima(45); // chega na esquina 6x4
  controllerTela.zonaCritica6x4_6x3LW.acquire();
  controllerTela.zonaCritica6x4_6x3HW.acquire();
  controllerTela.zonaCritica6x4_6x3RW.acquire();
  controllerTela.zonaCritica6x4_6x3.acquire();
  animacaoCarro.esquinaCima();
  getImagemCarro().setRotate(0); // girar esquerda (a imagem não esta padrao)
  controllerTela.zonaCritica5x4_6x4HW.release();
  animacaoCarro.moveEsquerda(100); // chega na esquina 6x3
  animacaoCarro.moveEsquinaEsquerda();
   controllerTela.zonaCritica6x4_6x3LW.release();
  controllerTela.zonaCritica6x4_6x3HW.release();
   controllerTela.zonaCritica6x4_6x3RW.release();
  controllerTela.zonaCritica6x4_6x3.release();
  getImagemCarro().setRotate(270); // girar baixo (a imagem não esta padrao)
  animacaoCarro.moveBaixo(47); // chega na esquina 5x3
  controllerTela.zonaCritica5x3_5x1MW.acquire();
  animacaoCarro.esquinaBaixo();
  getImagemCarro().setRotate(0); // girar esquerda (a imagem não esta padrao)
  animacaoCarro.moveEsquerda(115); // chega na esqiuna 5x2
   controllerTela.cruzamento5x2LW.acquire();
  animacaoCarro.moveEsquinaEsquerda();
   controllerTela.cruzamento5x2LW.release();
  animacaoCarro.moveEsquerda(105); // chega na esqiuna 5x1
  controllerTela.zonaCritica5x1_3x1HW.acquire();
  controllerTela.zonaCritica5x1_3x1MW.acquire();
  controllerTela.zonaCritica5x1_2x1RW.acquire();
  controllerTela.zonaCritica5x1_2x1FW.acquire();
  animacaoCarro.moveEsquinaEsquerda();
   controllerTela.zonaCritica5x3_5x1MW.release();
  getImagemCarro().setRotate(270); // girar baixo (a imagem não esta padrao)
  animacaoCarro.moveBaixo(50); // chega na esquina 4x1
  controllerTela.zonaCritica4x1_3x1LW.acquire();
  animacaoCarro.esquinaBaixo();
  animacaoCarro.moveBaixo(50); // chega na esquina 3x1
  controllerTela.zonaCritica3x1_2x1AW.acquire();
  animacaoCarro.esquinaBaixo();
  controllerTela.zonaCritica4x1_3x1LW.release();
  controllerTela.zonaCritica5x1_3x1HW.release();
  controllerTela.zonaCritica5x1_3x1MW.release();
  animacaoCarro.moveBaixo(35); // chega na esquina 2x1
  animacaoCarro.esquinaBaixo();
  controllerTela.zonaCritica3x1_2x1AW.release();
  controllerTela.zonaCritica5x1_2x1RW.release();
  controllerTela.zonaCritica5x1_2x1FW.release();
  getImagemCarro().setRotate(180); // girar direita (a imagem não esta padrao)
  animacaoCarro.moveDireita(115); // chega na esquina 2x2
  controllerTela.cruzamento2x2LW.acquire();
  animacaoCarro.moveEsquinaDireita();
  controllerTela.cruzamento2x2LW.release();
  animacaoCarro.moveDireita(110); // chega na esquina 2x3
  controllerTela.zonaCritica2x3_1x3RW.acquire();
  controllerTela.zonaCritica1x4_2x3.acquire(); // aumentei a zona critica para evitar deadlock
  
  animacaoCarro.moveEsquinaDireita();
  getImagemCarro().setRotate(270); // gira para baixo
  animacaoCarro.moveBaixo(35); // chega na esquina 1x3
  controllerTela.zonaCritica1x3_1x4.acquire();
  controllerTela.zonaCritica1x3_1x4AW.acquire();
  controllerTela.zonaCritica1x3_1x4LW.acquire();
  
  animacaoCarro.esquinaBaixo();
  controllerTela.zonaCritica2x3_1x3RW.release();
  getImagemCarro().setRotate(180); // girar direita (a imagem não esta padrao)
  animacaoCarro.moveDireita(100); // chega na esquina 1x4
  controllerTela.zonaCritica2x4_1x4RW.acquire();
  animacaoCarro.moveEsquinaDireita(); 
  controllerTela.zonaCritica1x3_1x4LW.release();
  controllerTela.zonaCritica1x3_1x4AW.release();
  controllerTela.zonaCritica1x3_1x4.release();
  getImagemCarro().setRotate(90); // girar cima (a imagem não esta padrao)
  controllerTela.zonaCritica1x4_2x3.release();
  animacaoCarro.moveCima(37); // chega na esquina 2x4
  animacaoCarro.esquinaCima();
  controllerTela.zonaCritica2x4_1x4RW.release();
  getImagemCarro().setRotate(180); // girar direita (a imagem não esta padrao)
  animacaoCarro.moveDireita(20);
  this.getImagemCarro().setLayoutX(467);
  this.getImagemCarro().setLayoutY(322);
  
 }

  /* ***************************************************************
  * Metodo: getImagemCarro
  * Funcao: retornar imagem do carro
  * Parametros: void
  * Retorno: void
  *************************************************************** */
 public ImageView getImagemCarro() {
    return imagemCarro;
  }

  /* ***************************************************************
  * Metodo: getSliderelocidade
  * Funcao: retornar valor atual do slider
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public Slider getSliderVelocidade() {
    return sliderVelocidade;
  }

    /* ***************************************************************
  * Metodo:serSliderVelocidade
  * Funcao: definir uma velocidade no slider
  * Parametros:  Slider
  * Retorno: void
  *************************************************************** */
  public void setSliderVelocidade(Slider sliderVelocidade) {
    this.sliderVelocidade = sliderVelocidade;
  }

    /* ***************************************************************
  * Metodo: pausar
  * Funcao: colocar o carro para dormir infinitamente enquanto estiver pausado
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
   public void pausar(){
    while (pausado){
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      if(!pausado){
        break;
      }
    }
  }
  
}
