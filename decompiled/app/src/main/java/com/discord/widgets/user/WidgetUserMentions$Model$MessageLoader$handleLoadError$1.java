package com.discord.widgets.user;

import com.discord.widgets.user.WidgetUserMentions;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetUserMentions.kt */
/* loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$handleLoadError$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetUserMentions.Model.MessageLoader this$0;

    /* compiled from: WidgetUserMentions.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserMentions$Model$MessageLoader$handleLoadError$1$1 */
    public static final class C102081 extends Lambda implements Function1<WidgetUserMentions.Model.MessageLoader.LoadingState, WidgetUserMentions.Model.MessageLoader.LoadingState> {
        public static final C102081 INSTANCE = new C102081();

        public C102081() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ WidgetUserMentions.Model.MessageLoader.LoadingState invoke(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
            return invoke2(loadingState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetUserMentions.Model.MessageLoader.LoadingState invoke2(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
            Intrinsics3.checkNotNullParameter(loadingState, "it");
            return WidgetUserMentions.Model.MessageLoader.LoadingState.copy$default(loadingState, false, false, null, 6, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$Model$MessageLoader$handleLoadError$1(WidgetUserMentions.Model.MessageLoader messageLoader) {
        super(0);
        this.this$0 = messageLoader;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.tryLoad(C102081.INSTANCE);
    }
}
