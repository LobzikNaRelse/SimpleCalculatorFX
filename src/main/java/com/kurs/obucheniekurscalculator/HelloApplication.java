package com.kurs.obucheniekurscalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// что бы создать exe файл project stru -> artif -> + -> jar -> with modules
// создаст meti inf -> manifest
// далее build -> build artifacts
// создаст в out .jar файл
// далее лайнч4g там надо разбираться

public class HelloApplication extends Application
{
    // в Sctnt Builder у кнопки Code: On key pressed срабатывает когда пользователь вводим, мб для ДЗ
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("calculator.fxml"));
        // указываем какой файл с дизайном подключаем
        Scene scene = new Scene(fxmlLoader.load(), 235, 300); // создается окошко
        stage.setTitle("Калькулятор"); // stage это класс всего приложения
        stage.setScene(scene); // основное окно
        stage.show(); // показываем приложение
    }

    public static void main(String[] args)
    {
        launch();
    }
}