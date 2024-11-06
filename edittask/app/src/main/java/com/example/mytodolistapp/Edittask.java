import android.content.Context;
import android.os.Bundle;

public Context getContext(){
    return activity;
}
public void edit(int position){
    ToDoModel toDoModel = todolist.get(position);

    Bundle bundle = new BUNDLE();
    bundle.putstring("task",toDoModel.getTask());
    bundle.putstring("due",toDoModel.getDue());
    bundle.putstring("id",toDoModel.Taskid());

    AddNewTask addNewTask = new AddNewTask();
    AddNewTask.setArgument("bundle");
    AddNewTask.show(activity.getSupportFragmentManager(),addNewTask.getTag());
}