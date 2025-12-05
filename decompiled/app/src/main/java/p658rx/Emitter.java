package p658rx;

import p637j0.Observer2;

/* loaded from: classes3.dex */
public interface Emitter<T> extends Observer2<T> {

    public enum BackpressureMode {
        NONE,
        ERROR,
        BUFFER,
        DROP,
        LATEST
    }
}
