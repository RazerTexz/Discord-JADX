package p007b.p008a.p050t.p051a;

import android.text.SpannableStringBuilder;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p579g0.CharJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Xml.kt */
/* renamed from: b.a.t.a.v, reason: use source file name */
/* loaded from: classes.dex */
public final class Xml {

    /* renamed from: a */
    public static final Pattern f1973a;

    /* renamed from: b */
    public static final Pattern f1974b;

    /* renamed from: c */
    public static final Xml f1975c = new Xml();

    /* compiled from: Xml.kt */
    /* renamed from: b.a.t.a.v$a */
    public static final class a<RC> extends Node.C5655a<RC> {

        /* renamed from: a */
        public final String f1976a;

        /* renamed from: b */
        public final String f1977b;

        /* renamed from: c */
        public final CodeStyleProviders<RC> f1978c;

        /* compiled from: Xml.kt */
        /* renamed from: b.a.t.a.v$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C13217a extends FunctionReferenceImpl implements Function1<RC, Iterable<?>> {
            public C13217a(StyleNode.InterfaceC5656a interfaceC5656a) {
                super(1, interfaceC5656a, StyleNode.InterfaceC5656a.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Iterable;", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public Iterable<?> invoke(Object obj) {
                return ((StyleNode.InterfaceC5656a) this.receiver).get(obj);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, CodeStyleProviders<RC> codeStyleProviders) {
            super(new Node[0]);
            Intrinsics3.checkNotNullParameter(str, "opening");
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
            this.f1976a = str;
            this.f1977b = str2;
            this.f1978c = codeStyleProviders;
        }

        @Override // com.discord.simpleast.core.node.Node.C5655a, com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, RC rc) {
            Tuples2 tuples2M10073to;
            Intrinsics3.checkNotNullParameter(spannableStringBuilder, "builder");
            String str = this.f1976a;
            int length = str.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                }
                char cCharAt = str.charAt(i);
                if (CharJVM.isWhitespace(cCharAt) || cCharAt == '/') {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                String str2 = this.f1976a;
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                String strSubstring = str2.substring(0, i);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String str3 = this.f1976a;
                Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                String strSubstring2 = str3.substring(i);
                Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                tuples2M10073to = Tuples.m10073to(strSubstring, strSubstring2);
            } else {
                tuples2M10073to = Tuples.m10073to(this.f1976a, "");
            }
            String str4 = (String) tuples2M10073to.component1();
            String str5 = (String) tuples2M10073to.component2();
            C13217a c13217a = new C13217a(this.f1978c.f1912g);
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) ('<' + str4));
            Iterator<?> it = c13217a.invoke(rc).iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), length2, spannableStringBuilder.length(), 33);
            }
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) (str5 + '>'));
            Iterator<?> it2 = this.f1978c.f1913h.get(rc).iterator();
            while (it2.hasNext()) {
                spannableStringBuilder.setSpan(it2.next(), length3, spannableStringBuilder.length() - 1, 33);
            }
            Iterator<?> it3 = c13217a.invoke(rc).iterator();
            while (it3.hasNext()) {
                spannableStringBuilder.setSpan(it3.next(), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            }
            super.render(spannableStringBuilder, rc);
            String str6 = this.f1977b;
            if (str6 == null || str6.length() == 0) {
                return;
            }
            int length4 = spannableStringBuilder.length();
            StringBuilder sbM833U = outline.m833U("</");
            sbM833U.append(this.f1977b);
            sbM833U.append('>');
            spannableStringBuilder.append((CharSequence) sbM833U.toString());
            Iterator<?> it4 = c13217a.invoke(rc).iterator();
            while (it4.hasNext()) {
                spannableStringBuilder.setSpan(it4.next(), length4 + 1, spannableStringBuilder.length(), 33);
            }
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("^<!--[\\s\\S]*?-->", 32);
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^<!--…*?-->\"\"\", Pattern.DOTALL)");
        f1973a = patternCompile;
        Pattern patternCompile2 = Pattern.compile("^<([\\s\\S]+?)(?:>(.*?)<\\/([\\s\\S]+?))?>", 32);
        Intrinsics3.checkNotNullExpressionValue(patternCompile2, "Pattern.compile(\n      \"…?))?>\"\"\", Pattern.DOTALL)");
        f1974b = patternCompile2;
    }
}
