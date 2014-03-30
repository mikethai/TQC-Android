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
    //�إ�menu��檺����
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	
    	//////////////add.one////////�]�wmenu�ﶵ///////////////////////////////////
    	menu.add(0, Menu.FIRST, 0, R.string.menu_add);
    	menu.add(0, Menu.FIRST+1, 1, R.string.menu_delete);
    	menu.add(0, Menu.FIRST+2, 2, R.string.menu_about);
    	menu.add(0, Menu.FIRST+3, 3, R.string.menu_exit);
        /////////////////////////////////////////////////////////
    	
    	//�s�Wmenu���A�A�Q��onOptionsItemSelected�^������ܶ��ءA�B�z�۹������ƥ�
    	
    	return true ;	
    }
    //menu�Q��ܰ���᪺�ƥ�B�z
    public boolean onOptionsItemSelected(MenuItem item){
    	//�I��menu�A�X�{�|�ӿ�ܡA�Hswitch�Ϥ��I��󶵡A�]�wtitle��ô���ܨ�\��
    	switch(item.getItemId()){
		//////////////add.two////////�إ��I��ƥ�///////////////////////////////////
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
    
    //�I��u����v�\��
    public void openAboutDialog()
    {    	
    		//////////////add.three////////�إ߹�ܮ�///////////////////////////////////
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
    //�I��u���}�v�\��
    public void openExitDialog()
    {
       	//�}�ҵ����߰ݡi�O�_�T�{���}�t�ΡH�j�A��T�������I��u�T�{�v��A�����{��
    	//��T�������I��u�����v�A�h�������߰ݵ����A�h�^��MENU�\����e��
    	
          //////////////add.four////////�إ߹�ܮ�///////////////////////////////////
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