package p007b.p008a.p027k.p031h;

import android.text.style.StyleSpan;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p027k.p030g.ParseState;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ItalicsRule.kt */
/* renamed from: b.a.k.h.h, reason: use source file name */
/* loaded from: classes.dex */
public final class ItalicsRule<T> extends Rule<T, Node<T>, ParseState> {
    public ItalicsRule(Pattern pattern) {
        super(pattern);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    @Override // com.discord.simpleast.core.parser.Rule
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ParseSpec parse(Matcher matcher, Parser parser, ParseState parseState) {
        int iStart;
        int iEnd;
        ParseState parseState2 = parseState;
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        Intrinsics3.checkNotNullParameter(parseState2, "state");
        Node c5655a = parseState2.f1501a ? new Node.C5655a(new Node[0]) : new StyleNode(CollectionsJVM.listOf(new StyleSpan(2)));
        String strGroup = matcher.group(2);
        if (strGroup == null) {
            iStart = matcher.start(1);
            iEnd = matcher.end(1);
        } else {
            if (strGroup.length() > 0) {
                iStart = matcher.start(2);
                iEnd = matcher.end(2);
            }
        }
        Intrinsics3.checkNotNullParameter(c5655a, "node");
        return new ParseSpec(c5655a, parseState2, iStart, iEnd);
    }
}
