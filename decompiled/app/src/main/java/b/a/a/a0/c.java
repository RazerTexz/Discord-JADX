package b.a.a.a0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.i.m4;
import com.discord.R;
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
import com.discord.utilities.gifting.GiftStyleKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.settings.premium.WidgetSettingsGifting;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.l;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import defpackage.g;
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
import rx.Observable;
import rx.functions.Func2;

/* compiled from: WidgetGiftAcceptDialog.kt */
/* loaded from: classes.dex */
public final class c extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(c.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAcceptGiftDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetGiftAcceptDialog.kt */
    /* renamed from: b.a.a.a0.c$a, reason: from kotlin metadata */
    public static final class Companion {

        /* compiled from: WidgetGiftAcceptDialog.kt */
        /* renamed from: b.a.a.a0.c$a$a, reason: collision with other inner class name */
        public static final class C0015a {
            public final StoreGifting.GiftState a;

            /* renamed from: b, reason: collision with root package name */
            public final boolean f44b;

            public C0015a(StoreGifting.GiftState giftState, boolean z2) {
                m.checkNotNullParameter(giftState, "giftState");
                this.a = giftState;
                this.f44b = z2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0015a)) {
                    return false;
                }
                C0015a c0015a = (C0015a) obj;
                return m.areEqual(this.a, c0015a.a) && this.f44b == c0015a.f44b;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                StoreGifting.GiftState giftState = this.a;
                int iHashCode = (giftState != null ? giftState.hashCode() : 0) * 31;
                boolean z2 = this.f44b;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("GiftUiState(giftState=");
                sbU.append(this.a);
                sbU.append(", reduceMotion=");
                return b.d.b.a.a.O(sbU, this.f44b, ")");
            }
        }

        /* compiled from: WidgetGiftAcceptDialog.kt */
        /* renamed from: b.a.a.a0.c$a$b */
        public static final class b extends o implements Function1<FragmentActivity, Boolean> {
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
                m.checkNotNullParameter(fragmentActivity2, "appActivity");
                StoreStream.INSTANCE.getAnalytics().trackOpenGiftAcceptModal(this.$giftCode, this.$source, this.$channelId);
                c cVar = new c();
                Bundle bundle = new Bundle();
                bundle.putString("ARG_GIFT_CODE", this.$giftCode);
                cVar.setArguments(bundle);
                FragmentManager supportFragmentManager = fragmentActivity2.getSupportFragmentManager();
                m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
                cVar.show(supportFragmentManager, a0.getOrCreateKotlinClass(c.class).toString());
                return Boolean.TRUE;
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void a(String str, String str2, long j) {
            m.checkNotNullParameter(str, "giftCode");
            m.checkNotNullParameter(str2, "source");
            if (BlockRussianPurchasesUtils.INSTANCE.getINSTANCE().showDialog()) {
                return;
            }
            m.checkNotNullParameter(str, "giftCode");
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("gift:" + str, null, 0L, 0, false, n.listOf((Object[]) new d0.e0.c[]{a0.getOrCreateKotlinClass(WidgetSettingsGifting.class), a0.getOrCreateKotlinClass(WidgetHome.class)}), 0L, false, 0L, new b(str, str2, j), 150, null));
        }
    }

    /* compiled from: WidgetGiftAcceptDialog.kt */
    public static final /* synthetic */ class b extends k implements Function1<View, m4> {
        public static final b j = new b();

        public b() {
            super(1, m4.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAcceptGiftDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public m4 invoke(View view) {
            View view2 = view;
            m.checkNotNullParameter(view2, "p1");
            int i = R.id.accept_gift_body_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.accept_gift_body_container);
            if (linearLayout != null) {
                i = R.id.accept_gift_body_image;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(R.id.accept_gift_body_image);
                if (simpleDraweeView != null) {
                    i = R.id.accept_gift_body_lottie;
                    RLottieImageView rLottieImageView = (RLottieImageView) view2.findViewById(R.id.accept_gift_body_lottie);
                    if (rLottieImageView != null) {
                        i = R.id.accept_gift_body_text;
                        TextView textView = (TextView) view2.findViewById(R.id.accept_gift_body_text);
                        if (textView != null) {
                            i = R.id.accept_gift_confirm;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.accept_gift_confirm);
                            if (materialButton != null) {
                                i = R.id.accept_gift_disclaimer_container;
                                LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.accept_gift_disclaimer_container);
                                if (linearLayout2 != null) {
                                    i = R.id.accept_gift_disclaimer_text;
                                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view2.findViewById(R.id.accept_gift_disclaimer_text);
                                    if (linkifiedTextView != null) {
                                        i = R.id.accept_gift_flipper;
                                        AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(R.id.accept_gift_flipper);
                                        if (appViewFlipper != null) {
                                            i = R.id.accept_gift_header;
                                            TextView textView2 = (TextView) view2.findViewById(R.id.accept_gift_header);
                                            if (textView2 != null) {
                                                i = R.id.accept_gift_progress;
                                                ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.accept_gift_progress);
                                                if (progressBar != null) {
                                                    return new m4((LinearLayout) view2, linearLayout, simpleDraweeView, rLottieImageView, textView, materialButton, linearLayout2, linkifiedTextView, appViewFlipper, textView2, progressBar);
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
    @d0.w.i.a.e(c = "com.discord.dialogs.gifting.WidgetGiftAcceptDialog$configureUI$1$1", f = "WidgetGiftAcceptDialog.kt", l = {118}, m = "invokeSuspend")
    /* renamed from: b.a.a.a0.c$c, reason: collision with other inner class name */
    public static final class C0016c extends d0.w.i.a.k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ RLottieImageView $this_apply;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0016c(RLottieImageView rLottieImageView, Continuation continuation) {
            super(2, continuation);
            this.$this_apply = rLottieImageView;
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            return new C0016c(this.$this_apply, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            m.checkNotNullParameter(continuation2, "completion");
            return new C0016c(this.$this_apply, continuation2).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                l.throwOnFailure(obj);
                this.label = 1;
                if (b.i.a.f.e.o.f.P(200L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            this.$this_apply.b();
            return Unit.a;
        }
    }

    /* compiled from: WidgetGiftAcceptDialog.kt */
    public static final class d<T1, T2, R> implements Func2<StoreGifting.GiftState, Boolean, Companion.C0015a> {
        public static final d j = new d();

        @Override // rx.functions.Func2
        public Companion.C0015a call(StoreGifting.GiftState giftState, Boolean bool) {
            StoreGifting.GiftState giftState2 = giftState;
            Boolean bool2 = bool;
            m.checkNotNullExpressionValue(giftState2, "giftState");
            m.checkNotNullExpressionValue(bool2, "reduceMotion");
            return new Companion.C0015a(giftState2, bool2.booleanValue());
        }
    }

    /* compiled from: WidgetGiftAcceptDialog.kt */
    public static final class e extends o implements Function1<Companion.C0015a, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Companion.C0015a c0015a) {
            ModelSku sku;
            ModelSku sku2;
            String name;
            ModelSku sku3;
            Companion.C0015a c0015a2 = c0015a;
            Object obj = c0015a2.a;
            if (obj instanceof StoreGifting.GiftState.Loading) {
                c cVar = c.this;
                KProperty[] kPropertyArr = c.j;
                AppViewFlipper appViewFlipper = cVar.h().h;
                m.checkNotNullExpressionValue(appViewFlipper, "binding.acceptGiftFlipper");
                appViewFlipper.setDisplayedChild(0);
            } else {
                if (obj instanceof StoreGifting.GiftState.Resolved) {
                    StoreGifting.GiftState.Resolved resolved = (StoreGifting.GiftState.Resolved) obj;
                    if (resolved.getGift().getRedeemed()) {
                        c cVar2 = c.this;
                        m.checkNotNullExpressionValue(c0015a2, "giftUiState");
                        KProperty[] kPropertyArr2 = c.j;
                        Objects.requireNonNull(cVar2);
                        ModelGift gift = resolved.getGift();
                        cVar2.g(gift, c0015a2);
                        ModelStoreListing storeListing = gift.getStoreListing();
                        if (storeListing == null || (sku3 = storeListing.getSku()) == null || (name = sku3.getName()) == null) {
                            name = "";
                        }
                        CharSequence charSequenceI = cVar2.i(gift);
                        LinearLayout linearLayout = b.d.b.a.a.v0(b.d.b.a.a.v0(cVar2.h().i, "binding.acceptGiftHeader", gift.isAnyNitroGift() ? b.a.k.b.k(cVar2, R.string.gift_confirmation_header_success_nitro, new Object[]{name}, null, 4) : b.a.k.b.k(cVar2, R.string.gift_confirmation_header_success, new Object[0], null, 4), cVar2).d, "binding.acceptGiftBodyText", gift.isNitroClassicGift() ? b.a.k.b.k(cVar2, R.string.gift_confirmation_body_success_nitro_classic_mobile, new Object[]{charSequenceI}, null, 4) : gift.isNitroGift() ? b.a.k.b.k(cVar2, R.string.gift_confirmation_body_success_nitro_mobile, new Object[]{charSequenceI}, null, 4) : b.a.k.b.k(cVar2, R.string.gift_confirmation_body_success_mobile, new Object[]{name}, null, 4), cVar2).f;
                        m.checkNotNullExpressionValue(linearLayout, "binding.acceptGiftDisclaimerContainer");
                        linearLayout.setVisibility(8);
                        MaterialButton materialButton = cVar2.h().e;
                        m.checkNotNullExpressionValue(materialButton, "binding.acceptGiftConfirm");
                        Context context = cVar2.getContext();
                        materialButton.setText(context != null ? context.getText(R.string.gift_confirmation_button_success_mobile) : null);
                        cVar2.h().e.setOnClickListener(new b.a.a.a0.d(cVar2));
                    } else if (resolved.getGift().getMaxUses() == resolved.getGift().getUses()) {
                        c cVar3 = c.this;
                        m.checkNotNullExpressionValue(c0015a2, "giftUiState");
                        KProperty[] kPropertyArr3 = c.j;
                        Objects.requireNonNull(cVar3);
                        cVar3.g(resolved.getGift(), c0015a2);
                        TextView textView = cVar3.h().i;
                        m.checkNotNullExpressionValue(textView, "binding.acceptGiftHeader");
                        b.a.k.b.n(textView, R.string.gift_confirmation_header_fail, new Object[0], null, 4);
                        TextView textView2 = cVar3.h().d;
                        m.checkNotNullExpressionValue(textView2, "binding.acceptGiftBodyText");
                        b.a.k.b.n(textView2, R.string.gift_confirmation_body_claimed, new Object[0], null, 4);
                        LinearLayout linearLayout2 = cVar3.h().f;
                        m.checkNotNullExpressionValue(linearLayout2, "binding.acceptGiftDisclaimerContainer");
                        linearLayout2.setVisibility(8);
                        MaterialButton materialButton2 = cVar3.h().e;
                        m.checkNotNullExpressionValue(materialButton2, "binding.acceptGiftConfirm");
                        b.a.k.b.n(materialButton2, R.string.gift_confirmation_button_fail, new Object[0], null, 4);
                        cVar3.h().e.setOnClickListener(new b.a.a.a0.e(cVar3));
                    } else {
                        c cVar4 = c.this;
                        m.checkNotNullExpressionValue(c0015a2, "giftUiState");
                        KProperty[] kPropertyArr4 = c.j;
                        Objects.requireNonNull(cVar4);
                        ModelGift gift2 = ((StoreGifting.HasGift) obj).getGift();
                        cVar4.g(gift2, c0015a2);
                        ModelStoreListing storeListing2 = gift2.getStoreListing();
                        String name2 = (storeListing2 == null || (sku2 = storeListing2.getSku()) == null) ? null : sku2.getName();
                        LinearLayout linearLayout3 = b.d.b.a.a.v0(b.d.b.a.a.v0(cVar4.h().i, "binding.acceptGiftHeader", gift2.isAnyNitroGift() ? b.a.k.b.k(cVar4, R.string.gift_confirmation_header_confirm_nitro, new Object[]{name2}, null, 4) : b.a.k.b.k(cVar4, R.string.gift_confirmation_header_confirm, new Object[0], null, 4), cVar4).d, "binding.acceptGiftBodyText", gift2.isAnyNitroGift() ? b.a.k.b.k(cVar4, R.string.gift_confirmation_body_confirm_nitro, new Object[]{name2, cVar4.i(gift2)}, null, 4) : b.a.k.b.k(cVar4, R.string.gift_confirmation_body_confirm, new Object[]{name2}, null, 4), cVar4).f;
                        m.checkNotNullExpressionValue(linearLayout3, "binding.acceptGiftDisclaimerContainer");
                        linearLayout3.setVisibility(gift2.isAnyNitroGift() ? 0 : 8);
                        MaterialButton materialButton3 = cVar4.h().e;
                        m.checkNotNullExpressionValue(materialButton3, "binding.acceptGiftConfirm");
                        b.a.k.b.n(materialButton3, R.string.gift_confirmation_button_confirm_mobile, new Object[0], null, 4);
                        cVar4.h().e.setOnClickListener(new b.a.a.a0.f(gift2));
                    }
                } else if (obj instanceof StoreGifting.GiftState.Redeeming) {
                    c cVar5 = c.this;
                    m.checkNotNullExpressionValue(c0015a2, "giftUiState");
                    KProperty[] kPropertyArr5 = c.j;
                    Objects.requireNonNull(cVar5);
                    ModelGift gift3 = ((StoreGifting.GiftState.Redeeming) obj).getGift();
                    cVar5.g(gift3, c0015a2);
                    ModelStoreListing storeListing3 = gift3.getStoreListing();
                    String name3 = (storeListing3 == null || (sku = storeListing3.getSku()) == null) ? null : sku.getName();
                    MaterialButton materialButton4 = cVar5.h().e;
                    m.checkNotNullExpressionValue(materialButton4, "binding.acceptGiftConfirm");
                    materialButton4.setVisibility(8);
                    ProgressBar progressBar = cVar5.h().j;
                    m.checkNotNullExpressionValue(progressBar, "binding.acceptGiftProgress");
                    progressBar.setVisibility(0);
                    LinearLayout linearLayout4 = b.d.b.a.a.v0(b.d.b.a.a.v0(cVar5.h().i, "binding.acceptGiftHeader", gift3.isAnyNitroGift() ? b.a.k.b.k(cVar5, R.string.gift_confirmation_header_confirm_nitro, new Object[]{name3}, null, 4) : b.a.k.b.k(cVar5, R.string.gift_confirmation_header_confirm, new Object[0], null, 4), cVar5).d, "binding.acceptGiftBodyText", gift3.isAnyNitroGift() ? b.a.k.b.k(cVar5, R.string.gift_confirmation_body_confirm_nitro, new Object[]{name3, cVar5.i(gift3)}, null, 4) : b.a.k.b.k(cVar5, R.string.gift_confirmation_body_confirm, new Object[]{name3}, null, 4), cVar5).f;
                    m.checkNotNullExpressionValue(linearLayout4, "binding.acceptGiftDisclaimerContainer");
                    linearLayout4.setVisibility(gift3.isAnyNitroGift() ? 0 : 8);
                } else if (obj instanceof StoreGifting.GiftState.RedeemedFailed) {
                    c cVar6 = c.this;
                    StoreGifting.GiftState.RedeemedFailed redeemedFailed = (StoreGifting.GiftState.RedeemedFailed) obj;
                    m.checkNotNullExpressionValue(c0015a2, "giftUiState");
                    KProperty[] kPropertyArr6 = c.j;
                    Objects.requireNonNull(cVar6);
                    cVar6.g(redeemedFailed.getGift(), c0015a2);
                    TextView textView3 = cVar6.h().i;
                    m.checkNotNullExpressionValue(textView3, "binding.acceptGiftHeader");
                    textView3.setText(b.a.k.b.k(cVar6, R.string.gift_confirmation_header_fail, new Object[0], null, 4));
                    TextView textView4 = cVar6.h().d;
                    m.checkNotNullExpressionValue(textView4, "binding.acceptGiftBodyText");
                    b.a.k.b.n(textView4, R.string.gift_confirmation_body_unknown_error, new Object[0], null, 4);
                    if (redeemedFailed.getCanRetry()) {
                        TextView textView5 = cVar6.h().d;
                        m.checkNotNullExpressionValue(textView5, "binding.acceptGiftBodyText");
                        b.a.k.b.n(textView5, R.string.gift_confirmation_body_unknown_error, new Object[0], null, 4);
                        MaterialButton materialButton5 = cVar6.h().e;
                        m.checkNotNullExpressionValue(materialButton5, "binding.acceptGiftConfirm");
                        Context context2 = cVar6.getContext();
                        materialButton5.setText(context2 != null ? context2.getText(R.string.retry) : null);
                        cVar6.h().e.setOnClickListener(new g(0, redeemedFailed));
                    } else {
                        Integer errorCode = redeemedFailed.getErrorCode();
                        if (errorCode != null && errorCode.intValue() == 50054) {
                            cVar6.h().d.setText(R.string.gift_confirmation_body_self_gift_no_payment);
                        } else if (errorCode != null && errorCode.intValue() == 100024) {
                            cVar6.h().d.setText(R.string.gift_confirmation_body_error_nitro_upgrade_downgrade);
                        } else if (errorCode != null && errorCode.intValue() == 100022) {
                            cVar6.h().d.setText(R.string.gift_confirmation_body_error_subscription_managed);
                        } else if (errorCode != null && errorCode.intValue() == 100025) {
                            cVar6.h().d.setText(R.string.gift_confirmation_body_error_invoice_open);
                        }
                        MaterialButton materialButton6 = cVar6.h().e;
                        m.checkNotNullExpressionValue(materialButton6, "binding.acceptGiftConfirm");
                        Context context3 = cVar6.getContext();
                        materialButton6.setText(context3 != null ? context3.getText(R.string.gift_confirmation_button_fail) : null);
                        cVar6.h().e.setOnClickListener(new g(1, cVar6));
                    }
                } else if ((obj instanceof StoreGifting.GiftState.Invalid) || (obj instanceof StoreGifting.GiftState.LoadFailed) || (obj instanceof StoreGifting.GiftState.Revoking)) {
                    c.this.dismiss();
                }
            }
            return Unit.a;
        }
    }

    /* compiled from: WidgetGiftAcceptDialog.kt */
    public static final class f extends o implements Function1<Error, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Error error) {
            m.checkNotNullParameter(error, "it");
            c.this.dismiss();
            return Unit.a;
        }
    }

    public c() {
        super(R.layout.widget_accept_gift_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.j, null, 2, null);
    }

    public final void g(ModelGift gift, Companion.C0015a uiState) {
        ModelSku sku;
        Application application;
        String icon;
        ModelSku sku2;
        AppViewFlipper appViewFlipper = h().h;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.acceptGiftFlipper");
        appViewFlipper.setDisplayedChild(1);
        String applicationIcon$default = null;
        if (gift.isAnyNitroGift()) {
            GiftStyle customStyle = GiftStyleKt.getCustomStyle(gift);
            if (customStyle != null) {
                RLottieImageView rLottieImageView = h().c;
                m.checkNotNullExpressionValue(rLottieImageView, "binding.acceptGiftBodyLottie");
                rLottieImageView.setVisibility(0);
                SimpleDraweeView simpleDraweeView = h().f161b;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.acceptGiftBodyImage");
                simpleDraweeView.setVisibility(8);
                RLottieImageView rLottieImageView2 = h().c;
                if (uiState.f44b) {
                    rLottieImageView2.setImageResource(customStyle.getStaticRes());
                } else {
                    int animRes = customStyle.getAnimRes();
                    RLottieImageView rLottieImageView3 = h().c;
                    m.checkNotNullExpressionValue(rLottieImageView3, "binding.acceptGiftBodyLottie");
                    int iDpToPixels = DimenUtils.dpToPixels(rLottieImageView3.getLayoutParams().width);
                    RLottieImageView rLottieImageView4 = h().c;
                    m.checkNotNullExpressionValue(rLottieImageView4, "binding.acceptGiftBodyLottie");
                    rLottieImageView2.c(animRes, iDpToPixels, DimenUtils.dpToPixels(rLottieImageView4.getLayoutParams().height));
                    CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(rLottieImageView2);
                    if (coroutineScope != null) {
                        b.i.a.f.e.o.f.H0(coroutineScope, null, null, new C0016c(rLottieImageView2, null), 3, null);
                    }
                }
                m.checkNotNullExpressionValue(rLottieImageView2, "binding.acceptGiftBodyLo…  }\n          }\n        }");
            } else {
                MGImages mGImages = MGImages.INSTANCE;
                SimpleDraweeView simpleDraweeView2 = h().f161b;
                m.checkNotNullExpressionValue(simpleDraweeView2, "binding.acceptGiftBodyImage");
                MGImages.setImage$default(mGImages, simpleDraweeView2, PremiumUtils.INSTANCE.getNitroGiftIcon(gift), (MGImages.ChangeDetector) null, 4, (Object) null);
            }
        } else {
            ModelStoreListing storeListing = gift.getStoreListing();
            if (storeListing != null && (sku = storeListing.getSku()) != null && (application = sku.getApplication()) != null && (icon = application.getIcon()) != null) {
                ModelStoreListing storeListing2 = gift.getStoreListing();
                applicationIcon$default = IconUtils.getApplicationIcon$default((storeListing2 == null || (sku2 = storeListing2.getSku()) == null) ? 0L : sku2.getApplicationId(), icon, 0, 4, (Object) null);
            }
            h().f161b.setImageURI(applicationIcon$default);
        }
        MaterialButton materialButton = h().e;
        m.checkNotNullExpressionValue(materialButton, "binding.acceptGiftConfirm");
        materialButton.setVisibility(0);
        ProgressBar progressBar = h().j;
        m.checkNotNullExpressionValue(progressBar, "binding.acceptGiftProgress");
        progressBar.setVisibility(8);
    }

    public final m4 h() {
        return (m4) this.binding.getValue((Fragment) this, j[0]);
    }

    public final CharSequence i(ModelGift gift) {
        int i;
        SubscriptionPlan subscriptionPlan = gift.getSubscriptionPlan();
        if (subscriptionPlan == null) {
            return "";
        }
        int iOrdinal = subscriptionPlan.getInterval().ordinal();
        if (iOrdinal == 0) {
            i = R.plurals.gift_confirmation_nitro_time_frame_months_time;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.plurals.gift_confirmation_nitro_time_frame_years_time;
        }
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(contextRequireContext, i, subscriptionPlan.getIntervalCount(), Integer.valueOf(subscriptionPlan.getIntervalCount()));
        int iOrdinal2 = subscriptionPlan.getInterval().ordinal();
        if (iOrdinal2 == 0) {
            return b.a.k.b.k(this, R.string.gift_confirmation_nitro_time_frame_months, new Object[]{i18nPluralString}, null, 4);
        }
        if (iOrdinal2 == 1) {
            return b.a.k.b.k(this, R.string.gift_confirmation_nitro_time_frame_years, new Object[]{i18nPluralString}, null, 4);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("ARG_GIFT_CODE")) != null) {
            Companion companion = INSTANCE;
            m.checkNotNullExpressionValue(string, "it");
            Objects.requireNonNull(companion);
            m.checkNotNullParameter(string, "giftCode");
            String str = "gift:" + string;
            if (str != null) {
                StoreStream.INSTANCE.getNotices().markDialogSeen(str);
            }
        }
        super.onDestroy();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("ARG_GIFT_CODE") : null;
        if (string == null) {
            dismiss();
            return;
        }
        LinkifiedTextView linkifiedTextView = h().g;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.acceptGiftDisclaimerText");
        b.a.k.b.n(linkifiedTextView, R.string.gift_confirmation_body_confirm_nitro_disclaimer, new Object[]{b.a.d.f.a.a(360055386693L, null)}, null, 4);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableJ = Observable.j(companion.getGifting().requestGift(string), companion.getAccessibility().observeReducedMotionEnabled(), d.j);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…iftState, reduceMotion) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableJ, this, null, 2, null), c.class, (Context) null, (Function1) null, new f(), (Function0) null, (Function0) null, new e(), 54, (Object) null);
    }
}
