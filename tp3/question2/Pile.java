package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;
    boolean estEgale;

    public Pile(int taille) {
        if (taille <= 0)
            taille = PileI.CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if(o==null) return;
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        
        if (estVide())
            throw new PileVideException();
       
        return zone[--ptr];
    }

    public Object sommet() throws PileVideException {
              if (estVide())
                    throw new PileVideException();  
             return this.zone[ptr-1];
    }

    public int capacite() 
    {
        return this.zone.length;
    }

    public int taille() {
        
        return this.ptr;
    }

    public boolean estVide() {
        return this.ptr == 0;
    }

    public boolean estPleine() {
        return this.ptr == zone.length;
    }

    public boolean equals(Object o) {
        if(o== this) return true;
        PileI  p=(PileI) this;
        PileI p1=new Pile();
        PileI p2=new Pile();
        PileI pile=(PileI)o;
        
        try{
            boolean c=true;
            for(int i=0;i<taille();i++)
            {
                Object obj1=p.depiler();
                Object obj2=pile.depiler();
                
                if(!obj1.equals(obj2)) c=false;
                p1.empiler(obj1);
                p2.empiler(obj2);
            }  
                
                
            for(int j=0;j<p1.taille();j++)
            {
                this.empiler(p1.depiler());
                pile.empiler(p2.depiler());}
                return c;
            }catch(Exception e){}
            return false;
            }
                
             
        
        
        
        
        
    


    // fonction fournie
    public int hashCode() 
    {
        return toString().hashCode();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    
}