package d0.g0;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;

/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class g implements MatchResult {
    public final f a;

    /* renamed from: b, reason: collision with root package name */
    public List<String> f3582b;
    public final Matcher c;
    public final CharSequence d;

    /* compiled from: Regex.kt */
    public static final class a extends d0.t.c<String> {
        public a() {
        }

        @Override // d0.t.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return contains((String) obj);
            }
            return false;
        }

        @Override // d0.t.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i) {
            return get(i);
        }

        @Override // d0.t.a
        public int getSize() {
            return g.access$getMatchResult$p(g.this).groupCount() + 1;
        }

        @Override // d0.t.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return indexOf((String) obj);
            }
            return -1;
        }

        @Override // d0.t.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return lastIndexOf((String) obj);
            }
            return -1;
        }

        public /* bridge */ boolean contains(String str) {
            return super.contains((Object) str);
        }

        @Override // d0.t.c, java.util.List
        public String get(int i) {
            String strGroup = g.access$getMatchResult$p(g.this).group(i);
            return strGroup != null ? strGroup : "";
        }

        public /* bridge */ int indexOf(String str) {
            return super.indexOf((Object) str);
        }

        public /* bridge */ int lastIndexOf(String str) {
            return super.lastIndexOf((Object) str);
        }
    }

    /* compiled from: Regex.kt */
    public static final class b extends d0.t.a<e> implements f {

        /* compiled from: Regex.kt */
        public static final class a extends d0.z.d.o implements Function1<Integer, e> {
            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ e invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final e invoke(int i) {
                return b.this.get(i);
            }
        }

        public b() {
        }

        @Override // d0.t.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof e : true) {
                return contains((e) obj);
            }
            return false;
        }

        public e get(int i) {
            IntRange intRangeAccess$range = h.access$range(g.access$getMatchResult$p(g.this), i);
            if (intRangeAccess$range.getStart().intValue() < 0) {
                return null;
            }
            String strGroup = g.access$getMatchResult$p(g.this).group(i);
            d0.z.d.m.checkNotNullExpressionValue(strGroup, "matchResult.group(index)");
            return new e(strGroup, intRangeAccess$range);
        }

        @Override // d0.t.a
        public int getSize() {
            return g.access$getMatchResult$p(g.this).groupCount() + 1;
        }

        @Override // d0.t.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<e> iterator() {
            return d0.f0.q.map(d0.t.u.asSequence(d0.t.n.getIndices(this)), new a()).iterator();
        }

        public /* bridge */ boolean contains(e eVar) {
            return super.contains((Object) eVar);
        }
    }

    public g(Matcher matcher, CharSequence charSequence) {
        d0.z.d.m.checkNotNullParameter(matcher, "matcher");
        d0.z.d.m.checkNotNullParameter(charSequence, "input");
        this.c = matcher;
        this.d = charSequence;
        this.a = new b();
    }

    public static final java.util.regex.MatchResult access$getMatchResult$p(g gVar) {
        return gVar.c;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult.b getDestructured() {
        return MatchResult.a.getDestructured(this);
    }

    @Override // kotlin.text.MatchResult
    public List<String> getGroupValues() {
        if (this.f3582b == null) {
            this.f3582b = new a();
        }
        List<String> list = this.f3582b;
        d0.z.d.m.checkNotNull(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    public f getGroups() {
        return this.a;
    }

    @Override // kotlin.text.MatchResult
    public IntRange getRange() {
        return h.access$range(this.c);
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String strGroup = this.c.group();
        d0.z.d.m.checkNotNullExpressionValue(strGroup, "matchResult.group()");
        return strGroup;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        int iEnd = this.c.end() + (this.c.end() == this.c.start() ? 1 : 0);
        if (iEnd > this.d.length()) {
            return null;
        }
        Matcher matcher = this.c.pattern().matcher(this.d);
        d0.z.d.m.checkNotNullExpressionValue(matcher, "matcher.pattern().matcher(input)");
        return h.access$findNext(matcher, iEnd, this.d);
    }
}
