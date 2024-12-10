import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

public class PokemonMarketPanel extends JPanel implements ActionListener {
    JLabel coinLabel;
    JPanel collectionPanel;
    ArrayList<JButton> pokemonButtons;
    PokemonCenter center ;
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
    JButton purchaseButton;
    ImageIcon pokemonMarketIcon;
    ImageIcon homeIcon;
    PokemonUser user1;
    int index;
    JTextField searchBar;
    JButton searchButton;
    JLabel searchLabel;

        PokemonMarketPanel(PokemonUser user1, PokemonCenter center){
            this.center = center;
            // setup Main Panel
            setLayout(new BorderLayout());
            setBackground(Color.red);
            this.user1 = user1;
            addLeftPanel(center.cardCollection.get(0));
            addRightPanel(user1);
        }


    @Override
    public void actionPerformed(ActionEvent e) {

            searchLabel.setVisible(false);

            if(e.getSource()==searchButton){
                String search = searchBar.getText();
                PokemonCard card = center.pokemonTree.search(search);
                if(card!=null){
                    displayPokemon(card);
                    purchaseButton.setText("Purchase " + card.getName() + " for 10 coins");
                    purchaseButton.setVisible(true);
                    index = center.getIndex(card);
                }
                else{
                    searchLabel.setVisible(true);
                }
            }
            else {
                if (e.getSource() == purchaseButton) {
                    if (user1.getBalance() < 10) {
                        purchaseButton.setText("Not enough funds");
                    } else if (user1.has(center.cardCollection.get(index))) {
                        purchaseButton.setText("You already have " + center.cardCollection.get(index).getName());
                    } else {

                        user1.removeCoin(10);
                        coinLabel.setText(Integer.toString(user1.getBalance()));
                        user1.addCard(center.cardCollection.get(index));

                        System.out.println("purchased " + center.cardCollection.get(index).getName()
                                + "\nCurrent balance: " + user1.getBalance());
                    }
                } else {
                    for (index = 0; index < pokemonButtons.size(); ++index) {
                        if (e.getSource() == pokemonButtons.get(index)) {
                            System.out.println("Display: " + center.cardCollection.get(index).getName());
                            displayPokemon(center.cardCollection.get(index));
                            purchaseButton.setText("Purchase " + center.cardCollection.get(index).getName() + " for 10 coins");
                            purchaseButton.setVisible(true);
                            break;
                        }
                    }
                }
            }
    }

    public void addLeftPanel(PokemonCard card){
        // setup titlePanel
        titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0xB99976));
        title = new JLabel();
        pokemonMarketIcon = scaleImg(new ImageIcon("Images/PokemonMarket.png"),300,315);
        title.setIcon(pokemonMarketIcon);
        titlePanel.add(title);
        // setup buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0xB99976));
        buttonPanel.setPreferredSize(new Dimension(75,0));
        homeButton = new JButton("Home");
        homeButton.setPreferredSize(new Dimension(75,25));
        homeIcon = scaleImg(new ImageIcon("Images/HomeIcon.png"),15,15);
        homeButton.setIcon(homeIcon);
        buttonPanel.add(homeButton);

        //setup topLeftPanel
        topLeftPanel = new JPanel();
        topLeftPanel.setBackground(Color.gray);
        topLeftPanel.setBorder(BorderFactory.createLineBorder(new Color(0x644229),10));
        topLeftPanel.setPreferredSize(new Dimension(600,350));
        topLeftPanel.setLayout(new BorderLayout());
        topLeftPanel.add(buttonPanel,BorderLayout.WEST);
        topLeftPanel.add(titlePanel,BorderLayout.CENTER);

        //setup bottomLeftPanel
        bottomLeftPanel = new JPanel();

        bottomLeftPanel.setLayout(new BorderLayout());
        bottomLeftPanel.setBorder(BorderFactory.createLineBorder(new Color(0x644229),10));

        pokemonStatsPanel = new JPanel();
        pokemonStatsPanel.setLayout(new GridLayout(5,1));
        pokemonStatsPanel.setBorder(BorderFactory.createLineBorder(new Color(0x644229),1));
        pokemonStatsPanel.setPreferredSize(new Dimension(200,0));

        nameLabel = new JLabel(" Name: " + card.name);
        typeLabel = new JLabel(" Type: " + card.type);
        hpLabel = new JLabel(" HP: " + card.hp);
        attackLabel = new JLabel(" Attack: " + card.attack);
        attackPowerLabel = new JLabel(" Attack Power: " + card.attackPower);

        nameLabel.setBorder(BorderFactory.createLineBorder(new Color(0x644229),1));
        typeLabel.setBorder(BorderFactory.createLineBorder(new Color(0x644229),1));
        hpLabel.setBorder(BorderFactory.createLineBorder(new Color(0x644229),1));
        attackLabel.setBorder(BorderFactory.createLineBorder(new Color(0x644229),1));
        attackPowerLabel.setBorder(BorderFactory.createLineBorder(new Color(0x644229),1));

        pokemonStatsPanel.add(nameLabel);
        pokemonStatsPanel.add(typeLabel);
        pokemonStatsPanel.add(hpLabel);
        pokemonStatsPanel.add(attackLabel);
        pokemonStatsPanel.add(attackPowerLabel);

        pokedexLabel = new JLabel(scaleImg(card.pokemonImg,300,300));

        pokemonDescriptionPanel = new JPanel();
        pokemonDescriptionPanel.setPreferredSize(new Dimension(300,100));
        pokemonDescriptionPanel.setBorder(BorderFactory.createLineBorder(new Color(0x644229),5));
        pokemonDescriptionPanel.setLayout(new BorderLayout());

        descLabel = new JTextArea(card.description);

        descLabel.setBorder(BorderFactory.createLineBorder(Color.white,5));

        descLabel.setWrapStyleWord(true);
        descLabel.setLineWrap(true);
        descLabel.setEditable(false);
        pokemonDescriptionPanel.add(descLabel);

        bottomLeftPanel.add(pokemonStatsPanel,BorderLayout.EAST);
        bottomLeftPanel.add(pokedexLabel);
        bottomLeftPanel.add(pokemonDescriptionPanel,BorderLayout.SOUTH);

        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(600,800));
        leftPanel.add(topLeftPanel,BorderLayout.NORTH);
        leftPanel.add(bottomLeftPanel);

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

    public void addRightPanel(PokemonUser user1){
        // create display of store's pokemon collection

        pokemonButtons = new ArrayList<JButton>();

        for(int i =0; i < center.cardCollection.size(); ++i) {
            PokemonCard card = center.cardCollection.get(i);
            JButton pokemonButton = card.getButton(new Color(0x644229));
            pokemonButton.addActionListener(this);
            pokemonButtons.add(pokemonButton);
        }

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        JPanel coinDisplayPanel = new JPanel();
        coinDisplayPanel.setLayout(new BorderLayout());
        coinDisplayPanel.setBorder(BorderFactory.createLineBorder(new Color(0x644229),10));

        coinLabel = new JLabel(Integer.toString(user1.getBalance()));
        coinLabel.setPreferredSize(new Dimension(100,50));
        coinLabel.setIcon(scaleImg(new ImageIcon("Images/pokemonCoin.png"),30,30));
        coinLabel.setHorizontalAlignment(SwingConstants.CENTER);
        coinLabel.setVerticalAlignment(SwingConstants.CENTER);
        coinLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        coinLabel.setVerticalTextPosition(SwingConstants.CENTER);
        coinLabel.setIconTextGap(10);

        purchaseButton = new JButton("Purchase");
        purchaseButton.addActionListener(this);
        purchaseButton.setVisible(false);

        coinDisplayPanel.add(coinLabel,BorderLayout.EAST);
        coinDisplayPanel.add(purchaseButton,BorderLayout.WEST);

        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createLineBorder(new Color(0x644229),10));
        searchBar = new JTextField();
        searchBar.setPreferredSize(new Dimension(200,25));
        searchButton = new JButton("Search Pokemon");
        searchButton.addActionListener(this);
        searchLabel = new JLabel("No such pokemon.");
        searchLabel.setVisible(false);
        searchPanel.add(searchBar);
        searchPanel.add(searchButton);
        searchPanel.add(searchLabel);

        JPanel topRightPanel = new JPanel(new BorderLayout());
        topRightPanel.add(coinDisplayPanel,BorderLayout.NORTH);
        topRightPanel.add(searchPanel);

        rightPanel.add(topRightPanel,BorderLayout.NORTH);

        collectionPanel = new JPanel();
        collectionPanel.setBackground(new Color(0xE5D3B3));
        collectionPanel.setBorder(BorderFactory.createLineBorder(new Color(0x644229),10));
        collectionPanel.setLayout(new FlowLayout());

        for(int i = 0; i < pokemonButtons.size(); ++i){
            collectionPanel.add(pokemonButtons.get(i));
        }

        rightPanel.add(collectionPanel);

        add(rightPanel);
    }
}


