package b.i.a.c.x2;

import androidx.annotation.Nullable;
import b.i.a.c.j1;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: TrackOutput.java */
/* loaded from: classes3.dex */
public interface w {

    /* compiled from: TrackOutput.java */
    public static final class a {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f1299b;
        public final int c;
        public final int d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.a = i;
            this.f1299b = bArr;
            this.c = i2;
            this.d = i3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.c == aVar.c && this.d == aVar.d && Arrays.equals(this.f1299b, aVar.f1299b);
        }

        public int hashCode() {
            return ((((Arrays.hashCode(this.f1299b) + (this.a * 31)) * 31) + this.c) * 31) + this.d;
        }
    }

    int a(b.i.a.c.e3.h hVar, int i, boolean z2, int i2) throws IOException;

    int b(b.i.a.c.e3.h hVar, int i, boolean z2) throws IOException;

    void c(b.i.a.c.f3.x xVar, int i);

    void d(long j, int i, int i2, int i3, @Nullable a aVar);

    void e(j1 j1Var);

    void f(b.i.a.c.f3.x xVar, int i, int i2);
}
