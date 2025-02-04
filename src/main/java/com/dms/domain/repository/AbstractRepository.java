package com.dms.domain.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractRepository<T> {

    private final List<T> elements = new ArrayList<>();

    public void delete(T entity) {
        final Iterator<T> iterator = elements.iterator();
        while (iterator.hasNext()) {
            final T next = iterator.next();
            if (next.equals(entity)) {
                iterator.remove();
                break;
            }
        }
    }

    public List<T> findAll() {
        return this.elements;
    }

    public T save(T entity) {
        this.elements.add(entity);
        return entity;
    }

    public T findOne(String id) {
        return this.elements.stream().filter(el -> el.equals(id)).findFirst().get();
    }
}