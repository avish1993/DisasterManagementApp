package io.github.project_travel_mate.utilities.safety_measures;

import java.util.ArrayList;


import objects.SafetyMeasure;

/**
 * Created by niranjanb on 14/06/17.
 */

interface SafetyMeasuresView {
    void showProgressDialog();
    void hideProgressDialog();
    void setupViewPager(ArrayList<SafetyMeasure> factsArray);
}
