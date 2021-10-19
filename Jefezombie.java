/******************************************************************
Jefezombie.java
Autor: Diego Morales
Última modificación: 28/09/2021

Modelo de jugador para uso del Controlador.
******************************************************************/
public class Jefezombie extends zombie{
    vista v = new vista();
    private String habilidad1, habilidad2, nombre;
    /*Costructor de clase*/
    public Jefezombie(int v, int a, String h, String h1, String h2, String n) {
        super(v, a, h);
        habilidad1=h1;
        habilidad2=h2;
        nombre=n; 
    }
    /*Metodo para devolver el valor de habilidad1
      @return valor de habilidad1
      */
    public String getHabilidad1(){
      return habilidad1;
    }
    /*Metodo para devolver el valor de habilidad1
      @return valor de habilidad1
      */
    public String getHabilidad2(){
      return habilidad2;
    }
}