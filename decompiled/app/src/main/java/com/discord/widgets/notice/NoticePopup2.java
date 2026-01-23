package com.discord.widgets.notice;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetNoticePopupBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tapadoo.alerter.C11198R;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p007b.p483p.p484a.Alert;
import p007b.p483p.p484a.Alerter;
import p007b.p483p.p484a.Alerter2;
import p007b.p483p.p484a.Alerter3;
import p007b.p483p.p484a.OnHideAlertListener;
import p007b.p483p.p484a.SwipeDismissTouchListener;
import p007b.p483p.p484a.ViewOnClickListenerC5272b;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.notice.NoticePopup$enqueue$notice$1, reason: use source file name */
/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ Integer $noticeAutoDismissPeriodSecs;
    public final /* synthetic */ CharSequence $noticeBody;
    public final /* synthetic */ Drawable $noticeBodyBackgroundDrawable;
    public final /* synthetic */ Drawable $noticeBodyImageDrawable;
    public final /* synthetic */ String $noticeBodyImageUrl;
    public final /* synthetic */ Integer $noticeIconResId;
    public final /* synthetic */ Drawable $noticeIconTopRight;
    public final /* synthetic */ String $noticeIconUrl;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ List $noticeStickers;
    public final /* synthetic */ CharSequence $noticeSubtitle;
    public final /* synthetic */ CharSequence $noticeTitle;
    public final /* synthetic */ Function1 $onClick;
    public final /* synthetic */ Function1 $onClickTopRightIcon;

    /* JADX INFO: renamed from: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$1 */
    /* JADX INFO: compiled from: NoticePopup.kt */
    public static final class ViewOnClickListenerC90911 implements View.OnClickListener {
        public ViewOnClickListenerC90911() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = NoticePopup2.this.$onClick;
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            function1.invoke(view);
            NoticePopup.access$dismiss(NoticePopup.INSTANCE, NoticePopup2.this.$noticeName);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$2 */
    /* JADX INFO: compiled from: NoticePopup.kt */
    public static final class C90922 implements OnHideAlertListener {
        public C90922() {
        }

        @Override // p007b.p483p.p484a.OnHideAlertListener
        public final void onHide() {
            StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), NoticePopup2.this.$noticeName, 0L, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticePopup2(Function1 function1, String str, Integer num, String str2, Integer num2, String str3, Drawable drawable, Drawable drawable2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Drawable drawable3, List list, Function1 function12) {
        super(1);
        this.$onClick = function1;
        this.$noticeName = str;
        this.$noticeAutoDismissPeriodSecs = num;
        this.$noticeIconUrl = str2;
        this.$noticeIconResId = num2;
        this.$noticeBodyImageUrl = str3;
        this.$noticeBodyImageDrawable = drawable;
        this.$noticeBodyBackgroundDrawable = drawable2;
        this.$noticeTitle = charSequence;
        this.$noticeSubtitle = charSequence2;
        this.$noticeBody = charSequence3;
        this.$noticeIconTopRight = drawable3;
        this.$noticeStickers = list;
        this.$onClickTopRightIcon = function12;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        ViewOnClickListenerC5272b viewOnClickListenerC5272b;
        View view;
        ViewGroup viewGroup;
        Sticker sticker;
        Window window;
        int childCount;
        ViewOnClickListenerC5272b viewOnClickListenerC5272b2;
        Window window2;
        Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Alerter3 alerter3 = new Alerter3(null);
        View decorView = (fragmentActivity == null || (window2 = fragmentActivity.getWindow()) == null) ? null : window2.getDecorView();
        if (!(decorView instanceof ViewGroup)) {
            decorView = null;
        }
        ViewGroup viewGroup2 = (ViewGroup) decorView;
        if (viewGroup2 != null && (childCount = viewGroup2.getChildCount()) >= 0) {
            int i = 0;
            while (true) {
                if (viewGroup2.getChildAt(i) instanceof ViewOnClickListenerC5272b) {
                    View childAt = viewGroup2.getChildAt(i);
                    Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.tapadoo.alerter.Alert");
                    viewOnClickListenerC5272b2 = (ViewOnClickListenerC5272b) childAt;
                } else {
                    viewOnClickListenerC5272b2 = null;
                }
                if (viewOnClickListenerC5272b2 != null && viewOnClickListenerC5272b2.getWindowToken() != null) {
                    ViewCompat.animate(viewOnClickListenerC5272b2).alpha(0.0f).withEndAction(new Alerter(viewOnClickListenerC5272b2));
                }
                if (i == childCount) {
                    break;
                }
                i++;
            }
        }
        if (fragmentActivity == null || (window = fragmentActivity.getWindow()) == null) {
            viewOnClickListenerC5272b = null;
        } else {
            View decorView2 = window.getDecorView();
            Objects.requireNonNull(decorView2, "null cannot be cast to non-null type android.view.ViewGroup");
            Alerter3.f14367a = new WeakReference<>((ViewGroup) decorView2);
            View decorView3 = window.getDecorView();
            Intrinsics3.checkNotNullExpressionValue(decorView3, "it.decorView");
            Context context = decorView3.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.decorView.context");
            viewOnClickListenerC5272b = new ViewOnClickListenerC5272b(context, C5419R.layout.widget_notice_popup, null, 0, 12);
        }
        alerter3.f14368b = viewOnClickListenerC5272b;
        int themedColor = ColorCompat.getThemedColor(fragmentActivity, C5419R.attr.colorBackgroundTertiary);
        ViewOnClickListenerC5272b viewOnClickListenerC5272b3 = alerter3.f14368b;
        if (viewOnClickListenerC5272b3 != null) {
            viewOnClickListenerC5272b3.setAlertBackgroundColor(themedColor);
        }
        ViewOnClickListenerC5272b viewOnClickListenerC5272b4 = alerter3.f14368b;
        if (viewOnClickListenerC5272b4 != null) {
            LinearLayout linearLayout = (LinearLayout) viewOnClickListenerC5272b4.m7465c(C11198R.d.llAlertBackground);
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "it");
            linearLayout.setOnTouchListener(new SwipeDismissTouchListener(linearLayout, new Alert(viewOnClickListenerC5272b4)));
        }
        ViewOnClickListenerC5272b viewOnClickListenerC5272b5 = alerter3.f14368b;
        if (viewOnClickListenerC5272b5 != null) {
            viewOnClickListenerC5272b5.setVibrationEnabled(false);
        }
        ViewOnClickListenerC5272b viewOnClickListenerC5272b6 = alerter3.f14368b;
        if (viewOnClickListenerC5272b6 != null) {
            viewOnClickListenerC5272b6.setEnableInfiniteDuration(true);
        }
        ViewOnClickListenerC5272b viewOnClickListenerC5272b7 = alerter3.f14368b;
        if (viewOnClickListenerC5272b7 != null) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(viewOnClickListenerC5272b7.getContext(), C5419R.anim.anim_slide_in_down);
            Intrinsics3.checkNotNullExpressionValue(animationLoadAnimation, "AnimationUtils.loadAnima…lert?.context, animation)");
            viewOnClickListenerC5272b7.setEnterAnimation$alerter_release(animationLoadAnimation);
        }
        ViewOnClickListenerC90911 viewOnClickListenerC90911 = new ViewOnClickListenerC90911();
        Intrinsics3.checkNotNullParameter(viewOnClickListenerC90911, "onClickListener");
        ViewOnClickListenerC5272b viewOnClickListenerC5272b8 = alerter3.f14368b;
        if (viewOnClickListenerC5272b8 != null) {
            viewOnClickListenerC5272b8.setOnClickListener(viewOnClickListenerC90911);
        }
        C90922 c90922 = new C90922();
        Intrinsics3.checkNotNullParameter(c90922, "listener");
        ViewOnClickListenerC5272b viewOnClickListenerC5272b9 = alerter3.f14368b;
        if (viewOnClickListenerC5272b9 != null) {
            viewOnClickListenerC5272b9.setOnHideListener$alerter_release(c90922);
        }
        ViewOnClickListenerC5272b viewOnClickListenerC5272b10 = alerter3.f14368b;
        View layoutContainer = viewOnClickListenerC5272b10 != null ? viewOnClickListenerC5272b10.getLayoutContainer() : null;
        if (layoutContainer != null) {
            layoutContainer.setOnTouchListener(new NoticePopup5(NoticePopup.access$getAutoDismissAnimator(NoticePopup.INSTANCE, this.$noticeAutoDismissPeriodSecs, new NoticePopup3(this, fragmentActivity))));
            int i2 = C5419R.id.popup_attachment;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) layoutContainer.findViewById(C5419R.id.popup_attachment);
            if (simpleDraweeView != null) {
                i2 = C5419R.id.popup_body;
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) layoutContainer.findViewById(C5419R.id.popup_body);
                if (simpleDraweeSpanTextView != null) {
                    i2 = C5419R.id.popup_close_btn;
                    ImageView imageView = (ImageView) layoutContainer.findViewById(C5419R.id.popup_close_btn);
                    if (imageView != null) {
                        i2 = C5419R.id.popup_icon;
                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) layoutContainer.findViewById(C5419R.id.popup_icon);
                        if (simpleDraweeView2 != null) {
                            i2 = C5419R.id.popup_sticker;
                            StickerView stickerView = (StickerView) layoutContainer.findViewById(C5419R.id.popup_sticker);
                            if (stickerView != null) {
                                i2 = C5419R.id.popup_subtitle;
                                TextView textView = (TextView) layoutContainer.findViewById(C5419R.id.popup_subtitle);
                                if (textView != null) {
                                    i2 = C5419R.id.popup_title;
                                    TextView textView2 = (TextView) layoutContainer.findViewById(C5419R.id.popup_title);
                                    if (textView2 != null) {
                                        i2 = C5419R.id.popup_title_wrap;
                                        RelativeLayout relativeLayout = (RelativeLayout) layoutContainer.findViewById(C5419R.id.popup_title_wrap);
                                        if (relativeLayout != null) {
                                            WidgetNoticePopupBinding widgetNoticePopupBinding = new WidgetNoticePopupBinding((RelativeLayout) layoutContainer, simpleDraweeView, simpleDraweeSpanTextView, imageView, simpleDraweeView2, stickerView, textView, textView2, relativeLayout);
                                            Intrinsics3.checkNotNullExpressionValue(widgetNoticePopupBinding, "WidgetNoticePopupBinding.bind(view)");
                                            if (this.$noticeIconUrl != null) {
                                                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.popupIcon");
                                                MGImages.setImage$default(simpleDraweeView2, this.$noticeIconUrl, 0, 0, false, null, null, 124, null);
                                            } else if (this.$noticeIconResId != null) {
                                                MGImages mGImages = MGImages.INSTANCE;
                                                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.popupIcon");
                                                MGImages.setImage$default(mGImages, simpleDraweeView2, this.$noticeIconResId.intValue(), (MGImages.ChangeDetector) null, 4, (Object) null);
                                            }
                                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                            simpleDraweeView.setVisibility(this.$noticeBodyImageUrl != null || this.$noticeBodyImageDrawable != null ? 0 : 8);
                                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                            simpleDraweeView.setBackground(this.$noticeBodyBackgroundDrawable);
                                            if (this.$noticeBodyImageUrl != null) {
                                                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                                MGImages.setImage$default(simpleDraweeView, this.$noticeBodyImageUrl, 0, 0, false, null, null, 124, null);
                                            } else if (this.$noticeBodyImageDrawable != null) {
                                                MGImages mGImages2 = MGImages.INSTANCE;
                                                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.popupAttachment");
                                                MGImages.setImage$default(mGImages2, simpleDraweeView, this.$noticeBodyImageDrawable, (MGImages.ChangeDetector) null, 4, (Object) null);
                                            }
                                            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.popupTitle");
                                            textView2.setText(this.$noticeTitle);
                                            Intrinsics3.checkNotNullExpressionValue(textView, "binding.popupSubtitle");
                                            ViewExtensions.setTextAndVisibilityBy(textView, this.$noticeSubtitle);
                                            CharSequence charSequence = this.$noticeBody;
                                            if (charSequence instanceof DraweeSpanStringBuilder) {
                                                simpleDraweeSpanTextView.setDraweeSpanStringBuilder((DraweeSpanStringBuilder) charSequence);
                                            } else {
                                                Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.popupBody");
                                                simpleDraweeSpanTextView.setText(this.$noticeBody);
                                            }
                                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.popupBody");
                                            CharSequence charSequence2 = this.$noticeBody;
                                            simpleDraweeSpanTextView.setVisibility(charSequence2 != null && (StringsJVM.isBlank(charSequence2) ^ true) ? 0 : 8);
                                            simpleDraweeSpanTextView.post(new NoticePopup6(widgetNoticePopupBinding));
                                            Drawable drawable = this.$noticeIconTopRight;
                                            if (drawable == null) {
                                                drawable = ContextCompat.getDrawable(fragmentActivity, DrawableCompat.getThemedDrawableRes$default(fragmentActivity, C5419R.attr.ic_settings, 0, 2, (Object) null));
                                            }
                                            Intrinsics3.checkNotNullExpressionValue(stickerView, "binding.popupSticker");
                                            List list = this.$noticeStickers;
                                            stickerView.setVisibility(list != null && !list.isEmpty() ? 0 : 8);
                                            List list2 = this.$noticeStickers;
                                            if (list2 == null || (sticker = (Sticker) _Collections.firstOrNull(list2)) == null) {
                                                view = null;
                                            } else {
                                                view = null;
                                                StickerView.m8613e(stickerView, sticker, null, 2);
                                            }
                                            imageView.setImageDrawable(drawable);
                                            imageView.setOnClickListener(new NoticePopup4(layoutContainer, this, fragmentActivity));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(layoutContainer.getResources().getResourceName(i2)));
        }
        view = null;
        WeakReference<ViewGroup> weakReference = Alerter3.f14367a;
        if (weakReference != null && (viewGroup = weakReference.get()) != null) {
            new Handler(Looper.getMainLooper()).post(new Alerter2(viewGroup, alerter3));
        }
        ViewOnClickListenerC5272b viewOnClickListenerC5272b11 = alerter3.f14368b;
        View viewFindViewById = viewOnClickListenerC5272b11 != null ? viewOnClickListenerC5272b11.findViewById(C5419R.id.llAlertBackground) : view;
        if (viewFindViewById != null) {
            ViewCompat.setElevation(viewFindViewById, fragmentActivity.getResources().getDimension(C5419R.dimen.app_elevation));
        }
        return true;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }
}
