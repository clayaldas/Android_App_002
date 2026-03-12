package uta.edu.ec.android_app_002;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import uta.edu.ec.android_app_002.DAL.ContactDAL;
import uta.edu.ec.android_app_002.Entities.Contact;

public class ShowAllActivity extends AppCompatActivity {
    private ListView listViewData;
    private ArrayList<Contact> contactList;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_all);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listViewData = findViewById(R.id.listViewData);

        ContactDAL contactDAL = new ContactDAL(this);

        // recuperar los datos
        contactList = contactDAL.selectAll();

        /*
        // crear un adapter y formatear
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                contactList);

        // mostrar los datos en el listView
        if (contactList != null) {
            listViewData.setAdapter(adapter);
        }
        else {
            Toast.makeText(this, "No hay datos que mostrar", Toast.LENGTH_SHORT).show();
        }
         */

        ContactAdapter contactAdapter = new ContactAdapter(this, contactList );
        listViewData.setAdapter(contactAdapter);
    }
}