package b.a.t.a;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;

/* compiled from: TypeScript.kt */
/* loaded from: classes.dex */
public final class r {
    public static final String[] a = {"import|from|export|default|package", "class|enum", "function|super|extends|implements|arguments", "var|let|const|static|get|set|new", "return|break|continue|yield|void", "if|else|for|while|do|switch|async|await|case|try|catch|finally|delete|throw|NaN|Infinity", "of|in|instanceof|typeof", "debugger|with", "true|false|null|undefined", "type|as|interface|public|private|protected|module|declare|namespace", "abstract|keyof|readonly|is|asserts|infer|override|intrinsic"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f301b = {"String|Boolean|RegExp|Number|Date|Math|JSON|Symbol|BigInt|Atomics|DataView", "Function|Promise|Generator|GeneratorFunction|AsyncFunction|AsyncGenerator|AsyncGeneratorFunction", "Array|Object|Map|Set|WeakMap|WeakSet|Int8Array|Int16Array|Int32Array|Uint8Array|Uint16Array", "Uint32Array|Uint8ClampedArray|Float32Array|Float64Array|BigInt64Array|BigUint64Array|Buffer", "ArrayBuffer|SharedArrayBuffer", "Reflect|Proxy|Intl|WebAssembly", "console|process|require|isNaN|parseInt|parseFloat|encodeURI|decodeURI|encodeURIComponent", "decodeURIComponent|this|global|globalThis|eval|isFinite|module", "setTimeout|setInterval|clearTimeout|clearInterval|setImmediate|clearImmediate", "queueMicrotask|document|window", "Error|SyntaxError|TypeError|RangeError|ReferenceError|EvalError|InternalError|URIError", "AggregateError|escape|unescape|URL|URLSearchParams|TextEncoder|TextDecoder", "AbortController|AbortSignal|EventTarget|Event|MessageChannel", "MessagePort|MessageEvent|FinalizationRegistry|WeakRef", "regeneratorRuntime|performance", "Iterable|Iterator|IterableIterator", "Partial|Required|Readonly|Record|Pick|Omit|Exclude|Extract", "NonNullable|Parameters|ConstructorParameters|ReturnType", "InstanceType|ThisParameterType|OmitThisParameter", "ThisType|Uppercase|Lowercase|Capitalize|Uncapitalize"};
    public static final String[] c = {"string|number|boolean|object|symbol|any|unknown|bigint|never"};
    public static final Pattern d = Pattern.compile("^/.+(?<!\\\\)/[dgimsuy]*");
    public static final Pattern e = Pattern.compile("^(?:(?://.*?(?=\\n|$))|(/\\*.*?\\*/))", 32);
    public static final Pattern f = Pattern.compile("^('.*?(?<!\\\\)'|\".*?(?<!\\\\)\"|`[\\s\\S]*?(?<!\\\\)`)(?=\\W|\\s|$)");
    public static final r g = null;

    /* compiled from: TypeScript.kt */
    public static final class a<RC> extends Node.a<RC> {

        /* renamed from: b, reason: collision with root package name */
        public static final C0053a f302b = new C0053a(null);
        public static final Pattern a = Pattern.compile("^(@)(\\s*[a-zA-Z_$][a-zA-Z0-9_$]*)(<.*>)?", 32);

        /* compiled from: TypeScript.kt */
        /* renamed from: b.a.t.a.r$a$a, reason: collision with other inner class name */
        public static final class C0053a {
            public C0053a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(String str, String str2, String str3, f<RC> fVar) {
            d0.z.d.m.checkNotNullParameter(str, "prefix");
            d0.z.d.m.checkNotNullParameter(str2, "decorator");
            d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
            Node[] nodeArr = new Node[3];
            nodeArr[0] = new StyleNode.b(str, fVar.d);
            nodeArr[1] = new StyleNode.b(str2, fVar.g);
            nodeArr[2] = str3 != null ? new StyleNode.b(str3, fVar.g) : null;
            super(nodeArr);
        }
    }

    /* compiled from: TypeScript.kt */
    public static final class b<RC> extends Node.a<RC> {

        /* renamed from: b, reason: collision with root package name */
        public static final a f303b = new a(null);
        public static final Pattern a = Pattern.compile("^(var|let|const)(\\s+[a-zA-Z_$][a-zA-Z0-9_$]*)");

        /* compiled from: TypeScript.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, f<RC> fVar) {
            super(new StyleNode.b(str, fVar.d), new StyleNode.b(str2, fVar.e));
            d0.z.d.m.checkNotNullParameter(str, "definition");
            d0.z.d.m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
        }
    }

    /* compiled from: TypeScript.kt */
    public static final class c<RC> extends Node.a<RC> {

        /* renamed from: b, reason: collision with root package name */
        public static final a f304b = new a(null);
        public static final Pattern a = new Regex("^((?:function\\*?|static|get|set|async)\\s)(\\s*[a-zA-Z_$][a-zA-Z0-9_$]*)?(\\s*<.*>)?", d0.g0.i.DOT_MATCHES_ALL).getNativePattern();

        /* compiled from: TypeScript.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public c(String str, String str2, String str3, f<RC> fVar) {
            d0.z.d.m.checkNotNullParameter(str, "pre");
            d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
            Node[] nodeArr = new Node[3];
            nodeArr[0] = new StyleNode.b(str, fVar.d);
            nodeArr[1] = str2 != null ? new StyleNode.b(str2, fVar.e) : null;
            nodeArr[2] = str3 != null ? new StyleNode.b(str3, fVar.g) : null;
            super(nodeArr);
        }
    }

    /* compiled from: TypeScript.kt */
    public static final class d<RC> extends Node.a<RC> {

        /* renamed from: b, reason: collision with root package name */
        public static final a f305b = new a(null);
        public static final Pattern a = Pattern.compile("^([{\\[(,;](?:\\s*-)?)(\\s*(?:public|private|protected|readonly))?(\\s*[a-zA-Z0-9_$]+)((?:\\s*\\?)?\\s*:)");

        /* compiled from: TypeScript.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public d(String str, String str2, String str3, String str4, f<RC> fVar) {
            d0.z.d.m.checkNotNullParameter(str, "prefix");
            d0.z.d.m.checkNotNullParameter(str3, "property");
            d0.z.d.m.checkNotNullParameter(str4, "suffix");
            d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
            Node[] nodeArr = new Node[4];
            nodeArr[0] = new StyleNode.b(str, fVar.a);
            nodeArr[1] = str2 != null ? new StyleNode.b(str2, fVar.d) : null;
            nodeArr[2] = new StyleNode.b(str3, fVar.e);
            nodeArr[3] = new StyleNode.b(str4, fVar.a);
            super(nodeArr);
        }
    }
}
