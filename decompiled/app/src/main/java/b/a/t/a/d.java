package b.a.t.a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* compiled from: CodeRules.kt */
/* loaded from: classes.dex */
public final class d<R, S> extends Rule<R, Node<R>, S> {
    public final /* synthetic */ int a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StyleNode.a f289b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Pattern pattern, int i, StyleNode.a aVar, Pattern pattern2) {
        super(pattern2);
        this.a = i;
        this.f289b = aVar;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        d0.z.d.m.checkNotNullParameter(matcher, "matcher");
        d0.z.d.m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(this.a);
        if (strGroup == null) {
            strGroup = "";
        }
        StyleNode.a aVar = this.f289b;
        Node bVar = aVar != null ? new StyleNode.b(strGroup, aVar) : new b.a.t.b.a.a(strGroup);
        d0.z.d.m.checkNotNullParameter(bVar, "node");
        return new ParseSpec<>(bVar, s2);
    }
}
