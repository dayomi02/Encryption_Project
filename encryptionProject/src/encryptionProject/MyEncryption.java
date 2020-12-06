package encryptionProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class FrameTest extends JFrame{
//    private JPanelChange win;

	//public FrameTest(JPanelChange win) {
	public FrameTest() {
        setTitle("��ȣȭ ���α׷�");
        //this.win=win;
        //setSize(700, 500);
        setBounds(400, 200, 560, 300);
        
        JPanel panel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel subPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        Font font;
        
        font=new Font("�������",Font.BOLD,20);
        
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("��ȣȭ / ��ȣȭ ���α׷�");
        JLabel plain = new JLabel("�� / ��ȣ��   ");
        JLabel encryption  = new JLabel("     ��ȣŰ        ");
        JTextField plainText = new JTextField(20);
        JTextField encryptionText = new JTextField(20);

        JButton button1 = new JButton("��ȣȭ");
        JButton button2 = new JButton("��ȣȭ");
        button1.setPreferredSize(new Dimension(120, 70));
        button2.setPreferredSize(new Dimension(120, 70));

        
        titleLabel.setFont(font);
        plain.setFont(font);
        encryption.setFont(font);
        plainText.setFont(font);
        encryptionText.setFont(font);
        button1.setFont(font);
        button2.setFont(font);

        topPanel.add(titleLabel);
        subPanel.add(plain);
        subPanel.add(plainText);
        subPanel.add(encryption);
        subPanel.add(encryptionText);
        
        bottomPanel.add(button1);
        bottomPanel.add(button2);
        
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(subPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        this.add(panel);
        
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
                
        button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getSource() == button1){
					System.out.println("��ư1 Ŭ��");
			        String text = plainText.getText();
					//System.out.println(text);
					String text2 = encryptionText.getText();
					//System.out.println(text2);
					
			        new encryptionDialog(text, text2);
        		}
			}
        });
        button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getSource() == button2){
					System.out.println("��ư2 Ŭ��");
					String text = plainText.getText();
					//System.out.println(text);
					String text2 = encryptionText.getText();
					//System.out.println(text2);
					
			        new decryptDialog(text, text2);
        		}
			}
        });
        
        
        
    }
}
public class MyEncryption {
    public static void main(String[] args) {
        new FrameTest();
    }
}
