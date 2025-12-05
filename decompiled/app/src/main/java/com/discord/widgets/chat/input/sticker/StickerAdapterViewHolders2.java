package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.discord.C5419R;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppComponent;
import com.discord.databinding.StickerPickerStickerItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rlottie.RLottieImageView;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* compiled from: StickerAdapterViewHolders.kt */
/* renamed from: com.discord.widgets.chat.input.sticker.StickerViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class StickerAdapterViewHolders2 extends MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> {
    private final AppComponent appComponent;
    private final StickerPickerStickerItemBinding binding;
    private final BehaviorSubject<Boolean> recyclerScrollingWithinThresholdSubject;
    private Subscription scrollingSpeedSubscription;
    private final int type;

    /* compiled from: StickerAdapterViewHolders.kt */
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerViewHolder$configureSticker$1 */
    public static final class ViewOnClickListenerC78971 implements View.OnClickListener {
        public final /* synthetic */ MGRecyclerDataPayload $data;

        public ViewOnClickListenerC78971(MGRecyclerDataPayload mGRecyclerDataPayload) {
            this.$data = mGRecyclerDataPayload;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StickerAdapterViewHolders2.access$getAdapter$p(StickerAdapterViewHolders2.this).getOnStickerItemSelected().invoke(this.$data);
            try {
                StickerAdapterViewHolders2.access$getBinding$p(StickerAdapterViewHolders2.this).f15276b.performHapticFeedback(3);
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: StickerAdapterViewHolders.kt */
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerViewHolder$onConfigure$1 */
    public static final class C78981 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ MGRecyclerDataPayload $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C78981(MGRecyclerDataPayload mGRecyclerDataPayload) {
            super(1);
            this.$data = mGRecyclerDataPayload;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "scrollingWithinThreshold");
            if (bool.booleanValue()) {
                StickerAdapterViewHolders2.access$configureSticker(StickerAdapterViewHolders2.this, this.$data);
                Subscription subscriptionAccess$getScrollingSpeedSubscription$p = StickerAdapterViewHolders2.access$getScrollingSpeedSubscription$p(StickerAdapterViewHolders2.this);
                if (subscriptionAccess$getScrollingSpeedSubscription$p != null) {
                    subscriptionAccess$getScrollingSpeedSubscription$p.unsubscribe();
                }
                StickerAdapterViewHolders2.access$setScrollingSpeedSubscription$p(StickerAdapterViewHolders2.this, null);
            }
        }
    }

    /* compiled from: StickerAdapterViewHolders.kt */
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerViewHolder$onConfigure$2 */
    public static final class C78992 extends Lambda implements Function1<Subscription, Unit> {
        public C78992() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StickerAdapterViewHolders2.access$setScrollingSpeedSubscription$p(StickerAdapterViewHolders2.this, subscription);
        }
    }

    public /* synthetic */ StickerAdapterViewHolders2(int i, WidgetStickerAdapter widgetStickerAdapter, BehaviorSubject behaviorSubject, AppComponent appComponent, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, widgetStickerAdapter, (i2 & 4) != 0 ? null : behaviorSubject, appComponent);
    }

    public static final /* synthetic */ void access$configureSticker(StickerAdapterViewHolders2 stickerAdapterViewHolders2, MGRecyclerDataPayload mGRecyclerDataPayload) {
        stickerAdapterViewHolders2.configureSticker(mGRecyclerDataPayload);
    }

    public static final /* synthetic */ WidgetStickerAdapter access$getAdapter$p(StickerAdapterViewHolders2 stickerAdapterViewHolders2) {
        return (WidgetStickerAdapter) stickerAdapterViewHolders2.adapter;
    }

    public static final /* synthetic */ StickerPickerStickerItemBinding access$getBinding$p(StickerAdapterViewHolders2 stickerAdapterViewHolders2) {
        return stickerAdapterViewHolders2.binding;
    }

    public static final /* synthetic */ Subscription access$getScrollingSpeedSubscription$p(StickerAdapterViewHolders2 stickerAdapterViewHolders2) {
        return stickerAdapterViewHolders2.scrollingSpeedSubscription;
    }

    public static final /* synthetic */ void access$setScrollingSpeedSubscription$p(StickerAdapterViewHolders2 stickerAdapterViewHolders2, Subscription subscription) {
        stickerAdapterViewHolders2.scrollingSpeedSubscription = subscription;
    }

    private final void configureSticker(MGRecyclerDataPayload data) {
        Sticker sticker;
        StickerAdapterItems3 stickerAdapterItems3 = (StickerAdapterItems3) (!(data instanceof StickerAdapterItems3) ? null : data);
        if (stickerAdapterItems3 == null || (sticker = stickerAdapterItems3.getSticker()) == null) {
            return;
        }
        this.binding.f15276b.m8616d(sticker, 0);
        StickerView stickerView = this.binding.f15276b;
        Intrinsics3.checkNotNullExpressionValue(stickerView, "binding.stickerPickerSticker");
        stickerView.setAlpha(((StickerAdapterItems3) data).getSendability() == StickerUtils.StickerSendability.SENDABLE ? 1.0f : 0.25f);
        this.binding.f15276b.setOnClickListener(new ViewOnClickListenerC78971(data));
    }

    public final void cancelLoading() {
        StickerView stickerView = this.binding.f15276b;
        Job job = stickerView.apngLoadingJob;
        if (job != null) {
            C3404f.m4343t(job, null, 1, null);
        }
        stickerView.binding.f1178c.clearAnimation();
        Subscription subscription = this.scrollingSpeedSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.scrollingSpeedSubscription = null;
    }

    public final AppComponent getAppComponent() {
        return this.appComponent;
    }

    public final BehaviorSubject<Boolean> getRecyclerScrollingWithinThresholdSubject() {
        return this.recyclerScrollingWithinThresholdSubject;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.binding.f15276b.getCom.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String();
    }

    public final int getType() {
        return this.type;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerAdapterViewHolders2(int i, WidgetStickerAdapter widgetStickerAdapter, BehaviorSubject<Boolean> behaviorSubject, AppComponent appComponent) {
        super(C5419R.layout.sticker_picker_sticker_item, widgetStickerAdapter);
        Intrinsics3.checkNotNullParameter(widgetStickerAdapter, "adapter");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        this.type = i;
        this.recyclerScrollingWithinThresholdSubject = behaviorSubject;
        this.appComponent = appComponent;
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(C5419R.id.sticker_picker_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.sticker_picker_sticker)));
        }
        StickerPickerStickerItemBinding stickerPickerStickerItemBinding = new StickerPickerStickerItemBinding((FrameLayout) view, stickerView);
        Intrinsics3.checkNotNullExpressionValue(stickerPickerStickerItemBinding, "StickerPickerStickerItemBinding.bind(itemView)");
        this.binding = stickerPickerStickerItemBinding;
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (this.recyclerScrollingWithinThresholdSubject == null) {
            configureSticker(data);
            return;
        }
        StickerView stickerView = this.binding.f15276b;
        RLottieImageView rLottieImageView = stickerView.binding.f1178c;
        Intrinsics3.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
        rLottieImageView.setVisibility(8);
        SimpleDraweeView simpleDraweeView = stickerView.binding.f1177b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
        simpleDraweeView.setVisibility(8);
        stickerView.binding.f1177b.setImageDrawable(null);
        ImageView imageView = stickerView.binding.f1179d;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
        imageView.setVisibility(0);
        Observable<Boolean> observableM11112r = this.recyclerScrollingWithinThresholdSubject.m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "recyclerScrollingWithinT…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11112r, this.appComponent, null, 2, null), StickerAdapterViewHolders2.class, (Context) null, new C78992(), (Function1) null, (Function0) null, (Function0) null, new C78981(data), 58, (Object) null);
    }
}
