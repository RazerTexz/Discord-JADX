package j0;

import rx.exceptions.MissingBackpressureException;

/* compiled from: BackpressureOverflow.java */
/* loaded from: classes3.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* compiled from: BackpressureOverflow.java */
    /* renamed from: j0.a$a, reason: collision with other inner class name */
    public static final class C0618a implements b {
        public static final C0618a a = new C0618a();

        @Override // j0.a.b
        public boolean a() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    /* compiled from: BackpressureOverflow.java */
    public interface b {
        boolean a() throws MissingBackpressureException;
    }
}
