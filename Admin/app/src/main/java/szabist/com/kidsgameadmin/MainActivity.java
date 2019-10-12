package szabist.com.kidsgameadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtusername,txtpassword;
    Button btn;
    TextView txtSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtusername = (EditText)findViewById(R.id.editTextUsername);
        txtpassword = (EditText)findViewById(R.id.editTextPassword);
        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = "test", password= "123";
                if(user.equals(txtusername.getText().toString()) && password.equals(txtpassword.getText().toString())){

                    Intent intent = new Intent(MainActivity.this,home1.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(getBaseContext(), "Incorrect Username or Password!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
