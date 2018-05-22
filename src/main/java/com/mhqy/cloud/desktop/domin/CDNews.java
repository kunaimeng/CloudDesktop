package com.mhqy.cloud.desktop.domin;

/**
 * @Description:新闻实体
 * @author: peiqiankun
 * @date: 2018/5/22
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class CDNews {

    /**
     * key
     */
    private String uniquekey;

    /**
     * 标题
     */
    private String title;

    /**
     * 日期
     */
    private String date;

    /**
     * 类型
     */
    private String category;

    /**
     * 作者
     */
    private String authorName;

    /**
     * 链接
     */
    private String  url;

    /**
     * 图片
     */
    private String thumbnail_pic_s;

    /**
     * 图片
     */
    private String thumbnail_pic_s02;

    /**
     * 图片
     */
    private  String thumbnail_pic_s03;

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
    }

    public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
    }

    public String getThumbnail_pic_s03() {
        return thumbnail_pic_s03;
    }

    public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
    }
}
