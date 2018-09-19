package com.example.bonnielu.hackthebarriersmessaging;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class SurveyActivity extends AppCompatActivity {
    public static NewComer newYouth = new NewComer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
          // public NewComer newYouth = new NewComer();
            @Override
            public void onClick(View view) {

                EditText[] textResponses = new EditText[11];
                String[] radioBtnResponses = new String[3];
                textResponses[0] = (EditText) findViewById(R.id.nameText);
                textResponses[1] = (EditText) findViewById(R.id.ageText);
                textResponses[2] = (EditText) findViewById(R.id.homeText);
                textResponses[3] = (EditText) findViewById(R.id.originText);
                textResponses[4] = (EditText) findViewById(R.id.schoolText);
                textResponses[5] = (EditText) findViewById(R.id.timeInCanText);
                textResponses[6] = (EditText) findViewById(R.id.numFluentLangText);
                textResponses[7] = (EditText) findViewById(R.id.languagesText);
                textResponses[8] = (EditText) findViewById(R.id.communityLearningText);
                textResponses[9] = (EditText) findViewById(R.id.interestsText);
                textResponses[10] = (EditText) findViewById(R.id.futureAspirationsText);

                newYouth.name = textResponses[0].getText().toString();
                newYouth.age = Integer.parseInt(textResponses[1].getText().toString());
                newYouth.placeOfOrigin = textResponses[2].getText().toString();
                newYouth.home = textResponses[3].getText().toString();
                newYouth.school = textResponses[4].getText().toString();
                newYouth.timeInCanada = textResponses[5].getText().toString();
                newYouth.numLangs = Integer.parseInt(textResponses[6].getText().toString());
                newYouth.languages(textResponses[7].getText().toString(), newYouth.numLangs);
                newYouth.communityLearningOutcomes = textResponses[8].getText().toString();
                newYouth.interests = textResponses[9].getText().toString();
                newYouth.futureAspirations = textResponses[10].getText().toString();


                newYouth.nationalLangs[1] = Integer.parseInt(radioBtnResponses[2]);


            } public void onRadioButtonClicked(View view) {
                // Is the button now checked?
                boolean checked = ((RadioButton) view).isChecked();

                // Check which radio button was clicked
                switch (view.getId()) {
                    case R.id.one:
                        if (checked) {
                            newYouth.environmentalFamiliarity = 1;
                            break;
                        }

                    case R.id.two:
                        if (checked) {
                            newYouth.environmentalFamiliarity = 2;
                            break;
                        }
                    case R.id.three:
                        if (checked) {
                            newYouth.environmentalFamiliarity = 3;
                            break;
                        }
                    case R.id.four:
                        if (checked) {
                            newYouth.environmentalFamiliarity = 4;
                            break;
                        }
                    case R.id.five:
                        if (checked) {
                            newYouth.environmentalFamiliarity = 5;
                            break;
                        }
                }

                switch (view.getId()) {
                    case R.id.onea:
                        if (checked) {
                            newYouth.nationalLangs[0] = 1;
                            break;
                        }

                    case R.id.twoa:
                        if (checked) {
                            newYouth.nationalLangs[0] = 2;
                            break;
                        }
                    case R.id.threea:
                        if (checked) {
                            newYouth.nationalLangs[0] = 3;
                            break;
                        }
                    case R.id.foura:
                        if (checked) {
                            newYouth.nationalLangs[0] = 4;
                            break;
                        }
                    case R.id.fivea:
                        if (checked) {
                            newYouth.nationalLangs[0] = 5;
                            break;
                        }
                }

                switch (view.getId()) {
                    case R.id.oneb:
                        if (checked) {
                            newYouth.nationalLangs[1] = 1;
                            break;
                        }

                    case R.id.twob:
                        if (checked) {
                            newYouth.nationalLangs[1] = 2;
                            break;
                        }
                    case R.id.threeb:
                        if (checked) {
                            newYouth.nationalLangs[1] = 3;
                            break;
                        }
                    case R.id.fourb:
                        if (checked) {
                            newYouth.nationalLangs[1] = 4;
                            break;
                        }
                    case R.id.fiveb:
                        if (checked) {
                            newYouth.nationalLangs[1] = 5;
                            break;
                        }
                }
            }


        });
    }
}

