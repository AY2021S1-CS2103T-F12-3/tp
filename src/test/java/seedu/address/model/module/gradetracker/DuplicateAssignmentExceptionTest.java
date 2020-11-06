package seedu.address.model.module.gradetracker;

import org.junit.jupiter.api.Test;
import seedu.address.model.module.grade.GradeTracker;
import seedu.address.model.module.grade.exceptions.AssignmentNotFoundException;
import seedu.address.model.module.grade.exceptions.DuplicateAssignmentException;

import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalAssignments.LAB_1;
import static seedu.address.testutil.TypicalAssignments.QUIZ_2;

public class DuplicateAssignmentExceptionTest {

    @Test
    void execute_addAssignment_throwsDuplicateAssignmentException() {
        GradeTracker gradeTracker = new GradeTracker();
        gradeTracker.addAssignment(QUIZ_2);
        assertThrows(DuplicateAssignmentException.class, () -> gradeTracker.addAssignment(QUIZ_2));
    }

}
