package encryptionProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class encryptionDialog extends JDialog{
	
	public static char alphabetBoard[][] = new char[5][5];
	public static boolean oddFlag = false; 
	public static String zCheck ="";
	
	public encryptionDialog(String text, String text2){
		setTitle("암호화 결과");
		setModal(true);   

		Font font;
        font=new Font("맑은고딕",Font.PLAIN,30);
		System.out.println(text+", "+text2);

		String decryption;
		String encryption;
		
		String key = text2;				
		String str =  text;				
		String blankCheck="";
		int blankCheckCount = 0;

		setBoard(key);							
		
		for( int i = 0 ; i < str.length() ; i++ ) 
		{
			if(str.charAt(i)==' ') 
			{
				str = str.substring(0,i)+str.substring(i+1,str.length());
				blankCheck+=10;
			}
			else
			{
				blankCheck+=0;
			}
			if(str.charAt(i)=='z') 
			{
				str = str.substring(0,i)+'q'+str.substring(i+1,str.length());
				zCheck+=1;
			}
			else 
			{
				zCheck+=0;
			}
		}
		
		encryption = strEncryption(key, str);
		
		//출력부분
		System.out.println("암호화된 문자열 : " + encryption.trim());
		
		JLabel label = new JLabel(encryption.replace(" ",""));
		label.setFont(font);

//		this.setLayout(new BorderLayout());
//		this.add(label, BorderLayout.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		this.add(label);
		//setBackground(Color.LIGHT_GRAY);
		setBounds(400, 300, 700, 200);
		setVisible(true);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static String strEncryption(String key, String str){
		ArrayList<char[]> playFair = new ArrayList<char[]>();
		ArrayList<char[]> encPlayFair = new ArrayList<char[]>();
		int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0;
		String encStr ="";	
		
		
		
		for( int i = 0 ; i < str.length() ; i+=2 ) 
		{
			char[] tmpArr = new char[2];
			tmpArr[0] = str.charAt(i);
			try{
				if( str.charAt(i) == str.charAt(i+1)) 
				{
					tmpArr[1] = 'x';
					i--;
				}else{
					tmpArr[1] = str.charAt(i+1);
				}
			}catch(StringIndexOutOfBoundsException e)
			{
				tmpArr[1] = 'x'; 
				oddFlag = true;
			}
			playFair.add(tmpArr);	
		}
		
//		System.out.println("평문 자른 결과");
		for(int i = 0 ; i < playFair.size() ; i++ )
		{
			System.out.print(playFair.get(i)[0]+""+playFair.get(i)[1]+" ");
		}
//		System.out.println("====================");
		System.out.println();
		
		for(int i = 0 ; i < playFair.size() ; i++ )
		{
			char[] tmpArr = new char[2];
			for( int j = 0 ; j < alphabetBoard.length ; j++ ) 
			{
				for( int k = 0 ; k < alphabetBoard[j].length ; k++ )
				{
//					System.out.println("i : "+i+", j : "+j+", k : "+k);
					if(alphabetBoard[j][k] == playFair.get(i)[0])
					{
						x1 = j;
						y1 = k;
					}
					if(alphabetBoard[j][k] == playFair.get(i)[1])
					{
						x2 = j;
						y2 = k;
					}
				}
			}
			
			
			if(x1==x2) //행이 같은경우
			{
				tmpArr[0] = alphabetBoard[x1][(y1+1)%5];
				tmpArr[1] = alphabetBoard[x2][(y2+1)%5];
			}
			else if(y1==y2) //열이 같은 경우
			{
				tmpArr[0] = alphabetBoard[(x1+1)%5][y1];
				tmpArr[1] = alphabetBoard[(x2+1)%5][y2];
			} 
			else //행, 열 모두 다른경우
			{
				tmpArr[0] = alphabetBoard[x2][y1];
				tmpArr[1] = alphabetBoard[x1][y2];
			}
			
			encPlayFair.add(tmpArr);
			
		}
		
		for(int i = 0 ; i < encPlayFair.size() ; i++)
		{
			encStr += encPlayFair.get(i)[0]+""+encPlayFair.get(i)[1]+" ";
		}
		
		
		return encStr;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	private static void setBoard(String key) {
		String keyForSet = "";					
		boolean duplicationFlag = false;		
		int keyLengthCount = 0;					
		
		key += "abcdefghijklmnopqrstuvwxyz"; 	
		
		
		for( int i = 0 ; i < key.length() ; i++ ) 
		{
			for( int j = 0 ; j < keyForSet.length() ; j++ )
			{
				if(key.charAt(i)==keyForSet.charAt(j))
				{
					duplicationFlag = true;
					break;
				}
			}
			if(!(duplicationFlag)) keyForSet += key.charAt(i);
			duplicationFlag = false;
		}
		
		for( int i = 0 ; i < alphabetBoard.length ; i++ )
		{
			for( int j = 0; j <alphabetBoard[i].length ; j++ )
			{
				alphabetBoard[i][j] = keyForSet.charAt(keyLengthCount++);
			}
		}		
		System.out.println("암호판 출력");
		for( int i = 0 ; i < alphabetBoard.length ; i++ )
		{
			for( int j = 0; j <alphabetBoard[i].length ; j++ )
			{
				System.out.print(alphabetBoard[i][j]+"-");
			}
			System.out.println();
		}		
		System.out.println("=====================");
			
		
	}//setBoard()
	
}
