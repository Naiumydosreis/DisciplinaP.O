import java.util.Random;
import java.util.Scanner;

public class Baralho {
    private Deck cartas;

    public Baralho(){
        cartas = new Deck();
        Naipe[] naipes =  Naipe.values(); 
        for(Naipe naipe:Naipe.values()){
            for(Valor valor:Valor.values()){
                Carta carta = new Carta(naipe,valor);
                cartas.insereEmbaixo(carta);
            }
        }
        sortearOrdem();
    }

    public int qtdadeCartas(){
        return cartas.qtdadeCartas();
    }

    public boolean vazio(){ 
        return cartas.vazio();
    }

    public Carta retiraDeCima(){
        return cartas.retiraDeCima();
    }

    public void embaralha(){
        cartas.embaralha();
    }
    public void incorporarCartas(Baralho outroBaralho){
        while (!outroBaralho.vazio()){
            cartas.insereEmbaixo(outroBaralho.retiraDeCima());
        }
    }
    private void sortearOrdem(){
        Random random = new Random();
        for (int i = 0; i < cartas.qtdadeCartas(); i++){
            int j = random.nextInt(cartas.qtdadeCartas());
            Carta temp = this.cartas.cartas[i];
            this.cartas.cartas[i] = this.cartas.cartas[j];
            this.cartas.cartas[j] = temp;
        }
    }
        public static void main(String[] args) throws Exception {
            Scanner teclado = new Scanner(System.in);
    
            System.out.print("Nome do Jogador 1: ");
            String nomeJogador1 = teclado.nextLine();
    
            System.out.print("Nome do Jogador 2: ");
            String nomeJogador2 = teclado.nextLine();
    
            Baralho baralho = new Baralho();
            baralho.embaralha();
}
}

