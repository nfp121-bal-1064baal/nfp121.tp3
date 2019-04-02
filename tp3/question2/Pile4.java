package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
        nombre=0;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if(o==null) return;
        if (estPleine())
            throw new PilePleineException();
        
           stk=new Maillon(o,stk);
           nombre++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        Maillon tmp = this.stk;
        this.stk = this.stk.suivant;
        nombre--;
        return tmp.element;

    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.element ;
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk == null; 
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
         return this.taille() >= capacite; 
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {

        String s = "[";
                Maillon tmp = stk;
        while (tmp != null){
            s = s + tmp.element().toString() ;
            tmp = tmp.suivant();
            if (tmp !=null) {s = s + ", ";}  
        }  

        return s + "]";
    }

    public boolean equals(Object o) {
       PileI p1=new Pile4();
        PileI p2=new Pile4();
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



    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

           

        
    public int taille() {
        return nombre;
    }
}