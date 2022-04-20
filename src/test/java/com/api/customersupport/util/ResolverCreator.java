package com.api.customersupport.util;

import com.api.customersupport.models.ResolverModel;

public class ResolverCreator {

    public static ResolverModel createdValidStudent() {
        ResolverModel resolverModel = new ResolverModel();
        resolverModel.setId(1L);
        resolverModel.setName("Marcelo");
        return resolverModel;
    }
}
