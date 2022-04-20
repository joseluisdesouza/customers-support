package com.api.customersupport.params;

import com.api.customersupport.models.OrderServiceModel;
import com.api.customersupport.models.ResolverModel;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomerSupportGeneric {

    Calendar calendar;
    OrderServiceModel orderServiceModel;
    ArrayList<ResolverModel> resolverModelArrayList;
    ResolverModel resolverModel;
    String dayDescription;

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public OrderServiceModel getOrderService() {
        return orderServiceModel;
    }

    public void setOrderService(OrderServiceModel orderServiceModel) {
        this.orderServiceModel = orderServiceModel;
    }

    public ArrayList<ResolverModel> getResolverArrayList() {
        return resolverModelArrayList;
    }

    public void setResolverArrayList(ArrayList<ResolverModel> resolverModelArrayList) {
        this.resolverModelArrayList = resolverModelArrayList;
    }

    public ResolverModel getResolver() {
        return resolverModel;
    }

    public void setResolver(ResolverModel resolverModel) {
        this.resolverModel = resolverModel;
    }

    public String getDayDescription() {
        return dayDescription;
    }

    public void setDayDescription(String dayDescription) {
        this.dayDescription = dayDescription;
    }
}
