package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;
    private int taille;
    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        // prevoir le cas <=0
        if (taille <= 0)
            taille = PileI.CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<Object>();
        this.capacite=taille;
        this.taille=0;
    }

    // constructeur fourni
    public Pile2() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if(o==null) return;
        if (estPleine())
            throw new PilePleineException();
           this.stk.push(o);
           taille++;
    }

    public Object depiler() throws PileVideException {
        
        if (estVide())
            throw new PileVideException();
            taille--;
        return stk.pop();
    }

    public Object sommet() throws PileVideException {
        
        if (estVide())
                    throw new PileVideException(); 
        return stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        
        return stk.empty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        //return this.stk.size() == this.capacité;
        return taille==capacite();
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
        for (int i = taille-1; i >= 0; i--) {
            s+=stk.get(i).toString();
            if (i > 0)
                s+=", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        PileI p1=new Pile2();
        PileI p2=new Pile2();
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

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        return taille;
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
       return this.capacite;
    }

} // Pile2.java
