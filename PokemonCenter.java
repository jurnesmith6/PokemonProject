import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
public class PokemonCenter {
    HashMap<String, PokemonCard> storeCollection = new HashMap<>();
    HashMap<String,String> pokemonDescriptions = new HashMap<>();
    ArrayList<PokemonCard> cardCollection = new ArrayList<>();
    PokemonBinarySearchTree pokemonTree;
    PokemonUser user1;
    PokemonUser user2;
    PokemonCenter(){
        fillMap(pokemonDescriptions);
        loadhashCollection();
        fillCardCollection();
        loadPokemonTree();
    }

    public ArrayList<PokemonCard> getCardCollection(){
        return cardCollection;
    }
    public void loadhashCollection(){

        storeCollection.put("Bulbasaur", new PokemonCard("Bulbasaur","Grass","Vine Whip",50,70,new ImageIcon("Images/BulbasaurImg.png"), pokemonDescriptions.get("Bulbasaur")) );
        storeCollection.put("Charmander", new PokemonCard("Charmander","Fire","Fire Breath",30,70,new ImageIcon("Images/CharmanderImg.png"),pokemonDescriptions.get("Charmander")));
        storeCollection.put("Squirtle", new PokemonCard("Squirtle","Water","Water Gun",20,70,new ImageIcon("Images/SquirtleImg.png"),pokemonDescriptions.get("Squirtle")));
        storeCollection.put("Pidgey", new PokemonCard("Pidgey","Wind","Gust",20,60,new ImageIcon("Images/PidgeyImg.png"),pokemonDescriptions.get("Pidgey")));
        storeCollection.put("Pikachu", new PokemonCard("Pikachu","Electric","Lightning bolt",50,70,new ImageIcon("Images/PikachuImg.png"),pokemonDescriptions.get("Pikachu")));
        storeCollection.put("Mankey", new PokemonCard("Mankey","Fighting","Monkey Beatdown",30,60,new ImageIcon("Images/MankeyImg.png"),pokemonDescriptions.get("Mankey")));
        storeCollection.put("Growlithe", new PokemonCard("Growlithe","Fire","Fire claws",50,70,new ImageIcon("Images/GrowlitheImg.png"),pokemonDescriptions.get("Growlithe")));
        storeCollection.put("Geodude", new PokemonCard("Geodude","Rock","Knuckle Punch",30,80,new ImageIcon("Images/GeodudeImg.png"),pokemonDescriptions.get("Geodude")));
        storeCollection.put("Cubone", new PokemonCard("Cubone","Ground","Bone Attack",20,50,new ImageIcon("Images/CuboneImg.png"),pokemonDescriptions.get("Cubone")));
        storeCollection.put("Caterpie", new PokemonCard("Caterpie","Grass","Bug Bite",10,40,new ImageIcon("Images/CaterpieImg.png"),pokemonDescriptions.get("Caterpie")));
        storeCollection.put("Jigglypuff", new PokemonCard("Jigglypuff","Fairy","Moon Kick",20,70,new ImageIcon("Images/JigglyPuffImg.png"),pokemonDescriptions.get("Jigglypuff")));
        storeCollection.put("Zubat", new PokemonCard("Zubat","Flying","Razor Wing",20,50,new ImageIcon("Images/ZubatImg.png"),pokemonDescriptions.get("Zubat")));
        storeCollection.put("Magnemite", new PokemonCard("Magnemite","Electric","Spark",10,60,new ImageIcon("Images/MagnemiteImg.png"),pokemonDescriptions.get("Magnemite")));
    }

    public static void fillMap(HashMap<String,String> map){
        map.put("Cubone","When the memory of its departed mother brings it to tears, " +
                "its cries echo mournfully within the skull it wears on its head.");
        map.put("Bulbasaur","For some time after its birth, " +
                "it uses the nutrients that are packed into the seed on its back in order to grow.");
        map.put("Charmander","The flame on its tail shows the strength of its life-force." +
                " If Charmander is weak, the flame also burns weakly.");
        map.put("Squirtle","After birth, its back swells and hardens into a shell. " +
                "It sprays a potent foam from its mouth.");
        map.put("Caterpie","For protection, it releases a horrible stench from the antenna on its head to drive away enemies.");
        map.put("Pidgey","Very docile. If attacked, it will often kick up sand to protect itself rather than fight back.");
        map.put("Pikachu","When it is angered, it immediately discharges the energy stored in the pouches in its cheeks.");
        map.put("Jigglypuff","When its huge eyes waver, it sings a mysteriously soothing melody that lulls its enemies to sleep.");
        map.put("Zubat","It emits ultrasonic waves from its mouth to check its surroundings. Even in tight caves, Zubat flies around with skill.");
        map.put("Mankey","It lives in groups in the treetops. If it loses sight of its group, it becomes infuriated by its loneliness.");
        map.put("Growlithe","It has a brave and trustworthy nature. It fearlessly stands up to bigger and stronger foes.");
        map.put("Geodude","At rest, it looks just like a rock. Carelessly stepping on it will make it swing its fists angrily.");
        map.put("Magnemite","The electromagnetic waves emitted by the units at the sides of its head expel antigravity, which allows it to float.");

    }
    public void fillCardCollection(){

        cardCollection.add(new PokemonCard("Bulbasaur","Grass","Vine Whip",50,70,new ImageIcon("Images/BulbasaurImg.png"),pokemonDescriptions.get("Bulbasaur")));
        cardCollection.add(new PokemonCard("Charmander","Fire","Fire Breath",30,70,new ImageIcon("Images/CharmanderImg.png"),pokemonDescriptions.get("Charmander")));
        cardCollection.add(new PokemonCard("Squirtle","Water","Water Gun",20,70,new ImageIcon("Images/SquirtleImg.png"),pokemonDescriptions.get("Squirtle")));
        cardCollection.add(new PokemonCard("Pidgey","Wind","Gust",20,60,new ImageIcon("Images/PidgeyImg.png"),pokemonDescriptions.get("Pidgey")));
        cardCollection.add(new PokemonCard("Pikachu","Electric","Lightning bolt",50,70,new ImageIcon("Images/PikachuImg.png"),pokemonDescriptions.get("Pikachu")));
        cardCollection.add( new PokemonCard("Mankey","Fighting","Monkey Beatdown",30,60,new ImageIcon("Images/MankeyImg.png"),pokemonDescriptions.get("Mankey")));
        cardCollection.add(new PokemonCard("Growlithe","Fire","Fire claws",50,70,new ImageIcon("Images/GrowlitheImg.png"),pokemonDescriptions.get("Growlithe")));
        cardCollection.add(new PokemonCard("Geodude","Rock","Knuckle Punch",30,80,new ImageIcon("Images/GeodudeImg.png"),pokemonDescriptions.get("Geodude")));
        cardCollection.add(new PokemonCard("Cubone","Ground","Bone Attack",20,50,new ImageIcon("Images/CuboneImg.png"),pokemonDescriptions.get("Cubone")));
        cardCollection.add(new PokemonCard("Caterpie","Grass","Bug Bite",10,40,new ImageIcon("Images/CaterpieImg.png"),pokemonDescriptions.get("Caterpie")));
        cardCollection.add(new PokemonCard("Jigglypuff","Fairy","Moon Kick",20,70,new ImageIcon("Images/JigglyPuffImg.png"),pokemonDescriptions.get("Jigglypuff")));
        cardCollection.add(new PokemonCard("Zubat","Flying","Razor Wing",20,50,new ImageIcon("Images/ZubatImg.png"),pokemonDescriptions.get("Zubat")));
        cardCollection.add(new PokemonCard("Magnemite","Electric","Spark",10,60,new ImageIcon("Images/MagnemiteImg.png"),pokemonDescriptions.get("Magnemite")));
    }

    public PokemonCard getStoreCard(String name){
        return storeCollection.get(name);
    }

    public void loadPokemonTree(){
        pokemonTree = new PokemonBinarySearchTree();

        for(PokemonCard card : cardCollection){
            pokemonTree.insertCard(card);
        }
    }

    public int getIndex(PokemonCard card){

        for(int i = 0; i < cardCollection.size(); ++i){
            if(cardCollection.get(i) == card){
                return i;
            }
        }
        return -1;

    }

    public void addUser2(String user2Name, String passWord){
        user2 = new PokemonUser(user2Name,passWord);
    }

    public void trade( String card1, String card2){
        PokemonCard tradeCard;
        tradeCard = user1.getCard(card1);
        user1.removeCard(card1);
        user2.addCard(tradeCard);
        tradeCard = user2.getCard(card2);
        user2.removeCard(card2);
        user1.addCard(tradeCard);
    }
    public void printCollection(){

        for(String key: storeCollection.keySet()){
            System.out.println(storeCollection.get(key));
        }
    }
}

