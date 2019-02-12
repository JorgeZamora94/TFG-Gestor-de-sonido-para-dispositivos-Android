package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;


public class ContactoFragment extends Fragment {

    public ContactoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contacto, container, false);

        final ImageButton facebook = (ImageButton) view.findViewById(R.id.facebook);
        ImageButton google = (ImageButton) view.findViewById(R.id.google);
        ImageButton twitter = (ImageButton) view.findViewById(R.id.twitter);
        ImageButton instagram = (ImageButton) view.findViewById(R.id.instagram);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/people/@/100033640770992"));
                startActivity(browser);
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCG-k_M_lUvK3PuLhUL87agQ?view_as=subscriber"));
                startActivity(browser);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ZamoraApp"));
                startActivity(browser);
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/zamora.app.soporte"));
                startActivity(browser);
            }
        });

        return view;
    }

}
