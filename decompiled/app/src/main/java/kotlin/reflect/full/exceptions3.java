package kotlin.reflect.full;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: kotlin.reflect.full.NoSuchPropertyException, reason: use source file name */
/* JADX INFO: compiled from: exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
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
