package p007b.p008a.p027k;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.parser.Parser;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import p007b.p008a.p027k.p030g.FormattingParser;
import p007b.p008a.p027k.p030g.FormattingParserProvider;
import p007b.p008a.p027k.p030g.ParseState;
import p007b.p008a.p050t.p052b.p054b.SimpleRenderer;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.k.b, reason: use source file name */
/* JADX INFO: compiled from: FormatUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FormatUtils {

    /* JADX INFO: renamed from: a */
    public static final Regex f1489a = new Regex("\\{(\\S+?)\\}");

    /* JADX INFO: renamed from: b.a.k.b$a */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class a extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final a f1490j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$b */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class b extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final b f1491j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$c */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class c extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final c f1492j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$d */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class d extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final d f1493j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$e */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class e extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final e f1494j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$f */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class f extends Lambda implements Function1<MatchResult, CharSequence> {
        public final /* synthetic */ Map $namedArgs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Map map) {
            super(1);
            this.$namedArgs = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(MatchResult matchResult) {
            MatchResult matchResult2 = matchResult;
            Intrinsics3.checkNotNullParameter(matchResult2, "matchResult");
            String str = (String) this.$namedArgs.get(matchResult2.getGroupValues().get(1));
            return str != null ? str : matchResult2.getValue();
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$g */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class g extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final g f1495j = new g();

        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$h */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class h extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final h f1496j = new h();

        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m209a(TextView textView, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(textView, "$this$bindText");
        textView.setText(charSequence);
        textView.setVisibility((charSequence == null || charSequence.length() == 0) ^ true ? 0 : 8);
    }

    /* JADX INFO: renamed from: b */
    public static final CharSequence m210b(Context context, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(context, "$this$i18nFormat");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        Resources resources = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        return m211c(resources, i, Arrays.copyOf(objArr, objArr.length), function1);
    }

    /* JADX INFO: renamed from: c */
    public static final CharSequence m211c(Resources resources, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(resources, "$this$i18nFormat");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        String string = resources.getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "getString(stringResId)");
        return m215g(string, Arrays.copyOf(objArr, objArr.length), function1);
    }

    /* JADX INFO: renamed from: d */
    public static final CharSequence m212d(View view, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "$this$i18nFormat");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        return m210b(context, i, Arrays.copyOf(objArr, objArr.length), function1);
    }

    /* JADX INFO: renamed from: e */
    public static final CharSequence m213e(Fragment fragment, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$i18nFormat");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        Context contextRequireContext = fragment.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return m210b(contextRequireContext, i, Arrays.copyOf(objArr, objArr.length), function1);
    }

    /* JADX INFO: renamed from: f */
    public static final CharSequence m214f(CharSequence charSequence, Object[] objArr, RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$i18nFormat");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        Map<String, String> map = renderContext.args;
        List<? extends Object> list = renderContext.orderedArguments;
        boolean z2 = true;
        if (!map.isEmpty()) {
            charSequence = f1489a.replace(charSequence, new f(map));
        } else {
            if (list != null && !list.isEmpty()) {
                z2 = false;
            }
            if (!z2) {
                String strReplace = f1489a.replace(charSequence, "%s");
                Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                charSequence = outline.m828P(objArrCopyOf, objArrCopyOf.length, strReplace, "java.lang.String.format(this, *args)");
            }
        }
        Format format = Format.f1486d;
        FormattingParserProvider formattingParserProvider = Format.f1483a;
        if (formattingParserProvider == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("formattingParserProvider");
        }
        FormattingParser formattingParserMo224a = formattingParserProvider.mo224a();
        if (renderContext.uppercase) {
            String string = charSequence.toString();
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            charSequence = string.toUpperCase(locale);
            Intrinsics3.checkNotNullExpressionValue(charSequence, "(this as java.lang.String).toUpperCase(locale)");
        }
        CharSequence charSequence2 = charSequence;
        Objects.requireNonNull(formattingParserMo224a);
        Intrinsics3.checkNotNullParameter(charSequence2, "input");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        List list2 = Parser.parse$default(formattingParserMo224a, charSequence2, new ParseState(false, 0, 3), null, 4, null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SimpleRenderer.m375a(spannableStringBuilder, list2, renderContext);
        return spannableStringBuilder;
    }

    /* JADX INFO: renamed from: g */
    public static final CharSequence m215g(CharSequence charSequence, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$i18nFormat");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        return m214f(charSequence, objArr, AnimatableValueParser.m470R1(function1, Arrays.copyOf(objArr, objArr.length)));
    }

    /* JADX INFO: renamed from: h */
    public static /* synthetic */ CharSequence m216h(Context context, int i, Object[] objArr, Function1 function1, int i2) {
        return m210b(context, i, objArr, (i2 & 4) != 0 ? b.f1491j : null);
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ CharSequence m217i(Resources resources, int i, Object[] objArr, Function1 function1, int i2) {
        return m211c(resources, i, objArr, (i2 & 4) != 0 ? d.f1493j : null);
    }

    /* JADX INFO: renamed from: j */
    public static /* synthetic */ CharSequence m218j(View view, int i, Object[] objArr, Function1 function1, int i2) {
        return m212d(view, i, objArr, (i2 & 4) != 0 ? c.f1492j : null);
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ CharSequence m219k(Fragment fragment, int i, Object[] objArr, Function1 function1, int i2) {
        return m213e(fragment, i, objArr, (i2 & 4) != 0 ? a.f1490j : null);
    }

    /* JADX INFO: renamed from: l */
    public static /* synthetic */ CharSequence m220l(CharSequence charSequence, Object[] objArr, Function1 function1, int i) {
        return m215g(charSequence, objArr, (i & 2) != 0 ? e.f1494j : null);
    }

    /* JADX INFO: renamed from: m */
    public static final void m221m(TextView textView, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textView, "$this$i18nSetText");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        RenderContext renderContextM470R1 = AnimatableValueParser.m470R1(function1, Arrays.copyOf(objArr, objArr.length));
        textView.setMovementMethod(renderContextM470R1.hasClickables ? LinkMovementMethod.getInstance() : null);
        String string = textView.getContext().getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(stringResId)");
        textView.setText(m214f(string, objArr, renderContextM470R1));
    }

    /* JADX INFO: renamed from: n */
    public static /* synthetic */ void m222n(TextView textView, int i, Object[] objArr, Function1 function1, int i2) {
        m221m(textView, i, objArr, (i2 & 4) != 0 ? g.f1495j : null);
    }

    /* JADX INFO: renamed from: o */
    public static void m223o(TextView textView, CharSequence charSequence, Object[] objArr, Function1 function1, int i) {
        h hVar = (i & 4) != 0 ? h.f1496j : null;
        Intrinsics3.checkNotNullParameter(textView, "$this$i18nSetText");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(hVar, "initializer");
        if (charSequence == null) {
            textView.setText((CharSequence) null);
            textView.setMovementMethod(null);
        } else {
            RenderContext renderContextM470R1 = AnimatableValueParser.m470R1(hVar, Arrays.copyOf(objArr, objArr.length));
            textView.setMovementMethod(renderContextM470R1.hasClickables ? LinkMovementMethod.getInstance() : null);
            textView.setText(m214f(charSequence, objArr, renderContextM470R1));
        }
    }
}
