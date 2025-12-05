package p507d0.p578f0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Appendable;
import p507d0.p580t.Collections2;
import p507d0.p580t.MutableCollectionsJVM;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* compiled from: _Sequences.kt */
/* renamed from: d0.f0.q, reason: use source file name */
/* loaded from: classes3.dex */
public class _Sequences2 extends _SequencesJvm {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.kt */
    /* renamed from: d0.f0.q$a */
    public static final class a<T> implements Iterable<T>, KMarkers {

        /* renamed from: j */
        public final /* synthetic */ Sequence f25109j;

        public a(Sequence sequence) {
            this.f25109j = sequence;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f25109j.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: _Sequences.kt */
    /* renamed from: d0.f0.q$b */
    public static final class b<T> extends Lambda implements Function1<T, T> {

        /* renamed from: j */
        public static final b f25110j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final T invoke(T t) {
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: _Sequences.kt */
    /* renamed from: d0.f0.q$c */
    public static final class c<T> extends Lambda implements Function1<T, Boolean> {

        /* renamed from: j */
        public static final c f25111j = new c();

        public c() {
            super(1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke2(obj));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(T t) {
            return t == null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: _Sequences.kt */
    /* renamed from: d0.f0.q$d */
    public static final /* synthetic */ class d<R> extends FunctionReferenceImpl implements Function1<Sequence<? extends R>, Iterator<? extends R>> {

        /* renamed from: j */
        public static final d f25112j = new d();

        public d() {
            super(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((Sequence) obj);
        }

        public final Iterator<R> invoke(Sequence<? extends R> sequence) {
            Intrinsics3.checkNotNullParameter(sequence, "p1");
            return sequence.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: _Sequences.kt */
    /* renamed from: d0.f0.q$e */
    public static final class e<T> implements Sequence<T> {

        /* renamed from: a */
        public final /* synthetic */ Sequence f25113a;

        public e(Sequence<? extends T> sequence) {
            this.f25113a = sequence;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            List mutableList = _Sequences2.toMutableList(this.f25113a);
            MutableCollectionsJVM.sort(mutableList);
            return mutableList.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: _Sequences.kt */
    /* renamed from: d0.f0.q$f */
    public static final class f<T> implements Sequence<T> {

        /* renamed from: a */
        public final /* synthetic */ Sequence f25114a;

        /* renamed from: b */
        public final /* synthetic */ Comparator f25115b;

        public f(Sequence<? extends T> sequence, Comparator comparator) {
            this.f25114a = sequence;
            this.f25115b = comparator;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            List mutableList = _Sequences2.toMutableList(this.f25114a);
            MutableCollectionsJVM.sortWith(mutableList, this.f25115b);
            return mutableList.iterator();
        }
    }

    public static final <T> boolean any(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$any");
        return sequence.iterator().hasNext();
    }

    public static final <T> Iterable<T> asIterable(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$asIterable");
        return new a(sequence);
    }

    public static final <T> int count(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$count");
        Iterator<? extends T> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                Collections2.throwCountOverflow();
            }
        }
        return i;
    }

    public static final <T> Sequence<T> distinct(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$distinct");
        return distinctBy(sequence, b.f25110j);
    }

    public static final <T, K> Sequence<T> distinctBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$distinctBy");
        Intrinsics3.checkNotNullParameter(function1, "selector");
        return new C12064c(sequence, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> drop(Sequence<? extends T> sequence, int i) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$drop");
        if (i >= 0) {
            return i == 0 ? sequence : sequence instanceof InterfaceC12066e ? ((InterfaceC12066e) sequence).drop(i) : new C12065d(sequence, i);
        }
        throw new IllegalArgumentException(outline.m873r("Requested element count ", i, " is less than zero.").toString());
    }

    public static final <T> Sequence<T> filter(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$filter");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        return new C12068g(sequence, true, function1);
    }

    public static final <T> Sequence<T> filterNot(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$filterNot");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        return new C12068g(sequence, false, function1);
    }

    public static final <T> Sequence<T> filterNotNull(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$filterNotNull");
        Sequence<T> sequenceFilterNot = filterNot(sequence, c.f25111j);
        Objects.requireNonNull(sequenceFilterNot, "null cannot be cast to non-null type kotlin.sequences.Sequence<T>");
        return sequenceFilterNot;
    }

    public static final <T> T firstOrNull(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$firstOrNull");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final <T, R> Sequence<R> flatMap(Sequence<? extends T> sequence, Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$flatMap");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        return new C12069h(sequence, function1, d.f25112j);
    }

    public static final <T, A extends Appendable> A joinTo(Sequence<? extends T> sequence, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        Intrinsics3.checkNotNullParameter(sequence, "$this$joinTo");
        Intrinsics3.checkNotNullParameter(a2, "buffer");
        Intrinsics3.checkNotNullParameter(charSequence, "separator");
        Intrinsics3.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics3.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics3.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : sequence) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            Appendable.appendElement(a2, t, function1);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> String joinToString(Sequence<? extends T> sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$joinToString");
        Intrinsics3.checkNotNullParameter(charSequence, "separator");
        Intrinsics3.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics3.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics3.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(sequence, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics3.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(sequence, charSequence, charSequence5, charSequence6, i3, charSequence7, function1);
    }

    public static final <T> T last(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$last");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T, R> Sequence<R> map(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$map");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        return new C12082u(sequence, function1);
    }

    public static final <T, R> Sequence<R> mapNotNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$mapNotNull");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        return filterNotNull(new C12082u(sequence, function1));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, T t) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$plus");
        return C12075n.flatten(C12075n.sequenceOf(sequence, C12075n.sequenceOf(t)));
    }

    public static final <T extends Comparable<? super T>> Sequence<T> sorted(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$sorted");
        return new e(sequence);
    }

    public static final <T> Sequence<T> sortedWith(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$sortedWith");
        Intrinsics3.checkNotNullParameter(comparator, "comparator");
        return new f(sequence, comparator);
    }

    public static final <T> Sequence<T> take(Sequence<? extends T> sequence, int i) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$take");
        if (i >= 0) {
            return i == 0 ? C12075n.emptySequence() : sequence instanceof InterfaceC12066e ? ((InterfaceC12066e) sequence).take(i) : new C12080s(sequence, i);
        }
        throw new IllegalArgumentException(outline.m873r("Requested element count ", i, " is less than zero.").toString());
    }

    public static final <T> Sequence<T> takeWhile(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$takeWhile");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        return new C12081t(sequence, function1);
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Sequence<? extends T> sequence, C c2) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$toCollection");
        Intrinsics3.checkNotNullParameter(c2, "destination");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    public static final <T> HashSet<T> toHashSet(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$toHashSet");
        return (HashSet) toCollection(sequence, new HashSet());
    }

    public static final <T> List<T> toList(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$toList");
        return Collections2.optimizeReadOnlyList(toMutableList(sequence));
    }

    public static final <T> List<T> toMutableList(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$toMutableList");
        return (List) toCollection(sequence, new ArrayList());
    }

    public static final <T> Set<T> toSet(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$toSet");
        return Sets5.optimizeReadOnlySet((Set) toCollection(sequence, new LinkedHashSet()));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, Iterable<? extends T> iterable) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$plus");
        Intrinsics3.checkNotNullParameter(iterable, "elements");
        return C12075n.flatten(C12075n.sequenceOf(sequence, _Collections.asSequence(iterable)));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, Sequence<? extends T> sequence2) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$plus");
        Intrinsics3.checkNotNullParameter(sequence2, "elements");
        return C12075n.flatten(C12075n.sequenceOf(sequence, sequence2));
    }
}
