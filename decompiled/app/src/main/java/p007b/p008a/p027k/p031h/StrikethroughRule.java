package p007b.p008a.p027k.p031h;

import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p027k.p029f.StrikethroughNode;
import p007b.p008a.p027k.p030g.ParseState;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.k.h.i, reason: use source file name */
/* JADX INFO: compiled from: StrikethroughRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StrikethroughRule extends Rule<RenderContext, Node<RenderContext>, ParseState> {
    public StrikethroughRule(Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RenderContext, ParseState> parse(Matcher matcher, Parser parser, ParseState parseState) {
        ParseState parseState2 = parseState;
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        Intrinsics3.checkNotNullParameter(parseState2, "state");
        Node c5655a = parseState2.f1501a ? new Node.C5655a(new Node[0]) : new StrikethroughNode();
        int iStart = matcher.start(1);
        int iEnd = matcher.end(1);
        Intrinsics3.checkNotNullParameter(c5655a, "node");
        return new ParseSpec<>(c5655a, parseState2, iStart, iEnd);
    }
}
