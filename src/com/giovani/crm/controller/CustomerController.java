package com.giovani.crm.controller;

import com.giovani.crm.pojo.BaseDict;
import com.giovani.crm.pojo.Customer;
import com.giovani.crm.pojo.QueryVo;
import com.giovani.crm.service.BaseDictService;
import com.giovani.crm.service.CustomerService;
import com.giovani.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 客户信息请求处理
 * 访问路径：http://localhost:8080/ssmDemo1/customer/list.action
 *
 * @author Giovani
 * @create: 2018/7/10 12:04
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    @Value("${CUSTOMER_FROM_TYPE}")
    private String CUSTOMER_FROM_TYPE;

    @Value("${CUSTOMER_INDUSTRY_TYPE}")
    private String CUSTOMER_INDUSTRY_TYPE;

    @Value("${CUSTOMER_LEVEL_TYPE}")
    private String CUSTOMER_LEVEL_TYPE;

    /**
     * 显示首页
     *
     * @Param: []
     * @return: java.lang.String
     * @Author: Giovani
     * @Date: 2018/7/10
     * @Time: 15:50
     */
    @RequestMapping("list")
    public String list(Model model, QueryVo queryVo) {

        // 解决get编码问题
        //        try {
        //
        //            if (queryVo.getCustName().trim() != "" && queryVo.getCustName() != null) {
        //                queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
        //            }
        //
        //        } catch (UnsupportedEncodingException e) {
        //            e.printStackTrace();
        //        }

        // 客户来源
        List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_FROM_TYPE);
        // 所属行业
        List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_INDUSTRY_TYPE);
        // 客户级别
        List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_LEVEL_TYPE);

        // 把前端页面需要显示的数据放到模型中
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        // 根据条件分页查询用户数据列表
        Page<Customer> customerPage = customerService.queryCustomerByQueryVo(queryVo);

        // 返回分页信息
        model.addAttribute("page", customerPage);
        // 返回查询条件
        model.addAttribute("vo", queryVo);

        return "customer";
    }

    /**
     * 根据id查询用户，返回json信息
     *
     * @Param: [id]
     * @return: com.giovani.crm.pojo.Customer
     * @Author: Giovani
     * @Date: 2018/7/18
     * @Time: 10:51
     */
    @RequestMapping("edit")
    @ResponseBody // 返回json
    public Customer queryCustomerById(long id) {
        Customer customer = customerService.queryCustomerById(id);
        return customer;
    }

    /**
     * 根据id，保存用户修改后的信息
     *
     * @Param: [customer]
     * @return: int
     * @Author: Giovani
     * @Date: 2018/7/18
     * @Time: 11:22
     */
    @RequestMapping("update")
    @ResponseBody
    public String updateCustomerById(Customer customer) {
        String msg = "1";

        try {
            customerService.updateCustomerById(customer);
            msg = "0";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;
    }

    /**
     * 根据id删除用户
     *
     * @Param: [customer]
     * @return: java.lang.String
     * @Author: Giovani
     * @Date: 2018/7/18
     * @Time: 12:11
     */
    @RequestMapping("delete")
    @ResponseBody
    public String deleteCustomerById(long id) {
        String msg = "1";

        try {
            customerService.deleteCustomerById(id);
            msg = "0";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;
    }

}
