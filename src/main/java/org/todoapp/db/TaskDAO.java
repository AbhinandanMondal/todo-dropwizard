package org.todoapp.db;

import io.dropwizard.hibernate.AbstractDAO;


import jakarta.validation.Valid;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.todoapp.core.Task;
import java.util.List;
import jakarta.persistence.Entity;


public class TaskDAO extends AbstractDAO<Task> {



    public TaskDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Task findById(Long id) {
        return get(id);
    }

    public List<Task> findAll() {
        System.out.println("yayahahhaha");
        Query<Task> query = currentSession().createQuery("FROM Task", Task.class);
        return query.list();
    }

    public Task create(@Valid Task task) {
        System.out.println("Yaha pe create ho raha");
//        currentSession().persist(task);
        return persist(task);
    }

    public Task update(Task task) {
        return persist(task);
    }

    public void delete(Task task) {
        currentSession().delete(task);
    }
}



