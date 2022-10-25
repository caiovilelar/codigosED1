package LDE;

public class LDECrescente<T extends Comparable<T>> {
    private LDENode<T> prim;
    private LDENode<T> ult;
    private int qtd;
    private int limite;

    public LDECrescente(int tam) {
        this.limite = tam;
    }

    public boolean isEmpty() { //Verifica se a lista tá vazia
        if (this.qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void inserir(T valor) { //Insere um novo nó na lista
        LDENode<T> novo = new LDENode(valor);
        LDENode<T> aux, anterior;
        if (this.isEmpty() == true) { //Lista vazia?
            this.prim = novo;
            this.ult = novo;
            this.qtd++;
        } else if (valor.compareTo(this.prim.getInfo()) < 0 ){ // Lista com um nó. Insere no início
            novo.setProx(this.prim);
            this.prim.setAnt(novo);
            this.prim = novo;
            this.qtd++;
        } else if (valor.compareTo(this.prim.getInfo()) == 0 ){ // Verifica repetição
            System.out.println("Valor Repetido. Inserção não efetuada.");
        } else if (valor.compareTo(this.ult.getInfo()) > 0) { // Lista com mais de um nó. Insere no final
            this.ult.setProx(novo);
            novo.setAnt(this.ult);
            this.ult = novo;
            this.qtd++;
        } else if (valor.compareTo(this.ult.getInfo()) == 0 ){ // Verifica repetição
            System.out.println("Valor Repetido. Inserção não efetuada.");
        } else { // Lista com mais de um nó. Insere no meio
            aux = this.prim.getProx();
            while (true) {
                if (valor.compareTo(aux.getInfo()) == 0) { // Verifica repetição
                    System.out.println("Valor repetido. Inserção não efetuada.");
                    break;
                } else if (valor.compareTo(aux.getInfo()) < 0){ // Insere no meio da lista
                    anterior = aux.getAnt();
                    anterior.setProx(novo);
                    aux.setAnt(novo);
                    novo.setProx(aux);
                    novo.setAnt(anterior);
                    this.qtd++;
                    break;
                } else {
                    aux = aux.getProx();
                }

            }
        }
    }
}