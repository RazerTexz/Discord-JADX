package com.discord.widgets.announcements;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetChannelFollowSuccessDialogBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.c0.c;
import d0.t.k;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetChannelFollowSuccessDialog.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelFollowSuccessDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelFollowSuccessDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelFollowSuccessDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Integer[] successImageOptions;
    private final Integer[] successTextOptions;

    /* compiled from: WidgetChannelFollowSuccessDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            new WidgetChannelFollowSuccessDialog().show(fragmentManager, WidgetChannelFollowSuccessDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelFollowSuccessDialog.kt */
    /* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSuccessDialog$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelFollowSuccessDialog.this.dismiss();
        }
    }

    public WidgetChannelFollowSuccessDialog() {
        super(R.layout.widget_channel_follow_success_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelFollowSuccessDialog$binding$2.INSTANCE, null, 2, null);
        this.successTextOptions = new Integer[]{Integer.valueOf(R.string.follow_success_modal_header_01), Integer.valueOf(R.string.follow_success_modal_header_02), Integer.valueOf(R.string.follow_success_modal_header_03), Integer.valueOf(R.string.follow_success_modal_header_04), Integer.valueOf(R.string.follow_success_modal_header_05), Integer.valueOf(R.string.follow_success_modal_header_06), Integer.valueOf(R.string.follow_success_modal_header_07), Integer.valueOf(R.string.follow_success_modal_header_08), Integer.valueOf(R.string.follow_success_modal_header_09), Integer.valueOf(R.string.follow_success_modal_header_10)};
        this.successImageOptions = new Integer[]{Integer.valueOf(R.attr.img_channel_following_success_1), Integer.valueOf(R.attr.img_channel_following_success_2), Integer.valueOf(R.attr.img_channel_following_success_3)};
    }

    private final WidgetChannelFollowSuccessDialogBinding getBinding() {
        return (WidgetChannelFollowSuccessDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager) {
        INSTANCE.show(fragmentManager);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.channelFollowSuccessText");
        Integer[] numArr = this.successTextOptions;
        c.a aVar = c.k;
        textView.setText(getString(((Number) k.random(numArr, aVar)).intValue()));
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView = getBinding().c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelFollowSuccessImage");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        MGImages.setImage$default(mGImages, simpleDraweeView, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, ((Number) k.random(this.successImageOptions, aVar)).intValue(), 0, 2, (Object) null), (MGImages.ChangeDetector) null, 4, (Object) null);
        getBinding().f2256b.setOnClickListener(new AnonymousClass1());
    }
}
