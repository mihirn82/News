package com.example.android.news;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mihirnewalkar on 12/25/16.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String LOG_TAG = News.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param news A List of news objects to display in a list
     */
    public NewsAdapter(Activity context, ArrayList<News> news) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, news);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        News currentNews = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the title from the current News object and
        // set this text on the title TextView
        String sTitle = currentNews.getTitle();
        titleView.setText(sTitle);

        // Find the TextView in the list_item.xml layout with the ID section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section_text_view);
        // Get the title from the current News object and
        // set this text on the title TextView
        String sSection = currentNews.getSection();
        sectionView.setText(sSection);

        String sDate = currentNews.getDate();
        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Get the date from the current News object and
        // set this text on the date TextView
        dateView.setText(sDate);

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
