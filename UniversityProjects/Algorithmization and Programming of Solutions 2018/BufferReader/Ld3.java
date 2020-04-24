
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.border.BevelBorder;


public class Ld3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ld3 frame = new Ld3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public  Ld3() {
		
		setTitle("Ld3171rdb226");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 416, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(10, 77, 203, 254);
		contentPane.add(list);
		
		DefaultListModel model_1 = new DefaultListModel();
		JList list_1 = new JList(model_1);
		
		list_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list_1.setBounds(223, 77, 203, 254);
		contentPane.add(list_1);
		
		// BUTTON ADD
				JButton btnNewButton = new JButton("Add");
				btnNewButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						try {
							model.addElement(textField.getText());
						} catch (Exception e1) {
							textField.setText("Error");
						}
						textField.setText("");
					}
				});
				
				btnNewButton.setBounds(124, 43, 89, 23);
				contentPane.add(btnNewButton);
				
				// BUTTON RUN
				JButton btnNewButton_1 = new JButton("Run");
				btnNewButton_1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						int count = model.getSize();
						
						for (int i = 0; i < count; i++) {
						
							String alpha = (model.getElementAt(i)).toString();
							alpha = Checked(alpha);
							model_1.addElement(alpha);
						}
					}
				});
				
				btnNewButton_1.setBounds(223, 43, 89, 23);
				contentPane.add(btnNewButton_1);

				// BUTTON DELETE
				JButton btnDelete = new JButton("Delete");
				btnDelete.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						int count = list.getSelectedIndices().length;

						for (int i = 0; i < count; i++) {
						     model.removeElementAt(list.getSelectedIndex());
						}
					}					
				});
				btnDelete.setBounds(124, 342, 89, 23);
				contentPane.add(btnDelete);
				
				// BUTTON CLEAR
				JButton btnClear = new JButton("Clear");
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == btnClear) {
					        DefaultListModel<?> listModel = (DefaultListModel<?>) list_1.getModel();
					        listModel.removeAllElements();
						}
					}
				});
				btnClear.setBounds(223, 342, 89, 23);
				contentPane.add(btnClear);			
		}
	
	 public static String Checked(String val) {
	      String f[] = val.split(" ");
	      String ans = "";
	      int i = 0;
	      	while(i < f.length) {
	      		ans = ans + Checker(f[i]);
	      		i++;
	     }
	     return ans;
	     }
	     
	 public static String Checker(String k){
	      String savee, an = "";
	      savee = k;
	      char[] save = k.toCharArray();
	      int j = 0;
	      while(j < save.length){
	    
	    	  if ((save[j] >= '0') && (save[j] <= '9')) {
		     an = an + save[j];
		     j++;
	    	  } else {
	    		  return savee;
	    	  }
	   }
	      
	   int gotoint = Integer.parseInt(an);
	   if (gotoint > 0 && gotoint < 27) {
	    gotoint = gotoint + 96;
	    an = "" + ((char)gotoint );
	    return an;
	   } else return an;
	   
	     }
}