package com.giovani.crm.mapper;

import com.giovani.crm.pojo.Customer;
import com.giovani.crm.pojo.QueryVo;

import java.util.List;

/**
 * 客户信息持久化接口
 *
 * @author Giovani
 * @create: 2018/7/11 15:31
 */
public interface CustomerMapper {

    /**
     * 根据查询条件，查询出用户列表总数
     *
     * @Param: [queryVo]
     * @return: int
     * @Author: Giovani
     * @Date: 2018/7/11
     * @Time: 15:52
     */
    public int queryCountByQueryVo(QueryVo queryVo);

    /**
     * 根据查询条件，查询出用户列表
     *
     * @Param: [queryVo]
     * @return: java.util.List<com.giovani.crm.pojo.Customer>
     * @Author: Giovani
     * @Date: 2018/7/11
     * @Time: 15:50
     */
    public List<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    /**
     * 根据id查询出用户信息
     *
     * @Param: [id]
     * @return: com.giovani.crm.pojo.Customer
     * @Author: Giovani
     * @Date: 2018/7/18
     * @Time: 10:40
     */
    public Customer queryCustomerById(Long id);

    /**
     * 根据id，保存用户修改后的信息
     *
     * @Param: [customer]
     * @return: int
     * @Author: Giovani
     * @Date: 2018/7/18
     * @Time: 11:06
     */
    public void updateCustomerById(Customer customer);

    /**
     * 根据id删除用户
     *
     * @Param: [customer]
     * @return: void
     * @Author: Giovani
     * @Date: 2018/7/18
     * @Time: 12:08
     */
    public void deleteCustomerById(long id);

}
