import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Array;

public class Main {
   public static void main (String[] args) {


       PR450Producte p0 = new PR450Producte(0, "Llibre");
       PR450Producte p1 = new PR450Producte(1, "Boli");
       PR450Producte p2 = new PR450Producte(2, "Rotulador");
       PR450Producte p3 = new PR450Producte(3, "Carpeta");
       PR450Producte p4 = new PR450Producte(4, "Motxilla");


       PR450Magatzem magatzem = new PR450Magatzem();
       PR450Entregues entregues = new PR450Entregues();


       // Aquí afegir els property listeners adequats

        PropertyChangeListener l0 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("Producte ha canviat la id de '%s' a '%s'\n",
                                  evt.getOldValue(), evt.getNewValue());                
            }
        };
        p0.addPropertyChangeListener("id", l0);


        PropertyChangeListener l1 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("Producte ha canviat el nom de '%s' a '%s'\n",
                                  evt.getOldValue(), evt.getNewValue());                
            }
        };
        p0.addPropertyChangeListener("nom", l1);
        p1.addPropertyChangeListener("nom", l1);


        PropertyChangeListener l2 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S'ha afegit el producte amb id '%s' al magatzem, capacitat '%s'\n",
                                  evt.getNewValue(), magatzem.getCapacitat());                
            }
        };
        magatzem.addPropertyChangeListener("magatzemAdd", l2);


        PropertyChangeListener l3 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S'ha esborat el producte amb id '%s' al magatzem, capacitat '%s'\n",
                                  evt.getOldValue(), magatzem.getCapacitat());         
            }
        };
        magatzem.addPropertyChangeListener("magatzemRemove", l3);
        

        PropertyChangeListener l4 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S’ha afegit el producte amb id '%s'  al la llista d’entregues\n",
                                  evt.getNewValue());     
                if (evt.getNewValue() instanceof PR450Producte) {
                    entregues.addProducte((PR450Producte) evt.getNewValue());
                }  
                else {
                    System.out.println("Jaja");
                }
            }
        };
        magatzem.addPropertyChangeListener("entreguesAdd", l4);;
    

        PropertyChangeListener l5 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S’ha entregat el producte amb id '%s'\n",
                                  evt.getOldValue());                
            }
        };
        entregues.addPropertyChangeListener("entreguesRemove", l5);;



        

       p0.setId(5);
       p0.setNom("Llibreta");
       p1.setNom("Boli");


       magatzem.addProducte(p0);
       magatzem.addProducte(p1);
       magatzem.addProducte(p2);
       magatzem.addProducte(p3);
       magatzem.addProducte(p4);


       magatzem.removeProducte(2);
       magatzem.removeProducte(3);
       magatzem.removeProducte(4);

       entregues.removeProducte(2);
       entregues.removeProducte(3);


       System.out.println(magatzem);
       System.out.println(entregues);


   }
}
