package p007b.p008a.p039o;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: LocaleProvider.kt */
/* renamed from: b.a.o.a, reason: use source file name */
/* loaded from: classes.dex */
public final class LocaleProvider {

    /* renamed from: a */
    public static Function1<? super Context, Locale> f1570a = a.f1572j;

    /* renamed from: b */
    public static final LocaleProvider f1571b = null;

    /* compiled from: LocaleProvider.kt */
    /* renamed from: b.a.o.a$a */
    public static final class a extends Lambda implements Function1<Context, Locale> {

        /* renamed from: j */
        public static final a f1572j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Locale invoke(Context context) {
            Context context2 = context;
            Intrinsics3.checkParameterIsNotNull(context2, "context");
            Resources resources = context2.getResources();
            Intrinsics3.checkExpressionValueIsNotNull(resources, "context.resources");
            Locale locale = ConfigurationCompat.getLocales(resources.getConfiguration()).get(0);
            Intrinsics3.checkExpressionValueIsNotNull(locale, "ConfigurationCompat.getL…sources.configuration)[0]");
            return locale;
        }
    }
}
