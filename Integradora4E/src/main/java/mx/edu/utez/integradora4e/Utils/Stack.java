package mx.edu.utez.integradora4e.Utils;

public class Stack <T>{

    private T[] items;
    private int capacidad;
    private int tope;

    @SuppressWarnings("unchecked")
    Stack(int capacidad){
        this.capacidad=capacidad;
        this.tope=-1;
        this.items=(T[]) new Object[capacidad];
    }

    public void push(T item){
        if (isFull()) {
            System.out.println("El stack está lleno, ya no puedes agregar más elementos");
            return;
        }
        items[++tope] = item;
    }

    public T pop(){
        if (isEmpty()) {
            System.out.println("El stack está vacío");
        }
        return items[tope--];
    }

    public boolean isEmpty(){
        return (tope==-1);
    }
    public boolean isFull(){
        return tope == capacidad-1;
    }

    public T peek(){
        if (isEmpty()) {
            System.out.println("no hay nada");
        }
        return items[tope];
    }

}
