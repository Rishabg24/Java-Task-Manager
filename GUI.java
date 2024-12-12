import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI extends JPanel implements ActionListener {

    private Tasks tasks = new Tasks();
    private JList b;
    private DefaultListModel<String> listModel = new DefaultListModel<String>();;

    public GUI() {
        JFrame myFrame = new JFrame();
        myFrame.setSize(700, 500);
        setLayout(new BorderLayout());
        myFrame.add(this);

        JButton Clear = new JButton("Clear All");
        Clear.addActionListener(this);
        JButton Remove = new JButton("Remove");
        Remove.addActionListener(this);
        JPanel north = new JPanel();
        JTextField textField = new JTextField("", 40);
        this.handleTaskTextField(textField);
        this.add(north, BorderLayout.NORTH);
        north.add(textField, BorderLayout.NORTH);
        north.add(Clear, BorderLayout.NORTH);
        north.add(Remove, BorderLayout.NORTH);
        b = new JList(listModel);
        this.add(b);
        myFrame.setVisible(true);

        JPanel newPanel = new JPanel();
        this.add(newPanel, BorderLayout.CENTER);

    } // RECORD A PART OF YOU CODING FOR MIT MAKER PORTFOLIO

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Clear All")) {
            clearList();
        } else if (e.getActionCommand().equals("Remove")) {
            removeItem();
        }
    }

    public void paintComponent(Graphics g) {
        super.repaint();
    }

    public void handleTaskTextField(JTextField tf) {
        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = tf.getText();
                tasks.addTasks(s);
                listModel.addElement(s);
                tf.setText("");

            }
        });
    }

    public void clearList() {
        if(listModel.getSize()!=0){
            listModel.clear();
            tasks.removeAll();
        }
        else{
            JOptionPane.showMessageDialog(this, "Your Task List is Empty. Get Busy!");
        }
        
        
        this.repaint();
    }

    public void removeItem() {
        int SelectedTask = b.getSelectedIndex();
        if(SelectedTask!=-1){
            String taskrmv = listModel.getElementAt(SelectedTask);
            listModel.remove(SelectedTask);
            tasks.RemoveTasks(taskrmv);
            this.repaint();
        }
        else {
            JOptionPane.showMessageDialog(this, "You Have To Select A Task To Delete It You Know. ");
        }
    }

    public static void main(String[] args) {
        new GUI();
    }
}