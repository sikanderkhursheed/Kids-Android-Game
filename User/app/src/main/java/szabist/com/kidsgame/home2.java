package szabist.com.kidsgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import szabist.com.kidsgame.Model.Items;

public class home2 extends AppCompatActivity {

    EditText txtname;
    ImageView image;
    Button btn;
    Items items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        txtname = (EditText)findViewById(R.id.txtName);
        image = (ImageView) findViewById(R.id.imageView);
        btn = (Button) findViewById(R.id.btnCheck);
        items = (Items) getIntent().getSerializableExtra("items");

        Picasso.with(image.getContext()).load(items.picture).into(image);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String i = items.name.toLowerCase();
                if (i.equals(txtname.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Correct Answer!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(home2.this, Home.class);
                    startActivity(intent);


                } else {
                    Toast.makeText(getBaseContext(), "Incorrect Answer!", Toast.LENGTH_LONG).show();
                }
            }

        });

    }
}
