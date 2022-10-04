package dev.visum.smartpark.ui.home;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import dev.visum.smartpark.R;
import dev.visum.smartpark.utils.ViewAnimation;
import timber.log.Timber;

public class HomeFragment extends Fragment {

    private Activity mContext= (Activity) getContext();
    private HomeViewModel homeViewModel;
    private ImageButton bt_toggle_reviews;
    private ImageButton bt_toggle_warranty;
    private ImageButton bt_toggle_description;
    private View lyt_expand_reviews, lyt_expand_warranty, lyt_expand_description;
    private Button bt_add_reservation;
    String valueFirebase;
    TextView status;
    Button reservationBt;
    DatabaseReference dref;

    private Context TAG=getContext();
    private Button directionsBt;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.activity_park_details, container, false);


        initComponent(root);

        status = (TextView) root.findViewById(R.id.status);
        reservationBt = (Button) root.findViewById(R.id.reservation);


        dref = FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                valueFirebase = dataSnapshot.child("Node1/distance").getValue().toString();


                Log.d("", "onDataChange: valueJarak "+ valueFirebase);

                if(Double.parseDouble(valueFirebase.toString()) <= 50){
                    reservationBt.setBackgroundColor(Color.RED);
                    reservationBt.setText("Ocupado");
                    reservationBt.setTextColor(Color.WHITE);
                    status.setText("Lugares vagos 0");

                    try {
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        Ringtone r = RingtoneManager.getRingtone(getContext(), notification);
                        r.play();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    reservationBt.setBackgroundColor(Color.GREEN);
                    reservationBt.setText("Livre");
                    reservationBt.setTextColor(Color.BLACK);
                    status.setText("Lugares vagos 1");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return root;
    }
    private void initComponent(View v) {

        bt_toggle_reviews = (ImageButton) v.findViewById(R.id.bt_toggle_reviews);
        lyt_expand_reviews = (View) v.findViewById(R.id.lyt_expand_reviews);
        bt_toggle_reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSection(view, lyt_expand_reviews);
            }
        });


        bt_toggle_warranty = (ImageButton) v.findViewById(R.id.bt_toggle_warranty);
        lyt_expand_warranty = (View) v.findViewById(R.id.lyt_expand_warranty);
        bt_toggle_warranty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSection(view, lyt_expand_warranty);
            }
        });

        bt_toggle_description = (ImageButton) v.findViewById(R.id.bt_toggle_description);
        lyt_expand_description = (View) v.findViewById(R.id.lyt_expand_description);
        bt_toggle_description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSection(view, lyt_expand_description);
            }
        });


        toggleArrow(bt_toggle_description);
        lyt_expand_description.setVisibility(View.VISIBLE);

        bt_add_reservation=v.findViewById(R.id.reservation);
        bt_add_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(getContext(), "Reservando", Toast.LENGTH_SHORT).show();
            }
        });
        directionsBt = (Button) v.findViewById(R.id.directions);
        directionsBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Localizando...", Toast.LENGTH_SHORT).show();
                try {

                    Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                    mapIntent.setData(Uri.parse("geo:" + -25.97041867107596 + "," + 32.56822145891641+"?q="+"Parque Municipal do Mercado central"));
                    mapIntent.setPackage("com.google.android.apps.maps");
                    getContext().startActivity(mapIntent);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(getContext(), "Para poder Rastrear este local precisa do Google Maps", Toast.LENGTH_LONG).show();
                }
            }
        });




    }
    private void toggleSection(View bt, final View lyt) {
        boolean show = toggleArrow(bt);
        if (show) {
            ViewAnimation.expand(lyt, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
//                    Tools.nestedScrollTo(nested_scroll_view, lyt);
                }
            });
        } else {
            ViewAnimation.collapse(lyt);
        }
    }

    public boolean toggleArrow(View view) {
        if (view.getRotation() == 0) {
            view.animate().setDuration(200).rotation(180);
            return true;
        } else {
            view.animate().setDuration(200).rotation(0);
            return false;
        }
    }

    public static void reservar(){
        Timber.d("Reservando....");


    }

    public static void directions() {


    }




}
