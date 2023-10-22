import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PR450Entregues {
    private ArrayList<PR450Producte> productes = new ArrayList<PR450Producte>();   
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);

    public PR450Producte getProductes(Integer id){
        return productes.get(id);
    }

    public void addProducte(PR450Producte producte) {
        productes.add(producte);
        llistaObservers.firePropertyChange("entreguesAdd", null, producte);
    }

    public void removeProducte(int id) {
        PR450Producte producteToRemove = null;
        for (PR450Producte producte : productes) {
            if (producte.getId() == id) {
                producteToRemove = producte;
                productes.remove(producte);
                llistaObservers.firePropertyChange("entreguesRemove", producteToRemove, null);
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
        String cadena  = "Productes per entregar: [ ";
        for (PR450Producte producte : productes){
            cadena = cadena + producte.getId() +  ": " + producte.getNom() + ", ";
        }
        cadena = cadena.substring(0, cadena.length()-2) + " ]";
        
        return cadena;
    }
}
