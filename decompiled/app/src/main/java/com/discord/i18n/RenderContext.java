package com.discord.i18n;

import android.view.View;
import androidx.annotation.ColorInt;
import b.a.k.d;
import com.discord.i18n.Hook;
import d0.z.d.m;
import d0.z.d.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: RenderContext.kt */
/* loaded from: classes.dex */
public final class RenderContext {

    /* renamed from: a, reason: from kotlin metadata */
    public final Map<String, String> args = new HashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Hook> hooks = new HashMap();

    /* renamed from: c, reason: from kotlin metadata */
    public List<? extends Object> orderedArguments;

    /* renamed from: d, reason: from kotlin metadata */
    @ColorInt
    public Integer boldColor;

    /* renamed from: e, reason: from kotlin metadata */
    @ColorInt
    public Integer strikethroughColor;

    /* renamed from: f, reason: from kotlin metadata */
    public boolean uppercase;

    /* renamed from: g, reason: from kotlin metadata */
    public boolean hasClickables;

    /* compiled from: RenderContext.kt */
    public static final class a extends o implements Function1<Hook, Unit> {
        public final /* synthetic */ Function1 $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function1 function1) {
            super(1);
            this.$onClick = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Hook hook) {
            Hook hook2 = hook;
            m.checkNotNullParameter(hook2, "$receiver");
            d dVar = new d(this);
            Objects.requireNonNull(hook2);
            m.checkNotNullParameter(dVar, "onClick");
            hook2.clickHandler = new Hook.a(null, dVar);
            return Unit.a;
        }
    }

    public final void a(String key, Function1<? super Hook, Unit> hookInitializer) {
        m.checkNotNullParameter(key, "key");
        m.checkNotNullParameter(hookInitializer, "hookInitializer");
        Map<String, Hook> map = this.hooks;
        Hook hook = new Hook();
        hookInitializer.invoke(hook);
        map.put(key, hook);
    }

    public final void b(String key, Function1<? super View, Unit> onClick) {
        m.checkNotNullParameter(key, "key");
        m.checkNotNullParameter(onClick, "onClick");
        a(key, new a(onClick));
    }
}
