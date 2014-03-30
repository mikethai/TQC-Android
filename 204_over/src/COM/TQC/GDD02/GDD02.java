package COM.TQC.GDD02;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class GDD02 extends Activity
{
  private mySQLiteOpenHelper gaaSQLiteOpenHelper;
  private Cursor myCursor;
  private ListView myListView;
  private EditText myEditText;
  private int _id;
  protected final static int MENU_ADD = Menu.FIRST;
  protected final static int MENU_EDIT = Menu.FIRST + 1;
  protected final static int MENU_DELETE = Menu.FIRST + 2;

  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {
    super.onOptionsItemSelected(item);
    switch (item.getItemId())
    {
      case MENU_ADD:
        this.addTodo();
        break;
      case MENU_EDIT:
        this.editTodo();
        break;
      case MENU_DELETE:
        this.deleteTodo();
        break;
    }
    return true;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    super.onCreateOptionsMenu(menu);
    //1
   ////////////新增menu的名字與實作//////////
    menu.add(0, MENU_ADD, 0, getString(R.string.strAddButton));
    menu.add(0, MENU_EDIT, 1, getString(R.string.strEditButton));
    menu.add(0, MENU_DELETE, 2, getString(R.string.strDeleteButton));
    ///////////////////////////////////

    return true;
  }

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    myListView = (ListView) this.findViewById(R.id.myListView);
    myEditText = (EditText) this.findViewById(R.id.myEditText);

    gaaSQLiteOpenHelper = new mySQLiteOpenHelper(this);
    
    myCursor = gaaSQLiteOpenHelper.select();

    
    SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list,
        myCursor, new String[]
        { gaaSQLiteOpenHelper.FIELD_TEXT }, new int[]
        { R.id.listTextView1 });
    myListView.setAdapter(adapter);

    
    myListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {

      
      public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
          long arg3)
      {
        
        myCursor.moveToPosition(arg2);
        
        _id = myCursor.getInt(0);
        
        myEditText.setText(myCursor.getString(1));
      }

    });
    myListView
        .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

          
          public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
              long arg3)
          {
           //2
        	  
           ////////////獲得SQLitecursor，並從SQLlite抓取資料////////////////
        	SQLiteCursor sc= (SQLiteCursor) arg0.getSelectedItem();
        	//////////////取得該筆資料的第0個欄位整數/////////////////////////
        	_id=sc.getInt(0);
        	//////////////取得該筆資料的第1筆欄位內容，並把資料填到Edittext////////
        	myEditText.setText(sc.getString(1));
        	
        	  
        	  
          }

          
          public void onNothingSelected(AdapterView<?> arg0)
          {

          }

        });

  }

  private void addTodo()
  {
   //3
	if(myEditText.getText().toString().equals(""))
		return;
	///////把資料insert到SQLite/////////
	  gaaSQLiteOpenHelper.insert(myEditText.getText().toString());
	//重新查詢資料庫內容，並重新顯示，_id歸零
	  myCursor.requery();
	  myListView.invalidateViews();
	  myEditText.setText("");
	  _id=0;
	  
  }

  private void editTodo()
  {
   //4 
	  if(myEditText.getText().toString().equals(""))
			return;
		///////把資料update到SQLite/////////
		  gaaSQLiteOpenHelper.update(_id, myEditText.getText().toString());
		//重新查詢資料庫內容，並重新顯示，_id歸零
		  myCursor.requery();
		  myListView.invalidateViews();
		  myEditText.setText("");
		  _id=0; 
	  	  
  }

  private void deleteTodo()
  {
   //5
	  if(_id==0)
			return;
		///////把資料delete從SQLite/////////
		  gaaSQLiteOpenHelper.delete(_id);
		//重新查詢資料庫內容，並重新顯示，_id歸零
		  myCursor.requery();
		  myListView.invalidateViews();
		  myEditText.setText("");
		  _id=0; 
	  
	  
  }
}