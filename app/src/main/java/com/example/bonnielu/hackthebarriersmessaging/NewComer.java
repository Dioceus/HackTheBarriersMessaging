package com.example.bonnielu.hackthebarriersmessaging;

public class NewComer {
    String name;
    int age;
    String placeOfOrigin;
    String home;
    String school;
    String timeInCanada;
    int numLangs;
    String enteredLanguages;
    int environmentalFamiliarity; //MC
    int[] nationalLangs = new int[2]; //MC
    String communityLearningOutcomes;
    String interests;
    String futureAspirations;

    public String[] languages (String enteredLanguages, int numLangs){
        String langs[] = new String[numLangs];
        int start = 0;
        for (int i = 0; i < enteredLanguages.length(); i++) {
            if (enteredLanguages.charAt(i) == ',')  {
                langs[i] = enteredLanguages.substring(start, i-1);
                start = i+2;
            }
        }
        return langs;
    }

}
