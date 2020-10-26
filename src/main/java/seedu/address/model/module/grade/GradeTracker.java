package seedu.address.model.module.grade;

import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import seedu.address.model.contact.Contact;
import seedu.address.model.module.grade.comparator.AssignmentNameComparator;
import seedu.address.model.task.Task;
import seedu.address.model.task.UniqueTodoList;
import seedu.address.model.task.comparator.TaskNameComparator;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an association class that tracks the assignments and grade for a module.
 */
public class GradeTracker implements ReadOnlyGradeTracker{
    public static final String MESSAGE_INVALID_GRADE =
            "Grades should be provided in the range from 0.00 to 1.00.";
    public static final String MESSAGE_DUPLICATE_ASSIGNMENT =
            "Assignments cannot be repeated.";

    private final UniqueAssignmentList assignments;
    private final AssignmentNameComparator comparator = new AssignmentNameComparator();
    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        assignments = new UniqueAssignmentList();
    }
    private Grade grade;

    /**
     * Creates a GradeTracker that stores the assignments and grades for a module.
     */
    public GradeTracker() {
        this.grade = new Grade(0);
    }

    public void setGrade(Grade newGrade) {
        this.grade = newGrade;
    }

    public Grade getGrade() {
        return grade;
    }

    public void addAssignment(Assignment newAssignment) {
        assignments.add(newAssignment);
    }

    /**
     * Removes {@code key} from this {@code assignments}.
     * {@code key} must exist in the assignments.
     */
    public void removeAssignment(Assignment key) {
        assignments.remove(key);
    }

    public List<Assignment> getSortedAssignments() {
        List<Assignment> sortedAssignments = new SortedList<Assignment>(assignments
                .asUnmodifiableObservableList(), comparator);
        return sortedAssignments;
    }

    @Override
    public ObservableList<Assignment> getAssignments() {
        return assignments.asUnmodifiableObservableList();
    }

    /**
     * Checks if the Grade Tracker is valid.
     *
     * @param gradeTracker grade tracker to check.
     * @return true if the grade tracker is valid.
     */
    public static boolean isValidGradeTracker(GradeTracker gradeTracker) {
        boolean areAssignmentsValid = true;
        for (Assignment eachAssignment: gradeTracker.assignments) {
            if (!Assignment.isValidAssignmentResult(eachAssignment.assignmentResult)
                    && Assignment.isValidAssignmentName(eachAssignment.assignmentName)
                    && Assignment.isValidAssignmentPercentage(eachAssignment.assignmentPercentage)) {
                areAssignmentsValid = false;
                break;
            }
        }
        if (Grade.isValidGrade(gradeTracker.grade.gradeResult) && areAssignmentsValid) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks for duplicated assignments in the module.
     *
     * @param otherAssignment the assignment being checked.
     * @return true if the assignment already exists
     */
    public boolean isDuplicateAssignment(Assignment otherAssignment) {
        for (Assignment eachAssignment : assignments) {
            if (eachAssignment.equals(otherAssignment)) {
                return true;
            }
        }
        return false;
    }
}
