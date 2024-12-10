import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class BattleArenaGamePanel extends JPanel implements ActionListener {

    JButton exitGameButton;
    JPanel arenaPanel;
    JLabel activePokemonLabel2;
    JLabel activePokemonLabel1;
    JTextArea commentaryLabel;
    ArrayList<PokemonCard> user1BenchPokemon;
    ArrayList<JButton> user1PokemonButtons;
    ArrayList<PokemonCard> user2BenchPokemon;
    ArrayList<JButton> user2PokemonButtons;

    PokemonUser user1;

    PokemonCard user1ActivePokemon;
    boolean user1isActive;
    boolean user1isPlaying;
    int[] user1PokemonHP;
    JLabel user1Pokemon1HPLabel;
    JLabel user1Pokemon2HPLabel;
    JLabel user1Pokemon3HPLabel;
    JButton user1SubmitButton;
    JButton user1PlayButton;
    JLabel user1Question;
    JTextField user1TextField;

    PokemonUser user2;
    PokemonCard user2ActivePokemon;
    boolean user2isPlaying;
    boolean user2isActive;

    int correctAnswer;
    JLabel user2Pokemon1HPLabel;
    JLabel user2Pokemon2HPLabel;
    JLabel user2Pokemon3HPLabel;

    int[] user2PokemonHP;
    JButton user2SubmitButton;
    JTextField user2TextField;
    JButton user2PlayButton;

    JLabel user2Question;

    JPanel bottomPanel;

    int gameTurn = 1;

    int user1BenchCnt = 3;
    int user2BenchCnt = 3;

    JButton commentaryOKButton;

    boolean gameOver = false;


    BattleArenaGamePanel(PokemonUser user1, PokemonUser user2) {

        user1isActive = false;
        user2isActive = false;

        user1isPlaying = false;
        user2isPlaying = false;

        this.user1 = user1;
        this.user2 = user2;

        exitGameButton = new JButton("Exit game");

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.GRAY);
        panel.add(exitGameButton,BorderLayout.WEST);

        setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        add(panel, BorderLayout.NORTH);

        arenaPanel = new JPanel(new BorderLayout());

        setUpCenterPanel();

        setUpTopPanel();

        setUpRightandLeftPanels();

        System.out.println(user1BenchPokemon.size());
        System.out.println(user2BenchPokemon.size());

        bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.setPreferredSize(new Dimension(0, 125));
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        setUpUser1TeamPanel();

        setUpUser2TeamPanel();

        arenaPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(arenaPanel);

    }

    public void setUpUser2TeamPanel() {
        JPanel user2TeamPanel = new JPanel();
        user2TeamPanel.setBorder(BorderFactory.createMatteBorder(1,15,1,1,Color.BLACK));
        user2TeamPanel.setBackground(new Color(0xD14747));

        user2PokemonHP = new int[]{user2BenchPokemon.get(0).getHP(), user2BenchPokemon.get(1).getHP(), user2BenchPokemon.get(2).getHP()};

        //user2pokemon1
        ImageIcon user2Pokemon1Img = user2BenchPokemon.get(0).getPokemonImg();
        JLabel user2Pokemon1Icon = new JLabel(scaleImg(user2Pokemon1Img, 50, 50));
        user2Pokemon1Icon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //pokemon1 infoPanel
        JPanel user2Pokemon1InfoPanel = new JPanel(new GridLayout(4, 1));
        user2Pokemon1InfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JLabel user2pokemon1NameLabel = new JLabel(" Name: " + user2BenchPokemon.get(0).getName() + " ");
        user2Pokemon1HPLabel = new JLabel(" HP: " + user2PokemonHP[0] + " / " + user2BenchPokemon.get(0).getHP() + " ");
        JLabel user2pokemon1TypeLabel = new JLabel(" Type: " + user2BenchPokemon.get(0).getType() + " ");
        JLabel user2pokemon1AttackPowerLabel = new JLabel(" Power: " + user2BenchPokemon.get(0).getAttackPower() + " ");

        user2pokemon1NameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user2Pokemon1HPLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user2pokemon1TypeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user2pokemon1AttackPowerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        user2Pokemon1InfoPanel.add(user2pokemon1NameLabel);
        user2Pokemon1InfoPanel.add(user2Pokemon1HPLabel);
        user2Pokemon1InfoPanel.add(user2pokemon1TypeLabel);
        user2Pokemon1InfoPanel.add(user2pokemon1AttackPowerLabel);

        //user2pokemon3Panel
        JPanel user2pokemon1Panel = new JPanel();
        user2pokemon1Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user2pokemon1Panel.add(user2Pokemon1Icon);
        user2pokemon1Panel.add(user2Pokemon1InfoPanel);

        user2TeamPanel.add(user2pokemon1Panel);

        //user2pokemon2
        ImageIcon user2Pokemon2Img = user2BenchPokemon.get(1).getPokemonImg();
        JLabel user2Pokemon2Icon = new JLabel(scaleImg(user2Pokemon2Img, 50, 50));
        user2Pokemon2Icon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //pokemon2 infoPanel
        JPanel user2Pokemon2InfoPanel = new JPanel(new GridLayout(4, 1));
        user2Pokemon2InfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JLabel user2pokemon2NameLabel = new JLabel(" Name: " + user2BenchPokemon.get(1).getName() + " ");
        user2Pokemon2HPLabel = new JLabel(" HP: " + user2PokemonHP[1] + " / " + user2BenchPokemon.get(1).getHP() + " ");
        JLabel user2pokemon2TypeLabel = new JLabel(" Type: " + user2BenchPokemon.get(1).getType() + " ");
        JLabel user2pokemon2AttackPowerLabel = new JLabel(" Power: " + user2BenchPokemon.get(1).getAttackPower() + " ");

        user2pokemon2NameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user2Pokemon2HPLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user2pokemon2TypeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user2pokemon2AttackPowerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        user2Pokemon2InfoPanel.add(user2pokemon2NameLabel);
        user2Pokemon2InfoPanel.add(user2Pokemon2HPLabel);
        user2Pokemon2InfoPanel.add(user2pokemon2TypeLabel);
        user2Pokemon2InfoPanel.add(user2pokemon2AttackPowerLabel);

        //user2pokemon3Panel
        JPanel user2pokemon2Panel = new JPanel();
        user2pokemon2Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user2pokemon2Panel.add(user2Pokemon2Icon);
        user2pokemon2Panel.add(user2Pokemon2InfoPanel);

        user2TeamPanel.add(user2pokemon2Panel);

        //user2pokemon3
        ImageIcon user2Pokemon3Img = user2BenchPokemon.get(2).getPokemonImg();
        JLabel user2Pokemon3Icon = new JLabel(scaleImg(user2Pokemon3Img, 50, 50));
        user2Pokemon3Icon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //pokemon3 infoPanel
        JPanel user2Pokemon3InfoPanel = new JPanel(new GridLayout(4, 1));
        user2Pokemon3InfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JLabel user2pokemon3NameLabel = new JLabel(" Name: " + user2BenchPokemon.get(2).getName() + " ");
        user2Pokemon3HPLabel = new JLabel(" HP: " + user2PokemonHP[2] + " / " + user2BenchPokemon.get(2).getHP() + " ");
        JLabel user2pokemon3TypeLabel = new JLabel(" Type: " + user2BenchPokemon.get(2).getType() + " ");
        JLabel user2pokemon3AttackPowerLabel = new JLabel(" Power: " + user2BenchPokemon.get(2).getAttackPower() + " ");

        user2pokemon3NameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user2Pokemon3HPLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user2pokemon3TypeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user2pokemon3AttackPowerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        user2Pokemon3InfoPanel.add(user2pokemon3NameLabel);
        user2Pokemon3InfoPanel.add(user2Pokemon3HPLabel);
        user2Pokemon3InfoPanel.add(user2pokemon3TypeLabel);
        user2Pokemon3InfoPanel.add(user2pokemon3AttackPowerLabel);

        //user2pokemon3Panel
        JPanel user2pokemon3Panel = new JPanel();
        user2pokemon3Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user2pokemon3Panel.add(user2Pokemon3Icon);
        user2pokemon3Panel.add(user2Pokemon3InfoPanel);

        user2TeamPanel.add(user2pokemon3Panel);

        bottomPanel.add(user2TeamPanel);
    }

    public void setUpUser1TeamPanel() {
        // user1 Team Panel
        JPanel user1TeamPanel = new JPanel();
        user1TeamPanel.setBorder(BorderFactory.createMatteBorder(1,1,1,14,Color.BLACK));
        user1TeamPanel.setBackground(new Color(0x2976A3));

        user1PokemonHP = new int[]{user1BenchPokemon.get(0).getHP(), user1BenchPokemon.get(1).getHP(), user1BenchPokemon.get(2).getHP()};

        //user1pokemon1
        ImageIcon user1Pokemon1Img = user1BenchPokemon.get(0).getPokemonImg();
        JLabel user1Pokemon1Icon = new JLabel(scaleImg(user1Pokemon1Img, 50, 50));
        user1Pokemon1Icon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //pokemon1 infoPanel
        JPanel user1Pokemon1InfoPanel = new JPanel(new GridLayout(4, 1));
        user1Pokemon1InfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JLabel user1pokemon1NameLabel = new JLabel(" Name: " + user1BenchPokemon.get(0).getName() + " ");
        user1Pokemon1HPLabel = new JLabel(" HP: " + user1PokemonHP[0] + " / " + user1BenchPokemon.get(0).getHP() + " ");
        JLabel user1pokemon1TypeLabel = new JLabel(" Type: " + user1BenchPokemon.get(0).getType() + " ");
        JLabel user1pokemon1AttackPowerLabel = new JLabel(" Power: " + user1BenchPokemon.get(0).getAttackPower() + " ");

        user1pokemon1NameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user1Pokemon1HPLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user1pokemon1TypeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user1pokemon1AttackPowerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        user1Pokemon1InfoPanel.add(user1pokemon1NameLabel);
        user1Pokemon1InfoPanel.add(user1Pokemon1HPLabel);
        user1Pokemon1InfoPanel.add(user1pokemon1TypeLabel);
        user1Pokemon1InfoPanel.add(user1pokemon1AttackPowerLabel);

        //user1pokemon1Panel
        JPanel user1pokemon1Panel = new JPanel();
        user1pokemon1Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user1pokemon1Panel.add(user1Pokemon1Icon);
        user1pokemon1Panel.add(user1Pokemon1InfoPanel);


        user1TeamPanel.add(user1pokemon1Panel);


        //user1pokemon2
        ImageIcon user1Pokemon2Img = user1BenchPokemon.get(1).getPokemonImg();
        JLabel user1Pokemon2Icon = new JLabel(scaleImg(user1Pokemon2Img, 50, 50));
        user1Pokemon2Icon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //pokemon2 infoPanel
        JPanel user1Pokemon2InfoPanel = new JPanel(new GridLayout(4, 1));
        user1Pokemon2InfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JLabel pokemon2NameLabel = new JLabel(" Name: " + user1BenchPokemon.get(1).getName() + " ");
        user1Pokemon2HPLabel = new JLabel(" HP: " + user1PokemonHP[1] + " / " + user1BenchPokemon.get(1).getHP() + " ");
        JLabel user1pokemon2TypeLabel = new JLabel(" Type: " + user1BenchPokemon.get(1).getType() + " ");
        JLabel user1pokemon2AttackPowerLabel = new JLabel(" Power: " + user1BenchPokemon.get(1).getAttackPower() + " ");

        pokemon2NameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user1Pokemon2HPLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user1pokemon2TypeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user1pokemon2AttackPowerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        user1Pokemon2InfoPanel.add(pokemon2NameLabel);
        user1Pokemon2InfoPanel.add(user1Pokemon2HPLabel);
        user1Pokemon2InfoPanel.add(user1pokemon2TypeLabel);
        user1Pokemon2InfoPanel.add(user1pokemon2AttackPowerLabel);

        //user1pokemon2Panel
        JPanel user1pokemon2Panel = new JPanel();
        user1pokemon2Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user1pokemon2Panel.add(user1Pokemon2Icon);
        user1pokemon2Panel.add(user1Pokemon2InfoPanel);

        user1TeamPanel.add(user1pokemon2Panel);

        //user1pokemon3
        ImageIcon user1Pokemon3Img = user1BenchPokemon.get(2).getPokemonImg();
        JLabel user1Pokemon3Icon = new JLabel(scaleImg(user1Pokemon3Img, 50, 50));
        user1Pokemon3Icon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //pokemon3 infoPanel
        JPanel user1Pokemon3InfoPanel = new JPanel(new GridLayout(4, 1));
        user1Pokemon3InfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JLabel pokemon3NameLabel = new JLabel(" Name: " + user1BenchPokemon.get(2).getName() + " ");
        user1Pokemon3HPLabel = new JLabel(" HP: " + user1PokemonHP[2] + " / " + user1BenchPokemon.get(2).getHP() + " ");
        JLabel user1pokemon3TypeLabel = new JLabel(" Type: " + user1BenchPokemon.get(2).getType() + " ");
        JLabel user1pokemon3AttackPowerLabel = new JLabel(" Power: " + user1BenchPokemon.get(2).getAttackPower() + " ");

        pokemon3NameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user1Pokemon3HPLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user1pokemon3TypeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user1pokemon3AttackPowerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        user1Pokemon3InfoPanel.add(pokemon3NameLabel);
        user1Pokemon3InfoPanel.add(user1Pokemon3HPLabel);
        user1Pokemon3InfoPanel.add(user1pokemon3TypeLabel);
        user1Pokemon3InfoPanel.add(user1pokemon3AttackPowerLabel);

        //user1pokemon3Panel
        JPanel user1pokemon3Panel = new JPanel();
        user1pokemon3Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        user1pokemon3Panel.add(user1Pokemon3Icon);
        user1pokemon3Panel.add(user1Pokemon3InfoPanel);

        user1TeamPanel.add(user1pokemon3Panel);

        bottomPanel.add(user1TeamPanel);
    }

    public void setUpCenterPanel() {
        JPanel centerPanel = new JPanel(null);
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        centerPanel.setBackground(Color.GRAY);

        activePokemonLabel1 = new JLabel();
        activePokemonLabel1.setBounds(50, 175, 125, 125);
        centerPanel.add(activePokemonLabel1);
        activePokemonLabel2 = new JLabel();
        activePokemonLabel2.setBounds(325, 175, 125, 125);
        centerPanel.add(activePokemonLabel2);
        JLabel stageIcon = new JLabel(scaleImg(new ImageIcon("Images/PokemonArenaIcon.png"), 485, 483));
        stageIcon.setBounds(8, 4, 485, 485);
        centerPanel.add(stageIcon);

        arenaPanel.add(centerPanel, BorderLayout.CENTER);
    }

    public void setUpTopPanel() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(0, 125));
        topPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        JLabel user1NameLabel = new JLabel(user1.getUserName());
        user1NameLabel.setPreferredSize(new Dimension(350, 125));
        user1NameLabel.setHorizontalAlignment(JLabel.CENTER);
        user1NameLabel.setBackground(new Color(0x2976A3));
        user1NameLabel.setOpaque(true);
        topPanel.add(user1NameLabel, BorderLayout.WEST);

        JLabel user2NameLabel = new JLabel(user2.getUserName());
        user2NameLabel.setPreferredSize(new Dimension(350, 125));
        user2NameLabel.setHorizontalAlignment(JLabel.CENTER);
        user2NameLabel.setBackground(new Color(0xD14747));
        user2NameLabel.setOpaque(true);
        topPanel.add(user2NameLabel, BorderLayout.EAST);

        JPanel commentaryPanel = new JPanel(new BorderLayout());
        commentaryPanel.setBackground(new Color(0xE5D3B3));

        commentaryLabel = new JTextArea("Please choose a pokemon");
        commentaryLabel.setBackground(new Color(0xE5D3B3));
        commentaryLabel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        commentaryLabel.setWrapStyleWord(true);
        commentaryLabel.setLineWrap(true);
        commentaryLabel.setEditable(false);
        commentaryPanel.add(commentaryLabel);

        commentaryOKButton = new JButton("OK");
        commentaryOKButton.addActionListener(this);
        commentaryOKButton.setVisible(false);

        commentaryPanel.add(commentaryOKButton, BorderLayout.SOUTH);

        topPanel.add(commentaryPanel, BorderLayout.CENTER);

        arenaPanel.add(topPanel, BorderLayout.NORTH);

    }

    public void setUpRightandLeftPanels() {
        JPanel rightPanel = new JPanel(new GridLayout(3, 1));
        rightPanel.setBackground(new Color(0xE5D3B3));
        rightPanel.setPreferredSize(new Dimension(350, 0));
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        JPanel user2BenchPanel = new JPanel();
        user2BenchPanel.setBackground(new Color(0xE5D3B3));
        user2BenchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        JPanel leftPanel = new JPanel(new GridLayout(3, 1));
        leftPanel.setBackground(new Color(0xE5D3B3));
        leftPanel.setPreferredSize(new Dimension(350, 0));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        JPanel user1BenchPanel = new JPanel();
        user1BenchPanel.setBackground(new Color(0xE5D3B3));
        user1BenchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        user2BenchPokemon = new ArrayList<>();
        user1BenchPokemon = new ArrayList<>();
        user2PokemonButtons = new ArrayList<>();
        user1PokemonButtons = new ArrayList<>();

        System.out.println("user2 queue size: " + user2.queue.getElements());

        for (int i = 0; i < user2.queue.getElements(); ++i) {

            user2BenchPokemon.add((user2.queue.peek(i)));
            JButton pokemonButton = user2BenchPokemon.get(i).getButton(Color.BLACK);
            pokemonButton.addActionListener(this);
            user2PokemonButtons.add(pokemonButton);
            user2BenchPanel.add(user2PokemonButtons.get(i));

            user1BenchPokemon.add((user1.queue.peek(i)));
            pokemonButton = user1BenchPokemon.get(i).getButton(Color.BLACK);
            pokemonButton.addActionListener(this);
            user1PokemonButtons.add(pokemonButton);
            user1BenchPanel.add(user1PokemonButtons.get(i));
        }

        System.out.println("user1 bench pokemon 1: " + user1BenchPokemon.get(0));

        rightPanel.add(user2BenchPanel);
        leftPanel.add(user1BenchPanel);

        JPanel user1PlayPanel = new JPanel(new BorderLayout());
        user1PlayPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        user1PlayPanel.setBackground(new Color(0xE5D3B3));
        user1PlayButton = new JButton("Play");
        user1PlayButton.addActionListener(this);
        user1Question = new JLabel();
        user1Question.setHorizontalAlignment(JLabel.CENTER);
        user1PlayPanel.add(user1PlayButton, BorderLayout.NORTH);
        user1PlayPanel.add(user1Question);
        leftPanel.add(user1PlayPanel);

        JPanel user2PlayPanel = new JPanel(new BorderLayout());
        user2PlayPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        user2PlayPanel.setBackground(new Color(0xE5D3B3));
        user2PlayButton = new JButton("Play");
        user2PlayButton.addActionListener(this);
        user2Question = new JLabel();
        user2Question.setHorizontalAlignment(JLabel.CENTER);
        user2PlayPanel.add(user2PlayButton, BorderLayout.NORTH);
        user2PlayPanel.add(user2Question);
        rightPanel.add(user2PlayPanel);


        JPanel user1AnswerPanel = new JPanel(new BorderLayout());
        user1AnswerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        user1AnswerPanel.setBackground(new Color(0xE5D3B3));
        user1TextField = new JTextField();
        user1TextField.setPreferredSize(new Dimension(0, 50));
        user1SubmitButton = new JButton("Submit");
        user1SubmitButton.addActionListener(this);
        user1AnswerPanel.add(user1TextField,BorderLayout.NORTH);
        user1AnswerPanel.add(user1SubmitButton, BorderLayout.SOUTH);
        leftPanel.add(user1AnswerPanel);

        JPanel user2AnswerPanel = new JPanel(new BorderLayout());
        user2AnswerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        user2AnswerPanel.setBackground(new Color(0xE5D3B3));
        user2TextField = new JTextField();
        user2TextField.setPreferredSize(new Dimension(0, 50));
        user2SubmitButton = new JButton("Submit");
        user2SubmitButton.addActionListener(this);
        user2AnswerPanel.add(user2TextField,BorderLayout.NORTH);
        user2AnswerPanel.add(user2SubmitButton, BorderLayout.SOUTH);
        rightPanel.add(user2AnswerPanel);


        arenaPanel.add(rightPanel, BorderLayout.EAST);
        arenaPanel.add(leftPanel, BorderLayout.WEST);

    }

    public ImageIcon scaleImg(ImageIcon img, int width, int height) {
        ImageIcon icon = img;
        Image scaledImg = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImg);
        return icon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(gameOver){
            return;
        }
        if (commentaryOKButton.isVisible()) {
            if (e.getSource() == commentaryOKButton) {
                commentaryOKButton.setVisible(false);
                if (user1isActive && user2isActive) {
                    if (gameTurn % 2 == 1) {
                        commentaryLabel.setText(user1.getUserName() + "'s turn");
                    } else {
                        commentaryLabel.setText(user2.getUserName() + "'s turn");
                    }
                }
                else{
                    if(user1BenchCnt == 0){
                        commentaryLabel.setText(user2.getUserName() + " wins the game!");
                        user1Question.setText("Better luck next time");
                        user2Question.setText("Splendid victory. You earned 30 coins");
                        user2.addCoin(30);
                        gameOver = true;

                    }
                    else if(user2BenchCnt == 0){
                        commentaryLabel.setText(user1.getUserName() + " wins the game!");
                        user2Question.setText("Better luck next time");
                        user1Question.setText("Splendid victory. You earned 30 coins");
                        user1.addCoin(30);
                        gameOver = true;
                    }
                }
            }
        }
        else {

            if (user1isActive && user2isActive) {
                if (gameTurn % 2 != 0) {
                    if (e.getSource() == user1PlayButton) {
                        user1isPlaying = true;
                        setQuestion(user1Question);

                    } else if (user1isPlaying) {

                        if (e.getSource() == user1SubmitButton) {
                            int answer = Integer.parseInt(user1TextField.getText());
                            if (answer == correctAnswer) {
                                user1Question.setText("correct!");

                                int activeHp=1;

                                for (int i = 0; i < user2BenchPokemon.size(); ++i) {
                                    if (user2ActivePokemon == user2BenchPokemon.get(i)) {
                                        user2PokemonHP[i] = user2PokemonHP[i] - user1ActivePokemon.getAttackPower();
                                        activeHp = user2PokemonHP[i];
                                        if (i == 0) {
                                            if (activeHp <= 0) {
                                                user2Pokemon1HPLabel.setText(" HP : 0/" + user2BenchPokemon.get(i).getHP());
                                            }
                                            else {
                                                user2Pokemon1HPLabel.setText(" HP : " + user2PokemonHP[i] + "/" + user2BenchPokemon.get(i).getHP());
                                            }
                                        } else if (i == 1) {
                                            if (activeHp <= 0) {
                                                user2Pokemon2HPLabel.setText(" HP : 0/" + user2BenchPokemon.get(i).getHP());
                                            }
                                            else {
                                                user2Pokemon2HPLabel.setText(" HP : " + user2PokemonHP[i] + "/" + user2BenchPokemon.get(i).getHP());
                                            }

                                        } else {
                                            if (activeHp <= 0) {
                                                user2Pokemon3HPLabel.setText(" HP : 0/" + user2BenchPokemon.get(i).getHP());
                                            }
                                            else {
                                                user2Pokemon3HPLabel.setText(" HP : " + user2PokemonHP[i] + "/" + user2BenchPokemon.get(i).getHP());
                                            }
                                        }
                                        break;
                                    }
                                }
                                String str = ".";
                                if(activeHp<=0){
                                    user2isActive = false;
                                    user2BenchCnt--;
                                    user2Question.setText((user2BenchCnt==0)?"":"Please activate another pokemon") ;
                                    str = " and knocks them out of the game!";

                                }

                                commentaryLabel.setText(user1.getUserName() + "'s " + user1ActivePokemon.getName() + " uses " + user1ActivePokemon.getAttack()
                                        + " and deals " + user1ActivePokemon.getAttackPower() + " damage to " + user2.getUserName() + "'s " + user2ActivePokemon.getName() + str);
                                commentaryOKButton.setVisible(true);

                            } else {
                                user1Question.setText("incorrect");
                                commentaryLabel.setText("Player 1 fails Math");
                                commentaryOKButton.setVisible(true);
                            }
                            gameTurn++;

                            user1isPlaying = false;
                        }
                    }
                } else {
                    if (e.getSource() == user2PlayButton) {
                        user2isPlaying = true;
                        setQuestion(user2Question);

                    } else if (user2isPlaying) {

                        if (e.getSource() == user2SubmitButton) {
                            int answer = Integer.parseInt(user2TextField.getText());
                            if (answer == correctAnswer) {
                                user2Question.setText("correct!");

                                int activeHp=1;
                                for (int i = 0; i < user1BenchPokemon.size(); ++i) {
                                    if (user1ActivePokemon == user1BenchPokemon.get(i)) {
                                        user1PokemonHP[i] = user1PokemonHP[i] - user2ActivePokemon.getAttackPower();
                                        activeHp = user1PokemonHP[i];
                                        if (i == 0) {
                                            if (activeHp <= 0) {
                                                user1Pokemon1HPLabel.setText(" HP : 0/" + user1BenchPokemon.get(i).getHP());
                                            }
                                            else {
                                                user1Pokemon1HPLabel.setText(" HP : " + user1PokemonHP[i] + "/" + user1BenchPokemon.get(i).getHP());
                                            }
                                        } else if (i == 1) {
                                            if (activeHp <= 0) {
                                                user1Pokemon2HPLabel.setText(" HP : 0/" + user1BenchPokemon.get(i).getHP());
                                            }
                                            else {
                                                user1Pokemon2HPLabel.setText(" HP : " + user1PokemonHP[i] + "/" + user1BenchPokemon.get(i).getHP());
                                            }

                                        } else {
                                            if (activeHp <= 0) {
                                                user1Pokemon3HPLabel.setText(" HP : 0/" + user1BenchPokemon.get(i).getHP());
                                            }
                                            else {
                                                user1Pokemon3HPLabel.setText(" HP : " + user1PokemonHP[i] + "/" + user1BenchPokemon.get(i).getHP());
                                            }
                                        }
                                        break;
                                    }
                                }

                                String str = ".";
                                if(activeHp<=0){
                                    user1isActive = false;
                                    str = " and knocks them out of the game!";
                                    user1BenchCnt--;
                                    user1Question.setText((user1BenchCnt==0)?"":"Please activate another pokemon") ;
                                }

                                commentaryLabel.setText(user2.getUserName() + "'s " + user2ActivePokemon.getName() + " uses " + user2ActivePokemon.getAttack()
                                        + " and deals " + user2ActivePokemon.getAttackPower() + " damage to " + user1.getUserName() + "'s " + user1ActivePokemon.getName() + str);
                                commentaryOKButton.setVisible(true);



                            } else {
                                user2Question.setText("incorrect");
                                commentaryLabel.setText("Player 2 fails Math");
                                commentaryOKButton.setVisible(true);
                            }
                            gameTurn++;

                            user2isPlaying = false;
                        }
                    }
                }
            }
            if (!user1isActive) {
                for (int i = 0; i < user1PokemonButtons.size(); ++i) {
                    if (e.getSource() == user1PokemonButtons.get(i)) {
                        user1PokemonButtons.get(i).setEnabled(false);
                        user1ActivePokemon = user1BenchPokemon.get(i);
                        activePokemonLabel1.setIcon(scaleImg(user1BenchPokemon.get(i).getPokemonImg(), 125, 125));
                        commentaryLabel.setText(user1.getUserName() + " chooses " + user1BenchPokemon.get(i).getName());
                        commentaryOKButton.setVisible(true);
                        user1isActive = true;
                        user1Question.setText("");
                    }
                }
            }
            if (!user2isActive) {
                for (int i = 0; i < user2PokemonButtons.size(); ++i) {
                    if (e.getSource() == user2PokemonButtons.get(i)) {
                        user2PokemonButtons.get(i).setEnabled(false);
                        user2ActivePokemon = user2BenchPokemon.get(i);
                        activePokemonLabel2.setIcon(scaleImg(user2BenchPokemon.get(i).getPokemonImg(), 125, 125));
                        commentaryLabel.setText(user2.getUserName() + " chooses " + user2BenchPokemon.get(i).getName());
                        commentaryOKButton.setVisible(true);
                        user2isActive = true;
                        user2Question.setText("");
                    }
                }
            }
        }
    }

        public void setQuestion(JLabel label){


            Random rand = new Random();
            int aNum = rand.nextInt(10);
            int bNum = rand.nextInt(10);
            int operator = rand.nextInt(3);
            if (operator == 0) {
                label.setText("Solve the expression: \n" + aNum + " + " + bNum);
                correctAnswer = aNum + bNum;
            } else if (operator == 1) {
                label.setText("Solve the expression: \n" + aNum + " - " + bNum);
                correctAnswer = aNum - bNum;
            } else if (operator == 2) {
                label.setText("Solve the expression: \n" + aNum + " * " + bNum);
                correctAnswer = aNum * bNum;
            } else {
                label.setText("Solve the expression: \n" + aNum + " / " + (bNum+1));
                correctAnswer = aNum / (bNum + 1);
            }

        }

    }

