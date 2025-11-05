package d0.e0.p.d.m0.f.y;

import d0.t.c0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* compiled from: BuiltInsBinaryVersion.kt */
/* loaded from: classes3.dex */
public final class a extends d0.e0.p.d.m0.f.z.a {
    public static final C0553a f = new C0553a(null);
    public static final a g = new a(1, 0, 7);

    /* compiled from: BuiltInsBinaryVersion.kt */
    /* renamed from: d0.e0.p.d.m0.f.y.a$a, reason: collision with other inner class name */
    public static final class C0553a {
        public C0553a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final a readFrom(InputStream inputStream) {
            m.checkNotNullParameter(inputStream, "stream");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            IntRange intRange = new IntRange(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                ((c0) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] intArray = u.toIntArray(arrayList);
            int[] iArr = new int[intArray.length];
            System.arraycopy(intArray, 0, iArr, 0, intArray.length);
            return new a(iArr);
        }
    }

    static {
        new a(new int[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(int... iArr) {
        m.checkNotNullParameter(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super(iArr2);
    }

    public boolean isCompatible() {
        return a(g);
    }
}
