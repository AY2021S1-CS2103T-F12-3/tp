package seedu.address.ui;

import static javafx.collections.FXCollections.observableList;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.logic.commands.ViewCommandResult;

public class DetailDisplay extends UiPart<Region> {

    private static final String FXML = "DetailsDisplay.fxml";
    private static final int SMALL_DETAILS_CARD_INDEX = 0;

    private ModuleSmallDetailsCard smallDetailsPanel;

    private ZoomLinkPanel zoomLinkPanel;

    private AssignmentPanel assignmentPanel;

    @FXML
    private Pane smallDetailsPlaceHolder;

    @FXML
    private StackPane listPlaceholder;

    @FXML
    private StackPane assignmentListPlaceHolder;

    public DetailDisplay() {
        super(FXML);
    }

    public void setDisplay(ViewCommandResult result) {
        resultDisplay.setText(result.getTextArea());

        zoomLinkPanel = new ZoomLinkPanel(observableList(result.getZoomLinks()));
        smallDetailsPanel = new ModuleSmallDetailsCard(result.getModule());
        if (!smallDetailsPlaceHolder.getChildren().isEmpty()) {
            smallDetailsPlaceHolder.getChildren().remove(SMALL_DETAILS_CARD_INDEX);
        }
        smallDetailsPlaceHolder.getChildren().add(smallDetailsPanel.getRoot());
        listPlaceholder.getChildren().add(zoomLinkPanel.getRoot());
        assignmentPanel = new AssignmentPanel(FXCollections.observableArrayList(result.getAssignments()));
        assignmentListPlaceHolder.getChildren().add(assignmentPanel.getRoot());
    }

}
