package com.bohangao;

import com.bohangao.AtomicVariable.AtomicVariableDemo;
import com.bohangao.DaemonThread.DaemonThreadDemo;
import com.bohangao.DataRace.DataRaceDemo;
import com.bohangao.MutualExclusion.MutualExclusionDemo;
import com.bohangao.ReentrantLock.ReentrantLockDemo;
import com.bohangao.Runnable.RunnableDemo;
import com.bohangao.Scheduling.SchedulingDemo;
import com.bohangao.Synchronized.SynchronizedMethodDemo;
import com.bohangao.Synchronized.SynchronizedStatementDemo;
import com.bohangao.ThreadLifeCycle.ThreadLifeCycleDemo;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //SchedulingDemo.demo();

        //ThreadLifeCycleDemo.demo();

        //RunnableDemo.demo();

        //DaemonThreadDemo.demo();

        //DataRaceDemo.demo();

        //MutualExclusionDemo.demo();

        //AtomicVariableDemo.demo();

        //SynchronizedMethodDemo.demo();
        //SynchronizedStatementDemo.demo();

        ReentrantLockDemo.demo();
    }
}
