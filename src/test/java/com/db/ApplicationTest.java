package com.db;

import lib.Algo;
import lib.SignalHandler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


public class ApplicationTest {
    Algo algoMock;
    Application app;

    SignalHandler signalHandler1 = new SignalHandler() {
        @Override
        public void handleSignal(int signal) {
            algoMock.setUp();
            algoMock.setAlgoParam(1, 60);
            algoMock.performCalc();
            algoMock.submitToMarket();
        }
    };

    private SignalHandler signalHandler2 = new SignalHandler() {
        @Override
        public void handleSignal(int signal) {
            algoMock.reverse();
            algoMock.setAlgoParam(1, 80);
            algoMock.submitToMarket();
        }
    };

    private SignalHandler signalHandler3 = new SignalHandler() {
        @Override
        public void handleSignal(int signal) {
            algoMock.setAlgoParam(1, 90);
            algoMock.setAlgoParam(2, 15);
            algoMock.performCalc();
            algoMock.submitToMarket();

        }
    };

    @BeforeEach
    public void setUp() {
        algoMock = Mockito.mock(Algo.class);
        app = new Application(algoMock);
    }

    @Test
    public void should_handle_signal_1() {
        app.addSignalHandler(1, signalHandler1);
        app.handleSignal(1);

        verify(algoMock, times(1))
                .setUp();
        verify(algoMock, times(1))
                .setAlgoParam(1, 60);
        verify(algoMock, times(1))
                .performCalc();
        verify(algoMock, times(1))
                .submitToMarket();
        verify(algoMock, times(1))
                .doAlgo();

    }

    @Test
    public void should_handle_signal_2() {
        app.addSignalHandler(2, signalHandler2);
        app.handleSignal(2);

        verify(algoMock, times(1))
                .reverse();
        verify(algoMock, times(1))
                .setAlgoParam(1, 80);
        verify(algoMock, times(1))
                .submitToMarket();
        verify(algoMock, times(1))
                .doAlgo();

    }

    @Test
    public void should_handle_signal_3() {
        app.addSignalHandler(3, signalHandler3);
        app.handleSignal(3);

        verify(algoMock, times(1))
                .setAlgoParam(1, 90);
        verify(algoMock, times(1))
                .setAlgoParam(2, 15);
        verify(algoMock, times(1))
                .performCalc();
        verify(algoMock, times(1))
                .doAlgo();

    }

    @Test
    public void should_handle_signal_4() {
        app.handleSignal(4);

        verify(algoMock, times(1))
                .cancelTrades();
        verify(algoMock, times(1))
                .doAlgo();

    }

    @Test
    public void should_handle_signal_5() {
        app.handleSignal(5);

        verify(algoMock, times(1))
                .cancelTrades();
        verify(algoMock, times(1))
                .doAlgo();

    }
}
