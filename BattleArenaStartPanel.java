import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class BattleArenaStartPanel extends JPanel implements ActionListener {

    HashMap<PokemonCard, JButton> user1PokemonButtonMap;

    ArrayList<JButton> user1PokemonButtons;
    HashMap<PokemonCard, JButton> user2PokemonButtonMap;

    ArrayList<JButton> user2PokemonButtons;
    PokemonUser user1;
    PokemonUser user2;
    JPanel user1CollectionPanel;
    JPanel user2CollectionPanel;
    JPanel user2InfoPanel;
    JLabel user2Label;
    JLabel user1Pokemon1;
    JLabel user1Pokemon2;
    JLabel user1Pokemon3;
    JLabel user2Pokemon1;
    JLabel user2Pokemon2;
    JLabel user2Pokemon3;
    JButton homeButton;
    JLabel loginLabel;
    JLabel userNameLabel;
    JLabel passwordLabel;
    JTextField userNameInput;
    JTextField passwordInput;
    JButton submitButton;
    JButton user1ReadyButton;
    JButton user2ReadyButton;


    PokemonQueue user1PokemonQueue;
    PokemonQueue user2PokemonQueue;
    JLabel pickTeamLabel;

    JLabel pickTeamLabel2;

    CardLayout cardLayout;

    BattleArenaPanel mainPanel;


    BattleArenaStartPanel(BattleArenaPanel mainPanel, PokemonUser user1,PokemonUser user2) {

        this.mainPanel = mainPanel;
        this.user1 = user1;
        this.user2 = user2;

        setLayout(new BorderLayout());
        setBackground(Color.orange);

        user1PokemonQueue = user1.queue;
        user2PokemonQueue = user2.queue;

        addTopPanel();
        addBottomPanel();

    }
    public ImageIcon scaleImg(ImageIcon img, int width, int height) {
        ImageIcon icon = img;
        Image scaledImg = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImg);
        return icon;
    }

    public void addTopPanel() {
        JPanel topPanel = new JPanel(new BorderLayout());

        JPanel user1Panel = new JPanel(null);
        user1Panel.setPreferredSize(new Dimension(400, 200));
        user1Panel.setBackground(new Color(0x2976A3));
        user1Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        JLabel user1Label = new JLabel(user1.getUserName());
        user1Label.setBounds(100, 0, 300, 200);
        user1Label.setFont(new Font("Roboto", Font.PLAIN, 40));
        user1Panel.add(user1Label);
        homeButton = new JButton();
        homeButton.setText("Home");
        homeButton.setBounds(0, 0, 75, 25);
        homeButton.setIcon(scaleImg(new ImageIcon("Images/HomeIcon.png"), 15, 15));
        user1Panel.add(homeButton);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0xE5D3B3));
        JLabel versusLabel = new JLabel(scaleImg(new ImageIcon("Images/VersusIcon.png"), 200, 200));
        titlePanel.add(versusLabel);

        JPanel user2LoginPanel;
        user2LoginPanel = new JPanel();
        user2LoginPanel.setBackground(new Color(0xD14747));
        user2LoginPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        user2LoginPanel.setPreferredSize(new Dimension(400, 200));
        user2LoginPanel.setLayout(new GridBagLayout());
        //add login components
        loginLabel = new JLabel("Login");

        loginLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
        userNameLabel = new JLabel("Username:");
        userNameLabel.setFont(new Font("Roboto",Font.PLAIN,15));

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Roboto",Font.PLAIN,15));

        userNameInput = new JTextField();

        userNameInput.setPreferredSize(new Dimension(150, 30));
        passwordInput = new JTextField();

        passwordInput.setPreferredSize(new Dimension(150, 30));
        submitButton = new JButton("Enter");
        submitButton.addActionListener(this);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        user2LoginPanel.add(loginLabel, constraints);
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        user2LoginPanel.add(userNameLabel, constraints);
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        user2LoginPanel.add(userNameInput, constraints);
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(5, 5, 5, 5);
        user2LoginPanel.add(passwordLabel, constraints);
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.insets = new Insets(5, 5, 5, 5);
        user2LoginPanel.add(passwordInput, constraints);
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.insets = new Insets(5, 5, 5, 5);
        user2LoginPanel.add(submitButton, constraints);


        JPanel user2Panel = new JPanel(null);
        user2Panel.setPreferredSize(new Dimension(400, 200));
        user2Panel.setBackground(new Color(0xD14747));
        user2Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        user2Label = new JLabel();
        user2Label.setBounds(100, 0, 300, 200);
        user2Label.setFont(new Font("Roboto", Font.PLAIN, 40));
        user2Panel.add(user2Label);

        cardLayout = new CardLayout();
        user2InfoPanel = new JPanel(cardLayout);
        user2InfoPanel.add(user2LoginPanel, "login");
        user2InfoPanel.add(user2Panel, "user2Panel");


        topPanel.add(user1Panel, BorderLayout.WEST);
        topPanel.add(titlePanel);
        topPanel.add(user2InfoPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
    }

    public void addBottomPanel() {

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        //user1's panel
        JPanel user1TeamPanel = new JPanel(new BorderLayout());
        user1TeamPanel.setBackground(Color.gray);
        user1TeamPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        JPanel user1TeamPickPanel = new JPanel(new BorderLayout());
        user1TeamPickPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(0xE5D3B3));
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(0xE5D3B3));
        buttonPanel.setPreferredSize(new Dimension(100,50));
        user1ReadyButton = new JButton("Ready");
        user1ReadyButton.addActionListener(this);
        user1ReadyButton.setVisible(false);
        buttonPanel.add(user1ReadyButton);
        panel.add(buttonPanel,BorderLayout.WEST);

        pickTeamLabel = new JLabel("Pick Your Team");
        pickTeamLabel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 10));
        pickTeamLabel.setFont(new Font("Roboto", Font.PLAIN, 25));
        panel.add(pickTeamLabel);


        JPanel user1TeamLineUpPanel = new JPanel(new GridLayout(1, 3));
        user1TeamLineUpPanel.setBackground(new Color(0xE5D3B3));

        user1TeamLineUpPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(5,0,0,0, Color.BLACK),
                BorderFactory.createEmptyBorder(10,10,10,10)));

        user1Pokemon1 = new JLabel(scaleImg(new ImageIcon("Images/PokemonBall.png"), 100, 100));
        user1Pokemon2 = new JLabel(scaleImg(new ImageIcon("Images/PokemonBall.png"), 100, 100));
        user1Pokemon3 = new JLabel(scaleImg(new ImageIcon("Images/PokemonBall.png"), 100, 100));
        user1TeamLineUpPanel.add(user1Pokemon1);
        user1TeamLineUpPanel.add(user1Pokemon2);
        user1TeamLineUpPanel.add(user1Pokemon3);

        user1TeamPickPanel.add(panel, BorderLayout.NORTH);
        user1TeamPickPanel.add(user1TeamLineUpPanel);

        user1CollectionPanel = new JPanel();
        user1CollectionPanel.setBackground(new Color(0x74ABCA));
        user1CollectionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        user1TeamPanel.add(user1TeamPickPanel, BorderLayout.NORTH);
        user1TeamPanel.add(user1CollectionPanel);

        bottomPanel.add(user1TeamPanel);

        //user2's panel
        JPanel user2TeamPanel = new JPanel(new BorderLayout());
        user2TeamPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        JPanel user2TeamPickPanel = new JPanel(new BorderLayout());
        user2TeamPickPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(0xE5D3B3));
        buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(new Color(0xE5D3B3));
        buttonPanel.setPreferredSize(new Dimension(100,50));

        user2ReadyButton = new JButton("Ready");
        user2ReadyButton.addActionListener(this);
        user2ReadyButton.setVisible(false);
        buttonPanel.add(user2ReadyButton);

        panel.add(buttonPanel,BorderLayout.WEST);

        pickTeamLabel2 = new JLabel("Pick Your Team");
        pickTeamLabel2.setFont(new Font("Roboto", Font.PLAIN, 25));
        pickTeamLabel2.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 10));
        panel.add(pickTeamLabel2,BorderLayout.CENTER);

        JPanel user2TeamLineUpPanel = new JPanel(new GridLayout(1, 3));
        user2TeamLineUpPanel.setBackground(new Color(0xE5D3B3));

        user2TeamLineUpPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(5,0,0,0, Color.BLACK),
                BorderFactory.createEmptyBorder(10,10,10,10)));

        user2Pokemon1 = new JLabel(scaleImg(new ImageIcon("Images/PokemonBall.png"), 100, 100));
        user2Pokemon2 = new JLabel(scaleImg(new ImageIcon("Images/PokemonBall.png"), 100, 100));
        user2Pokemon3 = new JLabel(scaleImg(new ImageIcon("Images/PokemonBall.png"), 100, 100));
        user2TeamLineUpPanel.add(user2Pokemon1);
        user2TeamLineUpPanel.add(user2Pokemon2);
        user2TeamLineUpPanel.add(user2Pokemon3);

        user2TeamPickPanel.add(panel, BorderLayout.NORTH);
        user2TeamPickPanel.add(user2TeamLineUpPanel);

        user2CollectionPanel = new JPanel();
        user2CollectionPanel.setBackground(new Color(0xE07D7D));
        user2CollectionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        user2TeamPanel.add(user2TeamPickPanel, BorderLayout.NORTH);
        user2TeamPanel.add(user2CollectionPanel);

        bottomPanel.add(user2TeamPanel);

        add(bottomPanel);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String userName;
        String passWord;

        if(e.getSource() == user1ReadyButton) {
            if(!user2ReadyButton.isEnabled()){
                System.out.println("Start Game");
                mainPanel.startGamePanel();
            }
            else {
                System.out.println("user1's ready");
                user1ReadyButton.setText("Waiting");
                user1ReadyButton.setEnabled(false);
            }
        }
        else if(e.getSource() == user2ReadyButton) {
            if(!user1ReadyButton.isEnabled()){
                System.out.println("Start Game");
                mainPanel.startGamePanel();
            }
            else {
                System.out.println("user2's ready");
                user2ReadyButton.setText("Waiting");
                user2ReadyButton.setEnabled(false);
            }
        }
        else if (e.getSource() == submitButton) {
            userName = userNameInput.getText();
            passWord = passwordInput.getText();
            user2.userName = userName;
            user2.passWord = passWord;
            PokemonCenter center = new PokemonCenter();
            user2.addCard(center.getStoreCard("Pikachu"));
            user2.addCard(center.getStoreCard("Bulbasaur"));
            user2.addCard(center.getStoreCard("Squirtle"));
            System.out.println("User2 Name: " + userName);
            System.out.println("User2 Password: " + passWord);

            user2Label.setText(user2.getUserName());
            cardLayout.show(user2InfoPanel, "user2Panel");

            user2PokemonButtons = new ArrayList<>();
            user2PokemonButtonMap = new HashMap<>();
            for (int i = 0; i < user2.getCollection().size(); ++i) {
                JButton pokemonButton = user2.getCard(i).getButton(Color.BLACK);
                pokemonButton.addActionListener(this);
                user2PokemonButtonMap.put(user2.getCard(i), pokemonButton);
                user2PokemonButtons.add(pokemonButton);
                user2CollectionPanel.add(pokemonButton);
            }

            user1PokemonButtons = new ArrayList<>();
            user1PokemonButtonMap = new HashMap<>();
            for (int i = 0; i < user1.getCollection().size(); ++i) {
                JButton pokemonButton = user1.getCard(i).getButton(Color.BLACK);
                pokemonButton.addActionListener(this);
                user1PokemonButtonMap.put(user1.getCard(i), pokemonButton);
                user1PokemonButtons.add(pokemonButton);
                user1CollectionPanel.add(pokemonButton);
            }

        }
        else {
            user1PokemonQueue.print();
            for (int i = 0; i < user1PokemonButtons.size(); ++i) {
                if (e.getSource() == user1PokemonButtons.get(i)) {
                    System.out.println(user1.getCard(i).getName() + " goes to slot " + (user1PokemonQueue.getElements() + 1));
                    System.out.println("add " + user1.getCard(i).getName() + "to queue");

                    if (user1PokemonQueue.getElements() == 0) {

                        user1Pokemon1.setIcon(scaleImg(user1.getCard(i).pokemonImg, 100, 100));
                    } else if (user1PokemonQueue.getElements() == 1) {

                        user1Pokemon2.setIcon(user1Pokemon1.getIcon());
                        user1Pokemon1.setIcon(scaleImg(user1.getCard(i).pokemonImg, 100, 100));

                    } else if (user1PokemonQueue.getElements() >= 2) {
                        user1ReadyButton.setVisible(true);
                        user1Pokemon3.setIcon(user1Pokemon2.getIcon());
                        user1Pokemon2.setIcon(user1Pokemon1.getIcon());
                        user1Pokemon1.setIcon(scaleImg(user1.getCard(i).pokemonImg, 100, 100));
                    }

                    user1PokemonButtons.get(i).setVisible(false);

                    PokemonCard card;
                    card = user1PokemonQueue.enqueue(user1.getCard(i));
                    user1PokemonQueue.print();
                    System.out.println(card);
                    if (card != null) {
                        JButton pokButton = user1PokemonButtonMap.get(card);
                        pokButton.setVisible(true);
                    }


                }
            }

            user2PokemonQueue.print();
            for (int i = 0; i < user2PokemonButtons.size(); ++i) {
                if (e.getSource() == user2PokemonButtons.get(i)) {
                    System.out.println(user2.getCard(i).getName() + " goes to slot " + (user2PokemonQueue.getElements() + 1));
                    System.out.println("add " + user2.getCard(i).getName() + "to queue");

                    if (user2PokemonQueue.getElements() == 0) {

                        user2Pokemon1.setIcon(scaleImg(user2.getCard(i).pokemonImg, 100, 100));
                    } else if (user2PokemonQueue.getElements() == 1) {

                        user2Pokemon2.setIcon(user2Pokemon1.getIcon());
                        user2Pokemon1.setIcon(scaleImg(user2.getCard(i).pokemonImg, 100, 100));

                    } else if (user2PokemonQueue.getElements() >= 2) {
                        user2ReadyButton.setVisible(true);
                        user2Pokemon3.setIcon(user2Pokemon2.getIcon());
                        user2Pokemon2.setIcon(user2Pokemon1.getIcon());
                        user2Pokemon1.setIcon(scaleImg(user2.getCard(i).pokemonImg, 100, 100));
                    }

                    user2PokemonButtons.get(i).setVisible(false);

                    PokemonCard card;
                    card = user2PokemonQueue.enqueue(user2.getCard(i));
                    user2PokemonQueue.print();
                    System.out.println(card);
                    if (card != null) {
                        JButton pokButton = user2PokemonButtonMap.get(card);
                        pokButton.setVisible(true);
                    }

                }
            }
        }
    }
}




