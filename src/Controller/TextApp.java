/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

/**
 *
 * @author ninza
 */

import Controller.TextController;
import Model.TextModel;
import View.TextView;

public class TextApp {
    public static void main(String[] args) {
        TextModel model = new TextModel("input.txt", "output.txt");
        TextView view = new TextView();
        TextController controller = new TextController(model, view);

        controller.processText();
    }
}


