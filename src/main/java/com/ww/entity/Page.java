package com.ww.entity;

/**
 * 分页对应的实体类
 */
public class Page {
    /**
     * 总条数
     */
    private int totalNumber;
    /**
     * 当前第几页
     */
    private int currentPage;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 每页显示条数
     */
    private int pageNumber = 5;
    /**
     * 数据库中limit的参数，从第几条开始取
     */
    private int startIndex;
    /**
     * 数据库中limit的参数，一共取多少条
     */
    private int pageSize;

    /**
     * 根据当前对象中属性值计算并设置相关属性值
     */
    public void count() {
        // 计算总页数
        int totalPageTemp = this.totalNumber / this.pageNumber;
        int plus = (this.totalNumber % this.pageNumber) == 0 ? 0 : 1;
        totalPageTemp = totalPageTemp + plus;
        if(totalPageTemp <= 0) {
            totalPageTemp = 1;
        }
        this.totalPage = totalPageTemp;

        // 设置当前页数
        // 总页数小于当前页数，应将当前页数设置为总页数
        if(this.totalPage < this.currentPage) {
            this.currentPage = this.totalPage;
        }
        // 当前页数小于1设置为1
        if(this.currentPage < 1) {
            this.currentPage = 1;
        }

        // 设置limit的参数
        this.startIndex = (this.currentPage - 1) * this.pageNumber;
        this.pageSize = this.pageNumber;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
        this.count();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        this.count();
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}