package com.giovani.crm.mapper;

import com.giovani.crm.pojo.BaseDict;

import java.util.List;

/**
 * 字典数据持久化接口
 *
 * @author Giovani
 * @create: 2018/7/10 15:22
 */
public interface BaseDictMapper {

    /**
     * 根据类别代码查询数据
     *
     * @Description:
     * @Param: [dictTypeCode]
     * @return: java.util.List<com.giovani.crm.pojo.BaseDict>
     * @Author: Giovani
     * @Date: 2018/7/10
     * @Time: 15:25
     */
    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);

}
