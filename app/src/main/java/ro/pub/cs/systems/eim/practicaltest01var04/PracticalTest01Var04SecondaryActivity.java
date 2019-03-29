package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {
    private EditText editText2 = null;
    private Button verifyButton = null;
    private Button cancelButton = null;


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.verify_button:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        editText2 = (EditText) findViewById(R.id.edit_text_2);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("text1")) {
            String text = intent.getStringExtra("text1");
            editText2.setText(text);
        }

        verifyButton = (Button)findViewById(R.id.verify_button);
        verifyButton.setOnClickListener(buttonClickListener);
        cancelButton = (Button)findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(buttonClickListener);
    }

}
