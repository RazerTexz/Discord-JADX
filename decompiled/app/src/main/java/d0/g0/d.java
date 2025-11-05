package d0.g0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public final class d implements Sequence<IntRange> {
    public final CharSequence a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3580b;
    public final int c;
    public final Function2<CharSequence, Integer, Pair<Integer, Integer>> d;

    /* compiled from: Strings.kt */
    public static final class a implements Iterator<IntRange>, d0.z.d.g0.a {
        public int j = -1;
        public int k;
        public int l;
        public IntRange m;
        public int n;

        public a() {
            int iCoerceIn = d0.d0.f.coerceIn(d.access$getStartIndex$p(d.this), 0, d.access$getInput$p(d.this).length());
            this.k = iCoerceIn;
            this.l = iCoerceIn;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a() {
            Pair pair;
            if (this.l < 0) {
                this.j = 0;
                this.m = null;
                return;
            }
            if (d.access$getLimit$p(d.this) > 0) {
                int i = this.n + 1;
                this.n = i;
                if (i >= d.access$getLimit$p(d.this)) {
                    this.m = new IntRange(this.k, w.getLastIndex(d.access$getInput$p(d.this)));
                    this.l = -1;
                } else if (this.l <= d.access$getInput$p(d.this).length() && (pair = (Pair) d.access$getGetNextMatch$p(d.this).invoke(d.access$getInput$p(d.this), Integer.valueOf(this.l))) != null) {
                    int iIntValue = ((Number) pair.component1()).intValue();
                    int iIntValue2 = ((Number) pair.component2()).intValue();
                    this.m = d0.d0.f.until(this.k, iIntValue);
                    int i2 = iIntValue + iIntValue2;
                    this.k = i2;
                    this.l = i2 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.m = new IntRange(this.k, w.getLastIndex(d.access$getInput$p(d.this)));
                    this.l = -1;
                }
            }
            this.j = 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.j == -1) {
                a();
            }
            return this.j == 1;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ IntRange next() {
            return next2();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        /* renamed from: next, reason: avoid collision after fix types in other method */
        public IntRange next2() {
            if (this.j == -1) {
                a();
            }
            if (this.j == 0) {
                throw new NoSuchElementException();
            }
            IntRange intRange = this.m;
            Objects.requireNonNull(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.m = null;
            this.j = -1;
            return intRange;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        d0.z.d.m.checkNotNullParameter(charSequence, "input");
        d0.z.d.m.checkNotNullParameter(function2, "getNextMatch");
        this.a = charSequence;
        this.f3580b = i;
        this.c = i2;
        this.d = function2;
    }

    public static final /* synthetic */ Function2 access$getGetNextMatch$p(d dVar) {
        return dVar.d;
    }

    public static final /* synthetic */ CharSequence access$getInput$p(d dVar) {
        return dVar.a;
    }

    public static final /* synthetic */ int access$getLimit$p(d dVar) {
        return dVar.c;
    }

    public static final /* synthetic */ int access$getStartIndex$p(d dVar) {
        return dVar.f3580b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<IntRange> iterator() {
        return new a();
    }
}
