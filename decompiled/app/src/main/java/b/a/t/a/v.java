package b.a.t.a;

import android.text.SpannableStringBuilder;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* compiled from: Xml.kt */
/* loaded from: classes.dex */
public final class v {
    public static final Pattern a;

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f306b;
    public static final v c = new v();

    /* compiled from: Xml.kt */
    public static final class a<RC> extends Node.a<RC> {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final String f307b;
        public final f<RC> c;

        /* compiled from: Xml.kt */
        /* renamed from: b.a.t.a.v$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0054a extends d0.z.d.k implements Function1<RC, Iterable<?>> {
            public C0054a(StyleNode.a aVar) {
                super(1, aVar, StyleNode.a.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Iterable;", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public Iterable<?> invoke(Object obj) {
                return ((StyleNode.a) this.receiver).get(obj);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, f<RC> fVar) {
            super(new Node[0]);
            d0.z.d.m.checkNotNullParameter(str, "opening");
            d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
            this.a = str;
            this.f307b = str2;
            this.c = fVar;
        }

        @Override // com.discord.simpleast.core.node.Node.a, com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, RC rc) {
            Pair pair;
            d0.z.d.m.checkNotNullParameter(spannableStringBuilder, "builder");
            String str = this.a;
            int length = str.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                }
                char cCharAt = str.charAt(i);
                if (d0.g0.a.isWhitespace(cCharAt) || cCharAt == '/') {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                String str2 = this.a;
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                String strSubstring = str2.substring(0, i);
                d0.z.d.m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String str3 = this.a;
                Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                String strSubstring2 = str3.substring(i);
                d0.z.d.m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                pair = d0.o.to(strSubstring, strSubstring2);
            } else {
                pair = d0.o.to(this.a, "");
            }
            String str4 = (String) pair.component1();
            String str5 = (String) pair.component2();
            C0054a c0054a = new C0054a(this.c.g);
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) ('<' + str4));
            Iterator<?> it = c0054a.invoke(rc).iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), length2, spannableStringBuilder.length(), 33);
            }
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) (str5 + '>'));
            Iterator<?> it2 = this.c.h.get(rc).iterator();
            while (it2.hasNext()) {
                spannableStringBuilder.setSpan(it2.next(), length3, spannableStringBuilder.length() - 1, 33);
            }
            Iterator<?> it3 = c0054a.invoke(rc).iterator();
            while (it3.hasNext()) {
                spannableStringBuilder.setSpan(it3.next(), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            }
            super.render(spannableStringBuilder, rc);
            String str6 = this.f307b;
            if (str6 == null || str6.length() == 0) {
                return;
            }
            int length4 = spannableStringBuilder.length();
            StringBuilder sbU = b.d.b.a.a.U("</");
            sbU.append(this.f307b);
            sbU.append('>');
            spannableStringBuilder.append((CharSequence) sbU.toString());
            Iterator<?> it4 = c0054a.invoke(rc).iterator();
            while (it4.hasNext()) {
                spannableStringBuilder.setSpan(it4.next(), length4 + 1, spannableStringBuilder.length(), 33);
            }
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("^<!--[\\s\\S]*?-->", 32);
        d0.z.d.m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^<!--…*?-->\"\"\", Pattern.DOTALL)");
        a = patternCompile;
        Pattern patternCompile2 = Pattern.compile("^<([\\s\\S]+?)(?:>(.*?)<\\/([\\s\\S]+?))?>", 32);
        d0.z.d.m.checkNotNullExpressionValue(patternCompile2, "Pattern.compile(\n      \"…?))?>\"\"\", Pattern.DOTALL)");
        f306b = patternCompile2;
    }
}
