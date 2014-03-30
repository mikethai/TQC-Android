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
						showToast("�s�W���\�I�Э��s�n�J�I"); 
						Button01.setText(btnLogin);
						EditText01.setText("");
					}
					else{
						showToast("�п�J�K�X�I"); 
					}
				}
				else if(Button01.getText().equals(btnLogin)){
					String text = ""+EditText01.getText();
					if(text.equals(readFile())){
						showToast("�n�J���\�I");
						Button01.setText(btnUpdate);
					}
					else{
						showToast("�n�J���ѡI");
					}
				}
				else if(Button01.getText().equals(btnUpdate)){
					String text = ""+EditText01.getText();
					if(!text.equals("")){
						writeFile(text);
						showToast("�ק令�\�I�Э��s�n�J�I");
						Button01.setText(btnLogin);
						EditText01.setText("");
					}
					else{
						showToast("�п�J�K�X�I"); 
					}
				}
			}});
    }
    
    //�w�qwriteFile(String data)��k�AFileOutputStream�POutputStreamWriter����ŧi���ŭȡA�óЫ��ɮשM�g�J���
    private void writeFile(String data){
		 
		FileOutputStream out = null;
		OutputStreamWriter osw = null;
		
		try{
			//�إ߿�X��y����
			out = openFileOutput(FileName,MODE_PRIVATE);
			//�إߤ@��OutputStreamWriter���O�A�Hout���󬰥ؼСA�NCharacter��y�নByte��y�A�g��out�����
			
			osw = new OutputStreamWriter(out);
			osw.write(data);//�Ndata�g�JOutputStreamWriter
			osw.flush(); //��s�w�İϪ��ƾ�
		}catch(Exception e){
			e.printStackTrace();
		}		
    }   
    //�w�qreadFile()��k�AŪ���ɮ׸��
    private String readFile(){
    	
		String data = ""; 
		InputStreamReader isr =null; //�ŧi�@��InputStreamReader����
		char[]buf = new char[255];
		try{
			//�}���ɮסA�إ�FileInputSteam���O����FileInputStream
			fileInputStream = openFileInput(FileName);
			//�bFileInputSteam���O������fileInputStream�W�A�إߤ@��InputStreamReader������A�NByte��y�নCharacter��y
			isr = new InputStreamReader(fileInputStream);
			isr.read(buf);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		data = new String(buf);
		data = data.trim();//�h�ťջP�w��r��
		
		return data;
    }   
    //(2)��Toast����ܰT��
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