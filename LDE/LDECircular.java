package LDE;

public class LDECircular <T extends Comparable<T>> {
    private LDENode<T> first;
    private LDENode<T> last;
    private int qtd;

    public boolean isEmpty() {
        if (this.qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

    
}
