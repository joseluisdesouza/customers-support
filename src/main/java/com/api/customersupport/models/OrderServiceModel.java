package com.api.customersupport.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderServiceModel {

    @Id
    private String data;

    private String dayOfWeek;

    private String dayDescription;

    @ManyToOne
    @JoinColumn(name = "resolvers_id")
    private ResolverModel resolverModel;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDayDescription() {
        return dayDescription;
    }

    public void setDayDescription(String dayDescription) {
        this.dayDescription = dayDescription;
    }

    public ResolverModel getResolver() {
        return resolverModel;
    }

    public void setResolver(ResolverModel resolverModel) {
        this.resolverModel = resolverModel;
    }
}
