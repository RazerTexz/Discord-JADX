package kotlin.reflect;

import d0.c;

/* compiled from: KFunction.kt */
/* loaded from: classes3.dex */
public interface KFunction<R> extends KCallable<R>, c<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();
}
