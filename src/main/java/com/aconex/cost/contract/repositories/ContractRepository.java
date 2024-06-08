package com.aconex.cost.contract.repositories;

import com.aconex.cost.contract.models.Contract;
import org.hibernate.SessionFactory;

import java.util.List;

public class ContractRepository {

    private final SessionFactory sessionFactory;

    public ContractRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Contract> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Contract order by code", Contract.class)
                .list();
    }
}
