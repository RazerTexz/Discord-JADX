package p659s.p660a.p663c2;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Channel.kt */
/* renamed from: s.a.c2.v, reason: use source file name */
/* loaded from: classes3.dex */
public final class Channel8<T> {

    /* renamed from: a */
    public final Object f27770a;

    /* compiled from: Channel.kt */
    /* renamed from: s.a.c2.v$a */
    public static final class a {

        /* renamed from: a */
        public final Throwable f27771a;

        public a(Throwable th) {
            this.f27771a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && Intrinsics3.areEqual(this.f27771a, ((a) obj).f27771a);
        }

        public int hashCode() {
            Throwable th = this.f27771a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Closed(");
            sbM833U.append(this.f27771a);
            sbM833U.append(')');
            return sbM833U.toString();
        }
    }

    public /* synthetic */ Channel8(Object obj) {
        this.f27770a = obj;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Channel8) && Intrinsics3.areEqual(this.f27770a, ((Channel8) obj).f27770a);
    }

    public int hashCode() {
        Object obj = this.f27770a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f27770a;
        if (obj instanceof a) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }
}
