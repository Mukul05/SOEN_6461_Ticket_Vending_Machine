package igoApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IgoTVMApplication extends Application {
	private Language language = Language.getInstance();
	private Button rechargeButton;
	private Text titleLabel;
	private Scene mainScene;

	private Button purchaseButton;
	private String passType;

	private void updateDisplay(Stage primaryStage) {
		// TODO Auto-generated method stub
		rechargeButton.setText(language.getTextString("recharge"));
		purchaseButton.setText(language.getTextString("purchase"));

		titleLabel.setText(language.getTextString("title"));

		rechargeButton.setOnAction(e -> {

			VBox rechargeVBox = new VBox(10);
			rechargeVBox.setAlignment(Pos.CENTER);
			rechargeVBox.setPadding(new Insets(20, 20, 20, 20));

			Text passTypeLabel = new Text(30.0, 80.0, language.getTextString("passTypeLabel"));

			Font font1 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
			passTypeLabel.setFont(font1);
			passTypeLabel
					.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, #ffe716 0%, #00aeef 80%);\r\n"
							+ "    -fx-stroke: black;\r\n" + "    -fx-stroke-width: 1;");

			ComboBox<String> passTypeCombo = new ComboBox<>();
			passTypeCombo.getItems().addAll(language.getTextString("2WeekPrice"), language.getTextString("1MonthPrice"),
					language.getTextString("2MonthPrice"), language.getTextString("3MonthPrice"));
			passTypeCombo.setValue(language.getTextString("2WeekPrice"));
			passTypeCombo.setPrefSize(220, 60);
			passTypeCombo.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");
			passTypeCombo.setStyle("-fx-border-color: #000099; -fx-border-width: 3px;");

			Button confirmPassTypeButton = new Button(language.getTextString("confirmPassTypeButton"));
			confirmPassTypeButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
			confirmPassTypeButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
			confirmPassTypeButton.setStyle("-fx-background-color: linear-gradient(#439CC1, #43C1B0);\r\n"
					+ "    -fx-background-radius: 30;\r\n" + "    -fx-background-insets: 0;\r\n"
					+ "    -fx-text-fill: white;");
			confirmPassTypeButton.setPrefSize(120, 30);
			confirmPassTypeButton.setOnAction(e2 -> {
				this.passType = passTypeCombo.getValue();

				System.out.println("Pass Type Selected: " + this.passType);

				VBox paymentVBox = new VBox(10);
				paymentVBox.setAlignment(Pos.CENTER);
				paymentVBox.setPadding(new Insets(20, 20, 20, 20));

				Text paymentLabel = new Text(30.0, 80.0, language.getTextString("paymentLabel"));

				Font font2 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
				paymentLabel.setFont(font2);
				paymentLabel.setStyle(
						"-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, #ffe716 0%, #00aeef 80%);\r\n"
								+ "    -fx-stroke: black;\r\n" + "    -fx-stroke-width: 1;");

				ComboBox<String> paymentCombo = new ComboBox<>();
				paymentCombo.getItems().addAll(language.getTextString("cashOption"),
						language.getTextString("debitCreditOption"));
				paymentCombo.setValue(language.getTextString("cashOption"));
				paymentCombo.setPrefSize(220, 40);
				paymentCombo.setStyle("-fx-font-size: 48px; -fx-font-weight: bold;");
				paymentCombo.setStyle("-fx-border-color: #000099; -fx-border-width: 3px;");

				Button confirmPaymentButton = new Button(language.getTextString("confirmPassTypeButton"));
				confirmPaymentButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
				confirmPaymentButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
				confirmPaymentButton.setStyle("-fx-background-color: linear-gradient(#439CC1, #43C1B0);\r\n"
						+ "    -fx-background-radius: 30;\r\n" + "    -fx-background-insets: 0;\r\n"
						+ "    -fx-text-fill: white;");
				confirmPaymentButton.setPrefSize(120, 30);
				confirmPaymentButton.setOnAction(e3 -> {
					String paymentMethod = paymentCombo.getValue();
					System.out.println("Pass Type: " + this.passType + ", Payment Method: " + paymentMethod);

					if (paymentMethod.equals(language.getTextString("cashOption"))) {

						VBox cashVBox = new VBox(10);
						cashVBox.setAlignment(Pos.CENTER);
						cashVBox.setPadding(new Insets(20, 20, 20, 20));

						Image backgroundImageCB = new Image("PB.png");

						BackgroundSize backgroundSizeCB = new BackgroundSize(1.0, 1.0, true, true, false, false);
						BackgroundImage backgroundImageObjCB = new BackgroundImage(backgroundImageCB,
								BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
								backgroundSizeCB);
						Background backgroundCB = new Background(backgroundImageObjCB);
						cashVBox.setBackground(backgroundCB);

						Text cashLabel = new Text(30.0, 80.0, language.getTextString("cashOption"));
						cashLabel.setStyle(
								"-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, #ffe716 0%, #00aeef 80%);\r\n"
										+ "    -fx-stroke: black;\r\n" + "    -fx-stroke-width: 1;");

						Font font3 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
						cashLabel.setFont(font3);

						TextField cashField = new TextField();
						cashField.setFont(Font.font("Arial", 20));
						cashField.setMaxWidth(200);

						Button confirmCashButton = new Button(language.getTextString("confirmPassTypeButton"));
						confirmCashButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
						confirmCashButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
						confirmCashButton.setStyle("-fx-background-color: linear-gradient(#439CC1, #43C1B0);\r\n"
								+ "    -fx-background-radius: 30;\r\n" + "    -fx-background-insets: 0;\r\n"
								+ "    -fx-text-fill: white;");
						confirmCashButton.setPrefSize(120, 30);
						confirmCashButton.setOnAction(e4 -> {
							String cashAmount = cashField.getText();

							System.out.println("Cash Amount Entered: " + cashAmount);
							System.out.println(passType);
							if (cashAmount.length() <= 0 || cashAmount.equals("")) {
								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setHeaderText("Invalid Amount");
								alert.setContentText("Invalid amount value");
								alert.showAndWait();
							} else {
								double passAmount = Double.parseDouble(this.passType.split(" ")[4]);
								double cash = Double.parseDouble(cashAmount);

								if (cash >= passAmount) {
									double balance = cash - passAmount;
									String balanceMessage = String.format(language.getTextString("balanceMessage"),
											balance);

									Text balanceLabel = new Text(30.0, 80.0, balanceMessage);

									Font font4 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 42);
									balanceLabel.setFont(font4);

									VBox successVBox = new VBox(10);
									successVBox.setAlignment(Pos.CENTER);
									successVBox.setPadding(new Insets(20, 20, 20, 20));
									successVBox.getChildren().add(balanceLabel);

									Button okButton = new Button(language.getTextString("okButton"));
									okButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
									okButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
									okButton.setStyle(
											"-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
									okButton.setPrefSize(120, 30);
									okButton.setOnAction(e5 -> {
										primaryStage.setScene(mainScene);
									});

									successVBox.getChildren().add(okButton);

									Image backgroundImageSB = new Image("SB.png");
									BackgroundSize backgroundSizeSB = new BackgroundSize(1.0, 1.0, true, true, false,
											false);
									BackgroundImage backgroundImageObjSB = new BackgroundImage(backgroundImageSB,
											BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
											backgroundSizeSB);
									Background backgroundSB = new Background(backgroundImageObjSB);
									successVBox.setBackground(backgroundSB);

									Scene successScene = new Scene(successVBox, 1200, 700);
									primaryStage.setScene(successScene);

								} else {
									Alert alert = new Alert(Alert.AlertType.ERROR);
									alert.setTitle(language.getTextString("errorTitle"));
									alert.setHeaderText(null);
									alert.setContentText(language.getTextString("errorLessBalanceMessage"));
									alert.showAndWait();
								}
							}

						});

						cashVBox.getChildren().addAll(cashLabel, cashField, confirmCashButton);

						Scene cashScene = new Scene(cashVBox, 1200, 700);
						primaryStage.setScene(cashScene);

					} else if (paymentMethod.equals(language.getTextString("debitCreditOption"))) {

						VBox cardDetailsVBox = new VBox(10);
						cardDetailsVBox.setAlignment(Pos.CENTER);
						cardDetailsVBox.setPadding(new Insets(20, 20, 20, 20));

						Image backgroundImageCD = new Image("CD.png");

						BackgroundSize backgroundSizeCD = new BackgroundSize(1.0, 1.0, true, true, false, false);
						BackgroundImage backgroundImageObjCD = new BackgroundImage(backgroundImageCD,
								BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
								backgroundSizeCD);
						Background backgroundCD = new Background(backgroundImageObjCD);
						cardDetailsVBox.setBackground(backgroundCD);

						Text cardNumberLabel = new Text(30.0, 80.0, "Card Number:");
						Font font5 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
						cardNumberLabel.setFont(font5);
						cardNumberLabel.setFill(Color.YELLOW);
						cardNumberLabel.setStrokeWidth(2);
						cardNumberLabel.setStroke(Color.DARKBLUE);

						TextField cardNumberField = new TextField();
						cardNumberField.setFont(Font.font("Arial", 20));
						cardNumberField.setMaxWidth(500);
						cardNumberField.setPromptText("Enter card number");

						Text expiryDateLabel = new Text(30.0, 80.0, "Expiry Date (MM/YY):");
						Font font6 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
						expiryDateLabel.setFont(font6);
						expiryDateLabel.setFill(Color.YELLOW);
						expiryDateLabel.setStrokeWidth(2);
						expiryDateLabel.setStroke(Color.DARKBLUE);

						TextField expiryDateField = new TextField();
						expiryDateField.setFont(Font.font("Arial", 20));
						expiryDateField.setMaxWidth(500);
						expiryDateField.setPromptText("MM/YY");

						Text cvvLabel = new Text(30.0, 80.0, "CVV:");
						Font font7 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
						cvvLabel.setFont(font7);
						cvvLabel.setFill(Color.YELLOW);
						cvvLabel.setStrokeWidth(2);
						cvvLabel.setStroke(Color.DARKBLUE);

						TextField cvvField = new TextField();
						cvvField.setFont(Font.font("Arial", 20));
						cvvField.setMaxWidth(500);
						cvvField.setPromptText("Enter CVV");

						Button confirmCardDetailsButton = new Button(language.getTextString("confirmPassTypeButton"));
						confirmCardDetailsButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
						confirmCardDetailsButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
						confirmCardDetailsButton
								.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
						confirmCardDetailsButton.setPrefSize(120, 30);
						confirmCardDetailsButton.setOnAction(e4 -> {
							String cardNumber = cardNumberField.getText();
							String expiryDate = expiryDateField.getText();
							String cvv = cvvField.getText();

							SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
							Date currentDate = new Date();
							boolean validExpiryDate = true;
							try {
								Date expiryDateObj = dateFormat.parse(expiryDate);
								if (expiryDateObj.before(currentDate)) {
									validExpiryDate = false;
								}
							} catch (ParseException ex) {
								validExpiryDate = false;
							}

							int sum = 0;
							boolean alternate = false;
							for (int i = cardNumber.length() - 1; i >= 0; i--) {
								int n = Integer.parseInt(cardNumber.substring(i, i + 1));
								if (alternate) {
									n *= 2;
									if (n > 9) {
										n = (n % 10) + 1;
									}
								}
								sum += n;
								alternate = !alternate;
							}

							if (cardNumber.isEmpty() || expiryDate.isEmpty() || cvv.isEmpty()) {
								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setHeaderText("Invalid Card Details");
								alert.setContentText(language.getTextString("errorInvalidCardDetails"));
								alert.showAndWait();
							} else if (!cardNumber.matches("^\\d{16}$")) {

								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setHeaderText("Invalid Card Number");
								alert.setContentText("Please enter a valid 16-digit card number.");
								alert.showAndWait();
							} else if (!expiryDate.matches("^(0[1-9]|1[0-2])/\\d{2}$")) {

								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setHeaderText("Invalid Expiry date");
								alert.setContentText("Please enter a valid Expiry Date.");
								alert.showAndWait();
							} else if (!cvv.matches("^\\d{3}$")) {

								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setHeaderText("Invalid CVV");
								alert.setContentText("Please enter a valid CVV number.");
								alert.showAndWait();
							} else if (!validExpiryDate) {
								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setHeaderText("Expired Card");
								alert.setContentText("The entered card has expired. Please use a valid card.");
								alert.showAndWait();
							}

							else if (sum % 10 != 0) {
								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setHeaderText("Invalid Card Number");
								alert.setContentText("Please enter a valid card number.");
								alert.showAndWait();
							} else {

								Alert alert = new Alert(Alert.AlertType.INFORMATION);
								alert.setTitle("Payment Confirmation");
								alert.setHeaderText("Payment Successful");

								String contentText = "Payment by Debit/Credit card for " + this.passType
										+ " is successful.\nThank you for using igo TVM.\n\nPlease select your receipt prefernce :";

								Text contentLabel = new Text(30.0, 80.0, contentText);

								Font font4 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30);
								contentLabel.setFont(font4);

								contentLabel.setFill(Color.YELLOW);

								contentLabel.setStrokeWidth(1);

								contentLabel.setStroke(Color.DARKGREEN);

								RadioButton emailRadioButton = new RadioButton("Email Receipt");
								emailRadioButton.setStyle("-fx-font-size: 22px; -fx-text-fill: #ffff00;");
								RadioButton paperRadioButton = new RadioButton("Paper-based Receipt");
								paperRadioButton.setStyle("-fx-font-size: 22px; -fx-text-fill: #ffff00;");

								ToggleGroup receiptToggleGroup = new ToggleGroup();
								emailRadioButton.setToggleGroup(receiptToggleGroup);
								paperRadioButton.setToggleGroup(receiptToggleGroup);

								TextField emailTextField = new TextField();
								emailTextField.setFont(Font.font("Arial", 18));
								emailTextField.setMaxWidth(500);
								emailTextField.setPromptText("Enter email address");

								Button confirmReceiptButton = new Button("Confirm");
								confirmReceiptButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
								confirmReceiptButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
								confirmReceiptButton.setStyle(
										"-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
								confirmReceiptButton.setPrefSize(100, 20);
								confirmReceiptButton.setOnAction(e5 -> {
									String receiptPreference = "";
									if (emailRadioButton.isSelected()) {
										if (emailTextField.getText().isEmpty()) {
											Alert emailAlert = new Alert(Alert.AlertType.ERROR,
													"Please enter your email address.");
											emailAlert.showAndWait();
											return;
										}
										receiptPreference = "Email";
									} else if (paperRadioButton.isSelected()) {
										receiptPreference = "Paper-based ticket";
									}

								});

								VBox contentVBox = new VBox(10);
								contentVBox.setAlignment(Pos.CENTER);
								contentVBox.getChildren().addAll(contentLabel, emailRadioButton, paperRadioButton,
										emailTextField, confirmReceiptButton);

								emailTextField.visibleProperty().bind(emailRadioButton.selectedProperty());

								Image backgroundImageCSB = new Image("SB.png");

								BackgroundSize backgroundSizeCSB = new BackgroundSize(1.0, 1.0, true, true, false,
										false);
								BackgroundImage backgroundImageObjCSB = new BackgroundImage(backgroundImageCSB,
										BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
										backgroundSizeCSB);
								Background backgroundCSB = new Background(backgroundImageObjCSB);
								contentVBox.setBackground(backgroundCSB);
								alert.getDialogPane().setContent(contentVBox);
								alert.getDialogPane().setPrefSize(700, 400);
								alert.showAndWait();

								primaryStage.setScene(mainScene);

							}
						});

						cardDetailsVBox.getChildren().addAll(cardNumberLabel, cardNumberField, expiryDateLabel,
								expiryDateField, cvvLabel, cvvField, confirmCardDetailsButton);

						Scene cardDetailsScene = new Scene(cardDetailsVBox, 1200, 700);
						primaryStage.setScene(cardDetailsScene);
					}
				});

				paymentVBox.getChildren().addAll(paymentLabel, paymentCombo, confirmPaymentButton);

				Image backgroundImagePB = new Image("PB.png");

				BackgroundSize backgroundSizePB = new BackgroundSize(1.0, 1.0, true, true, false, false);
				BackgroundImage backgroundImageObjPB = new BackgroundImage(backgroundImagePB, BackgroundRepeat.REPEAT,
						BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizePB);
				Background backgroundPB = new Background(backgroundImageObjPB);
				paymentVBox.setBackground(backgroundPB);

				Scene paymentScene = new Scene(paymentVBox, 1200, 700);
				primaryStage.setScene(paymentScene);
			});

			rechargeVBox.getChildren().addAll(passTypeLabel, passTypeCombo, confirmPassTypeButton);

			Image backgroundImageRB = new Image("RB.png");
			BackgroundSize backgroundSizeRB = new BackgroundSize(1.0, 1.0, true, true, false, false);
			BackgroundImage backgroundImageObjRB = new BackgroundImage(backgroundImageRB, BackgroundRepeat.REPEAT,
					BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeRB);
			Background backgroundRB = new Background(backgroundImageObjRB);
			rechargeVBox.setBackground(backgroundRB);
			Scene rechargeScene = new Scene(rechargeVBox, 1200, 700);
			primaryStage.setScene(rechargeScene);

		});

		purchaseButton.setOnAction(e -> {
			System.out.println("Purchase Ticket Selected");

			VBox rechargeVBox = new VBox(10);
			rechargeVBox.setAlignment(Pos.CENTER);
			rechargeVBox.setPadding(new Insets(20, 20, 20, 20));

			Text passTypeLabel = new Text(30.0, 80.0, language.getTextString("purchaseTicketType"));
			Font font1 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
			passTypeLabel.setFont(font1);
			passTypeLabel
					.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, #ffe716 0%, #00aeef 80%);\r\n"
							+ "    -fx-stroke: black;\r\n" + "    -fx-stroke-width: 1;");

			ComboBox<String> passTypeCombo = new ComboBox<>();
			passTypeCombo.getItems().addAll(language.getTextString("1tripLabel"), language.getTextString("2tripLabel"),
					language.getTextString("1dayLabel"), language.getTextString("1weekLabel"),
					language.getTextString("unlimitedWeekendLabel"));
			passTypeCombo.setValue(language.getTextString("1tripLabel"));
			passTypeCombo.setPrefSize(220, 60);
			passTypeCombo.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");
			passTypeCombo.setStyle("-fx-border-color: #000099; -fx-border-width: 3px;");

			Button confirmPassTypeButton = new Button("Confirm");
			confirmPassTypeButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
			confirmPassTypeButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
			confirmPassTypeButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
			confirmPassTypeButton.setPrefSize(120, 30);
			confirmPassTypeButton.setOnAction(e2 -> {
				this.passType = passTypeCombo.getValue();

				System.out.println("Ticket Type Selected: " + this.passType);

				VBox paymentVBox = new VBox(10);
				paymentVBox.setAlignment(Pos.CENTER);
				paymentVBox.setPadding(new Insets(20, 20, 20, 20));

				Text paymentLabel = new Text(30.0, 80.0, language.getTextString("paymentLabel"));
				Font font2 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
				paymentLabel.setFont(font2);
				paymentLabel.setStyle(
						"-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, #ffe716 0%, #00aeef 80%);\r\n"
								+ "    -fx-stroke: black;\r\n" + "    -fx-stroke-width: 1;");

				ComboBox<String> paymentCombo = new ComboBox<>();
				paymentCombo.getItems().addAll(language.getTextString("cashOption"),
						language.getTextString("debitCreditOption"));
				paymentCombo.setValue(language.getTextString("cashOption"));
				paymentCombo.setPrefSize(220, 40);
				paymentCombo.setStyle("-fx-font-size: 48px; -fx-font-weight: bold;");
				paymentCombo.setStyle("-fx-border-color: #000099; -fx-border-width: 3px;");

				Button confirmPaymentButton = new Button(language.getTextString("confirmPassTypeButton"));
				confirmPaymentButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
				confirmPaymentButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
				confirmPaymentButton
						.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
				confirmPaymentButton.setPrefSize(120, 30);
				confirmPaymentButton.setOnAction(e3 -> {
					String paymentMethod = paymentCombo.getValue();
					System.out.println("Pass Type: " + this.passType + ", Payment Method: " + paymentMethod);

					if (paymentMethod.equals(language.getTextString("cashOption"))) {

						VBox cashVBox = new VBox(10);
						cashVBox.setAlignment(Pos.CENTER);
						cashVBox.setPadding(new Insets(20, 20, 20, 20));

						Text cashLabel = new Text(30.0, 80.0, "Enter Cash Amount:");
						Font font3 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 52);
						cashLabel.setFont(font3);
						cashLabel.setStyle(
								"-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, #ffe716 0%, #00aeef 80%);\r\n"
										+ "    -fx-stroke: black;\r\n" + "    -fx-stroke-width: 1;");

						TextField cashField = new TextField();
						cashField.setFont(Font.font("Arial", 20));
						cashField.setMaxWidth(200);

						Button confirmCashButton = new Button("Confirm");
						confirmCashButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
						confirmCashButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
						confirmCashButton
								.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
						confirmCashButton.setPrefSize(120, 30);
						confirmCashButton.setOnAction(e4 -> {
							String cashAmount = cashField.getText();
							System.out.println("Cash Amount Entered: " + cashAmount);

							if (cashAmount.length() <= 0 || cashAmount.equals("")) {
								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setHeaderText("Invalid Amount");
								alert.setContentText("Invalid amount value");
								alert.showAndWait();
							} else {
								double passAmount = Double.parseDouble(this.passType.split(" ")[4]);
								double cash = Double.parseDouble(cashAmount);

								if (cash >= passAmount) {
									double balance = cash - passAmount;
									String balanceMessage = String.format(
											"Payment Successful!\nPlease collect your ticket and balance amount: $%.2f",
											balance);

									Text balanceLabel = new Text(30.0, 80.0, balanceMessage);
									Font font4 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 42);
									balanceLabel.setFont(font4);

									VBox successVBox = new VBox(10);
									successVBox.setAlignment(Pos.CENTER);
									successVBox.setPadding(new Insets(20, 20, 20, 20));
									successVBox.getChildren().add(balanceLabel);

									Button okButton = new Button("OK");
									okButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
									okButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
									okButton.setStyle(
											"-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
									okButton.setPrefSize(120, 30);
									okButton.setOnAction(e5 -> {
										primaryStage.setScene(mainScene);
									});

									successVBox.getChildren().add(okButton);

									Image backgroundImageSB = new Image("SB.png");
									BackgroundSize backgroundSizeSB = new BackgroundSize(1.0, 1.0, true, true, false,
											false);
									BackgroundImage backgroundImageObjSB = new BackgroundImage(backgroundImageSB,
											BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
											backgroundSizeSB);
									Background backgroundSB = new Background(backgroundImageObjSB);
									successVBox.setBackground(backgroundSB);

									Scene successScene = new Scene(successVBox, 1200, 700);
									primaryStage.setScene(successScene);
								} else {
									Alert alert = new Alert(Alert.AlertType.ERROR);
									alert.setTitle(language.getTextString("error"));
									alert.setHeaderText(null);
									alert.setContentText("Entered amount is less. Please try again.");
									alert.showAndWait();
								}
							}

						});

						cashVBox.getChildren().addAll(cashLabel, cashField, confirmCashButton);

						Image backgroundImageCB = new Image("PB.png");

						BackgroundSize backgroundSizeCB = new BackgroundSize(1.0, 1.0, true, true, false, false);
						BackgroundImage backgroundImageObjCB = new BackgroundImage(backgroundImageCB,
								BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
								backgroundSizeCB);
						Background backgroundCB = new Background(backgroundImageObjCB);
						cashVBox.setBackground(backgroundCB);

						Scene cashScene = new Scene(cashVBox, 1200, 700);
						primaryStage.setScene(cashScene);
					} else if (paymentMethod.equals(language.getTextString("debitCreditOption"))) {

						VBox cardDetailsVBox = new VBox(10);
						cardDetailsVBox.setAlignment(Pos.CENTER);
						cardDetailsVBox.setPadding(new Insets(20, 20, 20, 20));

						Text cardNumberLabel = new Text(30.0, 80.0, "Card Number:");
						Font font5 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
						cardNumberLabel.setFont(font5);
						cardNumberLabel.setFill(Color.YELLOW);
						cardNumberLabel.setStrokeWidth(2);
						cardNumberLabel.setStroke(Color.DARKBLUE);

						TextField cardNumberField = new TextField();
						cardNumberField.setFont(Font.font("Arial", 20));
						cardNumberField.setMaxWidth(500);
						cardNumberField.setPromptText("Enter card number");

						Text expiryDateLabel = new Text(30.0, 80.0, "Expiry Date (MM/YY):");
						Font font6 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
						expiryDateLabel.setFont(font6);
						expiryDateLabel.setFill(Color.YELLOW);
						expiryDateLabel.setStrokeWidth(2);
						expiryDateLabel.setStroke(Color.DARKBLUE);

						TextField expiryDateField = new TextField();
						expiryDateField.setFont(Font.font("Arial", 20));
						expiryDateField.setMaxWidth(500);
						expiryDateField.setPromptText("MM/YY");

						Text cvvLabel = new Text(30.0, 80.0, "CVV:");

						Font font7 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
						cvvLabel.setFont(font7);
						cvvLabel.setFill(Color.YELLOW);
						cvvLabel.setStrokeWidth(2);
						cvvLabel.setStroke(Color.DARKBLUE);

						TextField cvvField = new TextField();
						cvvField.setFont(Font.font("Arial", 20));
						cvvField.setMaxWidth(500);
						cvvField.setPromptText("Enter CVV");

						Button confirmCardDetailsButton = new Button("Confirm");
						confirmCardDetailsButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
						confirmCardDetailsButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
						confirmCardDetailsButton
								.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
						confirmCardDetailsButton.setPrefSize(120, 30);
						confirmCardDetailsButton.setOnAction(e4 -> {
							String cardNumber = cardNumberField.getText();
							String expiryDate = expiryDateField.getText();
							String cvv = cvvField.getText();

							SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
							Date currentDate = new Date();
							boolean validExpiryDate = true;
							try {
								Date expiryDateObj = dateFormat.parse(expiryDate);
								if (expiryDateObj.before(currentDate)) {
									validExpiryDate = false;
								}
							} catch (ParseException ex) {
								validExpiryDate = false;
							}

							int sum = 0;
							boolean alternate = false;
							for (int i = cardNumber.length() - 1; i >= 0; i--) {
								int n = Integer.parseInt(cardNumber.substring(i, i + 1));
								if (alternate) {
									n *= 2;
									if (n > 9) {
										n = (n % 10) + 1;
									}
								}
								sum += n;
								alternate = !alternate;
							}

							if (cardNumber.isEmpty() || expiryDate.isEmpty() || cvv.isEmpty()) {
								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setHeaderText("Invalid Card Details");
								alert.setContentText(language.getTextString("errorInvalidCardDetails"));
								alert.showAndWait();
							} else if (!cardNumber.matches("^\\d{16}$")) {

								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setHeaderText("Invalid Card Number");
								alert.setContentText("Please enter a valid 16-digit card number.");
								alert.showAndWait();
							} else if (!expiryDate.matches("^(0[1-9]|1[0-2])/\\d{2}$")) {

								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setContentText("Please enter a valid Expiry Date.");
								alert.showAndWait();
							} else if (!cvv.matches("^\\d{3}$")) {

								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setHeaderText("Invalid CVV");
								alert.setContentText("Please enter a valid CVV number.");
								alert.showAndWait();
							} else if (!validExpiryDate) {
								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setHeaderText("Expired Card");
								alert.setContentText("The entered card has expired. Please use a valid card.");
								alert.showAndWait();
							}

							else if (sum % 10 != 0) {
								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle(language.getTextString("error"));
								alert.setHeaderText("Invalid Card Number");
								alert.setContentText("Please enter a valid card number.");
								alert.showAndWait();
							} else {

								Alert alert = new Alert(Alert.AlertType.INFORMATION);
								alert.setTitle("Payment Confirmation");
								alert.setHeaderText("Payment Successful");

								String contentText = "Payment by Debit/Credit card for " + this.passType
										+ " is successful.\nThank you for using igo TVM.\n\nPlease select your receipt prefernce :";

								Text contentLabel = new Text(30.0, 80.0, contentText);

								Font font4 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30);
								contentLabel.setFont(font4);

								contentLabel.setFill(Color.YELLOW);

								contentLabel.setStrokeWidth(1);

								contentLabel.setStroke(Color.DARKGREEN);

								RadioButton emailRadioButton = new RadioButton("Email Receipt");
								emailRadioButton.setStyle("-fx-font-size: 22px; -fx-text-fill: #ffff00;");
								RadioButton paperRadioButton = new RadioButton("Paper-based Receipt");
								paperRadioButton.setStyle("-fx-font-size: 22px; -fx-text-fill: #ffff00;");

								ToggleGroup receiptToggleGroup = new ToggleGroup();
								emailRadioButton.setToggleGroup(receiptToggleGroup);
								paperRadioButton.setToggleGroup(receiptToggleGroup);

								TextField emailTextField = new TextField();
								emailTextField.setFont(Font.font("Arial", 18));
								emailTextField.setMaxWidth(500);
								emailTextField.setPromptText("Enter email address");

								Button confirmReceiptButton = new Button("Confirm");
								confirmReceiptButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
								confirmReceiptButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
								confirmReceiptButton.setStyle(
										"-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
								confirmReceiptButton.setPrefSize(100, 20);
								confirmReceiptButton.setOnAction(e5 -> {
									String receiptPreference = "";
									if (emailRadioButton.isSelected()) {
										if (emailTextField.getText().isEmpty()) {

											Alert emailAlert = new Alert(Alert.AlertType.ERROR,
													"Please enter your email address.");
											emailAlert.showAndWait();
											return;
										}
										receiptPreference = "Email";
									} else if (paperRadioButton.isSelected()) {
										receiptPreference = "Paper-based ticket";
									}

								});

								VBox contentVBox = new VBox(10);
								contentVBox.setAlignment(Pos.CENTER);
								contentVBox.getChildren().addAll(contentLabel, emailRadioButton, paperRadioButton,
										emailTextField, confirmReceiptButton);

								emailTextField.visibleProperty().bind(emailRadioButton.selectedProperty());

								Image backgroundImageCSB = new Image("SB.png");
								BackgroundSize backgroundSizeCSB = new BackgroundSize(1.0, 1.0, true, true, false,
										false);
								BackgroundImage backgroundImageObjCSB = new BackgroundImage(backgroundImageCSB,
										BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
										backgroundSizeCSB);
								Background backgroundCSB = new Background(backgroundImageObjCSB);
								contentVBox.setBackground(backgroundCSB);
								alert.getDialogPane().setContent(contentVBox);
								alert.getDialogPane().setPrefSize(700, 400);
								alert.showAndWait();

								primaryStage.setScene(mainScene);

							}
						});

						cardDetailsVBox.getChildren().addAll(cardNumberLabel, cardNumberField, expiryDateLabel,
								expiryDateField, cvvLabel, cvvField, confirmCardDetailsButton);

						Image backgroundImageCD = new Image("CD.png");

						BackgroundSize backgroundSizeCD = new BackgroundSize(1.0, 1.0, true, true, false, false);
						BackgroundImage backgroundImageObjCD = new BackgroundImage(backgroundImageCD,
								BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
								backgroundSizeCD);
						Background backgroundCD = new Background(backgroundImageObjCD);
						cardDetailsVBox.setBackground(backgroundCD);

						Scene cardDetailsScene = new Scene(cardDetailsVBox, 1200, 700);
						primaryStage.setScene(cardDetailsScene);
					}

				});

				paymentVBox.getChildren().addAll(paymentLabel, paymentCombo, confirmPaymentButton);

				Image backgroundImagePB = new Image("PB.png");

				BackgroundSize backgroundSizePB = new BackgroundSize(1.0, 1.0, true, true, false, false);
				BackgroundImage backgroundImageObjPB = new BackgroundImage(backgroundImagePB, BackgroundRepeat.REPEAT,
						BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizePB);
				Background backgroundPB = new Background(backgroundImageObjPB);
				paymentVBox.setBackground(backgroundPB);

				Scene paymentScene = new Scene(paymentVBox, 1200, 700);
				primaryStage.setScene(paymentScene);
			});

			rechargeVBox.getChildren().addAll(passTypeLabel, passTypeCombo, confirmPassTypeButton);

			Image backgroundImageRB = new Image("RB.png");

			BackgroundSize backgroundSizeRB = new BackgroundSize(1.0, 1.0, true, true, false, false);
			BackgroundImage backgroundImageObjRB = new BackgroundImage(backgroundImageRB, BackgroundRepeat.REPEAT,
					BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeRB);
			Background backgroundRB = new Background(backgroundImageObjRB);
			rechargeVBox.setBackground(backgroundRB);

			Scene rechargeScene = new Scene(rechargeVBox, 1200, 700);
			primaryStage.setScene(rechargeScene);
		});

	}

	@Override
	public void start(Stage primaryStage) {
		HBox languageBox = new HBox(10);
		languageBox.setAlignment(Pos.BOTTOM_LEFT);

		ComboBox<String> languageCombo = new ComboBox<>();
		languageCombo.getItems().addAll("English", "French");
		languageCombo.setPromptText("English");
		languageBox.getChildren().addAll(languageCombo);
		languageBox.setStyle("");

		rechargeButton = new Button(language.getTextString("recharge"));
		rechargeButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		rechargeButton.setStyle(
				"-fx-background-color: linear-gradient(#439CC1, #43C1B0);\r\n" + "    -fx-background-radius: 30;\r\n"
						+ "    -fx-background-insets: 0;\r\n" + "    -fx-text-fill: white;");
		rechargeButton.setPrefSize(300, 70);

		purchaseButton = new Button(language.getTextString("purchase"));
		purchaseButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		purchaseButton.setStyle("-fx-background-color: #008CBA; -fx-text-fill: white;");
		purchaseButton.setStyle(
				"-fx-background-color: linear-gradient(#439CC1, #43C1B0);\r\n" + "    -fx-background-radius: 30;\r\n"
						+ "    -fx-background-insets: 0;\r\n" + "    -fx-text-fill: white;");
		purchaseButton.setPrefSize(300, 70);

		titleLabel = new Text(30.0, 80.0, language.getTextString("title"));
		Font font = Font.font("Calibry", FontWeight.BOLD, FontPosture.REGULAR, 72);
		titleLabel.setFont(font);
		titleLabel.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, #ffe716 0%, #00aeef 80%);\r\n"
				+ "    -fx-stroke: black;\r\n" + "    -fx-stroke-width: 1;");

		VBox mainVBox = new VBox(10);
		mainVBox.setAlignment(Pos.TOP_CENTER);
		mainVBox.setPadding(new Insets(20, 20, 20, 20));
		mainVBox.getChildren().addAll(titleLabel, languageBox, rechargeButton, purchaseButton);

		Image backgroundImage = new Image("mainScreen.png");
		BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, false, false);
		BackgroundImage backgroundImageObj = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
		Background background = new Background(backgroundImageObj);
		mainVBox.setBackground(background);

		mainScene = new Scene(mainVBox, 1200, 700);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle(language.getTextString(passType));
		primaryStage.show();

		updateDisplay(primaryStage);
		languageCombo.setOnAction(event -> {

			if (languageCombo.getValue().equals("English")) {
				Language.setLanguageType(LanguageEnum.ENGLISH);
				language = Language.getInstance();
				updateDisplay(primaryStage);
			} else if (languageCombo.getValue().equals("French")) {
				System.out.println("FRENCH SELECTED");
				Language.setLanguageType(LanguageEnum.FRENCH);
				language = Language.getInstance();
				updateDisplay(primaryStage);
			}
			System.out.println(language.getClass());

		});

	}

	public static void main(String[] args) {
		IgoTVMApplication.launch(args);
	}
}