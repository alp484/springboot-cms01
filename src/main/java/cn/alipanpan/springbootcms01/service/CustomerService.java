package cn.alipanpan.springbootcms01.service;

import cn.alipanpan.springbootcms01.bean.BasePage;
import cn.alipanpan.springbootcms01.bean.Customer;
import cn.alipanpan.springbootcms01.dao.CustomerDao;
import cn.alipanpan.springbootcms01.dao.CustomerJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerService {

    private int PAGE_SIZE = 10;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerJpaDao customerJpaDaoDao;

    public List<Customer> getByMap(Map map) {
        return customerDao.getByMap(map);
    }

    public Customer getById(Integer id) {
        return customerDao.getById(id);
    }

    public Customer findById(Integer id) {
        Optional<Customer> customer = customerJpaDaoDao.findById(id);

       /* customerJpaDaoDao.findAll(new BasePage(){
            @Override
            public long getOffset() {
                return 1;
            }
        });*/
        return customer.get();
    }

    public Customer create(Customer customer) {
        customerDao.create(customer);
        return customer;
    }

    public Customer save(Customer customer) {
        return customerJpaDaoDao.save(customer);
    }

    public Customer update(Customer customer) {
        customerJpaDaoDao.save(customer);
        return customer;
    }
    public int deleteJpa(Integer id) {
        customerJpaDaoDao.deleteById(id);
        return id;
    }

    public int delete(Integer id) {
        return customerDao.delete(id);
    }
}
