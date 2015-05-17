package me.doapps.miraflores.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.rk.lib.view.SwipeView;

import me.doapps.miraflores.R;

/**
 * Created by william on 17/05/2015.
 */
public class RandomTimerFragment extends Fragment implements SwipeView.OnCardSwipedListener {
    private String receive;
/*
    public static final RandomTimerFragment newInstance(String flag) {
        RandomTimerFragment randomTimerFragment = new RandomTimerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("FLAG", flag);
        randomTimerFragment.setArguments(bundle);
        return randomTimerFragment;
    }
*/
    private final static int CARDS_MAX_ELEMENTS = 5;

    private FrameLayout contentLayout;
    private SwipeView mSwipeView;

    private int[] bikes = { R.mipmap.img_bike_1, R.mipmap.img_bike_2,
            R.mipmap.img_bike_3, R.mipmap.img_bike_4,
            R.mipmap.img_bike_5, R.mipmap.img_bike_6,
            R.mipmap.img_bike_7, R.mipmap.img_bike_8, R.mipmap.img_bike_9 };

    private int count = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabs, container, false);
        contentLayout = (FrameLayout) view.findViewById(R.id.contentLayout);

        // Add the swipe view
        mSwipeView = new SwipeView(getActivity(), R.id.imgSwipeLike, R.id.imgSwipeNope, this);
        contentLayout.addView(mSwipeView);

        // Adding the cards initially with the maximum limits of cards.
        for (int i = 0; i < CARDS_MAX_ELEMENTS; i++) {
            addCard(i);
        }
        return view;
    }

    @Override
    public void onLikes() {
        System.out.println("An Card removed");
        // Add a card if you needed after any previous card swiped
        addCard(0);
    }

    @Override
    public void onDisLikes() {
        System.out.println("An Card removed");
        // Add a card if you needed after any previous card swiped
        addCard(0);
    }

    @Override
    public void onSingleTap() {

    }

    private void addCard(int position) {
        final View cardView = LayoutInflater.from(getActivity()).inflate(R.layout.item_swipe_view, null);
        final FrameLayout frameLayout = (FrameLayout) cardView.findViewById(R.id.event);

        //final ImageView imgBike = (ImageView) cardView
        //        .findViewById(R.id.imgBike);
        //imgBike.setImageResource(bikes[count]);
        count++;
        if (count == bikes.length) {
            count = 0;
        }
        // Add a card to the swipe view.
        mSwipeView.addCard(cardView, position);
    }
}
