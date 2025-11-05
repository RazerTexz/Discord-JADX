package b.a.t.b.b;

import android.text.style.CharacterStyle;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;

/* compiled from: SimpleMarkdownRules.kt */
/* loaded from: classes.dex */
public final class e {
    public static final e h = new e();
    public static final Pattern a = Pattern.compile("^\\*\\*([\\s\\S]+?)\\*\\*(?!\\*)");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f308b = Pattern.compile("^__([\\s\\S]+?)__(?!_)");
    public static final Pattern c = Pattern.compile("^~~(?=\\S)([\\s\\S]*?\\S)~~");
    public static final Pattern d = Pattern.compile("^(?:\\n *)*\\n");
    public static final Pattern e = Pattern.compile("^[\\s\\S]+?(?=[^0-9A-Za-z\\s\\u00c0-\\uffff]|\\n| {2,}\\n|\\w+:\\S|$)");
    public static final Pattern f = Pattern.compile("^\\\\([^0-9A-Za-z\\s])");
    public static final Pattern g = Pattern.compile("^\\b_((?:__|\\\\[\\s\\S]|[^\\\\_])+?)_\\b|^\\*(?=\\S)((?:\\*\\*|\\s+(?:[^*\\s]|\\*\\*)|[^\\s*])+?)\\*(?!\\*)");

    /* JADX INFO: Add missing generic type declarations: [R, S] */
    /* compiled from: SimpleMarkdownRules.kt */
    public static final class a<R, S> extends Rule<R, Node<R>, S> {
        public final /* synthetic */ Function0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0 function0, Pattern pattern, Pattern pattern2) {
            super(pattern2);
            this.a = function0;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            StyleNode styleNode = new StyleNode((List) this.a.invoke());
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            m.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, s2, iStart, iEnd);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, S] */
    /* compiled from: SimpleMarkdownRules.kt */
    public static final class b<R, S> extends Rule<R, Node<R>, S> {
        public b(e eVar, Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group();
            m.checkNotNullExpressionValue(strGroup, "matcher.group()");
            b.a.t.b.a.a aVar = new b.a.t.b.a.a(strGroup);
            m.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, s2);
        }
    }

    public static final <R, S> List<Rule<R, Node<R>, S>> a(boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList();
        if (z3) {
            e eVar = h;
            Pattern pattern = f;
            m.checkNotNullExpressionValue(pattern, "PATTERN_ESCAPE");
            arrayList.add(new b.a.t.b.b.b(eVar, pattern));
        }
        e eVar2 = h;
        Pattern pattern2 = d;
        m.checkNotNullExpressionValue(pattern2, "PATTERN_NEWLINE");
        arrayList.add(new d(eVar2, pattern2));
        Pattern pattern3 = a;
        m.checkNotNullExpressionValue(pattern3, "PATTERN_BOLD");
        arrayList.add(c(pattern3, b.a.t.b.b.a.j));
        Pattern pattern4 = f308b;
        m.checkNotNullExpressionValue(pattern4, "PATTERN_UNDERLINE");
        arrayList.add(c(pattern4, g.j));
        Pattern pattern5 = g;
        m.checkNotNullExpressionValue(pattern5, "PATTERN_ITALICS");
        arrayList.add(new c(eVar2, pattern5));
        Pattern pattern6 = c;
        m.checkNotNullExpressionValue(pattern6, "PATTERN_STRIKETHRU");
        arrayList.add(c(pattern6, f.j));
        if (z2) {
            arrayList.add(eVar2.d());
        }
        return arrayList;
    }

    public static /* synthetic */ List b(boolean z2, boolean z3, int i) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        return a(z2, z3);
    }

    public static final <R, S> Rule<R, Node<R>, S> c(Pattern pattern, Function0<? extends List<? extends CharacterStyle>> function0) {
        m.checkNotNullParameter(pattern, "pattern");
        m.checkNotNullParameter(function0, "styleFactory");
        return new a(function0, pattern, pattern);
    }

    public final <R, S> Rule<R, Node<R>, S> d() {
        Pattern pattern = e;
        m.checkNotNullExpressionValue(pattern, "PATTERN_TEXT");
        return new b(this, pattern);
    }
}
