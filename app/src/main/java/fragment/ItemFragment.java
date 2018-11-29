package fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ExtraClass.CarouselLinearLayout;
import e.wolfsoft1.onboarding_pizza.LoginActivity;
import e.wolfsoft1.onboarding_pizza.R;/**
 * Created by wolfsoft3 on 12/9/18.
 */

public class ItemFragment extends Fragment {

    private static final String POSITON = "position";
    private static final String SCALE = "scale";
    private static final String DRAWABLE_RESOURE = "resource";

    private int screenWidth;
    private int screenHeight;

    private int[] imageArray = new int[]{R.drawable.bedroom_color_ful01, R.drawable.bedroom_color_ful01,
            R.drawable.bedroom_color_ful01, R.drawable.bedroom_color_ful01, R.drawable.bedroom_color_ful01,
            R.drawable.bedroom_color_ful01, R.drawable.bedroom_color_ful01, R.drawable.bedroom_color_ful01,
            R.drawable.bedroom_color_ful01, R.drawable.bedroom_color_ful01};

    public static Fragment newInstance(LoginActivity context, int pos, float scale) {
        Bundle b = new Bundle();
        b.putInt(POSITON, pos);
        b.putFloat(SCALE, scale);

        return Fragment.instantiate(context, ItemFragment.class.getName(), b);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWidthAndHeight();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        final int postion = this.getArguments().getInt(POSITON);
        float scale = this.getArguments().getFloat(SCALE);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(screenWidth / 2, screenHeight / 4);
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_one, container, false);

        TextView textView = (TextView) linearLayout.findViewById(R.id.text);
        CarouselLinearLayout root = (CarouselLinearLayout) linearLayout.findViewById(R.id.root_container);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.pagerImg);

        textView.setText("Lovely Bedroom");
        imageView.setLayoutParams(layoutParams);




        imageView.setImageResource(imageArray[postion]);

//        //handling click event
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), ImageDetailsActivity.class);
//                intent.putExtra(DRAWABLE_RESOURE, imageArray[postion]);
//                startActivity(intent);
//            }
//        });

        root.setScaleBoth(scale);

        return linearLayout;
    }

    /**
     * Get device screen width and height
     */
    private void getWidthAndHeight() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenHeight = displaymetrics.heightPixels;
        screenWidth = displaymetrics.widthPixels;
    }
}