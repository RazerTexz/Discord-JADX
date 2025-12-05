package p659s.p660a;

import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CancellableContinuationImpl.kt */
/* renamed from: s.a.v, reason: use source file name */
/* loaded from: classes3.dex */
public final class CancellableContinuationImpl8 {

    /* renamed from: a */
    public final Object f27906a;

    /* renamed from: b */
    public final CancellableContinuationImpl4 f27907b;

    /* renamed from: c */
    public final Function1<Throwable, Unit> f27908c;

    /* renamed from: d */
    public final Object f27909d;

    /* renamed from: e */
    public final Throwable f27910e;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl8(Object obj, CancellableContinuationImpl4 cancellableContinuationImpl4, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.f27906a = obj;
        this.f27907b = cancellableContinuationImpl4;
        this.f27908c = function1;
        this.f27909d = obj2;
        this.f27910e = th;
    }

    /* renamed from: a */
    public static CancellableContinuationImpl8 m11349a(CancellableContinuationImpl8 cancellableContinuationImpl8, Object obj, CancellableContinuationImpl4 cancellableContinuationImpl4, Function1 function1, Object obj2, Throwable th, int i) {
        Object obj3 = (i & 1) != 0 ? cancellableContinuationImpl8.f27906a : null;
        if ((i & 2) != 0) {
            cancellableContinuationImpl4 = cancellableContinuationImpl8.f27907b;
        }
        CancellableContinuationImpl4 cancellableContinuationImpl42 = cancellableContinuationImpl4;
        Function1<Throwable, Unit> function12 = (i & 4) != 0 ? cancellableContinuationImpl8.f27908c : null;
        Object obj4 = (i & 8) != 0 ? cancellableContinuationImpl8.f27909d : null;
        if ((i & 16) != 0) {
            th = cancellableContinuationImpl8.f27910e;
        }
        Objects.requireNonNull(cancellableContinuationImpl8);
        return new CancellableContinuationImpl8(obj3, cancellableContinuationImpl42, function12, obj4, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CancellableContinuationImpl8)) {
            return false;
        }
        CancellableContinuationImpl8 cancellableContinuationImpl8 = (CancellableContinuationImpl8) obj;
        return Intrinsics3.areEqual(this.f27906a, cancellableContinuationImpl8.f27906a) && Intrinsics3.areEqual(this.f27907b, cancellableContinuationImpl8.f27907b) && Intrinsics3.areEqual(this.f27908c, cancellableContinuationImpl8.f27908c) && Intrinsics3.areEqual(this.f27909d, cancellableContinuationImpl8.f27909d) && Intrinsics3.areEqual(this.f27910e, cancellableContinuationImpl8.f27910e);
    }

    public int hashCode() {
        Object obj = this.f27906a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        CancellableContinuationImpl4 cancellableContinuationImpl4 = this.f27907b;
        int iHashCode2 = (iHashCode + (cancellableContinuationImpl4 != null ? cancellableContinuationImpl4.hashCode() : 0)) * 31;
        Function1<Throwable, Unit> function1 = this.f27908c;
        int iHashCode3 = (iHashCode2 + (function1 != null ? function1.hashCode() : 0)) * 31;
        Object obj2 = this.f27909d;
        int iHashCode4 = (iHashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Throwable th = this.f27910e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("CompletedContinuation(result=");
        sbM833U.append(this.f27906a);
        sbM833U.append(", cancelHandler=");
        sbM833U.append(this.f27907b);
        sbM833U.append(", onCancellation=");
        sbM833U.append(this.f27908c);
        sbM833U.append(", idempotentResume=");
        sbM833U.append(this.f27909d);
        sbM833U.append(", cancelCause=");
        sbM833U.append(this.f27910e);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public CancellableContinuationImpl8(Object obj, CancellableContinuationImpl4 cancellableContinuationImpl4, Function1 function1, Object obj2, Throwable th, int i) {
        cancellableContinuationImpl4 = (i & 2) != 0 ? null : cancellableContinuationImpl4;
        function1 = (i & 4) != 0 ? null : function1;
        obj2 = (i & 8) != 0 ? null : obj2;
        th = (i & 16) != 0 ? null : th;
        this.f27906a = obj;
        this.f27907b = cancellableContinuationImpl4;
        this.f27908c = function1;
        this.f27909d = obj2;
        this.f27910e = th;
    }
}
