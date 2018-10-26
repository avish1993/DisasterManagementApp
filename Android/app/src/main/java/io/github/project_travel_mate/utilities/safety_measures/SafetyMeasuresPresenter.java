package io.github.project_travel_mate.utilities.safety_measures;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import objects.SafetyMeasure;

import static objects.SafetyMeasure.createFunFactList;

public class SafetyMeasuresPresenter {

    private final SafetyMeasuresView mSafetyMeasuresView;
    private ArrayList<String> mFactsText;
    //private ArrayList<String> mImages;

    SafetyMeasuresPresenter(SafetyMeasuresView safetyMeasuresView) {
        mSafetyMeasuresView = safetyMeasuresView;
    }

    public void initPresenter(String id, String token) {
        mSafetyMeasuresView.showProgressDialog();
        mFactsText = new ArrayList<>();
        //mImages = new ArrayList<>();
        getCityFacts(id, token);
    }

    // Fetch fun facts about city
    private void getCityFacts(final String id, final String token) {
        if (id.equals("Cyclone")) {
            mFactsText.add("Before cyclone:\n \n" +
                    "-> Assemble an emergency kit that includes things like first aid supplies, mobile " +
                    "charger, torch, important documents, canned food, and medicines.\n" +
                    "-> Trim hazardous treetops and branches (get council permission).\n" +
                    "-> Clear your property of loose material that could blow about and possibly " +
                    "cause injury or damage during extreme winds.\n" +
                    "-> In case of a storm surge/tide warning, or another flooding, know your nearest " +
                    "safe high ground and the safest access route to it.\n" +
                    "-> Ensure your vehicle is in good working order.\n" +
                    "-> If you receive a warning for your area, charge your mobile battery and " +
                    "fill up the car if possible.\n" +
                    "\n" + "During cyclone\n\n" +
                    "-> Remain indoors (with your pets). Stay tuned to your local radio/TV " +
                    "for further information.\n" +
                    "-> Close shutters or board-up or heavily tape all windows. " +
                    "-> Draw curtains and lock doors.\n" +
                    "-> If the building starts to break up, protect yourself with mattresses, rugs " +
                    "or blankets under a strong table or bench or hold onto a solid fixture, " +
                    "e.g. a water pipe.\n" +
                    "-> Beware the calm 'eye'. If the wind drops, don't assume the cyclone is " +
                    "over; violent winds will soon resume from another direction. Wait for " +
                    "the official 'all clear'.\n" +
                    "-> Stay away from doors, windows and exterior walls.\n" +
                    "-> If an official evacuation order is issued, you must leave immediately " +
                    "and seek shelter elsewhere.\n" +
                    "-> Check if your neighbors are aware of the situation and are preparing.\n" +
                    " \n" +
                    "\nAfter cyclone \n\n" +
                    "-> Check for gas leaks. Don't use electric appliances if wet.\n" +
                    "-> Don't go outside until officially advised it is safe.\n" +
                    "-> Beware of damaged power lines, bridges, buildings, trees, and don't " +
                    "enter floodwaters.\n" +
                    "-> Make sure the water being used is not contaminated.\n");
        }
        if (id.equals("Earthquake")) {
            mFactsText.add("fact Earthquake");
        }
        //getCityImages(id, token);\
        ArrayList<SafetyMeasure> safetyMeasures = createFunFactList(mFactsText);
        mSafetyMeasuresView.setupViewPager(safetyMeasures);
        mSafetyMeasuresView.hideProgressDialog();
    }


    // Fetch images of a city
    /*
    private void getCityImages(String id, String token) {

        JSONArray array = new JSONArray(res);
        for (int i = 0; i < array.length(); i++) {
            mImages.add(array.getJSONObject(i).getString("image_url"));
            ArrayList<SafetyMeasure> safetyMeasures = createFunFactList(mFactsText, mImages,
                    mFactsSourceText, mFactsSourceURL);
            mSafetyMeasuresView.setupViewPager(safetyMeasures);
            mSafetyMeasuresView.hideProgressDialog();
        }
    }
    */
}
