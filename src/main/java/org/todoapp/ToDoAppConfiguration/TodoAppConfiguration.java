package org.todoapp.ToDoAppConfiguration;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.core.Configuration;
import io.dropwizard.db.DataSourceFactory;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TodoAppConfiguration extends Configuration {

    private DataSourceFactory dataSourceFactory;

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory(){
        if(Objects.isNull(dataSourceFactory))
            dataSourceFactory = new DataSourceFactory();
        return dataSourceFactory;
    }

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }
}
