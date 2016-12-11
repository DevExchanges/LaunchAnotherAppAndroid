package info.devexchanges.secondapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        View btnBack = findViewById(R.id.button);
        final EditText editText = (EditText) findViewById(R.id.edit_text);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("EditText_Value", editText.getText().toString().trim());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
