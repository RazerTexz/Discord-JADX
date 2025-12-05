package p007b.p008a.p027k.p030g;

import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import java.util.regex.Pattern;
import p007b.p008a.p027k.p031h.BangEscapeRule;
import p007b.p008a.p027k.p031h.BangEscapeRule2;
import p007b.p008a.p027k.p031h.BoldRule;
import p007b.p008a.p027k.p031h.ClickListenerRule;
import p007b.p008a.p027k.p031h.ClickListenerRule2;
import p007b.p008a.p027k.p031h.HookRule;
import p007b.p008a.p027k.p031h.HookRule2;
import p007b.p008a.p027k.p031h.ItalicsRule;
import p007b.p008a.p027k.p031h.StrikethroughRule;
import p007b.p008a.p050t.p052b.p054b.SimpleMarkdownRules5;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: FormattingParser.kt */
/* renamed from: b.a.k.g.a, reason: use source file name */
/* loaded from: classes.dex */
public final class FormattingParser extends Parser<RenderContext, Node<RenderContext>, ParseState> {
    public FormattingParser() {
        super(false, 1, null);
        Pattern pattern = BangEscapeRule2.f1507a;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_BANG_ESCAPE");
        addRule(new BangEscapeRule(pattern));
        Pattern pattern2 = HookRule2.f1509a;
        Intrinsics3.checkNotNullExpressionValue(pattern2, "PATTERN_HOOK");
        addRule(new HookRule(pattern2));
        Pattern pattern3 = ClickListenerRule2.f1508a;
        Intrinsics3.checkNotNullExpressionValue(pattern3, "PATTERN_CLICK_LISTENER");
        addRule(new ClickListenerRule(pattern3));
        SimpleMarkdownRules5 simpleMarkdownRules5 = SimpleMarkdownRules5.f1988h;
        Pattern pattern4 = SimpleMarkdownRules5.f1981a;
        Intrinsics3.checkNotNullExpressionValue(pattern4, "SimpleMarkdownRules.PATTERN_BOLD");
        addRule(new BoldRule(pattern4));
        Pattern pattern5 = SimpleMarkdownRules5.f1987g;
        Intrinsics3.checkNotNullExpressionValue(pattern5, "SimpleMarkdownRules.PATTERN_ITALICS");
        addRule(new ItalicsRule(pattern5));
        Pattern pattern6 = SimpleMarkdownRules5.f1983c;
        Intrinsics3.checkNotNullExpressionValue(pattern6, "SimpleMarkdownRules.PATTERN_STRIKETHRU");
        addRule(new StrikethroughRule(pattern6));
        addRule(simpleMarkdownRules5.m374d());
    }
}
