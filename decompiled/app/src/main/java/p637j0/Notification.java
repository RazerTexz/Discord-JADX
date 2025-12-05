package p637j0;

/* compiled from: Notification.java */
/* renamed from: j0.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class Notification<T> {

    /* renamed from: a */
    public static final Notification<Void> f26688a = new Notification<>(a.OnCompleted, null, null);

    /* renamed from: b */
    public final a f26689b;

    /* renamed from: c */
    public final Throwable f26690c;

    /* renamed from: d */
    public final T f26691d;

    /* compiled from: Notification.java */
    /* renamed from: j0.f$a */
    public enum a {
        OnNext,
        OnError,
        OnCompleted
    }

    public Notification(a aVar, T t, Throwable th) {
        this.f26691d = t;
        this.f26690c = th;
        this.f26689b = aVar;
    }

    /* renamed from: a */
    public boolean m10733a() {
        return (this.f26689b == a.OnError) && this.f26690c != null;
    }

    /* renamed from: b */
    public boolean m10734b() {
        return (this.f26689b == a.OnNext) && this.f26691d != null;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != Notification.class) {
            return false;
        }
        Notification notification = (Notification) obj;
        if (notification.f26689b != this.f26689b) {
            return false;
        }
        T t = this.f26691d;
        T t2 = notification.f26691d;
        if (t != t2 && (t == null || !t.equals(t2))) {
            return false;
        }
        Throwable th = this.f26690c;
        Throwable th2 = notification.f26690c;
        return th == th2 || (th != null && th.equals(th2));
    }

    public int hashCode() {
        int iHashCode = this.f26689b.hashCode();
        if (m10734b()) {
            iHashCode = (iHashCode * 31) + this.f26691d.hashCode();
        }
        return m10733a() ? (iHashCode * 31) + this.f26690c.hashCode() : iHashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(' ');
        sb.append(this.f26689b);
        if (m10734b()) {
            sb.append(' ');
            sb.append(this.f26691d);
        }
        if (m10733a()) {
            sb.append(' ');
            sb.append(this.f26690c.getMessage());
        }
        sb.append(']');
        return sb.toString();
    }
}
