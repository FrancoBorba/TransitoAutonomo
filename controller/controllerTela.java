/* ***************************************************************
* Autor............: Franco Ribeiro Borba
* Matricula........: 202310445
* Inicio...........: 16/06/2024
* Ultima alteracao.: 02/07/2024
* Nome.............: controllerTela
* Funcao...........: Controllar as interações e imagens que estao na GUI
*************************************************************** */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Carro;

public class controllerTela implements Initializable {
  // imagem dos carros
  @FXML
  private ImageView ferrari , redbull , mercedes , alpine ,astonMartin ,hass , mclaren , willians;

  // declara os sliders dos carros
  @FXML
  private Slider ferrariSlider , redBullSlider , mercedesSlider , alpineSlider ,astonMartinSlider , hassSlider , mclarenSlider , williansSlider;

  // declara as imagens dos trajetos
  @FXML
  private ImageView trajeto2 ,trajeto5 , trajeto8 , trajeto10 , trajeto15, trajeto18 , trajeto21 , trajeto22;

  // declara os carros
  private Carro ferrariCarro , redBullCarro , mercedesCarro , alpineCarro , astonMarinCarro , hassCarro , mclarenCarro , williansCarro;


  // semaforos para AstonMartin e Mercedes
  public static Semaphore cruzamento3x3AM ;
  public static  Semaphore cruzamento4x6AM; 

  // Semaforos para AstonMartin e Hass

   public static Semaphore cruzamento3x3AH; 
  public static  Semaphore cruzamento4x4AH; 

  // Semaforos para AstonMarint e RedBull
  public static Semaphore zonaCritica1x3_4x4;
  public static Semaphore zonaCritica1x4_4x6;

  // Semaforos para AstonMartin e mcLaren
  public static Semaphore zonaCricrita1x3_1x5;
  public static Semaphore zonaCricrita3x6_4x5;

  // Semaforos para AstonMartin e Ferrari
   public static Semaphore zonaCritica1x3_4x6;

  // Semaforos para AstonMartin e Alpine
    public static Semaphore zonaCritica1x3_3x6;
    public static Semaphore cruzamento3x3AA;

  // Semaforos para AstonMartin e Willians
  public static Semaphore zonaCritica2x6_4x6;
  public static Semaphore zonaCritica1x4_2x3;

  // Semaforos para Ferrari e Redbull( subdivir a zonas critica em zonas criticas menores)
  public static Semaphore zonaCritica1x6_6x6;
  public static Semaphore zonaCritica6x6_6x1;
  public static Semaphore zonaCritica6x1_1x1;
  public static Semaphore zonaCritica1x1_1x3;
  public static Semaphore zonaCritica1x4_1x6;

  // Semaforos para Ferrari e Mercedes
  public static Semaphore zonaCritica3x6_5x6;
  public static Semaphore zonaCritica5x1_2x1;

  // Semaforos para Ferrari e Alpine
  public static Semaphore zonaCritica3x1_1x1;
  public static Semaphore zonaCritica1x1_1x6;
  public static Semaphore zonaCritica1x6_3x6;

  // Semaforos entre Ferrari e Hass
  public static Semaphore zonaCritica6x4_6x1;
  public static Semaphore zonaCritica6x1_4x1;

  // Semaforos entre Ferrari e McLaren
  public static Semaphore zonaCritica3x6_4x6;
  public static Semaphore zonaCritica6x5_6x2;
  public static Semaphore zonaCritica4x1_3x1;
  public static Semaphore zonaCritica1x2_1x5;

  //Semaforos entre Ferrari e Willians
  public static Semaphore zonaCritica2x6_5x6;
  public static Semaphore zonaCritica6x4_6x3;
  public static Semaphore zonaCritica5x1_2x1FW;
  public static Semaphore zonaCritica1x3_1x4;
  
  // Semaforos entre Redbull e Mercedes
  public static Semaphore cruzamento3x3RM;
  public static Semaphore cruzamento3x4RM;
  public static Semaphore zonaCritica5x1_3x1RM;
  public static Semaphore zonaCritica3x6_5x6RM;

   // Semaforos entre RedBull e Alpine
  public static Semaphore cruzamento3x3RA;
  public static Semaphore cruzamento3x4RA;
  public static Semaphore zonaCritica3x1_1x1RA;
  public static Semaphore zonaCritica1x1_1x3RA;
  public static Semaphore zonaCritica1x4_1x6RA;
  public static Semaphore zonaCritica1x6_3x6RA;

   //Semaforos entre RedBull e Hass
   public static Semaphore cruzamento3x3RH;
   public static Semaphore zonaCritica4x4_3x4RH;
   public static Semaphore zonaCritica6x4_6x1RH;
   public static Semaphore zonaCritica6x1_3x1RH;

   //Semaforos entre RedBull e McLaren
   public static Semaphore zonaCritica6x5_6x2RL;
   public static Semaphore zonaCritica4x1_3x1RL;
   public static Semaphore zonaCritica1x2_1x3RL;
   public static Semaphore zonaCritica1x4_1x5RL;
   public static Semaphore zonaCritica3x6_4x6RL;

  // Semaforos entre RedBull e Willians
  public static Semaphore zonaCritica2x6_5x6RW;
  public static Semaphore zonaCritica6x4_6x3RW;
  public static Semaphore zonaCritica5x1_2x1RW;
  public static Semaphore zonaCritica2x3_1x3RW;
  public static Semaphore zonaCritica2x4_1x4RW;
 
  // Semaforos entre Mercedes e Alpine
  public static Semaphore zonaCritica3x6_3x1MA;

  // Semaforos entre Mercedes e Hass
  public static Semaphore cruzamento5x4MH;
  public static Semaphore zonaCritica5x1_3x1MH;
  public static Semaphore zonaCritica3x1_3x4MH;  

  // Semaforos entre Mercedes e McLaren
  public static Semaphore cruzamento5x5ML;
  public static Semaphore cruzamento5x2ML;
  public static Semaphore zonaCritica3x5_3x6ML;
  public static Semaphore zonaCritica3x6_4x6ML;
  public static Semaphore zonaCritica4x1_3x1ML;
  public static Semaphore zonaCritica3x1_3x2ML;

  // Semaforos entre Mercedes e Willians
  public static Semaphore zonaCritica3x6_5x6MW;
  public static Semaphore zonaCritica5x6_5x4MW;
  public static Semaphore zonaCritica5x3_5x1MW;
  public static Semaphore zonaCritica5x1_3x1MW;

  // Semaforos entre Alpine e Hass 
  public static Semaphore zonaCritica3x1_3x4AH;

  // Semaforos entre Alpine e Mclaren
  public static Semaphore zonaCritica3x2_3x1AL;
  public static Semaphore zonaCritica1x2_1x5AL;
  public static Semaphore zonaCritica3x5_3x6AL;

  // Semaforos entre Alpine e Willians
  public static Semaphore zonaCritica2x6_3x6AW;
  public static Semaphore zonaCritica3x1_2x1AW;
  public static Semaphore zonaCritica1x3_1x4AW;

  // Semaforos entre Hass e Mclaren
  public static Semaphore zonaCritica6x4_6x2HL;
  public static Semaphore zonaCritica4x1_3x1HL;
  public static Semaphore zonaCritica3x1_3x2HL;

  // Semaforos entre Hass e Willians
  public static Semaphore zonaCritica6x4_6x3HW;
  public static Semaphore zonaCritica5x1_3x1HW;
  public static Semaphore zonaCritica5x4_6x4HW;


  // Semaforos entre Mclaren e Willians
  public static Semaphore cruzamento2x5LW;
  public static Semaphore cruzamento5x5LW;
  public static Semaphore cruzamento5x2LW;
  public static Semaphore cruzamento2x2LW;
  public static Semaphore zonaCritica6x4_6x3LW;
  public static Semaphore zonaCritica4x1_3x1LW;
  public static Semaphore zonaCritica1x3_1x4LW;
  public static Semaphore zonaCritica3x6_4x6LW;
  


  @Override
  public void initialize(URL location, ResourceBundle resources) {
   inicializarSemaforos(); // inicializa os semaforos
   // cria os carros
    ferrariCarro = new Carro(ferrari ,ferrariSlider , 0);
    redBullCarro = new Carro(redbull, redBullSlider, 1);
   mercedesCarro = new Carro(mercedes, mercedesSlider, 2 );
   alpineCarro = new Carro(alpine , alpineSlider , 3);
    astonMarinCarro = new Carro(astonMartin, astonMartinSlider, 4);
   hassCarro = new Carro(hass, hassSlider, 5);
   mclarenCarro = new Carro(mclaren, mclarenSlider, 6);
   williansCarro = new Carro(willians, williansSlider, 7);

  // inicializa as Thread
  ferrariCarro.start();
  redBullCarro.start();
  mercedesCarro.start();
  alpineCarro.start();
  astonMarinCarro.start();
  hassCarro.start();
  mclarenCarro.start();
  williansCarro.start();
  }

    /* ***************************************************************
  * Metodo: aparecerTrajeto5
  * Funcao: aparecer o trajeto na tela do percurso especifico
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
  public void aparecerTrajeto5(MouseEvent event){
    if(trajeto5.isVisible() == true){
      trajeto5.setVisible(false);
    } else{
      trajeto5.setVisible(true);
    }
  }
    /* ***************************************************************
  * Metodo: aparecerTrajeto2
  * Funcao: aparecer o trajeto na tela do percurso especifico
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
  public void aparecerTrajeto2(MouseEvent event){
    if(trajeto2.isVisible() == true){
      trajeto2.setVisible(false);
    } else{
      trajeto2.setVisible(true);
    }
  }
    /* *************************************************************
  * Metodo: aparecerTrajeto8
  * Funcao: aparecer o trajeto na tela do percurso especifico
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
   public void aparecerTrajeto8(MouseEvent event){
    if(trajeto8.isVisible() == true){
      trajeto8.setVisible(false);
    } else{
      trajeto8.setVisible(true);
    }
  }
    /* ***************************************************************
  * Metodo: aparecerTrajeto10
  * Funcao: aparecer o trajeto na tela do percurso especifico
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
    public void aparecerTrajeto10(MouseEvent event){
    if(trajeto10.isVisible() == true){
      trajeto10.setVisible(false);
    } else{
      trajeto10.setVisible(true);
    }
  }
    /* ***************************************************************
  * Metodo: aparecerTrajeto15
  * Funcao: aparecer o trajeto na tela do percurso especifico
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
     public void aparecerTrajeto15(MouseEvent event){
    if(trajeto15.isVisible() == true){
      trajeto15.setVisible(false);
    } else{
      trajeto15.setVisible(true);
    }
  }
    /* ***************************************************************
  * Metodo: aparecerTrajeto18
  * Funcao: aparecer o trajeto na tela do percurso especifico
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
      public void aparecerTrajeto18(MouseEvent event){
    if(trajeto18.isVisible() == true){
      trajeto18.setVisible(false);
    } else{
      trajeto18.setVisible(true);
    }
  }
    /* ***************************************************************
  * Metodo: aparecerTrajeto21
  * Funcao: aparecer o trajeto na tela do percurso especifico
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
    public void aparecerTrajeto21(MouseEvent event){
    if(trajeto21.isVisible() == true){
      trajeto21.setVisible(false);
    } else{
      trajeto21.setVisible(true);
    }
  }
  /* ***************************************************************
  * Metodo: aparecerTrajeto22
  * Funcao: aparecer o trajeto na tela do percurso especifico
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
  public void aparecerTrajeto22(MouseEvent event){
    if(trajeto22.isVisible() == true){
      trajeto22.setVisible(false);
    } else{
      trajeto22.setVisible(true);
    }
  }

   
   /* ***************************************************************
  * Metodo: pararAston
  * Funcao: definir o estado de pausa como verdadeiro ou falso
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
   public void pararAston(MouseEvent event) {
     
      if(astonMarinCarro.pausado){
        astonMarinCarro.pausado = false;
      } else{
        astonMarinCarro.pausado = true;
      }
  }

    /* ***************************************************************
  * Metodo: pararMercedes
  * Funcao: definir o estado de pausa como verdadeiro ou falso
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
  public void pararMercedes(MouseEvent event) {
      
      if(mercedesCarro.pausado){
        mercedesCarro.pausado = false;
      } else {
      mercedesCarro.pausado = true;
      }     
  }
  /* ***************************************************************
  * Metodo: pararFerrari
  * Funcao: definir o estado de pausa como verdadeiro ou falso
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
    public void pararFerrari(MouseEvent event) {
      
      if(ferrariCarro.pausado){
        ferrariCarro.pausado = false;
      } else {
      ferrariCarro.pausado = true;
      }     
  }

/* ***************************************************************
  * Metodo: pararRedBull
  * Funcao: definir o estado de pausa como verdadeiro ou falso
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
    public void pararRedBull(MouseEvent event) {
      
      if(redBullCarro.pausado){
        redBullCarro.pausado = false;
      } else {
      redBullCarro.pausado = true;
      }     
  }
  /* ***************************************************************
  * Metodo: pararHass
  * Funcao: definir o estado de pausa como verdadeiro ou falso
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
    public void pararHass(MouseEvent event) {
      
      if(hassCarro.pausado){
        hassCarro.pausado = false;
      } else {
      hassCarro.pausado = true;
      }     
  }
  /* ***************************************************************
  * Metodo: pararAlpine
  * Funcao: definir o estado de pausa como verdadeiro ou falso
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
    public void pararAlpine(MouseEvent event) {
      
      if(alpineCarro.pausado){
        alpineCarro.pausado = false;
      } else {
      alpineCarro.pausado = true;
      }     
  }
  /* ***************************************************************
  * Metodo: pararMclaren
  * Funcao: definir o estado de pausa como verdadeiro ou falso
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
    public void pararMcLaren(MouseEvent event) {
      
      if(mclarenCarro.pausado){
        mclarenCarro.pausado = false;
      } else {
      mclarenCarro.pausado = true;
      }     
  }
     /* ***************************************************************
  * Metodo: pararWillians
  * Funcao: definir o estado de pausa como verdadeiro ou falso
  * Parametros: MouseEvent
  * Retorno: void
  *************************************************************** */
    public void pararWillians(MouseEvent event) {
      
      if(williansCarro.pausado){
        williansCarro.pausado = false;
      } else {
      williansCarro.pausado = true;
      }     
  }


     /* ***************************************************************
  * Metodo: inicializarSemaforos
  * Funcao: inicializar todos os semaforos com seus sinais disponiveis
  * Parametros: void
  * Retorno: void
  *************************************************************** */
  public void inicializarSemaforos(){
    // semaforo entre AstonMartin e Hass
      cruzamento3x3AH = new Semaphore(1);
      cruzamento4x4AH = new Semaphore(1);

    // semaforos entre AstonMartin e Mercedes
    cruzamento3x3AM = new Semaphore(1);
    cruzamento4x6AM = new Semaphore(1);

    // Semaforos entre AstonMartin e RedBull
    zonaCritica1x3_4x4 = new Semaphore(1);
   zonaCritica1x4_4x6 = new Semaphore(-1); // red bull comeca na zona critica astonMartin tbm

    // Semaforos entre AstonMartin e mcLaren
    zonaCricrita1x3_1x5 = new Semaphore(0);// astonMartin começa na zona critica
    zonaCricrita3x6_4x5 = new Semaphore(1);

    // Semaforos entre AstonMartin e ferrari

    zonaCritica1x3_4x6 = new Semaphore(0); // astonMartin comeca na zona critica 

    // Semafotoe entre AstonMartin e Alpine
    zonaCritica1x3_3x6 = new Semaphore(0); // astonMartin comeca na zona
    cruzamento3x3AA = new Semaphore(1);

    // Semaforos para AstonMartin e Willians
   zonaCritica2x6_4x6 = new Semaphore(1);
   zonaCritica1x4_2x3 = new Semaphore(0);

   // Semaforos para Ferrari e Redbull
   zonaCritica1x6_6x6 = new Semaphore(0); // red bull comeca na zona critica
   zonaCritica6x6_6x1 = new Semaphore(1);
   zonaCritica6x1_1x1 = new Semaphore(1); 
   zonaCritica1x1_1x3 = new Semaphore(0); // ferrari comeca na zona critica
   zonaCritica1x4_1x6 = new Semaphore(1);

  // Semaforos para Ferrari e Mercedes
  zonaCritica3x6_5x6 = new Semaphore(1);
  zonaCritica5x1_2x1 = new Semaphore(1);

  // Semaforo para Ferrari e Alpine
  zonaCritica3x1_1x1 = new Semaphore(1);
  zonaCritica1x1_1x6 = new Semaphore(0); // ferrari comeca na zona critica
  zonaCritica1x6_3x6 = new Semaphore(1);

  // Semaforo entre Ferrari e Hass
  zonaCritica6x4_6x1 = new Semaphore(0); // hass comeca na zona critica
  zonaCritica6x1_4x1 = new Semaphore(1);

   // Semaforos entre Ferrari e Mclaren
   zonaCritica3x6_4x6 = new Semaphore(1);
   zonaCritica6x5_6x2 = new Semaphore(1);
   zonaCritica4x1_3x1 = new Semaphore(1);
   zonaCritica1x2_1x5 = new Semaphore(1);

   // Semaforos entre Ferrari e Willians
   zonaCritica2x6_5x6 = new Semaphore(1);
   zonaCritica6x4_6x3 = new Semaphore(1);
   zonaCritica5x1_2x1FW = new Semaphore(1);
   zonaCritica1x3_1x4 = new Semaphore(1);  

   // Semaforos entre Redbull e Mercedes
   cruzamento3x3RM = new Semaphore(1);
   cruzamento3x4RM = new Semaphore(1);
   zonaCritica3x6_5x6RM = new Semaphore(1);
   zonaCritica5x1_3x1RM = new Semaphore(1);

   // Semaforos entre RedBull e Alpine
   cruzamento3x3RA = new Semaphore(1);
   cruzamento3x4RA = new Semaphore(1);
   zonaCritica1x1_1x3RA = new Semaphore(1);
   zonaCritica1x4_1x6RA = new Semaphore(1);
   zonaCritica1x6_3x6RA = new Semaphore(0); // redbull comeca na zona critica
   zonaCritica3x1_1x1RA = new Semaphore(1);

   //Semaforos entre RedBull e Hass
   cruzamento3x3RH = new Semaphore(1);
   zonaCritica4x4_3x4RH = new Semaphore(1);
   zonaCritica6x1_3x1RH = new Semaphore(1);
   zonaCritica6x4_6x1RH = new Semaphore(0); // hass comeca na zona critica

   //Semaforos entre RedBull e McLaren
    zonaCritica1x2_1x3RL = new Semaphore(1);
    zonaCritica1x4_1x5RL = new Semaphore(1);
    zonaCritica6x5_6x2RL = new Semaphore(1);
    zonaCritica3x6_4x6RL = new Semaphore(1);
    zonaCritica4x1_3x1RL = new Semaphore(1);

   //Semaforos entre Redbull e Willians
   zonaCritica6x4_6x3RW = new Semaphore(1);
   zonaCritica2x3_1x3RW = new Semaphore(1);
   zonaCritica2x4_1x4RW = new Semaphore(1);
   zonaCritica2x6_5x6RW = new Semaphore(1);
   zonaCritica5x1_2x1RW = new Semaphore(1);

   //Semaforos entre Mercedes e Alpine
   zonaCritica3x6_3x1MA = new Semaphore(0); //alpine comeca na zona Critica

   //Semaforos entre Mercedes e Hass
   cruzamento5x4MH = new Semaphore(1);
   zonaCritica3x1_3x4MH = new Semaphore(1);
   zonaCritica5x1_3x1MH = new Semaphore(1);

   //Semaforos entre Mercedes e Mclaren
   cruzamento5x2ML = new Semaphore(1);
   cruzamento5x5ML = new Semaphore(1);
   zonaCritica3x1_3x2ML = new Semaphore(1);
   zonaCritica3x5_3x6ML = new Semaphore(1);
   zonaCritica3x6_4x6ML = new Semaphore(1);
   zonaCritica4x1_3x1ML = new Semaphore(1);

   //Semaforos entre Mercedes e Willians
   zonaCritica5x6_5x4MW = new Semaphore(0); // mercedes comeca na zona critica
   zonaCritica3x6_5x6MW = new Semaphore(1);
   zonaCritica5x1_3x1MW = new Semaphore(1);
   zonaCritica5x3_5x1MW = new Semaphore(1);

   // Semaforos entre Alpine e Hass 
   zonaCritica3x1_3x4AH = new Semaphore(1);

   // Semaforos entre Alpine e Mclaren
   zonaCritica1x2_1x5AL = new Semaphore(1);
   zonaCritica3x2_3x1AL = new Semaphore(1);
   zonaCritica3x5_3x6AL = new Semaphore(0); // alpine comeca na zona critica

   // Semaforos entre Alpine e Willians
   zonaCritica1x3_1x4AW = new Semaphore(1);
   zonaCritica2x6_3x6AW = new Semaphore(1);
   zonaCritica3x1_2x1AW = new Semaphore(1);

   // Semaforos entre Hass e McLaren
   zonaCritica3x1_3x2HL = new Semaphore(1);
   zonaCritica4x1_3x1HL = new Semaphore(1);
   zonaCritica6x4_6x2HL = new Semaphore(1);

   // Semafors entre Hass e Willians
   zonaCritica5x1_3x1HW = new Semaphore(1);
   zonaCritica6x4_6x3HW = new Semaphore(1);
   zonaCritica5x4_6x4HW = new Semaphore(1);

   // Semaforos entre Mclaren e Willians
   cruzamento2x2LW = new Semaphore(1);
   cruzamento2x5LW = new Semaphore(1);
   cruzamento5x2LW = new Semaphore(1);
   cruzamento5x5LW = new Semaphore(1);
   zonaCritica1x3_1x4LW = new Semaphore(1);
   zonaCritica3x6_4x6LW = new Semaphore(1);
   zonaCritica6x4_6x3LW = new Semaphore(1);
   zonaCritica4x1_3x1LW = new Semaphore(1);

  }
}

   
   



      
        


   
  

  

