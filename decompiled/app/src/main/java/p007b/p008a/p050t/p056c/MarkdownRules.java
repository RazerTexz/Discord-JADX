package p007b.p008a.p050t.p056c;

import android.text.style.CharacterStyle;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import p007b.p008a.p050t.p052b.p054b.SimpleMarkdownRules5;
import p507d0.p579g0.Strings4;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MarkdownRules.kt */
/* renamed from: b.a.t.c.a, reason: use source file name */
/* loaded from: classes.dex */
public final class MarkdownRules {

    /* renamed from: a */
    public static final Pattern f1992a;

    /* renamed from: b */
    public static final Pattern f1993b;

    /* renamed from: c */
    public static final Pattern f1994c;

    /* renamed from: d */
    public static final Pattern f1995d;

    /* renamed from: e */
    public static final MarkdownRules f1996e = new MarkdownRules();

    /* compiled from: MarkdownRules.kt */
    /* renamed from: b.a.t.c.a$c */
    public static class c<R, S> extends Rule.BlockRule<R, Node<R>, S> {
        private final Function1<Integer, CharacterStyle> styleSpanProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(Pattern pattern, Function1<? super Integer, ? extends CharacterStyle> function1) {
            super(pattern);
            Intrinsics3.checkNotNullParameter(pattern, "pattern");
            Intrinsics3.checkNotNullParameter(function1, "styleSpanProvider");
            this.styleSpanProvider = function1;
        }

        public StyleNode<R, CharacterStyle> createHeaderStyleNode(String str) {
            Intrinsics3.checkNotNullParameter(str, "headerStyleGroup");
            return new StyleNode<>(CollectionsJVM.listOf(this.styleSpanProvider.invoke(Integer.valueOf(str.length()))));
        }

        public final Function1<Integer, CharacterStyle> getStyleSpanProvider() {
            return this.styleSpanProvider;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNullExpressionValue(strGroup, "matcher.group(1)");
            StyleNode<R, CharacterStyle> styleNodeCreateHeaderStyleNode = createHeaderStyleNode(strGroup);
            int iStart = matcher.start(2);
            int iEnd = matcher.end(2);
            Intrinsics3.checkNotNullParameter(styleNodeCreateHeaderStyleNode, "node");
            return new ParseSpec<>(styleNodeCreateHeaderStyleNode, s2, iStart, iEnd);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c(Function1<? super Integer, ? extends CharacterStyle> function1) {
            this(MarkdownRules.f1993b, function1);
            Intrinsics3.checkNotNullParameter(function1, "styleSpanProvider");
            MarkdownRules markdownRules = MarkdownRules.f1996e;
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("^\\*[ \\t](.*)(?=\\n|$)", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "java.util.regex.Pattern.compile(this, flags)");
        f1992a = patternCompile;
        Pattern patternCompile2 = Pattern.compile("^\\s*(#+)[ \\t](.*) *(?=\\n|$)", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile2, "java.util.regex.Pattern.compile(this, flags)");
        f1993b = patternCompile2;
        Pattern patternCompile3 = Pattern.compile("^\\s*(.+)\\n *(=|-){3,} *(?=\\n|$)", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile3, "java.util.regex.Pattern.compile(this, flags)");
        f1994c = patternCompile3;
        f1995d = new Regex("^\\s*(?:(?:(.+)(?: +\\{([\\w ]*)\\}))|(.*))[ \\t]*\\n *([=\\-]){3,}[ \\t]*(?=\\n|$)").getNativePattern();
    }

    /* compiled from: MarkdownRules.kt */
    /* renamed from: b.a.t.c.a$a */
    public static class a<RC, T, S> extends b<RC, S> {
        private final Function1<String, T> classSpanProvider;
        private final List<Rule<RC, Node<RC>, S>> innerRules;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Integer, ? extends CharacterStyle> function1, Function1<? super String, ? extends T> function12, List<? extends Rule<RC, Node<RC>, S>> list) {
            super(MarkdownRules.f1995d, function1);
            Intrinsics3.checkNotNullParameter(function1, "styleSpanProvider");
            Intrinsics3.checkNotNullParameter(function12, "classSpanProvider");
            Intrinsics3.checkNotNullParameter(list, "innerRules");
            MarkdownRules markdownRules = MarkdownRules.f1996e;
            this.classSpanProvider = function12;
            this.innerRules = list;
        }

        public final Function1<String, T> getClassSpanProvider() {
            return this.classSpanProvider;
        }

        public final List<Rule<RC, Node<RC>, S>> getInnerRules() {
            return this.innerRules;
        }

        @Override // p007b.p008a.p050t.p056c.MarkdownRules.b, p007b.p008a.p050t.p056c.MarkdownRules.c, com.discord.simpleast.core.parser.Rule
        public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
            List listEmptyList;
            String string;
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(4);
            Intrinsics3.checkNotNullExpressionValue(strGroup, "matcher.group(4)");
            StyleNode<RC, CharacterStyle> styleNodeCreateHeaderStyleNode = createHeaderStyleNode(strGroup);
            String strGroup2 = matcher.group(1);
            if (strGroup2 == null) {
                strGroup2 = matcher.group(3);
            }
            Intrinsics3.checkNotNullExpressionValue(strGroup2, "headerBody");
            for (Object obj : parser.parse(strGroup2, s2, this.innerRules)) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<RC>");
                styleNodeCreateHeaderStyleNode.addChild((Node) obj);
            }
            String strGroup3 = matcher.group(2);
            List listSplit$default = (strGroup3 == null || (string = Strings4.trim(strGroup3).toString()) == null) ? null : Strings4.split$default((CharSequence) string, new char[]{' '}, false, 0, 6, (Object) null);
            if (listSplit$default != null) {
                listEmptyList = new ArrayList();
                Iterator<T> it = listSplit$default.iterator();
                while (it.hasNext()) {
                    T tInvoke = this.classSpanProvider.invoke((String) it.next());
                    if (tInvoke != null) {
                        listEmptyList.add(tInvoke);
                    }
                }
            } else {
                listEmptyList = Collections2.emptyList();
            }
            if (!listEmptyList.isEmpty()) {
                StyleNode<RC, CharacterStyle> styleNode = new StyleNode<>(listEmptyList);
                styleNode.addChild(styleNodeCreateHeaderStyleNode);
                styleNodeCreateHeaderStyleNode = styleNode;
            }
            Intrinsics3.checkNotNullParameter(styleNodeCreateHeaderStyleNode, "node");
            return new ParseSpec<>(styleNodeCreateHeaderStyleNode, s2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Function1<? super Integer, ? extends CharacterStyle> function1, Function1<? super String, ? extends T> function12) {
            this(function1, function12, _Collections.plus((Collection<? extends Rule>) SimpleMarkdownRules5.m372b(false, false, 2), SimpleMarkdownRules5.f1988h.m374d()));
            Intrinsics3.checkNotNullParameter(function1, "styleSpanProvider");
            Intrinsics3.checkNotNullParameter(function12, "classSpanProvider");
        }
    }

    /* compiled from: MarkdownRules.kt */
    /* renamed from: b.a.t.c.a$b */
    public static class b<R, S> extends c<R, S> {
        /* JADX WARN: Illegal instructions before constructor call */
        public b(Pattern pattern, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                MarkdownRules markdownRules = MarkdownRules.f1996e;
                pattern = MarkdownRules.f1994c;
            }
            this(pattern, function1);
        }

        @Override // p007b.p008a.p050t.p056c.MarkdownRules.c
        public StyleNode<R, CharacterStyle> createHeaderStyleNode(String str) {
            Intrinsics3.checkNotNullParameter(str, "headerStyleGroup");
            return new StyleNode<>(CollectionsJVM.listOf(getStyleSpanProvider().invoke(Integer.valueOf((str.hashCode() == 61 && str.equals("=")) ? 1 : 2))));
        }

        @Override // p007b.p008a.p050t.p056c.MarkdownRules.c, com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            throw null;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Pattern pattern, Function1<? super Integer, ? extends CharacterStyle> function1) {
            super(pattern, function1);
            Intrinsics3.checkNotNullParameter(pattern, "pattern");
            Intrinsics3.checkNotNullParameter(function1, "styleSpanProvider");
        }
    }
}
