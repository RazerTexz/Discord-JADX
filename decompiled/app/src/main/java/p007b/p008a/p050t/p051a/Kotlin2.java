package p007b.p008a.p050t.p051a;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import p507d0.p579g0.Regex5;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Kotlin.kt */
/* renamed from: b.a.t.a.o, reason: use source file name */
/* loaded from: classes.dex */
public final class Kotlin2 {

    /* renamed from: a */
    public static final String[] f1943a = {"public|private|internal|inline|lateinit|abstract|open|reified", "import|package", "class|interface|data|enum|sealed|object|typealias", "fun|override|this|super|where|constructor|init|param|delegate", "const|val|var|get|final|vararg|it", "return|break|continue|suspend", "for|while|do|if|else|when|try|catch|finally|throw", "in|out|is|as|typeof", "shr|ushr|shl|ushl", "true|false|null"};

    /* renamed from: b */
    public static final String[] f1944b = {"true|false|Boolean|String|Char", "Int|UInt|Long|ULong|Float|Double|Byte|UByte|Short|UShort", "Self|Set|Map|MutableMap|List|MutableList|Array|Runnable|Unit", "arrayOf|listOf|mapOf|setOf|let|also|apply|run"};

    /* renamed from: c */
    public static final Pattern f1945c = Pattern.compile("^(?:(?://.*?(?=\\n|$))|(/\\*.*?\\*/))", 32);

    /* renamed from: d */
    public static final Pattern f1946d = Pattern.compile("^@(\\w+)");

    /* renamed from: e */
    public static final Pattern f1947e = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");

    /* renamed from: f */
    public static final Kotlin2 f1948f = null;

    /* compiled from: Kotlin.kt */
    /* renamed from: b.a.t.a.o$a */
    public static final class a<RC> extends Node.C5655a<RC> {

        /* renamed from: b */
        public static final C13215a f1950b = new C13215a(null);

        /* renamed from: a */
        public static final Pattern f1949a = Pattern.compile("^(val|var)(\\s+\\w+)", 32);

        /* compiled from: Kotlin.kt */
        /* renamed from: b.a.t.a.o$a$a, reason: collision with other inner class name */
        public static final class C13215a {
            public C13215a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, CodeStyleProviders<RC> codeStyleProviders) {
            super(new StyleNode.C5657b(str, codeStyleProviders.f1909d), new StyleNode.C5657b(str2, codeStyleProviders.f1910e));
            Intrinsics3.checkNotNullParameter(str, "definition");
            Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        }
    }

    /* compiled from: Kotlin.kt */
    /* renamed from: b.a.t.a.o$b */
    public static final class b<RC> extends Node.C5655a<RC> {

        /* renamed from: b */
        public static final a f1952b = new a(null);

        /* renamed from: a */
        public static final Pattern f1951a = new Regex("^(fun)( *<.*>)?( \\w+)( *\\(.*?\\))", Regex5.DOT_MATCHES_ALL).getNativePattern();

        /* compiled from: Kotlin.kt */
        /* renamed from: b.a.t.a.o$b$a */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public b(String str, String str2, String str3, String str4, CodeStyleProviders<RC> codeStyleProviders) {
            Intrinsics3.checkNotNullParameter(str, "pre");
            Intrinsics3.checkNotNullParameter(str3, "signature");
            Intrinsics3.checkNotNullParameter(str4, "params");
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
            Node[] nodeArr = new Node[4];
            nodeArr[0] = new StyleNode.C5657b(str, codeStyleProviders.f1909d);
            nodeArr[1] = str2 != null ? new StyleNode.C5657b(str2, codeStyleProviders.f1912g) : null;
            nodeArr[2] = new StyleNode.C5657b(str3, codeStyleProviders.f1910e);
            nodeArr[3] = new StyleNode.C5657b(str4, codeStyleProviders.f1913h);
            super(nodeArr);
        }
    }
}
