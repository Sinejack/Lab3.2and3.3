package my.edu.tarc.lab32and33;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge=(Spinner)findViewById(R.id.spinnerAge);

        spinnerAge.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);


        radioGroupGender=(RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale=(RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale=(RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker=(CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium=(TextView)findViewById(R.id.textViewPremium);

        textViewPremium.setTextSize(16.0f);
    }

    @Override
    //parent is the main activity
    //view is the spinner itself
    //position is the item selected by user
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"Position "+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void calculatePremium(View view)
    {
        float premium=0.0f;
        int position;
        int idGender;
        boolean isSmoker;

        position=spinnerAge.getSelectedItemPosition();
        idGender=radioGroupGender.getCheckedRadioButtonId();
        isSmoker=checkBoxSmoker.isChecked();
       switch (position)
       {
           case 1:
           {
               premium+=50.0f;
               break;
           }
           case 2:
           {
               premium+=55.0f;
               break;
           }
           case 3:
           {
               premium += 60.0f;
               break;
           }
           case 4:
           {
               premium+=70.0f;
               break;
           }
           case 5:
           {
               premium+=120.0f;
               break;
           }
           case 6:
           {
               premium+=160.0f;
               break;
           }
           case 7:
           {
               premium+=200.0f;
               break;
           }
           case 8:
           {
               premium+=250.0f;
               break;
           }
           default:
               break;
       }

        if(idGender==R.id.radioButtonMale)
        {
            switch (position)
            {
                case 3:
                case 6:
                {
                    premium+=50.0f;
                    break;
                }

                case 4:
                case 5:
                {
                    premium+=100.0f;
                    break;
                }

                default:
                    break;
            }
        }
        if(isSmoker)
        {
            switch (position)
            {
                case 4:
                {
                    premium+=100.0f;
                    break;
                }
                case 5:
                case 6:
                {
                    premium+=150.0f;
                    break;
                }
                case 7:
                case 8:
                {
                    premium+=250.0f;
                    break;
                }
                default:break;
            }
        }
        textViewPremium.setText(getString(R.string.premium)+premium);
    }
    public void resetDisplay(View view)
    {
        //Reset text, use setText(string)
        textViewPremium.setText(getString(R.string.premium));

        //Reset radio group buttons, use clearCheck(void)
        radioGroupGender.clearCheck();

        //Reset checkbox, use setChecked(boolean)
        checkBoxSmoker.setChecked(false);

        //Reset spinner, use setSelection(int)
        spinnerAge.setSelection(0);
    }
}
