package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildInviteShareEmptySuggestionsBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareEmptySuggestions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildInviteShareEmptySuggestions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareEmptySuggestionsBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$initBottomSheet$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
    public static final class C86851 extends Lambda implements Function0<Unit> {
        public C86851() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).setState(5);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$initBottomSheetBehavior$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
    public static final class C86861 extends BottomSheetBehavior.BottomSheetCallback {
        public C86861() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View bottomSheet, float slideOffset) {
            Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View bottomSheet, int newState) {
            Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 5) {
                WidgetGuildInviteShareEmptySuggestions.access$getViewModel$p(WidgetGuildInviteShareEmptySuggestions.this).refreshUi();
            }
            ViewExtensions.fadeBy$default(WidgetGuildInviteShareEmptySuggestions.access$getBinding$p(WidgetGuildInviteShareEmptySuggestions.this).f16826b, newState != 5, 0L, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
    public static final class C86871<R> implements Func0<Boolean> {
        public final /* synthetic */ boolean $isNuxFlow;

        public C86871(boolean z2) {
            this.$isNuxFlow = z2;
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            if (WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).getState() != 5) {
                WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).setState(5);
                return Boolean.TRUE;
            }
            if (!this.$isNuxFlow) {
                return Boolean.FALSE;
            }
            AppScreen2.m155c(WidgetGuildInviteShareEmptySuggestions.this.requireContext(), false, null, 6);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
    public static final class ViewOnClickListenerC86882 implements View.OnClickListener {
        public ViewOnClickListenerC86882() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).setState(5);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
    public static final class C86911 extends Lambda implements Function1<WidgetGuildInviteShareViewModel.ViewState.Loaded, Unit> {
        public C86911() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "viewState");
            WidgetGuildInviteShareEmptySuggestions.access$updateUi(WidgetGuildInviteShareEmptySuggestions.this, loaded);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$updateUi$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
    public static final class ViewOnClickListenerC86921 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public ViewOnClickListenerC86921(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildInviteUiHelper.copyLinkClick(outline.m885x(view, "it", "it.context"), this.$invite, WidgetGuildInviteShareEmptySuggestions.this.getMostRecentIntent());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$updateUi$2 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
    public static final class ViewOnClickListenerC86932 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public ViewOnClickListenerC86932(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite modelInvite = this.$invite;
            if (modelInvite != null) {
                GuildInviteUiHelper.shareLinkClick(WidgetGuildInviteShareEmptySuggestions.this.getContext(), modelInvite);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$updateUi$3 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
    public static final class ViewOnClickListenerC86943 implements View.OnClickListener {
        public ViewOnClickListenerC86943() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).setState(3);
        }
    }

    public WidgetGuildInviteShareEmptySuggestions() {
        super(C5419R.layout.widget_guild_invite_share_empty_suggestions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildInviteShareEmptySuggestions2.INSTANCE, null, 2, null);
        WidgetGuildInviteShareEmptySuggestions4 widgetGuildInviteShareEmptySuggestions4 = new WidgetGuildInviteShareEmptySuggestions4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildInviteShareViewModel.class), new C8684xdbf0d98a(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildInviteShareEmptySuggestions4));
        this.guildId = LazyJVM.lazy(new WidgetGuildInviteShareEmptySuggestions3(this));
    }

    public static final /* synthetic */ WidgetGuildInviteShareEmptySuggestionsBinding access$getBinding$p(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions) {
        return widgetGuildInviteShareEmptySuggestions.getBinding();
    }

    public static final /* synthetic */ BottomSheetBehavior access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions) {
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior = widgetGuildInviteShareEmptySuggestions.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        return bottomSheetBehavior;
    }

    public static final /* synthetic */ WidgetGuildInviteShareViewModel access$getViewModel$p(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions) {
        return widgetGuildInviteShareEmptySuggestions.getViewModel();
    }

    public static final /* synthetic */ void access$setBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions, BottomSheetBehavior bottomSheetBehavior) {
        widgetGuildInviteShareEmptySuggestions.bottomSheetBehavior = bottomSheetBehavior;
    }

    public static final /* synthetic */ void access$updateUi(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions, WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
        widgetGuildInviteShareEmptySuggestions.updateUi(loaded);
    }

    private final WidgetGuildInviteShareEmptySuggestionsBinding getBinding() {
        return (WidgetGuildInviteShareEmptySuggestionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getHoursExpirationString(int hours, CharSequence maxUses) {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        CharSequence quantityString = StringResourceUtils.getQuantityString(resources, requireContext(), C5419R.plurals.duration_hours_hours, hours, Integer.valueOf(hours));
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        return FormatUtils.m217i(resources2, C5419R.string.invite_settings_expired_description, new Object[]{quantityString, maxUses}, null, 4);
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(getResources(), BuildConfig.HOST_INVITE);
    }

    private final WidgetGuildInviteShareViewModel getViewModel() {
        return (WidgetGuildInviteShareViewModel) this.viewModel.getValue();
    }

    private final void initBottomSheet() {
        getBinding().f16831g.setOnGenerateLinkListener(new C86851());
        getBinding().f16831g.setViewModel(getViewModel());
    }

    private final void initBottomSheetBehavior(BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior) {
        bottomSheetBehavior.setState(5);
        bottomSheetBehavior.addBottomSheetCallback(new C86861());
    }

    private final void updateUi(WidgetGuildInviteShareViewModel.ViewState.Loaded viewState) {
        CharSequence quantityString;
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        getBinding().f16831g.configureUi(widgetInviteModel);
        ModelInvite invite = widgetInviteModel.getInvite();
        TextView textView = getBinding().f16827c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildInviteEmptySuggestionsInviteLink");
        textView.setText(getInviteLink(invite));
        getBinding().f16827c.setOnClickListener(new ViewOnClickListenerC86921(invite));
        getBinding().f16828d.setOnClickListener(new ViewOnClickListenerC86932(invite));
        getBinding().f16829e.setOnClickListener(new ViewOnClickListenerC86943());
        ModelInvite.Settings settings = widgetInviteModel.getSettings();
        if (settings != null) {
            if (settings.getMaxUses() == 0) {
                quantityString = getResources().getString(C5419R.string.max_uses_description_unlimited_uses);
                Intrinsics3.checkNotNullExpressionValue(quantityString, "resources.getString(R.st…scription_unlimited_uses)");
            } else {
                Resources resources = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                quantityString = StringResourceUtils.getQuantityString(resources, requireContext(), C5419R.plurals.max_uses_description_mobile_maxUses, settings.getMaxUses(), Integer.valueOf(settings.getMaxUses()));
            }
            int maxAge = widgetInviteModel.getSettings().getMaxAge();
            if (maxAge == 0) {
                String str = getResources().getString(C5419R.string.max_age_never_description_mobile) + ", " + quantityString;
                Intrinsics3.checkNotNullExpressionValue(str, "StringBuilder()\n        …              .toString()");
                TextView textView2 = getBinding().f16830f;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView2.setText(str);
                return;
            }
            if (maxAge == 1800) {
                Resources resources2 = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
                CharSequence quantityString2 = StringResourceUtils.getQuantityString(resources2, requireContext(), C5419R.plurals.duration_minutes_minutes, 30, 30);
                TextView textView3 = getBinding().f16830f;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                Resources resources3 = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
                textView3.setText(FormatUtils.m217i(resources3, C5419R.string.invite_settings_expired_description, new Object[]{quantityString2, quantityString}, null, 4));
                return;
            }
            if (maxAge == 3600) {
                TextView textView4 = getBinding().f16830f;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView4.setText(getHoursExpirationString(1, quantityString));
                return;
            }
            if (maxAge == 21600) {
                TextView textView5 = getBinding().f16830f;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView5.setText(getHoursExpirationString(6, quantityString));
                return;
            }
            if (maxAge == 43200) {
                TextView textView6 = getBinding().f16830f;
                Intrinsics3.checkNotNullExpressionValue(textView6, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView6.setText(getHoursExpirationString(12, quantityString));
                return;
            }
            if (maxAge == 86400) {
                Resources resources4 = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources4, "resources");
                CharSequence quantityString3 = StringResourceUtils.getQuantityString(resources4, requireContext(), C5419R.plurals.duration_days_days, 1, 1);
                TextView textView7 = getBinding().f16830f;
                Intrinsics3.checkNotNullExpressionValue(textView7, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                Resources resources5 = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources5, "resources");
                textView7.setText(FormatUtils.m217i(resources5, C5419R.string.invite_settings_expired_description, new Object[]{quantityString3, quantityString}, null, 4));
                return;
            }
            if (maxAge != 604800) {
                return;
            }
            Resources resources6 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources6, "resources");
            CharSequence quantityString4 = StringResourceUtils.getQuantityString(resources6, requireContext(), C5419R.plurals.duration_days_days, 7, 7);
            TextView textView8 = getBinding().f16830f;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
            Resources resources7 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources7, "resources");
            textView8.setText(FormatUtils.m217i(resources7, C5419R.string.invite_settings_expired_description, new Object[]{quantityString4, quantityString}, null, 4));
        }
    }

    public final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", 0L) <= 0) {
            requireActivity().finish();
            return;
        }
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        if (longExtra != 0) {
            getViewModel().selectChannel(longExtra);
        }
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(WidgetGuildInviteShare.INTENT_IS_NUX_FLOW, false);
        setActionBarDisplayHomeAsUpEnabled(true, booleanExtra ? Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(requireContext(), C5419R.attr.ic_close_24dp, 0, 2, (Object) null)) : null, booleanExtra ? Integer.valueOf(C5419R.string.close) : null);
        AppFragment.setOnBackPressed$default(this, new C86871(booleanExtra), 0, 2, null);
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().f16831g);
        Intrinsics3.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…nviteSettingsBottomSheet)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        initBottomSheetBehavior(bottomSheetBehaviorFrom);
        initBottomSheet();
        getBinding().f16826b.setOnClickListener(new ViewOnClickListenerC86882());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetGuildInviteShareViewModel.ViewState> observableM11085K = getViewModel().observeViewState().m11085K();
        Intrinsics3.checkNotNullExpressionValue(observableM11085K, "viewModel.observeViewSta…  .onBackpressureBuffer()");
        Observable<R> observableM11083G = observableM11085K.m11118y(C8689x831ee7f6.INSTANCE).m11083G(C8690x831ee7f7.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11083G, this, null, 2, null), WidgetGuildInviteShareEmptySuggestions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C86911(), 62, (Object) null);
    }
}
