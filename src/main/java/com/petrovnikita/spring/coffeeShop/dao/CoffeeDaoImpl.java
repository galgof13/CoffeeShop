package com.petrovnikita.spring.coffeeShop.dao;

import com.petrovnikita.spring.coffeeShop.entity.Coffee;
import com.petrovnikita.spring.coffeeShop.form.CoffeeForm;
import com.petrovnikita.spring.coffeeShop.model.CoffeeInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CoffeeDaoImpl implements CoffeeDao{

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public List<CoffeeInfo> getAllCoffee() {
        Session session = sessionFactory.getCurrentSession();

        String sql = "Select new com.petrovnikita.spring.coffeeShop.model.CoffeeInfo(p.id, p.name, p.evaluationBySCA, p.description, p.price) from Coffee p";

        List<CoffeeInfo> allCoffee = session.createQuery(sql , CoffeeInfo.class)
                .getResultList();

        return allCoffee;
    }
    @Override
    public Coffee getCoffee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Coffee coffee = session.get(Coffee.class, id);
        return coffee;
    }
    @Override
    public CoffeeInfo getCoffeeInfo(int id){
        Coffee coffee = this.getCoffee(id);
        if(coffee != null){
            return new CoffeeInfo(coffee);
        }
        return null;
    }

    @Override
    public void saveCoffee(CoffeeForm coffeeForm) {
        Session session = sessionFactory.getCurrentSession();
        Coffee coffee = null;
        if(coffeeForm.isNewCoffee() == true){
            coffee = new Coffee();
            coffee.setCreateDate(new Date());
        } else {
            coffee = this.getCoffee(coffeeForm.getId());
        }
        coffee.setName(coffeeForm.getName());
        coffee.setPrice(coffeeForm.getPrice());
        coffee.setDescription(coffeeForm.getDescription());
        coffee.setEvaluationBySCA(coffeeForm.getEvaluationBySCA());
        session.saveOrUpdate(coffee);
    }

    @Override
    public void deleteCoffee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Coffee> query = session.createQuery("delete from Coffee" +
                " where id =:CoffeeId");
        query.setParameter("CoffeeId", id);
        query.executeUpdate();
    }
}
