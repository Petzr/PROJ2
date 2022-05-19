package com.proj2.model.abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class AbstractRepository<T extends AbstractEntity> {

    private final List<T> EntityCollection = new ArrayList<>();

    public void save(T entity) {
        EntityCollection.add(entity);
    }

    public Optional<T> getById(UUID id){
        return EntityCollection.stream().filter(entity -> entity.matchId(id)).findFirst();
    }
}