package com.api.customersupport.services;

import com.api.customersupport.models.OrderServiceModel;
import com.api.customersupport.models.ResolverModel;
import com.api.customersupport.repositorys.OrderServiceRepository;
import com.api.customersupport.repositorys.ResolverRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ResolverService.class})
@ExtendWith(SpringExtension.class)
class ResolverModelServiceTest {
    @MockBean
    private OrderServiceRepository orderServiceRepository;

    @MockBean
    private ResolverRepository resolverRepository;

    @Autowired
    private ResolverService resolverService;

    @Test
    void testReturnAllResolversOrdered2() {
        ResolverModel resolverModel = new ResolverModel();
        resolverModel.setId(123L);
        resolverModel.setName("(Ontem)");

        ArrayList<ResolverModel> resolverModelList = new ArrayList<>();
        resolverModelList.add(resolverModel);
        when(this.resolverRepository.findAll()).thenReturn(resolverModelList);

        ResolverModel resolverModel1 = new ResolverModel();
        resolverModel1.setId(123L);
        resolverModel1.setName("Name");

        OrderServiceModel orderServiceModel = new OrderServiceModel();
        orderServiceModel.setData("Data");
        orderServiceModel.setDayDescription("Day Description");
        orderServiceModel.setDayOfWeek("Day Of Week");
        orderServiceModel.setResolver(resolverModel1);
        when(this.orderServiceRepository.save((OrderServiceModel) any())).thenReturn(orderServiceModel);
        when(this.orderServiceRepository.findAll()).thenReturn(new ArrayList<>());
        doNothing().when(this.orderServiceRepository).deleteAll();
        assertEquals("{\"lista\":[]}", this.resolverService.returnAllResolversOrdered());
        verify(this.resolverRepository).findAll();
        verify(this.orderServiceRepository, atLeast(1)).save((OrderServiceModel) any());
        verify(this.orderServiceRepository).findAll();
        verify(this.orderServiceRepository).deleteAll();
    }

    @Test
    void testReturnAllResolversOrdered3() {
        ResolverModel resolverModel = new ResolverModel();
        resolverModel.setId(123L);
        resolverModel.setName("(Ontem)");

        ResolverModel resolverModel1 = new ResolverModel();
        resolverModel1.setId(123L);
        resolverModel1.setName("(Ontem)");

        ArrayList<ResolverModel> resolverModelList = new ArrayList<>();
        resolverModelList.add(resolverModel1);
        resolverModelList.add(resolverModel);
        when(this.resolverRepository.findAll()).thenReturn(resolverModelList);

        ResolverModel resolverModel2 = new ResolverModel();
        resolverModel2.setId(123L);
        resolverModel2.setName("Name");

        OrderServiceModel orderServiceModel = new OrderServiceModel();
        orderServiceModel.setData("Data");
        orderServiceModel.setDayDescription("Day Description");
        orderServiceModel.setDayOfWeek("Day Of Week");
        orderServiceModel.setResolver(resolverModel2);
        when(this.orderServiceRepository.save((OrderServiceModel) any())).thenReturn(orderServiceModel);
        when(this.orderServiceRepository.findAll()).thenReturn(new ArrayList<>());
        doNothing().when(this.orderServiceRepository).deleteAll();
        assertEquals("{\"lista\":[]}", this.resolverService.returnAllResolversOrdered());
        verify(this.resolverRepository).findAll();
        verify(this.orderServiceRepository, atLeast(1)).save((OrderServiceModel) any());
        verify(this.orderServiceRepository).findAll();
        verify(this.orderServiceRepository).deleteAll();
    }

    @Test
    void testFindAll() {
        PageImpl<ResolverModel> pageImpl = new PageImpl<>(new ArrayList<>());
        when(this.resolverRepository.findAll((org.springframework.data.domain.Pageable) any())).thenReturn(pageImpl);
        Page<ResolverModel> actualFindAllResult = this.resolverService.findAll(null);
        assertSame(pageImpl, actualFindAllResult);
        assertTrue(actualFindAllResult.toList().isEmpty());
        verify(this.resolverRepository).findAll((org.springframework.data.domain.Pageable) any());
    }
}

