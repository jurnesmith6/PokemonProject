import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class BattleArenaPanel extends JPanel implements ActionListener {

    PokemonUser user1;
    PokemonUser user2;

    CardLayout cardLayout;
    BattleArenaStartPanel startPanel;

    BattleArenaGamePanel gamePanel;

    MyFrame frame;

    BattleArenaPanel(MyFrame frame, PokemonUser user1) {

        this.frame = frame;
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        setBackground(Color.orange);

        this.user1 = user1;
        user2 = new PokemonUser(null,null);
        startPanel = new BattleArenaStartPanel(this,user1,user2);
        add(startPanel,"startPanel");

    }

    public void startGamePanel(){
        gamePanel = new BattleArenaGamePanel(user1,user2);
        frame.updateGamePanelHomeButton();
        add(gamePanel,"gamePanel");
        cardLayout.show(this,"gamePanel");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}




