package com.api.customersupport.services;

import com.api.customersupport.models.OrderServiceModel;
import com.api.customersupport.models.ResolverModel;
import com.api.customersupport.params.CustomerSupportGeneric;
import com.api.customersupport.repositorys.OrderServiceRepository;
import com.api.customersupport.repositorys.ResolverRepository;
import com.api.customersupport.util.Util;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;

@Service
public class ResolverService {

    @Autowired
    private ResolverRepository resolverRepository;
    @Autowired
    private OrderServiceRepository orderServiceRepository;

    public String returnAllResolversOrdered() {
        CustomerSupportGeneric customerSupportGeneric = new CustomerSupportGeneric();
        int arrayLimit;
        int iContAux = 0;

        customerSupportGeneric.setCalendar(Calendar.getInstance());

        orderServiceRepository.deleteAll();

        customerSupportGeneric.setResolverArrayList(new ArrayList<>(resolverRepository.findAll()));

        arrayLimit = customerSupportGeneric.getResolverArrayList().size() - 1;

        customerSupportGeneric.getCalendar().add(Calendar.DAY_OF_WEEK, -1);

        searchDays(customerSupportGeneric, arrayLimit, iContAux);

        JSONObject jSONObject = getJsonObject();

        return jSONObject.toString();
    }

    private void searchDays(CustomerSupportGeneric customerSupportGeneric, int arrayLimit, int iContAux) {
        for (int x = 1; x <= 11; x++) {
            if (x == 1) {
                customerSupportGeneric.setDayDescription("(Ontem)");
            } else if (x == 2) {
                customerSupportGeneric.setDayDescription("(Hoje)");
            } else if (x == 3) {
                customerSupportGeneric.setDayDescription("(Amanha)");
            } else {
                customerSupportGeneric.setDayDescription("");
            }

            iContAux = validationForWeekends(customerSupportGeneric, arrayLimit, iContAux);

            instanceObject(customerSupportGeneric);

            customerSupportGeneric.getCalendar().add(Calendar.DAY_OF_WEEK, 1);

            customerSupportGeneric.setResolver(null);
        }
    }

    private int validationForWeekends(CustomerSupportGeneric customerSupportGeneric, int arrayLimit, int iContAux) {
        if (!Util.isWeekend(customerSupportGeneric.getCalendar())) {
            customerSupportGeneric.setResolver(customerSupportGeneric.getResolverArrayList().get(iContAux));

            if (iContAux == arrayLimit) {
                iContAux = 0;
            } else {
                iContAux++;
            }
        }
        return iContAux;
    }

    private void instanceObject(CustomerSupportGeneric customerSupportGeneric) {
        OrderServiceModel orderServiceModel = new OrderServiceModel();
        OrderServiceModel orderServiceModel1;
        orderServiceModel1 = orderServiceModel;

        orderServiceModel1.setData(Util.parseData(customerSupportGeneric.getCalendar(), "dd/MM/yyyy"));
        orderServiceModel1.setDayOfWeek(Util.getDayOfWeek(customerSupportGeneric.getCalendar()));
        orderServiceModel1.setDayDescription(orderServiceModel1.getDayDescription());
        orderServiceModel1.setResolver(customerSupportGeneric.getResolver());

        orderServiceRepository.save(orderServiceModel1);
    }

    private JSONObject getJsonObject() {
        JSONArray jSONArray = new JSONArray(new Gson().toJson(orderServiceRepository.findAll()));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("lista", jSONArray);
        return jSONObject;
    }

    public Page<ResolverModel> findAll(Pageable pageable) {
        return resolverRepository.findAll(pageable);
    }
}
