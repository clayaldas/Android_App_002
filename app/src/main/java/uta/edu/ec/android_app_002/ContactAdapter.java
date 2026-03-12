package uta.edu.ec.android_app_002;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import uta.edu.ec.android_app_002.Entities.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private List<Contact> contactList;
    public ContactAdapter(@NonNull Context context, @NonNull List<Contact> contactList) {
        super(context, 0, contactList);

        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_contact,
                    parent, false);
        }

        Contact contact = contactList.get(position);

        TextView textViewCode = convertView.findViewById(R.id.textViewCode);
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewLastName = convertView.findViewById(R.id.textViewLastName);
        TextView textViewAge = convertView.findViewById(R.id.textViewAge);

        textViewCode.setText(String.valueOf(contact.getCode()));
        textViewName.setText(String.valueOf(contact.getName()));
        textViewLastName.setText(String.valueOf(contact.getLastName()));
        textViewAge.setText(String.valueOf(contact.getAge()));

        return  convertView;
    }
}
