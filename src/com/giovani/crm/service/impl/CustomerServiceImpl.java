package com.giovani.crm.service.impl;

import com.giovani.crm.mapper.CustomerMapper;
import com.giovani.crm.pojo.Customer;
import com.giovani.crm.pojo.QueryVo;
import com.giovani.crm.service.CustomerService;
import com.giovani.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息业务逻辑接口实现类
 *
 * @author Giovani
 * @create: 2018/7/11 16:04
 */
@SuppressWarnings("ALL")
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
        // 设置查询条件，从哪一条开始查询
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());

        // 查询数据结果集
        List<Customer> customerList = customerMapper.queryCustomerByQueryVo(queryVo);
        // 查询数据总条数
        int customerCount = customerMapper.queryCountByQueryVo(queryVo);

        // 封装返回的page对象
        Page<Customer> customerPage = new Page<Customer>(customerCount, queryVo.getPage(), queryVo.getRows(), customerList);

        return customerPage;
    }

    @Override
    public Customer queryCustomerById(Long id) {
        Customer customer = customerMapper.queryCustomerById(id);
        return customer;
    }

    @Override
    public void updateCustomerById(Customer customer) {
        customerMapper.updateCustomerById(customer);
    }

    @Override
    public void deleteCustomerById(long id) {
        customerMapper.deleteCustomerById(id);
    }
}
