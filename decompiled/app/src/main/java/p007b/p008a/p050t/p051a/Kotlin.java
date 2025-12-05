package p007b.p008a.p050t.p051a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p050t.p051a.Kotlin2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: Add missing generic type declarations: [RC, S] */
/* compiled from: Kotlin.kt */
/* renamed from: b.a.t.a.n, reason: use source file name */
/* loaded from: classes.dex */
public final class Kotlin<RC, S> extends Rule<RC, Node<RC>, S> {

    /* renamed from: a */
    public final /* synthetic */ CodeStyleProviders f1942a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Kotlin(Kotlin2.a.C13215a c13215a, CodeStyleProviders codeStyleProviders, Pattern pattern) {
        super(pattern);
        this.f1942a = codeStyleProviders;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        Intrinsics3.checkNotNull(strGroup);
        Intrinsics3.checkNotNull(strGroup2);
        Kotlin2.a aVar = new Kotlin2.a(strGroup, strGroup2, this.f1942a);
        Intrinsics3.checkNotNullParameter(aVar, "node");
        return new ParseSpec<>(aVar, s2);
    }
}
