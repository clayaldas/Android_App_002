package uta.edu.ec.android_app_002.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import uta.edu.ec.android_app_002.Entities.Contact;
public class ContactDAL {
    private MasterPersistence persistence;// crear la BD
    private SQLiteDatabase sql;// comandos SQL
    private Context context;// para utiliza en el constructor

    public ContactDAL(Context context) {
        this.context = context;
    }

    public void openReadable() {
        // crear la base de datos
        persistence = new MasterPersistence(context, "DB_CONTACTS", null, 1);

        // abrir la base en modo: lectura/escribir
        sql = persistence.getReadableDatabase();
    }

    public void openWritable() {
        // crear la base de datos
        persistence = new MasterPersistence(context, "DB_CONTACTS", null, 1);

        // abrir la base en modo: lectura/escribir
        sql = persistence.getWritableDatabase();
    }

    public void close() {
        sql.close();
    }

    public long insert(Contact contact) {
        long count = 0;

        openWritable();

        try {
            ContentValues values = new ContentValues();
            values.put("Name", contact.getName());
            values.put("LastName", contact.getLastName());
            values.put("Age", contact.getAge());

           count =  sql.insert("Contacts", null, values);
        } catch (Exception e) {
            throw e;
        }
        finally {
            sql.close();
        }

        return count;
    }

    public Contact searchByCode(int code){
        openReadable();

        Contact contact = null;

        try {


        } catch (Exception e) {
            throw e;
        }
        finally {
            sql.close();
        }

        return  contact;
    }
}
