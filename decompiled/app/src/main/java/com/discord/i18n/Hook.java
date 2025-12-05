package com.discord.i18n;

import android.view.View;
import androidx.annotation.ColorInt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p027k.Hook2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Hook.kt */
/* loaded from: classes.dex */
public final class Hook {

    /* renamed from: a, reason: from kotlin metadata */
    public final List<Object> styles = new ArrayList();

    /* renamed from: b, reason: from kotlin metadata */
    public CharSequence replacementText;

    /* renamed from: c, reason: from kotlin metadata */
    public C5524a clickHandler;

    /* compiled from: Hook.kt */
    /* renamed from: com.discord.i18n.Hook$a */
    public static final class C5524a {

        /* renamed from: a */
        @ColorInt
        public Integer f18546a;

        /* renamed from: b */
        public Function2<? super String, ? super View, Unit> f18547b;

        public C5524a(@ColorInt Integer num, Function2<? super String, ? super View, Unit> function2) {
            Intrinsics3.checkNotNullParameter(function2, "onClick");
            this.f18547b = Hook2.f1497j;
            this.f18546a = num;
            this.f18547b = function2;
        }
    }
}
