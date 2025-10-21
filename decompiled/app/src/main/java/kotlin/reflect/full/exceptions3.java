package kotlin.reflect.full;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: exceptions.kt */
/* renamed from: kotlin.reflect.full.NoSuchPropertyException, reason: use source file name */
/* loaded from: classes3.dex */
public final class exceptions3 extends Exception {
    public exceptions3() {
        this(null, 1, null);
    }

    public exceptions3(Exception exc) {
        super(exc);
    }

    public /* synthetic */ exceptions3(Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : exc);
    }
}
