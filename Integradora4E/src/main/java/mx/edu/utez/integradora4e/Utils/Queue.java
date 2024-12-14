package mx.edu.utez.integradora4e.Utils;


    public class Queue<T> {


        int head;//indice cabeza
        int tail;//indice cola
        int itemsNumber;//Numero de elementos
        T[] items;//Items
        int arrLength;//Capacidad

        Queue(int tamaño){
            this.arrLength = tamaño;
            this.head = 0;
            this.tail = -1;
            this.itemsNumber = 0;
            this.items = (T[]) new Object[arrLength];
        }


        public boolean isFull(){
            return itemsNumber == arrLength;
        }

        public boolean isEmpty (){
            return itemsNumber == 0;
        }

        public void offer(T item){
            if(isFull()){
                System.out.println("Esta llena");
                return;
            }
            tail = (tail+1)%arrLength;
            items[tail] = item;
            itemsNumber++;
        }

        public T poll(){
            if(isEmpty()){
                System.out.println("Esta vacia");
                return null;
            }

            T item = items[head];
            head=(head+1)%arrLength;
            itemsNumber--;
            return item;
        }

        public T peak(){
            if(isEmpty()){
                System.out.println("No hay nada xd");
                return null;
            }
            return items[head];
        }

        public void rotar(int n){

            for(int i = 0; i<n; i++){
                poll();
            }
            for(int i= 0; i< (arrLength+1)-n; i++){
                offer(items[i]);
            }

        }

    }

