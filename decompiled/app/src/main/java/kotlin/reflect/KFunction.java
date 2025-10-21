package kotlin.reflect;

import d0.Function3;

/* compiled from: KFunction.kt */
/* loaded from: classes3.dex */
public interface KFunction<R> extends KCallable<R>, Function3<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();
}
