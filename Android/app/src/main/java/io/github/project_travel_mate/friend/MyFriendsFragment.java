package io.github.project_travel_mate.friend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.project_travel_mate.R;
import io.github.project_travel_mate.utilities.AnimalHelpActivity;
import io.github.project_travel_mate.utilities.safety_measures.SafetyMeasuresActivity;
import objects.User;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.view.View.GONE;
import static utils.Constants.API_LINK_V2;
import static utils.Constants.USER_TOKEN;

public class MyFriendsFragment extends Fragment {

    private final List<User> mFriends = new ArrayList<>();

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
//    @BindView(R.id.animation_view)
//    LottieAnimationView animationView;

    private String mToken;
    private Handler mHandler;
    private Activity mActivity;
    private MyFriendsAdapter mAdapter;

    public MyFriendsFragment() {
        // Required empty public constructor
    }

    public static MyFriendsFragment newInstance() {
        return new MyFriendsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animal_help, container, false);
//        ButterKnife.bind(this, view);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mActivity);
        mToken = sharedPreferences.getString(USER_TOKEN, null);
        mHandler = new Handler(Looper.getMainLooper());
        return view;

    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.mActivity = (Activity) activity;
        Intent intent = AnimalHelpActivity.getStartIntent(mActivity);
        startActivity(intent);
    }

}
