package LDE;

public class LDECircular <T extends Comparable<T>> {
    private LDENode<T> prim;
    private LDENode<T> ult;
    private int qtd;

    public boolean isEmpty() {
        if (this.qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void inserirNoInicio (T valor) {
        LDENode<T> novo = new LDENode(valor);
        if (this.isEmpty() == true) {
            this.prim = novo;
            this.ult = novo;
            this.qtd++;
            this.prim.setAnt(this.ult);
            this.ult.setProx(this.prim);
        } else {
            novo.setProx(this.prim);
            this.prim.setAnt(novo);
            this.prim = novo;
            this.qtd++;
            this.prim.setAnt(this.ult);
            this.ult.setProx(this.prim);
        }
    }

    public void inserirNoFinal (T valor) {
        LDENode<T> novo = new LDENode(valor);
        if (this.isEmpty() == true) {
            this.prim = novo;
            this.ult = novo;
            this.qtd++;
            this.prim.setAnt(this.ult);
            this.ult.setProx(this.prim);
        } else {
            novo.setAnt(this.ult);
            this.ult.setProx(novo);
            this.ult = novo;
            this.qtd++;
            this.prim.setAnt(this.ult);
            this.ult.setProx(this.prim);
        }
    }

    public void exibirTodos() {
        LDENode<T> aux;
        if (this.isEmpty() == true) {
            System.out.println("Lista Vazia!");
        } else {
            aux = this.prim;
            do {
                System.out.print(aux.getInfo() + " ");
                aux = aux.getProx();
            } while (aux != this.prim);
        }
        System.out.println(" ");
    }

    private LDENode<T> buscar (T valor) { // Busca o nó na lista
        LDENode<T> aux;
        if (this.isEmpty() == true) {
            return null;
        } else {
            aux = this.prim;
            while (aux != null) {
                if (aux.getInfo().compareTo(valor) == 0) {
                    return aux;
                } else {
                    aux = aux.getProx();
                }
            }
            return null;
        }
    }

    public void removerPrimeiro(T valor) {
        if (this.isEmpty() == true) {
            System.out.println("Lista Vazia!");
        } else if (this.qtd == 1) {
            this.prim = null;
            this.ult = null;
            this.qtd = 0;
        } else {
            this.prim = this.prim.getProx();
            this.qtd--;
            this.prim.setAnt(this.ult);
            this.ult.setProx(this.prim);
        }
    }

    public void removerUltimo(T valor) {
        if (this.isEmpty() == true) {
            System.out.println("Lista Vazia!");
        } else if (this.qtd == 1) {
            this.prim = null;
            this.ult = null;
            this.qtd = 0;
        } else {
            this.ult = this.ult.getAnt();
            this.qtd--;
            this.prim.setAnt(this.ult);
            this.ult.setProx(this.prim);
        }
    }

    public void remover(T valor) { // Remove um valor específico
        LDENode<T> retorno = this.buscar(valor);
        LDENode<T> anterior, proximo;
        if (retorno == null) {
            System.out.println("valor não encontrado!");
        } else if (this.qtd == 1) {
            this.prim = null;
            this.ult = null;
            this.qtd = 0;
        } else if (retorno == this.prim) { // remove o primeiro
            this.prim = this.prim.getProx();
            this.qtd--;
            this.prim.setAnt(this.ult);
            this.ult.setProx(this.prim);
        } else if (retorno == this.ult) { // remove o ultimo
            this.ult = this.ult.getAnt();
            this.qtd--;
            this.prim.setAnt(this.ult);
            this.ult.setProx(this.prim);
        } else { // remove no "meio"
            anterior = retorno.getAnt();
            proximo = retorno.getProx();
            anterior.setProx(proximo);
            proximo.setAnt(anterior);
            this.qtd--;
        }
    }
}