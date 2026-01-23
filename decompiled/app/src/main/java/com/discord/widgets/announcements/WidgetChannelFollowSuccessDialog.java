package com.discord.widgets.announcements;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetChannelFollowSuccessDialogBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p510c0.Random;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetChannelFollowSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSuccessDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetChannelFollowSuccessDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelFollowSuccessDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Integer[] successImageOptions;
    private final Integer[] successTextOptions;

    /* JADX INFO: compiled from: WidgetChannelFollowSuccessDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            new WidgetChannelFollowSuccessDialog().show(fragmentManager, WidgetChannelFollowSuccessDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.announcements.WidgetChannelFollowSuccessDialog$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetChannelFollowSuccessDialog.kt */
    public static final class ViewOnClickListenerC71521 implements View.OnClickListener {
        public ViewOnClickListenerC71521() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelFollowSuccessDialog.this.dismiss();
        }
    }

    public WidgetChannelFollowSuccessDialog() {
        super(C5419R.layout.widget_channel_follow_success_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelFollowSuccessDialog2.INSTANCE, null, 2, null);
        this.successTextOptions = new Integer[]{Integer.valueOf(C5419R.string.follow_success_modal_header_01), Integer.valueOf(C5419R.string.follow_success_modal_header_02), Integer.valueOf(C5419R.string.follow_success_modal_header_03), Integer.valueOf(C5419R.string.follow_success_modal_header_04), Integer.valueOf(C5419R.string.follow_success_modal_header_05), Integer.valueOf(C5419R.string.follow_success_modal_header_06), Integer.valueOf(C5419R.string.follow_success_modal_header_07), Integer.valueOf(C5419R.string.follow_success_modal_header_08), Integer.valueOf(C5419R.string.follow_success_modal_header_09), Integer.valueOf(C5419R.string.follow_success_modal_header_10)};
        this.successImageOptions = new Integer[]{Integer.valueOf(C5419R.attr.img_channel_following_success_1), Integer.valueOf(C5419R.attr.img_channel_following_success_2), Integer.valueOf(C5419R.attr.img_channel_following_success_3)};
    }

    private final WidgetChannelFollowSuccessDialogBinding getBinding() {
        return (WidgetChannelFollowSuccessDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager) {
        INSTANCE.show(fragmentManager);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f15844d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelFollowSuccessText");
        Integer[] numArr = this.successTextOptions;
        Random.a aVar = Random.f22272k;
        textView.setText(getString(((Number) _Arrays.random(numArr, aVar)).intValue()));
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView = getBinding().f15843c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelFollowSuccessImage");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        MGImages.setImage$default(mGImages, simpleDraweeView, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, ((Number) _Arrays.random(this.successImageOptions, aVar)).intValue(), 0, 2, (Object) null), (MGImages.ChangeDetector) null, 4, (Object) null);
        getBinding().f15842b.setOnClickListener(new ViewOnClickListenerC71521());
    }
}
