package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.util.Util;
import p007b.p100d.p104b.p105a.outline;
import p007b.p106e.p107a.Log;
import p617h0.p620b.p621a.ObjectInstantiator;

/* JADX INFO: loaded from: classes.dex */
public class Registration {

    /* JADX INFO: renamed from: id */
    private final int f19417id;
    private ObjectInstantiator instantiator;
    private Serializer serializer;
    private final Class type;

    public Registration(Class cls, Serializer serializer, int i) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.type = cls;
        this.serializer = serializer;
        this.f19417id = i;
    }

    public int getId() {
        return this.f19417id;
    }

    public ObjectInstantiator getInstantiator() {
        return this.instantiator;
    }

    public Serializer getSerializer() {
        return this.serializer;
    }

    public Class getType() {
        return this.type;
    }

    public void setInstantiator(ObjectInstantiator objectInstantiator) {
        if (objectInstantiator == null) {
            throw new IllegalArgumentException("instantiator cannot be null.");
        }
        this.instantiator = objectInstantiator;
    }

    public void setSerializer(Serializer serializer) {
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.serializer = serializer;
        Log.a aVar = Log.f3007a;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("[");
        sbM833U.append(this.f19417id);
        sbM833U.append(", ");
        sbM833U.append(Util.className(this.type));
        sbM833U.append("]");
        return sbM833U.toString();
    }
}
