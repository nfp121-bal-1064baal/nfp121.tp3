package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if (taille <= 0)
            taille = PileI.CAPACITE_PAR_DEFAUT;
        this.stk =new Stack<T>();  
        this.capacite=taille;
    }

    public Pile2(){
        this(PileI.CAPACITE_PAR_DEFAUT);
    }
    
      public int taille() {
        return this.stk.size();
    }
    

    public void empiler(T o) throws PilePleineException{
        if(o==null) return;
        if(estPleine()){
            throw new PilePleineException();
        }
        this.stk.push(o);

    }

    public T depiler() throws PileVideException{
        if (estVide())
            throw new PileVideException();
       
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
                     if (estVide())
                    throw new PileVideException();  
                    return this.stk.peek();
    }
    
    
    public int capacite() 
    {
        return this.capacite;
    }
        public boolean estVide() {
        return this.stk.empty();
    }

    public boolean estPleine() {
        return this.stk.size() ==this.capacite;
    }

    public boolean equals(Object o) {
        if(o== this) return true;
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
                {this.empiler((T)p1.depiler());
                   pile.empiler((T)p2.depiler());}
                    return c;
                }catch(Exception e){}
                return false;
                }


   
    public int hashCode() 
    {
        return toString().hashCode();
    }

    public String toString() {
                 String s = "[";
        for (int i = this.stk.size() - 1; i >= 0; i--) {
           s+= this.stk.get(i).toString();
           if(i >0){
               s+= ", ";
           }       
        }
        return s + "]"; 
    }
    
} 


  