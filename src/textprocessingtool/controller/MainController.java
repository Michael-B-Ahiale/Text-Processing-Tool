package textprocessingtool.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import textprocessingtool.model.DataManager;
import textprocessingtool.model.RegexHelper;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {

    @FXML private TextArea dataInputField;
    @FXML private ListView<String> dataListView;
    @FXML private TextField regexPatternField;
    @FXML private TextField replacementField;
    @FXML private TextFlow resultArea;
    @FXML private ComboBox<String> savedPatternsComboBox;

    private DataManager dataManager = new DataManager();
    private Map<String, String> savedPatterns = new HashMap<>();

    @FXML
    public void initialize() {
        updateDataListView();
        loadSavedPatterns();
    }

    @FXML
    private void addToSet() {
        String input = dataInputField.getText().trim();
        if (!input.isEmpty()) {
            boolean added = dataManager.addToSet(input);
            if (added) {
                dataInputField.clear();
                updateDataListView();
            } else {
                showAlert("Item already exists in the set.");
            }
        }
    }

    @FXML
    private void editData() {
        String selectedItem = dataListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            TextInputDialog dialog = new TextInputDialog(selectedItem);
            dialog.setTitle("Edit Data");
            dialog.setHeaderText("Edit the selected item:");
            dialog.setContentText("New value:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(newValue -> {
                dataManager.removeFromSet(selectedItem);
                dataManager.addToSet(newValue);
                updateDataListView();
            });
        }
    }

    @FXML
    private void deleteData() {
        String selectedItem = dataListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            dataManager.removeFromSet(selectedItem);
            updateDataListView();
        }
    }

    @FXML
    private void checkContainsPattern() {
        String selectedItem = dataListView.getSelectionModel().getSelectedItem();
        String pattern = regexPatternField.getText();
        if (selectedItem != null && !pattern.isEmpty()) {
            boolean contains = RegexHelper.containsPattern(selectedItem, pattern);
            setResultText("Contains pattern: " + contains);
        }
    }

    @FXML
    private void findAllMatches() {
        String selectedItem = dataListView.getSelectionModel().getSelectedItem();
        String pattern = regexPatternField.getText();
        if (selectedItem != null && !pattern.isEmpty()) {
            highlightMatches(selectedItem, pattern);
        }
    }

    @FXML
    private void replaceAll() {
        String selectedItem = dataListView.getSelectionModel().getSelectedItem();
        String pattern = regexPatternField.getText();
        String replacement = replacementField.getText();
        if (selectedItem != null && !pattern.isEmpty()) {
            String result = RegexHelper.replaceAll(selectedItem, pattern, replacement);
            setResultText("Result after replacement: " + result);
        }
    }

    @FXML
    private void savePattern() {
        String pattern = regexPatternField.getText();
        if (!pattern.isEmpty()) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Save Pattern");
            dialog.setHeaderText("Enter a name for this pattern:");
            dialog.setContentText("Name:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(name -> {
                savedPatterns.put(name, pattern);
                updateSavedPatternsComboBox();
            });
        }
    }

    @FXML
    private void loadPattern() {
        String selectedPattern = savedPatternsComboBox.getSelectionModel().getSelectedItem();
        if (selectedPattern != null) {
            regexPatternField.setText(savedPatterns.get(selectedPattern));
        }
    }

    private void updateDataListView() {
        dataListView.getItems().clear();
        dataListView.getItems().addAll(dataManager.getUniqueSet());
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void setResultText(String text) {
        resultArea.getChildren().clear();
        resultArea.getChildren().add(new Text(text));
    }

    private void highlightMatches(String text, String pattern) {
        resultArea.getChildren().clear();
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(text);
        int lastEnd = 0;
        int count = 0;

        while (matcher.find()) {
            count++;
            int start = matcher.start();
            int end = matcher.end();

            if (start > lastEnd) {
                resultArea.getChildren().add(new Text(text.substring(lastEnd, start)));
            }

            Text matchedText = new Text(text.substring(start, end));
            matchedText.setFill(Color.RED);
            matchedText.setStyle("-fx-font-weight: bold;");
            resultArea.getChildren().add(matchedText);

            lastEnd = end;
        }

        if (lastEnd < text.length()) {
            resultArea.getChildren().add(new Text(text.substring(lastEnd)));
        }

        Text countText = new Text("\n\nNumber of matches: " + count);
        countText.setStyle("-fx-font-weight: bold;");
        resultArea.getChildren().add(countText);
    }

    private void loadSavedPatterns() {
        // In a real application, you would load these from a file or database
        savedPatterns.put("Email", "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b");
        savedPatterns.put("Phone Number", "\\b\\d{3}[-.]?\\d{3}[-.]?\\d{4}\\b");
        savedPatterns.put("URL", "https?://\\S+");
        updateSavedPatternsComboBox();
    }

    private void updateSavedPatternsComboBox() {
        savedPatternsComboBox.getItems().clear();
        savedPatternsComboBox.getItems().addAll(savedPatterns.keySet());
    }
}