package com.example.login_app.loginRegister.Sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.login_app.loginRegister.modal.DemandeAss;
import com.example.login_app.loginRegister.modal.User;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    private static final String TABLE_DEMANDE = "demandeAss";
    private static final String COLUMN_DEMANDE_ID = "demande_id";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_BIRTHAY = "birdthay";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_TELE = "tel";
    private static final String COLUMN_PERMIS = "permis";
    private static final String COLUMN_IMMAT = "immat";
    private static final String COLUMN_MODULE = "module";
    private static final String COLUMN_MARQUE = "marque";
    private static final String COLUMN_CARBURANT = "carburant";
    private static final String COLUMN_PUISSACE = "puissace";
    private static final String DATEMISEENCIRCULATION = "dateMisECirculation";
    private static final String COLUMN_TYPECONTRAT = "typeContrat";
    private static final String COLUMN_DATEDEM = "dateDem";
    private static final String COLUMN_IDUSER = "id_user";


    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    private static final String CREATE_DEMANDE_TABLE = "CREATE TABLE " + TABLE_DEMANDE + "("
            + COLUMN_DEMANDE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FIRST_NAME + " TEXT,"
            + COLUMN_BIRTHAY + " TEXT ," + COLUMN_CITY + " TEXT," + COLUMN_TELE + " TEXT," + COLUMN_PERMIS +
            " INTEGER," + COLUMN_IMMAT + " TEXT," + COLUMN_MODULE + " TEXT," + COLUMN_MARQUE + " TEXT," +
            COLUMN_CARBURANT + " TEXT," + COLUMN_PUISSACE + " TEXT," + DATEMISEENCIRCULATION + " TEXT," + COLUMN_TYPECONTRAT +
            " TEXT," + COLUMN_DATEDEM + " TEXT," + COLUMN_IDUSER + " INTEGER REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + ")" + ")";


    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
    private String DROP_DEMANDE_TABLE = "DROP TABLE IF EXISTS " + TABLE_DEMANDE;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_DEMANDE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);
        db.execSQL(DROP_DEMANDE_TABLE);
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }


    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<DemandeAss> getAllDEMANDE() {
        // array of columns to fetch
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" yyyy-mm-dd");
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            String[] columns = {
                    COLUMN_DEMANDE_ID,
                    COLUMN_FIRST_NAME,
                    COLUMN_BIRTHAY,
                    COLUMN_CITY,
                    COLUMN_TELE,
                    COLUMN_PERMIS,
                    COLUMN_IMMAT,
                    COLUMN_MODULE,
                    COLUMN_MARQUE,
                    COLUMN_CARBURANT,
                    COLUMN_PUISSACE,
                    DATEMISEENCIRCULATION,
                    COLUMN_TYPECONTRAT,
                    COLUMN_DATEDEM,
                    COLUMN_IDUSER,
            };
            // sorting orders
            //   String sortOrder =COLUMN_DEMANDE_ID + " ASC";
            List<DemandeAss> demandeList = null;
            SQLiteDatabase db = this.getReadableDatabase();
            // query the user table
            /**
             * Here query function is used to fetch records from user table this function works like we use sql query.
             * SQL query equivalent to this query function is
             * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
             */
            Cursor cursor = db.rawQuery("select * from " + TABLE_DEMANDE, null);
          /*  query(TABLE_DEMANDE, //Table to query
                    columns,    //columns to return
                    null,        //columns for the WHERE clause
                    null,        //The values for the WHERE clause
                    null,       //group the rows
                    null,       //filter by row groups
                    //sortOrder); //The sort order
            //  Traversing through all rows and adding to list*/

            if (cursor.moveToFirst()) {
                demandeList = new ArrayList<DemandeAss>();
                do {
                    DemandeAss demandeAss = new DemandeAss();
                    demandeAss.setId_dem(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DEMANDE_ID))));
                    demandeAss.setFirst_name(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FIRST_NAME)));
                    demandeAss.setBirdthay(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_BIRTHAY)));
                    demandeAss.setCity(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CITY)));
                    demandeAss.setTele(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TELE)));
                    demandeAss.setPermis(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PERMIS))));
                    demandeAss.setImmat(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IMMAT)));
                    demandeAss.setMarque(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MARQUE)));
                    demandeAss.setModule(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MODULE)));
                    demandeAss.setCarburant(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CARBURANT)));
                    demandeAss.setPuissance(Double.parseDouble(decimalFormat.format(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PUISSACE)))));
                    demandeAss.setDateMisEnCirculation(cursor.getString(cursor.getColumnIndexOrThrow(DATEMISEENCIRCULATION)));
                    demandeAss.setType(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TYPECONTRAT)));
                    demandeAss.setDateDem(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATEDEM)));
                    // Adding user record to list
                    demandeList.add(demandeAss);
                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
            // return user list
            return demandeList;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean addDemande(DemandeAss demandeAss) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_FIRST_NAME, demandeAss.getFirst_name());
            values.put(COLUMN_BIRTHAY, demandeAss.getBirdthay());
            values.put(COLUMN_CITY, demandeAss.getCity());
            values.put(COLUMN_TELE, demandeAss.getTele());
            values.put(COLUMN_PERMIS, demandeAss.getPermis());
            values.put(COLUMN_IMMAT, demandeAss.getImmat());
            values.put(COLUMN_MODULE, demandeAss.getModule());
            values.put(COLUMN_MARQUE, demandeAss.getMarque());
            values.put(COLUMN_CARBURANT, demandeAss.getCarburant());
            values.put(COLUMN_PUISSACE, demandeAss.getPuissance());
            values.put(DATEMISEENCIRCULATION, demandeAss.getDateMisEnCirculation());
            values.put(COLUMN_TYPECONTRAT, demandeAss.getType());
            values.put(COLUMN_DATEDEM, demandeAss.getDateDem());
            // Inserting Row*/

            return db.insert(TABLE_DEMANDE, null, values) > 0;
        } catch (Exception e) {
            return false;
        }

    }


    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    public void updateDemandeAss(DemandeAss demandeAss) {
        SQLiteDatabase db = this.getWritableDatabase();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" yyyy-mm-dd");
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, demandeAss.getFirst_name());
        values.put(COLUMN_BIRTHAY, simpleDateFormat.format(demandeAss.getBirdthay()));
        values.put(COLUMN_CITY, demandeAss.getCity());
        values.put(COLUMN_TELE, demandeAss.getTele());
        values.put(COLUMN_PERMIS, demandeAss.getPermis());
        values.put(COLUMN_IMMAT, demandeAss.getImmat());
        values.put(COLUMN_MODULE, demandeAss.getModule());
        values.put(COLUMN_MARQUE, demandeAss.getMarque());
        values.put(COLUMN_CARBURANT, demandeAss.getCarburant());
        values.put(COLUMN_PUISSACE, demandeAss.getPuissance());
        values.put(DATEMISEENCIRCULATION, simpleDateFormat.format(demandeAss.getDateMisEnCirculation()));
        values.put(COLUMN_TYPECONTRAT, demandeAss.getType());
        values.put(COLUMN_DATEDEM, simpleDateFormat.format(demandeAss.getDateDem()));
        // updating row
        db.update(TABLE_DEMANDE, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(demandeAss.getId_dem())});
        db.close();
    }


    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    public void deleteDemandeAss(DemandeAss demandeAss) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_DEMANDE, COLUMN_DEMANDE_ID + " = ?",
                new String[]{String.valueOf(demandeAss.getId_dem())});
        db.close();
    }


    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public boolean checkDemande(String immat) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_DEMANDE_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_IMMAT + " = ?";
        // selection argument
        String[] selectionArgs = {immat};
        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_DEMANDE, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

}

