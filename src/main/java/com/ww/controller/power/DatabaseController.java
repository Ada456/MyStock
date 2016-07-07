package com.ww.controller.power;

import com.ww.service.power.DatabaseService;
import com.ww.utils.DataCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据库备份
 */
@Controller
@RequestMapping("power")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;


    @RequestMapping("/beifen")
    public String index(){
        return "power/beifen";
    }

    /**
     * 备份数据库
     */
    @RequestMapping("/backup")
    @ResponseBody
    public String backup(String datapath){
        return databaseService.backup(datapath);
    }

    /**
     * 恢复数据库
     */
    @RequestMapping("/load")
    public String load(String datafile) {
        return databaseService.load(datafile);
    }

    /**
     * 系统初始化（删除所有营业数据）
     */
    @RequestMapping("/init")
    public String init(String delstate){
        return databaseService.init(delstate);
    }

}
