package modeloClases;

import java.util.Observable;

    //TODO: cambios de STATE de arena. Hay que definir cuales son, su comportamiento, y donde van. 

public class Arena{
    private String nombre;
    private boolean enCurso = false;
    
    public Arena(String nombre) {
        this.nombre = nombre;
        this.enCurso = false;
    }
    
    //Aclaracion: deje comentado los system.out.println para ver bien el funcionamiento de los hilos. Esa informacion es la que deberiamos de mostrar en la ui?
    public synchronized Entrenador inicia(Entrenador entrenadorA, Pokemon p1, boolean cartaA, Entrenador entrenadorB, Pokemon p2,boolean cartaB, int ataques){
        //mientras que la arena este ocupada, espero
        while(enCurso){
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        //se desocupo la arena, la pongo como ocupada y comienzo a ejecutar el ataque
        System.out.println("\nENTRANDO A LA ARENA "+this.nombre);
        this.enCurso = true;
        Entrenador ganadorEncuentro = null;
        int i = 0;
        while( i < ataques){
            i++;
            if (cartaA) {
                    entrenadorA.usarCarta(p2);
                    //System.out.println("\n-->El entrenador "+entrenadorA.getNombre()+" uso una carta");
                    cartaA=false;
            }
            p1.ataca(p2);
            //System.out.println(p2.getNombre() +":\n-Vida:" + p2.getVitalidad()+"  --  Escudo:"+p2.getEscudo());
            if (p2.getVitalidad()<=0) {
                    //System.out.println("\n"+p2.getNombre()+" ha muerto");
                    entrenadorB.eliminaPokemon(p2);
                    actualizaEstado(entrenadorA, p1);;    
                    ganadorEncuentro = entrenadorA;
                    break;
            }
            else {
                    if (cartaB) {
                            entrenadorA.usarCarta(p1);
                            //System.out.println("\n-->El entrenador "+entrenadorB.getNombre()+" uso una carta");
                            cartaB=false;
                    }
                    p2.ataca(p1);
                   // System.out.println(p1.getNombre() +":\n-Vida:" + p1.getVitalidad()+"  --  Escudo:"+p1.getEscudo());
                    if (p1.getVitalidad() <= 0) {
                            //System.out.println("\n"+p1.getNombre()+" ha muerto");
                            entrenadorA.eliminaPokemon(p1);
                            actualizaEstado(entrenadorB, p2);
                            ganadorEncuentro= entrenadorB;
                            break;
                    }
            }
        }
        
        if (ganadorEncuentro == null) {
                if (p1.comparaEstado(p2)== 1) {
                        p2.pierdeBatalla();
                        actualizaEstado(entrenadorA, p1);
                        ganadorEncuentro = entrenadorA;
                }
                else {
                    p1.pierdeBatalla();
                    actualizaEstado(entrenadorB, p2);
                    ganadorEncuentro = entrenadorB;
                }               
        }
        notifyAll();
        return ganadorEncuentro;
        //TODO: hay que ver que hacer con los resultados, creo que esta parte seria la de serializacion.
        //listaResultados.add(new Reporte(entrenadorA,p1,entrenadorB,p2,ganador));
    }
    
    public synchronized void termina(){
        //mientras que la arena no este ocupada, espero
        while(!enCurso){
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        //la arena esta ocupada por mi, termino mi ejecucion, y la libero.
        this.enCurso = false;
        System.out.println("\nSaliendo A LA ARENA "+this.nombre);
        notifyAll();
    }
    
    //Se cambio el metodo desde batalla para arena, por el codigo que se encuentra mas arriba. 
    public void actualizaEstado(Entrenador entrenador, Pokemon pokemon){
        pokemon.ganaBatalla();
        pokemon.actualizaClasificacion();
        entrenador.actualizaClasificacion();
        entrenador.obtienePremio();
    }
}