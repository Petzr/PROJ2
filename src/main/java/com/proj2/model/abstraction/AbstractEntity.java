package com.proj2.model.abstraction;

import java.util.UUID;

public abstract class AbstractEntity {
    private final UUID ID = UUID.randomUUID();
    public boolean matchId(UUID id) {
        return ID.equals(id);
    }
}