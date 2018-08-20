package com.example.juan.loginsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juan.loginsqlite.Datos.UserDbHelper;
import com.example.juan.loginsqlite.Datos.UsersContract;

public class MainActivity extends AppCompatActivity {

    private EditText edUser, edPass;
    private Button btnIngresar;

    private String user, pass;
    private UserDbHelper userDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDbHelper = new UserDbHelper(this);

        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);
        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = edUser.getText().toString();
                pass = edPass.getText().toString();
                boolean flag = existe(user, pass);
                System.out.println("DATOS: " + user + pass);
                System.out.println("ASD: " + edUser.getText().toString() + edPass.getText().toString());
                if (flag){
                    Toast toast = Toast.makeText(getApplicationContext(), "Good", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "BAD", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    public boolean existe(String user, String pass){
        SQLiteDatabase db = userDbHelper.getReadableDatabase();
        String sql = "SELECT * FROM " + UsersContract.UserEntry.TABLE_NAME +
                " WHERE user=? and pass=?";
        String[] values = {user, pass};
        Cursor c = db.rawQuery(sql, values);

        if (c.getCount() > 0){
            return true;
        }
        return false;
    }

        /*public void existe(View view){
        SQLiteDatabase db = userDbHelper.getReadableDatabase();

        String[] projection = {UsersContract.UserEntry.USER, UsersContract.UserEntry.PASSWORD};

        String selection = UsersContract.UserEntry.USER + "=? " + " ," +
                UsersContract.UserEntry.PASSWORD + "=?";
        String[] selectionArgs = { user, pass };

        Cursor cursor = db.query(UsersContract.UserEntry.TABLE_NAME, projection, selection,
                selectionArgs,null, null, null);

        if (cursor.getCount() > 0){
            Toast toast = Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_SHORT);
            toast.show();
        }
    }*/
}
