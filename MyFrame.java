import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFrame extends JFrame implements ActionListener {
    StarterPagePanel starterPagePanel;
    HomePanel homePanel;
    MyPokemonPanel myPokemonPanel;
    PokemonMarketPanel pokemonMarketPanel;
    TradePanel tradePanel;
    BattleArenaPanel battleArenaPanel;
    CharactersPanel charactersPanel;
    CardLayout cardLayout;
    PokemonUser user1;
    PokemonCenter center;

    MyFrame(){

        // set frame
        setSize(1200,800);
        setTitle("Pokemon Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        center = new PokemonCenter();
        starterPagePanel = new StarterPagePanel(this);
        add(starterPagePanel,"StarterPage");
        setVisible(true);
    }

    public void startApp(PokemonUser user1){
        this.user1 = user1;
        // add homePanel
        homePanel = new HomePanel(user1);
        homePanel.myPokemonButton.addActionListener(this);
        homePanel.pokemonMarketButton.addActionListener(this);
        homePanel.battleArenaButton.addActionListener(this);
        homePanel.charactersButton.addActionListener(this);
        add(homePanel,"Home");

    }

    public void updateGamePanelHomeButton(){
        battleArenaPanel.gamePanel.exitGameButton.addActionListener(this);
    }
    public void goToHomePage(){
        cardLayout.show(getContentPane(), "Home"); // Show the home panel
    }
    public void goToMyPokemonPage(){
        myPokemonPanel = new MyPokemonPanel(user1.getCollection());
        myPokemonPanel.homeButton.addActionListener(this);
        add(myPokemonPanel,"myPokemon");
        cardLayout.show(getContentPane(), "myPokemon");
    }
    public void goToMarketPage(){
        pokemonMarketPanel = new PokemonMarketPanel(user1, center);
        pokemonMarketPanel.homeButton.addActionListener(this);
        add(pokemonMarketPanel,"pokemonMarket");
        cardLayout.show(getContentPane(), "pokemonMarket");
    }
    public void goToTradePage(){
        tradePanel = new TradePanel();
        tradePanel.homeButton.addActionListener(this);
        add(tradePanel,"trade");
        cardLayout.show(getContentPane(), "trade");
    }
    public void goToBattleArenaPage(){
        battleArenaPanel = new BattleArenaPanel(this,user1);
        battleArenaPanel.startPanel.homeButton.addActionListener(this);
        add(battleArenaPanel,"battleArena");
        cardLayout.show(getContentPane(), "battleArena");
    }
    public void goToCharactersPage(){
        charactersPanel = new CharactersPanel();
        charactersPanel.homeButton.addActionListener(this);
        add(charactersPanel,"characters");
        cardLayout.show(getContentPane(), "characters");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==homePanel.myPokemonButton){
            System.out.println("display myPokemon page");
            goToMyPokemonPage();

        }
        else if(e.getSource()==homePanel.pokemonMarketButton){
            System.out.println("Display PokemonMarket Page");
            goToMarketPage();

        }
        else if(e.getSource()==homePanel.tradeButton){
            System.out.println("Display Trade Page");
            goToTradePage();

        }
        else if(e.getSource()==homePanel.battleArenaButton){
            System.out.println("Display Battle arena Page");
            goToBattleArenaPage();

        }
        else if(e.getSource()==homePanel.charactersButton){
            System.out.println("Display characters Page");
            goToCharactersPage();

        }
        else{
            System.out.println("Display home Page");
            goToHomePage();
        }
    }
}
