package p007b.p225i.p226a.p242c.p267x2;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p257e3.DataReader;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;

/* compiled from: TrackOutput.java */
/* renamed from: b.i.a.c.x2.w, reason: use source file name */
/* loaded from: classes3.dex */
public interface TrackOutput2 {

    /* compiled from: TrackOutput.java */
    /* renamed from: b.i.a.c.x2.w$a */
    public static final class a {

        /* renamed from: a */
        public final int f9000a;

        /* renamed from: b */
        public final byte[] f9001b;

        /* renamed from: c */
        public final int f9002c;

        /* renamed from: d */
        public final int f9003d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.f9000a = i;
            this.f9001b = bArr;
            this.f9002c = i2;
            this.f9003d = i3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9000a == aVar.f9000a && this.f9002c == aVar.f9002c && this.f9003d == aVar.f9003d && Arrays.equals(this.f9001b, aVar.f9001b);
        }

        public int hashCode() {
            return ((((Arrays.hashCode(this.f9001b) + (this.f9000a * 31)) * 31) + this.f9002c) * 31) + this.f9003d;
        }
    }

    /* renamed from: a */
    int mo2522a(DataReader dataReader, int i, boolean z2, int i2) throws IOException;

    /* renamed from: b */
    int mo2523b(DataReader dataReader, int i, boolean z2) throws IOException;

    /* renamed from: c */
    void mo2524c(ParsableByteArray parsableByteArray, int i);

    /* renamed from: d */
    void mo2525d(long j, int i, int i2, int i3, @Nullable a aVar);

    /* renamed from: e */
    void mo2526e(Format2 format2);

    /* renamed from: f */
    void mo2527f(ParsableByteArray parsableByteArray, int i, int i2);
}
