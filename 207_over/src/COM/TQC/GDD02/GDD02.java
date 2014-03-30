package COM.TQC.GDD02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GDD02 extends Activity {
	private String btnAdd = "Add";
	private String btnLogin = "Login";
	private String btnUpdate = "Update";
	private String FileName = "MY_PASSWORD";
	
	
	private FileInputStream fileInputStream = null; 
	private Button Button01;
	private EditText EditText01;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        EditText01 = (EditText) findViewById(R.id.EditText01);
        Button01 = (Button) findViewById(R.id.Button01);
        
       try{
    	   fileInputStream=openFileInput(FileName);
       }
       catch(FileNotFoundException e){
    	   e.printStackTrace();
       }
       
		if(fileInputStream==null){
			Button01.setText(btnAdd);
		}
		else{
			Button01.setText(btnLogin);
		}
		Button01.setOnClickListener(new View.OnClickListener(){

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(Button01.getText().equals(btnAdd)){
					String text = ""+EditText01.getText();
					if(!text.equals("")){
						writeFile(text);
						showToast("新增成功！請重新登入！"); 
						Button01.setText(btnLogin);
						EditText01.setText("");
					}
					else{
						showToast("請輸入密碼！"); 
					}
				}
				else if(Button01.getText().equals(btnLogin)){
					String text = ""+EditText01.getText();
					if(text.equals(readFile())){
						showToast("登入成功！");
						Button01.setText(btnUpdate);
					}
					else{
						showToast("登入失敗！");
					}
				}
				else if(Button01.getText().equals(btnUpdate)){
					String text = ""+EditText01.getText();
					if(!text.equals("")){
						writeFile(text);
						showToast("修改成功！請重新登入！");
						Button01.setText(btnLogin);
						EditText01.setText("");
					}
					else{
						showToast("請輸入密碼！"); 
					}
				}
			}});
    }
    
    //定義writeFile(String data)方法，FileOutputStream與OutputStreamWriter物件宣告為空值，並創建檔案和寫入資料
    private void writeFile(String data){
		 
		FileOutputStream out = null;
		OutputStreamWriter osw = null;
		
		try{
			//建立輸出串流物件
			out = openFileOutput(FileName,MODE_PRIVATE);
			//建立一個OutputStreamWriter類別，以out物件為目標，將Character串流轉成Byte串流，寫到out物件裡
			
			osw = new OutputStreamWriter(out);
			osw.write(data);//將data寫入OutputStreamWriter
			osw.flush(); //刷新緩衝區的數據
		}catch(Exception e){
			e.printStackTrace();
		}		
    }   
    //定義readFile()方法，讀取檔案資料
    private String readFile(){
    	
		String data = ""; 
		InputStreamReader isr =null; //宣告一個InputStreamReader物件
		char[]buf = new char[255];
		try{
			//開啟檔案，建立FileInputSteam類別的物FileInputStream
			fileInputStream = openFileInput(FileName);
			//在FileInputSteam類別的物件fileInputStream上，建立一個InputStreamReader的物件，將Byte串流轉成Character串流
			isr = new InputStreamReader(fileInputStream);
			isr.read(buf);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		data = new String(buf);
		data = data.trim();//去空白與定位字元
		
		return data;
    }   
    //(2)用Toast來顯示訊息
    private void showToast(String message){
    	Toast.makeText(this,message, Toast.LENGTH_SHORT ).show();
    	
    }
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
}