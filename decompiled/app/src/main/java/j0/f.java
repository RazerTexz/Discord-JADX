package j0;

/* compiled from: Notification.java */
/* loaded from: classes3.dex */
public final class f<T> {
    public static final f<Void> a = new f<>(a.OnCompleted, null, null);

    /* renamed from: b, reason: collision with root package name */
    public final a f3768b;
    public final Throwable c;
    public final T d;

    /* compiled from: Notification.java */
    public enum a {
        OnNext,
        OnError,
        OnCompleted
    }

    public f(a aVar, T t, Throwable th) {
        this.d = t;
        this.c = th;
        this.f3768b = aVar;
    }

    public boolean a() {
        return (this.f3768b == a.OnError) && this.c != null;
    }

    public boolean b() {
        return (this.f3768b == a.OnNext) && this.d != null;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != f.class) {
            return false;
        }
        f fVar = (f) obj;
        if (fVar.f3768b != this.f3768b) {
            return false;
        }
        T t = this.d;
        T t2 = fVar.d;
        if (t != t2 && (t == null || !t.equals(t2))) {
            return false;
        }
        Throwable th = this.c;
        Throwable th2 = fVar.c;
        return th == th2 || (th != null && th.equals(th2));
    }

    public int hashCode() {
        int iHashCode = this.f3768b.hashCode();
        if (b()) {
            iHashCode = (iHashCode * 31) + this.d.hashCode();
        }
        return a() ? (iHashCode * 31) + this.c.hashCode() : iHashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(' ');
        sb.append(this.f3768b);
        if (b()) {
            sb.append(' ');
            sb.append(this.d);
        }
        if (a()) {
            sb.append(' ');
            sb.append(this.c.getMessage());
        }
        sb.append(']');
        return sb.toString();
    }
}
