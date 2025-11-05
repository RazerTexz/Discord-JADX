package b.a.t.a;

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

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* compiled from: CodeRules.kt */
/* loaded from: classes.dex */
public final class c<R, S> extends Rule<R, Node<R>, S> {
    public final /* synthetic */ StyleNode.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StyleNode.a f288b;

    /* compiled from: CodeRules.kt */
    public static final class a extends Node.a<R> {
        public a(CodeNode codeNode, Node[] nodeArr) {
            super(nodeArr);
        }

        @Override // com.discord.simpleast.core.node.Node.a, com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, R r) {
            d0.z.d.m.checkNotNullParameter(spannableStringBuilder, "builder");
            int length = spannableStringBuilder.length();
            super.render(spannableStringBuilder, r);
            Iterator<?> it = c.this.f288b.get(r).iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), length, spannableStringBuilder.length(), 33);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, StyleNode.a aVar, StyleNode.a aVar2, Pattern pattern) {
        super(pattern);
        this.a = aVar;
        this.f288b = aVar2;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        d0.z.d.m.checkNotNullParameter(matcher, "matcher");
        d0.z.d.m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(2);
        if (strGroup == null) {
            strGroup = "";
        }
        if (!(strGroup.length() == 0)) {
            CodeNode codeNode = new CodeNode(new CodeNode.a.b(strGroup), null, this.a);
            a aVar = new a(codeNode, new Node[]{codeNode});
            d0.z.d.m.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, s2);
        }
        String strGroup2 = matcher.group();
        d0.z.d.m.checkNotNullExpressionValue(strGroup2, "matcher.group()");
        b.a.t.b.a.a aVar2 = new b.a.t.b.a.a(strGroup2);
        d0.z.d.m.checkNotNullParameter(aVar2, "node");
        return new ParseSpec<>(aVar2, s2);
    }
}
