package d0.e0.p.d.m0.i;

import com.adjust.sdk.Constants;
import com.google.android.material.badge.BadgeDrawable;
import d0.e0.p.d.m0.i.r;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: ByteString.java */
/* loaded from: classes3.dex */
public abstract class c implements Iterable<Byte> {
    public static final c j = new m(new byte[0]);

    /* compiled from: ByteString.java */
    public interface a extends Iterator<Byte> {
        byte nextByte();
    }

    public static c c(Iterator<c> it, int i) {
        if (i == 1) {
            return it.next();
        }
        int i2 = i >>> 1;
        return c(it, i2).concat(c(it, i - i2));
    }

    public static c copyFrom(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new m(bArr2);
    }

    public static c copyFromUtf8(String str) {
        try {
            return new m(str.getBytes(Constants.ENCODING));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public static b newOutput() {
        return new b(128);
    }

    public c concat(c cVar) {
        int size = size();
        int size2 = cVar.size();
        if (size + size2 >= 2147483647L) {
            throw new IllegalArgumentException(b.d.b.a.a.h(53, "ByteString would be too long: ", size, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, size2));
        }
        int[] iArr = r.k;
        r rVar = this instanceof r ? (r) this : null;
        if (cVar.size() == 0) {
            return this;
        }
        if (size() == 0) {
            return cVar;
        }
        int size3 = cVar.size() + size();
        if (size3 < 128) {
            return r.l(this, cVar);
        }
        if (rVar != null) {
            if (cVar.size() + rVar.n.size() < 128) {
                return new r(rVar.m, r.l(rVar.n, cVar));
            }
        }
        if (rVar != null && rVar.m.e() > rVar.n.e() && rVar.p > cVar.e()) {
            return new r(rVar.m, new r(rVar.n, cVar));
        }
        if (size3 >= r.k[Math.max(e(), cVar.e()) + 1]) {
            return new r(this, cVar);
        }
        r.b bVar = new r.b(null);
        bVar.a(this);
        bVar.a(cVar);
        c cVarPop = bVar.a.pop();
        while (!bVar.a.isEmpty()) {
            cVarPop = new r(bVar.a.pop(), cVarPop);
        }
        return cVarPop;
    }

    public void copyTo(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(b.d.b.a.a.g(30, "Source offset < 0: ", i));
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(b.d.b.a.a.g(30, "Target offset < 0: ", i2));
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException(b.d.b.a.a.g(23, "Length < 0: ", i3));
        }
        int i4 = i + i3;
        if (i4 > size()) {
            throw new IndexOutOfBoundsException(b.d.b.a.a.g(34, "Source end offset < 0: ", i4));
        }
        int i5 = i2 + i3;
        if (i5 > bArr.length) {
            throw new IndexOutOfBoundsException(b.d.b.a.a.g(34, "Target end offset < 0: ", i5));
        }
        if (i3 > 0) {
            d(bArr, i, i2, i3);
        }
    }

    public abstract void d(byte[] bArr, int i, int i2, int i3);

    public abstract int e();

    public abstract boolean g();

    public abstract int h(int i, int i2, int i3);

    public abstract int i(int i, int i2, int i3);

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    @Override // java.lang.Iterable
    public abstract Iterator<Byte> iterator();

    @Override // java.lang.Iterable
    /* renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    public abstract int j();

    public abstract void k(OutputStream outputStream, int i, int i2) throws IOException;

    public abstract int size();

    public byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return h.a;
        }
        byte[] bArr = new byte[size];
        d(bArr, 0, 0, size);
        return bArr;
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract String toString(String str) throws UnsupportedEncodingException;

    public String toStringUtf8() {
        try {
            return toString(Constants.ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    /* compiled from: ByteString.java */
    public static final class b extends OutputStream {
        public static final byte[] j = new byte[0];
        public final int k;
        public final ArrayList<c> l;
        public int m;
        public byte[] n;
        public int o;

        public b(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.k = i;
            this.l = new ArrayList<>();
            this.n = new byte[i];
        }

        public final void a(int i) {
            this.l.add(new m(this.n));
            int length = this.m + this.n.length;
            this.m = length;
            this.n = new byte[Math.max(this.k, Math.max(i, length >>> 1))];
            this.o = 0;
        }

        public final void b() {
            int i = this.o;
            byte[] bArr = this.n;
            if (i >= bArr.length) {
                this.l.add(new m(this.n));
                this.n = j;
            } else if (i > 0) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
                this.l.add(new m(bArr2));
            }
            this.m += this.o;
            this.o = 0;
        }

        public synchronized int size() {
            return this.m + this.o;
        }

        public synchronized c toByteString() {
            b();
            return c.copyFrom(this.l);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) {
            if (this.o == this.n.length) {
                a(1);
            }
            byte[] bArr = this.n;
            int i2 = this.o;
            this.o = i2 + 1;
            bArr[i2] = (byte) i;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) {
            byte[] bArr2 = this.n;
            int length = bArr2.length;
            int i3 = this.o;
            if (i2 <= length - i3) {
                System.arraycopy(bArr, i, bArr2, i3, i2);
                this.o += i2;
            } else {
                int length2 = bArr2.length - i3;
                System.arraycopy(bArr, i, bArr2, i3, length2);
                int i4 = i2 - length2;
                a(i4);
                System.arraycopy(bArr, i + length2, this.n, 0, i4);
                this.o = i4;
            }
        }
    }

    public static c copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    public static c copyFrom(Iterable<c> iterable) {
        ?? arrayList;
        if (!(iterable instanceof Collection)) {
            arrayList = new ArrayList();
            Iterator<c> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        } else {
            arrayList = (Collection) iterable;
        }
        if (arrayList.isEmpty()) {
            return j;
        }
        return c(arrayList.iterator(), arrayList.size());
    }
}
