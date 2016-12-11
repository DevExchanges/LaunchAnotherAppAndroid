package info.devexchanges.firstapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class FistActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 111;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        textView = (TextView) findViewById(R.id.text);
        View btnGo = findViewById(R.id.button);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent("info.devexchanges.secondsapp.SECOND_ACTIVITY");
                    startActivityForResult(intent, REQUEST_CODE);
                } catch (ActivityNotFoundException ex) {
                    ex.printStackTrace();
                    Log.e("Main", "Second application is not installed!");
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String intentData = data.getStringExtra("EditText_Value");
                textView.setText(intentData);
            } else {
                textView.setText("User press back at Second Activity");
            }
        }
    }
}
