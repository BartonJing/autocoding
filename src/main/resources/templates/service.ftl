package ${package};

import java.util.List;
import java.util.Map;

public interface ${entityName}Service{
    /**
     * 添加
     * @param ${entityName ? uncap_first}
     * @return
     */
    ${entityName} insert(${entityName} ${entityName ? uncap_first});

    /**
     * 根据id修改
     * @param ${entityName ? uncap_first}
     * @return
     */
    ${entityName} updateById(${entityName} ${entityName ? uncap_first});

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ${entityName} selectById(String id);

    /**
     * 根据传入的参数查询
     * @param params
     * @return
     */
    List<${entityName}> selectByParams(Map<String, Object> params);

    /**
    * 分页查询
    * @param page
    * @param pageSize
    * @param params
    * @return
    */
    PageInfo<${entityName}> selectPage(Integer page, Integer pageSize, Map<String, Object> params);

}
