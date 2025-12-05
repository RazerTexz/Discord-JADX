package p007b.p008a.p050t.p051a;

import android.text.SpannableStringBuilder;
import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p050t.p052b.p053a.TextNode;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* compiled from: CodeRules.kt */
/* renamed from: b.a.t.a.c, reason: use source file name */
/* loaded from: classes.dex */
public final class CodeRules3<R, S> extends Rule<R, Node<R>, S> {

    /* renamed from: a */
    public final /* synthetic */ StyleNode.InterfaceC5656a f1895a;

    /* renamed from: b */
    public final /* synthetic */ StyleNode.InterfaceC5656a f1896b;

    /* compiled from: CodeRules.kt */
    /* renamed from: b.a.t.a.c$a */
    public static final class a extends Node.C5655a<R> {
        public a(CodeNode codeNode, Node[] nodeArr) {
            super(nodeArr);
        }

        @Override // com.discord.simpleast.core.node.Node.C5655a, com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, R r) {
            Intrinsics3.checkNotNullParameter(spannableStringBuilder, "builder");
            int length = spannableStringBuilder.length();
            super.render(spannableStringBuilder, r);
            Iterator<?> it = CodeRules3.this.f1896b.get(r).iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), length, spannableStringBuilder.length(), 33);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeRules3(CodeRules5 codeRules5, StyleNode.InterfaceC5656a interfaceC5656a, StyleNode.InterfaceC5656a interfaceC5656a2, Pattern pattern) {
        super(pattern);
        this.f1895a = interfaceC5656a;
        this.f1896b = interfaceC5656a2;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(2);
        if (strGroup == null) {
            strGroup = "";
        }
        if (!(strGroup.length() == 0)) {
            CodeNode codeNode = new CodeNode(new CodeNode.AbstractC5653a.b(strGroup), null, this.f1895a);
            a aVar = new a(codeNode, new Node[]{codeNode});
            Intrinsics3.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, s2);
        }
        String strGroup2 = matcher.group();
        Intrinsics3.checkNotNullExpressionValue(strGroup2, "matcher.group()");
        TextNode textNode = new TextNode(strGroup2);
        Intrinsics3.checkNotNullParameter(textNode, "node");
        return new ParseSpec<>(textNode, s2);
    }
}
