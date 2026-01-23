package p507d0.p579g0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.Ranges2;
import kotlin.sequences.Sequence;
import p507d0.p512d0._Ranges;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* JADX INFO: renamed from: d0.g0.d, reason: use source file name */
/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Strings implements Sequence<Ranges2> {

    /* JADX INFO: renamed from: a */
    public final CharSequence f25140a;

    /* JADX INFO: renamed from: b */
    public final int f25141b;

    /* JADX INFO: renamed from: c */
    public final int f25142c;

    /* JADX INFO: renamed from: d */
    public final Function2<CharSequence, Integer, Tuples2<Integer, Integer>> f25143d;

    /* JADX INFO: renamed from: d0.g0.d$a */
    /* JADX INFO: compiled from: Strings.kt */
    public static final class a implements Iterator<Ranges2>, KMarkers {

        /* JADX INFO: renamed from: j */
        public int f25144j = -1;

        /* JADX INFO: renamed from: k */
        public int f25145k;

        /* JADX INFO: renamed from: l */
        public int f25146l;

        /* JADX INFO: renamed from: m */
        public Ranges2 f25147m;

        /* JADX INFO: renamed from: n */
        public int f25148n;

        public a() {
            int iCoerceIn = _Ranges.coerceIn(Strings.access$getStartIndex$p(Strings.this), 0, Strings.access$getInput$p(Strings.this).length());
            this.f25145k = iCoerceIn;
            this.f25146l = iCoerceIn;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void m10067a() {
            Tuples2 tuples2;
            if (this.f25146l < 0) {
                this.f25144j = 0;
                this.f25147m = null;
                return;
            }
            if (Strings.access$getLimit$p(Strings.this) > 0) {
                int i = this.f25148n + 1;
                this.f25148n = i;
                if (i >= Strings.access$getLimit$p(Strings.this)) {
                    this.f25147m = new Ranges2(this.f25145k, Strings4.getLastIndex(Strings.access$getInput$p(Strings.this)));
                    this.f25146l = -1;
                } else if (this.f25146l <= Strings.access$getInput$p(Strings.this).length() && (tuples2 = (Tuples2) Strings.access$getGetNextMatch$p(Strings.this).invoke(Strings.access$getInput$p(Strings.this), Integer.valueOf(this.f25146l))) != null) {
                    int iIntValue = ((Number) tuples2.component1()).intValue();
                    int iIntValue2 = ((Number) tuples2.component2()).intValue();
                    this.f25147m = _Ranges.until(this.f25145k, iIntValue);
                    int i2 = iIntValue + iIntValue2;
                    this.f25145k = i2;
                    this.f25146l = i2 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.f25147m = new Ranges2(this.f25145k, Strings4.getLastIndex(Strings.access$getInput$p(Strings.this)));
                    this.f25146l = -1;
                }
            }
            this.f25144j = 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f25144j == -1) {
                m10067a();
            }
            return this.f25144j == 1;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Ranges2 next() {
            return next2();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public Ranges2 next2() {
            if (this.f25144j == -1) {
                m10067a();
            }
            if (this.f25144j == 0) {
                throw new NoSuchElementException();
            }
            Ranges2 ranges2 = this.f25147m;
            Objects.requireNonNull(ranges2, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f25147m = null;
            this.f25144j = -1;
            return ranges2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Strings(CharSequence charSequence, int i, int i2, Function2<? super CharSequence, ? super Integer, Tuples2<Integer, Integer>> function2) {
        Intrinsics3.checkNotNullParameter(charSequence, "input");
        Intrinsics3.checkNotNullParameter(function2, "getNextMatch");
        this.f25140a = charSequence;
        this.f25141b = i;
        this.f25142c = i2;
        this.f25143d = function2;
    }

    public static final /* synthetic */ Function2 access$getGetNextMatch$p(Strings strings) {
        return strings.f25143d;
    }

    public static final /* synthetic */ CharSequence access$getInput$p(Strings strings) {
        return strings.f25140a;
    }

    public static final /* synthetic */ int access$getLimit$p(Strings strings) {
        return strings.f25142c;
    }

    public static final /* synthetic */ int access$getStartIndex$p(Strings strings) {
        return strings.f25141b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Ranges2> iterator() {
        return new a();
    }
}
