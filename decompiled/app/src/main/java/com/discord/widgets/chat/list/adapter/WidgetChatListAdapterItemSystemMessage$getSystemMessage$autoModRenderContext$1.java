package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.discord.R;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("autoModHook", new AnonymousClass1());
        renderContext.a("systemHook", new AnonymousClass2());
    }

    /* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Hook, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new ForegroundColorSpan(ColorCompat.getColor(WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1.this.$context, R.color.brand_new_360)));
            hook.styles.add(new StyleSpan(1));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }

    /* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Hook, Unit> {

        /* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<String, String> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(String str) {
                return invoke2(str);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final String invoke2(String str) {
                if (str == null) {
                    return null;
                }
                Locale locale = Locale.ROOT;
                m.checkNotNullExpressionValue(locale, "Locale.ROOT");
                String upperCase = str.toUpperCase(locale);
                m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                return upperCase;
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new ForegroundColorSpan(ColorCompat.getThemedColor(WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1.this.$context, R.attr.colorHeaderPrimary)));
            hook.styles.add(new AbsoluteSizeSpan(DimenUtils.dpToPixels(14)));
            hook.styles.add(new SimpleRoundedBackgroundSpan(8, 14, DimenUtils.dpToPixels(4), DimenUtils.dpToPixels(2), ColorCompat.getColor(WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1.this.$context, R.color.brand_new_500), DimenUtils.dpToPixels(4), Integer.valueOf(ColorCompat.getColor(WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1.this.$context, R.color.white)), false, AnonymousClass1.INSTANCE, -2, 128, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }
}
