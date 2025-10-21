package com.discord.widgets.chat.input.attachments;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* compiled from: AttachmentBottomSheet.kt */
/* renamed from: com.discord.widgets.chat.input.attachments.AttachmentBottomSheet$draweeControllerListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AttachmentBottomSheet3 implements ControllerListener<ImageInfo> {
    public final /* synthetic */ AttachmentBottomSheet this$0;

    public AttachmentBottomSheet3(AttachmentBottomSheet attachmentBottomSheet) {
        this.this$0 = attachmentBottomSheet;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFailure(String id2, Throwable throwable) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public /* bridge */ /* synthetic */ void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
        onFinalImageSet2(str, imageInfo, animatable);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(String id2, Throwable throwable) {
    }

    /* renamed from: onIntermediateImageSet, reason: avoid collision after fix types in other method */
    public void onIntermediateImageSet2(String id2, ImageInfo imageInfo) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public /* bridge */ /* synthetic */ void onIntermediateImageSet(String str, ImageInfo imageInfo) {
        onIntermediateImageSet2(str, imageInfo);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onRelease(String id2) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String id2, Object callerContext) {
    }

    /* renamed from: onFinalImageSet, reason: avoid collision after fix types in other method */
    public void onFinalImageSet2(String id2, ImageInfo imageInfo, Animatable animatable) {
        String string;
        this.this$0.setAttachmentImageInfo(imageInfo);
        SimpleDraweeView simpleDraweeView = AttachmentBottomSheet.access$getBinding$p(this.this$0).f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentPreview");
        ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if ((imageInfo != null ? imageInfo.getWidth() : 0) > (imageInfo != null ? imageInfo.getHeight() : 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append(imageInfo != null ? Integer.valueOf(imageInfo.getWidth()) : null);
            sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
            sb.append(imageInfo != null ? Integer.valueOf(imageInfo.getHeight()) : null);
            string = sb.toString();
        } else {
            string = "1";
        }
        layoutParams2.dimensionRatio = string;
        simpleDraweeView.setLayoutParams(layoutParams2);
        this.this$0.updateSpoilerViewSize();
    }
}
