package com.discord.i18n;

import android.view.View;
import androidx.annotation.ColorInt;
import com.discord.i18n.Hook;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.RenderContext2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: RenderContext.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RenderContext {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Map<String, String> args = new HashMap();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Map<String, Hook> hooks = new HashMap();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public List<? extends Object> orderedArguments;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @ColorInt
    public Integer boldColor;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @ColorInt
    public Integer strikethroughColor;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public boolean uppercase;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public boolean hasClickables;

    /* JADX INFO: renamed from: com.discord.i18n.RenderContext$a */
    /* JADX INFO: compiled from: RenderContext.kt */
    public static final class C5526a extends Lambda implements Function1<Hook, Unit> {
        public final /* synthetic */ Function1 $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C5526a(Function1 function1) {
            super(1);
            this.$onClick = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Hook hook) {
            Hook hook2 = hook;
            Intrinsics3.checkNotNullParameter(hook2, "$receiver");
            RenderContext2 renderContext2 = new RenderContext2(this);
            Objects.requireNonNull(hook2);
            Intrinsics3.checkNotNullParameter(renderContext2, "onClick");
            hook2.clickHandler = new Hook.C5524a(null, renderContext2);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8422a(String key, Function1<? super Hook, Unit> hookInitializer) {
        Intrinsics3.checkNotNullParameter(key, "key");
        Intrinsics3.checkNotNullParameter(hookInitializer, "hookInitializer");
        Map<String, Hook> map = this.hooks;
        Hook hook = new Hook();
        hookInitializer.invoke(hook);
        map.put(key, hook);
    }

    /* JADX INFO: renamed from: b */
    public final void m8423b(String key, Function1<? super View, Unit> onClick) {
        Intrinsics3.checkNotNullParameter(key, "key");
        Intrinsics3.checkNotNullParameter(onClick, "onClick");
        m8422a(key, new C5526a(onClick));
    }
}
