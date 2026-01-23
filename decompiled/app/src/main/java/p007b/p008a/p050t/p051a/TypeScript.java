package p007b.p008a.p050t.p051a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p050t.p051a.TypeScript2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: Add missing generic type declarations: [RC, S] */
/* JADX INFO: renamed from: b.a.t.a.q, reason: use source file name */
/* JADX INFO: compiled from: TypeScript.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TypeScript<RC, S> extends Rule<RC, Node<RC>, S> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CodeStyleProviders f1954a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeScript(TypeScript2.a.C13216a c13216a, CodeStyleProviders codeStyleProviders, Pattern pattern) {
        super(pattern);
        this.f1954a = codeStyleProviders;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        String strGroup3 = matcher.group(3);
        Intrinsics3.checkNotNull(strGroup);
        Intrinsics3.checkNotNull(strGroup2);
        TypeScript2.a aVar = new TypeScript2.a(strGroup, strGroup2, strGroup3, this.f1954a);
        Intrinsics3.checkNotNullParameter(aVar, "node");
        return new ParseSpec<>(aVar, s2);
    }
}
