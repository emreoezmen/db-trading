package com.db;

import lib.Algo;
import lib.SignalHandler;

public class Application implements SignalHandler
{
    private Algo algo;

    public Application(Algo algo) {
        this.algo = algo;
    }

    public void handleSignal(int signal) {

        switch (signal) {
            case 1:
                algo.setUp();
                algo.setAlgoParam(1,60);
                algo.performCalc();
                algo.submitToMarket();
                break;

            case 2:
                algo.reverse();
                algo.setAlgoParam(1,80);
                algo.submitToMarket();
                break;

            case 3:
                algo.setAlgoParam(1,90);
                algo.setAlgoParam(2,15);
                algo.performCalc();
                algo.submitToMarket();
                break;

            default:
                algo.cancelTrades();
                break;
        }

        algo.doAlgo();
    }
}
