package com.peipeiyang.tablets;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A placeholder fragment containing a simple view.
 */
public class compareFragment extends Fragment {
    public static String Item1name = "item1name";
    public static String Item2name = "item2name";
    public static String Item3name = "item3name";
    public static String Item1system = "item1system";
    public static String Item2system = "item2system";
    public static String Item3system = "item3system";
    public static String Item1dimensions = "item1dimensions";
    public static String Item2dimensions = "item2dimensions";
    public static String Item3dimensions = "item3dimensions";
    public static String Item1weight = "item1weight";
    public static String Item2weight = "item2weight";
    public static String Item3weight = "item3weight";
    public static String Item1Photo ="photo1";
    public static String Item2Photo="photo2";
    public static String Item3Photo ="photo3";
    public static String OPINION = "opinion";
    public static ArrayList<String> receiver = new ArrayList<String>();
    public static ArrayList<CompareItem> finallist = new ArrayList<CompareItem>();
    public static CheckBox checkbox1;
    public static CheckBox checkbox2;
    public static CheckBox checkbox3;
    public static CompareItem list = new CompareItem();






    public compareFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_compare, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView tvname1 = (TextView) getActivity().findViewById(R.id.compare_item1name);
        TextView tvname2 = (TextView) getActivity().findViewById(R.id.compare_item2name);
        TextView tvname3 = (TextView) getActivity().findViewById(R.id.compare_item3name);
        TextView tvsystem1 = (TextView) getActivity().findViewById(R.id.compare_item1system);
        TextView tvsystem2 = (TextView) getActivity().findViewById(R.id.compare_item2system);
        TextView tvsystem3 = (TextView) getActivity().findViewById(R.id.compare_item3system);
        TextView tvdimensions1 = (TextView) getActivity().findViewById(R.id.compare_item1dimensions);
        TextView tvdimensions2 = (TextView) getActivity().findViewById(R.id.compare_item2dimensions);
        TextView tvdimensions3 = (TextView) getActivity().findViewById(R.id.compare_item3dimensions);
        TextView tvweight1 = (TextView) getActivity().findViewById(R.id.compare_item1weight);
        TextView tvweight2 = (TextView) getActivity().findViewById(R.id.compare_item2weight);
        TextView tvweight3 = (TextView) getActivity().findViewById(R.id.compare_item3weight);
        ImageView ivImage1 = (ImageView) getActivity().findViewById(R.id.compare_photo1);
        ImageView ivImage2 = (ImageView) getActivity().findViewById(R.id.compare_photo2);
        ImageView ivImage3 = (ImageView) getActivity().findViewById(R.id.compare_photo3);
        checkbox1 = (CheckBox) getActivity().findViewById(R.id.likeCheckBox1);
        checkbox2 = (CheckBox) getActivity().findViewById(R.id.likeCheckBox2);
        checkbox3 = (CheckBox) getActivity().findViewById(R.id.likeCheckBox3);
        List<CompareItem> holder = new ArrayList<CompareItem>();

         holder.add(new CompareItem("Amozon gen3","android 10.1", "8.5''", "3.2B", R.drawable.amozontablet));
         holder.add(new CompareItem("Dragon gen2", "android 10.1.2", "7.0''", "4.0B",R.drawable.dragon));
         holder.add(new CompareItem("HP x360", "window10", "12''", "3.8B",R.drawable.hp));
         holder.add(new CompareItem("LG SPEA", "android 10.1.3", "9.0''", "3.1B",R.drawable.lg));
         holder.add(new CompareItem("GALAXY gen2", "android 10.2", "8.0''", "4B",R.drawable.samsunggalaxytab));
         holder.add(new CompareItem("Sony gen3", "window10", "9.1''", "2.2B", R.drawable.sony));

        receiver = getActivity().getIntent().getExtras().getStringArrayList("items");

       for(int i=0;i<6;i++){
           if("1".equals(receiver.get(i))){
               finallist.add(holder.get(i));

           }
       }

        CompareItem list1 = new CompareItem();
        CompareItem list2 = new CompareItem();
        CompareItem list3 = new CompareItem();
        CompareItem empty = new CompareItem();


           int size = finallist.size();
            if (size==1)
                 list1 = finallist.get(0) ;
                checkbox1.setVisibility(getView().VISIBLE);
                checkbox2.setVisibility(View.GONE);
                checkbox3.setVisibility(View.GONE);
            if(size ==2){
                list1 = finallist.get(0) ;
                list2 = finallist.get(1);
                checkbox1.setVisibility(getView().VISIBLE);
                checkbox2.setVisibility(getView().VISIBLE);
                checkbox3.setVisibility(View.GONE);
            }
            if(size == 3){
                list1 = finallist.get(0);
                list2 = finallist.get(1);
                list3 = finallist.get(2);
                checkbox1.setVisibility(getView().VISIBLE);
                checkbox2.setVisibility(getView().VISIBLE);
                checkbox3.setVisibility(getView().VISIBLE);
            }




        tvname1.setText(list1.getNames());
        tvsystem1.setText(list1.getSystem());
        tvdimensions1.setText((list1.getDemensions()));
        tvweight1.setText((list1.getWeight()));
        ivImage1.setImageResource((list1.getPhoto()));

        tvname2.setText(list2.getNames());
        tvsystem2.setText(list2.getSystem());
        tvdimensions2.setText((list2.getDemensions()));
        tvweight2.setText((list2.getWeight()));
        ivImage2.setImageResource((list2.getPhoto()));

        tvname3.setText(list3.getNames());
        tvsystem3.setText(list3.getSystem());
        tvdimensions3.setText((list3.getDemensions()));
        tvweight3.setText((list3.getWeight()));
        ivImage3.setImageResource((list3.getPhoto()));



            Button T = (Button) getActivity().findViewById(R.id.compare_done);
            T.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent data = new Intent();

                    receiver = new ArrayList<String>(Arrays.asList("0", "0", "0", "0", "0", "0"));
                    finallist.clear();
                    ArrayList<String> likecheck = new ArrayList<String>(Arrays.asList("0", "0", "0"));
                    if(checkbox1.isChecked())
                        likecheck.set(0,"1");
                    if(checkbox2.isChecked())
                        likecheck.set(1,"1");
                    if(checkbox3.isChecked())
                        likecheck.set(2,"1");

                    data.putExtra(OPINION, likecheck);
                    getActivity().setResult(Activity.RESULT_OK, data);
                    getActivity().finish();
                }
            });
        }


    }



