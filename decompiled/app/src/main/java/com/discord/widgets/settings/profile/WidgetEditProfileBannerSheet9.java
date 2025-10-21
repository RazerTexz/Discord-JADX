package com.discord.widgets.settings.profile;

import android.graphics.Color;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetEditProfileBannerSheet.kt */
/* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet9 extends Lambda implements Function0<EditProfileBannerSheetViewModel> {
    public final /* synthetic */ WidgetEditProfileBannerSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditProfileBannerSheet9(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        super(0);
        this.this$0 = widgetEditProfileBannerSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EditProfileBannerSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EditProfileBannerSheetViewModel invoke() {
        String string = WidgetEditProfileBannerSheet.access$getArgumentsOrDefault$p(this.this$0).getString("ARG_DEFAULT_BANNER_COLOR_HEX");
        Intrinsics3.checkNotNull(string);
        Intrinsics3.checkNotNullExpressionValue(string, "argumentsOrDefault.getSt…FAULT_BANNER_COLOR_HEX)!!");
        String string2 = WidgetEditProfileBannerSheet.access$getArgumentsOrDefault$p(this.this$0).getString("ARG_INITIAL_COLOR_PREVIEW_HEX");
        WidgetEditProfileBannerSheet.access$setDefaultBannerColor$p(this.this$0, Color.parseColor(string));
        return new EditProfileBannerSheetViewModel(string, string2, null, 4, null);
    }
}
