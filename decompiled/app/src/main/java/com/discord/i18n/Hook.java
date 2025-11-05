package com.discord.i18n;

import android.view.View;
import androidx.annotation.ColorInt;
import b.a.k.c;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: Hook.kt */
/* loaded from: classes.dex */
public final class Hook {

    /* renamed from: a, reason: from kotlin metadata */
    public final List<Object> styles = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public CharSequence replacementText;

    /* renamed from: c, reason: from kotlin metadata */
    public a clickHandler;

    /* compiled from: Hook.kt */
    public static final class a {

        @ColorInt
        public Integer a;

        /* renamed from: b, reason: collision with root package name */
        public Function2<? super String, ? super View, Unit> f2709b;

        public a(@ColorInt Integer num, Function2<? super String, ? super View, Unit> function2) {
            m.checkNotNullParameter(function2, "onClick");
            this.f2709b = c.j;
            this.a = num;
            this.f2709b = function2;
        }
    }
}
