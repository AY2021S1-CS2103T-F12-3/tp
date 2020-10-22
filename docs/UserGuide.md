---
layout: page
title: User Guide
---

Cap 5.0 Buddy helps NUS SoC students to keep track of their module details efficiently. It helps them centralize key module details and follows their study progress through a Command Line Interface (CLI) that allows efficient management of module details.

1. [Quick Start](#quick-start)
2. [Features](#features)
    1. Module Tracker
        1. [Adding a module](#adding-a-new-module-add-module) : `addmodule`
        2. [Viewing a module](#viewing-a-module-view) : `viewmodule`
        3. [Adding a zoom link to a module](#adding-a-zoom-link-to-a-module-add-zoom) : `addzoomlink`
        4. [Deleting a module](#deleting-a-module-delete) : `deletemodule`
        5. [Editing a module](#editing-a-module--edit-zoom) : `editmodule`
    2. Grade Tracker
    3. CAP Calculator
    4. Contact List
    5. Todo List
        1. [Adding a task](#adding-a-task) : `addtask`
        2. [Deleting a task](#deleting-a-task) : `deletetask`
        3. [Editing a task](#editing-a-task) : `edittask`
        4. [Finding a task](#finding-a-task) : `findtask`
        5. [Marking a task as completed](#marking-a-task-as-completed) : `complete`
        6. [Resetting a task](#resetting-a-task) : `resettask`
        6. [Sorting tasks](#sorting-tasks) : `sorttask`
        7. [Filtering tasks](#filtering-tasks) : `filtertask`
        8. [Archiving a task](#archiving-a-task) : `archivetask`
        9. [Clearing the list](#clearing-the-list) : `clear`
    6. Scheduler
3. [FAQ](#faq)
4. [Command Summary](#command-summary)

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `cap5buddy.jar` from [here](https://github.com/AY2021S1-CS2103T-F12-3/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ Cap 5 Buddy application.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/OriginalImages/Ui.png)

--------------------------------------------------------------------------------------------------------------------

## Features

### Module Tracker

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.


</div>

#### Adding a new module: `add module`

Creates and add a new module to be stored in the system.

  Format: `add module` **_`[MODULE_NAME]`_** **_`[ZOOM_LINK]`_**

   * Leaving the **_ZOOM_LINK_** part empty will create a empty module.

   Examples:
   * `add module CS2103T https:\\link` creates and add the module called CS2103T
   with the specified link into the system.
   * `add module CS2103T` creates and add the module CS2103T with no zoom link.

### Viewing a module: `viewmodule`

Views a module stored in the system

 Format: `viewmodule` **_`n/[MODULE_NAME]`_**

  * Views information for a module named **_`[MODULE_NAME]`_**

  Examples:
   * `viewmodule n/cs2103t` views the specified module

#### Adding a zoom link to a module: `add zoom`

  Adds a zoom link to an existing module.

  Format: `add zoom` **_`[MODULE_NAME]`_** **_`[ZOOM_LINK]`_**

  * Adds a zoom link [ZOOM_LINK] to a module named **_`[MODULE_NAME]`_**

  Example of usage:
  `add zoom cs2103T https://sample.zoom.us` adds a zoom link `https://sample.zoom.us` to the module named `cs2103T`

### Deleting a module: `deletemodule`

Deletes the module at the specified position in the module list.

 Format: `delete` **_`[MODULE_POSITION]`_**

  Examples:
  * `deletemodule 1` deletes the module at position `1`

#### Editing a module: `edit zoom`

* Edits an existing module in the module list.

Format: `edit zoom` **_`[MODULE_NAME]`_** **_`[ZOOM_LINK]`_**

* Edits the zoom link of a module named **_`[MODULE_NAME]`_** to **_`[ZOOM_LINK]`_**

Examples:
* `edit zoom CS2030 https://sample.zoom.us` edits the zoom link for a module named `CS2030`
  to `https://sample.zoom.us`
 
### Adding assignment to a module: `addassignment`

  Adds an assignment that takes up a percentage of the grade and has a result from 0.00 to 1.00 to an existing module.

  Format: `addassignment` **_`n/[MODULE_NAME]`_** **_`a/[ASSIGNMENT_NAME]`_**
  **_`%/[ASSIGNMENT_PERCENTAGE]`_** **_`r/[ASSIGNMENT_RESULT]`_**

  * Adds an assignment **_`[ASSIGNMENT_NAME]`_** that takes up **_`[ASSIGNMENT_PERCENTAGE]`_**
  of the grade with a result of **_`[ASSIGMENT_RESULT]`_** to a module named **_`[MODULE_NAME]`_**

  Example of usage:
  `addassignment n/CS2100 a/Quiz 1 %/5 r/0.80` adds an assignment called `Quiz 1` that takes up `5`% of the
  grade with a result of `0.80` to the module named `CS2100`


### Contact List


### Todo List

#### Adding a task: `addtask`

Adds a task to the list.

Format: `addtask` **_`[n/TASK_NAME]`_** **_`[t/TAG]`_** **_`[p/PRIORITY]`_** **_`[d/DATE]`_**

* All fields except the name of the task are optional.
* Name of the task should not be longer than 30 characters.
* You can provide more than one tag.
* Date must be in the form of YYYY-MM-DD.

Examples: 
* `addtask n/read book t/DAILY HOBBY p/low d/2020-10-10` adds the specified task.

#### Deleting a task: `deletetask`

Deletes a task from the list.

Format: `deletetask` **_`INDEX`_**

* See index from the list.
* Index must be a positive integer.

Examples:
* `deletetask 1` deletes the first task in the list.

#### Editing a task: `edittask`

Edits a task in the list.

Format: `edittask` `INDEX` **_`[n/TASK_NAME]`_** **_`[t/TAG]`_** **_`[p/PRIORITY]`_** **_`[d/DATE]`_**

* See index from the list.
* Index must be a positive integer.
* At least one field must not be empty.

Examples:
* `edittask 1 n/read chapter 5 p/HIGH` edits the first task name to `read chapter 5` and
and priority to `HIGH`.

#### Finding a task: `findtask`

Finds a task based on keywords.

Format: `findtask` **_`[KEYWORD]`_**

Examples:
* `findtask` **_`[k/KEYWORD]`_** list all the task that matches the keyword.

#### Marking a task as completed: `completetask`

Labels a task as COMPLETED.

Format: `completetask` **_`INDEX`_**

* See index from the list.
* Index must be a positive integer.

Examples:
* `completetask 1` label first task in the list as completed.

#### Resetting a task: `resettask`

Reset the status of a task back to NOT COMPLETED.

Format: `resettask` **_`INDEX`_**

* See index from the list.
* Index must be a positive integer.

Examples:
* `resettask 2` reset the second task in the list.

#### Sorting tasks: `sorttask`

Sorts the list based on a criterion.

Format: `sorttask` **_`[REVERSED]`_** **_`[CRITERION]`_**

* **_`[REVERSED]`_** is a signle character 'r'.
* Add **_`[REVERSED]`_** to reverse the ordering of the list.
* **_`[CRITERION]`_** is pre-defined i.e. choose from `NAME`, `PRIORITY`, `DATE`.
* **_`[CRITERION]`_** is not case-sensitive.

Examples:
* `sorrtask priority` sorts the task from lowest to highest priority.
* `sorrtask r priority` sorts the task from the highest to the lowest.

#### Filtering tasks: `filtertask`

Filters the list based on a criterion.

Format: `filtertask` + **_`[CRITERION]`_** + **_`[KEYWORD]`_**

Examples:
* `filtertask priority high` shows only tasks that has high priority.

#### Archiving a task: `archivetask`

Archives a task from the list.

Format: `archivetask` **_`INDEX`_**

* See index from the list.
* Index must be a positive integer.

Examples: `archivetask 1` archive the first task.

#### Clearing the list: `cleartask`

Clears all tasks in the list.

Format: `cleartask`

### Scheduler

### Calculating Cumulative Average Point(CAP): `calculatecap`

Calculates the user's CAP based on completed modules

 Format: `calculatecap`

  Examples:
  * `calculatecap` calculate the user's cap

### Undo previous user command: `undo`

Undoes the previous user command

 Format: `undo`

  Examples:
  * `undo`

### Undo previous user command: `redo`

Redoes the previously undone user command

 Format: `redo`

  Examples:
  * `redo`

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do you add a module into the program?<br>
**A**: Run the program and wait for the terminal to start up. Next, type in : “add module [CS2103T]” to add a module called CS2103T.

**Q**: How do you view the zoom links of a particular module?<br>
**A**: When the program has started running, enter the following in the terminal : “view [CS2103T]” to view the zoom link for the module called CS2103T.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add module KEYWORD`<br> e.g. `add module CS2103T [link]`, `add module CS2103T`
**View** | `view KEYWORD `<br> e.g. `view cs2101` , `view all`
**Delete** | `delete KEYWORD `<br> e.g. `delete 3`
**Edit** | `edit zoom MODULE_NAME ZOOM_LINK`<br> e.g. `edit zoom CS2103T https://sample.zoom.us`
**Add Zoom** | `add zoom MODULE_NAME ZOOM_LINK` <br> e.g. `add zoom cs2103T https://sample.zoom.us`
**Calculate CAP** | `calculatecap` <br> e.g. `calculatecap`
**Undo** | `undo` <br> e.g. `undo`
**Redo** | `redo` <br> e.g. `redo`
