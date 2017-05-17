/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import ast.type.TypeVar;
import examples.Example;
import typing.Environ;
import typing.Subst;
import typing.TVPool;
import typing.UnificationException;

class Main {
    private static void unifyTest() {
        Subst subst = new Subst();

        System.out.println(Example.type3);
        System.out.println(Example.type4);

        try {
            Example.type3.unify(Example.type4, subst);
            System.out.println(Example.type3.substitute(subst));
            System.out.println(Example.type4.substitute(subst));
        } catch (UnificationException ex) {
            System.out.println(ex);
        }
    }

    private static void typeTest() {
        Subst subst = new Subst();
        TVPool tvPool = new TVPool();

        try {
            TypeVar tv = tvPool.freshTV();
            Example.prog2.inferType(new Environ(), tv, subst, tvPool);
            System.out.println(tv.substitute(subst));
        } catch (UnificationException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        typeTest();
    }
}
