package com.giovani.crm.service;

import com.giovani.crm.pojo.BaseDict;

import java.util.List;

/**
 * 字典数据业务逻辑接口
 *
 * @author Giovani
 * @create: 2018/7/10 15:33
 */
public interface BaseDictService {

    /**
     * @Description: 根据类别代码查询数据
     * @Param: [dictTypeCode]
     * @return: java.util.List<com.giovani.crm.pojo.BaseDict>
     * @Author: Giovani
     * @Date: 2018/7/10
     * @Time: 15:35
     */
    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
