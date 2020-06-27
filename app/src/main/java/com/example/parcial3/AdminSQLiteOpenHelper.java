package com.example.parcial3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table usertable(user text primary key, password text)");
        BaseDeDatos.execSQL("insert into usertable(user, password)" + "values('admin1', 'admin')");
        BaseDeDatos.execSQL("insert into usertable(user, password)" + "values('consumer1', 'consumer')");
        BaseDeDatos.execSQL("create table recetas(producto text primary key, foto text, ingrediente1 text, ingrediente2 text, ingrediente3 text, ingrediente4 text, ingrediente5 text, preparacion text)");
        BaseDeDatos.execSQL("create table favoritos(producto text, foto text, preparacion text, comentario text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int i, int i1) {
        BaseDeDatos.execSQL("drop table if exists usertable");
        BaseDeDatos.execSQL("drop table if exists recetas");
    }

    //Insertar usuario
    public boolean insert(String user,String password){
        SQLiteDatabase BaseDeDatos = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user",user);
        contentValues.put("password",password);
        long ins = BaseDeDatos.insert("usertable", null, contentValues);
        if (ins==-1) return false;
        else return true;
    }

    //Verificar si el usuario existe
    public Boolean checkuser(String user){
        SQLiteDatabase BaseDeDatos = this.getReadableDatabase();
        Cursor cursor = BaseDeDatos.rawQuery("Select * from usertable where user=?", new String[]{user});
        if (cursor.getCount()>0) return false;
        else return true;
    }

    //Comprobar que se encuentra registrado
    public Boolean userpassword(String user,String password){
        SQLiteDatabase BaseDeDatos = this.getReadableDatabase();
        Cursor cursor = BaseDeDatos.rawQuery("select * from usertable where user=? and password=?", new String[]{user,password});
        if (cursor.getCount()>0) return true;
        else return false;
    }

}
