package it.unibo.inner.api;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.prefs.PreferenceChangeListener;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableClass<T> implements IterableWithPolicy<T>{
    private final List<T> elements;
    private Predicate<T> predicate;
    private int counter;

    public IterableClass(final T[] elements) {
        this.elements = List.of(elements);
    }

    public IterableClass(final T[] elements,  Predicate<T> predicate) {
        this.elements = List.of(elements);
        this.predicate = predicate;
    }

    public Iterator<T> iterator(){
        return new MyIterator();
    }

    public void setIterationPolicy(Predicate filter){

    }

    public int getCounter(){
        return this.counter;
    }

    public void incrementCounter(){
        this.counter++;
    }

    public T getElement(int position){
        return this.elements.get(position);
    }

    public int elementsLength(){
        return this.elements.size();
    }
    

    class MyIterator implements Iterator<T>{

        public boolean hasNext() {
            return getCounter() < elementsLength()? true: false;
        }

        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException("Out of bounds");
            }
            T element = getElement(getCounter());
            incrementCounter();
            return element;               
        }


    }
}

