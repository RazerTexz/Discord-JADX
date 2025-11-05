package d0.e0;

import kotlin.reflect.KType;

/* compiled from: KParameter.kt */
/* loaded from: classes3.dex */
public interface f extends b {

    /* compiled from: KParameter.kt */
    public enum a {
        INSTANCE,
        EXTENSION_RECEIVER,
        VALUE
    }

    a getKind();

    String getName();

    KType getType();

    boolean isOptional();

    boolean isVararg();
}
