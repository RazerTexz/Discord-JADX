package p007b.p008a.p009a.p011a0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.application.Application;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.ModelStoreListing;
import com.discord.rlottie.RLottieImageView;
import com.discord.stores.StoreGifting;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.gifting.GiftStyle;
import com.discord.utilities.gifting.GiftStyle3;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewCoroutineScope;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.settings.premium.WidgetSettingsGifting;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import p000.ViewOnClickListenerC12383g;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p025i.WidgetAcceptGiftDialogBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p513e0.KClass;
import p507d0.p580t.Collections2;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.functions.Func2;

/* compiled from: WidgetGiftAcceptDialog.kt */
/* renamed from: b.a.a.a0.c, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGiftAcceptDialog extends AppDialog {

    /* renamed from: j */
    public static final /* synthetic */ KProperty[] f232j = {outline.m846d0(WidgetGiftAcceptDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAcceptGiftDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetGiftAcceptDialog.kt */
    /* renamed from: b.a.a.a0.c$a, reason: from kotlin metadata */
    public static final class Companion {

        /* compiled from: WidgetGiftAcceptDialog.kt */
        /* renamed from: b.a.a.a0.c$a$a, reason: collision with other inner class name */
        public static final class C13206a {

            /* renamed from: a */
            public final StoreGifting.GiftState f235a;

            /* renamed from: b */
            public final boolean f236b;

            public C13206a(StoreGifting.GiftState giftState, boolean z2) {
                Intrinsics3.checkNotNullParameter(giftState, "giftState");
                this.f235a = giftState;
                this.f236b = z2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C13206a)) {
                    return false;
                }
                C13206a c13206a = (C13206a) obj;
                return Intrinsics3.areEqual(this.f235a, c13206a.f235a) && this.f236b == c13206a.f236b;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                StoreGifting.GiftState giftState = this.f235a;
                int iHashCode = (giftState != null ? giftState.hashCode() : 0) * 31;
                boolean z2 = this.f236b;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("GiftUiState(giftState=");
                sbM833U.append(this.f235a);
                sbM833U.append(", reduceMotion=");
                return outline.m827O(sbM833U, this.f236b, ")");
            }
        }

        /* compiled from: WidgetGiftAcceptDialog.kt */
        /* renamed from: b.a.a.a0.c$a$b */
        public static final class b extends Lambda implements Function1<FragmentActivity, Boolean> {
            public final /* synthetic */ long $channelId;
            public final /* synthetic */ String $giftCode;
            public final /* synthetic */ String $source;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, String str2, long j) {
                super(1);
                this.$giftCode = str;
                this.$source = str2;
                this.$channelId = j;
            }

            @Override // kotlin.jvm.functions.Function1
            public Boolean invoke(FragmentActivity fragmentActivity) {
                FragmentActivity fragmentActivity2 = fragmentActivity;
                Intrinsics3.checkNotNullParameter(fragmentActivity2, "appActivity");
                StoreStream.INSTANCE.getAnalytics().trackOpenGiftAcceptModal(this.$giftCode, this.$source, this.$channelId);
                WidgetGiftAcceptDialog widgetGiftAcceptDialog = new WidgetGiftAcceptDialog();
                Bundle bundle = new Bundle();
                bundle.putString("ARG_GIFT_CODE", this.$giftCode);
                widgetGiftAcceptDialog.setArguments(bundle);
                FragmentManager supportFragmentManager = fragmentActivity2.getSupportFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
                widgetGiftAcceptDialog.show(supportFragmentManager, Reflection2.getOrCreateKotlinClass(WidgetGiftAcceptDialog.class).toString());
                return Boolean.TRUE;
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final void m107a(String str, String str2, long j) {
            Intrinsics3.checkNotNullParameter(str, "giftCode");
            Intrinsics3.checkNotNullParameter(str2, "source");
            if (BlockRussianPurchasesUtils.INSTANCE.getINSTANCE().showDialog()) {
                return;
            }
            Intrinsics3.checkNotNullParameter(str, "giftCode");
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("gift:" + str, null, 0L, 0, false, Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetSettingsGifting.class), Reflection2.getOrCreateKotlinClass(WidgetHome.class)}), 0L, false, 0L, new b(str, str2, j), 150, null));
        }
    }

    /* compiled from: WidgetGiftAcceptDialog.kt */
    /* renamed from: b.a.a.a0.c$b */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, WidgetAcceptGiftDialogBinding> {

        /* renamed from: j */
        public static final b f237j = new b();

        public b() {
            super(1, WidgetAcceptGiftDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAcceptGiftDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public WidgetAcceptGiftDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.accept_gift_body_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.accept_gift_body_container);
            if (linearLayout != null) {
                i = C5419R.id.accept_gift_body_image;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(C5419R.id.accept_gift_body_image);
                if (simpleDraweeView != null) {
                    i = C5419R.id.accept_gift_body_lottie;
                    RLottieImageView rLottieImageView = (RLottieImageView) view2.findViewById(C5419R.id.accept_gift_body_lottie);
                    if (rLottieImageView != null) {
                        i = C5419R.id.accept_gift_body_text;
                        TextView textView = (TextView) view2.findViewById(C5419R.id.accept_gift_body_text);
                        if (textView != null) {
                            i = C5419R.id.accept_gift_confirm;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.accept_gift_confirm);
                            if (materialButton != null) {
                                i = C5419R.id.accept_gift_disclaimer_container;
                                LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(C5419R.id.accept_gift_disclaimer_container);
                                if (linearLayout2 != null) {
                                    i = C5419R.id.accept_gift_disclaimer_text;
                                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view2.findViewById(C5419R.id.accept_gift_disclaimer_text);
                                    if (linkifiedTextView != null) {
                                        i = C5419R.id.accept_gift_flipper;
                                        AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(C5419R.id.accept_gift_flipper);
                                        if (appViewFlipper != null) {
                                            i = C5419R.id.accept_gift_header;
                                            TextView textView2 = (TextView) view2.findViewById(C5419R.id.accept_gift_header);
                                            if (textView2 != null) {
                                                i = C5419R.id.accept_gift_progress;
                                                ProgressBar progressBar = (ProgressBar) view2.findViewById(C5419R.id.accept_gift_progress);
                                                if (progressBar != null) {
                                                    return new WidgetAcceptGiftDialogBinding((LinearLayout) view2, linearLayout, simpleDraweeView, rLottieImageView, textView, materialButton, linearLayout2, linkifiedTextView, appViewFlipper, textView2, progressBar);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: WidgetGiftAcceptDialog.kt */
    @DebugMetadata(m10084c = "com.discord.dialogs.gifting.WidgetGiftAcceptDialog$configureUI$1$1", m10085f = "WidgetGiftAcceptDialog.kt", m10086l = {118}, m10087m = "invokeSuspend")
    /* renamed from: b.a.a.a0.c$c */
    public static final class c extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ RLottieImageView $this_apply;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(RLottieImageView rLottieImageView, Continuation continuation) {
            super(2, continuation);
            this.$this_apply = rLottieImageView;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new c(this.$this_apply, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics3.checkNotNullParameter(continuation2, "completion");
            return new c(this.$this_apply, continuation2).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                this.label = 1;
                if (C3404f.m4234P(200L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            this.$this_apply.m8449b();
            return Unit.f27425a;
        }
    }

    /* compiled from: WidgetGiftAcceptDialog.kt */
    /* renamed from: b.a.a.a0.c$d */
    public static final class d<T1, T2, R> implements Func2<StoreGifting.GiftState, Boolean, Companion.C13206a> {

        /* renamed from: j */
        public static final d f238j = new d();

        @Override // p658rx.functions.Func2
        public Companion.C13206a call(StoreGifting.GiftState giftState, Boolean bool) {
            StoreGifting.GiftState giftState2 = giftState;
            Boolean bool2 = bool;
            Intrinsics3.checkNotNullExpressionValue(giftState2, "giftState");
            Intrinsics3.checkNotNullExpressionValue(bool2, "reduceMotion");
            return new Companion.C13206a(giftState2, bool2.booleanValue());
        }
    }

    /* compiled from: WidgetGiftAcceptDialog.kt */
    /* renamed from: b.a.a.a0.c$e */
    public static final class e extends Lambda implements Function1<Companion.C13206a, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Companion.C13206a c13206a) {
            ModelSku sku;
            ModelSku sku2;
            String name;
            ModelSku sku3;
            Companion.C13206a c13206a2 = c13206a;
            Object obj = c13206a2.f235a;
            if (obj instanceof StoreGifting.GiftState.Loading) {
                WidgetGiftAcceptDialog widgetGiftAcceptDialog = WidgetGiftAcceptDialog.this;
                KProperty[] kPropertyArr = WidgetGiftAcceptDialog.f232j;
                AppViewFlipper appViewFlipper = widgetGiftAcceptDialog.m105h().f1060h;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.acceptGiftFlipper");
                appViewFlipper.setDisplayedChild(0);
            } else {
                if (obj instanceof StoreGifting.GiftState.Resolved) {
                    StoreGifting.GiftState.Resolved resolved = (StoreGifting.GiftState.Resolved) obj;
                    if (resolved.getGift().getRedeemed()) {
                        WidgetGiftAcceptDialog widgetGiftAcceptDialog2 = WidgetGiftAcceptDialog.this;
                        Intrinsics3.checkNotNullExpressionValue(c13206a2, "giftUiState");
                        KProperty[] kPropertyArr2 = WidgetGiftAcceptDialog.f232j;
                        Objects.requireNonNull(widgetGiftAcceptDialog2);
                        ModelGift gift = resolved.getGift();
                        widgetGiftAcceptDialog2.m104g(gift, c13206a2);
                        ModelStoreListing storeListing = gift.getStoreListing();
                        if (storeListing == null || (sku3 = storeListing.getSku()) == null || (name = sku3.getName()) == null) {
                            name = "";
                        }
                        CharSequence charSequenceM106i = widgetGiftAcceptDialog2.m106i(gift);
                        LinearLayout linearLayout = outline.m882v0(outline.m882v0(widgetGiftAcceptDialog2.m105h().f1061i, "binding.acceptGiftHeader", gift.isAnyNitroGift() ? FormatUtils.m219k(widgetGiftAcceptDialog2, C5419R.string.gift_confirmation_header_success_nitro, new Object[]{name}, null, 4) : FormatUtils.m219k(widgetGiftAcceptDialog2, C5419R.string.gift_confirmation_header_success, new Object[0], null, 4), widgetGiftAcceptDialog2).f1056d, "binding.acceptGiftBodyText", gift.isNitroClassicGift() ? FormatUtils.m219k(widgetGiftAcceptDialog2, C5419R.string.gift_confirmation_body_success_nitro_classic_mobile, new Object[]{charSequenceM106i}, null, 4) : gift.isNitroGift() ? FormatUtils.m219k(widgetGiftAcceptDialog2, C5419R.string.gift_confirmation_body_success_nitro_mobile, new Object[]{charSequenceM106i}, null, 4) : FormatUtils.m219k(widgetGiftAcceptDialog2, C5419R.string.gift_confirmation_body_success_mobile, new Object[]{name}, null, 4), widgetGiftAcceptDialog2).f1058f;
                        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.acceptGiftDisclaimerContainer");
                        linearLayout.setVisibility(8);
                        MaterialButton materialButton = widgetGiftAcceptDialog2.m105h().f1057e;
                        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.acceptGiftConfirm");
                        Context context = widgetGiftAcceptDialog2.getContext();
                        materialButton.setText(context != null ? context.getText(C5419R.string.gift_confirmation_button_success_mobile) : null);
                        widgetGiftAcceptDialog2.m105h().f1057e.setOnClickListener(new WidgetGiftAcceptDialog2(widgetGiftAcceptDialog2));
                    } else if (resolved.getGift().getMaxUses() == resolved.getGift().getUses()) {
                        WidgetGiftAcceptDialog widgetGiftAcceptDialog3 = WidgetGiftAcceptDialog.this;
                        Intrinsics3.checkNotNullExpressionValue(c13206a2, "giftUiState");
                        KProperty[] kPropertyArr3 = WidgetGiftAcceptDialog.f232j;
                        Objects.requireNonNull(widgetGiftAcceptDialog3);
                        widgetGiftAcceptDialog3.m104g(resolved.getGift(), c13206a2);
                        TextView textView = widgetGiftAcceptDialog3.m105h().f1061i;
                        Intrinsics3.checkNotNullExpressionValue(textView, "binding.acceptGiftHeader");
                        FormatUtils.m222n(textView, C5419R.string.gift_confirmation_header_fail, new Object[0], null, 4);
                        TextView textView2 = widgetGiftAcceptDialog3.m105h().f1056d;
                        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.acceptGiftBodyText");
                        FormatUtils.m222n(textView2, C5419R.string.gift_confirmation_body_claimed, new Object[0], null, 4);
                        LinearLayout linearLayout2 = widgetGiftAcceptDialog3.m105h().f1058f;
                        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.acceptGiftDisclaimerContainer");
                        linearLayout2.setVisibility(8);
                        MaterialButton materialButton2 = widgetGiftAcceptDialog3.m105h().f1057e;
                        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.acceptGiftConfirm");
                        FormatUtils.m222n(materialButton2, C5419R.string.gift_confirmation_button_fail, new Object[0], null, 4);
                        widgetGiftAcceptDialog3.m105h().f1057e.setOnClickListener(new WidgetGiftAcceptDialog3(widgetGiftAcceptDialog3));
                    } else {
                        WidgetGiftAcceptDialog widgetGiftAcceptDialog4 = WidgetGiftAcceptDialog.this;
                        Intrinsics3.checkNotNullExpressionValue(c13206a2, "giftUiState");
                        KProperty[] kPropertyArr4 = WidgetGiftAcceptDialog.f232j;
                        Objects.requireNonNull(widgetGiftAcceptDialog4);
                        ModelGift gift2 = ((StoreGifting.HasGift) obj).getGift();
                        widgetGiftAcceptDialog4.m104g(gift2, c13206a2);
                        ModelStoreListing storeListing2 = gift2.getStoreListing();
                        String name2 = (storeListing2 == null || (sku2 = storeListing2.getSku()) == null) ? null : sku2.getName();
                        LinearLayout linearLayout3 = outline.m882v0(outline.m882v0(widgetGiftAcceptDialog4.m105h().f1061i, "binding.acceptGiftHeader", gift2.isAnyNitroGift() ? FormatUtils.m219k(widgetGiftAcceptDialog4, C5419R.string.gift_confirmation_header_confirm_nitro, new Object[]{name2}, null, 4) : FormatUtils.m219k(widgetGiftAcceptDialog4, C5419R.string.gift_confirmation_header_confirm, new Object[0], null, 4), widgetGiftAcceptDialog4).f1056d, "binding.acceptGiftBodyText", gift2.isAnyNitroGift() ? FormatUtils.m219k(widgetGiftAcceptDialog4, C5419R.string.gift_confirmation_body_confirm_nitro, new Object[]{name2, widgetGiftAcceptDialog4.m106i(gift2)}, null, 4) : FormatUtils.m219k(widgetGiftAcceptDialog4, C5419R.string.gift_confirmation_body_confirm, new Object[]{name2}, null, 4), widgetGiftAcceptDialog4).f1058f;
                        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.acceptGiftDisclaimerContainer");
                        linearLayout3.setVisibility(gift2.isAnyNitroGift() ? 0 : 8);
                        MaterialButton materialButton3 = widgetGiftAcceptDialog4.m105h().f1057e;
                        Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.acceptGiftConfirm");
                        FormatUtils.m222n(materialButton3, C5419R.string.gift_confirmation_button_confirm_mobile, new Object[0], null, 4);
                        widgetGiftAcceptDialog4.m105h().f1057e.setOnClickListener(new WidgetGiftAcceptDialog4(gift2));
                    }
                } else if (obj instanceof StoreGifting.GiftState.Redeeming) {
                    WidgetGiftAcceptDialog widgetGiftAcceptDialog5 = WidgetGiftAcceptDialog.this;
                    Intrinsics3.checkNotNullExpressionValue(c13206a2, "giftUiState");
                    KProperty[] kPropertyArr5 = WidgetGiftAcceptDialog.f232j;
                    Objects.requireNonNull(widgetGiftAcceptDialog5);
                    ModelGift gift3 = ((StoreGifting.GiftState.Redeeming) obj).getGift();
                    widgetGiftAcceptDialog5.m104g(gift3, c13206a2);
                    ModelStoreListing storeListing3 = gift3.getStoreListing();
                    String name3 = (storeListing3 == null || (sku = storeListing3.getSku()) == null) ? null : sku.getName();
                    MaterialButton materialButton4 = widgetGiftAcceptDialog5.m105h().f1057e;
                    Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.acceptGiftConfirm");
                    materialButton4.setVisibility(8);
                    ProgressBar progressBar = widgetGiftAcceptDialog5.m105h().f1062j;
                    Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.acceptGiftProgress");
                    progressBar.setVisibility(0);
                    LinearLayout linearLayout4 = outline.m882v0(outline.m882v0(widgetGiftAcceptDialog5.m105h().f1061i, "binding.acceptGiftHeader", gift3.isAnyNitroGift() ? FormatUtils.m219k(widgetGiftAcceptDialog5, C5419R.string.gift_confirmation_header_confirm_nitro, new Object[]{name3}, null, 4) : FormatUtils.m219k(widgetGiftAcceptDialog5, C5419R.string.gift_confirmation_header_confirm, new Object[0], null, 4), widgetGiftAcceptDialog5).f1056d, "binding.acceptGiftBodyText", gift3.isAnyNitroGift() ? FormatUtils.m219k(widgetGiftAcceptDialog5, C5419R.string.gift_confirmation_body_confirm_nitro, new Object[]{name3, widgetGiftAcceptDialog5.m106i(gift3)}, null, 4) : FormatUtils.m219k(widgetGiftAcceptDialog5, C5419R.string.gift_confirmation_body_confirm, new Object[]{name3}, null, 4), widgetGiftAcceptDialog5).f1058f;
                    Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.acceptGiftDisclaimerContainer");
                    linearLayout4.setVisibility(gift3.isAnyNitroGift() ? 0 : 8);
                } else if (obj instanceof StoreGifting.GiftState.RedeemedFailed) {
                    WidgetGiftAcceptDialog widgetGiftAcceptDialog6 = WidgetGiftAcceptDialog.this;
                    StoreGifting.GiftState.RedeemedFailed redeemedFailed = (StoreGifting.GiftState.RedeemedFailed) obj;
                    Intrinsics3.checkNotNullExpressionValue(c13206a2, "giftUiState");
                    KProperty[] kPropertyArr6 = WidgetGiftAcceptDialog.f232j;
                    Objects.requireNonNull(widgetGiftAcceptDialog6);
                    widgetGiftAcceptDialog6.m104g(redeemedFailed.getGift(), c13206a2);
                    TextView textView3 = widgetGiftAcceptDialog6.m105h().f1061i;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.acceptGiftHeader");
                    textView3.setText(FormatUtils.m219k(widgetGiftAcceptDialog6, C5419R.string.gift_confirmation_header_fail, new Object[0], null, 4));
                    TextView textView4 = widgetGiftAcceptDialog6.m105h().f1056d;
                    Intrinsics3.checkNotNullExpressionValue(textView4, "binding.acceptGiftBodyText");
                    FormatUtils.m222n(textView4, C5419R.string.gift_confirmation_body_unknown_error, new Object[0], null, 4);
                    if (redeemedFailed.getCanRetry()) {
                        TextView textView5 = widgetGiftAcceptDialog6.m105h().f1056d;
                        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.acceptGiftBodyText");
                        FormatUtils.m222n(textView5, C5419R.string.gift_confirmation_body_unknown_error, new Object[0], null, 4);
                        MaterialButton materialButton5 = widgetGiftAcceptDialog6.m105h().f1057e;
                        Intrinsics3.checkNotNullExpressionValue(materialButton5, "binding.acceptGiftConfirm");
                        Context context2 = widgetGiftAcceptDialog6.getContext();
                        materialButton5.setText(context2 != null ? context2.getText(C5419R.string.retry) : null);
                        widgetGiftAcceptDialog6.m105h().f1057e.setOnClickListener(new ViewOnClickListenerC12383g(0, redeemedFailed));
                    } else {
                        Integer errorCode = redeemedFailed.getErrorCode();
                        if (errorCode != null && errorCode.intValue() == 50054) {
                            widgetGiftAcceptDialog6.m105h().f1056d.setText(C5419R.string.gift_confirmation_body_self_gift_no_payment);
                        } else if (errorCode != null && errorCode.intValue() == 100024) {
                            widgetGiftAcceptDialog6.m105h().f1056d.setText(C5419R.string.gift_confirmation_body_error_nitro_upgrade_downgrade);
                        } else if (errorCode != null && errorCode.intValue() == 100022) {
                            widgetGiftAcceptDialog6.m105h().f1056d.setText(C5419R.string.gift_confirmation_body_error_subscription_managed);
                        } else if (errorCode != null && errorCode.intValue() == 100025) {
                            widgetGiftAcceptDialog6.m105h().f1056d.setText(C5419R.string.gift_confirmation_body_error_invoice_open);
                        }
                        MaterialButton materialButton6 = widgetGiftAcceptDialog6.m105h().f1057e;
                        Intrinsics3.checkNotNullExpressionValue(materialButton6, "binding.acceptGiftConfirm");
                        Context context3 = widgetGiftAcceptDialog6.getContext();
                        materialButton6.setText(context3 != null ? context3.getText(C5419R.string.gift_confirmation_button_fail) : null);
                        widgetGiftAcceptDialog6.m105h().f1057e.setOnClickListener(new ViewOnClickListenerC12383g(1, widgetGiftAcceptDialog6));
                    }
                } else if ((obj instanceof StoreGifting.GiftState.Invalid) || (obj instanceof StoreGifting.GiftState.LoadFailed) || (obj instanceof StoreGifting.GiftState.Revoking)) {
                    WidgetGiftAcceptDialog.this.dismiss();
                }
            }
            return Unit.f27425a;
        }
    }

    /* compiled from: WidgetGiftAcceptDialog.kt */
    /* renamed from: b.a.a.a0.c$f */
    public static final class f extends Lambda implements Function1<Error, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetGiftAcceptDialog.this.dismiss();
            return Unit.f27425a;
        }
    }

    public WidgetGiftAcceptDialog() {
        super(C5419R.layout.widget_accept_gift_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.f237j, null, 2, null);
    }

    /* renamed from: g */
    public final void m104g(ModelGift gift, Companion.C13206a uiState) {
        ModelSku sku;
        Application application;
        String icon;
        ModelSku sku2;
        AppViewFlipper appViewFlipper = m105h().f1060h;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.acceptGiftFlipper");
        appViewFlipper.setDisplayedChild(1);
        String applicationIcon$default = null;
        if (gift.isAnyNitroGift()) {
            GiftStyle customStyle = GiftStyle3.getCustomStyle(gift);
            if (customStyle != null) {
                RLottieImageView rLottieImageView = m105h().f1055c;
                Intrinsics3.checkNotNullExpressionValue(rLottieImageView, "binding.acceptGiftBodyLottie");
                rLottieImageView.setVisibility(0);
                SimpleDraweeView simpleDraweeView = m105h().f1054b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.acceptGiftBodyImage");
                simpleDraweeView.setVisibility(8);
                RLottieImageView rLottieImageView2 = m105h().f1055c;
                if (uiState.f236b) {
                    rLottieImageView2.setImageResource(customStyle.getStaticRes());
                } else {
                    int animRes = customStyle.getAnimRes();
                    RLottieImageView rLottieImageView3 = m105h().f1055c;
                    Intrinsics3.checkNotNullExpressionValue(rLottieImageView3, "binding.acceptGiftBodyLottie");
                    int iDpToPixels = DimenUtils.dpToPixels(rLottieImageView3.getLayoutParams().width);
                    RLottieImageView rLottieImageView4 = m105h().f1055c;
                    Intrinsics3.checkNotNullExpressionValue(rLottieImageView4, "binding.acceptGiftBodyLottie");
                    rLottieImageView2.m8450c(animRes, iDpToPixels, DimenUtils.dpToPixels(rLottieImageView4.getLayoutParams().height));
                    CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(rLottieImageView2);
                    if (coroutineScope != null) {
                        C3404f.m4211H0(coroutineScope, null, null, new c(rLottieImageView2, null), 3, null);
                    }
                }
                Intrinsics3.checkNotNullExpressionValue(rLottieImageView2, "binding.acceptGiftBodyLo…  }\n          }\n        }");
            } else {
                MGImages mGImages = MGImages.INSTANCE;
                SimpleDraweeView simpleDraweeView2 = m105h().f1054b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.acceptGiftBodyImage");
                MGImages.setImage$default(mGImages, simpleDraweeView2, PremiumUtils.INSTANCE.getNitroGiftIcon(gift), (MGImages.ChangeDetector) null, 4, (Object) null);
            }
        } else {
            ModelStoreListing storeListing = gift.getStoreListing();
            if (storeListing != null && (sku = storeListing.getSku()) != null && (application = sku.getApplication()) != null && (icon = application.getIcon()) != null) {
                ModelStoreListing storeListing2 = gift.getStoreListing();
                applicationIcon$default = IconUtils.getApplicationIcon$default((storeListing2 == null || (sku2 = storeListing2.getSku()) == null) ? 0L : sku2.getApplicationId(), icon, 0, 4, (Object) null);
            }
            m105h().f1054b.setImageURI(applicationIcon$default);
        }
        MaterialButton materialButton = m105h().f1057e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.acceptGiftConfirm");
        materialButton.setVisibility(0);
        ProgressBar progressBar = m105h().f1062j;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.acceptGiftProgress");
        progressBar.setVisibility(8);
    }

    /* renamed from: h */
    public final WidgetAcceptGiftDialogBinding m105h() {
        return (WidgetAcceptGiftDialogBinding) this.binding.getValue((Fragment) this, f232j[0]);
    }

    /* renamed from: i */
    public final CharSequence m106i(ModelGift gift) {
        int i;
        SubscriptionPlan subscriptionPlan = gift.getSubscriptionPlan();
        if (subscriptionPlan == null) {
            return "";
        }
        int iOrdinal = subscriptionPlan.getInterval().ordinal();
        if (iOrdinal == 0) {
            i = C5419R.plurals.gift_confirmation_nitro_time_frame_months_time;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = C5419R.plurals.gift_confirmation_nitro_time_frame_years_time;
        }
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(contextRequireContext, i, subscriptionPlan.getIntervalCount(), Integer.valueOf(subscriptionPlan.getIntervalCount()));
        int iOrdinal2 = subscriptionPlan.getInterval().ordinal();
        if (iOrdinal2 == 0) {
            return FormatUtils.m219k(this, C5419R.string.gift_confirmation_nitro_time_frame_months, new Object[]{i18nPluralString}, null, 4);
        }
        if (iOrdinal2 == 1) {
            return FormatUtils.m219k(this, C5419R.string.gift_confirmation_nitro_time_frame_years, new Object[]{i18nPluralString}, null, 4);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("ARG_GIFT_CODE")) != null) {
            Companion companion = INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(string, "it");
            Objects.requireNonNull(companion);
            Intrinsics3.checkNotNullParameter(string, "giftCode");
            String str = "gift:" + string;
            if (str != null) {
                StoreStream.INSTANCE.getNotices().markDialogSeen(str);
            }
        }
        super.onDestroy();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("ARG_GIFT_CODE") : null;
        if (string == null) {
            dismiss();
            return;
        }
        LinkifiedTextView linkifiedTextView = m105h().f1059g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.acceptGiftDisclaimerText");
        FormatUtils.m222n(linkifiedTextView, C5419R.string.gift_confirmation_body_confirm_nitro_disclaimer, new Object[]{AppHelpDesk.f507a.m149a(360055386693L, null)}, null, 4);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableM11076j = Observable.m11076j(companion.getGifting().requestGift(string), companion.getAccessibility().observeReducedMotionEnabled(), d.f238j);
        Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…iftState, reduceMotion) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11076j, this, null, 2, null), WidgetGiftAcceptDialog.class, (Context) null, (Function1) null, new f(), (Function0) null, (Function0) null, new e(), 54, (Object) null);
    }
}
