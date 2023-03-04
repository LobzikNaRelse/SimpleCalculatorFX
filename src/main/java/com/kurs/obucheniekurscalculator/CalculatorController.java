package com.kurs.obucheniekurscalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController
{
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button clear_btn;
    @FXML
    private Button delen_btn;
    @FXML
    private Label label_res;
    @FXML
    private Button minus_btn;
    @FXML
    private Button minus_plus_btn;
    @FXML
    private Button percent_btn;
    @FXML
    private Button plus_btn;
    @FXML
    private Button ravno_btn;
    @FXML
    private Button umng_btn;
    @FXML
    private Button zpt_btn;

    String label_text = ""; // нужно присвоить пустоту что бы вначале не присваивалась null в лабел
    float first_num = 0f;
    char operation = '0';

    @FXML
    void addNumber(ActionEvent event) // метод для цифр, event событие которое передается
    {
        label_text += ((Button) event.getSource()).getText();// конвертируем в button и получаем текст с кнопки и добавляем его к прошлому
        label_res.setText(label_text);
    }

    @FXML
    void initialize() // срабатывает 1 раз при запуске fxml страницы
    {
        plus_btn.setOnAction(actionEvent -> // устанавливаем обработчик событий
        {
            mathAction('+');
        });

        minus_btn.setOnAction(actionEvent -> // устанавливаем обработчик событий
        {
            mathAction('-');
        });

        umng_btn.setOnAction(actionEvent -> // устанавливаем обработчик событий
        {
            mathAction('*');
        });

        delen_btn.setOnAction(actionEvent -> // устанавливаем обработчик событий
        {
            mathAction('/');
        });

        ravno_btn.setOnAction(actionEvent -> // устанавливаем обработчик событий
        {
            if (operation != '+' || operation != '-' || operation != '/' || operation != '*')
                equalsBtn();
        });

        zpt_btn.setOnAction(actionEvent -> // устанавливаем обработчик событий
        {
            mathAction(',');
        });

        clear_btn.setOnAction(actionEvent -> // устанавливаем обработчик событий
        {
            label_res = null;
        });

        percent_btn.setOnAction(actionEvent -> // устанавливаем обработчик событий
        {
            if(!label_text.equals(""))// проверяет пустая ли строка
            {
                float num = Float.parseFloat(label_text) * 0.1f;
                label_text = Float.toString(num);
                label_res.setText(label_text);
            }
        });

        zpt_btn.setOnAction(actionEvent -> // устанавливаем обработчик событий
        {
            if(!label_text.contains("."))// если строка не содержит точку
            {
                label_text += ".";
                label_res.setText(label_text );
            }
        });

        clear_btn.setOnAction(actionEvent ->
        {
            label_res.setText("0");
            label_text = "";
            operation = '0';
            first_num = 0f;
        });

        minus_plus_btn.setOnAction(actionEvent -> // устанавливаем обработчик событий
        {
            if(!label_text.equals(""))// проверяет пустая ли строка
            {
                float num = Float.parseFloat(label_text) * -1f;
                label_text = Float.toString(num);
                label_res.setText(label_text);
            }
        });

    }

    private void equalsBtn()
    {
        float res = 0f;
        switch (operation)
            {
                case '+':
                    res = first_num + Float.parseFloat(label_text);
                    break;
                case '-':
                    res = first_num - Float.parseFloat(label_text);
                    break;
                case '/':
                    float second_num = Float.parseFloat(label_text);
                    if(second_num != 0)
                        res = first_num / second_num;
                    else
                        res = 0;
                    break;
                case '*':
                    res = first_num * Float.parseFloat(label_text);
                    break;
            }
        label_res.setText(Float.toString(res)); // выводим результат
        label_text = ""; // обнуляем
        operation = '0';
        first_num = 0f;
    }

    private void mathAction(char action)
    {
        if (operation != '+' && operation != '-' && operation != '/' && operation != '*')
        {
            first_num = Float.parseFloat(label_text); // помещаем число которое есть в переменную
            label_res.setText(String.valueOf(action)); // чар в стринг
            label_text = "";
            operation = action;
        }
    }

}

