package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
    private int capacite;
    int taille;
    
    public Pile3() {
        this(PileI.CAPACITE_PAR_DEFAUT);
        
    }

    public Pile3(int taille) {
        if (taille <= 0)
            taille = PileI.CAPACITE_PAR_DEFAUT;
        this.v = new Vector<Object>();
        this.taille=0;
        capacite=taille;
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
           this.v.add(o);
           taille++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
            int s= v.lastIndexOf(sommet());
            taille--;
        return v.remove(s);
    }

    public Object sommet() throws PileVideException {
        
        if (estVide())
                    throw new PileVideException(); 
        return v.lastElement();
    }

    
    

    public int capacite() {
        
        return this.capacite;
    }

    public boolean estVide() {
        return v.isEmpty();
    }

    public boolean estPleine() {
        return capacite()==v.size();
    }

    public String toString() {
               String s = "[";
        for (int i = taille-1; i >= 0; i--) {
            s+=v.get(i).toString();
            if (i > 0)
                s+=", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {
       PileI p1=new Pile3();
        PileI p2=new Pile3();
        PileI pile=(PileI)o;
        try{
            boolean c;
            for(int i=0;i<taille();i++)
            {Object obj1=this.depiler();
             Object obj2=pile.depiler();
                if(!obj1.equals(obj2)) c=false;
                p1.empiler(obj1);
                p2.empiler(obj2);
                }
                c=true;
                for(int j=0;j<p1.taille();j++)
                {this.empiler(p1.depiler());
                   pile.empiler(p2.depiler());}
                    return c;
                }catch(Exception e){}
                return false;
                }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public int taille()
    {
        return taille;
    }
}
