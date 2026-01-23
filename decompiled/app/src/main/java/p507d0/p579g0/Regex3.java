package p507d0.p579g0;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.Ranges2;
import kotlin.text.MatchResult;
import p507d0.p578f0._Sequences2;
import p507d0.p580t.AbstractCollection;
import p507d0.p580t.AbstractList;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.g0.g, reason: use source file name */
/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Regex3 implements MatchResult {

    /* JADX INFO: renamed from: a */
    public final MatchResult2 f25152a;

    /* JADX INFO: renamed from: b */
    public List<String> f25153b;

    /* JADX INFO: renamed from: c */
    public final Matcher f25154c;

    /* JADX INFO: renamed from: d */
    public final CharSequence f25155d;

    /* JADX INFO: renamed from: d0.g0.g$a */
    /* JADX INFO: compiled from: Regex.kt */
    public static final class a extends AbstractList<String> {
        public a() {
        }

        @Override // p507d0.p580t.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return contains((String) obj);
            }
            return false;
        }

        @Override // p507d0.p580t.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i) {
            return get(i);
        }

        @Override // p507d0.p580t.AbstractCollection
        public int getSize() {
            return Regex3.access$getMatchResult$p(Regex3.this).groupCount() + 1;
        }

        @Override // p507d0.p580t.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return indexOf((String) obj);
            }
            return -1;
        }

        @Override // p507d0.p580t.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return lastIndexOf((String) obj);
            }
            return -1;
        }

        public /* bridge */ boolean contains(String str) {
            return super.contains((Object) str);
        }

        @Override // p507d0.p580t.AbstractList, java.util.List
        public String get(int i) {
            String strGroup = Regex3.access$getMatchResult$p(Regex3.this).group(i);
            return strGroup != null ? strGroup : "";
        }

        public /* bridge */ int indexOf(String str) {
            return super.indexOf((Object) str);
        }

        public /* bridge */ int lastIndexOf(String str) {
            return super.lastIndexOf((Object) str);
        }
    }

    /* JADX INFO: renamed from: d0.g0.g$b */
    /* JADX INFO: compiled from: Regex.kt */
    public static final class b extends AbstractCollection<Regex2> implements MatchResult2 {

        /* JADX INFO: renamed from: d0.g0.g$b$a */
        /* JADX INFO: compiled from: Regex.kt */
        public static final class a extends Lambda implements Function1<Integer, Regex2> {
            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Regex2 invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Regex2 invoke(int i) {
                return b.this.get(i);
            }
        }

        public b() {
        }

        @Override // p507d0.p580t.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof Regex2 : true) {
                return contains((Regex2) obj);
            }
            return false;
        }

        public Regex2 get(int i) {
            Ranges2 ranges2Access$range = Regex4.access$range(Regex3.access$getMatchResult$p(Regex3.this), i);
            if (ranges2Access$range.getStart().intValue() < 0) {
                return null;
            }
            String strGroup = Regex3.access$getMatchResult$p(Regex3.this).group(i);
            Intrinsics3.checkNotNullExpressionValue(strGroup, "matchResult.group(index)");
            return new Regex2(strGroup, ranges2Access$range);
        }

        @Override // p507d0.p580t.AbstractCollection
        public int getSize() {
            return Regex3.access$getMatchResult$p(Regex3.this).groupCount() + 1;
        }

        @Override // p507d0.p580t.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<Regex2> iterator() {
            return _Sequences2.map(_Collections.asSequence(Collections2.getIndices(this)), new a()).iterator();
        }

        public /* bridge */ boolean contains(Regex2 regex2) {
            return super.contains((Object) regex2);
        }
    }

    public Regex3(Matcher matcher, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(charSequence, "input");
        this.f25154c = matcher;
        this.f25155d = charSequence;
        this.f25152a = new b();
    }

    public static final java.util.regex.MatchResult access$getMatchResult$p(Regex3 regex3) {
        return regex3.f25154c;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult.C12798b getDestructured() {
        return MatchResult.C12797a.getDestructured(this);
    }

    @Override // kotlin.text.MatchResult
    public List<String> getGroupValues() {
        if (this.f25153b == null) {
            this.f25153b = new a();
        }
        List<String> list = this.f25153b;
        Intrinsics3.checkNotNull(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult2 getGroups() {
        return this.f25152a;
    }

    @Override // kotlin.text.MatchResult
    public Ranges2 getRange() {
        return Regex4.access$range(this.f25154c);
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String strGroup = this.f25154c.group();
        Intrinsics3.checkNotNullExpressionValue(strGroup, "matchResult.group()");
        return strGroup;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        int iEnd = this.f25154c.end() + (this.f25154c.end() == this.f25154c.start() ? 1 : 0);
        if (iEnd > this.f25155d.length()) {
            return null;
        }
        Matcher matcher = this.f25154c.pattern().matcher(this.f25155d);
        Intrinsics3.checkNotNullExpressionValue(matcher, "matcher.pattern().matcher(input)");
        return Regex4.access$findNext(matcher, iEnd, this.f25155d);
    }
}
