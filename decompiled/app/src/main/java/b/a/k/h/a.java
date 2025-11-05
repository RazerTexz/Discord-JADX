package b.a.k.h;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: BangEscapeRule.kt */
/* loaded from: classes.dex */
public final class a<T> extends Rule<T, Node<T>, b.a.k.g.c> {
    public a(Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec parse(Matcher matcher, Parser parser, b.a.k.g.c cVar) {
        b.a.k.g.c cVar2 = cVar;
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        m.checkNotNullParameter(cVar2, "state");
        b.a.k.g.c cVar3 = new b.a.k.g.c(true, cVar2.f246b);
        Node.a aVar = new Node.a(new Node[0]);
        int iStart = matcher.start(1);
        int iEnd = matcher.end(1);
        m.checkNotNullParameter(aVar, "node");
        return new ParseSpec(aVar, cVar3, iStart, iEnd);
    }
}
