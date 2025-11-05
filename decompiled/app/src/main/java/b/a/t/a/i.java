package b.a.t.a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Crystal.kt */
/* loaded from: classes.dex */
public final class i {
    public static final String[] a = {"true|false|nil", "module|require|include|extend|lib", "abstract|private|protected", "annotation|class|finalize|new|initialize|allocate|self|super", "union|typeof|forall|is_a?|nil?|as?|as|responds_to?|alias|type", "property|getter|setter|struct|of", "previous_def|method|fun|enum|macro", "rescue|raise|begin|end|ensure", "if|else|elsif|then|unless|until", "for|in|of|do|when|select|with", "while|break|next|yield|case", "print|puts|return"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f292b = {"Nil|Bool|true|false|Void|NoReturn", "Number|BigDecimal|BigRational|BigFloat|BigInt", "Int|Int8|Int16|Int32|Int64|UInt8|UInt16|UInt32|UInt64|Float|Float32|Float64", "Char|String|Symbol|Regex", "StaticArray|Array|Set|Hash|Range|Tuple|NamedTuple|Union|BitArray", "Proc|Command|Enum|Class", "Reference|Value|Struct|Object|Pointer", "Exception|ArgumentError|KeyError|TypeCastError|IndexError|RuntimeError|NilAssertionError|InvalidBigDecimalException|NotImplementedError|OverflowError", "pointerof|sizeof|instance_sizeof|offsetof|uninitialized"};
    public static final Pattern c = Pattern.compile("^(#.*)");
    public static final Pattern d = Pattern.compile("^@\\[(\\w+)(?:\\(.+\\))?]");
    public static final Pattern e = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
    public static final Pattern f = Pattern.compile("^/.*?/[imx]?");
    public static final Pattern g = Pattern.compile("^(:\"?(?:[+-/%&^|]|\\*\\*?|\\w+|(?:<(?=[<=\\s])[<=]?(?:(?<==)>)?|>(?=[>=\\s])[>=]?(?:(?<==)>)?)|\\[][?=]?|(?:!(?=[=~\\s])[=~]?|=?(?:~|==?)))(?:(?<!\\\\)\"(?=\\s|$))?)");
    public static final i h = null;

    /* compiled from: Crystal.kt */
    public static final class a<RC> extends Node.a<RC> {

        /* renamed from: b, reason: collision with root package name */
        public static final C0050a f293b = new C0050a(null);
        public static final Pattern a = Pattern.compile("^(def)( +\\w+)( *\\( *(?:@\\w+ +: +\\w*)?\\w+(?: +[:=] +.*)? *\\))?(?!.+)");

        /* compiled from: Crystal.kt */
        /* renamed from: b.a.t.a.i$a$a, reason: collision with other inner class name */
        public static final class C0050a {
            public C0050a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(String str, String str2, String str3, f<RC> fVar) {
            d0.z.d.m.checkNotNullParameter(str, "pre");
            d0.z.d.m.checkNotNullParameter(str2, "signature");
            d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
            Node[] nodeArr = new Node[3];
            nodeArr[0] = new StyleNode.b(str, fVar.d);
            nodeArr[1] = new StyleNode.b(str2, fVar.e);
            nodeArr[2] = str3 != null ? new StyleNode.b(str3, fVar.h) : null;
            super(nodeArr);
        }
    }
}
