package com.petrovnikita.spring.coffeeShop.dao;

import com.petrovnikita.spring.coffeeShop.entity.Client;
import com.petrovnikita.spring.coffeeShop.model.ClientInfo;
import com.petrovnikita.spring.coffeeShop.model.TaskInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<ClientInfo> getAllClients() {
        Session session = sessionFactory.getCurrentSession();

        String sql = "Select new com.petrovnikita.spring.coffeeShop.model.ClientInfo" +
                "(c.id,  c.firstName," +
                " c.secondName, c.address, c.phoneNumber) from Client c";

        List<ClientInfo> allClients = session.createQuery(sql, ClientInfo.class)
                .getResultList();

        return allClients;
    }

    @Override
    public void saveClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(client);
    }

    @Override
    public Client getClient(int id) {
        Session session = sessionFactory.getCurrentSession();
        Client client = session.get(Client.class, id);
        return client;
    }
    @Override
    public ClientInfo getClientInfo(int id){
        Session session = sessionFactory.getCurrentSession();
        Client client = this.getClient(id);
        ClientInfo clientInfo = new ClientInfo(client);
        return clientInfo;
    }
    @Override
    public Client getClientForPhone(String phone){
        Session session = sessionFactory.getCurrentSession();
        Query<Client> query = session.createQuery("from Client where phoneNumber =:phone");
        query.setParameter("phone", phone);
        List<Client> client = query.getResultList();
        if(client == null){
            return new Client();
        }
        return client.get(0);
    }

    @Override
    public void deleteClient(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Client> query = session.createQuery("delete from Client" +
                " where id =:ClientId");
        query.setParameter("ClientId", id);
        query.executeUpdate();
    }
}
