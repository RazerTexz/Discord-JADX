package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* compiled from: Region.kt */
/* renamed from: androidx.core.graphics.RegionKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Region {

    /* compiled from: Region.kt */
    /* renamed from: androidx.core.graphics.RegionKt$iterator$1 */
    public static final class C02261 implements Iterator<Rect>, KMarkers {
        public final /* synthetic */ android.graphics.Region $this_iterator;
        private boolean hasMore;
        private final RegionIterator iterator;
        private final Rect rect;

        public C02261(android.graphics.Region region) {
            this.$this_iterator = region;
            RegionIterator regionIterator = new RegionIterator(region);
            this.iterator = regionIterator;
            Rect rect = new Rect();
            this.rect = rect;
            this.hasMore = regionIterator.next(rect);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasMore;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Rect next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Rect next() {
            if (!this.hasMore) {
                throw new IndexOutOfBoundsException();
            }
            Rect rect = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return rect;
        }
    }

    public static final android.graphics.Region and(android.graphics.Region region, Rect rect) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(rect, "r");
        android.graphics.Region region2 = new android.graphics.Region(region);
        region2.op(rect, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(android.graphics.Region region, Point point) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(point, "p");
        return region.contains(point.x, point.y);
    }

    public static final void forEach(android.graphics.Region region, Function1<? super Rect, Unit> function1) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                function1.invoke(rect);
            }
        }
    }

    public static final Iterator<Rect> iterator(android.graphics.Region region) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        return new C02261(region);
    }

    public static final android.graphics.Region minus(android.graphics.Region region, Rect rect) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(rect, "r");
        android.graphics.Region region2 = new android.graphics.Region(region);
        region2.op(rect, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final android.graphics.Region not(android.graphics.Region region) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        android.graphics.Region region2 = new android.graphics.Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    /* renamed from: or */
    public static final android.graphics.Region m87or(android.graphics.Region region, Rect rect) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(rect, "r");
        android.graphics.Region region2 = new android.graphics.Region(region);
        region2.union(rect);
        return region2;
    }

    public static final android.graphics.Region plus(android.graphics.Region region, Rect rect) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(rect, "r");
        android.graphics.Region region2 = new android.graphics.Region(region);
        region2.union(rect);
        return region2;
    }

    public static final android.graphics.Region unaryMinus(android.graphics.Region region) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        android.graphics.Region region2 = new android.graphics.Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final android.graphics.Region xor(android.graphics.Region region, Rect rect) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(rect, "r");
        android.graphics.Region region2 = new android.graphics.Region(region);
        region2.op(rect, Region.Op.XOR);
        return region2;
    }

    public static final android.graphics.Region and(android.graphics.Region region, android.graphics.Region region2) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(region2, "r");
        android.graphics.Region region3 = new android.graphics.Region(region);
        region3.op(region2, Region.Op.INTERSECT);
        return region3;
    }

    public static final android.graphics.Region minus(android.graphics.Region region, android.graphics.Region region2) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(region2, "r");
        android.graphics.Region region3 = new android.graphics.Region(region);
        region3.op(region2, Region.Op.DIFFERENCE);
        return region3;
    }

    /* renamed from: or */
    public static final android.graphics.Region m88or(android.graphics.Region region, android.graphics.Region region2) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(region2, "r");
        android.graphics.Region region3 = new android.graphics.Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    public static final android.graphics.Region plus(android.graphics.Region region, android.graphics.Region region2) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(region2, "r");
        android.graphics.Region region3 = new android.graphics.Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    public static final android.graphics.Region xor(android.graphics.Region region, android.graphics.Region region2) {
        Intrinsics3.checkNotNullParameter(region, "<this>");
        Intrinsics3.checkNotNullParameter(region2, "r");
        android.graphics.Region region3 = new android.graphics.Region(region);
        region3.op(region2, Region.Op.XOR);
        return region3;
    }
}
