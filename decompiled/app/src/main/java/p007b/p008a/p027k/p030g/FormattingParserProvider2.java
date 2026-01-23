package p007b.p008a.p027k.p030g;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.k.g.d, reason: use source file name */
/* JADX INFO: compiled from: FormattingParserProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FormattingParserProvider2 extends FormattingParserProvider {

    /* JADX INFO: renamed from: a */
    public static final Lazy f1503a = LazyJVM.lazy(a.f1506j);

    /* JADX INFO: renamed from: b */
    public static final FormattingParserProvider2 f1504b = null;

    /* JADX INFO: renamed from: c */
    public final ThreadLocal<FormattingParser> f1505c = new b();

    /* JADX INFO: renamed from: b.a.k.g.d$a */
    /* JADX INFO: compiled from: FormattingParserProvider.kt */
    public static final class a extends Lambda implements Function0<FormattingParserProvider2> {

        /* JADX INFO: renamed from: j */
        public static final a f1506j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FormattingParserProvider2 invoke() {
            return new FormattingParserProvider2();
        }
    }

    /* JADX INFO: renamed from: b.a.k.g.d$b */
    /* JADX INFO: compiled from: FormattingParserProvider.kt */
    public static final class b extends ThreadLocal<FormattingParser> {
        @Override // java.lang.ThreadLocal
        public FormattingParser initialValue() {
            return new FormattingParser();
        }
    }

    @Override // p007b.p008a.p027k.p030g.FormattingParserProvider
    /* JADX INFO: renamed from: a */
    public FormattingParser mo224a() {
        FormattingParser formattingParser = this.f1505c.get();
        Intrinsics3.checkNotNull(formattingParser);
        return formattingParser;
    }
}
