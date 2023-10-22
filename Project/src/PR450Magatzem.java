import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PR450Magatzem {
    private ArrayList<PR450Producte> productes = new ArrayList<PR450Producte>();
    private int capacitat = 10;
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);


    public int getCapacitat() {
        return capacitat;
    }

    public PR450Producte getProductes(Integer id){
        return productes.get(id);
    }

    public void addProducte(PR450Producte producte) {
        if (productes.size() < capacitat) {
            productes.add(producte);
            capacitat = capacitat - 1;
            llistaObservers.firePropertyChange("magatzemAdd", null, producte);
        }
    }

    public void removeProducte(int id) {
        PR450Producte producteToRemove = null;
        for (PR450Producte producte : productes) {
            if (producte.getId() == id) {
                producteToRemove = producte;
                productes.remove(producte);
                capacitat = capacitat + 1;
                llistaObservers.firePropertyChange("magatzemRemove", producteToRemove, null);
                llistaObservers.firePropertyChange("magatzemEntrega", producteToRemove, null);

                llistaObservers.firePropertyChange("entreguesAdd", null, producteToRemove);

                break;
            }
        }
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.removePropertyChangeListener(name, listener);
    }

    @Override
    public String toString(){
        String cadena  = "Productes al magatzem: [ ";
        for (PR450Producte producte : productes){
            cadena = cadena + producte.getId() +  ": " + producte.getNom() + ", ";
        }
        cadena = cadena.substring(0, cadena.length()-2) + " ]";
        return cadena;
    }
    
}
