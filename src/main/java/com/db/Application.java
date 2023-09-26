package com.db;

import lib.Algo;
import lib.SignalHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Application implements SignalHandler {

    private Algo algo;
    private Map<Integer, SignalHandler> signalHandlersMap;

    public Application(Algo algo) {
        this.algo = algo;
        this.signalHandlersMap = new ConcurrentHashMap<Integer, SignalHandler>();
    }

    public void addSignalHandler(int signal, SignalHandler signalHandler) {
        signalHandlersMap.put(signal, signalHandler);
    }


    @Override
    public void handleSignal(int signal) {
        SignalHandler signalHandler;

        if (signalHandlersMap.get(signal) != null) {
            signalHandler = signalHandlersMap.get(signal);
            signalHandler.handleSignal(signal);
        } else {
            algo.cancelTrades();
        }

        algo.doAlgo();
    }

}

