package com.tkith.shoppingsite.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tkith.shoppingsite.entity.Product;

@Repository
public class ProductDAO {

//	private EntityManager entityManager;
//	
//	@Autowired
//	public ProductDAO(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}
//	
//	@Override
//	public List<Product> getAll() {
//		Session currentSession = this.entityManager.unwrap(Session.class);
//		
//		Query<Product> query = currentSession.createQuery("from Product", Product.class);
//		
//		List<Product> products = query.getResultList();
//		
//		return products;
//	}
//
//	@Override
//	public Product getById(int id) {
//		String hql = "from Product where id = :productId";
//		Session currentSession = this.entityManager.unwrap(Session.class);
//		
//		Query<Product> query = currentSession.createQuery(hql, Product.class);
//		query.setParameter(":productId", id);
//		
//		return (query.getSingleResult() != null ? query.getSingleResult() : null);
//	}
//
//	@Override
//	public Product getByName(String name) {
//		String hql = "from Product where name = :productName";
//		Session currentSession = this.entityManager.unwrap(Session.class);
//		
//		Query<Product> query = currentSession.createQuery(hql, Product.class);
//		query.setParameter(":productName", name);
//		
//		return (query.getSingleResult() != null ? query.getSingleResult() : null);
//	}
//
//	@Override
//	public void add(Product product) {
//		try {
//			this.entityManager.getTransaction().begin();
//			this.entityManager.persist(product);
//			this.entityManager.getTransaction().commit();
//		} catch (TransactionException e) {
//			this.entityManager.getTransaction().rollback();
//		}
//	}
//
//	@Override
//	public void update(int id) {
//		Product product = this.entityManager.find(Product.class, id);
//		
//		try {
//			this.entityManager.getTransaction().begin();
//			this.entityManager.merge(product);
//			this.entityManager.getTransaction().commit();
//		} catch (TransactionException e) {
//			this.entityManager.getTransaction().rollback();
//		}
//	}
//
//	@Override
//	public void delete(int id) {
//		Product product = this.entityManager.find(Product.class, id);
//		
//		try {
//			this.entityManager.getTransaction().begin();
//			this.entityManager.remove(product);
//			this.entityManager.getTransaction().commit();
//		} catch (TransactionException e) {
//			this.entityManager.getTransaction().rollback();
//		}
//	}

}
