package com.api.customersupport.repositorys;

import com.api.customersupport.models.OrderServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderServiceRepository extends JpaRepository<OrderServiceModel, Long> {
}
