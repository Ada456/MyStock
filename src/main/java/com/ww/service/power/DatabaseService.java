package com.ww.service.power;

import com.ww.utils.DataCopy;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/7 0007.
 */
@Service
public class DatabaseService {

    private String defualt_datapath = "E:/mystock";

    /**
     * 备份数据库
     * @param datapath
     * @return
     */
    public String backup(String datapath) {

        if (datapath == null) {
            datapath = defualt_datapath;
        }
        try {
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm");
            String d = bartDateFormat.format(new Date());
            DataCopy.backup(datapath + "data_" + d + ".sql");
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    /**
     * 恢复数据库
     * @param datafile
     * @return
     */
    public String load(String datafile) {
        try {
            DataCopy.load(datafile);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    /**初始化
     * @param delstate
     * @return
     */
    public String init(String delstate) {
        try {
            backup(defualt_datapath);

            DataCopy.delete(delstate);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
