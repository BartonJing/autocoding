package ${package};

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ${entityName}ServiceImpl implements ${entityName}Service {
    @Autowired
    private ${entityName}Mapper ${entityName ? uncap_first}Mapper;

    @Override
    public ${entityName} insert(${entityName} ${entityName ? uncap_first}) {
        if(${entityName ? uncap_first}Mapper.insert(${entityName ? uncap_first}) > 0){
            return ${entityName ? uncap_first};
        }
        return null;
    }

    @Override
    public ${entityName} updateById(${entityName} ${entityName ? uncap_first}) {
        if(${entityName}Mapper.updateByPrimaryKey(${entityName ? uncap_first}) > 0){
            return ${entityName};
        }
        return null;
    }

    @Override
    public int deleteById(String id) {
        return ${entityName ? uncap_first}Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public AuthUser selectById(String id) {
        return ${entityName ? uncap_first}Mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AuthUser> selectByParams(Map<String, Object> params) {
        return ${entityName ? uncap_first}Mapper.selectByParams(params);
    }

    @Override
    public PageInfo<${entityName}> selectPage(Integer page, Integer pageSize, Map<String, Object> params) {
        PageHelper.startPage(page,pageSize);
        PageInfo<${entityName}> pageInfo = new PageInfo<${entityName}>(selectByParams(params));
        return pageInfo;
    }
}
