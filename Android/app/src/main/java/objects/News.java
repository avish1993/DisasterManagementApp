package objects;

import android.support.annotation.NonNull;

import java.util.List;

public class News extends City {
    public String summaries;
    public String titles;
    public String urls;
    public String imageLinks;
    public String sourceLink;

    public News(@NonNull String mId, String mAvatar, String mNickname, int funFactsCount,
                int color, List<String> interests, String summaries, String titles, String urls,
                String imageLinks, String sourceLink) {
        super(mId, mAvatar, mNickname, funFactsCount, color, interests);
        this.summaries = summaries;
        this.titles = titles;
        this.urls = urls;
        this.imageLinks = imageLinks;
        this.sourceLink = sourceLink;
    }
}
