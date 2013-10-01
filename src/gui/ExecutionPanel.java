package gui;

import java.awt.BorderLayout;
import java.io.PrintStream;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ExecutionPanel extends JPanel {

	public ExecutionPanel() {
		add(new JLabel("Console"));

		JTextArea ta = new JTextArea();
		Console output = new Console(ta, 60);
		PrintStream ps = new PrintStream(output);
		System.setOut(ps);
		System.setErr(ps);

		add(new JScrollPane(ta));

		setVisible(true);

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException exception) {
				// TODO Auto-generated catch-block stub.
				exception.printStackTrace();
			}
		}
	}
}