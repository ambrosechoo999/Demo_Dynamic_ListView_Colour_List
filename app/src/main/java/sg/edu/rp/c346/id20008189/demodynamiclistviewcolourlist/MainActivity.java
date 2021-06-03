package sg.edu.rp.c346.id20008189.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextColour;
    Button btnAddItem;
    ListView listViewColour;
    EditText etIndexElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextColour=findViewById(R.id.editTextColour);
        btnAddItem=findViewById(R.id.btnAddItem);
        listViewColour=findViewById(R.id.listViewColour);
        etIndexElement=findViewById(R.id.etIndexElement);
        ArrayList<String> alColours = new ArrayList<String>( );
        alColours.add("Red");
        alColours.add("Orange");
        ArrayAdapter<String> aaColours=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);
        listViewColour.setAdapter(aaColours);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = editTextColour.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos,colour);
                aaColours.notifyDataSetChanged();
            }
        });
        listViewColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour= alColours.get(position);
                Toast.makeText(MainActivity.this, colour+" is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}