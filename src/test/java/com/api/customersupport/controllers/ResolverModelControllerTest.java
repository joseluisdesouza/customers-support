package com.api.customersupport.controllers;

import static com.api.customersupport.util.ResolverCreator.createdValidStudent;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.api.customersupport.models.ResolverModel;
import com.api.customersupport.repositorys.OrderServiceRepository;
import com.api.customersupport.repositorys.ResolverRepository;
import com.api.customersupport.services.ResolverService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@ContextConfiguration(classes = {ResolverController.class})
@ExtendWith(SpringExtension.class)
class ResolverModelControllerTest {
    @MockBean
    private OrderServiceRepository orderServiceRepository;

    @Autowired
    private ResolverController resolverController;

    @MockBean
    private ResolverRepository resolverRepository;

    @MockBean
    private ResolverService resolverService;

    @Test
    @DisplayName("List returns list of resolvers inside page object when successful")
    void list_ReturnsListOfResolversInsidePageObject_WhenSuccessful() {
        String expected = createdValidStudent().getName();
        PageImpl<ResolverModel> studentPage = new PageImpl<>(List.of(createdValidStudent()));
        when(resolverService.findAll(any()))
                .thenReturn(studentPage);
        Page<ResolverModel> resolverPage = resolverController.findAllPaginated(studentPage.getPageable());
        org.assertj.core.api.Assertions.assertThat(resolverPage).isNotNull();
        org.assertj.core.api.Assertions.assertThat(resolverPage.toList())
                .isNotEmpty()
                .hasSize(1);
        org.assertj.core.api.Assertions.assertThat(resolverPage.toList()
                .get(0)
                .getName())
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("List returns the list of resolvers sorted by days to resolve incidents")
    void list_ReturnsTheList_Of_Resolvers_SortedByDays_To_Resolve_Incidents() throws Exception {
        when(this.resolverService.returnAllResolversOrdered()).thenReturn("Return All Resolvers Ordered");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/resolvers/im-day");
        MockMvcBuilders.standaloneSetup(this.resolverController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Return All Resolvers Ordered"));
    }
}

