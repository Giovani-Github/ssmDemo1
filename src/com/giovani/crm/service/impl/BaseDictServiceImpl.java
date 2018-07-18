package com.giovani.crm.service.impl;

import com.giovani.crm.mapper.BaseDictMapper;
import com.giovani.crm.pojo.BaseDict;
import com.giovani.crm.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典数据业务逻辑接口实现类
 *
 * @author Giovani
 * @create: 2018/7/10 15:36
 */
@Service
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    private BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
        List<BaseDict> dictList = baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
        return dictList;
    }
}
