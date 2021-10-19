/******************************************************************
zombie.java
Autor: Diego Morales
Última modificación: 28/09/2021

Modelo de jugador para uso del Controlador.
******************************************************************/
public class acompanante extends combatiente{
    vista v = new vista();
      /*Costructor de clase*/
    public acompanante(int v, int a, String h){
        super(v, a, "");
        habilidad=h; 
    }
    public void usarHabilidad(String habilidad, combatiente c){
        int v;
        switch(habilidad){
          case "Aumentar vida":
          v=getVida();
          v=v+10;
          this.setVida(v);
          vista.VidaAumentada(v);
          break;
          case "Aumentar ataque":
          int a=getAtaque();
          a=a+10;
          this.setAtaque(a);
          vista.AtaqueAumentado(a);
          break;
          case "Regeneracion":
          v=getVida();
          v=v+5;
          this.setVida(v);
          vista.VidaRegenerada(v);
          break;
          case "Envenenamiento":
          v=c.getVida();
          v=v-10;
          c.setVida(v);
          if (v<=0) {
            c.setVida(0);
            vista.Envenenado(0);
          }else{
            vista.Envenenado(v);
          }
          break;
        }
      }
    /*Metodo para atacar al enemigo
    */
    public void atacar(combatiente c){
        int vjugador=c.getVida();
        vjugador=vjugador-ataque;
        c.setVida(vjugador);
    }
  }