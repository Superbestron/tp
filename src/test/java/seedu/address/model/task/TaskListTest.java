package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalTasks.APPLY_LEAVE;
import static seedu.address.testutil.TypicalTasks.DO_PAPERWORK;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TaskListTest {
    private final TaskList taskList = new TaskList();

    @Test
    public void contains_nullTask_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> taskList.contains(null));
    }

    @Test
    public void has_taskNotInList_returnsFalse() {
        assertFalse(taskList.contains(APPLY_LEAVE));
    }

    @Test
    public void contains_taskInList_returnsTrue() {
        taskList.add(APPLY_LEAVE);
        assertTrue(taskList.contains(APPLY_LEAVE));
    }

    @Test
    public void add_nullTask_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> taskList.add(null));
    }


    @Test
    public void setPersons_nullUniquePersonList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> taskList.setTasks((TaskList) null));
    }

    @Test
    public void setPersons_uniquePersonList_replacesOwnListWithProvidedUniquePersonList() {
        taskList.add(APPLY_LEAVE);
        TaskList expectedTaskList = new TaskList();
        expectedTaskList.add(DO_PAPERWORK);
        taskList.setTasks(expectedTaskList);
        assertEquals(expectedTaskList, taskList);
    }

    @Test
    public void setTasks_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> taskList.setTasks((List<Task>) null));
    }

    @Test
    public void setTasks_list_replacesOwnListWithProvidedList() {
        taskList.add(APPLY_LEAVE);
        List<Task> tList = Collections.singletonList(DO_PAPERWORK);
        taskList.setTasks(tList);
        TaskList expectedTaskList = new TaskList();
        expectedTaskList.add(DO_PAPERWORK);
        assertEquals(expectedTaskList, taskList);
    }
}