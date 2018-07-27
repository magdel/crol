package com.ridelr.crol.generator;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface IdGenerator {

    @Nonnull
    Long generate();

}