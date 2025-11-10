package br.senai.sp.jandira.tabuada.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaTabuada extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        // definir o tamanho da tela
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setTitle("Tabuada");

        // criar o root - componente de layout principal
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #c9b7ee;");

        // criamos a cena e colocamos o root nela
        Scene scene = new Scene(root);

        // colocamos o header na tela
        VBox header = new VBox();
        header.setPrefHeight(100);
        header.setStyle("-fx-background-color: #b835e6;");

        // colocar o conteudo do header
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setStyle("-fx-text-fill: white;-fx-font-size: 40;-fx-font-weight: bold");

        Label labelSubtitulo = new Label("Crie a tabuada que a sua imaginação mandar");

        // colocar os labels no header
        header.getChildren().addAll(labelTitulo, labelSubtitulo);

        // criar o grid de formulario
        GridPane gridFormulario = new GridPane();
        gridFormulario.setPrefHeight(100);
        gridFormulario.setStyle("-fx-background-color: #06732a;");

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
        HBox boxBotoes = new HBox();
        boxBotoes.setPrefHeight(100);
        boxBotoes.setStyle("-fx-background-color: #e19c0b;");

        // criar o conteudo dos botoes
        Button buttonCalcular = new Button("Calcular");
        Button buttonLimpar = new Button("Limpar");
        Button buttonSair = new Button("Sair");

        // adicionar os botoes
        boxBotoes.getChildren().addAll(buttonCalcular, buttonLimpar, buttonSair);

        // criar a caixa de resultado
        VBox boxResultado = new VBox();
        boxResultado.setPrefHeight(100);
        boxResultado.setStyle("-fx-background-color: #db2464;");

        // criar os componentes da boxResultado
        Label labelResultado = new Label("Resultado: ");
        ListView listaTabuada = new ListView();

        // adicionar os componentes no box resultado
        boxResultado.getChildren().addAll(labelResultado, listaTabuada);

        // adicionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(boxBotoes);
        root.getChildren().add(boxResultado);

        // colocamos a cena no palco
        stage.setScene(scene);

        stage.show();
    }


}
