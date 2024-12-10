import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StarterPagePanel extends JPanel implements ActionListener {

    JPanel loginPanel;
    JLabel loginLabel;
    JLabel userNameLabel;
    JLabel passwordLabel;
    JTextField userNameInput;
    JTextField passwordInput;
    JButton submitButton;
    PokemonUser user1;

    MyFrame pokemonFrame;

    StarterPagePanel(MyFrame pokemonFrame){
        this.pokemonFrame = pokemonFrame;

        setBackground(Color.gray);
        setLayout(new GridBagLayout());

        // setup loginPanel
        loginPanel = new JPanel();
        loginPanel.setBackground(new Color(0x2976A3));
        loginPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        loginPanel.setPreferredSize(new Dimension(500,700));
        loginPanel.setLayout(new GridBagLayout());
        //add login components
        loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Roboto",Font.PLAIN,30));
        userNameLabel = new JLabel("Username:");
        userNameLabel.setFont(new Font("Roboto",Font.PLAIN,20));
        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Roboto",Font.PLAIN,20));
        userNameInput = new JTextField();
        userNameInput.setPreferredSize(new Dimension(150,30));
        passwordInput = new JTextField();
        passwordInput.setPreferredSize(new Dimension(150,30));
        submitButton = new JButton("Enter");
        submitButton.addActionListener(this);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5,5,5,5);
        loginPanel.add(loginLabel,constraints);
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(5,5,5,5);
        loginPanel.add(userNameLabel,constraints);
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(5,5,5,5);
        loginPanel.add(userNameInput,constraints);
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(5,5,5,5);
        loginPanel.add(passwordLabel,constraints);
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.insets = new Insets(5,5,5,5);
        loginPanel.add(passwordInput,constraints);
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.insets = new Insets(5,5,5,5);
        loginPanel.add(submitButton,constraints);

        add(loginPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userName;
        String passWord;
            if(e.getSource() == submitButton){
                userName = userNameInput.getText();
                passWord = passwordInput.getText();
                user1 = new PokemonUser(userName,passWord);
                System.out.println("UserName: " + userName);
                System.out.println("Password: " + passWord);
                pokemonFrame.startApp(user1);
                pokemonFrame.goToHomePage();
            }
    }

    public PokemonUser getUser1(){
        return user1;
    }
}
