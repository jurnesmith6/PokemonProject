import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyPokemonPanel extends JPanel implements ActionListener {
    JPanel rightPanel;
    ArrayList<JButton> pokemonButtons;
    ArrayList<PokemonCard> pokemonCards;
    JPanel leftPanel;
    JPanel topLeftPanel;
    JPanel bottomLeftPanel;
    JLabel nameLabel;
    JLabel typeLabel ;
    JLabel hpLabel ;
    JLabel attackLabel ;
    JLabel attackPowerLabel ;
    JPanel titlePanel;
    JPanel buttonPanel;
    JPanel pokemonStatsPanel;
    JPanel pokemonDescriptionPanel;
    JTextArea descLabel;
    JLabel pokedexLabel;
    JLabel title;
    JButton homeButton;
    ImageIcon myPokemonIcon;
    ImageIcon homeIcon;

    MyPokemonPanel(ArrayList<PokemonCard> pokemonCards){
        this.pokemonCards = pokemonCards;
        //setup Main Panel

        setLayout(new BorderLayout());
        //setup Left Panel
        addLeftPanel();
        //setup right panel
        addRightPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < pokemonButtons.size(); ++i) {
            if (e.getSource() == pokemonButtons.get(i)) {
                System.out.println("Display: " + pokemonCards.get(i).getName());
                displayPokemon(pokemonCards.get(i));
            }
        }
    }

    public void addLeftPanel(){
        // setup titlePanel
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.gray);
        title = new JLabel();
        myPokemonIcon = scaleImg(new ImageIcon("Images/MyPokemonIcon.png"),300,315);
        title.setIcon(myPokemonIcon);
        titlePanel.add(title);

        // setup buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.gray);
        buttonPanel.setPreferredSize(new Dimension(75,0));
        homeButton = new JButton("Home");
        homeButton.setPreferredSize(new Dimension(75,25));
        homeIcon = scaleImg(new ImageIcon("Images/HomeIcon.png"),15,15);
        homeButton.setIcon(homeIcon);
        buttonPanel.add(homeButton);

        //setup topLeftPanel
        topLeftPanel = new JPanel();
        topLeftPanel.setBackground(Color.gray);
        topLeftPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray,10));
        topLeftPanel.setPreferredSize(new Dimension(600,350));
        topLeftPanel.setLayout(new BorderLayout());
        topLeftPanel.add(buttonPanel,BorderLayout.WEST);
        topLeftPanel.add(titlePanel,BorderLayout.CENTER);

        //setup bottomLeftPanel
        bottomLeftPanel = new JPanel();

        bottomLeftPanel.setLayout(new BorderLayout());
        bottomLeftPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray,10));

        pokemonStatsPanel = new JPanel();
        pokemonStatsPanel.setLayout(new GridLayout(5,1));
        pokemonStatsPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray,1));
        pokemonStatsPanel.setPreferredSize(new Dimension(200,0));

        if(pokemonCards.size() > 0) {
            nameLabel = new JLabel(" Name: " + pokemonCards.get(0).name);
            typeLabel = new JLabel(" Type: " + pokemonCards.get(0).type);
            hpLabel = new JLabel(" HP: " + pokemonCards.get(0).hp);
            attackLabel = new JLabel(" Attack: " + pokemonCards.get(0).attack);
            attackPowerLabel = new JLabel(" Attack Power: " + pokemonCards.get(0).attackPower);
            pokedexLabel = new JLabel(scaleImg(pokemonCards.get(0).pokemonImg, 300, 300));
            descLabel = new JTextArea(pokemonCards.get(0).description);
        }
        else{
            nameLabel = new JLabel();
            typeLabel = new JLabel();
            hpLabel = new JLabel();
            attackLabel = new JLabel();
            attackPowerLabel = new JLabel();
            pokedexLabel = new JLabel();
            descLabel = new JTextArea("You have no pokemon");
        }


        nameLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,1));
        typeLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,1));
        hpLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,1));
        attackLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,1));
        attackPowerLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,1));

        pokemonStatsPanel.add(nameLabel);
        pokemonStatsPanel.add(typeLabel);
        pokemonStatsPanel.add(hpLabel);
        pokemonStatsPanel.add(attackLabel);
        pokemonStatsPanel.add(attackPowerLabel);

        pokemonDescriptionPanel = new JPanel();
        pokemonDescriptionPanel.setPreferredSize(new Dimension(300,100));
        pokemonDescriptionPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray,5));
        pokemonDescriptionPanel.setLayout(new BorderLayout());

        descLabel.setBorder(BorderFactory.createLineBorder(Color.white,5));

        descLabel.setWrapStyleWord(true);
        descLabel.setLineWrap(true);
        descLabel.setEditable(false);
        pokemonDescriptionPanel.add(descLabel);


        bottomLeftPanel.add(pokemonStatsPanel,BorderLayout.EAST);
        bottomLeftPanel.add(pokedexLabel);
        bottomLeftPanel.add(pokemonDescriptionPanel,BorderLayout.SOUTH);

        //setup leftPanel
        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(600,800));
        leftPanel.add(topLeftPanel,BorderLayout.NORTH);
        leftPanel.add(bottomLeftPanel);

        // add leftPanel to main panel
        add(leftPanel,BorderLayout.WEST);

    }

    public void displayPokemon(PokemonCard card){

       nameLabel.setText(" Name: " + card.name);
       typeLabel.setText(" Type: " + card.type);
       hpLabel.setText(" HP: " + card.hp);
       attackLabel.setText(" Attack: " + card.attack);
       attackPowerLabel.setText(" Attack Power: " + card.attackPower);
       pokedexLabel.setIcon(scaleImg(card.pokemonImg,300,300));
       descLabel.setText(card.description);
    }

    public ImageIcon scaleImg(ImageIcon img, int width, int height){
        ImageIcon icon = img;
        Image scaledImg = icon.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImg);
        return icon;
    }

    public void addRightPanel(){
        // create display of user's pokemon collection
        rightPanel = new JPanel();
        rightPanel.setBackground(new Color(0xD14747));
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray,10));
        rightPanel.setLayout(new FlowLayout());

        pokemonButtons = new ArrayList<JButton>();


        if(pokemonCards.size() > 0) {
            for (int i = 0; i < pokemonCards.size(); ++i) {
                PokemonCard card = pokemonCards.get(i);
                JButton pokemonButton = card.getButton(Color.darkGray);
                pokemonButton.addActionListener(this);
                pokemonButtons.add(pokemonButton);
            }
            for (int i = 0; i < pokemonButtons.size(); ++i) {
                rightPanel.add(pokemonButtons.get(i));
            }
        }

        add(rightPanel);

    }

}
