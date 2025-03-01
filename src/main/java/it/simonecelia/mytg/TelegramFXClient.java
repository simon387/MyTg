package it.simonecelia.mytg;

import it.tdlight.client.SimpleTelegramClient;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TelegramFXClient extends Application {

	private SimpleTelegramClient client;

	private TextField phoneField;

	private TextField codeField;

	private Button loginButton;

	private ListView<String> chatList;

	private TextArea chatArea;

	private TextField messageField;

	private Button sendButton;

	@Override
	public void start ( Stage primaryStage ) {
		primaryStage.setTitle ( "Telegram Client" );

		// UI per login
		phoneField = new TextField ();
		phoneField.setPromptText ( "Inserisci il tuo numero di telefono" );
		codeField = new TextField ();
		codeField.setPromptText ( "Inserisci il codice di autenticazione" );
		loginButton = new Button ( "Accedi" );

		VBox loginLayout = new VBox ( 10, phoneField, codeField, loginButton );
		loginLayout.setPadding ( new Insets ( 10 ) );
		Scene loginScene = new Scene ( loginLayout, 300, 200 );

		primaryStage.setScene ( loginScene );
		primaryStage.show ();

		loginButton.setOnAction ( event -> authenticate () );
	}

	private void authenticate () {
		// Implementa l'autenticazione con TDLight qui
		System.out.println ( "Autenticazione in corso..." );
		// Se l'autenticazione ha successo, mostra la UI della chat
		showChatUI ();
	}

	private void showChatUI () {
		chatList = new ListView<> ();
		chatArea = new TextArea ();
		chatArea.setEditable ( false );
		messageField = new TextField ();
		messageField.setPromptText ( "Scrivi un messaggio..." );
		sendButton = new Button ( "Invia" );

		VBox chatLayout = new VBox ( 10, chatList, chatArea, messageField, sendButton );
		chatLayout.setPadding ( new Insets ( 10 ) );

		Scene chatScene = new Scene ( chatLayout, 500, 400 );
		Stage chatStage = new Stage ();
		chatStage.setTitle ( "Chat Telegram" );
		chatStage.setScene ( chatScene );
		chatStage.show ();

		sendButton.setOnAction ( event -> sendMessage () );
	}

	private void sendMessage () {
		String message = messageField.getText ();
		if ( !message.isEmpty () ) {
			chatArea.appendText ( "Tu: " + message + "\n" );
			messageField.clear ();
			// Implementa l'invio del messaggio con TDLight qui
		}
	}

	public static void main ( String[] args ) {
		launch ( args );
	}
}