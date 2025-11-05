package d0.e0.p.d.m0.i;

import d0.e0.p.d.m0.i.c;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/* compiled from: RopeByteString.java */
/* loaded from: classes3.dex */
public class r extends d0.e0.p.d.m0.i.c {
    public static final int[] k;
    public final int l;
    public final d0.e0.p.d.m0.i.c m;
    public final d0.e0.p.d.m0.i.c n;
    public final int o;
    public final int p;
    public int q = 0;

    /* compiled from: RopeByteString.java */
    public static class b {
        public final Stack<d0.e0.p.d.m0.i.c> a = new Stack<>();

        public b(a aVar) {
        }

        public final void a(d0.e0.p.d.m0.i.c cVar) {
            if (!cVar.g()) {
                if (!(cVar instanceof r)) {
                    String strValueOf = String.valueOf(cVar.getClass());
                    throw new IllegalArgumentException(b.d.b.a.a.J(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
                }
                r rVar = (r) cVar;
                a(rVar.m);
                a(rVar.n);
                return;
            }
            int size = cVar.size();
            int[] iArr = r.k;
            int iBinarySearch = Arrays.binarySearch(iArr, size);
            if (iBinarySearch < 0) {
                iBinarySearch = (-(iBinarySearch + 1)) - 1;
            }
            int i = iArr[iBinarySearch + 1];
            if (this.a.isEmpty() || this.a.peek().size() >= i) {
                this.a.push(cVar);
                return;
            }
            int i2 = iArr[iBinarySearch];
            d0.e0.p.d.m0.i.c cVarPop = this.a.pop();
            while (!this.a.isEmpty() && this.a.peek().size() < i2) {
                cVarPop = new r(this.a.pop(), cVarPop);
            }
            r rVar2 = new r(cVarPop, cVar);
            while (!this.a.isEmpty()) {
                int size2 = rVar2.size();
                int[] iArr2 = r.k;
                int iBinarySearch2 = Arrays.binarySearch(iArr2, size2);
                if (iBinarySearch2 < 0) {
                    iBinarySearch2 = (-(iBinarySearch2 + 1)) - 1;
                }
                if (this.a.peek().size() >= iArr2[iBinarySearch2 + 1]) {
                    break;
                } else {
                    rVar2 = new r(this.a.pop(), rVar2);
                }
            }
            this.a.push(rVar2);
        }
    }

    /* compiled from: RopeByteString.java */
    public static class c implements Iterator<m> {
        public final Stack<r> j = new Stack<>();
        public m k;

        public c(d0.e0.p.d.m0.i.c cVar, a aVar) {
            while (cVar instanceof r) {
                r rVar = (r) cVar;
                this.j.push(rVar);
                cVar = rVar.m;
            }
            this.k = (m) cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.k != null;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ m next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public m next() {
            m mVar;
            m mVar2 = this.k;
            if (mVar2 == null) {
                throw new NoSuchElementException();
            }
            while (true) {
                if (this.j.isEmpty()) {
                    mVar = null;
                    break;
                }
                d0.e0.p.d.m0.i.c cVar = this.j.pop().n;
                while (cVar instanceof r) {
                    r rVar = (r) cVar;
                    this.j.push(rVar);
                    cVar = rVar.m;
                }
                mVar = (m) cVar;
                if (!mVar.isEmpty()) {
                    break;
                }
            }
            this.k = mVar;
            return mVar2;
        }
    }

    /* compiled from: RopeByteString.java */
    public class d implements c.a {
        public final c j;
        public c.a k;
        public int l;

        /* JADX WARN: Type inference failed for: r3v3, types: [d0.e0.p.d.m0.i.c$a] */
        public d(r rVar, a aVar) {
            c cVar = new c(rVar, null);
            this.j = cVar;
            this.k = cVar.next().iterator();
            this.l = rVar.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.l > 0;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return next();
        }

        /* JADX WARN: Type inference failed for: r0v8, types: [d0.e0.p.d.m0.i.c$a] */
        @Override // d0.e0.p.d.m0.i.c.a
        public byte nextByte() {
            if (!this.k.hasNext()) {
                this.k = this.j.next().iterator();
            }
            this.l--;
            return this.k.nextByte();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        k = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = k;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }

    public r(d0.e0.p.d.m0.i.c cVar, d0.e0.p.d.m0.i.c cVar2) {
        this.m = cVar;
        this.n = cVar2;
        int size = cVar.size();
        this.o = size;
        this.l = cVar2.size() + size;
        this.p = Math.max(cVar.e(), cVar2.e()) + 1;
    }

    public static m l(d0.e0.p.d.m0.i.c cVar, d0.e0.p.d.m0.i.c cVar2) {
        int size = cVar.size();
        int size2 = cVar2.size();
        byte[] bArr = new byte[size + size2];
        cVar.copyTo(bArr, 0, 0, size);
        cVar2.copyTo(bArr, 0, size, size2);
        return new m(bArr);
    }

    @Override // d0.e0.p.d.m0.i.c
    public void d(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.o;
        if (i4 <= i5) {
            this.m.d(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.n.d(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.m.d(bArr, i, i2, i6);
            this.n.d(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // d0.e0.p.d.m0.i.c
    public int e() {
        return this.p;
    }

    public boolean equals(Object obj) {
        int iJ;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d0.e0.p.d.m0.i.c)) {
            return false;
        }
        d0.e0.p.d.m0.i.c cVar = (d0.e0.p.d.m0.i.c) obj;
        if (this.l != cVar.size()) {
            return false;
        }
        if (this.l == 0) {
            return true;
        }
        if (this.q != 0 && (iJ = cVar.j()) != 0 && this.q != iJ) {
            return false;
        }
        c cVar2 = new c(this, null);
        m next = cVar2.next();
        c cVar3 = new c(cVar, null);
        m next2 = cVar3.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next.size() - i;
            int size2 = next2.size() - i2;
            int iMin = Math.min(size, size2);
            if (!(i == 0 ? next.l(next2, i2, iMin) : next2.l(next, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.l;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                next = cVar2.next();
                i = 0;
            } else {
                i += iMin;
            }
            if (iMin == size2) {
                next2 = cVar3.next();
                i2 = 0;
            } else {
                i2 += iMin;
            }
        }
    }

    @Override // d0.e0.p.d.m0.i.c
    public boolean g() {
        return this.l >= k[this.p];
    }

    @Override // d0.e0.p.d.m0.i.c
    public int h(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.o;
        if (i4 <= i5) {
            return this.m.h(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.n.h(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.n.h(this.m.h(i, i2, i6), 0, i3 - i6);
    }

    public int hashCode() {
        int iH = this.q;
        if (iH == 0) {
            int i = this.l;
            iH = h(i, 0, i);
            if (iH == 0) {
                iH = 1;
            }
            this.q = iH;
        }
        return iH;
    }

    @Override // d0.e0.p.d.m0.i.c
    public int i(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.o;
        if (i4 <= i5) {
            return this.m.i(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.n.i(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.n.i(this.m.i(i, i2, i6), 0, i3 - i6);
    }

    @Override // d0.e0.p.d.m0.i.c
    public boolean isValidUtf8() {
        int i = this.m.i(0, 0, this.o);
        d0.e0.p.d.m0.i.c cVar = this.n;
        return cVar.i(i, 0, cVar.size()) == 0;
    }

    @Override // d0.e0.p.d.m0.i.c, java.lang.Iterable
    /* renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    @Override // d0.e0.p.d.m0.i.c
    public int j() {
        return this.q;
    }

    @Override // d0.e0.p.d.m0.i.c
    public void k(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = this.o;
        if (i3 <= i4) {
            this.m.k(outputStream, i, i2);
        } else {
            if (i >= i4) {
                this.n.k(outputStream, i - i4, i2);
                return;
            }
            int i5 = i4 - i;
            this.m.k(outputStream, i, i5);
            this.n.k(outputStream, 0, i2 - i5);
        }
    }

    @Override // d0.e0.p.d.m0.i.c
    public int size() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.i.c
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    @Override // d0.e0.p.d.m0.i.c, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new d(this, null);
    }
}
