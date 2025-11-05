package j0.l.a;

import java.io.Serializable;

/* compiled from: NotificationLite.java */
/* loaded from: classes3.dex */
public final class e {
    public static final Object a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f3771b = new b();

    /* compiled from: NotificationLite.java */
    public static class a implements Serializable {
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    }

    /* compiled from: NotificationLite.java */
    public static class b implements Serializable {
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    }

    /* compiled from: NotificationLite.java */
    public static final class c implements Serializable {
        private static final long serialVersionUID = 3;
        public final Throwable e;

        public c(Throwable th) {
            this.e = th;
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("Notification=>Error:");
            sbU.append(this.e);
            return sbU.toString();
        }
    }

    public static <T> boolean a(j0.g<? super T> gVar, Object obj) {
        if (obj == a) {
            gVar.onCompleted();
            return true;
        }
        if (obj == f3771b) {
            gVar.onNext(null);
            return false;
        }
        if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
        if (obj.getClass() == c.class) {
            gVar.onError(((c) obj).e);
            return true;
        }
        gVar.onNext(obj);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T b(Object obj) {
        if (obj == f3771b) {
            return null;
        }
        return obj;
    }

    public static boolean c(Object obj) {
        return obj == a;
    }
}
