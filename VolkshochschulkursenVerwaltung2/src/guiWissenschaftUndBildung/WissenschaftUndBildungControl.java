package guiWissenschaftUndBildung;

import business.KursModel;
import javafx.stage.Stage;

public class WissenschaftUndBildungControl {
	private WissenschaftUndBildungView wissenschaftUndBildungView;
	private KursModel volkshochschulkurseModel;

	public WissenschaftUndBildungControl(Stage primaryStage) {
		this.volkshochschulkurseModel = KursModel.getInstance();
		this.wissenschaftUndBildungView = new WissenschaftUndBildungView(this, primaryStage, volkshochschulkurseModel);
	}
}
