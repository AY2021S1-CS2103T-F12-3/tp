package seedu.address.testutil;

/*
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
*/
import static seedu.address.logic.commands.CommandTestUtil.VALID_MODULENAME_CS2103T;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ZOOMLINK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.ModuleList;
import seedu.address.model.module.Module;

/**
 * A utility class containing a list of {@code Module} objects to be used in tests.
 */
public class TypicalModules {

    public static final Module CS2030 = new ModuleBuilder().withName("CS2030")
        .withZoomLink("www.zoom.us").build();
    public static final Module CS2101 = new ModuleBuilder().withName("CS2101")
        .withZoomLink("www.zoom.us").build();
    public static final Module CS2105 = new ModuleBuilder().withName("CS2105")
        .withZoomLink("www.zoom.us").build();
    public static final Module CS1101S = new ModuleBuilder().withName("CS1101S")
        .withZoomLink("www.zoom.us").build();
    public static final Module IS1103 = new ModuleBuilder().withName("IS1103")
        .withZoomLink("www.zoom.us").build();

    // Manually added
    public static final Module CS1231S = new ModuleBuilder().withName("CS1231S")
        .withZoomLink("www.zoom.us").build();
    public static final Module MA1101R = new ModuleBuilder().withName("MA1101R")
        .withZoomLink("www.zoom.us").build();

    // Manually added - Modules's details found in {@code CommandTestUtil}
    public static final Module CS2103T = new ModuleBuilder().withName(VALID_MODULENAME_CS2103T)
        .withZoomLink(VALID_ZOOMLINK).build();
    /*
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB)
        .withEmail(VALID_EMAIL_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
        .build();
    */

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalModules() {} // prevents instantiation

    /**
     * Returns an {@code ModuleList} with all the typical modules.
     */
    public static ModuleList getTypicalModuleList() {
        ModuleList moduleList = new ModuleList();
        for (Module module : getTypicalModules()) {
            moduleList.addModule(module);
        }
        return moduleList;
    }

    public static List<Module> getTypicalModules() {
        return new ArrayList<>(Arrays.asList(CS2030, CS2101, CS2105, CS1101S, IS1103));
    }
}
