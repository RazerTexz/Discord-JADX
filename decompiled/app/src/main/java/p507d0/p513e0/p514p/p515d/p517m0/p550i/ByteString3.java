package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import com.adjust.sdk.Constants;
import com.google.android.material.badge.BadgeDrawable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.RopeByteString;

/* compiled from: ByteString.java */
/* renamed from: d0.e0.p.d.m0.i.c, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ByteString3 implements Iterable<Byte> {

    /* renamed from: j */
    public static final ByteString3 f24100j = new LiteralByteString(new byte[0]);

    /* compiled from: ByteString.java */
    /* renamed from: d0.e0.p.d.m0.i.c$a */
    public interface a extends Iterator<Byte> {
        byte nextByte();
    }

    /* renamed from: c */
    public static ByteString3 m9823c(Iterator<ByteString3> it, int i) {
        if (i == 1) {
            return it.next();
        }
        int i2 = i >>> 1;
        return m9823c(it, i2).concat(m9823c(it, i - i2));
    }

    public static ByteString3 copyFrom(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new LiteralByteString(bArr2);
    }

    public static ByteString3 copyFromUtf8(String str) {
        try {
            return new LiteralByteString(str.getBytes(Constants.ENCODING));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public static b newOutput() {
        return new b(128);
    }

    public ByteString3 concat(ByteString3 byteString3) {
        int size = size();
        int size2 = byteString3.size();
        if (size + size2 >= 2147483647L) {
            throw new IllegalArgumentException(outline.m853h(53, "ByteString would be too long: ", size, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, size2));
        }
        int[] iArr = RopeByteString.f24154k;
        RopeByteString ropeByteString = this instanceof RopeByteString ? (RopeByteString) this : null;
        if (byteString3.size() == 0) {
            return this;
        }
        if (size() == 0) {
            return byteString3;
        }
        int size3 = byteString3.size() + size();
        if (size3 < 128) {
            return RopeByteString.m9859l(this, byteString3);
        }
        if (ropeByteString != null) {
            if (byteString3.size() + ropeByteString.f24157n.size() < 128) {
                return new RopeByteString(ropeByteString.f24156m, RopeByteString.m9859l(ropeByteString.f24157n, byteString3));
            }
        }
        if (ropeByteString != null && ropeByteString.f24156m.mo9825e() > ropeByteString.f24157n.mo9825e() && ropeByteString.f24159p > byteString3.mo9825e()) {
            return new RopeByteString(ropeByteString.f24156m, new RopeByteString(ropeByteString.f24157n, byteString3));
        }
        if (size3 >= RopeByteString.f24154k[Math.max(mo9825e(), byteString3.mo9825e()) + 1]) {
            return new RopeByteString(this, byteString3);
        }
        RopeByteString.b bVar = new RopeByteString.b(null);
        bVar.m9860a(this);
        bVar.m9860a(byteString3);
        ByteString3 byteString3Pop = bVar.f24161a.pop();
        while (!bVar.f24161a.isEmpty()) {
            byteString3Pop = new RopeByteString(bVar.f24161a.pop(), byteString3Pop);
        }
        return byteString3Pop;
    }

    public void copyTo(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(outline.m851g(30, "Source offset < 0: ", i));
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(outline.m851g(30, "Target offset < 0: ", i2));
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException(outline.m851g(23, "Length < 0: ", i3));
        }
        int i4 = i + i3;
        if (i4 > size()) {
            throw new IndexOutOfBoundsException(outline.m851g(34, "Source end offset < 0: ", i4));
        }
        int i5 = i2 + i3;
        if (i5 > bArr.length) {
            throw new IndexOutOfBoundsException(outline.m851g(34, "Target end offset < 0: ", i5));
        }
        if (i3 > 0) {
            mo9824d(bArr, i, i2, i3);
        }
    }

    /* renamed from: d */
    public abstract void mo9824d(byte[] bArr, int i, int i2, int i3);

    /* renamed from: e */
    public abstract int mo9825e();

    /* renamed from: g */
    public abstract boolean mo9826g();

    /* renamed from: h */
    public abstract int mo9827h(int i, int i2, int i3);

    /* renamed from: i */
    public abstract int mo9828i(int i, int i2, int i3);

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

    /* renamed from: j */
    public abstract int mo9829j();

    /* renamed from: k */
    public abstract void mo9830k(OutputStream outputStream, int i, int i2) throws IOException;

    public abstract int size();

    public byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.f24142a;
        }
        byte[] bArr = new byte[size];
        mo9824d(bArr, 0, 0, size);
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
    /* renamed from: d0.e0.p.d.m0.i.c$b */
    public static final class b extends OutputStream {

        /* renamed from: j */
        public static final byte[] f24101j = new byte[0];

        /* renamed from: k */
        public final int f24102k;

        /* renamed from: l */
        public final ArrayList<ByteString3> f24103l;

        /* renamed from: m */
        public int f24104m;

        /* renamed from: n */
        public byte[] f24105n;

        /* renamed from: o */
        public int f24106o;

        public b(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.f24102k = i;
            this.f24103l = new ArrayList<>();
            this.f24105n = new byte[i];
        }

        /* renamed from: a */
        public final void m9831a(int i) {
            this.f24103l.add(new LiteralByteString(this.f24105n));
            int length = this.f24104m + this.f24105n.length;
            this.f24104m = length;
            this.f24105n = new byte[Math.max(this.f24102k, Math.max(i, length >>> 1))];
            this.f24106o = 0;
        }

        /* renamed from: b */
        public final void m9832b() {
            int i = this.f24106o;
            byte[] bArr = this.f24105n;
            if (i >= bArr.length) {
                this.f24103l.add(new LiteralByteString(this.f24105n));
                this.f24105n = f24101j;
            } else if (i > 0) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
                this.f24103l.add(new LiteralByteString(bArr2));
            }
            this.f24104m += this.f24106o;
            this.f24106o = 0;
        }

        public synchronized int size() {
            return this.f24104m + this.f24106o;
        }

        public synchronized ByteString3 toByteString() {
            m9832b();
            return ByteString3.copyFrom(this.f24103l);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) {
            if (this.f24106o == this.f24105n.length) {
                m9831a(1);
            }
            byte[] bArr = this.f24105n;
            int i2 = this.f24106o;
            this.f24106o = i2 + 1;
            bArr[i2] = (byte) i;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) {
            byte[] bArr2 = this.f24105n;
            int length = bArr2.length;
            int i3 = this.f24106o;
            if (i2 <= length - i3) {
                System.arraycopy(bArr, i, bArr2, i3, i2);
                this.f24106o += i2;
            } else {
                int length2 = bArr2.length - i3;
                System.arraycopy(bArr, i, bArr2, i3, length2);
                int i4 = i2 - length2;
                m9831a(i4);
                System.arraycopy(bArr, i + length2, this.f24105n, 0, i4);
                this.f24106o = i4;
            }
        }
    }

    public static ByteString3 copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    public static ByteString3 copyFrom(Iterable<ByteString3> iterable) {
        ?? arrayList;
        if (!(iterable instanceof Collection)) {
            arrayList = new ArrayList();
            Iterator<ByteString3> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        } else {
            arrayList = (Collection) iterable;
        }
        if (arrayList.isEmpty()) {
            return f24100j;
        }
        return m9823c(arrayList.iterator(), arrayList.size());
    }
}
