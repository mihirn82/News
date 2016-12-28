package com.example.android.news;

/**
 * Created by mihirnewalkar on 12/25/16.
 */

public class News {

    //Title of the news.
    private String mTitle;

    //Section Name categorizing the news.
    private String mSection;

    //Date Time published.
    private String mDate;

    //URL for news details.
    private String mUrl;

    /*
    * Create a new News object.
    *
    *@param title
    *@param section
    *@param timeInMilliseconds
    *@param url
    * */
    public News(String title, String section, String date, String url)
    {
        mTitle = title;
        mSection = section;
        mDate = date;
        mUrl = url;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getSection(){
        return mSection;
    }

    public String getDate(){
        return mDate;
    }

    public String getUrl() { return mUrl; }
}
