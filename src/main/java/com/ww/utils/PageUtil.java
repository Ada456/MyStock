package com.ww.utils;

import com.ww.entity.Page;

import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/7/7 0007.
 */
public class PageUtil {

    public  static Page getPage(String currentPage) {

        //创建分页对象
        Page page = new Page();
        //对当前页面做后台校验
        Pattern pattern = Pattern.compile("[0-9]{1,9}");
        if (currentPage == null || !pattern.matcher(currentPage).matches()) {
            page.setCurrentPage(1);
        } else {
            page.setCurrentPage(Integer.parseInt(currentPage));
        }
        return page;
    }
}
