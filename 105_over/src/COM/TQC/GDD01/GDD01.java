package COM.TQC.GDD01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GDD01 extends Activity {
	
	// ...
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    @Override
    //建立menu選單的項目
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	
    	//////////////add.one////////設定menu選項///////////////////////////////////
    	menu.add(0, Menu.FIRST, 0, R.string.menu_add);
    	menu.add(0, Menu.FIRST+1, 1, R.string.menu_delete);
    	menu.add(0, Menu.FIRST+2, 2, R.string.menu_about);
    	menu.add(0, Menu.FIRST+3, 3, R.string.menu_exit);
        /////////////////////////////////////////////////////////
    	
    	//新增menu選單，再利用onOptionsItemSelected擷取選單選擇項目，處理相對應的事件
    	
    	return true ;	
    }
    //menu被選擇執行後的事件處理
    public boolean onOptionsItemSelected(MenuItem item){
    	//點選menu，出現四個選擇，以switch區分點選何項，設定title並繫結至其功能
    	switch(item.getItemId()){
		//////////////add.two////////建立點選事件///////////////////////////////////
    	case Menu.FIRST:	
		    	setTitle(R.string.menu_add);
		    	break;
    	case Menu.FIRST+1:	
	    		setTitle(R.string.menu_delete);
	    		break;
    	case Menu.FIRST+2:	
	    		setTitle(R.string.menu_about);
    			openAboutDialog();
	    		break;
    	case Menu.FIRST+3:	
	    		openExitDialog();
	    		break;	
		    	
		///////////////////////////////////////////////////////////////    		
    	}
    	return super.onOptionsItemSelected(item) ;
    }
    
    //點選「關於」功能
    public void openAboutDialog()
    {    	
    		//////////////add.three////////建立對話框///////////////////////////////////
    	    new AlertDialog.Builder(this)
    	    .setTitle(R.string.menu_about)
    	    .setMessage(R.string.menu_about_msg)
    	    .setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}})
				.show();
    	    //////////////////////////////////////////////////////////////////////
    }
    //點選「離開」功能
    public void openExitDialog()
    {
       	//開啟視窗詢問【是否確認離開系統？】，於訊息視窗點選「確認」後，關閉程式
    	//於訊息視窗點選「取消」，則關閉此詢問視窗，則回到MENU功能選單畫面
    	
          //////////////add.four////////建立對話框///////////////////////////////////
          new AlertDialog.Builder(this)
          .setTitle(R.string.menu_exit)
          .setMessage(R.string.menu_exit_msg)
          .setNegativeButton(R.string.str_cancel, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		})
		.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		})
		.show();
    	
      //////////////////////////////////////////////////////////////////////////////////    
    	
    
    }
}