import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel implements ActionListener {
    JButton myPokemonButton;
    JButton pokemonMarketButton;
    JButton tradeButton;
    JButton battleArenaButton;
    JButton charactersButton;



    HomePanel(PokemonUser user1){
        // create directoryPanel
        JPanel directoryPanel = new JPanel();
        directoryPanel.setLayout(new GridLayout(2,2));
        // create home buttons
        myPokemonButton = new JButton("My Pokemon");
        myPokemonButton.setBackground(new Color(0xD14747));
        myPokemonButton.setBorderPainted(false);
        myPokemonButton.setOpaque(true);

        pokemonMarketButton = new JButton("Pokemon Market");
        pokemonMarketButton.setBackground(new Color(0xE5D3B3));
        pokemonMarketButton.setBorderPainted(false);
        pokemonMarketButton.setOpaque(true);

        battleArenaButton =  new JButton("Battle Arena");
        battleArenaButton.setBackground(new Color(0x2976A3));
        battleArenaButton.setBorderPainted(false);
        battleArenaButton.setOpaque(true);

        charactersButton =  new JButton("Characters");
        charactersButton.setBackground(new Color(0x0A6906));
        charactersButton.setBorderPainted(false);
        charactersButton.setOpaque(true);
        // add buttons
        directoryPanel.add(myPokemonButton);
        directoryPanel.add(pokemonMarketButton);
        directoryPanel.add(battleArenaButton);
        directoryPanel.add(charactersButton);
        // create userNamePanel
        JPanel userNamePanel = new JPanel(new BorderLayout());
        userNamePanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,5));
        JLabel userNameLabel = new JLabel(user1.getUserName());
        userNameLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,10));
        userNamePanel.add(userNameLabel,BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(directoryPanel);
        add(userNamePanel,BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
