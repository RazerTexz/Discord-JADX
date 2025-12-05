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
/* compiled from: HookRule.kt */
/* renamed from: b.a.k.h.f, reason: use source file name */
/* loaded from: classes.dex */
public final class HookRule<S> extends Rule<RenderContext, HookNode2, S> {
    public HookRule(Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RenderContext, S> parse(Matcher matcher, Parser<RenderContext, ? super HookNode2, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(2);
        Intrinsics3.checkNotNull(strGroup);
        if (matcher.start(1) == matcher.end(1)) {
            HookNode2 hookNode2 = new HookNode2(strGroup);
            Intrinsics3.checkNotNullParameter(hookNode2, "node");
            return new ParseSpec<>(hookNode2, s2);
        }
        HookNode2 hookNode22 = new HookNode2(strGroup);
        int iStart = matcher.start(1);
        int iEnd = matcher.end(1);
        Intrinsics3.checkNotNullParameter(hookNode22, "node");
        return new ParseSpec<>(hookNode22, s2, iStart, iEnd);
    }
}
