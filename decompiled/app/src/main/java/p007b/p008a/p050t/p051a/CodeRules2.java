package p007b.p008a.p050t.p051a;

import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* compiled from: CodeRules.kt */
/* renamed from: b.a.t.a.b, reason: use source file name */
/* loaded from: classes.dex */
public final class CodeRules2<R, S> extends Rule<R, Node<R>, S> {

    /* renamed from: a */
    public final /* synthetic */ CodeStyleProviders f1894a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeRules2(CodeStyleProviders codeStyleProviders, String[] strArr, Pattern pattern) {
        super(pattern);
        this.f1894a = codeStyleProviders;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        Intrinsics3.checkNotNull(strGroup);
        String strGroup2 = matcher.group(2);
        Intrinsics3.checkNotNull(strGroup2);
        CodeNode.C5654b c5654b = new CodeNode.C5654b(strGroup, strGroup2, this.f1894a);
        Intrinsics3.checkNotNullParameter(c5654b, "node");
        return new ParseSpec<>(c5654b, s2);
    }
}
