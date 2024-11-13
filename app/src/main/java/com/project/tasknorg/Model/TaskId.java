package com.project.tasknorg.Model;

import androidx.annotation.NonNull;

import com.google.firebase.firestore.Exclude;

public class TaskId {
    @Exclude
    public String TaskId; // excludes the task id from all manipulations of data

    public <T extends TaskId> T withId(@NonNull final String id) {
        this.TaskId = id;
        return (T)this;
    }
}
