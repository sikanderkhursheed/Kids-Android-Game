package szabist.com.kidsgameadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home1 extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        goList();
        goAdd();
    }

    public void goList(){
        button = (Button)findViewById(R.id.lsit);

        button.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(home1.this, Home.class);
                        startActivity(intent);

                    }
                }
        );
    }

    public void goAdd(){

        button = (Button)findViewById(R.id.btnAdd);

        button.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(home1.this, Add.class);
                        startActivity(intent);

                    }
                }
        );
    }
}
