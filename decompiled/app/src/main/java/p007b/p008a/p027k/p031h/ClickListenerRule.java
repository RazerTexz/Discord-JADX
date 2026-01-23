package p007b.p008a.p027k.p031h;

import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p027k.p029f.HookNode2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: renamed from: b.a.k.h.d, reason: use source file name */
/* JADX INFO: compiled from: ClickListenerRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ClickListenerRule<S> extends Rule<RenderContext, HookNode2, S> {
    public ClickListenerRule(Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RenderContext, S> parse(Matcher matcher, Parser<RenderContext, ? super HookNode2, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(2);
        Intrinsics3.checkNotNull(strGroup);
        HookNode2 hookNode2 = new HookNode2(strGroup);
        int iStart = matcher.start(1);
        int iEnd = matcher.end(1);
        Intrinsics3.checkNotNullParameter(hookNode2, "node");
        return new ParseSpec<>(hookNode2, s2, iStart, iEnd);
    }
}
