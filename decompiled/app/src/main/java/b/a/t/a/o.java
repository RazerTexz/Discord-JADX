package b.a.t.a;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;

/* compiled from: Kotlin.kt */
/* loaded from: classes.dex */
public final class o {
    public static final String[] a = {"public|private|internal|inline|lateinit|abstract|open|reified", "import|package", "class|interface|data|enum|sealed|object|typealias", "fun|override|this|super|where|constructor|init|param|delegate", "const|val|var|get|final|vararg|it", "return|break|continue|suspend", "for|while|do|if|else|when|try|catch|finally|throw", "in|out|is|as|typeof", "shr|ushr|shl|ushl", "true|false|null"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f298b = {"true|false|Boolean|String|Char", "Int|UInt|Long|ULong|Float|Double|Byte|UByte|Short|UShort", "Self|Set|Map|MutableMap|List|MutableList|Array|Runnable|Unit", "arrayOf|listOf|mapOf|setOf|let|also|apply|run"};
    public static final Pattern c = Pattern.compile("^(?:(?://.*?(?=\\n|$))|(/\\*.*?\\*/))", 32);
    public static final Pattern d = Pattern.compile("^@(\\w+)");
    public static final Pattern e = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
    public static final o f = null;

    /* compiled from: Kotlin.kt */
    public static final class a<RC> extends Node.a<RC> {

        /* renamed from: b, reason: collision with root package name */
        public static final C0052a f299b = new C0052a(null);
        public static final Pattern a = Pattern.compile("^(val|var)(\\s+\\w+)", 32);

        /* compiled from: Kotlin.kt */
        /* renamed from: b.a.t.a.o$a$a, reason: collision with other inner class name */
        public static final class C0052a {
            public C0052a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, f<RC> fVar) {
            super(new StyleNode.b(str, fVar.d), new StyleNode.b(str2, fVar.e));
            d0.z.d.m.checkNotNullParameter(str, "definition");
            d0.z.d.m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
        }
    }

    /* compiled from: Kotlin.kt */
    public static final class b<RC> extends Node.a<RC> {

        /* renamed from: b, reason: collision with root package name */
        public static final a f300b = new a(null);
        public static final Pattern a = new Regex("^(fun)( *<.*>)?( \\w+)( *\\(.*?\\))", d0.g0.i.DOT_MATCHES_ALL).getNativePattern();

        /* compiled from: Kotlin.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public b(String str, String str2, String str3, String str4, f<RC> fVar) {
            d0.z.d.m.checkNotNullParameter(str, "pre");
            d0.z.d.m.checkNotNullParameter(str3, "signature");
            d0.z.d.m.checkNotNullParameter(str4, "params");
            d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
            Node[] nodeArr = new Node[4];
            nodeArr[0] = new StyleNode.b(str, fVar.d);
            nodeArr[1] = str2 != null ? new StyleNode.b(str2, fVar.g) : null;
            nodeArr[2] = new StyleNode.b(str3, fVar.e);
            nodeArr[3] = new StyleNode.b(str4, fVar.h);
            super(nodeArr);
        }
    }
}
