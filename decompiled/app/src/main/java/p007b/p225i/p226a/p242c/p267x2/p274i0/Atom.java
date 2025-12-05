package p007b.p225i.p226a.p242c.p267x2.p274i0;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;

/* compiled from: Atom.java */
/* renamed from: b.i.a.c.x2.i0.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Atom {

    /* renamed from: a */
    public final int f8349a;

    /* compiled from: Atom.java */
    /* renamed from: b.i.a.c.x2.i0.d$a */
    public static final class a extends Atom {

        /* renamed from: b */
        public final long f8350b;

        /* renamed from: c */
        public final List<b> f8351c;

        /* renamed from: d */
        public final List<a> f8352d;

        public a(int i, long j) {
            super(i);
            this.f8350b = j;
            this.f8351c = new ArrayList();
            this.f8352d = new ArrayList();
        }

        @Nullable
        /* renamed from: b */
        public a m3700b(int i) {
            int size = this.f8352d.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.f8352d.get(i2);
                if (aVar.f8349a == i) {
                    return aVar;
                }
            }
            return null;
        }

        @Nullable
        /* renamed from: c */
        public b m3701c(int i) {
            int size = this.f8351c.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.f8351c.get(i2);
                if (bVar.f8349a == i) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.Atom
        public String toString() {
            String strM3699a = Atom.m3699a(this.f8349a);
            String string = Arrays.toString(this.f8351c.toArray());
            String string2 = Arrays.toString(this.f8352d.toArray());
            StringBuilder sbM831S = outline.m831S(outline.m841b(string2, outline.m841b(string, outline.m841b(strM3699a, 22))), strM3699a, " leaves: ", string, " containers: ");
            sbM831S.append(string2);
            return sbM831S.toString();
        }
    }

    /* compiled from: Atom.java */
    /* renamed from: b.i.a.c.x2.i0.d$b */
    public static final class b extends Atom {

        /* renamed from: b */
        public final ParsableByteArray f8353b;

        public b(int i, ParsableByteArray parsableByteArray) {
            super(i);
            this.f8353b = parsableByteArray;
        }
    }

    public Atom(int i) {
        this.f8349a = i;
    }

    /* renamed from: a */
    public static String m3699a(int i) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) ((i >> 24) & 255));
        sb.append((char) ((i >> 16) & 255));
        sb.append((char) ((i >> 8) & 255));
        sb.append((char) (i & 255));
        return sb.toString();
    }

    public String toString() {
        return m3699a(this.f8349a);
    }
}
