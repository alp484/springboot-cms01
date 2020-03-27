package cn.alipanpan.springbootcms01.dao;

import cn.alipanpan.springbootcms01.bean.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CustomerDao {

    List<Customer> getByMap(Map<String, Object> map);

    Customer getById(Integer id);

    Integer create(Customer customer);

    int update(Customer customer);

    int delete(Integer id);
}
