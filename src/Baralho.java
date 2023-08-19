import java.util.Random;

public class Baralho {
    private Deck cartas;

    public Baralho(){
        cartas = new Deck();
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
    private void sortearOrdem(){
        Random random = new Random();
        for (int i = 0; i < cartas.qtdadeCartas(); i++){
            int j = random.nextInt(cartas.qtdadeCartas());
            Carta temp = this.cartas.cartas[i];
            cartas.cartas[i] = cartas.cartas[j];
            cartas.cartas[j] = temp;
        }
}
}