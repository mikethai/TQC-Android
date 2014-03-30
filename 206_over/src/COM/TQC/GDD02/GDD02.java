package COM.TQC.GDD02;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class GDD02 extends Activity {
	
	
	/**////////1//////////////////////////////////////**/
	/*宣告參數*/
	private static final String  DBNAME="notes5";
	private static final String  TABLENAME="notes";
	private static final String  field01="_id";
	private static final String  field02="note";
	private static final String  field03="created";
	private SQLiteDatabase database;
	private android.database.Cursor cursor;
	
	/*/array[0] 儲存field02*/
	/*/array[1] 儲存有打勾的內容*/
	private Object[][] array;
	private ArrayAdapter<Object> adapter;
	/*/*/
	private Button ok,exit;
	private ListView lv;
	/*///////////////////////////////////////////////*/
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        /*////////2//////////////////////////////*/
        /*/////連結元件*/
        ok = (Button) findViewById(R.id.button2);
        exit = (Button) findViewById(R.id.button3);
        lv = (ListView) findViewById(R.id.listView1);
        
        /*////連結資料庫*/
        String sql = "Create table if not exists "+TABLENAME+" ("
        +field01+" Integer Primary Key,"+field02+" Text Not Null,"
        +field03+" Integer);";
        
        database=openOrCreateDatabase(DBNAME, MODE_WORLD_WRITEABLE, null);
        database.execSQL(sql);
        cursor=database.query(TABLENAME, null, null, null, null, null, null);
        
        ///insert資料進去
        insert(1,"BOOK",10);
        insert(2,"FOOD",10);
        insert(3,"TOOL",10);
        
        
        /*////設定array及set adapter 給Listview*/
        /*/定義array大小*/
        array = new Object[2][cursor.getCount()];
        for (int i = 0; i<array[0].length;i++){
        	cursor.moveToPosition(i);
        	/*/將資料庫的第二個欄位內容存到array[0]中*/
        	array[0][i] = cursor.getString(1);
        	/*/default先不要打勾*/
        	array[1][i]=false;
        }
        adapter = new ArrayAdapter<Object>
        (this, android.R.layout.simple_list_item_multiple_choice,array[0]);
        lv.setAdapter(adapter);
        
        /*////建立ListView 的onclickListener事件*/
        /*/可多選*/
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				array[1][arg2]=!(Boolean)array[1][arg2];
			}
		});
        
        /*/////建立ok與exit按鈕*/
        ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			GDD02.this.setTitle("{");
			for(int i=0;i<cursor.getCount();i++)
				if((Boolean)array[1][i]){
					GDD02.this.setTitle(getTitle().toString()+array[0][i]+" ");
				}
			GDD02.this.setTitle(getTitle().toString()+"}");
			}
		});
        
        exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        /*///////////////////////////////////////*/
        
    }
    
    private void insert(int f1,String f2,int f3){
    	ContentValues cv= new ContentValues();
    	cv.put(field01, f1);
    	cv.put(field02, f2);
    	cv.put(field03, f3);
    	database.insert(TABLENAME, null, cv);
    	cursor.requery();
    }
}