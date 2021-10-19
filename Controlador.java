/***************************************************
Controlador.java
Autor: Diego Morales
Fecha: 28/09/2021

Driver program. Instancia la vista y el modelo,
y los comunica de acuerdo con las elecciones del
usuario.
***************************************************/
import java.util.Random;
import java.util.ArrayList;
public class Controlador{
	public static void main(String[] args){
    int opcion=0;
		int combatiente=0;
		int accion=0;
		int enemigoa=0; 
		int accionenemigo=0;
		int jefe=0;
		int vida=0;
		int vidaGuerre=0;
		int vidaExplo=0;
        int vidaCaza=0;
		String tipo_combatiente="";
		Random r = new Random();
        vista v = new vista();
		guerrero guerre = new guerrero(0,0,"",0);
		explorador explo = new explorador(0,0,"",0);
        cazador caza = new cazador(0,0,"",0);
		esqueleto esque = new esqueleto(0, 0, "");
		demonio demon = new demonio(0, 0, "");
		zombie zomb = new zombie(0, 0, "");
        raidboss rboss = new raidboss(0, 0, ""); 
		acompanante a= new acompanante(0, 0, ""); 
    v.bienvenida();
    while (opcion != 5){
      opcion = v.menuOpciones();
      switch(opcion){
        case 1:
/**************************Combate***********************************/
				combatiente=v.elejirCombatiente();
				switch(combatiente){
					case 1:
					tipo_combatiente="Guerrero";
					guerre = new guerrero(80,15,"",5);
					vida=guerre.getVida();
					v.Eleccion(tipo_combatiente);
					break;
					case 2:
					tipo_combatiente="Explorador";
					explo = new explorador(70,10,"",10);
					v.Eleccion(tipo_combatiente);
					vida=explo.getVida();
					break;
                    case 3:
					tipo_combatiente="Cazador";
					caza = new cazador(65,20,"",5);
					v.Eleccion(tipo_combatiente);
					vida=caza.getVida();
					break;
				}
                    int acompanantes_boss=r.nextInt(3);
                    String nombre=""; 
                    acompanantes_boss+=1;
                    switch (acompanantes_boss){
                        case 1: 
                        rboss = new raidboss(100, 30, "Mundus: El devorador de mundos"); 
                        esque = new esqueleto (20, 10, "Aumentar vida");
                        nombre=rboss.getNombre(); 
                        v.Enemigosgenerados(nombre, 1);
                        break;
                        case 2: 
                        rboss = new raidboss(70, 30, "Nemesis: El temible"); 
                        demon = new demonio (25, 20, "Aumentar ataque");
					    zomb = new zombie (30, 25, "Envenenamiento");
                        nombre = rboss.getNombre();
                        v.Enemigosgenerados(nombre, 2);
                        break;
                    }
                    
					while(accion!=4){
						vidaGuerre=guerre.getVida();
						vidaExplo=explo.getVida();
                        vidaCaza=caza.getVida();
						int venemigo;
						v.Turnojugador();
						accion=v.menuBatalla();
						switch(accion){
							case 1:
                            if(acompanantes_boss==1){
                                enemigoa = v.elejirEnemigoAtaque(nombre, 1);
								switch(enemigoa){
									case 1:
									if (tipo_combatiente=="Guerrero") {
										guerre.atacar(rboss);
										venemigo=rboss.getVida();
										if(venemigo>=0){
										v.Ataque(venemigo);
										}else{
											v.Ataque(0);
											rboss = new raidboss(0, 0, "Mundus: El devorador de mundos"); 
										}
									}else if(tipo_combatiente=="Explorador"){
										explo.atacar(rboss);
										venemigo=rboss.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												rboss = new raidboss(0, 0, "Mundus: El devorador de mundos"); 
											}
									}else{
										caza.atacar(rboss);
										venemigo=rboss.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												rboss = new raidboss(0, 0, "Mundus: El devorador de mundos"); 
											}
									}
									break;
									case 2:
									if (tipo_combatiente=="Guerrero") {
										guerre.atacar(esque);
										venemigo=esque.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												esque = new esqueleto (0, 0, "Aumentar vida");
											}
									}else if(tipo_combatiente=="Explorador"){
										explo.atacar(esque);
										venemigo=esque.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												esque = new esqueleto (0, 0, "Aumentar vida");
											}
									}else{
										caza.atacar(esque);
										venemigo=esque.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												esque = new esqueleto (0, 0, "Aumentar vida");
											}
									}
									break;
								}
                            }else{
                                enemigoa = v.elejirEnemigoAtaque(nombre, 2);
								switch(enemigoa){
									case 1:
									if (tipo_combatiente=="Guerrero") {
										guerre.atacar(rboss);
										venemigo=rboss.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												rboss = new raidboss(0, 0, "Nemesis: El temible"); 
											}
									}else if(tipo_combatiente=="Explorador"){
										explo.atacar(rboss);
										venemigo=rboss.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												rboss = new raidboss(0, 0, "Nemesis: El temible"); 
											}
									}else{
										caza.atacar(rboss);
										venemigo=rboss.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												rboss = new raidboss(0, 0, "Nemesis: El temible"); 
											}
									}
									break;
									case 2:
									if (tipo_combatiente=="Guerrero") {
										guerre.atacar(demon);
										venemigo=demon.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												demon = new demonio (0, 0, "Aumentar ataque");
											}
									}else if(tipo_combatiente=="Explorador"){
										explo.atacar(demon);
										venemigo=demon.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												demon = new demonio (0, 0, "Aumentar ataque");
											}
									}else{
										caza.atacar(demon);
										venemigo=demon.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												demon = new demonio (0, 0, "Aumentar ataque");
											}
									}
									break;
									case 3:
									if (tipo_combatiente=="Guerrero") {
										guerre.atacar(zomb);
										venemigo=zomb.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												zomb = new zombie (0, 0, "Envenenamiento");
											}
									}else if(tipo_combatiente=="Explorador"){
										explo.atacar(zomb);
										venemigo=zomb.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												zomb = new zombie (0, 0, "Envenenamiento");
											}
									}else{
										caza.atacar(zomb);
										venemigo=zomb.getVida();
										if(venemigo>=0){
											v.Ataque(venemigo);
											}else{
												v.Ataque(0);
												zomb = new zombie (0, 0, "Envenenamiento");
											}
									}
									break;
								}
                            }

							break;
							case 2:
							v.items();
							break;
							case 3:
							break;
							case 4:
							v.Final();
							v.Huida();
							break;
							default:
							v.opcionInvalida();
							break;
						}
						v.Turnoenemigo();
						int vjugador;
						String habilidad;
						int rival=r.nextInt(3);
						rival+=1;
						int n=r.nextInt(2);
						n+=1;
						if(enemigoa==1){
						switch(rival){
							case 1:
							switch(n){
									case 1:
											if (tipo_combatiente=="Guerrero") {
												rboss.atacar(guerre);
												vjugador=guerre.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}else if(tipo_combatiente=="Explorador"){
												rboss.atacar(explo);
												vjugador=explo.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}else{
												rboss.atacar(caza);
												vjugador=explo.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}
											break;
									case 2:
											int habilidadboss=r.nextInt(3);
											habilidadboss+=1; 
											if (habilidadboss==1) {
												a=rboss.colanar(esque); 
												v.Clon();
										}else if(habilidadboss==2){
											rboss.variar(a, "Aumentar ataque");
											v.variar();
										}else{
											v.liberar();
										}
											break;
								}
								break;
							case 2:
								switch(n){
									case 1:
											if (tipo_combatiente=="Guerrero") {
												esque.atacar(guerre);
												vjugador=guerre.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}else if(tipo_combatiente=="Explorador"){
												esque.atacar(explo);
												vjugador=explo.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}else{
												esque.atacar(caza);
												vjugador=caza.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}
											break;
									case 2:
											if (tipo_combatiente=="Guerrero") {
											habilidad=esque.getHabilidad();
											esque.usarHabilidad(habilidad, guerre);
										}else if(tipo_combatiente=="Explorador"){
											habilidad=esque.getHabilidad();
											esque.usarHabilidad(habilidad, explo);
										}else{
											habilidad=esque.getHabilidad();
											esque.usarHabilidad(habilidad, caza);
										}
											break;


										}
							break;
							
						}
					}else{
						switch(rival){
							case 1:
							switch(n){
									case 1:
											if (tipo_combatiente=="Guerrero") {
												rboss.atacar(guerre);
												vjugador=guerre.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}else if(tipo_combatiente=="Explorador"){
												rboss.atacar(explo);
												vjugador=explo.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}else{
												rboss.atacar(caza);
												vjugador=caza.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}
											break;
									case 2:
											int habilidadboss=r.nextInt(3);
											habilidadboss+=1; 
											if (habilidadboss==1) {
												a=rboss.colanar(caza); 
												v.Clon();
										}else if(habilidadboss==2){
											rboss.variar(a, "Aumentar ataque");
											v.variar();
										}else{
											v.liberar();
										}
											break;
								}
								break;
							case 2:
								switch(n){
									case 1:
											if (tipo_combatiente=="Guerrero") {
												demon.atacar(guerre);
												vjugador=guerre.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}else if(tipo_combatiente=="Explorador"){
												demon.atacar(explo);
												vjugador=explo.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}else{
												demon.atacar(caza);
												vjugador=caza.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}
											break;
									case 2:
											if (tipo_combatiente=="Guerrero") {
											habilidad=demon.getHabilidad();
											demon.usarHabilidad(habilidad, guerre);
										}else if(tipo_combatiente=="Explorador"){
											habilidad=demon.getHabilidad();
											demon.usarHabilidad(habilidad, explo);
										}else{
											habilidad=demon.getHabilidad();
											demon.usarHabilidad(habilidad, caza);
										}
											break;


										}
							break;
							case 3:
								switch(n){
									case 1:
											if (tipo_combatiente=="Guerrero") {
												zomb.atacar(guerre);
												vjugador=guerre.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}else if(tipo_combatiente=="Explorador"){
												zomb.atacar(explo);
												vjugador=explo.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}else{
												zomb.atacar(caza);
												vjugador=caza.getVida();
												if(vjugador>=0){
													v.Atacado(vjugador);
												}else{
													v.Atacado(0);
													vjugador=0; 
													v.Perder();
													v.Final();
													break; 
												}
											}
									break;
									case 2:
										if (tipo_combatiente=="Guerrero") {
										habilidad=zomb.getHabilidad();
										zomb.usarHabilidad(habilidad, guerre);
									}else if(tipo_combatiente=="Explorador"){
										habilidad=zomb.getHabilidad();
										zomb.usarHabilidad(habilidad, explo);
									}else{
										habilidad=zomb.getHabilidad();
										zomb.usarHabilidad(habilidad, caza);
									}
									break;
								}
							break;
						}

					}
					
			}
		

        break;
/**************************Combate***********************************/
        case 2:
				v.TiposCombatientes();
        break;
        case 3:
				v.TiposEnemigos();
        break;
        case 4:
				v.TiposItems();
        break;
        case 5:
        v.despedida();
        break;
        default:
        v.opcionInvalida();
        break;
      }
    }
  	
	}

}
