package p007b.p008a.p050t.p052b.p054b;

import android.text.style.CharacterStyle;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p050t.p052b.p053a.TextNode;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.t.b.b.e, reason: use source file name */
/* JADX INFO: compiled from: SimpleMarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleMarkdownRules5 {

    /* JADX INFO: renamed from: h */
    public static final SimpleMarkdownRules5 f1988h = new SimpleMarkdownRules5();

    /* JADX INFO: renamed from: a */
    public static final Pattern f1981a = Pattern.compile("^\\*\\*([\\s\\S]+?)\\*\\*(?!\\*)");

    /* JADX INFO: renamed from: b */
    public static final Pattern f1982b = Pattern.compile("^__([\\s\\S]+?)__(?!_)");

    /* JADX INFO: renamed from: c */
    public static final Pattern f1983c = Pattern.compile("^~~(?=\\S)([\\s\\S]*?\\S)~~");

    /* JADX INFO: renamed from: d */
    public static final Pattern f1984d = Pattern.compile("^(?:\\n *)*\\n");

    /* JADX INFO: renamed from: e */
    public static final Pattern f1985e = Pattern.compile("^[\\s\\S]+?(?=[^0-9A-Za-z\\s\\u00c0-\\uffff]|\\n| {2,}\\n|\\w+:\\S|$)");

    /* JADX INFO: renamed from: f */
    public static final Pattern f1986f = Pattern.compile("^\\\\([^0-9A-Za-z\\s])");

    /* JADX INFO: renamed from: g */
    public static final Pattern f1987g = Pattern.compile("^\\b_((?:__|\\\\[\\s\\S]|[^\\\\_])+?)_\\b|^\\*(?=\\S)((?:\\*\\*|\\s+(?:[^*\\s]|\\*\\*)|[^\\s*])+?)\\*(?!\\*)");

    /* JADX INFO: Add missing generic type declarations: [R, S] */
    /* JADX INFO: renamed from: b.a.t.b.b.e$a */
    /* JADX INFO: compiled from: SimpleMarkdownRules.kt */
    public static final class a<R, S> extends Rule<R, Node<R>, S> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Function0 f1989a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0 function0, Pattern pattern, Pattern pattern2) {
            super(pattern2);
            this.f1989a = function0;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            StyleNode styleNode = new StyleNode((List) this.f1989a.invoke());
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            Intrinsics3.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, s2, iStart, iEnd);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, S] */
    /* JADX INFO: renamed from: b.a.t.b.b.e$b */
    /* JADX INFO: compiled from: SimpleMarkdownRules.kt */
    public static final class b<R, S> extends Rule<R, Node<R>, S> {
        public b(SimpleMarkdownRules5 simpleMarkdownRules5, Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group();
            Intrinsics3.checkNotNullExpressionValue(strGroup, "matcher.group()");
            TextNode textNode = new TextNode(strGroup);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, s2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final <R, S> List<Rule<R, Node<R>, S>> m371a(boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList();
        if (z3) {
            SimpleMarkdownRules5 simpleMarkdownRules5 = f1988h;
            Pattern pattern = f1986f;
            Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_ESCAPE");
            arrayList.add(new SimpleMarkdownRules2(simpleMarkdownRules5, pattern));
        }
        SimpleMarkdownRules5 simpleMarkdownRules52 = f1988h;
        Pattern pattern2 = f1984d;
        Intrinsics3.checkNotNullExpressionValue(pattern2, "PATTERN_NEWLINE");
        arrayList.add(new SimpleMarkdownRules4(simpleMarkdownRules52, pattern2));
        Pattern pattern3 = f1981a;
        Intrinsics3.checkNotNullExpressionValue(pattern3, "PATTERN_BOLD");
        arrayList.add(m373c(pattern3, SimpleMarkdownRules.f1980j));
        Pattern pattern4 = f1982b;
        Intrinsics3.checkNotNullExpressionValue(pattern4, "PATTERN_UNDERLINE");
        arrayList.add(m373c(pattern4, SimpleMarkdownRules7.f1991j));
        Pattern pattern5 = f1987g;
        Intrinsics3.checkNotNullExpressionValue(pattern5, "PATTERN_ITALICS");
        arrayList.add(new SimpleMarkdownRules3(simpleMarkdownRules52, pattern5));
        Pattern pattern6 = f1983c;
        Intrinsics3.checkNotNullExpressionValue(pattern6, "PATTERN_STRIKETHRU");
        arrayList.add(m373c(pattern6, SimpleMarkdownRules6.f1990j));
        if (z2) {
            arrayList.add(simpleMarkdownRules52.m374d());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ List m372b(boolean z2, boolean z3, int i) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        return m371a(z2, z3);
    }

    /* JADX INFO: renamed from: c */
    public static final <R, S> Rule<R, Node<R>, S> m373c(Pattern pattern, Function0<? extends List<? extends CharacterStyle>> function0) {
        Intrinsics3.checkNotNullParameter(pattern, "pattern");
        Intrinsics3.checkNotNullParameter(function0, "styleFactory");
        return new a(function0, pattern, pattern);
    }

    /* JADX INFO: renamed from: d */
    public final <R, S> Rule<R, Node<R>, S> m374d() {
        Pattern pattern = f1985e;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_TEXT");
        return new b(this, pattern);
    }
}
