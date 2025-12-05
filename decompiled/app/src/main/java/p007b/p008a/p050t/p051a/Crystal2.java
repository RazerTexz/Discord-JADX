package p007b.p008a.p050t.p051a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Crystal.kt */
/* renamed from: b.a.t.a.i, reason: use source file name */
/* loaded from: classes.dex */
public final class Crystal2 {

    /* renamed from: a */
    public static final String[] f1916a = {"true|false|nil", "module|require|include|extend|lib", "abstract|private|protected", "annotation|class|finalize|new|initialize|allocate|self|super", "union|typeof|forall|is_a?|nil?|as?|as|responds_to?|alias|type", "property|getter|setter|struct|of", "previous_def|method|fun|enum|macro", "rescue|raise|begin|end|ensure", "if|else|elsif|then|unless|until", "for|in|of|do|when|select|with", "while|break|next|yield|case", "print|puts|return"};

    /* renamed from: b */
    public static final String[] f1917b = {"Nil|Bool|true|false|Void|NoReturn", "Number|BigDecimal|BigRational|BigFloat|BigInt", "Int|Int8|Int16|Int32|Int64|UInt8|UInt16|UInt32|UInt64|Float|Float32|Float64", "Char|String|Symbol|Regex", "StaticArray|Array|Set|Hash|Range|Tuple|NamedTuple|Union|BitArray", "Proc|Command|Enum|Class", "Reference|Value|Struct|Object|Pointer", "Exception|ArgumentError|KeyError|TypeCastError|IndexError|RuntimeError|NilAssertionError|InvalidBigDecimalException|NotImplementedError|OverflowError", "pointerof|sizeof|instance_sizeof|offsetof|uninitialized"};

    /* renamed from: c */
    public static final Pattern f1918c = Pattern.compile("^(#.*)");

    /* renamed from: d */
    public static final Pattern f1919d = Pattern.compile("^@\\[(\\w+)(?:\\(.+\\))?]");

    /* renamed from: e */
    public static final Pattern f1920e = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");

    /* renamed from: f */
    public static final Pattern f1921f = Pattern.compile("^/.*?/[imx]?");

    /* renamed from: g */
    public static final Pattern f1922g = Pattern.compile("^(:\"?(?:[+-/%&^|]|\\*\\*?|\\w+|(?:<(?=[<=\\s])[<=]?(?:(?<==)>)?|>(?=[>=\\s])[>=]?(?:(?<==)>)?)|\\[][?=]?|(?:!(?=[=~\\s])[=~]?|=?(?:~|==?)))(?:(?<!\\\\)\"(?=\\s|$))?)");

    /* renamed from: h */
    public static final Crystal2 f1923h = null;

    /* compiled from: Crystal.kt */
    /* renamed from: b.a.t.a.i$a */
    public static final class a<RC> extends Node.C5655a<RC> {

        /* renamed from: b */
        public static final C13213a f1925b = new C13213a(null);

        /* renamed from: a */
        public static final Pattern f1924a = Pattern.compile("^(def)( +\\w+)( *\\( *(?:@\\w+ +: +\\w*)?\\w+(?: +[:=] +.*)? *\\))?(?!.+)");

        /* compiled from: Crystal.kt */
        /* renamed from: b.a.t.a.i$a$a, reason: collision with other inner class name */
        public static final class C13213a {
            public C13213a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(String str, String str2, String str3, CodeStyleProviders<RC> codeStyleProviders) {
            Intrinsics3.checkNotNullParameter(str, "pre");
            Intrinsics3.checkNotNullParameter(str2, "signature");
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
            Node[] nodeArr = new Node[3];
            nodeArr[0] = new StyleNode.C5657b(str, codeStyleProviders.f1909d);
            nodeArr[1] = new StyleNode.C5657b(str2, codeStyleProviders.f1910e);
            nodeArr[2] = str3 != null ? new StyleNode.C5657b(str3, codeStyleProviders.f1913h) : null;
            super(nodeArr);
        }
    }
}
