package com.giovani.crm.service;

import com.giovani.crm.pojo.Customer;
import com.giovani.crm.pojo.QueryVo;
import com.giovani.crm.utils.Page;

/**
 * 用户信息业务逻辑接口
 *
 * @author Giovani
 * @create: 2018/7/11 16:03
 */
public interface CustomerService {

    /**
     * 根据条件，分页查询用户信息
     *
     * @Param: [queryVo]
     * @return: java.util.List<com.giovani.crm.pojo.Customer>
     * @Author: Giovani
     * @Date: 2018/7/11
     * @Time: 16:04
     */
    public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    /**
     * 根据id，查询用户互信息
     *
     * @Param: [cust_id]
     * @return: com.giovani.crm.pojo.Customer
     * @Author: Giovani
     * @Date: 2018/7/18
     * @Time: 10:47
     */
    public Customer queryCustomerById(Long id);

    /**
     * 根据id，保存用户修改后的信息
     *
     * @Param: [customer]
     * @return: int
     * @Author: Giovani
     * @Date: 2018/7/18
     * @Time: 11:19
     */
    public void updateCustomerById(Customer customer);

    /**
     * 根据id，删除用户
     *
     * @Param: [customer]
     * @return: void
     * @Author: Giovani
     * @Date: 2018/7/18
     * @Time: 12:09
     */
    public void deleteCustomerById(long id);

}
