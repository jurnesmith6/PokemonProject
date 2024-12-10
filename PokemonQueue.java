

public class PokemonQueue {
    private PokemonCard[] pokemonQueue;
    int alloSize;
    int elements;

    public PokemonQueue(){
        elements = 0;
        alloSize = 3;
        pokemonQueue = new PokemonCard[alloSize];
    }
    public PokemonCard enqueue(PokemonCard card){
        PokemonCard dCard = null;
        if(elements == alloSize){
            dCard = deqeue();
        }
        pokemonQueue[elements] = card;
        elements++;
        return dCard;
    }

    public PokemonCard deqeue(){
        PokemonCard card = pokemonQueue[0];
        for(int i = 0; i < elements - 1;++i){
            pokemonQueue[i] = pokemonQueue[i+1];
        }
        --elements;
        return card;
    }

    public PokemonCard peek(int i){
        if(i>= alloSize){
            return null;
        }
        return pokemonQueue[i];
    }

    public int getElements(){
        return elements;
    }

    public void print() {
        System.out.print("current queue: ");
        System.out.print("[");

        for (int i=0; i < pokemonQueue.length; ++i) {
            if(pokemonQueue[i] != null)
                System.out.print(pokemonQueue[i].getName() + ",");
            else
                System.out.print("Empty, ");
        }
        System.out.println("\b]");
    }

}
