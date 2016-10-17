package com.peipeiyang.tablets;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class TabletsFragment extends Fragment {
    static  int REQUEST_TABLET ;

    //ArrayList<Integer> checkmark = new ArrayList<Integer>(6);
    public static CheckBox checkbox1;
    public static CheckBox checkbox2;
    public static CheckBox checkbox3;
    public static CheckBox checkbox4;
    public static CheckBox checkbox5;
    public static CheckBox checkbox6;
    public static TextView likeTv1;
    public static TextView likeTv2;
    public static TextView likeTv3;
    public static TextView likeTv4;
    public static TextView likeTv5;
    public static TextView likeTv6;
    public static ArrayList<String> sender = new ArrayList<String>(Arrays.asList("0", "0","0","0","0","0"));
    public static ArrayList<TextView> liketv = new ArrayList<TextView>();
    static Button cmpbutton;

    public static int totalnum;


    public TabletsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tablets, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

         checkbox1 = (CheckBox) getActivity().findViewById(R.id.tablet_check1);
         checkbox2 = (CheckBox) getActivity().findViewById(R.id.tablet_check2);
         checkbox3 = (CheckBox) getActivity().findViewById(R.id.tablet_check3);
         checkbox4 = (CheckBox) getActivity().findViewById(R.id.tablet_check4);
         checkbox5 = (CheckBox) getActivity().findViewById(R.id.tablet_check5);
         checkbox6 = (CheckBox) getActivity().findViewById(R.id.tablet_check6);
         likeTv1 = (TextView) getActivity().findViewById(R.id.tablet_likeTV1);
         likeTv2 = (TextView) getActivity().findViewById(R.id.tablet_likeTV2);
         likeTv3 = (TextView) getActivity().findViewById(R.id.tablet_likeTV3);
         likeTv4 = (TextView) getActivity().findViewById(R.id.tablet_likeTV4);
         likeTv5 = (TextView) getActivity().findViewById(R.id.tablet_likeTV5);
         likeTv6 = (TextView) getActivity().findViewById(R.id.tablet_likeTV6);
        likeTv1.setVisibility(View.INVISIBLE);
        likeTv2.setVisibility(View.INVISIBLE);
        likeTv3.setVisibility(View.INVISIBLE);
        likeTv4.setVisibility(View.INVISIBLE);
        likeTv5.setVisibility(View.INVISIBLE);
        likeTv6.setVisibility(View.INVISIBLE);
        //set buttom behavior
         cmpbutton = (Button) getActivity().findViewById(R.id.tablet_compareButn);


        //show compare

        cmpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checknumcheckbox();
            }
        });
    }

    public void checknumcheckbox() {

        if (checkbox1.isChecked()) {
            sender.set(0, "1");
            totalnum++;
        }

        if(checkbox2.isChecked()) {
            sender.set(1, "1");
            totalnum++;
        }


        if(checkbox3.isChecked()){
            sender.set(2,"1");
        totalnum++;
        }

        if(checkbox4.isChecked()) {
            sender.set(3, "1");
            totalnum++;
        }
        if(checkbox5.isChecked()) {
            sender.set(4, "1");
            totalnum++;
        }
        if(checkbox6.isChecked()) {
            sender.set(5, "1");
            totalnum++;
        }



        if (totalnum > 3 ){
           // cmpbutton.setEnabled(false);
            Toast.makeText(getActivity(), R.string.toastmessage1, Toast.LENGTH_SHORT).show();

        }
        else if(totalnum ==0){
            Toast.makeText(getActivity(), R.string.toastmessage2, Toast.LENGTH_SHORT).show();
        }
        else{
            showDetails();
        }

        totalnum = 0;

    }



    private void showDetails() {

        likeTv1.setVisibility(View.INVISIBLE);
        likeTv2.setVisibility(View.INVISIBLE);
        likeTv3.setVisibility(View.INVISIBLE);
        likeTv4.setVisibility(View.INVISIBLE);
        likeTv5.setVisibility(View.INVISIBLE);
        likeTv6.setVisibility(View.INVISIBLE);

        Intent intent = new Intent(getActivity(), compare.class);
        REQUEST_TABLET =1 ;
        intent.putStringArrayListExtra("items", sender);


        startActivityForResult(intent, REQUEST_TABLET);
    }

    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TABLET) {
            if (resultCode == Activity.RESULT_OK) {
                if (data.hasExtra(compareFragment.OPINION)) {
                    ArrayList<String> likecheck = new ArrayList<String>();
                    likecheck =  data.getStringArrayListExtra(compareFragment.OPINION) ;
                    int nums = likecheck.size();
                    int numc=0;

                   if("1".equals(sender.get(0))) {
                       numc++;
                       if(numc==1&&"1".equals(likecheck.get(0))){
                           likeTv1.setVisibility(View.VISIBLE);

                       }
                      }
                    if("1".equals(sender.get(1))&&numc <= nums){
                        numc++;
                        if(numc ==1 &&"1".equals(likecheck.get(0))){
                            likeTv2.setVisibility(View.VISIBLE);

                        }
                        if(numc ==2 &&"1".equals(likecheck.get(1))){
                            likeTv2.setVisibility(View.VISIBLE);

                        }
                    }
                    if("1".equals(sender.get(2))&&numc <= nums){
                        numc++;
                        if(numc ==1 &&"1".equals(likecheck.get(0))){
                            likeTv3.setVisibility(View.VISIBLE);

                        }
                        if(numc ==2 &&"1".equals(likecheck.get(1))){
                            likeTv3.setVisibility(View.VISIBLE);

                        }
                        if(numc ==3 &&"1".equals(likecheck.get(2))){
                            likeTv3.setVisibility(View.VISIBLE);

                        }

                    }
                    if("1".equals(sender.get(3))&&numc <= nums){
                        numc++;
                        if(numc ==1 &&"1".equals(likecheck.get(0))){

                            likeTv4.setVisibility(View.VISIBLE);
                        }
                        if(numc ==2 &&"1".equals(likecheck.get(1))){
                            likeTv4.setVisibility(View.VISIBLE);
                        }
                        if(numc ==3 &&"1".equals(likecheck.get(2))){
                            likeTv4.setVisibility(View.VISIBLE);
                        }
                    }
                    if("1".equals(sender.get(4))&&numc <= nums){
                        numc++;
                        if(numc ==1 &&"1".equals(likecheck.get(0))){
                            likeTv5.setVisibility(View.VISIBLE);
                        }
                        if(numc ==2 &&"1".equals(likecheck.get(1))){
                            likeTv5.setVisibility(View.VISIBLE);
                        }
                        if(numc ==3 &&"1".equals(likecheck.get(2))){
                            likeTv5.setVisibility(View.VISIBLE);
                        }
                    }
                    if("1".equals(sender.get(5))&&numc <= nums){
                        numc++;
                        if(numc ==1 &&"1".equals(likecheck.get(0))){
                            likeTv6.setVisibility(View.VISIBLE);
                        }
                        if(numc ==2 &&"1".equals(likecheck.get(1))){
                            likeTv6.setVisibility(View.VISIBLE);
                        }
                        if(numc ==3 &&"1".equals(likecheck.get(2))){
                            likeTv6.setVisibility(View.VISIBLE);
                        }
                    }
                         numc =0;
                   }
                }
               sender = new ArrayList<String>(Arrays.asList("0", "0","0","0","0","0"));
                checkbox1.setChecked(false);
                checkbox2.setChecked(false);
                checkbox3.setChecked(false);
                checkbox4.setChecked(false);
                checkbox5.setChecked(false);
                checkbox6.setChecked(false);
            }

        }
    }

























