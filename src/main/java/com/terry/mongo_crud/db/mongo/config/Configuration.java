package com.terry.mongo_crud.db.mongo.config;

import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@org.springframework.context.annotation.Configuration
public class Configuration extends AbstractMongoClientConfiguration
{
    @Override
    protected String getDatabaseName() {
        return "mongo_crud_terry";
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
