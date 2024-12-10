import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TradePanel extends JPanel implements ActionListener {
    JLabel title;
    JButton homeButton;
    TradePanel(){

        setLayout(new BorderLayout());
        setBackground(Color.green);

        title = new JLabel("Trade");
        add(title,BorderLayout.NORTH);

        homeButton = new JButton();
        homeButton.setText("Home");
        add(homeButton, BorderLayout.WEST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

