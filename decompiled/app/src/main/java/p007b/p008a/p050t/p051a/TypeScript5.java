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
/* JADX INFO: renamed from: b.a.t.a.u, reason: use source file name */
/* JADX INFO: compiled from: TypeScript.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TypeScript5<RC, S> extends Rule<RC, Node<RC>, S> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CodeStyleProviders f1972a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeScript5(TypeScript2.d.a aVar, CodeStyleProviders codeStyleProviders, Pattern pattern) {
        super(pattern);
        this.f1972a = codeStyleProviders;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        String strGroup3 = matcher.group(3);
        String strGroup4 = matcher.group(4);
        Intrinsics3.checkNotNull(strGroup);
        Intrinsics3.checkNotNull(strGroup3);
        Intrinsics3.checkNotNull(strGroup4);
        TypeScript2.d dVar = new TypeScript2.d(strGroup, strGroup2, strGroup3, strGroup4, this.f1972a);
        Intrinsics3.checkNotNullParameter(dVar, "node");
        return new ParseSpec<>(dVar, s2);
    }
}
