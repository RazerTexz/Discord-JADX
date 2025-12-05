package com.esotericsoftware.kryo.serializers;

import java.util.Iterator;
import java.util.LinkedList;
import p007b.p106e.p107a.Log;

/* loaded from: classes.dex */
public final class GenericsResolver {
    private LinkedList<Generics> stack = new LinkedList<>();

    public Class getConcreteClass(String str) {
        Iterator<Generics> it = this.stack.iterator();
        while (it.hasNext()) {
            Class concreteClass = it.next().getConcreteClass(str);
            if (concreteClass != null) {
                return concreteClass;
            }
        }
        return null;
    }

    public boolean isSet() {
        return !this.stack.isEmpty();
    }

    public void popScope() {
        this.stack.removeFirst();
    }

    public void pushScope(Class cls, Generics generics) {
        Log.a aVar = Log.f3007a;
        this.stack.addFirst(generics);
    }
}
