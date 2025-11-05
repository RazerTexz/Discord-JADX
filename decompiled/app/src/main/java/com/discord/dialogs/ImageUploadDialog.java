package com.discord.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.i.ImageUploadDialogBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.media_picker.MediaPicker;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.AutocompleteUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: ImageUploadDialog.kt */
/* loaded from: classes.dex */
public final class ImageUploadDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(ImageUploadDialog.class, "binding", "getBinding()Lcom/discord/databinding/ImageUploadDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public Uri uri;

    /* renamed from: n, reason: from kotlin metadata */
    public MediaPicker.Provider provider;

    /* renamed from: o, reason: from kotlin metadata */
    public String mimeType;

    /* renamed from: p, reason: from kotlin metadata */
    public Action1<String> cropResultCallBack;

    /* renamed from: q, reason: from kotlin metadata */
    public PreviewType previewType;

    /* compiled from: ImageUploadDialog.kt */
    public enum PreviewType {
        EMOJI(R.dimen.emoji_size),
        USER_AVATAR(R.dimen.avatar_size_extra_large_account),
        GUILD_AVATAR(R.dimen.avatar_size_xxlarge),
        GUILD_SUBSCRIPTION_ROLE_AVATAR(R.dimen.avatar_size_huge);

        private final int previewSizeDimenId;

        PreviewType(@DimenRes int i) {
            this.previewSizeDimenId = i;
        }

        public final int getPreviewSizeDimenId() {
            return this.previewSizeDimenId;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i != 0) {
                if (i != 1) {
                    throw null;
                }
                ((ImageUploadDialog) this.k).dismiss();
                return;
            }
            Context context = ((ImageUploadDialog) this.k).getContext();
            MediaPicker.Provider provider = ((ImageUploadDialog) this.k).provider;
            if (provider == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("provider");
            }
            Uri uri = ((ImageUploadDialog) this.k).uri;
            if (uri == null) {
                Intrinsics3.throwUninitializedPropertyAccessException(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            }
            MGImages.requestImageCrop$default(context, provider, uri, 0.0f, 0.0f, 0, 56, null);
            ((ImageUploadDialog) this.k).dismiss();
        }
    }

    /* compiled from: ImageUploadDialog.kt */
    /* renamed from: com.discord.dialogs.ImageUploadDialog$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: ImageUploadDialog.kt */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, ImageUploadDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, ImageUploadDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ImageUploadDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public ImageUploadDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.notice_cancel;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.notice_cancel);
            if (materialButton != null) {
                i = R.id.notice_crop;
                TextView textView = (TextView) view2.findViewById(R.id.notice_crop);
                if (textView != null) {
                    i = R.id.notice_image;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(R.id.notice_image);
                    if (simpleDraweeView != null) {
                        i = R.id.notice_upload;
                        MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.notice_upload);
                        if (materialButton2 != null) {
                            return new ImageUploadDialogBinding((LinearLayout) view2, materialButton, textView, simpleDraweeView, materialButton2);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: ImageUploadDialog.kt */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ String k;

        public d(String str) {
            this.k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = ImageUploadDialog.this.getContext();
            Uri uri = ImageUploadDialog.this.uri;
            if (uri == null) {
                Intrinsics3.throwUninitializedPropertyAccessException(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            }
            MGImages.requestDataUrl(context, uri, this.k, ImageUploadDialog.this.cropResultCallBack);
            ImageUploadDialog.this.dismiss();
        }
    }

    public ImageUploadDialog() {
        super(R.layout.image_upload_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
    }

    public final ImageUploadDialogBinding g() {
        return (ImageUploadDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        PreviewType previewType = this.previewType;
        String str = this.mimeType;
        if (previewType == null || str == null) {
            dismiss();
            return;
        }
        boolean zAreEqual = Intrinsics3.areEqual(str, "image/gif");
        g().e.setOnClickListener(new d(str));
        TextView textView = g().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeCrop");
        textView.setVisibility(zAreEqual ? 4 : 0);
        if (!zAreEqual) {
            g().c.setOnClickListener(new a(0, this));
        }
        g().f81b.setOnClickListener(new a(1, this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(previewType.getPreviewSizeDimenId());
        SimpleDraweeView simpleDraweeView = g().d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.noticeImage");
        ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = dimensionPixelSize;
        SimpleDraweeView simpleDraweeView2 = g().d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.noticeImage");
        simpleDraweeView2.setLayoutParams(layoutParams);
        int iOrdinal = previewType.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            SimpleDraweeView simpleDraweeView3 = g().d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.noticeImage");
            MGImages.setRoundingParams$default(simpleDraweeView3, dimensionPixelSize, true, Integer.valueOf(ColorCompat.getThemedColor(view, R.attr.primary_600)), null, null, 48, null);
        }
        SimpleDraweeView simpleDraweeView4 = g().d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.noticeImage");
        Uri uri = this.uri;
        if (uri == null) {
            Intrinsics3.throwUninitializedPropertyAccessException(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        }
        MGImages.setImage$default(simpleDraweeView4, uri.toString(), dimensionPixelSize, dimensionPixelSize, false, null, null, 112, null);
    }
}
