package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import sample.Common.Algorithm;
import sample.Model.Huffman.HuffmanAlgorithm;
import sample.Model.Reprezentation;
import sample.Model.SimpleEncoding;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by TeTorro on 25.03.2017.
 */
public class MainViewController implements Initializable{

    private static final double unitPrice=0.06;

    @FXML
    private Button fileOpen;

    @FXML
    private Label fileName;

    @FXML
    private Button convert;

    @FXML
    private TextArea inputField;

    @FXML
    private TextArea outputField;

    @FXML
    private ComboBox<Algorithm> algorithmComboBox;

    @FXML
    private Label priceLabel;

    @FXML
    private Label nucleotideAmountLabel;


    private int nucleotideAmount;

    private double pricing;

    private ObservableList<Algorithm> algorithms;

    private File currentFile;

    public void fileOpenButtonAction(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        currentFile = fileChooser.showOpenDialog(null);
        if(currentFile != null){
            fileName.setText(currentFile.getPath());
        } else {
            System.out.println("file is null");
        }
    }

    public void convertButtonPressed(ActionEvent event){
        validateFields();
        Algorithm algorithm = algorithmComboBox.getValue();
        algorithm.setInputFile(currentFile);
        algorithm.convert();
        inputField.setText(algorithm.getRepresentation().toString());
        outputField.setText(Reprezentation.toResult(Reprezentation.convertToReprezentation(algorithm.getOutput().toString())));
        calculatePricing(algorithm.getOutput().length());
    }

    private void calculatePricing(int amount){
        nucleotideAmount=amount;
        pricing=nucleotideAmount*unitPrice;
        priceLabel.setText(String.valueOf(pricing));
        nucleotideAmountLabel.setText(String.valueOf(nucleotideAmount));

    }

    private void validateFields(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        algorithms = FXCollections.observableArrayList(new SimpleEncoding(), new HuffmanAlgorithm());
        algorithmComboBox.setItems(algorithms);

    }
}
