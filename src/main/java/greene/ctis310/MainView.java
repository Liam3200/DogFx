package greene.ctis310;

import java.net.URISyntaxException;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MainView extends Pane {
    //Label that displays the name of the dog
    private Label nameLabel;
    //Label that displays the age of the dog
    private Label ageLabel;
    //Label that displays the breed of the dog
    private Label breedLabel;
    //Label for how many times the dog barks
    private Label barkedLabel;
    //Label that says "Woof!"
    private Label woofLabel;

    //Button that makes the dog bark and makes a new dog with the name and age from the textfields and the breed and color from the choiceboxes
    private Button barkButton;
    private Button newDogButton;

    //Textfields for the name and age of dog
    private TextField nameField;
    private TextField ageField;

    //ChoiceBox for the breed and color of the dog
    private ChoiceBox<String> breedChoice;
    private ChoiceBox<String> colorChoice;

    //Dog object
    Dog dog;

    //create 4 File objects of the 4 images
    Image blackHuskyPic;
    Image whiteHuskyPic;
    Image westiePic;
    Image scottiePic;

    //create an Imageview of the images
    ImageView dogImage;

    //Constructor
    public MainView(Dog dog) throws URISyntaxException {
        //create a new dog
        this.dog = dog;
        
        //create a label that displays the name of the dog
        nameLabel = new Label("Name: " + dog.getName());
        //set the position of the label
        nameLabel.setLayoutX(10);
        nameLabel.setLayoutY(10);
        //add the label to the pane
        this.getChildren().add(nameLabel);
        
        //create a label that displays the age of the dog
        ageLabel = new Label("Age: " + dog.getAge());
        //set the position of the label
        ageLabel.setLayoutX(10);
        ageLabel.setLayoutY(30);
        //add the label to the pane
        this.getChildren().add(ageLabel);
        
        //create a label that displays the breed of the dog
        breedLabel = new Label("Breed: " + dog.getBreed());
        //set the position of the label
        breedLabel.setLayoutX(10);
        breedLabel.setLayoutY(50);
        //add the label to the pane
        this.getChildren().add(breedLabel);

        //create a label that displays how many times the dog has barked
        barkedLabel = new Label("Barked: " + dog.getBarked());
        //set the position of the label
        barkedLabel.setLayoutX(10);
        barkedLabel.setLayoutY(70);
        //add the label to the pane
        this.getChildren().add(barkedLabel);

        //create a label that says "Woof!"
        woofLabel = new Label();
        //set the position of the label
        woofLabel.setLayoutX(560);
        woofLabel.setLayoutY(10);
        //add the label to the pane
        this.getChildren().add(woofLabel);
        
        //create a button that makes the dog bark
        barkButton = new Button("Bark");
        //set the position of the button
        barkButton.setLayoutX(10);
        barkButton.setLayoutY(90);
        //add an event handler to the button
        barkButton.setOnAction(event -> {
            dog.bark();
            barkedLabel.setText("Barked: " + dog.getBarked());
            woofLabel.setText("< Woof!");
        });
        //add the button to the pane
        this.getChildren().add(barkButton);

        //create a textfield for the name of the dog
        nameField = new TextField();
        nameField.setPromptText("Name");
        //set the position of the textfield
        nameField.setLayoutX(110);
        nameField.setLayoutY(10);
        //add the textfield to the pane
        this.getChildren().add(nameField);

        //create a textfield for the age of the dog
        ageField = new TextField();
        ageField.setPromptText("Age");
        //set the position of the textfield
        ageField.setLayoutX(110);
        ageField.setLayoutY(50);
        //add the textfield to the pane
        this.getChildren().add(ageField);

        //create a choicebox for the breed of the dog
        breedChoice = new ChoiceBox<>();
        //add the breeds to the choicebox
        breedChoice.getItems().addAll("Terrier", "Husky");
        //set the position of the choicebox
        breedChoice.setLayoutX(110);
        breedChoice.setLayoutY(90);
        //add the choicebox to the pane
        this.getChildren().add(breedChoice);

        //create a choicebox for the color of the dog
        colorChoice = new ChoiceBox<>();
        //add the colors to the choicebox
        colorChoice.getItems().addAll("black", "white");
        //set the position of the choicebox
        colorChoice.setLayoutX(110);
        colorChoice.setLayoutY(130);
        //add the choicebox to the pane
        this.getChildren().add(colorChoice);

        //create a button that makes a new dog with the name and age from the textfields and the breed and color from the choiceboxes
        newDogButton = new Button("New Dog");
        //set the position of the button
        newDogButton.setLayoutX(110);
        newDogButton.setLayoutY(170);
        //add an event handler to the button
        newDogButton.setOnAction(event -> {
            this.dog = new Dog(nameField.getText(), Integer.parseInt(ageField.getText()), breedChoice.getValue(), colorChoice.getValue());
            nameLabel.setText("Name: " + this.dog.getName());
            ageLabel.setText("Age: " + this.dog.getAge());
            breedLabel.setText("Breed: " + this.dog.getBreed());
            barkedLabel.setText("Barked: " + this.dog.getBarked());
            woofLabel.setText("");
            changeImage();
        });
        //add the button to the pane
        this.getChildren().add(newDogButton);

        //create a Image object of the black husky image
        blackHuskyPic = new Image(MainView.class.getResourceAsStream("/greene/ctis310/black-husky.png"));
        //create a Image object of the white husky image
        whiteHuskyPic = new Image(MainView.class.getResourceAsStream("/greene/ctis310/white-husky.png"));
        //create a Image object of the westie image
        westiePic = new Image(MainView.class.getResourceAsStream("/greene/ctis310/westie.png"));
        //create a Image object of the scottie image
        scottiePic = new Image(MainView.class.getResourceAsStream("/greene/ctis310/scottie.png"));

        //create an imageview of the dog
        dogImage = new ImageView();
        //set the position of the imageview
        dogImage.setLayoutX(350);
        dogImage.setLayoutY(10);
        //add the imageview to the pane
        this.getChildren().add(dogImage);
        //add the image to the imageview
        dogImage.setImage(westiePic);

    }

    //method that changes the image of the dog based on the breed and color
    public void changeImage() {
        if (dog.getBreed().equals("Husky")) {
            if (dog.getColor().equals("black")) {
                dogImage.setImage(blackHuskyPic);
            } else {
                dogImage.setImage(whiteHuskyPic);
            }
        } else {
            if (dog.getColor().equals("black")) {
                dogImage.setImage(scottiePic);
            } else {
                dogImage.setImage(westiePic);
            }
        }
    }
}
