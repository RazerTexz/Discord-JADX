package kotlin.text;

import b.d.b.a.a;
import d0.f0.n;
import d0.g0.h;
import d0.g0.i;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;

/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class Regex implements Serializable {

    /* renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Set<? extends i> _options;
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    /* renamed from: kotlin.text.Regex$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final int access$ensureUnicodeCase(Companion companion, int i) {
            Objects.requireNonNull(companion);
            return (i & 2) != 0 ? i | 64 : i;
        }

        public final String escape(String str) {
            m.checkNotNullParameter(str, "literal");
            String strQuote = Pattern.quote(str);
            m.checkNotNullExpressionValue(strQuote, "Pattern.quote(literal)");
            return strQuote;
        }
    }

    /* compiled from: Regex.kt */
    public static final class b implements Serializable {
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* compiled from: Regex.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        static {
            new a(null);
        }

        public b(String str, int i) {
            m.checkNotNullParameter(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern, flags)");
            return new Regex(patternCompile);
        }
    }

    /* compiled from: Regex.kt */
    public static final class c extends o implements Function0<MatchResult> {
        public final /* synthetic */ CharSequence $input;
        public final /* synthetic */ int $startIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CharSequence charSequence, int i) {
            super(0);
            this.$input = charSequence;
            this.$startIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ MatchResult invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MatchResult invoke2() {
            return Regex.this.find(this.$input, this.$startIndex);
        }
    }

    /* compiled from: Regex.kt */
    public static final /* synthetic */ class d extends k implements Function1<MatchResult, MatchResult> {
        public static final d j = new d();

        public d() {
            super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ MatchResult invoke(MatchResult matchResult) {
            return invoke2(matchResult);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MatchResult invoke2(MatchResult matchResult) {
            m.checkNotNullParameter(matchResult, "p1");
            return matchResult.next();
        }
    }

    public Regex(Pattern pattern) {
        m.checkNotNullParameter(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        m.checkNotNullExpressionValue(strPattern, "nativePattern.pattern()");
        return new b(strPattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence input) {
        m.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final MatchResult find(CharSequence input, int startIndex) {
        m.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        m.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return h.access$findNext(matcher, startIndex, input);
    }

    public final Sequence<MatchResult> findAll(CharSequence input, int startIndex) {
        m.checkNotNullParameter(input, "input");
        if (startIndex >= 0 && startIndex <= input.length()) {
            return n.generateSequence((Function0) new c(input, startIndex), (Function1) d.j);
        }
        StringBuilder sbV = a.V("Start index out of bounds: ", startIndex, ", input length: ");
        sbV.append(input.length());
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final MatchResult matchEntire(CharSequence input) {
        m.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        m.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return h.access$matchEntire(matcher, input);
    }

    public final boolean matches(CharSequence input) {
        m.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final String replace(CharSequence input, String replacement) {
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(replacement, "replacement");
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        m.checkNotNullExpressionValue(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    /* renamed from: toPattern, reason: from getter */
    public final Pattern getNativePattern() {
        return this.nativePattern;
    }

    public String toString() {
        String string = this.nativePattern.toString();
        m.checkNotNullExpressionValue(string, "nativePattern.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str) {
        m.checkNotNullParameter(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern)");
        this(patternCompile);
    }

    public final String replace(CharSequence input, Function1<? super MatchResult, ? extends CharSequence> transform) {
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(transform, "transform");
        int iIntValue = 0;
        MatchResult matchResultFind$default = find$default(this, input, 0, 2, null);
        if (matchResultFind$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            m.checkNotNull(matchResultFind$default);
            sb.append(input, iIntValue, matchResultFind$default.getRange().getStart().intValue());
            sb.append(transform.invoke(matchResultFind$default));
            iIntValue = matchResultFind$default.getRange().getEndInclusive().intValue() + 1;
            matchResultFind$default = matchResultFind$default.next();
            if (iIntValue >= length) {
                break;
            }
        } while (matchResultFind$default != null);
        if (iIntValue < length) {
            sb.append(input, iIntValue, length);
        }
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str, i iVar) {
        m.checkNotNullParameter(str, "pattern");
        m.checkNotNullParameter(iVar, "option");
        Pattern patternCompile = Pattern.compile(str, Companion.access$ensureUnicodeCase(INSTANCE, iVar.getValue()));
        m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern,…nicodeCase(option.value))");
        this(patternCompile);
    }
}
