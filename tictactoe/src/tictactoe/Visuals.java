package tictactoe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Visuals extends JFrame {

	private static JPanel contentPane;

	public static JButton button1;
	public static JButton button2;
	public static JButton button3;
	public static JButton button4;
	public static JButton button5;
	public static JButton button6;
	public static JButton button7;
	public static JButton button8;
	public static JButton button9;
	
	private static Visuals frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Visuals();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Visuals() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		button1 = new JButton(" ");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.pressButton(1);
			}
		});
		contentPane.add(button1);
		
		button2 = new JButton(" ");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.pressButton(2);
			}
		});
		contentPane.add(button2);
		
		button3 = new JButton(" ");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.pressButton(3);
			}
		});
		contentPane.add(button3);
		
		button4 = new JButton(" ");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.pressButton(4);
			}
		});
		contentPane.add(button4);
		
		button5 = new JButton(" ");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.pressButton(5);
			}
		});
		contentPane.add(button5);
		
		button6 = new JButton(" ");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.pressButton(6);
			}
		});
		contentPane.add(button6);
		
		button7 = new JButton(" ");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.pressButton(7);
			}
		});
		contentPane.add(button7);
		
		button8 = new JButton(" ");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.pressButton(8);
			}
		});
		contentPane.add(button8);
		
		button9 = new JButton(" ");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.pressButton(9);
			}
		});
		contentPane.add(button9);

	}
	
	public static void showResults(String results) {
		int response = JOptionPane.showConfirmDialog(null, results,
                "", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (response == JOptionPane.CLOSED_OPTION || response == JOptionPane.OK_OPTION)
		{
			Main.resetGame();
		}
	}
}
