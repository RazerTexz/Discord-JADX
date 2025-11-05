package s.a.c2;

/* compiled from: Channel.kt */
/* loaded from: classes3.dex */
public final class v<T> {
    public final Object a;

    /* compiled from: Channel.kt */
    public static final class a {
        public final Throwable a;

        public a(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && d0.z.d.m.areEqual(this.a, ((a) obj).a);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("Closed(");
            sbU.append(this.a);
            sbU.append(')');
            return sbU.toString();
        }
    }

    public /* synthetic */ v(Object obj) {
        this.a = obj;
    }

    public boolean equals(Object obj) {
        return (obj instanceof v) && d0.z.d.m.areEqual(this.a, ((v) obj).a);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.a;
        if (obj instanceof a) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }
}
