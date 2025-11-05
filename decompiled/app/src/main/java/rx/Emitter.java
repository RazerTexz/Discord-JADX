package rx;

import j0.g;

/* loaded from: classes3.dex */
public interface Emitter<T> extends g<T> {

    public enum BackpressureMode {
        NONE,
        ERROR,
        BUFFER,
        DROP,
        LATEST
    }
}
