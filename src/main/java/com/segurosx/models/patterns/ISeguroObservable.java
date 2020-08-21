package com.segurosx.models.patterns;

public interface ISeguroObservable {

    void addObserver(IClienteObserver observer);
    void removeObserver(IClienteObserver observer);
    
}