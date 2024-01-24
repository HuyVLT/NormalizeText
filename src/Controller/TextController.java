/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.TextModel;
import View.TextView;
import java.io.IOException;

/**
 *
 * @author ninza
 */
public class TextController {
    private TextModel model;
    private TextView view;

    public TextController(TextModel model, TextView view) {
        this.model = model;
        this.view = view;
    }

    public void processText() {
        try {
            String normalizedText = model.normalizeText();
            model.Output(normalizedText);
            view.displayMessage("Text normalization completed successfully. Output written to output.txt");
        } catch (IOException e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }
}
