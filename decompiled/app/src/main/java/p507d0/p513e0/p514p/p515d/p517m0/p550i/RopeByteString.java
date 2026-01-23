package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.r, reason: use source file name */
/* JADX INFO: compiled from: RopeByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public class RopeByteString extends ByteString3 {

    /* JADX INFO: renamed from: k */
    public static final int[] f24154k;

    /* JADX INFO: renamed from: l */
    public final int f24155l;

    /* JADX INFO: renamed from: m */
    public final ByteString3 f24156m;

    /* JADX INFO: renamed from: n */
    public final ByteString3 f24157n;

    /* JADX INFO: renamed from: o */
    public final int f24158o;

    /* JADX INFO: renamed from: p */
    public final int f24159p;

    /* JADX INFO: renamed from: q */
    public int f24160q = 0;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.r$b */
    /* JADX INFO: compiled from: RopeByteString.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public final Stack<ByteString3> f24161a = new Stack<>();

        public b(a aVar) {
        }

        /* JADX INFO: renamed from: a */
        public final void m9860a(ByteString3 byteString3) {
            if (!byteString3.mo9826g()) {
                if (!(byteString3 instanceof RopeByteString)) {
                    String strValueOf = String.valueOf(byteString3.getClass());
                    throw new IllegalArgumentException(outline.m822J(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
                }
                RopeByteString ropeByteString = (RopeByteString) byteString3;
                m9860a(ropeByteString.f24156m);
                m9860a(ropeByteString.f24157n);
                return;
            }
            int size = byteString3.size();
            int[] iArr = RopeByteString.f24154k;
            int iBinarySearch = Arrays.binarySearch(iArr, size);
            if (iBinarySearch < 0) {
                iBinarySearch = (-(iBinarySearch + 1)) - 1;
            }
            int i = iArr[iBinarySearch + 1];
            if (this.f24161a.isEmpty() || this.f24161a.peek().size() >= i) {
                this.f24161a.push(byteString3);
                return;
            }
            int i2 = iArr[iBinarySearch];
            ByteString3 byteString3Pop = this.f24161a.pop();
            while (!this.f24161a.isEmpty() && this.f24161a.peek().size() < i2) {
                byteString3Pop = new RopeByteString(this.f24161a.pop(), byteString3Pop);
            }
            RopeByteString ropeByteString2 = new RopeByteString(byteString3Pop, byteString3);
            while (!this.f24161a.isEmpty()) {
                int size2 = ropeByteString2.size();
                int[] iArr2 = RopeByteString.f24154k;
                int iBinarySearch2 = Arrays.binarySearch(iArr2, size2);
                if (iBinarySearch2 < 0) {
                    iBinarySearch2 = (-(iBinarySearch2 + 1)) - 1;
                }
                if (this.f24161a.peek().size() >= iArr2[iBinarySearch2 + 1]) {
                    break;
                } else {
                    ropeByteString2 = new RopeByteString(this.f24161a.pop(), ropeByteString2);
                }
            }
            this.f24161a.push(ropeByteString2);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.r$c */
    /* JADX INFO: compiled from: RopeByteString.java */
    public static class c implements Iterator<LiteralByteString> {

        /* JADX INFO: renamed from: j */
        public final Stack<RopeByteString> f24162j = new Stack<>();

        /* JADX INFO: renamed from: k */
        public LiteralByteString f24163k;

        public c(ByteString3 byteString3, a aVar) {
            while (byteString3 instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString3;
                this.f24162j.push(ropeByteString);
                byteString3 = ropeByteString.f24156m;
            }
            this.f24163k = (LiteralByteString) byteString3;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f24163k != null;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ LiteralByteString next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public LiteralByteString next() {
            LiteralByteString literalByteString;
            LiteralByteString literalByteString2 = this.f24163k;
            if (literalByteString2 == null) {
                throw new NoSuchElementException();
            }
            while (true) {
                if (this.f24162j.isEmpty()) {
                    literalByteString = null;
                    break;
                }
                ByteString3 byteString3 = this.f24162j.pop().f24157n;
                while (byteString3 instanceof RopeByteString) {
                    RopeByteString ropeByteString = (RopeByteString) byteString3;
                    this.f24162j.push(ropeByteString);
                    byteString3 = ropeByteString.f24156m;
                }
                literalByteString = (LiteralByteString) byteString3;
                if (!literalByteString.isEmpty()) {
                    break;
                }
            }
            this.f24163k = literalByteString;
            return literalByteString2;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.r$d */
    /* JADX INFO: compiled from: RopeByteString.java */
    public class d implements ByteString3.a {

        /* JADX INFO: renamed from: j */
        public final c f24164j;

        /* JADX INFO: renamed from: k */
        public ByteString3.a f24165k;

        /* JADX INFO: renamed from: l */
        public int f24166l;

        /* JADX WARN: Type inference failed for: r3v3, types: [d0.e0.p.d.m0.i.c$a] */
        public d(RopeByteString ropeByteString, a aVar) {
            c cVar = new c(ropeByteString, null);
            this.f24164j = cVar;
            this.f24165k = cVar.next().iterator();
            this.f24166l = ropeByteString.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f24166l > 0;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return next();
        }

        /* JADX WARN: Type inference failed for: r0v8, types: [d0.e0.p.d.m0.i.c$a] */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3.a
        public byte nextByte() {
            if (!this.f24165k.hasNext()) {
                this.f24165k = this.f24164j.next().iterator();
            }
            this.f24166l--;
            return this.f24165k.nextByte();
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
        f24154k = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = f24154k;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }

    public RopeByteString(ByteString3 byteString3, ByteString3 byteString32) {
        this.f24156m = byteString3;
        this.f24157n = byteString32;
        int size = byteString3.size();
        this.f24158o = size;
        this.f24155l = byteString32.size() + size;
        this.f24159p = Math.max(byteString3.mo9825e(), byteString32.mo9825e()) + 1;
    }

    /* JADX INFO: renamed from: l */
    public static LiteralByteString m9859l(ByteString3 byteString3, ByteString3 byteString32) {
        int size = byteString3.size();
        int size2 = byteString32.size();
        byte[] bArr = new byte[size + size2];
        byteString3.copyTo(bArr, 0, 0, size);
        byteString32.copyTo(bArr, 0, size, size2);
        return new LiteralByteString(bArr);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: d */
    public void mo9824d(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.f24158o;
        if (i4 <= i5) {
            this.f24156m.mo9824d(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.f24157n.mo9824d(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.f24156m.mo9824d(bArr, i, i2, i6);
            this.f24157n.mo9824d(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: e */
    public int mo9825e() {
        return this.f24159p;
    }

    public boolean equals(Object obj) {
        int iMo9829j;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString3)) {
            return false;
        }
        ByteString3 byteString3 = (ByteString3) obj;
        if (this.f24155l != byteString3.size()) {
            return false;
        }
        if (this.f24155l == 0) {
            return true;
        }
        if (this.f24160q != 0 && (iMo9829j = byteString3.mo9829j()) != 0 && this.f24160q != iMo9829j) {
            return false;
        }
        c cVar = new c(this, null);
        LiteralByteString next = cVar.next();
        c cVar2 = new c(byteString3, null);
        LiteralByteString next2 = cVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next.size() - i;
            int size2 = next2.size() - i2;
            int iMin = Math.min(size, size2);
            if (!(i == 0 ? next.m9857l(next2, i2, iMin) : next2.m9857l(next, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.f24155l;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                next = cVar.next();
                i = 0;
            } else {
                i += iMin;
            }
            if (iMin == size2) {
                next2 = cVar2.next();
                i2 = 0;
            } else {
                i2 += iMin;
            }
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: g */
    public boolean mo9826g() {
        return this.f24155l >= f24154k[this.f24159p];
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: h */
    public int mo9827h(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.f24158o;
        if (i4 <= i5) {
            return this.f24156m.mo9827h(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.f24157n.mo9827h(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.f24157n.mo9827h(this.f24156m.mo9827h(i, i2, i6), 0, i3 - i6);
    }

    public int hashCode() {
        int iMo9827h = this.f24160q;
        if (iMo9827h == 0) {
            int i = this.f24155l;
            iMo9827h = mo9827h(i, 0, i);
            if (iMo9827h == 0) {
                iMo9827h = 1;
            }
            this.f24160q = iMo9827h;
        }
        return iMo9827h;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: i */
    public int mo9828i(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.f24158o;
        if (i4 <= i5) {
            return this.f24156m.mo9828i(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.f24157n.mo9828i(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.f24157n.mo9828i(this.f24156m.mo9828i(i, i2, i6), 0, i3 - i6);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    public boolean isValidUtf8() {
        int iMo9828i = this.f24156m.mo9828i(0, 0, this.f24158o);
        ByteString3 byteString3 = this.f24157n;
        return byteString3.mo9828i(iMo9828i, 0, byteString3.size()) == 0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: j */
    public int mo9829j() {
        return this.f24160q;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: k */
    public void mo9830k(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = this.f24158o;
        if (i3 <= i4) {
            this.f24156m.mo9830k(outputStream, i, i2);
        } else {
            if (i >= i4) {
                this.f24157n.mo9830k(outputStream, i - i4, i2);
                return;
            }
            int i5 = i4 - i;
            this.f24156m.mo9830k(outputStream, i, i5);
            this.f24157n.mo9830k(outputStream, 0, i2 - i5);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    public int size() {
        return this.f24155l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new d(this, null);
    }
}
