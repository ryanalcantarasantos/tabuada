package br.senai.sp.jandira.tabuada.gui;

import br.senai.sp.jandira.tabuada.Tabuada;
import br.senai.sp.jandira.tabuada.model.TabuadaApp;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class TelaTabuada extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        // definir o tamanho da tela
        //stage.setWidth(500);
        //stage.setHeight(500);
        stage.setTitle("Tabuada");
        stage.setResizable(false);

        // criar o root - componente de layout principal
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #c9b7ee;");

        // criamos a cena e colocamos o root nela
        Scene scene = new Scene(root);

        // colocamos o header na tela
        VBox header = new VBox();
        //header.setPrefHeight(100);
        header.setStyle("-fx-background-color: #b835e6;");

        // colocar o conteudo do header
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setPadding(new Insets(8, 0, 0, 8));
        labelTitulo.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: bold");

        Label labelSubtitulo = new Label("Crie a tabuada que a sua imaginação mandar");
        labelSubtitulo.setPadding(new Insets(0, 8, 8, 8));
        labelSubtitulo.setStyle("-fx-text-fill: white;");

        // colocar os labels no header
        header.getChildren().addAll(labelTitulo, labelSubtitulo);

        // criar o grid de formulario
        GridPane gridFormulario = new GridPane();
        gridFormulario.setVgap(10);
        gridFormulario.setHgap(10);
        gridFormulario.setPadding(new Insets(16, 8, 16, 8));
        //gridFormulario.setPrefHeight(100);
        //gridFormulario.setStyle("-fx-background-color: #06732a;");

        // criar o conteudo do gridFormulario
        Label labelMultiplicando = new Label("Multiplicando: ");
        TextField textFieldMultiplicando = new TextField();
        Label labelMenorMultiplicador = new Label("Menor Multiplicador: ");
        TextField textFieldMenorMultiplicador = new TextField();
        Label labelMaiorMultiplicador = new Label("Maior Multiplicador: ");
        TextField textFieldMaiorMultiplicador = new TextField();

        // colocar os componentes no grid
        gridFormulario.add(labelMultiplicando, 0, 0);
        gridFormulario.add(textFieldMultiplicando, 1, 0);
        gridFormulario.add(labelMenorMultiplicador, 0, 1);
        gridFormulario.add(textFieldMenorMultiplicador, 1, 1);
        gridFormulario.add(labelMaiorMultiplicador, 0, 2);
        gridFormulario.add(textFieldMaiorMultiplicador, 1, 2);

        // criar a caixa dos botoes
        Pane paneButtons = new Pane();
        paneButtons.setPadding(new Insets(16, 0, 16, 8));
        HBox boxBotoes = new HBox();
        boxBotoes.setPadding(new Insets(8));
        boxBotoes.setSpacing(10);
        //boxBotoes.setPrefHeight(100);
        //boxBotoes.setStyle("-fx-background-color: #e19c0b;");
        paneButtons.getChildren().add(boxBotoes);

        // criar o conteudo dos botoes
        Button buttonCalcular = new Button("Calcular");
        Button buttonLimpar = new Button("Limpar");
        Button buttonSair = new Button("Sair");

        // adicionar os botoes
        boxBotoes.getChildren().addAll(buttonCalcular, buttonLimpar, buttonSair);

        // criar a caixa de resultado
        VBox boxResultado = new VBox();
        boxResultado.setPrefHeight(300);
        //boxResultado.setStyle("-fx-background-color: #db2464;");

        // criar os componentes da boxResultado
        Label labelResultado = new Label("Resultado: ");
        labelResultado.setPadding(new Insets(8, 8, 8, 8));
        labelResultado.setStyle("-fx-text-fill: blue;-fx-font-size: 18;");
        ListView listaTabuada = new ListView();
        listaTabuada.setPadding(new Insets(8));
        //listaTabuada.setPrefHeight(300);

        // adicionar os componentes no box resultado
        boxResultado.getChildren().addAll(labelResultado, listaTabuada);

        // adicionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(paneButtons);
        root.getChildren().add(boxResultado);

        // colocamos a cena no palco
        stage.setScene(scene);

        stage.show();

        buttonLimpar.setOnAction(e -> {

            textFieldMaiorMultiplicador.clear();
            textFieldMenorMultiplicador.clear();
            textFieldMultiplicando.clear();
            listaTabuada.getItems().clear();
            textFieldMultiplicando.requestFocus();
        });

        buttonCalcular.setOnAction(e -> {

            TabuadaApp tabuadaApp = new TabuadaApp();

            tabuadaApp.multiplicando =
                    Integer.parseInt(textFieldMultiplicando.getText());

            tabuadaApp.multiplicadorInicial =
                    Integer.parseInt( textFieldMenorMultiplicador.getText());

            tabuadaApp.multiplicadorFinal =
                    Integer.parseInt( textFieldMaiorMultiplicador.getText());

            String[] resultado = tabuadaApp.calcularTabuada();
            listaTabuada.getItems().addAll(resultado);

            //gravar os itens da tabuada em arquivo
            Path arquivo = Path.of("c:\\Users\\25203781\\ds1t\\tabuada\\dados_tabuada.csv");

            String dados = textFieldMultiplicando.getText() + ";" + textFieldMenorMultiplicador.getText() + ";" + textFieldMaiorMultiplicador.getText() + ";" + LocalDateTime.now() + "\n";

            try {
                Files.writeString(arquivo, dados, StandardOpenOption.APPEND);
            } catch (IOException erro){
                System.out.println(erro.getMessage());
            }
        });
    }


}
