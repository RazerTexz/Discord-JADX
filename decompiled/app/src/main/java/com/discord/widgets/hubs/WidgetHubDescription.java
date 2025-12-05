package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetHubDescriptionBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet;
import com.google.android.material.textfield.TextInputEditText;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetHubDescription.kt */
/* loaded from: classes2.dex */
public final class WidgetHubDescription extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetHubDescription.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDescriptionBinding;", 0)};

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubDescription.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$configureUI$3 */
    public static final class C90093 extends Lambda implements Function1<RestCallState6<? extends DirectoryEntryGuild>, Unit> {
        public C90093() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends DirectoryEntryGuild> restCallState6) {
            invoke2((RestCallState6<DirectoryEntryGuild>) restCallState6);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<DirectoryEntryGuild> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            StoreStream.INSTANCE.getDirectories().addServerToDirectory(WidgetHubDescription.this.getArgs().getChannelId(), restCallState6.invoke());
            WidgetHubDescription widgetHubDescription = WidgetHubDescription.this;
            widgetHubDescription.hideKeyboard(widgetHubDescription.getView());
            FragmentActivity activity = WidgetHubDescription.this.getActivity();
            if (activity != null) {
                activity.setResult(-1, AnimatableValueParser.m522g2(new WidgetHubDescription2(restCallState6.invoke().getGuild().getId(), WidgetHubDescription.this.getArgs().getHubName())));
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetHubDescription.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$onViewBound$1 */
    public static final class ViewOnClickListenerC90101 implements View.OnClickListener {

        /* compiled from: WidgetHubDescription.kt */
        /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$onViewBound$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f27425a;
            }

            public final void invoke(int i) {
                WidgetHubDescription.this.getViewModel().setCategory(i);
            }
        }

        public ViewOnClickListenerC90101() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetRadioSelectorBottomSheet.Companion companion = WidgetRadioSelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = WidgetHubDescription.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            companion.show(childFragmentManager, WidgetHubDescription.access$getSelectorArgs$p(WidgetHubDescription.this), new AnonymousClass1());
        }
    }

    /* compiled from: WidgetHubDescription.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$onViewBoundOrOnResume$1 */
    public static final class C90111 extends Lambda implements Function1<WidgetHubDescriptionViewModel3, Unit> {
        public C90111() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
            invoke2(widgetHubDescriptionViewModel3);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubDescriptionViewModel3, "viewState");
            WidgetHubDescription.access$configureUI(WidgetHubDescription.this, widgetHubDescriptionViewModel3);
        }
    }

    public WidgetHubDescription() {
        super(C5419R.layout.widget_hub_description);
        this.args = LazyJVM.lazy(new WidgetHubDescription$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubDescription3.INSTANCE, null, 2, null);
        WidgetHubDescription8 widgetHubDescription8 = new WidgetHubDescription8(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubDescriptionViewModel.class), new WidgetHubDescription$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubDescription8));
        this.validationManager = LazyJVM.lazy(new WidgetHubDescription7(this));
        this.loggingConfig = new AppLogger2(false, null, new WidgetHubDescription5(this), 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetHubDescription widgetHubDescription, WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
        widgetHubDescription.configureUI(widgetHubDescriptionViewModel3);
    }

    public static final /* synthetic */ WidgetRadioSelectorBottomSheet3 access$getSelectorArgs$p(WidgetHubDescription widgetHubDescription) {
        return widgetHubDescription.getSelectorArgs();
    }

    public static final /* synthetic */ void access$maybeAddServer(WidgetHubDescription widgetHubDescription) {
        widgetHubDescription.maybeAddServer();
    }

    private final void configureUI(WidgetHubDescriptionViewModel3 state) {
        int i;
        String string;
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            getBinding().f17161h.setTitle(FormatUtils.m219k(this, getArgs().isEditing() ? C5419R.string.hub_entry_update_description_title : C5419R.string.hub_customize_existing_guild_title, new Object[]{state.getGuildName()}, null, 4));
            LoadingButton loadingButton = getBinding().f17155b;
            loadingButton.setOnClickListener(new WidgetHubDescription4(this, state));
            loadingButton.setIsLoading(state.getAddServerAsync() instanceof RestCallState4);
            loadingButton.setText(getString(getArgs().isEditing() ? C5419R.string.save : C5419R.string.hub_add_server_cta));
            TextView textView = getBinding().f17156c;
            DirectoryEntryCategory selectedCategory = state.getSelectedCategory();
            if (selectedCategory != null) {
                selectedCategory.getTitleRes();
                i = C5419R.attr.colorTextNormal;
            } else {
                i = C5419R.attr.colorTextMuted;
            }
            textView.setTextColor(ColorCompat.getThemedColor(context, i));
            TextView textView2 = getBinding().f17156c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.category");
            DirectoryEntryCategory selectedCategory2 = state.getSelectedCategory();
            if (selectedCategory2 == null || (string = selectedCategory2.getTitle(context)) == null) {
                string = getString(C5419R.string.categories);
            }
            textView2.setText(string);
            RestCallState5.handleResponse$default(state.getAddServerAsync(), context, null, null, new C90093(), 6, null);
        }
    }

    private final WidgetRadioSelectorBottomSheet3 getSelectorArgs() {
        String string = requireContext().getString(C5419R.string.categories);
        Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getString(R.string.categories)");
        return new WidgetRadioSelectorBottomSheet3(string, (List) getViewModel().withViewState(new WidgetHubDescription6(this)));
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void maybeAddServer() {
        if (getValidationManager().validate(true)) {
            WidgetHubDescriptionViewModel viewModel = getViewModel();
            long channelId = getArgs().getChannelId();
            long guildId = getArgs().getGuildId();
            TextInputEditText textInputEditText = getBinding().f17159f;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.description");
            viewModel.addServer(channelId, guildId, String.valueOf(textInputEditText.getText()));
        }
    }

    public final WidgetHubDescriptionViewModel2 getArgs() {
        return (WidgetHubDescriptionViewModel2) this.args.getValue();
    }

    public final WidgetHubDescriptionBinding getBinding() {
        return (WidgetHubDescriptionBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final WidgetHubDescriptionViewModel getViewModel() {
        return (WidgetHubDescriptionViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f17159f.setText(getArgs().getDescription());
        getBinding().f17158e.setOnClickListener(new ViewOnClickListenerC90101());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null)), WidgetHubDescription.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C90111(), 62, (Object) null);
    }
}
