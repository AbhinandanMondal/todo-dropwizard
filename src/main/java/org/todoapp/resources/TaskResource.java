package org.todoapp.resources;

import io.dropwizard.hibernate.UnitOfWork;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import org.todoapp.core.Task;
import org.todoapp.db.TaskDAO;


import java.util.List;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    private final TaskDAO taskDAO;

    public TaskResource(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Task getTask(@PathParam("id") Long id) {
        return taskDAO.findById(id);
    }

    @GET
    @UnitOfWork
    public List<Task> getAllTasks() {
        System.out.println("hshhsshshsfkjhkhgkghfkhkhdf");
        return taskDAO.findAll();
    }

    @POST
    @Path("/new")
    @UnitOfWork
    public Task createTask(Task task) {
        System.out.println("hshhsshshsfkjhkhgkghfkhkhdf");
        return taskDAO.create(task);
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    public Task updateTask(@PathParam("id") Integer id, Task task) {
        task.setId(id);
        return taskDAO.update(task);
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void deleteTask(@PathParam("id") Long id) {
        Task task = taskDAO.findById(id);
        if (task != null) {
            taskDAO.delete(task);
        }
    }
    @GET
    @Path("/tasks")
    public String hello()
    {
        return ("hello WOrd");

    }
}
