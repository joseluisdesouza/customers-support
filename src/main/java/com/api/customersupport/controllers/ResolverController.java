package com.api.customersupport.controllers;

import com.api.customersupport.models.ResolverModel;
import com.api.customersupport.repositorys.OrderServiceRepository;
import com.api.customersupport.repositorys.ResolverRepository;
import com.api.customersupport.services.ResolverService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resolvers")
@Api(value = "API REST CUSTOMER SUPPORT")
public class ResolverController {

    @Autowired
    private ResolverRepository resolverRepository;
    @Autowired
    private OrderServiceRepository orderServiceRepository;
    @Autowired
    private ResolverService resolverService;

    @GetMapping("im-day")
    @Operation(summary = "Returning resolvers ordered",
            responses = {@ApiResponse(responseCode = "200",
                    description = "Resource successfully retrieved",
                    content = @Content(schema = @Schema(implementation = ResolverModel.class)))})
    public String orderedSearch() {
        return resolverService.returnAllResolversOrdered();
    }

    @GetMapping()
    @Operation(summary = "Returning all resolvers that are in the database",
            responses = {@ApiResponse(responseCode = "200",
                    description = "Resource successfully retrieved",
                    content = @Content(schema = @Schema(implementation = ResolverModel.class)))})
    public Page<ResolverModel> findAllPaginated(Pageable pageable) {
        return resolverService.findAll(pageable);
    }
}
