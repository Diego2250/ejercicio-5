/******************************************************************
combatiente.java
Autor: Diego Morales
Última modificación: 28/09/2021

Modelo de enemigo para uso del Controlador.
******************************************************************/
public class combatiente{
    protected String habilidad;
    protected int vida;
    protected int ataque;
    vista vista = new vista();
      /*Costructor de clase*/
    public combatiente(int v, int a, String h){
      vida=v;
      ataque=a;
      habilidad=h;
    }
    /*Metodo para cambiar el valor de vida
    */
    public void setVida(int newVida){
      this.vida=newVida;
    }
    /*Metodo para cambiar el valor de ataque
    */
    public void setAtaque(int newAtaque){
      this.ataque=newAtaque;
    }
  
    public int getVida(){
      return vida;
    }
    /*Metodo para devolver el valor de ataque
      @return valor de ataque
      */
    public int getAtaque(){
      return ataque;
    }
    /*Metodo para devolver el valor de habilidad
      @return valor de habilidad
      */
    public String getHabilidad(){
      return habilidad;
    }
  
  }
  