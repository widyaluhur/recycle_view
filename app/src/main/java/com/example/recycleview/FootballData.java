package com.example.recycleview;

import java.util.ArrayList;

public class FootballData {
    private static String[] title = new String[]{"soto","sate","gudeg","pempek","siomay","seblak","nasigoreng","bakso","rendang","ayamopor"};

    private static int[] thumbnail = new
            int[]{R.drawable.soto,R.drawable.sate,
            R.drawable.gudeg,R.drawable.pempek,R.drawable.siomay,R.drawable.seblak,
            R.drawable.nasigoreng,R.drawable.bakso,R.drawable.rendang,R.drawable.ayamopor};

    private static String[] preview = new String[]{
            "ini soto","ini sate","ini gudeg","ini pempek","siomay","seblak","nasigoreng","bakso","rendang","ayamopor"
    };

    public static ArrayList<FootballModel> getListData(){
        FootballModel footballModel = null;
        ArrayList<FootballModel> list = new ArrayList<>();
        for (int i = 0; i <title.length; i++){
            footballModel = new FootballModel();
            footballModel.setLambangTeam(thumbnail[i]);
            footballModel.setNamaTeam(title[i]);
            footballModel.setPrivew(preview[i]);
            list.add(footballModel);
        }
        return list;
    }
}
