package h0.a.a;

/* compiled from: Attribute.java */
/* loaded from: classes3.dex */
public class b {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f3697b;
    public b c;

    /* compiled from: Attribute.java */
    public static final class a {
        public int a;

        /* renamed from: b, reason: collision with root package name */
        public b[] f3698b = new b[6];

        public void a(b bVar) {
            boolean z2;
            while (bVar != null) {
                int i = 0;
                while (true) {
                    if (i >= this.a) {
                        z2 = false;
                        break;
                    } else {
                        if (this.f3698b[i].a.equals(bVar.a)) {
                            z2 = true;
                            break;
                        }
                        i++;
                    }
                }
                if (!z2) {
                    int i2 = this.a;
                    b[] bVarArr = this.f3698b;
                    if (i2 >= bVarArr.length) {
                        b[] bVarArr2 = new b[bVarArr.length + 6];
                        System.arraycopy(bVarArr, 0, bVarArr2, 0, i2);
                        this.f3698b = bVarArr2;
                    }
                    b[] bVarArr3 = this.f3698b;
                    int i3 = this.a;
                    this.a = i3 + 1;
                    bVarArr3[i3] = bVar;
                }
                bVar = bVar.c;
            }
        }
    }

    public b(String str) {
        this.a = str;
    }

    public final int a(v vVar) {
        return b(vVar, null, 0, -1, -1);
    }

    public final int b(v vVar, byte[] bArr, int i, int i2, int i3) {
        f fVar = vVar.a;
        int length = 0;
        for (b bVar = this; bVar != null; bVar = bVar.c) {
            vVar.l(bVar.a);
            length += bVar.f3697b.length + 6;
        }
        return length;
    }

    public final int c() {
        int i = 0;
        for (b bVar = this; bVar != null; bVar = bVar.c) {
            i++;
        }
        return i;
    }

    public final void d(v vVar, c cVar) {
        e(vVar, null, 0, -1, -1, cVar);
    }

    public final void e(v vVar, byte[] bArr, int i, int i2, int i3, c cVar) {
        f fVar = vVar.a;
        for (b bVar = this; bVar != null; bVar = bVar.c) {
            byte[] bArr2 = bVar.f3697b;
            int length = bArr2.length;
            b.d.b.a.a.t0(vVar, bVar.a, cVar, length);
            cVar.h(bArr2, 0, length);
        }
    }
}
