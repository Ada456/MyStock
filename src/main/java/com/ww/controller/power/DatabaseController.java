package com.ww.controller.power;

import com.ww.utils.DataCopy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/6 0006.
 */
@Controller
@RequestMapping("database")
public class DatabaseController {

    private String datapath;
    private String datafile;
    private String delstate;

    /**
     * 备份数据库
     */
    @RequestMapping("/backup")
    public String backup(){
        try {
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm");
            String d = bartDateFormat.format(new Date());
            DataCopy.backup(datapath+"data_"+d+".sql");
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    /**
     * 恢复数据库
     */
    @RequestMapping("/load")
    public String load() {
        try {
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm");
            String d = bartDateFormat.format(new Date());
            DataCopy.backup("D:\\MyStockData\\old_"+d+".sql");
            DataCopy.load(datafile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 系统初始化（删除所有营业数据）
     */
    @RequestMapping("/init")
    public String init(){
        try {
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm");
            String d = bartDateFormat.format(new Date());
            DataCopy.backup("D:\\MyStockData\\del_"+d+".sql");
            DataCopy.delete(delstate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setDatapath(String datapath) {
        this.datapath = datapath;
    }

    public void setDatafile(String datafile) {
        this.datafile = datafile;
    }

    public void setDelstate(String delstate) {
        this.delstate = delstate;
    }

}
