package p507d0.p579g0;

import kotlin.text.Regex;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: StringNumberConversionsJVM.kt */
/* renamed from: d0.g0.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class StringNumberConversionsJVM {

    /* renamed from: a */
    public static final Regex f25162a;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append("(\\p{Digit}+)");
        sb.append("(\\.)?(");
        sb.append("(\\p{Digit}+)");
        sb.append("?)(");
        outline.m876s0(sb, "[eE][+-]?(\\p{Digit}+)", ")?)|", "(\\.(", "(\\p{Digit}+)");
        outline.m876s0(sb, ")(", "[eE][+-]?(\\p{Digit}+)", ")?)|", "((");
        sb.append("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))");
        sb.append(")[pP][+-]?");
        sb.append("(\\p{Digit}+)");
        sb.append(')');
        f25162a = new Regex(outline.m886y("[\\x00-\\x20]*[+-]?(NaN|Infinity|((", sb.toString(), ")[fFdD]?))[\\x00-\\x20]*"));
    }
}
