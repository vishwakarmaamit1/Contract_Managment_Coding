package com.aconex.cost.contract.repositories;


import com.aconex.cost.contract.models.Contract;
import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DropwizardExtensionsSupport.class)
public class ContractRepositoryTest {

    private final DAOTestExtension database = DAOTestExtension.newBuilder().addEntityClass(Contract.class).build();

    private ContractRepository contractRepository;

    @BeforeEach
    public void setUp() {
        contractRepository = new ContractRepository(database.getSessionFactory());
    }

    @Test
    public void findAll() {
        database.inTransaction(() -> {
            List<Contract> contracts = contractRepository.findAll();

            assertTrue(contracts.isEmpty());
        });
    }

}
