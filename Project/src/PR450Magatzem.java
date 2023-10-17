import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PR450Magatzem {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);

    private ArrayList<PR450Producte> productes = new ArrayList<PR450Producte>();
    private int capacitat = 10;

    PR450Magatzem(ArrayList<PR450Producte> productes, int capacitat){
        
    }


    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.removePropertyChangeListener(name, listener);
    }
    
}
