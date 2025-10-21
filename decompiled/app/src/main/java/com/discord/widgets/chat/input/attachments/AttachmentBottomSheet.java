package com.discord.widgets.chat.input.attachments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import b.f.g.a.a.Fresco;
import b.f.g.a.a.PipelineDraweeControllerBuilder;
import b.f.j.d.RotationOptions;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetAttachmentBottomSheetBinding;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: AttachmentBottomSheet.kt */
/* loaded from: classes2.dex */
public final class AttachmentBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(AttachmentBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAttachmentBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Attachment<? extends Object> attachment;
    private ImageInfo attachmentImageInfo;
    private Integer attachmentViewSize;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ControllerListener<ImageInfo> draweeControllerListener;
    private boolean isSpoiler;
    private Function0<Unit> onDismissed;
    private Function0<Unit> onFileRemoved;
    private Function1<? super Boolean, Unit> onMarkSpoiler;

    /* compiled from: AttachmentBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ AttachmentBottomSheet show$default(Companion companion, FragmentManager fragmentManager, Attachment attachment, Function0 function0, Function1 function1, Function0 function02, int i, Object obj) {
            if ((i & 16) != 0) {
                function02 = null;
            }
            return companion.show(fragmentManager, attachment, function0, function1, function02);
        }

        public final AttachmentBottomSheet show(FragmentManager fragmentManager, Attachment<? extends Object> attachment, Function0<Unit> onFileRemoved, Function1<? super Boolean, Unit> onMarkSpoiler, Function0<Unit> onDismissed) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(attachment, "attachment");
            Intrinsics3.checkNotNullParameter(onFileRemoved, "onFileRemoved");
            Intrinsics3.checkNotNullParameter(onMarkSpoiler, "onMarkSpoiler");
            AttachmentBottomSheet attachmentBottomSheet = new AttachmentBottomSheet();
            attachmentBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to("EXTRA_ATTACHMENT", attachment)));
            AttachmentBottomSheet.access$setOnFileRemoved$p(attachmentBottomSheet, onFileRemoved);
            AttachmentBottomSheet.access$setOnMarkSpoiler$p(attachmentBottomSheet, onMarkSpoiler);
            AttachmentBottomSheet.access$setOnDismissed$p(attachmentBottomSheet, onDismissed);
            AttachmentBottomSheet.access$setSpoiler$p(attachmentBottomSheet, attachment.getSpoiler());
            attachmentBottomSheet.show(fragmentManager, Reflection2.getOrCreateKotlinClass(AttachmentBottomSheet.class).toString());
            return attachmentBottomSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AttachmentBottomSheet.kt */
    /* renamed from: com.discord.widgets.chat.input.attachments.AttachmentBottomSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function4<Integer, Integer, Integer, Integer, Unit> {
        public AnonymousClass1() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3, Integer num4) {
            invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2, int i3, int i4) {
            AttachmentBottomSheet.this.setAttachmentViewSize(Integer.valueOf(i));
            AttachmentBottomSheet.this.updateSpoilerViewSize();
        }
    }

    /* compiled from: AttachmentBottomSheet.kt */
    /* renamed from: com.discord.widgets.chat.input.attachments.AttachmentBottomSheet$onViewCreated$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getOnFileRemoved$p = AttachmentBottomSheet.access$getOnFileRemoved$p(AttachmentBottomSheet.this);
            if (function0Access$getOnFileRemoved$p != null) {
            }
            AttachmentBottomSheet.this.dismiss();
        }
    }

    /* compiled from: AttachmentBottomSheet.kt */
    /* renamed from: com.discord.widgets.chat.input.attachments.AttachmentBottomSheet$onViewCreated$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean z2 = !AttachmentBottomSheet.access$isSpoiler$p(AttachmentBottomSheet.this);
            AttachmentBottomSheet.this.markSpoiler(z2);
            Function1 function1Access$getOnMarkSpoiler$p = AttachmentBottomSheet.access$getOnMarkSpoiler$p(AttachmentBottomSheet.this);
            if (function1Access$getOnMarkSpoiler$p != null) {
            }
        }
    }

    public AttachmentBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, AttachmentBottomSheet2.INSTANCE, null, 2, null);
        this.draweeControllerListener = new AttachmentBottomSheet3(this);
    }

    public static final /* synthetic */ WidgetAttachmentBottomSheetBinding access$getBinding$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.getBinding();
    }

    public static final /* synthetic */ Function0 access$getOnDismissed$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.onDismissed;
    }

    public static final /* synthetic */ Function0 access$getOnFileRemoved$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.onFileRemoved;
    }

    public static final /* synthetic */ Function1 access$getOnMarkSpoiler$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.onMarkSpoiler;
    }

    public static final /* synthetic */ boolean access$isSpoiler$p(AttachmentBottomSheet attachmentBottomSheet) {
        return attachmentBottomSheet.isSpoiler;
    }

    public static final /* synthetic */ void access$setOnDismissed$p(AttachmentBottomSheet attachmentBottomSheet, Function0 function0) {
        attachmentBottomSheet.onDismissed = function0;
    }

    public static final /* synthetic */ void access$setOnFileRemoved$p(AttachmentBottomSheet attachmentBottomSheet, Function0 function0) {
        attachmentBottomSheet.onFileRemoved = function0;
    }

    public static final /* synthetic */ void access$setOnMarkSpoiler$p(AttachmentBottomSheet attachmentBottomSheet, Function1 function1) {
        attachmentBottomSheet.onMarkSpoiler = function1;
    }

    public static final /* synthetic */ void access$setSpoiler$p(AttachmentBottomSheet attachmentBottomSheet, boolean z2) {
        attachmentBottomSheet.isSpoiler = z2;
    }

    private final WidgetAttachmentBottomSheetBinding getBinding() {
        return (WidgetAttachmentBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final Attachment<Object> getAttachment() {
        return this.attachment;
    }

    public final ImageInfo getAttachmentImageInfo() {
        return this.attachmentImageInfo;
    }

    public final Integer getAttachmentViewSize() {
        return this.attachmentViewSize;
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_attachment_bottom_sheet;
    }

    public final ControllerListener<ImageInfo> getDraweeControllerListener() {
        return this.draweeControllerListener;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public final void loadAttachment() {
        Attachment<? extends Object> attachment = this.attachment;
        ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(attachment != null ? attachment.getUri() : null);
        imageRequestBuilderB.e = RotationOptions.a;
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderA = Fresco.a();
        pipelineDraweeControllerBuilderA.m = true;
        SimpleDraweeView simpleDraweeView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentPreview");
        pipelineDraweeControllerBuilderA.n = simpleDraweeView.getController();
        pipelineDraweeControllerBuilderA.h = imageRequestBuilderB.a();
        AbstractDraweeController abstractDraweeControllerA = pipelineDraweeControllerBuilderA.a();
        abstractDraweeControllerA.f(this.draweeControllerListener);
        SimpleDraweeView simpleDraweeView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.attachmentPreview");
        simpleDraweeView2.setController(abstractDraweeControllerA);
    }

    public final void markSpoiler(boolean spoiler) {
        this.isSpoiler = spoiler;
        MaterialCheckBox materialCheckBox = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.attachmentMarkSpoilerCheckbox");
        materialCheckBox.setChecked(spoiler);
        FrameLayout frameLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.attachmentSpoilerCover");
        frameLayout.setVisibility(spoiler ? 0 : 8);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.attachment = (Attachment) getArgumentsOrDefault().getParcelable("EXTRA_ATTACHMENT");
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        this.onFileRemoved = null;
        this.onMarkSpoiler = null;
        Function0<Unit> function0 = this.onDismissed;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence string;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppCompatTextView appCompatTextView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appCompatTextView, "binding.attachmentFilename");
        Attachment<? extends Object> attachment = this.attachment;
        appCompatTextView.setText(attachment != null ? attachment.getDisplayName() : null);
        SimpleDraweeView simpleDraweeView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentPreview");
        ViewExtensions.addOnSizeChangedListener(simpleDraweeView, new AnonymousClass1());
        Attachment<? extends Object> attachment2 = this.attachment;
        if (!(attachment2 instanceof Media)) {
            attachment2 = null;
        }
        Media media = (Media) attachment2;
        Long l = media != null ? media.k : null;
        MaterialTextView materialTextView = getBinding().f2227b;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.attachmentDuration");
        materialTextView.setVisibility(l != null ? 0 : 8);
        if (l != null) {
            long jLongValue = l.longValue();
            MaterialTextView materialTextView2 = getBinding().f2227b;
            Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.attachmentDuration");
            if (jLongValue > 0) {
                string = TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, jLongValue, null, null, 6, null);
            } else {
                Context context = getContext();
                string = context != null ? context.getString(R.string.video) : null;
            }
            materialTextView2.setText(string);
        }
        markSpoiler(this.isSpoiler);
        loadAttachment();
        getBinding().g.setOnClickListener(new AnonymousClass3());
        getBinding().d.setOnClickListener(new AnonymousClass4());
        setPeekHeightBottomView(getBinding().g);
    }

    public final void setAttachment(Attachment<? extends Object> attachment) {
        this.attachment = attachment;
    }

    public final void setAttachmentImageInfo(ImageInfo imageInfo) {
        this.attachmentImageInfo = imageInfo;
    }

    public final void setAttachmentViewSize(Integer num) {
        this.attachmentViewSize = num;
    }

    public final void updateSpoilerViewSize() {
        Integer num;
        ImageInfo imageInfo = this.attachmentImageInfo;
        if (imageInfo == null || (num = this.attachmentViewSize) == null) {
            return;
        }
        int iIntValue = num.intValue();
        int width = imageInfo.getWidth();
        int height = imageInfo.getHeight();
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        Tuples2 tuples2CalculateScaledSize$default = EmbedResourceUtils.calculateScaledSize$default(embedResourceUtils, width, height, iIntValue, iIntValue, resources, 0, 32, null);
        FrameLayout frameLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.attachmentSpoilerCover");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((Number) tuples2CalculateScaledSize$default.getFirst()).intValue();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = ((Number) tuples2CalculateScaledSize$default.getSecond()).intValue();
        frameLayout.setLayoutParams(layoutParams2);
    }
}
