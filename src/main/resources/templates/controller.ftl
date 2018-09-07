package ${package};

import com.barton.sbc.common.ServerResponse;
import com.barton.sbc.domain.entity.auth.AuthUser;
import com.barton.sbc.service.auth.AuthUserService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ${entityName}Controller {
    private static final Logger logger = LoggerFactory.getLogger(${entityName}.class);
    @Autowired
    private ${entityName}Service ${entityName ? uncap_first}Service;

    /**
     * 添加
     * @param ${entityName ? uncap_first}
     * @return
     */
    @PostMapping("/insert")
    public ServerResponse insert(${entityName} ${entityName ? uncap_first}){
        if((${entityName ? uncap_first} = ${entityName ? uncap_first}Service.insert(${entityName ? uncap_first})) != null){
            return ServerResponse.createBySuccess(${entityName ? uncap_first});
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public ServerResponse deleteById(@RequestParam String id){
        if(${entityName ? uncap_first}Service.deleteById(id) > 0){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }


    /**
     * 修改
     * @param ${entityName ? uncap_first}
     * @return
     */
    @PostMapping("/update")
    public ServerResponse updateById(@RequestBody ${entityName} ${entityName ? uncap_first}){
        if((${entityName ? uncap_first} = ${entityName ? uncap_first}Service.updateById(${entityName ? uncap_first})) != null){
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }

    /**
     * 查询
     * @param ${entityName ? uncap_first}
     * @return
     */
    @PostMapping("/selectPage")
    public PageInfo<${entityName}> selectPage(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestBody ${entityName} ${entityName ? uncap_first}){
    return ${entityName ? uncap_first}Service.selectPage(page,pageSize,null);
    }


}
