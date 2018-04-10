package sci.iam.learnapp;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;



public class DataBaseForSignUp {

    DBinfo dbinfo;
    Cursor c = null;

    public DataBaseForSignUp(Context context){

        dbinfo = new DBinfo(context);

    }


    public long insertUserData(String username, String password){

        SQLiteDatabase sqLiteDatabase = dbinfo.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBinfo.username , username);
        contentValues.put(DBinfo.password , password);

        long id = sqLiteDatabase.insert(DBinfo.tableSignUp,null,contentValues);
        return id;

    }

    public ArrayList searchUserData(String name,String pass){

        SQLiteDatabase sqLiteDatabase = dbinfo.getWritableDatabase();
        String [] columns = {DBinfo.username,DBinfo.password};
        Cursor cursor = sqLiteDatabase.query(DBinfo.tableSignUp,columns,DBinfo.username+" = '"+name+"' and "+DBinfo.password+" = '"+pass+"'",null,null,null,null);

        ArrayList<String> user_pass = new ArrayList <String>();

        while(cursor.moveToNext()){
            int index1 = cursor.getColumnIndex(DBinfo.username);
            int index2 = cursor.getColumnIndex(DBinfo.password);

            String username = cursor.getString(index1);
            String password = cursor.getString(index2);

            user_pass.add(username);
            user_pass.add(password);

        }

        return user_pass;
    }

    public String searchUser(String name){

        SQLiteDatabase sqLiteDatabase = dbinfo.getWritableDatabase();
        String nom_m = null;

        String [] columns = {DBinfo.username};
        Cursor cursor = sqLiteDatabase.query(DBinfo.tableSignUp,columns,DBinfo.username+" = '"+name+"'",null,null,null,null);


        while(cursor.moveToNext()){

            nom_m = cursor.getString(0);
        }

        return nom_m;
    }




    static class DBinfo extends SQLiteOpenHelper {



        static final String tableSignUp  = "user";
        static final int dataBase_Version = 2;

        private static final String UID = "id";

        static final String username = "Username";
        static final String password = "Password";

        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+tableSignUp;


        private static final String CREATE_TABLE = "CREATE TABLE "+tableSignUp+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                username+" VARCHAR(255), "+password+" VARCHAR(255));" ;



        String DB_PATH = null;
        static String DB_NAME = "database_";

        final Context myContext;


        public DBinfo(Context context) {
            super(context, DB_NAME, null, dataBase_Version);
            this.myContext = context;

            if (android.os.Build.VERSION.SDK_INT >= 4.2) {
                DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
            } else {
                DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
            }

        }



        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            try{
                sqLiteDatabase.execSQL(CREATE_TABLE);
            }
            catch (SQLException e){
                Toast.makeText(myContext,"due to: "+e,Toast.LENGTH_LONG).show();
            }



        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

            try{
                sqLiteDatabase.execSQL(DROP_TABLE);
                System.out.println("table deleted");
                onCreate(sqLiteDatabase);

            }
            catch (SQLException e){
                Toast.makeText(myContext,"due to: "+e,Toast.LENGTH_LONG).show();
            }

        }



    }




}
