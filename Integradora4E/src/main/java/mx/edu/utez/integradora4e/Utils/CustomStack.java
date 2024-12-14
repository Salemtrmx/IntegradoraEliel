package mx.edu.utez.integradora4e.Utils;


public class CustomStack<T> {
    public  T[] items;
    public int capacidad;
    private int tope;

    public CustomStack(int capacidad){
        this.capacidad = capacidad;
        this.tope = -1;
        this.items = (T[]) new Object[capacidad];
    }

    public void push(T item){
        if (isFull()) {
            System.out.println("Esta lleno el stack");
            return;
        }
        items[++tope] = item;
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("esta vacio xd");
        }

        return items[tope--];
    }

    public T peak(){
        if(isEmpty()){
            System.out.println("No se puede regresar nada");
        }
        return items[tope];
    }

    public boolean isEmpty(){
        return tope == -1;
    }

    public boolean isFull(){
        return tope == capacidad -1;
    }

}

