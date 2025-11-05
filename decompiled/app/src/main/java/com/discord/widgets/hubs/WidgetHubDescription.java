package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetHubDescriptionBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.Loading;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet;
import com.google.android.material.textfield.TextInputEditText;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetHubDescription.kt */
/* loaded from: classes2.dex */
public final class WidgetHubDescription extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHubDescription.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDescriptionBinding;", 0)};

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubDescription.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Success<? extends DirectoryEntryGuild>, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends DirectoryEntryGuild> success) {
            invoke2((Success<DirectoryEntryGuild>) success);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<DirectoryEntryGuild> success) {
            m.checkNotNullParameter(success, "it");
            StoreStream.INSTANCE.getDirectories().addServerToDirectory(WidgetHubDescription.this.getArgs().getChannelId(), success.invoke());
            WidgetHubDescription widgetHubDescription = WidgetHubDescription.this;
            widgetHubDescription.hideKeyboard(widgetHubDescription.getView());
            FragmentActivity activity = WidgetHubDescription.this.getActivity();
            if (activity != null) {
                activity.setResult(-1, d.g2(new DescriptionResult(success.invoke().getGuild().getId(), WidgetHubDescription.this.getArgs().getHubName())));
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetHubDescription.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {

        /* compiled from: WidgetHubDescription.kt */
        /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$onViewBound$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04181 extends o implements Function1<Integer, Unit> {
            public C04181() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.a;
            }

            public final void invoke(int i) {
                WidgetHubDescription.this.getViewModel().setCategory(i);
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetRadioSelectorBottomSheet.Companion companion = WidgetRadioSelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = WidgetHubDescription.this.getChildFragmentManager();
            m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            companion.show(childFragmentManager, WidgetHubDescription.access$getSelectorArgs$p(WidgetHubDescription.this), new C04181());
        }
    }

    /* compiled from: WidgetHubDescription.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<HubDescriptionState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HubDescriptionState hubDescriptionState) {
            invoke2(hubDescriptionState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HubDescriptionState hubDescriptionState) {
            m.checkNotNullParameter(hubDescriptionState, "viewState");
            WidgetHubDescription.access$configureUI(WidgetHubDescription.this, hubDescriptionState);
        }
    }

    public WidgetHubDescription() {
        super(R.layout.widget_hub_description);
        this.args = g.lazy(new WidgetHubDescription$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubDescription$binding$2.INSTANCE, null, 2, null);
        WidgetHubDescription$viewModel$2 widgetHubDescription$viewModel$2 = new WidgetHubDescription$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetHubDescriptionViewModel.class), new WidgetHubDescription$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetHubDescription$viewModel$2));
        this.validationManager = g.lazy(new WidgetHubDescription$validationManager$2(this));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetHubDescription$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetHubDescription widgetHubDescription, HubDescriptionState hubDescriptionState) {
        widgetHubDescription.configureUI(hubDescriptionState);
    }

    public static final /* synthetic */ RadioSelectorItems access$getSelectorArgs$p(WidgetHubDescription widgetHubDescription) {
        return widgetHubDescription.getSelectorArgs();
    }

    public static final /* synthetic */ void access$maybeAddServer(WidgetHubDescription widgetHubDescription) {
        widgetHubDescription.maybeAddServer();
    }

    private final void configureUI(HubDescriptionState state) {
        int i;
        String string;
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            getBinding().h.setTitle(b.k(this, getArgs().isEditing() ? R.string.hub_entry_update_description_title : R.string.hub_customize_existing_guild_title, new Object[]{state.getGuildName()}, null, 4));
            LoadingButton loadingButton = getBinding().f2470b;
            loadingButton.setOnClickListener(new WidgetHubDescription$configureUI$$inlined$apply$lambda$1(this, state));
            loadingButton.setIsLoading(state.getAddServerAsync() instanceof Loading);
            loadingButton.setText(getString(getArgs().isEditing() ? R.string.save : R.string.hub_add_server_cta));
            TextView textView = getBinding().c;
            DirectoryEntryCategory selectedCategory = state.getSelectedCategory();
            if (selectedCategory != null) {
                selectedCategory.getTitleRes();
                i = R.attr.colorTextNormal;
            } else {
                i = R.attr.colorTextMuted;
            }
            textView.setTextColor(ColorCompat.getThemedColor(context, i));
            TextView textView2 = getBinding().c;
            m.checkNotNullExpressionValue(textView2, "binding.category");
            DirectoryEntryCategory selectedCategory2 = state.getSelectedCategory();
            if (selectedCategory2 == null || (string = selectedCategory2.getTitle(context)) == null) {
                string = getString(R.string.categories);
            }
            textView2.setText(string);
            RestCallStateKt.handleResponse$default(state.getAddServerAsync(), context, null, null, new AnonymousClass3(), 6, null);
        }
    }

    private final RadioSelectorItems getSelectorArgs() {
        String string = requireContext().getString(R.string.categories);
        m.checkNotNullExpressionValue(string, "requireContext().getString(R.string.categories)");
        return new RadioSelectorItems(string, (List) getViewModel().withViewState(new WidgetHubDescription$selectorArgs$1(this)));
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void maybeAddServer() {
        if (getValidationManager().validate(true)) {
            WidgetHubDescriptionViewModel viewModel = getViewModel();
            long channelId = getArgs().getChannelId();
            long guildId = getArgs().getGuildId();
            TextInputEditText textInputEditText = getBinding().f;
            m.checkNotNullExpressionValue(textInputEditText, "binding.description");
            viewModel.addServer(channelId, guildId, String.valueOf(textInputEditText.getText()));
        }
    }

    public final HubDescriptionArgs getArgs() {
        return (HubDescriptionArgs) this.args.getValue();
    }

    public final WidgetHubDescriptionBinding getBinding() {
        return (WidgetHubDescriptionBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final WidgetHubDescriptionViewModel getViewModel() {
        return (WidgetHubDescriptionViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f.setText(getArgs().getDescription());
        getBinding().e.setOnClickListener(new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null)), WidgetHubDescription.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
