package p637j0.p642l.p643a;

import java.io.Serializable;
import p007b.p100d.p104b.p105a.outline;
import p637j0.Observer2;

/* compiled from: NotificationLite.java */
/* renamed from: j0.l.a.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class NotificationLite {

    /* renamed from: a */
    public static final Object f26768a = new a();

    /* renamed from: b */
    public static final Object f26769b = new b();

    /* compiled from: NotificationLite.java */
    /* renamed from: j0.l.a.e$a */
    public static class a implements Serializable {
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    }

    /* compiled from: NotificationLite.java */
    /* renamed from: j0.l.a.e$b */
    public static class b implements Serializable {
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    }

    /* compiled from: NotificationLite.java */
    /* renamed from: j0.l.a.e$c */
    public static final class c implements Serializable {
        private static final long serialVersionUID = 3;

        /* renamed from: e */
        public final Throwable f26770e;

        public c(Throwable th) {
            this.f26770e = th;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Notification=>Error:");
            sbM833U.append(this.f26770e);
            return sbM833U.toString();
        }
    }

    /* renamed from: a */
    public static <T> boolean m10744a(Observer2<? super T> observer2, Object obj) {
        if (obj == f26768a) {
            observer2.onCompleted();
            return true;
        }
        if (obj == f26769b) {
            observer2.onNext(null);
            return false;
        }
        if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
        if (obj.getClass() == c.class) {
            observer2.onError(((c) obj).f26770e);
            return true;
        }
        observer2.onNext(obj);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static <T> T m10745b(Object obj) {
        if (obj == f26769b) {
            return null;
        }
        return obj;
    }

    /* renamed from: c */
    public static boolean m10746c(Object obj) {
        return obj == f26768a;
    }
}
