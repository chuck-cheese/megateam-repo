package com.megateam.core.utils;


import com.megateam.core.utils.Printer;

public class ConsolePrinter implements Printer {

        @Override
        public void print(String printable) {
            System.out.print(printable);
        }

        @Override
        public void println(String printable) {
            System.out.println(printable);
        }
    }

