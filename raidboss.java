/******************************************************************
zombie.java
Autor: Diego Morales
Última modificación: 28/09/2021

Modelo de jugador para uso del Controlador.
******************************************************************/
public class raidboss extends combatiente{
    vista v = new vista();
    String nombre; 
      /*Costructor de clase*/
    public raidboss(int v, int a, String n){
        super(v, a, "");
        nombre=n; 
    }

    public String getNombre(){
        return nombre; 
    }
   /*Metodo para usar habilidad    */
    public acompanante colanar(combatiente c){
        int vida, ataque; 
        String habilidad; 
        vida=c.getVida(); 
        ataque=c.getAtaque(); 
        habilidad=c.getHabilidad(); 
        acompanante a = new acompanante(vida, ataque, habilidad); 
        return a; 
    }

    /*Metodo para usar habilidad
    */
    public void variar(acompanante a, String h){
        int vida, ataque; 
        String habilidad; 
        vida=a.getVida(); 
        ataque=a.getAtaque(); 
        habilidad=h;  
        a = new acompanante(vida, ataque, habilidad); 
    }

    /*Metodo para usar habilidad
    */
    public void liberar(){

    }
    /*Metodo para atacar al enemigo
    */
    public void atacar(combatiente c){
        int vjugador=c.getVida();
        vjugador=vjugador-ataque;
        c.setVida(vjugador);
    }
  }