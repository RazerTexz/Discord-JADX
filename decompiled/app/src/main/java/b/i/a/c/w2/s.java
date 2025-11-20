package b.i.a.c.w2;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import b.i.a.c.a3.a0;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: DrmSessionEventListener.java */
/* loaded from: classes3.dex */
public interface s {
    void J(int i, @Nullable a0.a aVar);

    void S(int i, @Nullable a0.a aVar);

    void c0(int i, @Nullable a0.a aVar, int i2);

    void d0(int i, @Nullable a0.a aVar);

    void i0(int i, @Nullable a0.a aVar);

    void u(int i, @Nullable a0.a aVar, Exception exc);

    /* compiled from: DrmSessionEventListener.java */
    public static class a {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final a0.a f1156b;
        public final CopyOnWriteArrayList<C0101a> c;

        /* compiled from: DrmSessionEventListener.java */
        /* renamed from: b.i.a.c.w2.s$a$a, reason: collision with other inner class name */
        public static final class C0101a {
            public Handler a;

            /* renamed from: b, reason: collision with root package name */
            public s f1157b;

            public C0101a(Handler handler, s sVar) {
                this.a = handler;
                this.f1157b = sVar;
            }
        }

        public a() {
            this.c = new CopyOnWriteArrayList<>();
            this.a = 0;
            this.f1156b = null;
        }

        public void a() {
            for (C0101a c0101a : this.c) {
                b.i.a.c.f3.e0.E(c0101a.a, new i(this, c0101a.f1157b));
            }
        }

        public void b() {
            for (C0101a c0101a : this.c) {
                b.i.a.c.f3.e0.E(c0101a.a, new h(this, c0101a.f1157b));
            }
        }

        public void c() {
            for (C0101a c0101a : this.c) {
                b.i.a.c.f3.e0.E(c0101a.a, new j(this, c0101a.f1157b));
            }
        }

        public void d(int i) {
            for (C0101a c0101a : this.c) {
                b.i.a.c.f3.e0.E(c0101a.a, new l(this, c0101a.f1157b, i));
            }
        }

        public void e(Exception exc) {
            for (C0101a c0101a : this.c) {
                b.i.a.c.f3.e0.E(c0101a.a, new k(this, c0101a.f1157b, exc));
            }
        }

        public void f() {
            for (C0101a c0101a : this.c) {
                b.i.a.c.f3.e0.E(c0101a.a, new g(this, c0101a.f1157b));
            }
        }

        @CheckResult
        public a g(int i, @Nullable a0.a aVar) {
            return new a(this.c, i, aVar);
        }

        public a(CopyOnWriteArrayList<C0101a> copyOnWriteArrayList, int i, @Nullable a0.a aVar) {
            this.c = copyOnWriteArrayList;
            this.a = i;
            this.f1156b = aVar;
        }
    }
}
