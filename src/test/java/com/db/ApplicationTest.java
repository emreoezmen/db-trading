package com.db;

import lib.Algo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
public class ApplicationTest
{
    private Algo algoMock;

    @BeforeEach
    public void setUp() {
        algoMock = Mockito.mock(Algo.class);
    }

    @Test
    public void should_handle_signal_1()
    {
        Application app = new Application(algoMock);
        app.handleSignal(1);

        verify(algoMock, times(1))
                .setUp();
        verify(algoMock, times(1))
                .setAlgoParam(1,60);
        verify(algoMock, times(1))
                .performCalc();
        verify(algoMock, times(1))
                .submitToMarket();
        verify(algoMock, times(1))
                .doAlgo();

    }

    @Test
    public void should_handle_signal_2()
    {
        Application app = new Application(algoMock);
        app.handleSignal(2);

        verify(algoMock, times(1))
                .reverse();
        verify(algoMock, times(1))
                .setAlgoParam(1,80);
        verify(algoMock, times(1))
                .submitToMarket();
        verify(algoMock, times(1))
                .doAlgo();

    }

    @Test
    public void should_handle_signal_3()
    {
        Application app = new Application(algoMock);
        app.handleSignal(3);

        verify(algoMock, times(1))
                .setAlgoParam(1,90);
        verify(algoMock, times(1))
                .setAlgoParam(2,15);
        verify(algoMock, times(1))
                .performCalc();
        verify(algoMock, times(1))
                .doAlgo();

    }

    @Test
    public void should_handle_signal_4()
    {
        Application app = new Application(algoMock);
        app.handleSignal(4);

        verify(algoMock, times(1))
                .cancelTrades();
        verify(algoMock, times(1))
                .doAlgo();

    }

    @Test
    public void should_handle_signal_5()
    {
        Application app = new Application(algoMock);
        app.handleSignal(5);

        verify(algoMock, times(1))
                .cancelTrades();
        verify(algoMock, times(1))
                .doAlgo();

    }
}
