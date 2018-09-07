package ${package};

import ${entityClass};
import java.util.List;
import java.util.Map;

public interface ${entityName}Mapper {

    int deleteByPrimaryKey(String id);

    int insert(${entityName} record);

    int insertSelective(${entityName} record);

    ${entityName} selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(${entityName} record);

    int updateByPrimaryKey(${entityName} record);
    
    List<${entityName}> selectByParams(Map<String,Object> params);

}