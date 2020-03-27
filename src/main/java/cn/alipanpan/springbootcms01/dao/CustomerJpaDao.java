package cn.alipanpan.springbootcms01.dao;

import cn.alipanpan.springbootcms01.bean.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface UserJpaDao.
 *
 * @author abel
 */
public interface CustomerJpaDao extends JpaRepository<Customer, Integer> {

    /**
     * Find by name.
     *
     * @param name the name
     * @return the user
     */
    Customer findByName(String name);
}