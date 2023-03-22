package com.petrovnikita.spring.coffeeShop.dao;

import com.petrovnikita.spring.coffeeShop.entity.Client;
import com.petrovnikita.spring.coffeeShop.model.ClientInfo;

import java.util.List;

public interface ClientDao {

    List<ClientInfo> getAllClients();

    void saveClient(Client client);

    Client getClient(int id);

    void deleteClient(int id);

    Client getClientForPhone(String phone);

    ClientInfo getClientInfo(int id);
}
