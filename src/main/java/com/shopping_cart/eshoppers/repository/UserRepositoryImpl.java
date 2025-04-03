//package com.shopping_cart.eshoppers.repository;
//
//import com.shopping_cart.eshoppers.entity.User;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.NoResultException;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
///*
// ** 2024, July 16, Tuesday, 3:50 PM
// */
//
//public class UserRepositoryImpl{
//
//    private EntityManager entityManager;
//
//    public UserRepositoryImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    @Transactional
//    public void save(User user) {
//        entityManager.merge(user);
//    }
//
//    @Override
//    public User findByUserName(String username) {
//        try {
//            return entityManager
//                    .createQuery("from User where userName = :data", User.class)
//                    .setParameter("data", username)
//                    .getSingleResult();
//        } catch (NoResultException e) {
//            // Handle no result found
//            return null;
//        }
//    }
//
//    @Override
//    public User findByEmail(String email) {
//        try {
//            return entityManager
//                    .createQuery("from User where userName = :data", User.class)
//                    .setParameter("data", email)
//                    .getSingleResult();
//        } catch (NoResultException e) {
//            // Handle no result found
//            return null;
//        }
//    }
//
//    @Override
//    public List<User> findAll() {
//        return entityManager
//                .createQuery("""
//                        select u from User u
//                        """, User.class)
//                .getResultList();
//    }
//}
