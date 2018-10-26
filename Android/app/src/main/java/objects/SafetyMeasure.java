package objects;

import java.io.Serializable;
import java.util.ArrayList;

public class SafetyMeasure implements Serializable {

    private String mTitle;
    //private String mImage;
    private String mText;

    /***
     * Initialize funfact object
     * @param title fact title
     * @param text  face text
     */
    public SafetyMeasure(String title, /*String image,*/ String text) {
        this.mTitle = title;
        //this.mImage = image;
        this.mText = text;
    }

    public static ArrayList<SafetyMeasure> createFunFactList(ArrayList<String> facts /*, ArrayList<String> images*/) {
        ArrayList<SafetyMeasure> factsArray = new ArrayList<>();
        if (facts.size() > 0) {
            String fact;
            for (int i = 0; i < facts.size(); i++) {
                fact = facts.get(i);
                double random = Math.random();
                String randomImage = null;
                /*
                if (images.size() > 0) {
                    int randomNum = (int) (random * 100) % (images.size());
                    randomImage = images.get(randomNum);
                }*/
                SafetyMeasure fact1 = new SafetyMeasure(null, fact);
                factsArray.add(fact1);
            }
        }
        return factsArray;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    /*
    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        this.mImage = image;
    }
    */

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        this.mText = text;
    }
}
