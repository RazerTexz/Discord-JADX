package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.m, reason: use source file name */
/* JADX INFO: compiled from: LiteralByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public class LiteralByteString extends ByteString3 {

    /* JADX INFO: renamed from: k */
    public final byte[] f24149k;

    /* JADX INFO: renamed from: l */
    public int f24150l = 0;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.m$b */
    /* JADX INFO: compiled from: LiteralByteString.java */
    public class b implements ByteString3.a {

        /* JADX INFO: renamed from: j */
        public int f24151j = 0;

        /* JADX INFO: renamed from: k */
        public final int f24152k;

        public b(a aVar) {
            this.f24152k = LiteralByteString.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f24151j < this.f24152k;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return next();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3.a
        public byte nextByte() {
            try {
                byte[] bArr = LiteralByteString.this.f24149k;
                int i = this.f24151j;
                this.f24151j = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
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

    public LiteralByteString(byte[] bArr) {
        this.f24149k = bArr;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: d */
    public void mo9824d(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f24149k, i, bArr, i2, i3);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: e */
    public int mo9825e() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString3) || size() != ((ByteString3) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof LiteralByteString) {
            return m9857l((LiteralByteString) obj, 0, size());
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        String strValueOf = String.valueOf(obj.getClass());
        throw new IllegalArgumentException(outline.m822J(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: g */
    public boolean mo9826g() {
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: h */
    public int mo9827h(int i, int i2, int i3) {
        byte[] bArr = this.f24149k;
        int iM9858m = m9858m() + i2;
        for (int i4 = iM9858m; i4 < iM9858m + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public int hashCode() {
        int iMo9827h = this.f24150l;
        if (iMo9827h == 0) {
            int size = size();
            iMo9827h = mo9827h(size, 0, size);
            if (iMo9827h == 0) {
                iMo9827h = 1;
            }
            this.f24150l = iMo9827h;
        }
        return iMo9827h;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: i */
    public int mo9828i(int i, int i2, int i3) {
        int iM9858m = m9858m() + i2;
        return Utf8.partialIsValidUtf8(i, this.f24149k, iM9858m, i3 + iM9858m);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    public boolean isValidUtf8() {
        int iM9858m = m9858m();
        return Utf8.isValidUtf8(this.f24149k, iM9858m, size() + iM9858m);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: j */
    public int mo9829j() {
        return this.f24150l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    /* JADX INFO: renamed from: k */
    public void mo9830k(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.f24149k, m9858m() + i, i2);
    }

    /* JADX INFO: renamed from: l */
    public boolean m9857l(LiteralByteString literalByteString, int i, int i2) {
        if (i2 > literalByteString.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i + i2 > literalByteString.size()) {
            int size2 = literalByteString.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        byte[] bArr = this.f24149k;
        byte[] bArr2 = literalByteString.f24149k;
        int iM9858m = m9858m() + i2;
        int iM9858m2 = m9858m();
        int iM9858m3 = literalByteString.m9858m() + i;
        while (iM9858m2 < iM9858m) {
            if (bArr[iM9858m2] != bArr2[iM9858m3]) {
                return false;
            }
            iM9858m2++;
            iM9858m3++;
        }
        return true;
    }

    /* JADX INFO: renamed from: m */
    public int m9858m() {
        return 0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    public int size() {
        return this.f24149k.length;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.f24149k, m9858m(), size(), str);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new b(null);
    }
}
