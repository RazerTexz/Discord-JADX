package com.discord.widgets.user.profile;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import p007b.p109f.p132g.p133a.p134a.Fresco;
import p007b.p109f.p132g.p133a.p134a.PipelineDraweeControllerBuilder;
import p007b.p109f.p132g.p142e.C1788v;
import p007b.p109f.p132g.p143f.GenericDraweeHierarchyBuilder;
import p007b.p109f.p132g.p143f.RoundingParams;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.user.profile.DraweeSpanStringBuilderExtensionsKt, reason: use source file name */
/* JADX INFO: compiled from: DraweeSpanStringBuilderExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DraweeSpanStringBuilderExtensions {
    /* JADX WARN: Type inference failed for: r0v2, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public static final DraweeSpanStringBuilder setAvatar(DraweeSpanStringBuilder draweeSpanStringBuilder, Context context, String str, boolean z2, Integer num, @ColorInt Integer num2, Character ch) {
        Intrinsics3.checkNotNullParameter(draweeSpanStringBuilder, "$this$setAvatar");
        Intrinsics3.checkNotNullParameter(context, "context");
        if (str != null) {
            int length = draweeSpanStringBuilder.length();
            draweeSpanStringBuilder.append("#");
            draweeSpanStringBuilder.append((CharSequence) String.valueOf(ch));
            int iIntValue = num != null ? num.intValue() : DimenUtils.dpToPixels(16);
            ?? M8724a = MGImages.getImageRequest(str, IconUtils.getMediaProxySize(iIntValue), IconUtils.getMediaProxySize(iIntValue), true).m8724a();
            PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderM1037a = Fresco.m1037a();
            pipelineDraweeControllerBuilderM1037a.f19484h = M8724a;
            pipelineDraweeControllerBuilderM1037a.f19489m = z2;
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.f3472b = true;
            roundingParams.f3471a = 1;
            if (num2 != null) {
                int iIntValue2 = num2.intValue();
                Intrinsics3.checkNotNullExpressionValue(roundingParams, "roundingParams");
                roundingParams.m1125b(iIntValue2);
            }
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
            genericDraweeHierarchyBuilder.f3456f = ContextCompat.getDrawable(context, C5419R.drawable.asset_default_avatar_32dp);
            genericDraweeHierarchyBuilder.f3468r = roundingParams;
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.f19495a;
            genericDraweeHierarchyBuilder.f3464n = C1788v.f3446l;
            draweeSpanStringBuilder.m8686c(context, genericDraweeHierarchyBuilder.m1122a(), pipelineDraweeControllerBuilderM1037a.m8667a(), length, length, iIntValue, iIntValue, false, 2);
        }
        return draweeSpanStringBuilder;
    }

    public static /* synthetic */ DraweeSpanStringBuilder setAvatar$default(DraweeSpanStringBuilder draweeSpanStringBuilder, Context context, String str, boolean z2, Integer num, Integer num2, Character ch, int i, Object obj) {
        return setAvatar(draweeSpanStringBuilder, context, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : num, (i & 16) == 0 ? num2 : null, (i & 32) != 0 ? ' ' : ch);
    }
}
