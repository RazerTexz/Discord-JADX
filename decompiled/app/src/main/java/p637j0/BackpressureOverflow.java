package p637j0;

import p658rx.exceptions.MissingBackpressureException;

/* compiled from: BackpressureOverflow.java */
/* renamed from: j0.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class BackpressureOverflow {

    /* renamed from: a */
    public static final /* synthetic */ int f26683a = 0;

    /* compiled from: BackpressureOverflow.java */
    /* renamed from: j0.a$a */
    public static final class a implements b {

        /* renamed from: a */
        public static final a f26684a = new a();

        @Override // p637j0.BackpressureOverflow.b
        /* renamed from: a */
        public boolean mo10731a() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    /* compiled from: BackpressureOverflow.java */
    /* renamed from: j0.a$b */
    public interface b {
        /* renamed from: a */
        boolean mo10731a() throws MissingBackpressureException;
    }
}
