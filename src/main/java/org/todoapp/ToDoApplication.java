package org.todoapp;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import org.todoapp.ToDoAppConfiguration.TodoAppConfiguration;
import org.todoapp.core.Task;
import org.todoapp.db.TaskDAO;
import org.todoapp.resources.TaskResource;



public class ToDoApplication extends Application<TodoAppConfiguration> {


    public static void main(String[] args) throws Exception {
        new ToDoApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<TodoAppConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);

    }

    @Override
    public void run(TodoAppConfiguration configuration, Environment environment) throws Exception {
        // Register the HelloWorldResource

        TaskDAO taskDAO = new TaskDAO(hibernateBundle.getSessionFactory());
        TaskResource taskResource = new TaskResource(taskDAO);
        environment.jersey().register(taskResource);


//        TaskDAO taskDAO = new TaskDAO(hibernateBundle.getSessionFactory());
//        TaskResource taskResource = new TaskResource(taskDAO);
//        environment.jersey().register(taskResource);

//        TaskDAO taskDAO = new TaskDAO(hibernateBundle.getSessionFactory);
//        environment.jersey().register(new TaskResource(TaskDAO));

        // Add other configurations, health checks, etc.
    }
    HibernateBundle<TodoAppConfiguration> hibernateBundle = new HibernateBundle<TodoAppConfiguration>(Task.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(TodoAppConfiguration todoAppConfiguration) {
            return todoAppConfiguration.getDataSourceFactory();
        }
    };


}

