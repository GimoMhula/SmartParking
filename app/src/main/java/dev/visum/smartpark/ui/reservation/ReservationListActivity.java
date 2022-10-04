package dev.visum.smartpark.ui.reservation;

import android.app.AlertDialog;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dev.visum.smartpark.R;
import dev.visum.smartpark.model.Reservation;
import dev.visum.smartpark.ui.manager.ManagerActivity;
import dev.visum.smartpark.ui.settings.SettingsViewModel;
import timber.log.Timber;

public class ReservationListActivity extends Fragment {

    private SettingsViewModel slideshowViewModel;
    private Button btnRecarregar;
    private EditText editTextValorRec;
    private Button pay_with_mpesa;

    private static final String ARG_SECTION_NUMBER = "section_number";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.activity_timeline_card, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });


        pay_with_mpesa=root.findViewById(R.id.pay_button);

        pay_with_mpesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestDepositView(new Reservation());
            }
        });

        return root;

    }
    public static ReservationListActivity newInstance(int sectionNumber) {
        ReservationListActivity fragment = new ReservationListActivity();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    private void requestDepositView(Reservation reservation) {
        View customView = getLayoutInflater().inflate(R.layout.recharge_dialog, null, false);
        editTextValorRec = customView.findViewById(R.id.valor_a_recarregar);

        btnRecarregar = customView.findViewById(R.id.recharge_button);
        TextView textPhoneNumber = customView.findViewById(R.id.dialog_phone_number_id);
//        textPhoneNumber.setText(reservation.getClient_number());

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity());
        //alertBuilder.setTitle("Recarga");
        alertBuilder.setView(customView);
        AlertDialog alertDialog = alertBuilder.create();
        //saldoIntroduzido = Double.parseDouble(editTextValorRec.getText().toString());

        alertDialog.show();


//        btnRecarregar.setOnClickListener(v -> {
//            alertDialog.hide();
//
//            String saldoTxt = editTextValorRec.getText().toString().trim();
//            if (TextUtils.isEmpty(saldoTxt)) {
//                //Toast.makeText((getActivity(), "Introduza um valor ").show();
//                alertDialog.dismiss();
//                return;
//            }
//            double saldoIntroduzido = Double.parseDouble(saldoTxt);
//            Timber.d("saldo introduzido: %s", saldoIntroduzido);
//
////            FireFunctions.init().makeDeposit(person, saldoIntroduzido, MPESA)
////                    .observe(MapsActivity.this, MapsActivity.this::handlePayment);
//
//
//            alertDialog.dismiss();
//
//        });
        /*alertDialog.hide();*/
        //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }


}
