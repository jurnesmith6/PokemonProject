import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PokemonUser {
    String userName;
    String passWord;
    ArrayList<PokemonCard> cardCollection;
    Integer coin;
    PokemonQueue queue;

    public PokemonUser(String userName,String password){
        this.userName = userName;
        this.passWord = password;
        coin = 100;
        cardCollection = new ArrayList<>();
        queue = new PokemonQueue();
    }
    public void addCard(PokemonCard card){
        cardCollection.add(card);
    }

    public PokemonCard getCard(String name){
        for (int i = 0; i < cardCollection.size(); ++i){
            if(cardCollection.get(i).getName().equals(name)){
                return cardCollection.get(i);
            }
        }
        return null;
    }
    public PokemonCard getCard(int index){
        return cardCollection.get(index);
    }
    public void removeCard(String name){
        for (int i = 0; i < cardCollection.size(); ++i){
            if(cardCollection.get(i).getName().equals(name)){
                 cardCollection.remove(i);
            }
        }
    }

    public boolean has(PokemonCard card) {
        for (int i = 0; i < cardCollection.size(); ++i) {
            if (card == cardCollection.get(i)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<PokemonCard> getCollection(){
        return cardCollection;
    }

    public int getBalance(){
        return coin;
    }
    public void addCoin(int amount){
        coin += amount;
    }
    public void removeCoin(int amt){
        coin -= amt;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassWord(){
        return passWord;
    }

}
