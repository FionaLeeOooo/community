package com.olivia.community.entity;

/**
 * @author zxuyi
 * @title: Page
 * @description: Pagination
 * @date 2023/4/8 15:23
 */

public class Page {

    /**
    * current
    */
    private int current = 1;

    /**
     * limit
     */
    private int limit = 10;

    /**
     * rows
     */
    private int rows;

    /**
     * 查询路径（用于复用分页链接, 因为我们不只在首页中有分页，其他界面也会有分页）
     */
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (current >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始索引 offset
     */
    public int getOffset() {
        return current * limit - limit;
    }

    /**
     * 获取总页数
     */
    public int getTotal() {
        if (rows % limit == 0) {
            return rows / limit;
        }
        else {
            return rows / limit + 1;
        }
    }

    /**
     * 获取分页栏起始页码
     * 分页栏显示当前页码及其前后两页
     */
    public int getFrom() {
        int from = current - 2;
        return Math.max(from, 1);
    }

    /**
     * 获取分页栏结束页码
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return Math.min(to, total);
    }

}
