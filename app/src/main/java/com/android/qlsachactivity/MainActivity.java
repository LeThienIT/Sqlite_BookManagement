package com.android.qlsachactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDatabase myDatabase = null;
    final String TABLE_NAME = "tb1_sach";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase = new MyDatabase(MainActivity.this, "qlsach.sqlite", null, 1);
        String create_table = "create table if not exists "+TABLE_NAME+"(id integer primary key autoincrement, bookId integer, bookName varchar(100), page integer, price float, description text)";
        myDatabase.executeSQL(create_table);
//        insertBook(new Book(0,123,  "Sách lập trình Java", 100, 3000000, "Sách hay"));
//        insertBook(new Book(0,456,  "Sách lập trình Python", 50, 5000000, "Sách hay"));
//        insertBook(new Book(0,789,  "Sách lập trình C++", 200, 7000000, "Sách hay"));
        printData("tb1_sach");
    }

    public boolean insertBook(Book book){
        try {
            String sql_insert = "insert into "+TABLE_NAME+" values(null, "+book.getBookId()+", '"+book.getBookName()+"', "+book.getPage()+", "+book.getPrice()+", '"+book.getDescription()+"')";
            myDatabase.executeSQL(sql_insert);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBook(Book book){
        try {
            String sql_update = "update "+TABLE_NAME+" set bookId = '"+book.getBookId()
                    +", bookName = '"+book.getBookName()
                    +"', page = "+book.getPage()
                    +", price = "+book.getPrice()
                    +", description = '"+book.getDescription()
                    +"' where id = "+book.getId();
            myDatabase.executeSQL(sql_update);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBook(Book book){
        try {
            String sql_delete = "delete from "+TABLE_NAME+" where id = " + book.getId();
            myDatabase.executeSQL(sql_delete);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBook(int id){
        try {
            String sql_delete = "delete from "+TABLE_NAME+" where id = " + id;
            myDatabase.executeSQL(sql_delete);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private void printData(String tableName) {
        Cursor cursor = myDatabase.selectData("select * from " + tableName);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            int bookId = cursor.getInt(1);
            String bookName = cursor.getString(2);
            int page = cursor.getInt(3);
            float price = cursor.getFloat(4);
            String description = cursor.getString(5);

            Book book = new Book(id, bookId, bookName, page, price, description);
            Toast.makeText(MainActivity.this, "" + book, Toast.LENGTH_SHORT).show();
        }
    }

}