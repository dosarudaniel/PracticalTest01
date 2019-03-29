package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {


    private EditText editText = null;
    private Button topleftb = null;
    private Button toprightb = null;
    private Button centerb = null;
    private Button bottomleftb = null;
    private Button bottomrightb = null;
    private  int nrOFClicks;
    private String text = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        nrOFClicks = 0;
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("numberOfClicks")) {
                Log.d("TAG11", "aici + savedInstanceState.getString(\"numberOfClicks\")");
                nrOFClicks = Integer.parseInt(savedInstanceState.getString("numberOfClicks"));
            }
        }

        topleftb = findViewById(R.id.top_left_b);
        toprightb = findViewById(R.id.top_right_b);
        centerb = findViewById(R.id.center_b);
        bottomrightb = findViewById(R.id.bottom_right_b);
        bottomleftb = findViewById(R.id.bottom_left_b);
        editText = (EditText)findViewById(R.id.edit_text);

        topleftb.setOnClickListener(new View.OnClickListener() {
            String val = editText.getText().toString();
            @Override
            public void onClick(View view) {
                val += "Top Left,";
                text = val;
                editText.setText(val);
                nrOFClicks++;
            }
        });

        toprightb.setOnClickListener(new View.OnClickListener() {
            String val = editText.getText().toString();
            @Override
            public void onClick(View view) {
                val += "Top Right,";
                text = val;
                editText.setText(val);
                nrOFClicks++;
            }
        });

        centerb.setOnClickListener(new View.OnClickListener() {
            String val = editText.getText().toString();
            @Override
            public void onClick(View view) {
                val += "Center,";
                text = val;
                editText.setText(val);
                nrOFClicks++;
            }
        });

        bottomleftb.setOnClickListener(new View.OnClickListener() {
            String val = editText.getText().toString();
            @Override
            public void onClick(View view) {
                val += "Bottom Left,";
                text = val;
                editText.setText(val);
                nrOFClicks++;
            }
        });

        bottomrightb.setOnClickListener(new View.OnClickListener() {
            String val = editText.getText().toString();
            @Override
            public void onClick(View view) {
                val += "Bottom Right,";
                text = val;
                editText.setText(val);
                nrOFClicks++;
            }
        });

        navigateToSecondaryActivityButton = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("numberOfClicks", String.valueOf(nrOFClicks));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("numberOfClicks")) {

            Toast.makeText(this, "NR_ofclicks = " + String.valueOf(nrOFClicks), Toast.LENGTH_LONG).show();
        }
    }


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            editText = (EditText)findViewById(R.id.edit_text);
            switch(view.getId()) {
                case R.id.navigate_to_secondary_activity_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
                    String text1 = editText.getText().toString();
                    intent.putExtra("text1", text1);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
                // ...
            }
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
            nrOFClicks = 0;
        }
    }

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private Button navigateToSecondaryActivityButton = null;
}
