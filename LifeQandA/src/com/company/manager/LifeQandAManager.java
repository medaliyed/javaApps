package com.company.manager;

import com.company.entities.QuestionAndAnswers;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class LifeQandAManager {
    //a Map would be a good choice but i tried to use many other feature in java just for my proper training
    private List<QuestionAndAnswers> lifeQandAList;

    public LifeQandAManager() {
        this.lifeQandAList = new ArrayList<>();
    }

    public int addLifeQandA(QuestionAndAnswers qa){
        this.lifeQandAList.add(qa);
        return this.lifeQandAList.size();
    }

    public int count(){
        return this.lifeQandAList.size();
    }

    public QuestionAndAnswers getLifeQandA(int index) {

        if(index <0 || index >= count() ){
            return null;
        }
        return this.lifeQandAList.get(index);
    }

    public Stream<QuestionAndAnswers> stream() {
        return lifeQandAList.stream();
    }

    public int size() {
        return lifeQandAList.size();
    }

    public boolean isEmpty() {
        return lifeQandAList.isEmpty();
    }

    public boolean contains(Object o) {
        return lifeQandAList.contains(o);
    }

    public Iterator<QuestionAndAnswers> iterator() {
        return lifeQandAList.iterator();
    }

    public Object[] toArray() {
        return lifeQandAList.toArray();
    }

    public <T> T[] toArray(T[] ts) {
        return lifeQandAList.toArray(ts);
    }

    public boolean add(QuestionAndAnswers questionAndAnswers) {
        return lifeQandAList.add(questionAndAnswers);
    }

    public boolean remove(Object o) {
        return lifeQandAList.remove(o);
    }

    public boolean containsAll(Collection<?> collection) {
        return lifeQandAList.containsAll(collection);
    }

    public boolean addAll(Collection<? extends QuestionAndAnswers> collection) {
        return lifeQandAList.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends QuestionAndAnswers> collection) {
        return lifeQandAList.addAll(i, collection);
    }

    public boolean removeAll(Collection<?> collection) {
        return lifeQandAList.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return lifeQandAList.retainAll(collection);
    }

    public void replaceAll(UnaryOperator<QuestionAndAnswers> unaryOperator) {
        lifeQandAList.replaceAll(unaryOperator);
    }

    public void sort(Comparator<? super QuestionAndAnswers> comparator) {
        lifeQandAList.sort(comparator);
    }

    public void clear() {
        lifeQandAList.clear();
    }

    @Override
    public boolean equals(Object o) {
        return lifeQandAList.equals(o);
    }

    @Override
    public int hashCode() {
        return lifeQandAList.hashCode();
    }

    public QuestionAndAnswers get(int i) {
        return lifeQandAList.get(i);
    }

    public QuestionAndAnswers set(int i, QuestionAndAnswers questionAndAnswers) {
        return lifeQandAList.set(i, questionAndAnswers);
    }

    public void add(int i, QuestionAndAnswers questionAndAnswers) {
        lifeQandAList.add(i, questionAndAnswers);
    }

    public QuestionAndAnswers remove(int i) {
        return lifeQandAList.remove(i);
    }

    public int indexOf(Object o) {
        return lifeQandAList.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return lifeQandAList.lastIndexOf(o);
    }

    public ListIterator<QuestionAndAnswers> listIterator() {
        return lifeQandAList.listIterator();
    }

    public ListIterator<QuestionAndAnswers> listIterator(int i) {
        return lifeQandAList.listIterator(i);
    }

    public List<QuestionAndAnswers> subList(int i, int i1) {
        return lifeQandAList.subList(i, i1);
    }

    public Spliterator<QuestionAndAnswers> spliterator() {
        return lifeQandAList.spliterator();
    }

    public boolean removeIf(Predicate<? super QuestionAndAnswers> predicate) {
        return lifeQandAList.removeIf(predicate);
    }

    public Stream<QuestionAndAnswers> parallelStream() {
        return lifeQandAList.parallelStream();
    }

    public void forEach(Consumer<? super QuestionAndAnswers> consumer) {
        lifeQandAList.forEach(consumer);
    }
}