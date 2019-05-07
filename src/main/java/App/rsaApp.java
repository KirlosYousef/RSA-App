package App;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class rsaApp extends Application {


    private RSA rsa = new RSA();

    private Stage createApp() {
        Stage stage = new Stage();
        VBox vContainer = new VBox();
        Label rsaLabel = new Label("RSA");
        Label encLabel = new Label("Enter text");
        TextField encTxtFld = new TextField();
        Button doneBtn = new Button("Done");

        Label enc = new Label();
        Label strInByt = new Label();
        Label dycByt = new Label();
        Label dyc = new Label();


        enc.setVisible(false);
        strInByt.setVisible(false);
        dycByt.setVisible(false);
        dyc.setVisible(false);


        doneBtn.setOnAction(e -> {
            String text = encTxtFld.getText();
            enc.setText("Encrypting String: " + text);
            strInByt.setText("String in Bytes: " + rsa.bytesToString(text.getBytes()));
            byte[] encrypted = rsa.encrypt(text.getBytes());
            byte[] decrypted = rsa.decrypt(encrypted);
            dycByt.setText("Decrypting Bytes: " + rsa.bytesToString(decrypted));
            dyc.setText("Decrypted String: " + new String(decrypted));
            enc.setVisible(true);
            strInByt.setVisible(true);
            dycByt.setVisible(true);
            dyc.setVisible(true);
        });


//        encTxtFld.maxWidth(50);


        vContainer.getChildren().addAll(rsaLabel, encLabel, encTxtFld, doneBtn, enc, strInByt, dycByt, dyc);
        vContainer.setAlignment(Pos.CENTER);
        vContainer.setSpacing(10);
        Scene rsaScene = new Scene(vContainer, 600, 300);
        stage.setScene(rsaScene);

        return stage;
    }

    @Override
    public void start(Stage stage) {
        stage = createApp();
        stage.setTitle("RSA APP");
//        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
