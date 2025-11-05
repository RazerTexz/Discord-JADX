package b.i.a.c.x2.j0;

import b.i.a.c.f3.x;
import b.i.a.c.j1;
import b.i.a.c.x2.t;
import b.i.a.c.x2.w;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: StreamReader.java */
/* loaded from: classes3.dex */
public abstract class i {

    /* renamed from: b, reason: collision with root package name */
    public w f1239b;
    public b.i.a.c.x2.j c;
    public g d;
    public long e;
    public long f;
    public long g;
    public int h;
    public int i;
    public long k;
    public boolean l;
    public boolean m;
    public final e a = new e();
    public b j = new b();

    /* compiled from: StreamReader.java */
    public static class b {
        public j1 a;

        /* renamed from: b, reason: collision with root package name */
        public g f1240b;
    }

    /* compiled from: StreamReader.java */
    public static final class c implements g {
        public c(a aVar) {
        }

        @Override // b.i.a.c.x2.j0.g
        public t a() {
            return new t.b(-9223372036854775807L, 0L);
        }

        @Override // b.i.a.c.x2.j0.g
        public long b(b.i.a.c.x2.i iVar) {
            return -1L;
        }

        @Override // b.i.a.c.x2.j0.g
        public void c(long j) {
        }
    }

    public long a(long j) {
        return (this.i * j) / 1000000;
    }

    public void b(long j) {
        this.g = j;
    }

    public abstract long c(x xVar);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean d(x xVar, long j, b bVar) throws IOException;

    public void e(boolean z2) {
        if (z2) {
            this.j = new b();
            this.f = 0L;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.e = -1L;
        this.g = 0L;
    }
}
